package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile.Activity;
import org.simbiosis.ui.bpr.system.shared.CompanyDv;
import org.simbiosis.ui.gwt.client.editor.ViewerForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class CompanyViewer extends ViewerForm<CompanyDv> {

	Activity activity;

	private static CompanyEditorUiBinder uiBinder = GWT
			.create(CompanyEditorUiBinder.class);

	interface CompanyEditorUiBinder extends UiBinder<Widget, CompanyViewer> {
	}

	@UiField
	Button btnChange;

	public CompanyViewer() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@UiHandler("btnChange")
	public void onChange(ClickEvent e) {
		activity.editCompany();
	}

	@Override
	public void view(CompanyDv data) {
		// TODO Auto-generated method stub

	}
}
