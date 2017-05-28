// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import com.jfoenix.controls.JFXButton;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.model.ElerhetosegAdatok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class KonditeremElerhetosegeiKezelo implements Initializable {

    private static Logger logger = LoggerFactory.getLogger(KonditeremElerhetosegKezelo.class);

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private TableView<ElerhetosegAdatok> konditeremElerhetosegekTabla;

    private ObservableList<ElerhetosegAdatok> konditeremElerhetosegTablaAdatok;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> konditeremCimOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> telefonszamOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> telepulesNevOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> megyeNeveOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> emailCimOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> facebookOldalLinkOszlop;

    @FXML
    private TableColumn<ElerhetosegAdatok, String> weboldalLinkOszlop;

    @FXML
    private JFXButton megseGomb;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    @Autowired
    private KonditeremElerhetosegSzolgaltatas konditeremElerhetosegSzolgaltatas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();

        konditeremElerhetosegTablaAdatok = FXCollections.observableArrayList();

        adatFrissites();

        konditeremElerhetosegekTabla.getStylesheets().add("/css/tablakinezet.css");
    }

    @FXML
    private void elerhetosegHozzaadasa(ActionEvent event) {

    }

    @FXML
    private void megsem() {
        ((Stage) megseGomb.getScene().getWindow()).close();
        logger.debug("Megse gombra kattintva!");
    }

    private void adatFrissites() {

        logger.debug("Adatfrissites.");

        List<KonditeremElerhetosegVo> bejeletkezettTeremElerhetosegek = bejelentkezettKonditerem.getKonditeremElerhetosegek();

        if (!konditeremElerhetosegTablaAdatok.isEmpty()) {
            konditeremElerhetosegTablaAdatok.clear();
        }

        logger.debug("Tablazat feltoltese adatokkal: ");

        for (KonditeremElerhetosegVo konditeremElerhetoseg : bejeletkezettTeremElerhetosegek) {
            konditeremElerhetosegTablaAdatok.add(new ElerhetosegAdatok(
                    konditeremElerhetoseg.getId(),
                    konditeremElerhetoseg.getKonditeremVarosanakNeve(),
                    konditeremElerhetoseg.getKonditeremVarosanakMegyeje(),
                    konditeremElerhetoseg.getKonditeremCime(),
                    konditeremElerhetoseg.getKonditremTelefonszam(),
                    konditeremElerhetoseg.getKonditremEmailCim(),
                    konditeremElerhetoseg.getKonditeremFacebookOldalLink(),
                    konditeremElerhetoseg.getKonditeremWeboldalLink()
            ));

            logger.debug("Adat: " + konditeremElerhetosegTablaAdatok.get(konditeremElerhetosegTablaAdatok.size() - 1));
        }

        osszesAdat();
    }

    private void osszesAdat() {

        konditeremCimOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremCimeProperty());

        telefonszamOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremTelefonszamaProperty());

        telepulesNevOszlop.setCellValueFactory(celldata -> celldata.getValue().telepulesNevProperty());

        megyeNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().megyyeNevProperty());

        emailCimOszlop.setCellValueFactory(celldata -> celldata.getValue().emailCimProperty());

        facebookOldalLinkOszlop.setCellValueFactory(celldata -> celldata.getValue().facebookOldalLinkProperty());

        weboldalLinkOszlop.setCellValueFactory(celldata -> celldata.getValue().weboldalLinkProperty());

        konditeremElerhetosegekTabla.setItems(konditeremElerhetosegTablaAdatok);

    }


//	private static String bejelentkezesUzenet;
//
//	private static String felhasznalo;
//
//	@FXML
//	public void mentes(ActionEvent event) throws Exception {
//	}
//
//	@FXML
//	public void megse(ActionEvent event) {
//	}
//
//	public static String getBejelentkezesUzenet() {
//		return bejelentkezesUzenet;
//	}
//
//	public static void setBejelentkezesUzenet(String bejelentkezesUzenet) {
//		KonditeremElerhetosegSzerkesztesKezelo.bejelentkezesUzenet = bejelentkezesUzenet;
//	}
//
//	public static String getFelhasznalo() {
//		return felhasznalo;
//	}
//
//	public static void setFelhasznalo(String felhasznalo) {
//		KonditeremElerhetosegSzerkesztesKezelo.felhasznalo = felhasznalo;
//	}

}
