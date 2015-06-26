package org.simbiosis.ui.gwt.client.main;

import org.simbiosis.ui.gwt.client.SIMbiosisStatus;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public interface IMain {
	public void setActivity(Activity activity, SIMbiosisStatus status);

	public Widget getWidget();

	public SimpleLayoutPanel getDisplay();

	public HTMLPanel getLogoPanel();
	
	public void setHasProfile(String link);
	
	public void activateMainMenu(Integer index, String path);

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void logout();
		
		public abstract void goTo(Place place);

		public abstract void goTo(String place);
	}
}
