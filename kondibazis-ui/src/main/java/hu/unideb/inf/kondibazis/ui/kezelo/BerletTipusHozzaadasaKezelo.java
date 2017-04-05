package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class BerletTipusHozzaadasaKezelo implements Initializable {

	FeluletBetoltese feluletBetoltese = new FeluletBetoltese();
	
	@FXML
	private Button letrehozasGomb;
	
	@FXML
	private Button kihagyasGomb;

	@FXML
	public void letrehozas(ActionEvent event) {

	}

	@FXML
	public void kihagyas(ActionEvent event) throws IOException {
		feluletBetoltese.BelepesiFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		letrehozasGomb.setVisible(false);
	}

}
