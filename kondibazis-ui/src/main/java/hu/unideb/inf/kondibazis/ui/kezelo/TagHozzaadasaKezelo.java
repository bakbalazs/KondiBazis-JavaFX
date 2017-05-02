package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

@Component
public class TagHozzaadasaKezelo implements Initializable {

	private Image nincsKep = new Image("/kepek/nincsKep.png");

	private FileChooser kepValaszto = new FileChooser();

	private File kivalasztottKep;

	private KonditeremVo bejelentkezettKonditerem;

	private String nemValasztas;

	@Autowired
	BejelentkezoKezelo bejelentkezoKezelo;

	@FXML
	private ImageView kepMegjelenites;

	private byte[] kepByte;

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
	private Text valasztottBerlet;

	@FXML
	private TextField megyeBevitel;

	@FXML
	private TextField varosBevitel;

	@FXML
	private DatePicker beiratkozasBevitel;

	@FXML
	private DatePicker szuldatumBevitel;

	@FXML
	private TextField keresztnevBevitel;

	@FXML
	private TextField vezeteknevBevitel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kepMegjelenites.setImage(nincsKep);
		bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
		konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
		// System.out.println(bejelentkezettKonditerem);
	}
	
	@FXML
	public void hozzaadas(ActionEvent event) {
	}

	@FXML
	public void ferfiValasztas(ActionEvent event) {
		nemValasztas = ferfiValasztasGomb.getText();
	}

	@FXML
	public void noValasztas(ActionEvent event) {
		nemValasztas = ferfiValasztasGomb.getText();
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
		} else {
			// tagHozzaadasaUzenet.setFill(Color.RED);
			// tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");
			// imageV.setImage(nincskep);
		}

	}

	@FXML
	public void szuldatumKivalaszt(ActionEvent event) {
	}

	@FXML
	public void beiratkozasKivalaszt(ActionEvent event) {
	}

	@FXML
	public void beriratkozasKivalaszt(ActionEvent event) {
	}

	public void korSzamolas() {

	}

}
