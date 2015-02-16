package org.simbiosis.ui.bpr.system.client;

import org.simbiosis.ui.bpr.system.client.companyprofile.CompanyProfileForm;
import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactoryImpl;

public class AppFactoryImpl extends SIMbiosisClientFactoryImpl implements
		AppFactory {

	static final CompanyProfileForm COMPANY_FORM = new CompanyProfileForm();

	@Override
	public ICompanyProfile getCompanyForm() {
		return COMPANY_FORM;
	}

}
