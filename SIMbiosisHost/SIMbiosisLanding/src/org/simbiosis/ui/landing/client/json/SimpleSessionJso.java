package org.simbiosis.ui.landing.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class SimpleSessionJso extends JavaScriptObject {
	protected SimpleSessionJso() {
	}

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native String getFirstModule() /*-{
		return this.firstModule;
	}-*/;

}
