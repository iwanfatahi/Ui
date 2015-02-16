package org.simbiosis.ui.gwt.client.mvp;

import com.google.gwt.activity.shared.AbstractActivity;

public abstract class SIMbiosisActivity extends AbstractActivity {
	String session = "";
	SIMbiosisClientFactory appFactory;

	protected void setFactory(SIMbiosisClientFactory appFactory) {
		this.appFactory = appFactory;
	}

	public String getSession() {
		return appFactory.getStatus().getSession();
	}

	public String getCookies() {
		return appFactory.getStatus().getCookies();
	}
}
