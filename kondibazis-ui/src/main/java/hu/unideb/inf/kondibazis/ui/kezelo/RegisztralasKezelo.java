package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class RegisztralasKezelo implements Initializable {

	@Autowired
	KonditeremSzolgaltatas konditeremSzolgaltatas;

	@FXML
	private TextField konditeremnevBevitel;

	@FXML
	private TextField felhasznalonevBevitel;

	@FXML
	private PasswordField jelszoBevitel;

	@FXML
	private Button visszaGomb;

	@FXML
	private Text regisztraciosUzenet;

	@FXML
	public void regisztralas(ActionEvent event) throws IOException {

		boolean ok = true;
		regisztraciosUzenet.setText("");
		
		if(konditeremnevBevitel.getText().length() == 0) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Konditerem nevének a megadása kötelező\n");
			ok = false;
		}
		
		if(felhasznalonevBevitel.getText().length() == 0) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Felhasználónév megadása kötelező\n");
			ok = false;
		}
		if(jelszoBevitel.getText().length() == 0) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Jelszó megadása kötlező\n");
			ok = false;
		}
		
		if(ok) {
			KonditeremVo uj = new KonditeremVo();
			uj.setKonditeremNeve(konditeremnevBevitel.getText());
			uj.setFelhasznalonev(felhasznalonevBevitel.getText());
			uj.setJelszo(jelszoBevitel.getText());
			konditeremSzolgaltatas.konditeremetLetrehoz(uj);
			regisztraciosUzenet.setText("Sikeres létrehozás");
		}
		
		

		/*
		 * // sikeres reg esetén feluletBetoltese.BerletHozzaadasaFelulet();
		 */
	}

	@FXML
	public void vissza(ActionEvent event) throws IOException {
		FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
