package org.simbiosis.ui.bpr.system.client;

import org.simbiosis.ui.bpr.system.client.companyprofile.CompanyProfileActivity;
import org.simbiosis.ui.bpr.system.client.places.CompanyProfile;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivityMapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper extends SIMbiosisActivityMapper {

	public AppActivityMapper(AppFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public Activity dispatchActivity(Place place) {
		//
		AppFactory appFactory = (AppFactory) getClientFactory();
		//
		if (place instanceof CompanyProfile) {
			return new CompanyProfileActivity((CompanyProfile) place, appFactory);
		}
		return null;
	}

}
