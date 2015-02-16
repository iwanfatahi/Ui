package org.simbiosis.ui.gwt.client.mainwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SidebarCollapseHeader extends Composite {

	private static SidebarHeaderUiBinder uiBinder = GWT
			.create(SidebarHeaderUiBinder.class);

	@UiField
	Button switchCollapse;

	SidebarHandler handler;

	interface SidebarHeaderUiBinder extends
			UiBinder<Widget, SidebarCollapseHeader> {
	}

	public SidebarCollapseHeader(SidebarHandler handler) {
		initWidget(uiBinder.createAndBindUi(this));
		this.handler = handler;
	}

	@UiHandler("switchCollapse")
	public void onSwitchCollapse(ClickEvent e) {
		handler.onSwitchCollapse();
	}
}
