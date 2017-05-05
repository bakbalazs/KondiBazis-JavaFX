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
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

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
	private TextField emailBevitel;

	@FXML
	private TextField facebookBevitel;

	@FXML
	private TextField weboldalBevitel;

	@FXML
	private Text regisztraltKonditerem;
	
	@FXML
	private TextField korzetSzamBevitel;

	@FXML
	private TextField haromSzamBevitel;

	@FXML
	private TextField negySzamBevitel;

	@FXML
	private ImageView megyeJoRossz;

	private int iranyitoszam;

	private int hazSzam;

	private int emelet;

	private int ajto;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regisztraltKondi = regisztralasKezelo.getRegisztraltKonditerem();
		regisztraltKonditerem.setText(regisztraltKondi.getKonditeremNeve());
		hazSzamBevitel.setText("0");
		emeletBevitel.setText("0");
		ajtoBevitel.setText("0");
		weboldalBevitel.setText(" ");
	}

	@FXML
	public void mentes(ActionEvent event) {

		iranyitoszam = Integer.parseInt(iranyitoszamBevitel.getText());
		hazSzam = Integer.parseInt(hazSzamBevitel.getText());
		emelet = Integer.parseInt(emeletBevitel.getText());
		ajto = Integer.parseInt(ajtoBevitel.getText());

		boolean mehet = true;

		if (megyeNeveBevitel.getText().equals("")) {
			mehet = false;
			megyeJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		}

		if (iranyitoszamBevitel.getText().equals("")) {
			mehet = false;
		}

		if (iranyitoszamBevitel.getLength() == 4) {
			mehet = true;
		}

		if (iranyitoszamBevitel.getLength() < 4) {
			mehet = false;
		}

		if (iranyitoszam > 0000) {
			mehet = true;
		}

		if (varosNeveBevitel.getText().equals("")) {
			mehet = false;
		}

		if (utcaNeveBevitel.getText().equals("")) {
			mehet = false;
		}

		if (hazSzam > 0 || emelet > 0 || ajto > 0) {
			mehet = true;
		}

		if (!(korzetSzamBevitel.getLength() == 2)) {
			mehet = false;
		}

		if (korzetSzamBevitel.getLength() == 2) {
			mehet = true;
		}

		if (!(haromSzamBevitel.getLength() == 3)) {
			mehet = false;
		}

		if (haromSzamBevitel.getLength() == 3) {
			mehet = true;
		}

		if (!(negySzamBevitel.getLength() == 3) || !(negySzamBevitel.getLength() == 4)) {
			mehet = false;
		}

		if (negySzamBevitel.getLength() == 3 || negySzamBevitel.getLength() == 4) {
			mehet = true;
		}

		if (!(emailBevitel.getText().contains("@"))) {
			mehet = false;
		}

		if (emailBevitel.getText().contains("@")) {
			mehet = true;
		}

		if (!(facebookBevitel.getText().contains("facebook"))) {
			mehet = false;
		}

		if (facebookBevitel.getText().contains("facebook")) {
			mehet = true;
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

			// ujElerhetoseg.setKonditerem(regisztraltKondi);

			// konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujElerhetoseg);
			// konditeremElerhetosegSzolgaltatas.frissitElerhetoseget(ujElerhetoseg);

			KonditeremElerhetosegVo letezo = konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujElerhetoseg);

			// letezo.setKonditerem(regisztraltKondi);
			// konditeremElerhetosegSzolgaltatas.frissitElerhetoseget(letezo);

		}

	}

	@FXML
	public void megse(ActionEvent event) {
		FeluletBetoltese.BejelentkezoFelulet(event);
	}

}
