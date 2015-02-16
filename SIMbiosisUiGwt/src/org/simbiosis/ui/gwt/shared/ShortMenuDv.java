package org.simbiosis.ui.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ShortMenuDv implements IsSerializable {
	String title;
	String link;
	String icon;
	String path;

	public ShortMenuDv() {

	}

	public ShortMenuDv(String title, String icon, String link, String path) {
		this.title = title;
		this.icon = icon;
		this.link = link;
		this.path = path;
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
}
