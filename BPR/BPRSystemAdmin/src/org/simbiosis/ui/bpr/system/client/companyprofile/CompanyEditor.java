package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.shared.CompanyDv;
import org.simbiosis.ui.gwt.client.editor.EditorForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

public class CompanyEditor extends EditorForm<CompanyDv> {

	private static CompanyEditorUiBinder uiBinder = GWT
			.create(CompanyEditorUiBinder.class);

	interface CompanyEditorUiBinder extends UiBinder<Widget, CompanyEditor> {
	}

	@UiField
	Button btnChange;

	public CompanyEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnChange")
	public void onChange(ClickEvent e) {

	}

	@Override
	public void edit(CompanyDv data) {
		// TODO Auto-generated method stub
		
	}
}
