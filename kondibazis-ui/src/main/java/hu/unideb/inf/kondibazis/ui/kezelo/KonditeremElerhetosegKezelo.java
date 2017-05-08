// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.kontener.TartalomBetoltese;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;
import hu.unideb.inf.kondibazis.ui.bevitel.szam.NumberTextFieldIranyitoszam;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

@Component
public class KonditeremElerhetosegKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private KonditeremElerhetosegSzolgaltatas konditeremElerhetosegSzolgaltatas;

	@Autowired
	private TelepulesekSzolgaltatas telepulesekSzolgaltatas;

	@Autowired
	private RegisztralasKezelo regisztralasKezelo;

	private KonditeremVo regisztraltKondi;

	@FXML
	private TextField megyeNeveBevitel;

	@FXML
	private TextField varosNeveBevitel;

	@FXML
	private NumberTextFieldIranyitoszam iranyitoszamBevitel;

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

	private static String bejelentkezesUzenet;

	private static String felhasznalo;

	private int hazSzam;

	private int emelet;

	private boolean kotelezo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regisztraltKondi = regisztralasKezelo.getRegisztraltKonditerem();
		regisztraltKonditerem.setFill(Color.GREEN);
		regisztraltKonditerem.setText("Sikeresen regisztrált konditerm: " + regisztraltKondi.getKonditeremNeve());

		iranyitoszamBevitel.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {

				if (iranyitoszamBevitel.getLength() == 4) {
					int iranyitoszamBeir = Integer.parseInt(iranyitoszamBevitel.getText());
					TelepulesekVo ta = telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir);
					kotelezo = false;
					if (telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir) == null) {
						megyeNeveBevitel.setText("");
						varosNeveBevitel.setText("");
						elerhetosegHiba.setText("A megadott irányítószám nem létezik!\n");
						kotelezo = false;
					} else if (ta.getTelepulesnev() != null) {
						megyeNeveBevitel.setText(ta.getMegye());
						varosNeveBevitel.setText(ta.getTelepulesnev());
						kotelezo = true;
					}
				} else if (iranyitoszamBevitel.getText().equals("")) {
					megyeNeveBevitel.setText("");
					varosNeveBevitel.setText("");
					elerhetosegHiba.setText("Nincs megadva irányítószám!\n");
					kotelezo = false;
				}

			}
		});
	}

	@FXML
	public void mentes(ActionEvent event) throws Exception {
		boolean mehet = true;

		hazSzam = Integer.parseInt(hazSzamBevitel.getText());
		// emelet = Integer.parseInt(emeletBevitel.getText());

		if (!(korzetSzamBevitel.getLength() == 2)) {
			mehet = false;
			kotelezo = false;
			// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		}

		if (korzetSzamBevitel.getLength() == 2) {
			mehet = true;
			kotelezo = true;
			// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (!(haromSzamBevitel.getLength() == 3)) {
			mehet = false;
			kotelezo = false;
			// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		}

		if (haromSzamBevitel.getLength() == 3) {
			mehet = true;
			kotelezo = true;
			// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (!(negySzamBevitel.getLength() == 3) || !(negySzamBevitel.getLength() == 4)) {
			mehet = false;
			kotelezo = false;
			// teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
		}

		if (negySzamBevitel.getLength() == 3 || negySzamBevitel.getLength() == 4) {
			mehet = true;
			kotelezo = true;
			// teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
		}

		if (kotelezo == false) {
			mehet = false;
			elerhetosegHiba.setText("Nem sikerült");
		} else if (utcaNeveBevitel.getText().equals("")) {
			mehet = false;
			elerhetosegHiba.setText("Nem sikerült");
		} else if (hazSzamBevitel.getText().equals("")) {
			mehet = false;
			elerhetosegHiba.setText("Nem sikerült");
		} else {
			mehet = true;
		}

		if (kotelezo == false) {
			elerhetosegHiba.setFill(Color.RED);
			elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
		} else {
			if (emailBevitel.getText().contains("@") || emailBevitel.getText().equals("")) {
				mehet = true;
				emailJoRossz.setImage(TartalomBetoltese.joBeirt);
			} else {
				mehet = false;
				elerhetosegHiba.setText("Nme szerepel az emailcímben a @ ");
				emailJoRossz.setImage(TartalomBetoltese.rosszBeirt);

			}

			if (facebookBevitel.getText().contains("facebook") || (facebookBevitel.getText().equals(""))) {
				mehet = true;
				facebookJoRossz.setImage(TartalomBetoltese.joBeirt);
			} else {
				mehet = false;
				elerhetosegHiba.setText("A facebook szó nem szerepel a linkben.");
				facebookJoRossz.setImage(TartalomBetoltese.rosszBeirt);
			}
		}

		if (mehet) {
			KonditeremElerhetosegVo ujElerhetoseg = new KonditeremElerhetosegVo();
			ujElerhetoseg.setMegyeNeve(megyeNeveBevitel.getText());
			ujElerhetoseg.setIranyitoSzam(Integer.parseInt(iranyitoszamBevitel.getText()));
			ujElerhetoseg.setVarosNeve(varosNeveBevitel.getText());
			ujElerhetoseg.setUtcaNeve(utcaNeveBevitel.getText());
			ujElerhetoseg.setHazSzam(hazSzam);
			ujElerhetoseg.setEmelet(emelet);
			ujElerhetoseg.setAjto(ajtoBevitel.getText());
			ujElerhetoseg.setTelefonszam("+36-" + korzetSzamBevitel.getText() + "-" + haromSzamBevitel.getText() + "-"
					+ negySzamBevitel.getText());
			ujElerhetoseg.setEmailCim(emailBevitel.getText());
			ujElerhetoseg.setWeboldalLink(weboldalBevitel.getText());
			ujElerhetoseg.setFacebookOldalLink(facebookBevitel.getText());

			ujElerhetoseg.setKonditerem(regisztraltKondi);

			konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujElerhetoseg);
			
			setBejelentkezesUzenet("Kérem jeletkezzen be a felhasználóval: " + regisztraltKondi.getFelhasznalonev() + "\n");
			setBejelentkezesUzenet("Elérhetőség sikeresen hozzáadva!");
			setFelhasznalo(regisztraltKondi.getFelhasznalonev());
			FeluletBetoltese.BejelentkezoFelulet(event);

		}

	}

	@FXML
	public void kihagyas(ActionEvent event) {

		KonditeremElerhetosegVo kihagyasElerhetoseg = new KonditeremElerhetosegVo();
		kihagyasElerhetoseg.setIranyitoSzam(0000);
		kihagyasElerhetoseg.setMegyeNeve("nincs megadva");
		kihagyasElerhetoseg.setVarosNeve("nincs megadva");
		kihagyasElerhetoseg.setUtcaNeve("nincs megadva");
		kihagyasElerhetoseg.setHazSzam(0);
		kihagyasElerhetoseg.setEmelet(0);
		kihagyasElerhetoseg.setAjto("nincs megadva");
		kihagyasElerhetoseg.setTelefonszam("nincs megadva");
		kihagyasElerhetoseg.setEmailCim("nincs megadva");
		kihagyasElerhetoseg.setFacebookOldalLink("nincs megadva");
		kihagyasElerhetoseg.setKonditerem(regisztraltKondi);

		setBejelentkezesUzenet("Kérem jeletkezzen be a felhasználóval: " + regisztraltKondi.getFelhasznalonev());
		setFelhasznalo(regisztraltKondi.getFelhasznalonev());
		FeluletBetoltese.BejelentkezoFelulet(event);
	}

	public static String getBejelentkezesUzenet() {
		return bejelentkezesUzenet;
	}

	public static void setBejelentkezesUzenet(String bejelentkezesUzenet) {
		KonditeremElerhetosegKezelo.bejelentkezesUzenet = bejelentkezesUzenet;
	}

	public static String getFelhasznalo() {
		return felhasznalo;
	}

	public static void setFelhasznalo(String felhasznalo) {
		KonditeremElerhetosegKezelo.felhasznalo = felhasznalo;
	}

}
