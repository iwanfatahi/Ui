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
		vefCompany.setViewerEditor(new CompanyViewer(), new CompanyEditor());
		vefBranch.setViewerEditor(new CompanyViewer(), new CompanyEditor());
		vefSubBranch.setViewerEditor(new CompanyViewer(), new CompanyEditor());
		//
		// Tabs are hidden because of overflow setting. Remove overflow &
		// relative positioning from the tab widget.
		// for (int i = 0; i < tlpCompanyProfile.getWidgetCount(); i++) {
		// final Widget widget = tlpCompanyProfile.getWidget(i);
		// widget.getElement().getStyle().setProperty("position", "relative");
		//
		// final Element parent = DOM.getParent(widget.getElement());
		// parent.getStyle().setProperty("overflowX", "visible");
		// //parent.getStyle().setProperty("overflowY", "visible");
		// }
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void editCompany() {

	}

}
