package org.simbiosis.ui.gwt.client;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.json.JsonServerResponse;
import org.simbiosis.ui.gwt.client.json.MenuJso;
import org.simbiosis.ui.gwt.client.json.SessionJso;
import org.simbiosis.ui.gwt.client.main.IMain;
import org.simbiosis.ui.gwt.client.main.Main;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;
import org.simbiosis.ui.gwt.shared.ShortMenuDv;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public abstract class SIMbiosisEntryPoint {
	private String moduleName;
	private Place defaultPlace;
	private SIMbiosisClientFactory clientFactory;
	private ActivityMapper activityMapper;
	private SIMbiosisHistoryMapper historyMapper;

	public SIMbiosisEntryPoint(String moduleName) {
		defaultPlace = new Main("");
		this.moduleName = moduleName;
	}

	public SIMbiosisEntryPoint(String moduleName, Place defaultPlace) {
		this.moduleName = moduleName;
		this.defaultPlace = defaultPlace;
	}

	public String getModuleName() {
		return moduleName;
	}

	public abstract void initialize();

	public void setClientFactory(SIMbiosisEntryPoint entryPoint,
			SIMbiosisClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.clientFactory.getStatus()
				.setModuleName(entryPoint.getModuleName());
	}

	public SIMbiosisClientFactory getClientFactory() {
		return clientFactory;
	}

	public void setMapper(ActivityMapper activityMapper,
			SIMbiosisHistoryMapper historyMapper) {
		this.activityMapper = activityMapper;
		this.historyMapper = historyMapper;
	}

	private void showLoginForm() {
		Window.Location.replace("/login");
	}

	private void showMainForm() {
		//
		ActivityManager activityManager = new ActivityManager(activityMapper,
				clientFactory.getEventBus());
		IMain mainForm = clientFactory.getMainForm();
		SIMbiosisStatus status = clientFactory.getStatus();
		activityManager.setDisplay(mainForm.getDisplay());
		mainForm.setMenuList(status.getMenus());
		mainForm.setUserInformation(status.getCompanyName(),
				status.getBranchName(), status.getUserRealName());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(), defaultPlace);

		RootLayoutPanel.get().add(clientFactory.getMainForm().getWidget());
		historyHandler.handleCurrentHistory();
	}

	private void loadUserMenu(JsArray<MenuJso> menus) {
		List<ShortMenuDv> userMenus = new ArrayList<ShortMenuDv>();
		for (int i = 0; i < menus.length(); i++) {
			MenuJso menu = menus.get(i);
			userMenus.add(new ShortMenuDv(menu.getTitle(), menu.getIcon(), menu
					.getLink(), menu.getGrandParentTitle() + " / "
					+ menu.getParentTitle() + " / " + menu.getTitle()));
		}
		// userMenus.add(new ShortMenuDv("Master tabungan", "fa-database",
		// "SearchSaving"));
		// userMenus.add(new ShortMenuDv("Setor tunai", "fa-sign-in", ""));
		// userMenus.add(new ShortMenuDv("Tarik tunai", "fa-sign-out", ""));
		clientFactory.getStatus().setMenus(userMenus);
		//
		showMainForm();
	}

	private void sessionValid(String json) {
		SessionJso session = JsonServerResponse.getSessionJso(json);
		SIMbiosisStatus status = clientFactory.getStatus();
		status.setUserRealName(session.getUserRealName());
		status.setCompanyName(session.getCompanyName());
		status.setBranchName(session.getBranchName());
		loadUserMenu(session.getMenuItems());
	}

	public void start() {
		//
		// Resources.INSTANCE.css().ensureInjected();
		//
		initialize();
		//
		//
		SIMbiosisStatus status = getClientFactory().getStatus();
		String session = status.getSession();
		if (session != null && !session.isEmpty()) {
			String url = Window.Location.getProtocol() + "//"
					+ Window.Location.getHost()
					+ "/systemuiapi/session/getlogininfo/"
					+ session.replace("/", "%2F") + "/"
					+ status.getModuleName();
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
			try {
				builder.sendRequest(null, new RequestCallback() {
					public void onError(Request request, Throwable e) {
						Window.alert(e.getMessage());
					}

					public void onResponseReceived(Request request,
							Response response) {
						if (200 == response.getStatusCode()) {
							if (!response.getText().isEmpty()) {
								sessionValid(response.getText());
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
