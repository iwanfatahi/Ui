package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.client.AppFactory;
import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile.Activity;
import org.simbiosis.ui.bpr.system.client.places.CompanyProfile;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CompanyProfileActivity extends Activity {

	// private HostServiceAsync hostSrv = GWT.create(HostService.class);

	CompanyProfile myPlace;
	AppFactory appFactory;

	public CompanyProfileActivity(CompanyProfile myPlace, AppFactory appFactory) {
		super();
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ICompanyProfile myForm = appFactory.getCompanyForm();
		myForm.setActivity(this);
		panel.setWidget(myForm.getWidget());
	}

	@Override
	public void editCompany() {
		// TODO edit Data
		// show in form
		ICompanyProfile myForm = appFactory.getCompanyForm();
		myForm.editCompany();
	}

}
