package org.simbiosis.ui.gwt.client.main;

import java.util.List;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;
import org.simbiosis.ui.gwt.shared.ShortMenuDv;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public interface IMain {
	public void setActivity(Activity activity);

	public Widget getWidget();

	public SimpleLayoutPanel getDisplay();

	public void setMenuList(List<ShortMenuDv> menus);

	public void setUserInformation(String companyName, String branchName,
			String userRealName);

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void logout();

		public abstract void goTo(Place place);

		public abstract void goTo(String place);
	}
}
