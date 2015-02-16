package org.simbiosis.ui.bpr.system.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class UserGroup extends Place {
	String token;

	public UserGroup(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<UserGroup> {

		@Override
		public UserGroup getPlace(String token) {
			return new UserGroup(token);
		}

		@Override
		public String getToken(UserGroup place) {
			return place.getToken();
		}

	}
}
