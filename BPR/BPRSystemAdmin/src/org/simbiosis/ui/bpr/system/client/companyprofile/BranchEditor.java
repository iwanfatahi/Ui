package org.simbiosis.ui.bpr.system.client.companyprofile;

import org.simbiosis.ui.bpr.system.shared.BranchDv;
import org.simbiosis.ui.gwt.client.editor.EditorForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class BranchEditor extends EditorForm<BranchDv> implements
		Editor<BranchDv> {

	private static BranchEditorUiBinder uiBinder = GWT
			.create(BranchEditorUiBinder.class);

	interface BranchEditorUiBinder extends UiBinder<Widget, BranchEditor> {
	}

	public BranchEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void edit(BranchDv data) {
		// TODO Auto-generated method stub
		
	}

}
