package org.simbiosis.ui.gwt.client.editor;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.IntegerBox;

public class IntegerTextBox extends IntegerBox {

	NumberFormat nf = NumberFormat.getFormat("#0;(#0)");
	Boolean dontProcess = false;

	public IntegerTextBox() {
		//
		setStyleName("gwt-TextBox");
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
					((IntegerBox) event.getSource()).cancelKey();
				} else {
					if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_LEFT
							|| event.getNativeEvent().getKeyCode() == KeyCodes.KEY_RIGHT) {
						dontProcess = true;
					}
				}
			}
		});

		//
		addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (!dontProcess) {
					int index = getCursorPos();
					int indexAdded = formatValue(index);
					setCursorPos(index + indexAdded);
				} else {
					dontProcess = false;
				}
			}
		});
	}

	@Override
	public void setValue(Integer value) {
		setText(nf.format(value));
	}

	private int formatValue(int curPos) {
		int result = 0;
		String text = getText();
		int textLength = text.length();
		//
		text = getText().replace(",", "");
		//
		String textFormat = nf.format(nf.parse(text));
		int newLength = textFormat.length();
		if (textLength != 1) {
			result = newLength - textLength;
		}
		setText(textFormat);
		return result;
	}

}
