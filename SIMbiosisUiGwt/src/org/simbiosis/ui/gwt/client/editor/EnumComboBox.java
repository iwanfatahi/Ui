package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.ListBox;

public class EnumComboBox<T extends Enum<T>> extends ListBox implements
		LeafValueEditor<Integer> {
	Class<T> enumClass;

	public EnumComboBox(Class<T> enumClass) {
		this.enumClass = enumClass;
		addAll();
	}

	@Override
	public void setValue(Integer value) {
		if (value == null) {
			setSelectedIndex(-1);
		} else {
			setSelectedIndex(value - 1);
		}
	}

	@Override
	public Integer getValue() {
		String value = getValue(getSelectedIndex());
		return Integer.parseInt(value);
	}

	public void addAll() {
		int i = 1;
		for (T t : enumClass.getEnumConstants()) {
			String title = t.toString();
			this.addItem(title.replaceAll("_", "-"), "" + i++);
		}
	}

}
