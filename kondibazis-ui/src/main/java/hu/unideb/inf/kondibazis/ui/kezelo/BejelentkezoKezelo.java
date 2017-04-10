package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Component
public class BejelentkezoKezelo implements Initializable {

	@FXML
	public void bejelentkezes(ActionEvent event) throws IOException {
		FeluletBetoltese.FoAblakFelulet(event);
	}

	@FXML
	public void regisztralas(ActionEvent event) throws IOException {
		FeluletBetoltese.RegisztralasiFelulet(event);
	}

	@FXML
	public void vissza(ActionEvent event) throws IOException {
		FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
