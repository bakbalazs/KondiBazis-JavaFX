package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class BejelentkezoKezelo implements Initializable {
	
	FeluletBetoltese feluletBetoltese = new FeluletBetoltese();
	
	@FXML
	public void bejelentkezes(ActionEvent event) throws IOException{
		feluletBetoltese.FoAblakFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	public void regisztralas(ActionEvent event) throws IOException{
		feluletBetoltese.RegisztralasiFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	public void vissza(ActionEvent event) throws IOException{
		feluletBetoltese.InditasiFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
