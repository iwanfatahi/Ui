package org.simbiosis.ui.gwt.client.mvp;

import org.simbiosis.ui.gwt.client.main.Main;
import org.simbiosis.ui.gwt.client.main.MainActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public abstract class SIMbiosisActivityMapper implements ActivityMapper {

	private SIMbiosisClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public SIMbiosisActivityMapper(SIMbiosisClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * @return
	 */
	private MainActivity createBlankActivity() {
		return new MainActivity(new Main(""), clientFactory);
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		//
		if (place instanceof Main) {
			return new MainActivity((Main) place, clientFactory);
		} else {
			if (clientFactory.canGoto(place)) {
				return dispatchActivity(place);
			}
		}
		return createBlankActivity();
	}

	public SIMbiosisClientFactory getClientFactory() {
		return clientFactory;
	}

	public abstract Activity dispatchActivity(Place place);

}
