package org.simbiosis.ui.gwt.client.mvp;

import org.simbiosis.ui.gwt.client.SIMbiosisStatus;
import org.simbiosis.ui.gwt.client.main.IMain;
import org.simbiosis.ui.gwt.client.main.MainForm;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class SIMbiosisClientFactoryImpl implements SIMbiosisClientFactory {
	static final EventBus eventBus = new SimpleEventBus();
	static final PlaceController placeController = new PlaceController(eventBus);
	static final SIMbiosisStatus status = new SIMbiosisStatus();
	static final MainForm MAINFORM = new MainForm();

	String placeName;
	String menuName;
	AcceptsOneWidget currentPanel;

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public SIMbiosisStatus getStatus() {
		return status;
	}

	@Override
	public IMain getMainForm() {
		return MAINFORM;
	}

	@Override
	public Boolean canGoto(Place place) {
		// FIXME: harus mempertimbangkan hak akses user terhadap place tersebut
		return true;
	}

}