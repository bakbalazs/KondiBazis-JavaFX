// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

@Component
public class KondiBazisFoAblakKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private BejelentkezoKezelo bejelentkezoKezelo;

	private KonditeremVo bejelentkezettKonditerem;

	@FXML
	private Text konditeremNeve;

	@FXML
	private Text tagokSzama;

	@FXML
	private Text regisztralasDatuma;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
		regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());
		bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
	}

	@FXML
	public void elerhetoseg(ActionEvent event) {
		FeluletBetoltese.KonditeremElerhetosegSzekeszteseFelulet(event);
	}

	@FXML
	public void berletekLetrehozasa(ActionEvent event) {
		FeluletBetoltese.BerletLetrehozasaFelulet(event);
	}

	@FXML
	public void berletekModositasa(ActionEvent event) {
		FeluletBetoltese.BerletekModositasaFelulet(event);
	}

	@FXML
	public void tagHozzaadasa(ActionEvent event) {
		FeluletBetoltese.TagHozzaadasaFelulet(event);
	}

	@FXML
	public void kijelentkezes(ActionEvent event) {
	}

	@FXML
	public void bezaras(ActionEvent event) {
	}

	public KonditeremVo getBejelentkezettKonditerem() {
		return bejelentkezettKonditerem;
	}

	public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
		this.bejelentkezettKonditerem = bejelentkezettKonditerem;
	}

}
