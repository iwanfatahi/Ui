package org.simbiosis.ui.bpr.system.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CompanyProfile extends Place {
	String token;

	public CompanyProfile(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<CompanyProfile> {

		@Override
		public CompanyProfile getPlace(String token) {
			return new CompanyProfile(token);
		}

		@Override
		public String getToken(CompanyProfile place) {
			return place.getToken();
		}

	}
}
