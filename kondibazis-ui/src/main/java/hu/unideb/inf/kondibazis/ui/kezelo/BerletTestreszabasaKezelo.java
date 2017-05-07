// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
public class BerletTestreszabasaKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

	@Autowired
	private FoAblakKezelo foAblakKezelo;

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
	private TextField oraBevitel;

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
	
	private int ar;

	private int ora;

	private int nap;

	private int honap;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
		bejelentkezett_Konditerem.setText(bejelentkezettKonditerem.getKonditeremNeve());
		berletaraBevitel.setText("0");
		oraBevitel.setText("0");
		napBevitel.setText("0");
		honapBevitel.setText("0");
		
		
	}

	@FXML
	public void letrehozas(ActionEvent event) {

		boolean mehet = true;
		
		ar = Integer.parseInt(berletaraBevitel.getText());
		ora = Integer.parseInt(oraBevitel.getText());
		nap = Integer.parseInt(napBevitel.getText());
		honap = Integer.parseInt(honapBevitel.getText());
		
		if (berletnevBevitel.getText().equals("")) {
			mehet = false;
		}

		if (berletaraBevitel.getText().equals("")) {
			mehet = false;
		}
		
		if(ar == 0) {
			mehet = false;
		}

		if (ora == 0 || nap == 0 || honap == 0) {
			mehet = false;
		}
		
		if((ar > 0 && ora >0) || (ar > 0 && nap > 0) || (ar > 0 && honap > 0 )) {
			mehet = true;
		}

		if (berletaraBevitel.getText().equals("") || oraBevitel.getText().equals("") || napBevitel.getText().equals("")
				|| honapBevitel.getText().equals("")) {
			mehet = false;
		}

		if (mehet) {

			KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
			ujBerlet.setBerletNeve(berletnevBevitel.getText());

			ujBerlet.setBerletAra(ar);
			ujBerlet.setMennyiOra(ora);
			ujBerlet.setMennyiNap(nap);
			ujBerlet.setMennyiHonap(honap);

			KonditeremBerletVo letezo = konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);

			bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);

			konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

			letezo.setKonditerem(bejelentkezettKonditerem);

			konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);
		}

	}

	@FXML
	public void megse(ActionEvent event) throws IOException {
		((Stage)megseGomb.getScene().getWindow()).close();
	}

}
