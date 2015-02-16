package org.simbiosis.ui.gwt.client.mainwidget;

import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Sidebar extends Composite {

	private static SidebarUiBinder uiBinder = GWT.create(SidebarUiBinder.class);

	interface SidebarUiBinder extends UiBinder<Widget, Sidebar> {
	}

	Activity activity;
	int indexCreation = 0;
	int indexSelected = -1;
	List<HorizontalPanel> hpList = new ArrayList<HorizontalPanel>();
	List<Label> labelList = new ArrayList<Label>();
	SidebarHandler handler;

	@UiField
	VerticalPanel itemPanel;

	public Sidebar(SidebarHandler handler) {
		initWidget(uiBinder.createAndBindUi(this));
		//
		this.handler = handler;
		itemPanel.add(new SidebarHeader(handler));
	}

	public void setMenuList(List<ShortMenuDv> menus) {
		for (ShortMenuDv menu : menus) {
			addMenuItem(menu.getTitle(), menu.getIcon(), menu.getLink(),
					menu.getPath());
			indexCreation++;
		}
	}

	private void addMenuItem(String title, String icon, final String link,
			final String path) {
		final Integer index = new Integer(indexCreation);
		HorizontalPanel hp = new HorizontalPanel();
		hp.setStyleName("sidebarMenu");
		hp.add(new HTML("<i class=\"fa " + icon + " fa-fw\"/>"));
		hp.add(new HTML("&nbsp;"));
		Label sidebarMenuTitle = new Label(title);
		sidebarMenuTitle.setStyleName("sidebarMenuTitle");
		hp.add(sidebarMenuTitle);
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
		labelList.add(sidebarMenuTitle);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void activateMenu(Integer index, String path, Boolean execHandler) {
		// Kembalikan warna asli
		if (indexSelected > -1) {
			hpList.get(indexSelected).setStyleName("sidebarMenu");
			labelList.get(indexSelected).setStyleName("sidebarMenuTitle");
		}
		//
		indexSelected = index;
		// Set warna aktiv
		hpList.get(indexSelected).setStyleName("sidebarMenuSelected");
		//
		if (execHandler) {
			handler.changeMenuItem(index, path);
		}
		//
		labelList.get(indexSelected).setStyleName("sidebarMenuTitleSelected");
	}
}
