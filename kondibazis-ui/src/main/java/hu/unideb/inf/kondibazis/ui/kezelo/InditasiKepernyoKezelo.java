package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class InditasiKepernyoKezelo implements Initializable {
	
	FeluletBetoltese feluletBetoltese = new FeluletBetoltese();
	
	@FXML
	public void bejelentkezes(ActionEvent event) throws IOException {
		((Node) (event.getSource())).getScene().getWindow().hide();
		feluletBetoltese.BelepesiFelulet();
	}
	
	@FXML
	public void regisztracio(ActionEvent event) throws IOException{
		((Node) (event.getSource())).getScene().getWindow().hide();
		feluletBetoltese.RegisztralasiFelulet();
	}
	
	@FXML
	public void nevjegy(ActionEvent event) throws IOException {
		((Node) (event.getSource())).getScene().getWindow().hide();
		feluletBetoltese.NevjegyFelulet();
	}
	
	@FXML
	public void kilepes(ActionEvent event){
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
