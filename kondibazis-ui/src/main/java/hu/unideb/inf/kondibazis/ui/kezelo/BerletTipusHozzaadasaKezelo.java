package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.ui.bevitel.szam.NumberTextField;
import hu.unideb.inf.kondibazis.ui.bevitel.szam.NumberTextFieldLimited;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class BerletTipusHozzaadasaKezelo implements Initializable {

	FeluletBetoltese feluletBetoltese = new FeluletBetoltese();

	@FXML
	private Button letrehozasGomb;

	@FXML
	private Button kihagyasGomb;

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

	@FXML
	public void kihagyas(ActionEvent event) throws IOException {
//		feluletBetoltese.BelepesiFelulet();
//		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
