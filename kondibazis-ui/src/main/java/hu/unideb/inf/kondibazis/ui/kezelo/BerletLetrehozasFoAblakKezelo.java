package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.kondibazis.ui.bevitel.szam.NumberTextField;
import hu.unideb.inf.kondibazis.ui.bevitel.szam.NumberTextFieldLimited;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BerletLetrehozasFoAblakKezelo implements Initializable {
	
	@FXML
	private Button letrehozasGomb;

	@FXML
	private TextField berletnevBevitel;

	@FXML
	private NumberTextField berletaraBevitel;

	@FXML
	private NumberTextFieldLimited oraBevitel;

	@FXML
	private NumberTextFieldLimited napBevitel;

	@FXML
	private NumberTextFieldLimited honapBevitel;

	@FXML
	private Text letrehozasUzenet;
	
	@FXML
	public void letrehozas(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
