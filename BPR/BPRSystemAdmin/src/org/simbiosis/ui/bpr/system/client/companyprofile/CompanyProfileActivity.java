package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.client.AppFactory;
import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile.Activity;
import org.simbiosis.ui.bpr.system.client.places.CompanyProfile;
import org.simbiosis.ui.bpr.system.shared.CompanyDv;

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
		//
		loadCompanyData(myForm);
		//
		panel.setWidget(myForm.getWidget());
	}

	@Override
	public void editCompany() {
		// show in form
		ICompanyProfile myForm = appFactory.getCompanyForm();
		myForm.editCompany();
	}

	private void loadCompanyData(ICompanyProfile myForm) {
		CompanyDv data = new CompanyDv();
		data.setName("PT BPRS KARYA MUGI SENTOSA");
		data.setAddress("JL. MARGOREJO INDAH 70D");
		data.setCity("SURABAYA");
		data.setZipCode("66134");
		data.setProvince("JAWA TIMUR");
		data.setPhone("031887674");
		data.setBiCode("6662001");
		data.setDirector("DRS DIDIK SUPARDANA");
		data.setPic("SULISTYANTINI");
		myForm.setCompanyData(data);
		myForm.viewCompany();
	}

}
