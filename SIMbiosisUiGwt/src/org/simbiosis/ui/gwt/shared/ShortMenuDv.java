package org.simbiosis.ui.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ShortMenuDv implements IsSerializable {
	String title;
	String place;
	String link;
	String icon;
	String path;
	Boolean visible;

	public ShortMenuDv() {

	}

	public ShortMenuDv(String title, String icon, String link, String path,
			String place, Boolean visible) {
		this.title = title;
		this.icon = icon;
		this.link = link;
		this.path = path;
		this.place = place;
		this.visible = visible;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public Boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
