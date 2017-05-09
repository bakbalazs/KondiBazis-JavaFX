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

import javax.management.Notification;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
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

	Integer tagKora = 0;

	private LocalDate maiNap = LocalDate.now();

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
	private Button megseGomb;

	@FXML
	private ChoiceBox<String> berletValasztas;

	Boolean vanKep = false;

	@FXML
	ImageView vezeteknevEllenoriz;

	@FXML
	ImageView keresztnevEllenoriz;

	@FXML
	ImageView nemEllenoriz;

	@FXML
	ImageView szuldatumEllenoriz;

	@FXML
	ImageView varosEllenoriz;

	@FXML
	ImageView megyeEllenoriz;

	@FXML
	ImageView berletvalasztasEllenoriz;

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
		
		varosBevitel.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				
			}
		});

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
			vanKep = true;
			tallozasGomb.setText("Módosítás");

		} else {
			// tagHozzaadasaUzenet.setFill(Color.RED);
			// tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");

			kepMegjelenites.setImage(nincsKep);
			vanKep = false;
			tallozasGomb.setText("Tallózás");
		}

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
			vanKep = true;
		} else {
			// tagHozzaadasaUzenet.setFill(Color.RED);
			// tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");

			vanKep = false;
			kepMegjelenites.setImage(nincsKep);
			tallozasGomb.setText("Tallózás");
		}
	}

	@FXML
	public void kepTorlese(ActionEvent event) {
		kepMegjelenites.setImage(nincsKep);
		tallozasGomb.setText("Tallózás");
		vanKep = false;
	}

	@FXML
	public void hozzaadas(ActionEvent event) throws IOException {

		boolean mehet = false;
		boolean kotelezo = false;

		if (vezeteknevBevitel.getText().equals("")) {
			vezeteknevEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
			mehet = false;
			kotelezo = true;
		} else {
			vezeteknevEllenoriz.setImage(FeluletBetoltese.joBeirt);
			mehet = true;
		}

		if (keresztnevBevitel.getText().equals("")) {
			keresztnevEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
			mehet = false;
			kotelezo = true;
		} else {
			keresztnevEllenoriz.setImage(FeluletBetoltese.joBeirt);
			mehet = true;
		}

		if (!ferfiValasztasGomb.isSelected() && !noValasztasGomb.isSelected()) {
			nemEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
			mehet = false;
			kotelezo = true;
		} else if (ferfiValasztasGomb.isSelected() || noValasztasGomb.isSelected()) {
			nemEllenoriz.setImage(FeluletBetoltese.joBeirt);
			mehet = true;

		}

		if (szuldatumBevitel.getValue() == null) {
			szuldatumEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
			mehet = false;
			kotelezo = true;
		} else {
			tagKora = korSzamolas(szuldatumBevitel.getValue());
			szuldatumEllenoriz.setImage(FeluletBetoltese.joBeirt);
			mehet = true;
		}

		if (berletValasztas.getValue() == null) {
			berletvalasztasEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
			mehet = false;
			kotelezo = true;
		} else {
			berletvalasztasEllenoriz.setImage(FeluletBetoltese.joBeirt);
			mehet = true;
		}

		if (kotelezo == true) {
			mehet = false;
		} else if (mehet) {

			KonditeremTagVo ujTag = new KonditeremTagVo();
			ujTag.setTagNeve(vezeteknevBevitel.getText() + " " + keresztnevBevitel.getText());
			ujTag.setTagVezeteknev(vezeteknevBevitel.getText());
			ujTag.setTagKeresztnev(keresztnevBevitel.getText());
			ujTag.setTagNeme(nemValasztas());
			ujTag.setTagSzuletesidatuma(szuldatumBevitel.getValue());
			ujTag.setTagKora(tagKora);
			ujTag.setBerletVasarlasideje(maiNap);
			ujTag.setVasaroltBerletNeve(berletValasztas.getValue());

			if (vanKep == true) {
				ujTag.setTagKep(kepByte);
			} else {
				ujTag.setTagKep(nincsKep());
			}

			KonditeremTagVo letezo = konditeremTagSzolgaltatas.leterehozTagot(ujTag);

			bejelentkezettKonditerem.getKonditeremTagok().add(letezo);

			konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

			letezo.setKonditerem(bejelentkezettKonditerem);

			konditeremTagSzolgaltatas.frissitKonditeremTagot(letezo);

			Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
			Notifications n = Notifications.create().title("Tag Hozzáadása").text("A tag sikeresen hozzáadva!")
					.graphic(new ImageView(pipa)).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT)
					.onAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							System.out.println("Értesítést bezárták");

						}
					});
			foAblakKezelo.adatFrissites();
			((Stage) megseGomb.getScene().getWindow()).close();
			n.show();

		}

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

	}

	private int korSzamolas(LocalDate szuletesiDatum) {
		int kor = (int) ChronoUnit.YEARS.between(szuletesiDatum, maiNap);
		return kor;
	}

	public String nemValasztas() {
		String tagNeme = null;
		if (ferfiValasztasGomb.isSelected()) {
			tagNeme = "Férfi";
		} else if (noValasztasGomb.isSelected()) {
			tagNeme = "Nő";
		}

		return tagNeme;

	}

	public byte[] nincsKep() throws IOException {

		File f = new File("src/main/resources/kepek/nincsKep.png");
		new Image(f.toURI().toString(), 195, 285, false, false);
		byte[] kep = new byte[(int) f.length()];
		FileInputStream fileInputStream = new FileInputStream(f);
		fileInputStream.read(kep);
		fileInputStream.close();
		return kep;

	}

	public KonditeremVo getBejelentkezettKonditerem() {
		return bejelentkezettKonditerem;
	}

}
