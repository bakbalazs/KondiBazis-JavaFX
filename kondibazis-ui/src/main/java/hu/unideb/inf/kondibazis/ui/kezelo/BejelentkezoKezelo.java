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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

@Component
public class BejelentkezoKezelo implements Initializable {

	@Autowired
	KonditeremSzolgaltatas konditeremSzolgaltatas;

	private static String bejelentkezettKonditeremNeve;

	@FXML
	private TextField felhasznalonevBevitel;

	@FXML
	private PasswordField jelszoBevitel;

	@FXML
	private Text bejelentkezoUzenet;

	@FXML
	private Button visszaGomb;

	@FXML
	private ImageView felhasznalonevJoRossz;

	@FXML
	private ImageView jelszoJoRossz;

	@FXML
	public void bejelentkezes(ActionEvent event) throws IOException {

		KonditeremVo konditerem = konditeremSzolgaltatas.keresFelhasznalonevet(felhasznalonevBevitel.getText());

		if (konditerem == null) {
			bejelentkezoUzenet.setText("Nincs ilyen nevű felhasználó!");
			felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			felhasznalonevBevitel.clear();
			jelszoBevitel.clear();
		} else {
			if (konditerem.getJelszo().equals(jelszoBevitel.getText())) {
				setBejelentkezettKonditeremNeve(konditerem.getKonditeremNeve());
				FeluletBetoltese.FoAblakFelulet(event);
			} else {
				bejelentkezoUzenet.setText("Helytelen jelszó!");
				jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
				jelszoBevitel.clear();
			}
		}

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

	public static String getBejelentkezettKonditeremNeve() {
		return bejelentkezettKonditeremNeve;
	}

	public static void setBejelentkezettKonditeremNeve(String bejelentkezettKonditeremNeve) {
		BejelentkezoKezelo.bejelentkezettKonditeremNeve = bejelentkezettKonditeremNeve;

	}

}
