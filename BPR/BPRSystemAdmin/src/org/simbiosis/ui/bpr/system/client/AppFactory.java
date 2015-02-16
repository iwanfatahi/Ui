package org.simbiosis.ui.bpr.system.client;

import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;

public interface AppFactory extends SIMbiosisClientFactory {
	ICompanyProfile getCompanyForm();
}
