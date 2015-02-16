package org.simbiosis.ui.gwt.client.mvp;

import org.simbiosis.ui.gwt.client.SIMbiosisStatus;
import org.simbiosis.ui.gwt.client.main.IMain;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface SIMbiosisClientFactory {
	SIMbiosisStatus getStatus();

	EventBus getEventBus();

	PlaceController getPlaceController();

	IMain getMainForm();

	Boolean canGoto(Place place);
}