// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

@Component
public class TagHozzaadasaKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

	@Autowired
	private KonditeremTagSzolgaltatas konditeremTagSzolgaltatas;

	@Autowired
	private KondiBazisFoAblakKezelo foAblakKezelo;

	private Image nincsKep = new Image("/kepek/nincsKep.png");

	private FileChooser kepValaszto = new FileChooser();

	private File kivalasztottKep;

	private String nemValasztas;

	private LocalDate maiNap = LocalDate.now();

	private int kor;

	private byte[] kepByte;

	private KonditeremVo bejelentkezettKonditerem;

	@FXML
	private ImageView kepMegjelenites;

	@FXML
	private ToggleGroup nemek;

	@FXML
	private Text konditeremNeve;

	@FXML
	private Text tagHozzaadasUzenet;

	@FXML
	private RadioButton ferfiValasztasGomb;

	@FXML
	private RadioButton noValasztasGomb;

	@FXML
	private TextField megyeBevitel;

	@FXML
	private TextField varosBevitel;

	@FXML
	private Text beiratkozasBevitel;

	@FXML
	private DatePicker szuldatumBevitel;

	@FXML
	private TextField keresztnevBevitel;

	@FXML
	private TextField vezeteknevBevitel;

	@FXML
	private Button tallozasGomb;

	@FXML
	private ChoiceBox<String> berletValasztas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kepMegjelenites.setImage(nincsKep);
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
		konditeremNeve.setText(foAblakKezelo.getBejelentkezettKonditerem().getKonditeremNeve());

		beiratkozasBevitel.setText(maiNap.toString());

		tallozasGomb.setText("Tallózás");

		List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
				.konditeremOsszesBerlete(bejelentkezettKonditerem);
		for (KonditeremBerletVo berletek : konditeremBerletek) {
			berletValasztas.getItems().add(berletek.getBerletNeve());
		}

		
	}

	@FXML
	public void hozzaadas(ActionEvent event) throws IOException {

		System.out.println(berletValasztas.getValue());

		// KonditeremTagVo uj = new KonditeremTagVo();
		//// uj.setTagKep(nincsKep());
		//
		// KonditeremTagVo letezo =
		// konditeremTagSzolgaltatas.leterehozTagot(uj);
		//
		// bejelentkezettKonditerem.getKonditeremTagok().add(letezo);
		//
		// konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);
		//
		// letezo.setKonditerem(bejelentkezettKonditerem);
		//
		// konditeremTagSzolgaltatas.frissitKonditeremTagot(letezo);

	}

	// @FXML
	// public void hozzaadas(ActionEvent event) {
	//
	// boolean mehet = true;
	//
	// if (vezeteknevBevitel.getText().equals("")) {
	// mehet = false;
	// }
	//
	// if (keresztnevBevitel.getText().equals("")) {
	// mehet = false;
	// }
	//
	// if (!ferfiValasztasGomb.isSelected() && !noValasztasGomb.isSelected()) {
	// mehet = false;
	// }
	//
	// if (ferfiValasztasGomb.isSelected() || noValasztasGomb.isSelected()) {
	// mehet = true;
	// }
	//
	// if (szuldatumBevitel.getValue() == null) {
	// mehet = false;
	// }
	//
	// if (varosBevitel.getText().equals("")) {
	// mehet = false;
	// }
	//
	// if (megyeBevitel.getText().equals("")) {
	// mehet = false;
	// }
	//
	// if (beiratkozasBevitel.getValue() == null) {
	// mehet = false;
	// }
	//
	// if (mehet) {
	// KonditeremTagVo ujTag = new KonditeremTagVo();
	// ujTag.setTagVezeteknev(vezeteknevBevitel.getText());
	// ujTag.setTagKeresztnev(keresztnevBevitel.getText());
	// ujTag.setTagNeme(getNemValasztas());
	// ujTag.setTagSzuletesidatuma(szuldatumBevitel.getValue());
	// ujTag.setTagKora(getKor());
	// ujTag.setTagVarosa(varosBevitel.getText());
	// ujTag.setTagMegyeje(megyeBevitel.getText());
	// ujTag.setBerletVasarlasideje(beiratkozasBevitel.getValue());
	// // bérletkiválasztás fontos még ehez bérletfelület és bérlettábal
	// // nincsKep();
	// ujTag.setTagKep(kepByte);
	// // képet még visza kell nyerni
	// //
	// // KonditeremTagVo letezo =
	// // konditeremTagSzolgaltatas.leterehozTagot(ujTag);
	// //
	// // bejelentkezettKonditerem.getKonditeremTagok().add(letezo);
	// //
	// // konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);
	// //
	// // letezo.setKonditerem(bejelentkezettKonditerem);
	// //
	// // konditeremTagSzolgaltatas.frissitKonditeremTagot(letezo);
	//
	// }
	//
	// }

	@FXML
	public void ferfiValasztas(ActionEvent event) {
		setNemValasztas(ferfiValasztasGomb.getText());
	}

	@FXML
	public void noValasztas(ActionEvent event) {
		setNemValasztas(noValasztasGomb.getText());
	}

	@FXML
	public void tallozas(ActionEvent event) throws IOException {
		kepValaszto.getExtensionFilters().addAll(new ExtensionFilter("Image Files (*.png , *.jpg)", "*.png", "*.jpg"));
		kivalasztottKep = kepValaszto.showOpenDialog(null);

		if (kivalasztottKep != null) {
			Image image = new Image(kivalasztottKep.toURI().toString(), 195, 185, false, false);
			kepByte = new byte[(int) kivalasztottKep.length()];
			FileInputStream fileInputStream = new FileInputStream(kivalasztottKep);
			fileInputStream.read(kepByte);
			fileInputStream.close();

			kepMegjelenites.setImage(image);
			tallozasGomb.setText("Módosítás");

		} else {
			// tagHozzaadasaUzenet.setFill(Color.RED);
			// tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");

			kepMegjelenites.setImage(nincsKep);
			tallozasGomb.setText("Tallózás");
		}

	}
	//
	// public byte[] nincsKep() throws IOException {
	// File fd = new File("/kepek/nincsKep.png");
	// Image kep = new Image(fd.toURI().toString(), 195, 185, false, false);
	// kepByte = new byte[(int) fd.length()];
	// FileInputStream fileInputStream = new FileInputStream(fd);
	// fileInputStream.read(kepByte);
	// fileInputStream.close();
	// return kepByte;
	// }

	@FXML
	public void szuldatumKivalaszt(ActionEvent event) {
		korSzamolas(szuldatumBevitel.getValue(), maiNap);
	}

	private void korSzamolas(LocalDate szuletesiDatum, LocalDate maiNap) {
		setKor((int) ChronoUnit.YEARS.between(szuletesiDatum, maiNap));
	}

	public String getNemValasztas() {
		return nemValasztas;
	}

	public void setNemValasztas(String nemValasztas) {
		this.nemValasztas = nemValasztas;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	@FXML
	public void beriratkozasKivalaszt(ActionEvent event) {
	}

	public KonditeremVo getBejelentkezettKonditerem() {
		return bejelentkezettKonditerem;
	}

	@FXML
	public void kepenTallozas(ActionEvent event) throws IOException {
		kepValaszto.getExtensionFilters().addAll(new ExtensionFilter("Image Files (*.png , *.jpg)", "*.png", "*.jpg"));
		kivalasztottKep = kepValaszto.showOpenDialog(null);

		if (kivalasztottKep != null) {
			Image image = new Image(kivalasztottKep.toURI().toString(), 195, 185, false, false);
			kepByte = new byte[(int) kivalasztottKep.length()];
			FileInputStream fileInputStream = new FileInputStream(kivalasztottKep);
			fileInputStream.read(kepByte);
			fileInputStream.close();

			kepMegjelenites.setImage(image);
			tallozasGomb.setText("Módosítás");
		} else {
			// tagHozzaadasaUzenet.setFill(Color.RED);
			// tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");

			kepMegjelenites.setImage(nincsKep);
			tallozasGomb.setText("Tallózás");
		}
	}

	@FXML
	public void kepTorlese(ActionEvent event) {
		kepMegjelenites.setImage(nincsKep);
		tallozasGomb.setText("Tallózás");
	}

}
