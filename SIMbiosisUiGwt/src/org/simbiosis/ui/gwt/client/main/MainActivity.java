package org.simbiosis.ui.gwt.client.main;

import org.simbiosis.ui.gwt.client.main.IMain.Activity;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MainActivity extends Activity {

	Main myPlace;
	SIMbiosisClientFactory appFactory;

	public MainActivity(Main myPlace, SIMbiosisClientFactory appFactory) {
		super();
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		IMain myForm = appFactory.getMainForm();
		myForm.setActivity(this);
	}

	@Override
	public void logout() {
		String url = Window.Location.getProtocol() + "//"
				+ Window.Location.getHost() + "/systemapi/session/logout/"
				+ getSession().replace("/", "%2F");
		;
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						Cookies.removeCookie(getCookies(), "/");
						Window.Location.replace("/login");
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

	@Override
	public void goTo(Place place) {
		appFactory.getPlaceController().goTo(place);
	}

	@Override
	public void goTo(String place) {
		History.newItem(place);
	}

}
