package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.client.companyprofile.ICompanyProfile.Activity;
import org.simbiosis.ui.bpr.system.shared.CompanyDv;
import org.simbiosis.ui.gwt.client.editor.EditorForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CompanyEditor extends EditorForm<CompanyDv> implements
		Editor<CompanyDv> {

	Activity activity;

	interface ThisUiBinder extends UiBinder<Widget, CompanyEditor> {
	}

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface Driver extends SimpleBeanEditorDriver<CompanyDv, CompanyEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;
	@UiField
	TextBox name;
	@UiField
	TextBox address;
	@UiField
	TextBox city;
	@UiField
	TextBox zipCode;
	@UiField
	TextBox province;
	@UiField
	TextBox phone;
	@UiField
	TextBox biCode;
	@UiField
	TextBox director;
	@UiField
	TextBox pic;

	public CompanyEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
		driver.edit(new CompanyDv());
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@UiHandler("btnSave")
	public void onSave(ClickEvent e) {

	}
	
	@UiHandler("btnCancel")
	public void onCancel(ClickEvent e) {
		showViewForm();
	}

	@Override
	public void edit(CompanyDv data) {
		driver.edit(data);
	}
}
