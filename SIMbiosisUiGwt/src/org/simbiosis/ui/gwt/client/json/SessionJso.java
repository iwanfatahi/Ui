package org.simbiosis.ui.gwt.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class SessionJso extends JavaScriptObject {
	protected SessionJso() {
	}

	public final native String getUserRealName() /*-{
		return this.userRealName;
	}-*/;

	public final native void setUserRealName(String value) /*-{
		this.userRealName = value;
	}-*/;

	public final native String getCompanyName() /*-{
		return this.companyName;
	}-*/;

	public final native void setCompanyName(String value) /*-{
		this.companyName = value;
	}-*/;

	public final native String getBranchName() /*-{
		return this.branchName;
	}-*/;

	public final native void setBranchName(String value) /*-{
		this.branchName = value;
	}-*/;

	public final native JsArray<MenuJso> getMenuItems() /*-{
		return this.menuItems;
	}-*/;
}
