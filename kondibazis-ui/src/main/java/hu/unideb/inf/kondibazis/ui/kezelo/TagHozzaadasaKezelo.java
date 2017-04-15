package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Component
public class TagHozzaadasaKezelo implements Initializable {

	private Image nincsKep = new Image("/kepek/nincsKep.png");

	@FXML
	private ImageView kepMegjelenites;

	@FXML
	public void szuldatumKivalaszt(ActionEvent event) {
	}

	@FXML
	public void ferfiValasztas(ActionEvent event) {
	}

	@FXML
	public void noValasztas(ActionEvent event) {
	}

	@FXML
	public void beiratkozasKivalaszt(ActionEvent event) {
	}

	@FXML
	public void hozzaadas(ActionEvent event) {
	}

	@FXML
	public void tallozas(ActionEvent event) {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kepMegjelenites.setImage(nincsKep);
	}

}
