// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@Component
public class BerletLetrehozasaKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

	@Autowired
	private KondiBazisFoAblakKezelo foAblakKezelo;

    private KonditeremVo bejelentkezettKonditerem;

	@FXML
	private Button letrehozasGomb;

	@FXML
	private Button megseGomb;

	@FXML
	private TextField berletnevBevitel;

	@FXML
	private TextField berletaraBevitel;

	@FXML
	private TextField napBevitel;

	@FXML
	private TextField honapBevitel;

	@FXML
	private Text letrehozasUzenet;

	@FXML
	private Text regisztraltKonditerem;

	@FXML
	private Text berletletrehozasUzenet;

	@FXML 
	private Text bejelentkezett_Konditerem;

	@FXML
	private ChoiceBox berlettipusValasztasa;

	@FXML
	private Text berletnevSzoveg;

	@FXML
	private Text berletaraSzoveg;

	@FXML
	private Text berletnapSzoveg;

	@FXML
	private Text berlethonapSzoveg;

	@FXML
	private Text ftJel;

	@FXML
	private TextField alakomBevitel;

	@FXML
	private Text alkalomSzoveg;

	private int ar;

	private int nap;

	private int honap;

	public void alaperket(boolean e) {
		berletnevSzoveg.setVisible(e);
		berletnevBevitel.setVisible(e);
		berletaraSzoveg.setVisible(e);
		berletaraBevitel.setVisible(e);
		ftJel.setVisible(e);
	}

	public void idokorlatosBerlet(boolean e) {
		berletnapSzoveg.setVisible(e);
		napBevitel.setVisible(e);
		berlethonapSzoveg.setVisible(e);
		honapBevitel.setVisible(e);
	}

	public void alkalmasBerlet(boolean e) {
		alakomBevitel.setVisible(e);
		alkalomSzoveg.setVisible(e);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idokorlatosBerlet(false);
		alkalmasBerlet(false);
		alaperket(false);
		berlettipusValasztasa.getItems().add("Alkalmas bérlet");
		berlettipusValasztasa.getItems().add("Időkorlátos bérlet");
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
		bejelentkezett_Konditerem.setText(bejelentkezettKonditerem.getKonditeremNeve());
		berletaraBevitel.setText("0");
		napBevitel.setText("0");
		honapBevitel.setText("0");


		berlettipusValasztasa.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				if (t1.equals("Alkalmas bérlet")) {
					alaperket(true);
					idokorlatosBerlet(false);
					alkalmasBerlet(true);

				} else if (t1.equals("Időkorlátos bérlet")) {
					alaperket(true);
					idokorlatosBerlet(true);
					alkalmasBerlet(false);
				}
			}
		});
		
		
	}

	@FXML
	public void letrehozas(ActionEvent event) {

//		boolean mehet = true;
//
//		ar = Integer.parseInt(berletaraBevitel.getText());
//		nap = Integer.parseInt(napBevitel.getText());
//		honap = Integer.parseInt(honapBevitel.getText());
//
//		if (berletnevBevitel.getText().equals("")) {
//			mehet = false;
//		}
//
//		if (berletaraBevitel.getText().equals("")) {
//			mehet = false;
//		}
//
//		if(ar == 0) {
//			mehet = false;
//		}
//
//		if (ora == 0 || nap == 0 || honap == 0) {
//			mehet = false;
//		}
//
//		if((ar > 0 && ora >0) || (ar > 0 && nap > 0) || (ar > 0 && honap > 0 )) {
//			mehet = true;
//		}
//
//		if (berletaraBevitel.getText().equals("") || napBevitel.getText().equals("")
//				|| honapBevitel.getText().equals("")) {
//			mehet = false;
//		}
//
//		if (mehet) {
//
//			KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
//			ujBerlet.setBerletNeve(berletnevBevitel.getText());
//
//			ujBerlet.setBerletAra(ar);
//			ujBerlet.setMennyiOra(ora);
//			ujBerlet.setMennyiNap(nap);
//			ujBerlet.setMennyiHonap(honap);
//
//			KonditeremBerletVo letezo = konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);
//
//			bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);
//
//			konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);
//
//			letezo.setKonditerem(bejelentkezettKonditerem);
//
//			konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);
//			foAblakKezelo.gombFrissites();
//			((Stage)megseGomb.getScene().getWindow()).close();
//		}

	}

	@FXML
	public void megse(ActionEvent event) throws IOException {
		((Stage)megseGomb.getScene().getWindow()).close();
	}



}
