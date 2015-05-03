package org.simbiosis.ui.login.client.login;

import org.simbiosis.ui.login.client.Base64Utils;
import org.simbiosis.ui.login.client.json.JsonServerResponse;
import org.simbiosis.ui.login.client.json.SimpleSessionJso;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginForm extends Composite {

	private static LoginFormUiBinder uiBinder = GWT
			.create(LoginFormUiBinder.class);

	interface LoginFormUiBinder extends UiBinder<Widget, LoginForm> {
	}

	@UiField
	TextBox userName;
	@UiField
	TextBox password;
	@UiField
	Button loginSubmit;
	@UiField
	HorizontalPanel messageHolder;

	Label message = new Label();
	HorizontalPanel loadingPanel = new HorizontalPanel();

	public LoginForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		userName.getElement().setPropertyString("placeholder", "Nama pengguna");
		password.getElement().setPropertyString("placeholder", "Kata kunci");
		//
		message.setStyleName("login-errormessage");
		//
		HTMLPanel symbol = new HTMLPanel(
				"<i class=\"fa fa-spinner fa-fw fa-spin\" />");
		symbol.setStyleName("login-loadingsymbol");
		Label loadLabel = new Label("Loading...");
		loadLabel.setStyleName("login-loadingtext");
		loadingPanel.add(symbol);
		loadingPanel.add(loadLabel);
	}

	private void loadSalt() {
		String url = Window.Location.getProtocol() + "//"
				+ Window.Location.getHost() + "/systemapi/session/salt";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						login(response.getText());
					} else {
						Window.alert("Received HTTP status code other than 200 : "
								+ response.getStatusText());
					}
				}
			});
		} catch (RequestException e) {
			// Couldn't connect to server
			Window.alert(e.getMessage());
		}

	}

	private void loginError() {
		hideLoading();
		showMessage("Sistem login gagal");
	}

	private void loginFailed() {
		hideLoading();
		showMessage("Nama pengguna / kunci salah");
	}

	private void login(String salt) {
		String url = Window.Location.getProtocol() + "//"
				+ Window.Location.getHost() + "/systemuiapi/session/login";
		String passwordSalt = salt + password.getText();
		String param = "userName=" + userName.getText() + "&password=" + salt
				+ ":" + Base64Utils.toBase64(passwordSalt);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
		builder.setHeader("Content-type", "application/x-www-form-urlencoded");
		try {
			builder.sendRequest(param, new RequestCallback() {

				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						SimpleSessionJso session = JsonServerResponse
								.getSessionJso(response.getText());
						if (session.getName().isEmpty()) {
							loginFailed();
						} else {
							onLoginSuccess(session);
						}
					} else {
						loginError();
					}
				}
			});
		} catch (RequestException e) {
			// Couldn't connect to server
			Window.alert(e.getMessage());
		}
	}

	@UiHandler("loginSubmit")
	public void onLogin(ClickEvent event) {
		showLoading();
		//
		loadSalt();
	}

	private void onLoginSuccess(SimpleSessionJso session) {
		hideLoading();
		//
		Window.Location.replace(session.getRedirect());
	}

	private void showMessage(String text) {
		messageHolder.clear();
		messageHolder.add(message);
		message.setText(text);
	}

	private void showLoading() {
		messageHolder.clear();
		messageHolder.add(loadingPanel);
	}

	private void hideLoading() {
		messageHolder.clear();
	}
}
