package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;

public class NumericTextBox extends TextBox implements LeafValueEditor<String> {

	public NumericTextBox() {
		//
		addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (!Character.isDigit(event.getCharCode())
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_TAB
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_LEFT
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_RIGHT
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DELETE
						&& event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE) {
					((TextBox) event.getSource()).cancelKey();
				}
			}
		});

	}

	@Override
	public void setValue(String value) {
		if (isStringNumeric(value)) {
			setText(value);
		} else {
			setText("");
		}
	}

	@Override
	public String getValue() {
		return getText();
	}

	public static boolean isStringNumeric(String str) {
		boolean isMinus = str.charAt(0) == '-';
		if ((isMinus && str.length() < 2)
				|| ((!isMinus) && !Character.isDigit(str.charAt(0))))
			return false;

		boolean isDecimalSeparatorFound = false;
		char localeDecimalSeparator = '.';

		for (char c : str.substring(1).toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c == localeDecimalSeparator && !isDecimalSeparatorFound) {
					isDecimalSeparatorFound = true;
					continue;
				}
				return false;
			}
		}
		return true;
	}

}
