package hu.unideb.inf.kondibazis.ui.bevitel.szolg;

import javafx.scene.control.TextField;

public class NumberTextFieldIranyitoszam extends TextField {
	
	private final int limit = 4;
	
	@Override
	public void replaceText(int i , int il, String string) {
		if(string.matches("[0-9]") || string.isEmpty()) {
			super.replaceText(i, il, string);
			verify();
		}
	}
	
	@Override
	public void replaceSelection(String string) {
		super.replaceSelection(string);
		verify();
	}
	
	 private void verify() {
	        if (getText().length() > limit) {
	            setText(getText().substring(0, limit));
	        }

	    }

}