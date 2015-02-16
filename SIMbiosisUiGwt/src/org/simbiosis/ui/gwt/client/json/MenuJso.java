package org.simbiosis.ui.gwt.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class MenuJso extends JavaScriptObject {

	protected MenuJso() {

	}

	public final native String getTitle() /*-{
		return this.title;
	}-*/;

	public final native void setTitle(String value) /*-{
		this.title = value;
	}-*/;

	public final native String getIcon() /*-{
		return this.icon;
	}-*/;

	public final native void setIcon(String value) /*-{
		this.icon = value;
	}-*/;

	public final native String getLink() /*-{
		return this.link;
	}-*/;

	public final native String getParentTitle() /*-{
		return this.parentTitle;
	}-*/;

	public final native String getGrandParentTitle() /*-{
		return this.grandParentTitle;
	}-*/;
}
