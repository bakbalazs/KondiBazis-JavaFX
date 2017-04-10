package hu.unideb.inf.kondibazis.ui.kezelo;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

@Component
public class FoAblakKezelo implements Initializable {
	
	@FXML
	private Button berletLetrehozasaGomb;
	
	@FXML
	private Button tagHozzaadasaGomb;
	
	@FXML
	public void berletLetrehozasa(ActionEvent event) throws IOException {
		FeluletBetoltese.BerletLetrehozasaFoAblakFelulet();
	}
	
	@FXML
	public void tagHozzaadasa(ActionEvent event) throws IOException {
		FeluletBetoltese.TagHozzaadasaFelulet(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}

}
