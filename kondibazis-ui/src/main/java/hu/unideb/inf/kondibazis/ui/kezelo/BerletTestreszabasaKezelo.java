// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

@Component
public class BerletTestreszabasaKezelo implements Initializable {

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
	private ChoiceBox<String> berletNeveValaszto;

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

	private Long kivalasztottBerletId;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
		bejelentkezett_Konditerem.setText(bejelentkezettKonditerem.getKonditeremNeve());
		berletaraBevitel.setText("0");
		oraBevitel.setText("0");
		napBevitel.setText("0");
		honapBevitel.setText("0");

		List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
				.konditeremOsszesBerlete(bejelentkezettKonditerem);
		for (KonditeremBerletVo berletek : konditeremBerletek) {
			berletNeveValaszto.getItems().add(berletek.getBerletNeve());

			ChangeListener<String> valtozasFigyelo = new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> megfigyelendo, String korabbi, String jelenlegi) {
					if (jelenlegi != null) {
						if (jelenlegi.equals(berletek.getBerletNeve())) {
							kivalasztottBerletId = berletek.getId();

							berletaraBevitel.setText(Integer.toString(berletek.getBerletAra()));
							oraBevitel.setText(Integer.toString(berletek.getMennyiOra()));
							napBevitel.setText(Integer.toString(berletek.getMennyiNap()));
							honapBevitel.setText(Integer.toString(berletek.getMennyiHonap()));
						}
					}
				}
			};

			berletNeveValaszto.getSelectionModel().selectedItemProperty().addListener(valtozasFigyelo);

		}

	}

	@FXML
	public void modositas(ActionEvent event) {

		boolean mehet = true;

		KonditeremBerletVo kivalasztottBerlet = konditeremBerletSzolgaltatas.keresBerletet(kivalasztottBerletId);

		kivalasztottBerlet.setBerletAra(Integer.parseInt(berletaraBevitel.getText()));
		kivalasztottBerlet.setMennyiHonap(Integer.parseInt(honapBevitel.getText()));
		kivalasztottBerlet.setMennyiNap(Integer.parseInt(napBevitel.getText()));
		kivalasztottBerlet.setMennyiOra(Integer.parseInt(oraBevitel.getText()));

		konditeremBerletSzolgaltatas.frissitKonditeremBerletet(kivalasztottBerlet);

		//

		//
		// // if (berletnevBevitel.getText().equals("")) {
		// // mehet = false;
		// // }
		//
		// if (berletaraBevitel.getText().equals("")) {
		// mehet = false;
		// }
		//
		// if (ar == 0) {
		// mehet = false;
		// }
		//
		// if (ora == 0 || nap == 0 || honap == 0) {
		// mehet = false;
		// }
		//
		// if ((ar > 0 && ora > 0) || (ar > 0 && nap > 0) || (ar > 0 && honap >
		// 0)) {
		// mehet = true;
		// }
		//
		// if (berletaraBevitel.getText().equals("") ||
		// oraBevitel.getText().equals("") || napBevitel.getText().equals("")
		// || honapBevitel.getText().equals("")) {
		// mehet = false;
		// }
		//
		// if (mehet) {
		//
		// KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
		//
		// ujBerlet.setBerletNeve(neve);
		// ujBerlet.setBerletAra(ar);
		// ujBerlet.setMennyiOra(ora);
		// ujBerlet.setMennyiNap(nap);
		// ujBerlet.setMennyiHonap(honap);
		//
		// KonditeremBerletVo letezo =
		// konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);
		//
		// // bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);
		//
		// //
		// konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);
		//
		// // letezo.setKonditerem(bejelentkezettKonditerem);
		//
		// konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);
		// }
		((Stage) megseGomb.getScene().getWindow()).close();
	}

	@FXML
	public void megse(ActionEvent event) throws IOException {
		((Stage) megseGomb.getScene().getWindow()).close();
	}

}
