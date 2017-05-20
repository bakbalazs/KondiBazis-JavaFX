// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.bevitel.szolg.NumberTextFieldIranyitoszam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class KonditeremElerhetosegSzerkesztesKezelo implements Initializable {

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

	private KonditeremVo bejelentkezettKonditerem;

	@Autowired
	private KondiBazisFoAblakKezelo foAblakKezelo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();

		KonditeremElerhetosegVo konditeremElerhetosegVo =konditeremElerhetosegSzolgaltatas.keresElerhetoseget(bejelentkezettKonditerem);

//		iranyitoszamBevitel.setText(konditeremElerhetosegVo.getIranyitoSzam().toString());
//		megyeNeveBevitel.setText(konditeremElerhetosegVo.getMegyeNeve());
//		varosNeveBevitel.setText(konditeremElerhetosegVo.getVarosNeve());
//		utcaNeveBevitel.setText(konditeremElerhetosegVo.getUtcaNeve());
//		hazSzamBevitel.setText(konditeremElerhetosegVo.getHazSzam().toString());
//		emeletBevitel.setText(konditeremElerhetosegVo.getEmelet().toString());
//		ajtoBevitel.setText(konditeremElerhetosegVo.getAjto());
//
//		emailBevitel.setText(konditeremElerhetosegVo.getEmailCim());
//		weboldalBevitel.setText(konditeremElerhetosegVo.getWeboldalLink());
//		facebookBevitel.setText(konditeremElerhetosegVo.getFacebookOldalLink());
	}

	@FXML
	public void mentes(ActionEvent event) throws Exception {
	}

	@FXML
	public void megse(ActionEvent event) {
	}

	public static String getBejelentkezesUzenet() {
		return bejelentkezesUzenet;
	}

	public static void setBejelentkezesUzenet(String bejelentkezesUzenet) {
		KonditeremElerhetosegSzerkesztesKezelo.bejelentkezesUzenet = bejelentkezesUzenet;
	}

	public static String getFelhasznalo() {
		return felhasznalo;
	}

	public static void setFelhasznalo(String felhasznalo) {
		KonditeremElerhetosegSzerkesztesKezelo.felhasznalo = felhasznalo;
	}

}
