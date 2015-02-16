package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.google.gwt.user.client.ui.Widget;

public interface ICompanyProfile {
	public void setActivity(Activity activity);

	public Widget getWidget();

	public void editCompany();

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void editCompany();
	}
}
