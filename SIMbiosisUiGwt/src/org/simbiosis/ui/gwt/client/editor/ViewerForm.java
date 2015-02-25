package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.user.client.ui.Composite;

public abstract class ViewerForm<D> extends Composite {
	private ViewerEditorForm<D> parent;

	public abstract void view(D data);

	public ViewerEditorForm<D> getParent() {
		return parent;
	}

	public void setParent(ViewerEditorForm<D> parent) {
		this.parent = parent;
	}

	public void edit() {
		parent.edit();
	}
}
