package org.simbiosis.ui.gwt.client.mainwidget;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.SIMbiosisStatus;
import org.simbiosis.ui.gwt.client.main.IMain.Activity;
import org.simbiosis.ui.gwt.shared.ShortMenuDv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SidebarCollapse extends Composite {

	private static SidebarCollapseUiBinder uiBinder = GWT
			.create(SidebarCollapseUiBinder.class);

	interface SidebarCollapseUiBinder extends UiBinder<Widget, SidebarCollapse> {
	}

	Activity activity;
	int indexCreation = 0;
	int indexSelected = -1;
	List<HorizontalPanel> hpList = new ArrayList<HorizontalPanel>();
	SidebarHandler handler;

	@UiField
	VerticalPanel itemPanel;

	public SidebarCollapse(SidebarHandler handler) {
		initWidget(uiBinder.createAndBindUi(this));
		//
		this.handler = handler;
		itemPanel.add(new SidebarCollapseHeader(handler));
	}

	private void addMenuItem(String title, String icon, final String link,
			final String path) {
		final Integer index = new Integer(indexCreation);
		HorizontalPanel hp = new HorizontalPanel();
		hp.setStyleName("sidebarShortMenu");
		hp.add(new HTML("<i class=\"fa " + icon + " fa-fw\"/>"));
		hp.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				activateMenu(index, path, true);
				//
				activity.goTo(link + ":");
			}
		}, ClickEvent.getType());
		itemPanel.add(hp);
		//
		hpList.add(hp);
	}

	public void setActivity(Activity activity, SIMbiosisStatus status) {
		this.activity = activity;
		//
		for (ShortMenuDv menu : status.getMenus()) {
			addMenuItem(menu.getTitle(), menu.getIcon(), menu.getLink(),
					menu.getPath());
			indexCreation++;
		}
	}

	public void activateMenu(Integer index, String path, Boolean execHandler) {
		// Kembalikan warna asli
		if (indexSelected > -1) {
			hpList.get(indexSelected).setStyleName("sidebarShortMenu");
		}
		//
		indexSelected = index;
		//
		if (execHandler) {
			handler.changeMenuItem(index, path);
		}
		// Set warna aktiv
		hpList.get(indexSelected).setStyleName("sidebarShortMenuSelected");
	}
}
