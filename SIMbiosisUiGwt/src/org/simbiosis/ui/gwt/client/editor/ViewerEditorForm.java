package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class ViewerEditorForm<D> extends SimpleLayoutPanel {

	ViewerForm<D> viewer;
	EditorForm<D> editor;
	D data;

	public void setViewerEditor(ViewerForm<D> viewer, EditorForm<D> editor) {
		this.viewer = viewer;
		this.viewer.setParent(this);
		this.editor = editor;
		this.editor.setParent(this);
	}

	public void init(D data) {
		this.data = data;
		add(viewer);
	}

	public void setData(D data) {
		this.data = data;
	}

	public void view() {
		viewer.view(data);
		clear();
		add(viewer);
	}

	public void edit() {
		editor.edit(data);
		clear();
		add(editor);
	}

}
