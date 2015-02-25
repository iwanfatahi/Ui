package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.shared.CompanyDv;
import org.simbiosis.ui.gwt.client.editor.ViewerEditorForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class CompanyProfileForm extends Composite implements ICompanyProfile {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, CompanyProfileForm> {
	}

	CompanyViewer companyViewer;
	CompanyEditor companyEditor;

	@UiField
	TabLayoutPanel tlpCompanyProfile;
	@UiField
	ViewerEditorForm<CompanyDv> vefCompany;
	@UiField
	ViewerEditorForm<CompanyDv> vefBranch;
	@UiField
	ViewerEditorForm<CompanyDv> vefSubBranch;

	public CompanyProfileForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		companyViewer = new CompanyViewer();
		companyEditor = new CompanyEditor();
		vefCompany.setViewerEditor(companyViewer, companyEditor);
		vefCompany.init(new CompanyDv());
		vefBranch.setViewerEditor(new CompanyViewer(), new CompanyEditor());
		vefBranch.init(new CompanyDv());
		vefSubBranch.setViewerEditor(new CompanyViewer(), new CompanyEditor());
		vefSubBranch.init(new CompanyDv());
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
		companyViewer.setActivity(activity);
		companyEditor.setActivity(activity);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void setCompanyData(CompanyDv data) {
		vefCompany.setData(data);
	}

	@Override
	public void viewCompany() {
		vefCompany.view();
	}

	@Override
	public void editCompany() {
		vefCompany.edit();
	}

}
