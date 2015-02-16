package org.simbiosis.ui.gwt.client.main;

import java.util.List;

import org.simbiosis.ui.gwt.client.mainwidget.ApplicationsPopup;
import org.simbiosis.ui.gwt.client.mainwidget.PreferencesPopup;
import org.simbiosis.ui.gwt.client.mainwidget.PreferencesPopup.Handler;
import org.simbiosis.ui.gwt.client.mainwidget.Sidebar;
import org.simbiosis.ui.gwt.client.mainwidget.SidebarCollapse;
import org.simbiosis.ui.gwt.client.mainwidget.SidebarHandler;
import org.simbiosis.ui.gwt.shared.ShortMenuDv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainForm extends Composite implements IMain {

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, MainForm> {
	}

	@UiField
	Button preferences;
	@UiField
	Button applications;
	@UiField
	DockLayoutPanel sidebarParentPanel;
	@UiField
	VerticalPanel sidebarPanel;
	@UiField
	SimpleLayoutPanel appPanel;
	@UiField
	Label appPath;

	Sidebar sidebar;
	SidebarCollapse sidebarCollapse;
	Activity activity;
	String companyName;
	String branchName;
	String userRealName;

	public MainForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		sidebar = new Sidebar(new SidebarHandler() {

			@Override
			public void onSwitchCollapse() {
				sidebarPanel.clear();
				sidebarParentPanel.setWidgetSize(sidebarPanel, 38);
				sidebarPanel.add(sidebarCollapse);
				sidebarPanel.setCellWidth(sidebarCollapse, "38px");
			}

			@Override
			public void changeMenuItem(int index, String path) {
				appPath.setText(path);
				sidebarCollapse.activateMenu(index, path, false);
			}

		});

		sidebarCollapse = new SidebarCollapse(new SidebarHandler() {

			@Override
			public void onSwitchCollapse() {
				sidebarPanel.clear();
				sidebarParentPanel.setWidgetSize(sidebarPanel, 220);
				sidebarPanel.add(sidebar);
				sidebarPanel.setCellWidth(sidebar, "220px");
			}

			@Override
			public void changeMenuItem(int index, String path) {
				appPath.setText(path);
				sidebar.activateMenu(index, path, false);
			}

		});
		//
		sidebarPanel.add(sidebar);
		sidebarPanel.setCellWidth(sidebar, "220px");
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
		sidebar.setActivity(activity);
		sidebarCollapse.setActivity(activity);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public SimpleLayoutPanel getDisplay() {
		return appPanel;
	}

	@UiHandler("preferences")
	public void onPreferences(ClickEvent e) {
		// Ganti style button preferences
		preferences.setStyleName("headerConfigButtonOnClick");
		// Buat popup untuk preferences
		int x = Window.getClientWidth() - 276;
		PreferencesPopup pPopup = new PreferencesPopup(x, 60, "270px");
		pPopup.setUserName(userRealName);
		pPopup.setCompany(companyName + " - " + branchName);
		// Tambahkan close handler yang mengembalikan style button preferences
		pPopup.addCloseHandler(new CloseHandler<PopupPanel>() {

			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				preferences.setStyleName("headerConfigButton");
			}
		});
		// Tambahkan handler untuk masing-masing item
		pPopup.setHandler(new Handler() {

			@Override
			public void onLogout() {
				activity.logout();
			}
		});
		// Munculkan
		pPopup.show();
	}

	@UiHandler("applications")
	public void onApplications(ClickEvent e) {
		// Ganti style button preferences
		applications.setStyleName("headerConfigButtonOnClick");
		// Buat popup untuk preferences
		int x = Window.getClientWidth() - 239;
		ApplicationsPopup pPopup = new ApplicationsPopup(x, 60, "200px");
		// Tambahkan close handler yang mengembalikan style button preferences
		pPopup.addCloseHandler(new CloseHandler<PopupPanel>() {

			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				applications.setStyleName("headerConfigButton");
			}
		});
		// Tambahkan handler untuk masing-masing item
		// pPopup.setHandler(new Handler() {
		//
		// @Override
		// public void onLogout() {
		// activity.logout();
		// }
		// });
		// Munculkan
		pPopup.show();
	}

	public void attachApp(Widget widget) {
		appPanel.clear();
		appPanel.add(widget);
	}

	@Override
	public void setMenuList(List<ShortMenuDv> menus) {
		sidebar.setMenuList(menus);
		sidebarCollapse.setMenuList(menus);
	}

	@Override
	public void setUserInformation(String companyName, String branchName,
			String userRealName) {
		this.companyName = companyName;
		this.branchName = branchName;
		this.userRealName = userRealName;
	}

}
