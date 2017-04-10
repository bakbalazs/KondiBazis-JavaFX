package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Component
public class InditasiKepernyoKezelo implements Initializable {

	@FXML
	public void bejelentkezes(ActionEvent event) throws IOException {
		FeluletBetoltese.BejelentkezoFelulet(event);
	}

	@FXML
	public void regisztracio(ActionEvent event) throws IOException {
		FeluletBetoltese.RegisztralasiFelulet(event);
	}

	@FXML
	public void nevjegy(ActionEvent event) throws IOException {
		FeluletBetoltese.NevjegyFelulet(event);
	}

	@FXML
	public void kilepes(ActionEvent event) {
		SpringFxmlLoader.close();
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
