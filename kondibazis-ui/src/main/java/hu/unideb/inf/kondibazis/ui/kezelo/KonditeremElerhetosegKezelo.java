package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

@Component
public class KonditeremElerhetosegKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private KonditeremElerhetosegSzolgaltatas konditeremElerhetosegSzolgaltatas;

	@Autowired
	private RegisztralasKezelo regisztralasKezelo;

	private KonditeremVo regisztraltKondi;

	@FXML
	private TextField megyeNeveBevitel;

	@FXML
	private TextField varosNeveBevitel;

	@FXML
	private TextField iranyitoszamBevitel;

	@FXML
	private TextField utcaNeveBevitel;

	@FXML
	private TextField hazSzamBevitel;

	@FXML
	private TextField emeletBevitel;

	@FXML
	private TextField ajtoBevitel;

	@FXML
	private TextField korzetSzamBevitel;

	@FXML
	private TextField haromSzamBevitel;

	@FXML
	private TextField negySzamBevitel;

	@FXML
	private TextField emailBevitel;

	@FXML
	private TextField weboldalBevitel;

	@FXML
	private TextField facebookBevitel;

	@FXML
	private Text regisztraltKonditerem;

	@FXML
	private Text elerhetosegHiba;

	@FXML
	private ImageView megyeJoRossz;

	@FXML
	private ImageView iranyitoszamJoRossz;

	@FXML
	private ImageView varosJoRossz;

	@FXML
	private ImageView utcaJoRossz;

	@FXML
	private ImageView hazSzamJoRossz;

	@FXML
	private ImageView emeletJoRossz;

	@FXML
	private ImageView ajtoJoRossz;

	@FXML
	private ImageView teloszamJoRossz;

	@FXML
	private ImageView emailJoRossz;

	@FXML
	private ImageView facebookJoRossz;

	private int iranyitoszam;

	private int hazSzam;

	private int emelet;

	private int ajto;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regisztraltKondi = regisztralasKezelo.getRegisztraltKonditerem();
		regisztraltKonditerem.setText(regisztraltKondi.getKonditeremNeve());
		iranyitoszamBevitel.setText("0000");
		hazSzamBevitel.setText("0");
		emeletBevitel.setText("0");
		ajtoBevitel.setText("0");
		emailBevitel.setText("nincs email");
		weboldalBevitel.setText("nincs weboldal");
		facebookBevitel.setText("nincs facebook oldal");

		System.out.println(regisztraltKondi);
	}

	@FXML
	public void mentes(ActionEvent event) {

		boolean mehet = true;
		boolean kotelezo = true;

		iranyitoszam = Integer.parseInt(iranyitoszamBevitel.getText());
		hazSzam = Integer.parseInt(hazSzamBevitel.getText());
		emelet = Integer.parseInt(emeletBevitel.getText());
		ajto = Integer.parseInt(ajtoBevitel.getText());

		if (megyeNeveBevitel.getText().equals("")) {
			mehet = false;
			kotelezo = false;
			megyeJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			elerhetosegHiba.setFill(Color.RED);
			elerhetosegHiba.setText("Megye megadása kötelező!\n");
		} else {
			elerhetosegHiba.setText("");
			megyeJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (iranyitoszamBevitel.getLength() == 4 && iranyitoszam > 0000) {
			mehet = true;
			iranyitoszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		} else if (iranyitoszamBevitel.getText().equals("") || iranyitoszamBevitel.getLength() < 4
				|| iranyitoszam == 0000) {
			mehet = false;
			kotelezo = false;
			elerhetosegHiba.setFill(Color.RED);
			elerhetosegHiba.setText("Irányítószám megadása kötelező!\n");
			iranyitoszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		}

		// if (varosNeveBevitel.getText().equals("")) {
		// mehet = false;
		// varosJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		// } else {
		// varosJoRossz.setImage(FeluletBetoltese.joBeirt);
		// }
		//
		// if (utcaNeveBevitel.getText().equals("")) {
		// mehet = false;
		// utcaJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		// } else {
		// utcaJoRossz.setImage(FeluletBetoltese.joBeirt);
		// }
		//
		// if (hazSzam > 0 || emelet > 0 || ajto > 0) {
		// mehet = true;
		// }
		//
		// if (!(korzetSzamBevitel.getLength() == 2)) {
		// mehet = false;
		// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		// }
		//
		// if (korzetSzamBevitel.getLength() == 2) {
		// mehet = true;
		// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		// }
		//
		// if (!(haromSzamBevitel.getLength() == 3)) {
		// mehet = false;
		// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		// }
		//
		// if (haromSzamBevitel.getLength() == 3) {
		// mehet = true;
		// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		// }
		//
		// if (!(negySzamBevitel.getLength() == 3) ||
		// !(negySzamBevitel.getLength() == 4)) {
		// mehet = false;
		// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		// }
		//
		// if (negySzamBevitel.getLength() == 3 ||
		// negySzamBevitel.getLength() == 4) {
		// mehet = true;
		// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		// }

		if (kotelezo == false) {
			elerhetosegHiba.setFill(Color.RED);
			elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
		} else {
			if (emailBevitel.getText().contains("@") || emailBevitel.getText().equals("nincs email")) {
				mehet = true;
				emailJoRossz.setImage(FeluletBetoltese.joBeirt);
			} else {
				mehet = false;
				emailJoRossz.setImage(FeluletBetoltese.rosszBeirt);

			}

			if (facebookBevitel.getText().contains("facebook")
					|| (facebookBevitel.getText().equals("nincs facebook oldal"))) {
				mehet = true;
				facebookJoRossz.setImage(FeluletBetoltese.joBeirt);
			} else {
				mehet = false;
				facebookJoRossz.setImage(FeluletBetoltese.rosszBeirt);
			}
		}

		if (mehet) {
			KonditeremElerhetosegVo ujElerhetoseg = new KonditeremElerhetosegVo();
			ujElerhetoseg.setMegyeNeve(megyeNeveBevitel.getText());
			ujElerhetoseg.setIranyitoSzam(iranyitoszam);
			ujElerhetoseg.setVarosNeve(varosNeveBevitel.getText());
			ujElerhetoseg.setUtcaNeve(utcaNeveBevitel.getText());
			ujElerhetoseg.setHazSzam(hazSzam);
			ujElerhetoseg.setEmelet(emelet);
			ujElerhetoseg.setAjto(ajto);
			ujElerhetoseg.setTelefonszam("+36-" + korzetSzamBevitel.getText() + "-" + haromSzamBevitel.getText() + "-"
					+ negySzamBevitel.getText());
			ujElerhetoseg.setEmailCim(emailBevitel.getText());
			ujElerhetoseg.setWeboldalLink(weboldalBevitel.getText());

			ujElerhetoseg.setFacebookOldalLink(facebookBevitel.getText());

			ujElerhetoseg.setKonditerem(regisztraltKondi);

			konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujElerhetoseg);

		}

	}

	@FXML
	public void megse(ActionEvent event) {
		FeluletBetoltese.BejelentkezoFelulet(event);
	}

}
