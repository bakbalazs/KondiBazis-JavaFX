// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import hu.unideb.inf.kondibazis.ui.model.KonditeremAdatok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class RegisztraltKonditermekKezelo implements Initializable {

    private static Logger logger = LoggerFactory.getLogger(RegisztraltKonditermekKezelo.class);

    @FXML
    private TableView<KonditeremAdatok> konditeremAdatokTabla;

    private ObservableList<KonditeremAdatok> konditeremAdatokTablaAdatok;

    @FXML
    private TableColumn<KonditeremAdatok, String> konditeremNeveOszlop;

    @FXML
    private TableColumn<KonditeremAdatok, String> konditeremTelefonszamOszlop;

    @FXML
    private TableColumn<KonditeremAdatok, String> konditeremHelyeOszlop;

    @FXML
    private TableColumn<KonditeremAdatok, String> konditeremCimeOszlop;

    @FXML
    private TableColumn<KonditeremAdatok, String> konditeremTagjainakSzamaOszlop;

    @FXML
    private ImageView visszaGombKep;

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        konditeremAdatokTabla.setPlaceholder(new Text("Nincs regisztralt konditerem."));
        visszaGombKep.setImage(FeluletBetoltese.visszaGomb);
        konditeremAdatokTablaAdatok = FXCollections.observableArrayList();
        adatFrissites();
    }

    @FXML
    public void vissza() throws IOException {
        logger.debug("Indítása felulet indul.");
        FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
    }

    private void adatFrissites() {

        logger.debug("Adatfrissites.");

        List<KonditeremVo> osszesKonditerem = konditeremSzolgaltatas.osszesKonditerem();

        if (!konditeremAdatokTablaAdatok.isEmpty()) {
            konditeremAdatokTablaAdatok.clear();
        }


        logger.debug("Tablazat feltoltese adatokkal: ");

        /// HA NINCS EGY SEM AKKOR CSAK EGY ABALKA JÖJ BE HOGY NINCS REGISZTRÁLT TEREM TODO
        for (KonditeremVo konditerem : osszesKonditerem) {
            List<KonditeremElerhetosegVo> konditeremElerhetosegek = konditerem.getKonditeremElerhetosegek();
            for (KonditeremElerhetosegVo konditeremElerhetoseg : konditeremElerhetosegek) {
                konditeremAdatokTablaAdatok.add(new KonditeremAdatok(
                        konditerem.getId(),
                        konditerem.getKonditeremNeve(),
                        konditeremElerhetoseg.getKonditremTelefonszam(),
                        konditeremElerhetoseg.getKonditeremVarosanakNeve(),
                        konditeremElerhetoseg.getKonditeremCime(),
                        konditerem.getTagokSzama().toString()
                ));
            }
            logger.debug("Adat: " + konditeremAdatokTablaAdatok.get(konditeremAdatokTablaAdatok.size() - 1));
        }

        osszesAdat();
    }

    private void osszesAdat() {

        konditeremNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremNeveProperty());

        konditeremTelefonszamOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremTelefonszamaProperty());

        konditeremHelyeOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremHelyeProperty());

        konditeremCimeOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremCimeProperty());

        konditeremTagjainakSzamaOszlop.setCellValueFactory(celldata -> celldata.getValue().konditeremTagokSzamaProperty());

        konditeremAdatokTabla.setItems(konditeremAdatokTablaAdatok);

    }
}
