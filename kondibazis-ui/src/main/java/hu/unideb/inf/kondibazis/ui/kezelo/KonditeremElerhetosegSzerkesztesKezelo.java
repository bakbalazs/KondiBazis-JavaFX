// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class KonditeremElerhetosegSzerkesztesKezelo implements Initializable {

	private static String bejelentkezesUzenet;

	private static String felhasznalo;


	private KonditeremVo bejelentkezettKonditerem;

	@Autowired
	private KondiBazisFoAblakKezelo foAblakKezelo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();

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
