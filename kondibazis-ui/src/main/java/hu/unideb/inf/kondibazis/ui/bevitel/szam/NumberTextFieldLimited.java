package hu.unideb.inf.kondibazis.ui.bevitel.szam;

import javafx.scene.control.TextField;

public class NumberTextFieldLimited extends TextField {
	
	private final int limit = 2;
	
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
