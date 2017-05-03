package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class BerletLetrehozasFoAblakKezelo implements Initializable {
	
	@FXML 
	TextField berletnevBevitel;
	@FXML 
	TextField berletaraBevitel;
	@FXML 
	TextField oraBevitel;
	@FXML 
	TextField napBevitel;
	@FXML 
	TextField honapBevitel;
	@FXML 
	Text berletletrehozasUzenet;
	@FXML 
	Text bejelentkezettKonditerem;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML 
	public void letrehozas(ActionEvent event) {}

	@FXML 
	public void kihagyas(ActionEvent event) {}

}
