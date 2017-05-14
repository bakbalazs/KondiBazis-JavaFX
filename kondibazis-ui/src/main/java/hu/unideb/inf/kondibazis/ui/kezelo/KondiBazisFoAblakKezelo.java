// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagKepeSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.kiegeszito.Ertesites;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import hu.unideb.inf.kondibazis.ui.model.TagData;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private KonditeremTagKepeSzolgaltatas konditeremtagkepeSzolgaltatas;

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private Text konditeremNeve;

    @FXML
    private Text tagokSzama;

    @FXML
    private Text regisztralasDatuma;

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
    private RadioButton osszesTagNemGomb;

    @FXML
    private RadioButton lejertberletGomb;

    @FXML
    private RadioButton aktivberletGomb;

    @FXML
    private RadioButton ferfiGomb;

    @FXML
    private RadioButton noGomb;

    @FXML
    private Tab szuresEskereses;

    @FXML
    private Tab tagModositas;

    @FXML
    private TextField keresesszovegBevitel;

    @FXML
    private ComboBox<String> valaszt;

    @FXML
    private CheckMenuItem szures;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField vezeteknevModosit;

    @FXML
    private TextField keresztnevModosit;

    @FXML
    private DatePicker szuletesiDatumModosit;

    @FXML
    private RadioButton noModosit;

    @FXML
    private RadioButton ferfiModosit;

    @FXML
    private ImageView kepModositasa;

    @FXML
    private Menu statisztikaMenu;

    private ObservableList<TagData> tagTablazatAdatok;

    private FilteredList<TagData> lejartberletuTagok;

    private FilteredList<TagData> aktivberletuTagok;

    private FilteredList<TagData> lejartberletesNok;

    private FilteredList<TagData> aktivberletesNok;

    private FilteredList<TagData> noiTagok;

    private FilteredList<TagData> lejartberletesFerfiak;

    private FilteredList<TagData> aktivberletesFerfiak;

    private FilteredList<TagData> ferfiTagok;

    private KonditeremTagVo kivalasztottTag;

    private boolean lejart = false;

    private static String bejelentkezesUzenet;

    private static String felhasznalo;

    private static boolean kijelentkezes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        szuresEskereses.setDisable(true);

        osszesTagGomb.setSelected(true);
        osszesTagNemGomb.setSelected(true);

        keresesszovegBevitel.setVisible(false);

        tagModositasElrejtes();

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
        tagTablazatAdatok = FXCollections.observableArrayList();

        gombFrissites();
        adatFrissites();

        konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
        regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());


        tagokTabla.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    try {
                        tagSzerkesztes(newValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        valaszt.getItems().add("Név");
        valaszt.getItems().add("Bérlet neve");

        FilteredList<TagData> kereses = new FilteredList<TagData>(tagTablazatAdatok, p -> true);


        valaszt.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (t1.equals("Név")) {
                    keresesszovegBevitel.setVisible(true);
                    keresesszovegBevitel.textProperty().addListener((observable, oldValue, newValue) -> {
                        kereses.setPredicate(tagData -> {
                            if (newValue == null || newValue.isEmpty()) {
                                return true;
                            }
                            String lowerCaseFilter = newValue.toLowerCase();
                            if (tagData.getTagNeve().toString().toLowerCase().contains(lowerCaseFilter)) {
                                return true;
                            }
                            return false;
                        });
                    });
                    tagokTabla.setItems(kereses);
                } else if (t1.equals("Bérlet neve")) {
                    keresesszovegBevitel.setVisible(true);
                    keresesszovegBevitel.textProperty().addListener((observable, oldValue, newValue) -> {
                        kereses.setPredicate(tagData -> {
                            if (newValue == null || newValue.isEmpty()) {
                                return true;
                            }
                            String lowerCaseFilter = newValue.toLowerCase();
                            if (tagData.getVasaroltBerletNeve().toString().toLowerCase().contains(lowerCaseFilter)) {
                                return true;
                            }
                            return false;
                        });
                    });
                    tagokTabla.setItems(kereses);
                }
            }
        });
        szuresek();
    }


    @FXML
    public void osszestagBerlet(ActionEvent event) {
        if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(ferfiTagok);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(noiTagok);
        }
    }

    @FXML
    public void osszestagNem(ActionEvent event) {
        if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivberletuTagok);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartberletuTagok);
        }
    }

    @FXML
    public void aktivBerlet(ActionEvent event) {
        if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(aktivberletuTagok);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(aktivberletesFerfiak);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(aktivberletesNok);
        }
    }

    @FXML
    public void lejartBerlet(ActionEvent event) {
        if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(lejartberletuTagok);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(lejartberletesFerfiak);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(lejartberletesNok);
        }
    }

    @FXML
    public void noTagok(ActionEvent event) {
        if (noGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivberletesNok);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartberletesNok);
        } else if (noGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(noiTagok);
        }
    }

    @FXML
    public void ferfiTagok(ActionEvent event) {
        if (ferfiGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivberletesFerfiak);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartberletesFerfiak);
        } else if (ferfiGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(ferfiTagok);
        }
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
    public void szuresKereses(ActionEvent event) {
        if (szures.isSelected()) {
            szuresEskereses.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    tagokTabla.getSelectionModel().clearSelection();
                }});
            tagModositas.setDisable(true);
            tabPane.getSelectionModel().select(szuresEskereses);
        } else {
            szuresEskereses.setDisable(true);
        }
    }

    @FXML
    public void kijelentkezes() {

        logolo.info("Kijeletkezés gomb megnyomva.");

        if (kijeletkezesMegerositesFelulet("Kijeletkezés megerősítő ablak", "Kijeletkezés megerősítés.", "Biztosan ki akar jelentkeztni?", Alert.AlertType.CONFIRMATION) == true) {
            logolo.info("Sikeres kijeletkezés.");
            bejelentkezettKonditerem = null;
            tagokTabla = null;
            setKijelentkezes(true);
            setBejelentkezesUzenet("");
            setFelhasznalo("");
            FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
            Ertesites.ertesites("Kijeletkezés", "Sikeres kijeletkezés.","Sikeres kijeletkezés.", "Sikeres kijeletkezés után" );

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
    public void megyeStatisztika(ActionEvent event) {
        FeluletBetoltese.MegyeStatisztikaFelulet(event);
    }

    @FXML
    public void nemekStatisztika(ActionEvent event) {
        FeluletBetoltese.NemekStatisztikaFelulet(event);
    }

    @FXML
    public void berletTipusStatisztika(ActionEvent event) {
        FeluletBetoltese.BerletTipusStatisztikaFelulet(event);
    }

    @FXML
    public void berletletrehozasaMenu(ActionEvent event) {
        FeluletBetoltese.BerletLetrehozasaFelulet(event);
    }

    @FXML
    public void berlettestreszabasaMenu(ActionEvent event) {
        FeluletBetoltese.BerletekModositasaFelulet(event);
    }

    private boolean kijeletkezesMegerositesFelulet(String cim, String fejlec, String tartalom, Alert.AlertType alertType) {
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
            statisztikaMenu.setDisable(true);

        } else if (!konditeremBerletek.isEmpty()) {
            berletModositasGomb.setDisable(false);
            tagHozzaadasaGomb.setDisable(false);
            statisztikaMenu.setDisable(false);
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
                            konditeremTagVo.getId(),
                            konditeremTagVo.getTagSzuletesidatuma(),
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

    }

    private void osszesTag() {

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


    private void szuresek() {
        LocalDate a = LocalDate.of(2017, 3, 14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        noiTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        ferfiTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        aktivberletuTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        aktivberletesNok = new FilteredList<>(aktivberletuTagok, tagok -> true);
        aktivberletesFerfiak = new FilteredList<>(aktivberletuTagok, tagok -> true);

        lejartberletuTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        lejartberletesNok = new FilteredList<>(lejartberletuTagok, tagok -> true);
        lejartberletesFerfiak = new FilteredList<>(lejartberletuTagok, tagok -> true);

        ferfiTagok.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Férfi")) {
                return true;
            }
            return false;
        });

        noiTagok.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Nő")) {
                return true;
            }
            return false;
        });

        aktivberletuTagok.setPredicate(tag -> {
            if (LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), formatter).compareTo(a) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), formatter).compareTo(a) > 0) {
                return true;
            }
            return false;
        });

        aktivberletesNok.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Nő")) {
                return true;
            }
            return false;
        });

        aktivberletesFerfiak.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Férfi")) {
                return true;
            }
            return false;
        });

        lejartberletuTagok.setPredicate(tag -> {
            if (LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), formatter).compareTo(a) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), formatter).compareTo(a) == -1) {
                return true;
            } else {
                return false;
            }

        });

        lejartberletesNok.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Nő")) {
                return true;
            }
            return false;
        });

        lejartberletesFerfiak.setPredicate(tag -> {
            if (tag.getTagNeme().toString().contains("Férfi")) {
                return true;
            }
            return false;
        });
    }

    private void tagSzerkesztes(TagData tData) throws IOException {
        if (tData != null) {
            kivalasztottTag = konditeremtagSzolgaltatas.keresTagot(tData.getId());


            tagModositas.setDisable(false);
            tabPane.getSelectionModel().select(tagModositas);
            szuresEskereses.setDisable(true);
            szures.setSelected(false);
//            osszesTagGomb.setSelected(true);
//            osszesTagNemGomb.setSelected(true);
//            adatFrissites();

//HIBAAAAAA


            vezeteknevModosit.setText(tData.getTagVezetekneve().getValue());
            keresztnevModosit.setText(tData.getTagKeresztneve().getValue());
            tData.getTagNeve().getValue();

            if (tData.getTagNeme().getValue().equals("Nő")) {
                noModosit.setSelected(true);
            } else if (tData.getTagNeme().getValue().equals("Férfi")) {
                ferfiModosit.setSelected(true);
            }

            szuletesiDatumModosit.setValue(tData.getTagSzuletesiIdeje());

            List<KonditeremTagKepeVo> osszesKep = konditeremtagkepeSzolgaltatas.osszesKep();
            for (KonditeremTagKepeVo kepek : osszesKep) {
                if (kepek.getKonditeremTag().getId() == tData.getId()) {
                    kepModositasa.setImage(byteKonvertalasKeppe(kepek.getTagKep(), 149, 134));
                }
            }
        }
    }

    private Image byteKonvertalasKeppe(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    public void tagModositasElrejtes() {
        tagModositas.setDisable(true);
    }

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

    public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
        this.bejelentkezettKonditerem = bejelentkezettKonditerem;
    }

    public static String getBejelentkezesUzenet() {
        return bejelentkezesUzenet;
    }

    public static void setBejelentkezesUzenet(String bejelentkezesUzenet) {
        KondiBazisFoAblakKezelo.bejelentkezesUzenet = bejelentkezesUzenet;
    }

    public static String getFelhasznalo() {
        return felhasznalo;
    }

    public static void setFelhasznalo(String felhasznalo) {
        KondiBazisFoAblakKezelo.felhasznalo = felhasznalo;
    }

    public static boolean isKijelentkezes() {
        return kijelentkezes;
    }

    public static void setKijelentkezes(boolean kijelentkezes) {
        KondiBazisFoAblakKezelo.kijelentkezes = kijelentkezes;
    }
}
