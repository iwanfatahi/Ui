package org.simbiosis.ui.bpr.system.client.companyprofile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BranchEditor extends Composite {

	private static BranchEditorUiBinder uiBinder = GWT
			.create(BranchEditorUiBinder.class);

	interface BranchEditorUiBinder extends UiBinder<Widget, BranchEditor> {
	}

	public BranchEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
