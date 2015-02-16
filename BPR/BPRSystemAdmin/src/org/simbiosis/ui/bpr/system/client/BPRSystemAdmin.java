package org.simbiosis.ui.bpr.system.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BPRSystemAdmin implements EntryPoint {
	public void onModuleLoad() {
		new AppEntryPoint(getClass().getSimpleName()).start();
	}

}
