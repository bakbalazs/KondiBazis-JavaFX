// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

@Component
public class RegisztralasKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	private KonditeremVo regisztraltKonditerem;

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
	private ImageView konditeremneveJoRossz;

	@FXML
	private ImageView felhasznalonevJoRossz;

	@FXML
	private ImageView jelszoJoRossz;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void regisztralas(ActionEvent event) throws Exception {

		boolean ok = true;
		regisztraciosUzenet.setFill(Color.RED);
		regisztraciosUzenet.setText("");

		if (konditeremnevBevitel.getText().length() == 0) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Konditerem nevének a megadása kötelező!\n");
			konditeremneveJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			ok = false;
		} else {
			konditeremneveJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (felhasznalonevBevitel.getText().length() == 0) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText()
					+ "A felhasználónév min. 5 karakter!\n Felhasználónév megadása kötelező!\n");
			felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			ok = false;
		}
		if (felhasznalonevBevitel.getText().length() > 0 && felhasznalonevBevitel.getText().length() < 5) {
			regisztraciosUzenet.setText(regisztraciosUzenet.getText()
					+ "A felhasználónév min. 5 karakter!\n A felhasználónév túl rövid!\n");
			felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			felhasznalonevBevitel.clear();
			ok = false;
		} else if (felhasznalonevBevitel.getText().length() >= 5) {
			felhasznalonevJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (jelszoBevitel.getText().length() == 0) {
			regisztraciosUzenet
					.setText(regisztraciosUzenet.getText() + "A jelszó min. 8 karakter!\n Jelszó megadása kötelező!\n");
			jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			ok = false;
		}

		if (jelszoBevitel.getText().length() > 0 && jelszoBevitel.getText().length() < 8) {
			regisztraciosUzenet
					.setText(regisztraciosUzenet.getText() + " A jelszó min. 8 karakter!\n A jelszó túl rövid!\n");
			jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			jelszoBevitel.clear();
			ok = false;
		} else if (jelszoBevitel.getText().length() >= 8) {
			jelszoJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (ok) {
			if (konditeremSzolgaltatas.keresFelhasznalonevet(felhasznalonevBevitel.getText()) != null) {
				regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Ilyen felhazsnáló már létezik");
				felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
				felhasznalonevBevitel.clear();
			} else {
				KonditeremVo uj = new KonditeremVo();
				uj.setKonditeremNeve(konditeremnevBevitel.getText());
				uj.setFelhasznalonev(felhasznalonevBevitel.getText());
				uj.setJelszo(jelszoBevitel.getText());
				uj.setRegisztralasDatuma(LocalDate.now());
				konditeremSzolgaltatas.konditeremetLetrehoz(uj);
				KonditeremVo letrehozott = konditeremSzolgaltatas
						.keresFelhasznalonevet(felhasznalonevBevitel.getText());
				regisztraltKonditerem = letrehozott;
				FeluletBetoltese.KonditeremElerhetosegFelulet(event);
			}
		}
	}

	@FXML
	public void vissza(ActionEvent event) throws IOException {
		FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
	}

	public KonditeremVo getRegisztraltKonditerem() {
		return regisztraltKonditerem;
	}

	public void setRegisztraltKonditerem(KonditeremVo regisztraltKonditerem) {
		this.regisztraltKonditerem = regisztraltKonditerem;
	}

}
