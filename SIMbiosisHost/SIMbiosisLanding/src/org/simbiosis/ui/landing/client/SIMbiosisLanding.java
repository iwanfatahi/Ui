package org.simbiosis.ui.landing.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SIMbiosisLanding implements EntryPoint {

	public void showLoginForm() {
		Window.Location.replace(Window.Location.getPath() + "login");
	}

	public void onModuleLoad() {
		String session = Cookies.getCookie("simbiosis");
		if (session != null && !session.isEmpty()) {
			//
			//
			String url = Window.Location.getProtocol()+"//"+ Window.Location.getHost()
					+ "/systemuiapi/session/isvalid/" + session.replace("/", "%2F");
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
			try {
				builder.sendRequest(null, new RequestCallback() {
					public void onError(Request request, Throwable e) {
						Window.alert(e.getMessage());
					}

					public void onResponseReceived(Request request,
							Response response) {
						if (200 == response.getStatusCode()) {
							if (response.getText().equalsIgnoreCase("1")) {
								Window.Location.replace("/frontoffice");
							} else {
								showLoginForm();
							}
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
		} else {
			showLoginForm();
		}
	}

}
