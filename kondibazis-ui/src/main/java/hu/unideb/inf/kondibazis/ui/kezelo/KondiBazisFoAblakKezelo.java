// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import hu.unideb.inf.kondibazis.ui.model.TagData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class KondiBazisFoAblakKezelo implements Initializable {

    private static Logger logolo = LoggerFactory.getLogger(KondiBazisFoAblakKezelo.class);

    @Autowired
    private BejelentkezoKezelo bejelentkezoKezelo;

    @Autowired
    private KonditeremTagSzolgaltatas konditeremtagSzolgaltatas;

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private Text konditeremNeve;

    @FXML
    private Text tagokSzama;

    @FXML
    private Text regisztralasDatuma;

    private ObservableList<TagData> tagTablazatAdatok;

    @FXML
    private TableView<TagData> tagokTabla;

    @FXML
    private TableColumn<TagData, String> nevOszlop;

    @FXML
    private TableColumn<TagData, String> vezeteknevOszlop;

    @FXML
    private TableColumn<TagData, String> keresztnevOszlop;

    @FXML
    private TableColumn<TagData, String> nemOszlop;

    @FXML
    private TableColumn<TagData, String> korOszlop;

    @FXML
    private TableColumn<TagData, String> berletNeveOszlop;

    @FXML
    private TableColumn<TagData, String> berletVasarlasOszlop;

    @FXML
    private TableColumn<TagData, String> berletLejrataOszlop;

    @FXML
    private Button berletModositasGomb;

    @FXML
    private Button tagHozzaadasaGomb;

    @FXML
    private RadioButton osszesTagGomb;

    @FXML
    private Tab szuresEskereses;

    @FXML
    private Tab tagModositas;

    private boolean lejart = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tagModositasTabGombElrejtes();

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
        tagTablazatAdatok = FXCollections.observableArrayList();

        gombFrissites();
        adatFrissites();

        konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
        regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());

    }

    @FXML
    public void elerhetoseg(ActionEvent event) {
        logolo.info("Elérhetőség gombra kattintva.");
        FeluletBetoltese.KonditeremElerhetosegSzekeszteseFelulet(event);
    }

    @FXML
    public void berletekLetrehozasa(ActionEvent event) {
        logolo.info("Bérletek létrehozása gombra kattintva.");
        FeluletBetoltese.BerletLetrehozasaFelulet(event);
    }

    @FXML
    public void berletekModositasa(ActionEvent event) {
        logolo.info("Bérletek módosítása gombra kattintva.");
        FeluletBetoltese.BerletekModositasaFelulet(event);
    }

    @FXML
    public void tagHozzaadasa(ActionEvent event) {
        logolo.info("Tag Hozzáadása gombra kattintva.");
        FeluletBetoltese.TagHozzaadasaFelulet(event);
    }

    @FXML
    public void kijelentkezes() {

        logolo.info("Kijeletkezés gomb megnyomva.");

        if (kijeletkezesMegerositesFelulet("Kijeletkezés megerősítő ablak", "Kijeletkezés megerősítés.", "Biztosan ki akar jelentkeztni?", Alert.AlertType.CONFIRMATION) == true) {
            logolo.info("Sikeres kijeletkezés.");
            bejelentkezettKonditerem = null;
            tagokTabla = null;
            Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
            Notifications ertesites = Notifications.create().title("Kijeletkezés").text("Sikeres kijeletkezés.")
                    .graphic(new ImageView(pipa))
                    .hideAfter(Duration.seconds(2)).position(Pos.BOTTOM_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            logolo.info("Az értesítésre kattintottak.");
                        }
                    });

            FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
            ertesites.show();

        } else {
            logolo.info("Nem történt kijeletkezés.");
        }
    }

    @FXML
    public void bezaras(ActionEvent event) {
        logolo.info("Bezárás menüre kattintva.");
        SpringFxmlLoader.close();
        Platform.exit();
    }

    @FXML
    public void varosStatisztika(ActionEvent event) {
        FeluletBetoltese.VarosStatisztikaFelulet(event);
    }


    @FXML
    public void lejartBerletuTagok() {

        FilteredList<TagData> filter = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        filter.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Nő")) {
                return true;
            }
            return false;
        });
        logolo.info("Lejárt bérletű tagok mutatása.");
        tagokTabla.setItems(filter);
    }

    @FXML
    public void aktivBerletuTagok() {
        LocalDate a = LocalDate.of(2017, 3, 5);


        FilteredList<TagData> filter = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        filter.setPredicate(tag -> {
            if (!tag.getBerletLejaratiIdeje().toString().contains(a.toString())) {
                return true;
            }
            return false;
        });
        logolo.info("Aktív bérletes tagok mutatása.");
        tagokTabla.setItems(filter);
    }

    @FXML
    public void osszesTagKivalasztas() {
        osszesTag();
    }

    public boolean kijeletkezesMegerositesFelulet(String cim, String fejlec, String tartalom, Alert.AlertType alertType) {
        logolo.info("Kijeletkezés megerősítrése ablak.");
        final Alert alert = new Alert(alertType);
        alert.setTitle(cim);
        alert.setHeaderText(fejlec);
        alert.setContentText(tartalom);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(FeluletBetoltese.ikon);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

        Button yesButton = (Button) alert.getDialogPane().lookupButton(ButtonType.YES);
        yesButton.setText("Kijeletkezés");
        yesButton.setDefaultButton(false);

        Button noButton = (Button) alert.getDialogPane().lookupButton(ButtonType.NO);
        noButton.setText("Mégsem");
        noButton.setDefaultButton(true);

        final Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.YES;
    }

    public void gombFrissites() {

        logolo.debug("Gomgok frissítése ha törtét bérlet létrehozás.");

        List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                .konditeremOsszesBerlete(bejelentkezettKonditerem);

        if (konditeremBerletek.isEmpty()) {
            berletModositasGomb.setDisable(true);
            tagHozzaadasaGomb.setDisable(true);
        } else if (!konditeremBerletek.isEmpty()) {
            berletModositasGomb.setDisable(false);
            tagHozzaadasaGomb.setDisable(false);
        }
    }

    public void adatFrissites() {

        logolo.debug("Adatfrissítés.");

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        List<KonditeremTagVo> konditerem_tagjai = konditeremtagSzolgaltatas
                .konditeremOsszesTagja(bejelentkezettKonditerem);

        tagokSzama.setText(String.valueOf(konditerem_tagjai.size()));

        if (!tagTablazatAdatok.isEmpty()) {
            tagTablazatAdatok.clear();
        }

        logolo.debug("Tablazat feltoltese adatokkal: ");

        for (KonditeremTagVo konditeremTagVo : konditerem_tagjai) {

            tagTablazatAdatok.add(new TagData(
                            konditeremTagVo.getTagNeve(),
                            konditeremTagVo.getTagVezeteknev(),
                            konditeremTagVo.getTagKeresztnev(),
                            konditeremTagVo.getTagNeme(),
                            konditeremTagVo.getTagKora(),
                            konditeremTagVo.getVasaroltBerletNeve(),
                            konditeremTagVo.getBerletVasarlasideje(),
                            konditeremTagVo.getBerletLejaratiIdeje()
                    )
            );
            logolo.debug("Adat: " + tagTablazatAdatok.get(tagTablazatAdatok.size() - 1));
        }

        osszesTag();
//        LocalDate a = LocalDate.of(2017, 3, 5);
//
//        for (KonditeremTagVo konditeremTagVo : konditerem_tagjai) {
//
//            System.out.println("####################################################################################");
//            System.out.println(konditeremTagVo.getBerletLejaratiIdeje());
//            System.out.println(LocalDate.now());
//            System.out.println(a.toString());
//            System.out.println("####################################################################################");
//
//            if (konditeremTagVo.getBerletLejaratiIdeje().equals(a)) {
//                System.out.println("####################################################################################");
//                lejart = true;
//            }
//
//        }


    }

    public void osszesTag() {

        osszesTagGomb.setSelected(true);

        nevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagNeveProperty());

        vezeteknevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagVezetekneveProperty());

        keresztnevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagKeresztneveProperty());

        nemOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagNemeProperty());

        korOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagKoraProperty());

        berletVasarlasOszlop.setCellValueFactory(celldata -> celldata.getValue().getBerletVasarlasIdejeProperty());

        berletLejrataOszlop.setCellValueFactory(celldata -> celldata.getValue().getBerletLejaratiIdejeProperty());

        berletNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().getVasaroltBerletNeveProperty());

        logolo.debug("Összes tag megjelenítése.");

        tagokTabla.setItems(tagTablazatAdatok);
    }

    public void tagModositasTabGombElrejtes() {
           tagModositas.setDisable(true);
    }

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

    public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
        this.bejelentkezettKonditerem = bejelentkezettKonditerem;
    }

}
