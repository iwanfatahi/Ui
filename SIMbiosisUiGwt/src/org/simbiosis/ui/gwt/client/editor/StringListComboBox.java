package org.simbiosis.ui.gwt.client.editor;

import java.util.List;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.ListBox;

public class StringListComboBox extends ListBox implements
		LeafValueEditor<String> {

	List<String> listData = null;
	
	public void setList(List<String> listData) {
		clear();
		//
		this.listData = listData;
		for (String data : listData) {
			addItem(data);
		}
	}

	@Override
	public void setValue(String value) {
		if (listData == null) {
			setSelectedIndex(0);
		} else {
			int index = 0;
			for (String data : listData) {
				if (value.equals(data)) {
					break;
				}
				index++;
			}
			setSelectedIndex(index < getItemCount() ? index : 0);
		}
	}

	@Override
	public String getValue() {
		return getItemText(getSelectedIndex());
	}

}
