package org.simbiosis.ui.gwt.client.mainwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationsPopup extends PopupPanel {

	public interface Handler {
		public void onLogout();
	}

	@UiField
	VerticalPanel callOutPanel;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, ApplicationsPopup> {
	}

	Handler handler = null;

	public ApplicationsPopup(int left, int top, String width) {
		super(true);
		setWidget(uiBinder.createAndBindUi(this));
		callOutPanel.setWidth(width);
		setPopupPosition(left, top);
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
