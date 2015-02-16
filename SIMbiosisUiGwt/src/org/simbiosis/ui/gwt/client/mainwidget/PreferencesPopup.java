package org.simbiosis.ui.gwt.client.mainwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PreferencesPopup extends PopupPanel {

	public interface Handler {
		public void onLogout();
	}

	@UiField
	Label userName;
	@UiField
	Label userCompany;
	@UiField
	Label logout;
	@UiField
	Label changePassword;
	@UiField
	Label editFastMenu;
	@UiField
	VerticalPanel callOutPanel;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, PreferencesPopup> {
	}

	Handler handler = null;

	public PreferencesPopup(int left, int top, String width) {
		super(true);
		setWidget(uiBinder.createAndBindUi(this));
		callOutPanel.setWidth(width);
		setPopupPosition(left, top);
	}

	public void setUserName(String userName) {
		this.userName.setText(userName);
	}

	public void setCompany(String company) {
		this.userCompany.setText(company);
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@UiHandler("logout")
	public void onLogout(ClickEvent e) {
		hide();
		handler.onLogout();
	}
}
