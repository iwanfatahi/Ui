package org.simbiosis.ui.bpr.system.client.companyprofile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SubBranchEditor extends Composite {

	private static SubBranchEditorUiBinder uiBinder = GWT
			.create(SubBranchEditorUiBinder.class);

	interface SubBranchEditorUiBinder extends UiBinder<Widget, SubBranchEditor> {
	}

	public SubBranchEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
