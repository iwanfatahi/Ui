package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class ViewerEditorForm<D> extends SimpleLayoutPanel {

	ViewerForm<D> viewer;
	EditorForm<D> editor;
	D data;

	public void setViewerEditor(ViewerForm<D> viewer, EditorForm<D> editor) {
		this.viewer = viewer;
		this.editor = editor;
	}

	public void setData(D data) {
		this.data = data;
	}

	public void show() {
		add(viewer);
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
