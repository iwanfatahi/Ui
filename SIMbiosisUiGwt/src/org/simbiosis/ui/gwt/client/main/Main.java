package org.simbiosis.ui.gwt.client.main;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Main extends Place {
	String token;

	public Main(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<Main> {

		@Override
		public Main getPlace(String token) {
			return new Main(token);
		}

		@Override
		public String getToken(Main place) {
			return place.getToken();
		}

	}
}
