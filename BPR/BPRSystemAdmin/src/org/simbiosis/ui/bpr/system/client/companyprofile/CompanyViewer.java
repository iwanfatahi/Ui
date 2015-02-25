package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile.Activity;
import org.simbiosis.ui.bpr.system.shared.CompanyDv;
import org.simbiosis.ui.gwt.client.editor.ViewerForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CompanyViewer extends ViewerForm<CompanyDv> implements
		Editor<CompanyDv> {

	Activity activity;

	interface ThisUiBinder extends UiBinder<Widget, CompanyViewer> {
	}

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface Driver extends SimpleBeanEditorDriver<CompanyDv, CompanyViewer> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button btnChange;
	@UiField
	Label name;
	@UiField
	Label address;
	@UiField
	Label city;
	@UiField
	Label zipCode;
	@UiField
	Label province;
	@UiField
	Label phone;
	@UiField
	Label biCode;
	@UiField
	Label director;
	@UiField
	Label pic;

	public CompanyViewer() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
		driver.edit(new CompanyDv());
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
		driver.edit(data);
	}
}
