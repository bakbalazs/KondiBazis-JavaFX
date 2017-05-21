// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagKepeSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import hu.unideb.inf.kondibazis.ui.kiegeszito.KepKonvertalas;
import hu.unideb.inf.kondibazis.ui.kiegeszito.KiegeszitoFelulet;
import hu.unideb.inf.kondibazis.ui.kiegeszito.TagokSzurese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import hu.unideb.inf.kondibazis.ui.model.TagAdatok;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

import static hu.unideb.inf.kondibazis.ui.kiegeszito.TagokSzurese.*;

@Component
public class KondiBazisFoAblakKezelo implements Initializable {

    private static Logger logolo = LoggerFactory.getLogger(KondiBazisFoAblakKezelo.class);

    @Autowired
    private BejelentkezoKezelo bejelentkezoKezelo;

    @Autowired
    private KonditeremTagSzolgaltatas konditeremTagSzolgaltatas;

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
    private TableView<TagAdatok> tagokTabla;

    @FXML
    private TableColumn<TagAdatok, String> nevOszlop;

    @FXML
    private TableColumn<TagAdatok, String> vezeteknevOszlop;

    @FXML
    private TableColumn<TagAdatok, String> keresztnevOszlop;

    @FXML
    private TableColumn<TagAdatok, String> nemOszlop;

    @FXML
    private TableColumn<TagAdatok, String> korOszlop;

    @FXML
    private TableColumn<TagAdatok, String> berletNeveOszlop;

    @FXML
    private TableColumn<TagAdatok, String> berletVasarlasOszlop;

    private TableColumn<TagAdatok, TagAdatok> berletLejaratiDatuma;

    private TableColumn<TagAdatok, TagAdatok> alkalmakOszlop;

    @FXML
    private Button berletModositasGomb;

    @FXML
    private Button tagHozzaadasaGomb;

    @FXML
    private RadioButton osszesTagGomb;

    @FXML
    private RadioButton osszesTagNemGomb;

    @FXML
    private RadioButton osszesTagBerletTipusGomb;

    @FXML
    private RadioButton lejertberletGomb;

    @FXML
    private RadioButton aktivberletGomb;

    @FXML
    private RadioButton ferfiGomb;

    @FXML
    private RadioButton noGomb;

    @FXML
    private RadioButton alkalmasBerletekGomb;

    @FXML
    private RadioButton idokorlatosBerletekGomb;

    @FXML
    private Tab szuresEskereses;

    @FXML
    private Tab tagModositas;

    @FXML
    private TextField keresesszovegBevitel;

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
    private Text lejartBerletNeve;

    @FXML
    private ImageView kepModositasa;

    @FXML
    private Menu statisztikaMenu;

    @FXML
    private ChoiceBox<String> ujBerletValasztas;

    @FXML
    private Button tagModositasaGomb;

    private KonditeremTagVo kivalasztottTag;

    private ObservableList<TagAdatok> tagTablazatAdatok;

    private ObservableList<TagAdatok> kivalasztottSzures;

    private static String bejelentkezesUzenet;

    private static String felhasznalo;

    private static boolean kijelentkezes;

    private static String lejartBerletStyle;

    private ObservableList<TagAdatok> items;

    private static String lejart = "Lejárt a bérlet!";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tagokTabla.setPlaceholder(new Text("Nem található egy tag sem."));

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
        tagTablazatAdatok = FXCollections.observableArrayList();

        konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
        regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());

        oszlopokBerlet();
        tagokTabla.getColumns().addAll(berletLejaratiDatuma, alkalmakOszlop);

        lejartBerletStyle = "-fx-background-color: lightcoral;";

        szuresEskereses.setDisable(true);

        osszesTagGomb.setSelected(true);
        osszesTagNemGomb.setSelected(true);
        osszesTagBerletTipusGomb.setSelected(true);

        tagModositasElrejtes();


        gombFrissites();
        adatFrissites();

        tagokTabla.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    try {
                        tagSzerkesztes(newValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        items = tagokTabla.getItems();

        FilteredList<TagAdatok> kereses = new FilteredList<>(items, p -> true);

        keresesszovegBevitel.textProperty().addListener((observable, oldValue, newValue) -> kereses.setPredicate(tagData -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            return tagData.getTagNeve().toString().toLowerCase().contains(lowerCaseFilter);
        }));
        tagokTabla.setItems(kereses);


        TagokSzurese.szuresek(tagTablazatAdatok);
    }


    @FXML
    private void osszesTagBerlet() {
        if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiTagok);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(noiTagok);
        } else if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletek);
        } else if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletek);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesFerfiak);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesFerfiak);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesNok);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesNok);
        }
    }

    @FXML
    private void osszesTagNem() {
        if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuTagok);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuTagok);
        } else if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletek);
        } else if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletek);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasTagok);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasTagok);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosTagok);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosTagok);
        }
    }

    @FXML
    private void osszesTagBerletTipus() {
        if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(noiTagok);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(ferfiTagok);
        } else if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuTagok);
        } else if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuTagok);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesNok);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesFerfiak);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesNok);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesFerfiak);
        }
    }

    @FXML
    private void aktivBerlet() {
        if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuTagok);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesFerfiak);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesNok);
        } else if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasTagok);
        } else if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosTagok);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivNoiTagok);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivNoiTagok);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivFerfiTagok);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivFerfiTagok);
        }

    }

    @FXML
    private void lejartBerlet() {
        if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuTagok);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesFerfiak);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesNok);
        } else if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasTagok);
        } else if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosTagok);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartNoiTagok);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartNoiTagok);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartFerfiTagok);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartFerfiTagok);
        }
    }

    @FXML
    private void noTagok() {
        if (noGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(noiTagok);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesNok);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesNok);
        } else if (noGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesNok);
        } else if (noGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesNok);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivNoiTagok);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartNoiTagok);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivNoiTagok);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartNoiTagok);
        }
    }

    @FXML
    private void ferfiTagok() {
        if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiTagok);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletesFerfiak);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletesFerfiak);
        } else if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesFerfiak);
        } else if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesFerfiak);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivFerfiTagok);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartFerfiTagok);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivFerfiTagok);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartFerfiTagok);
        }
    }

    @FXML
    private void alkalmasBerletek() {
        if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletek);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasTagok);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasTagok);
        } else if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesNok);
        } else if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletesFerfiak);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivNoiTagok);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasAktivFerfiTagok);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartNoiTagok);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasLejartFerfiTagok);
        }
    }

    @FXML
    private void idokorlatosBerletek() {
        if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletek);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosTagok);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosTagok);
        } else if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesNok);
        } else if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletesFerfiak);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivNoiTagok);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosAktivFerfiTagok);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartNoiTagok);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosLejartFerfiTagok);
        }
    }

    @FXML
    public void elerhetoseg() {
        logolo.info("Elérhetőség gombra kattintva.");
        FeluletBetoltese.KonditeremElerhetosegSzekeszteseFelulet();
    }

    @FXML
    public void berletekLetrehozasa() {
        logolo.info("Bérletek létrehozása gombra kattintva.");
        FeluletBetoltese.BerletLetrehozasaFelulet();
    }

    @FXML
    public void berletekModositasa() {
        logolo.info("Bérletek módosítása gombra kattintva.");
        FeluletBetoltese.BerletekModositasaFelulet();
    }

    @FXML
    public void tagHozzaadasa() {
        logolo.info("Tag Hozzáadása gombra kattintva.");
        FeluletBetoltese.TagHozzaadasaFelulet();
    }

    @FXML
    public void szuresKereses() {
        if (szures.isSelected()) {
            szuresEskereses.setDisable(false);
            Platform.runLater(() -> tagokTabla.getSelectionModel().clearSelection());
            tagModositas.setDisable(true);
            tabPane.getSelectionModel().select(szuresEskereses);
        } else {
            szuresEskereses.setDisable(true);
        }
    }

    @FXML
    public void kijelentkezes() {

        logolo.info("Kijeletkezés gomb megnyomva.");

        if (KiegeszitoFelulet.kijeletkezesMegerositesFelulet("Kijeletkezés megerősítő ablak", "Kijeletkezés megerősítés.", "Biztosan ki akar jelentkeztni?", Alert.AlertType.CONFIRMATION)) {
            logolo.info("Sikeres kijeletkezés.");
            bejelentkezettKonditerem = null;
            tagokTabla = null;
            setKijelentkezes(true);
            setBejelentkezesUzenet("");
            setFelhasznalo("");
            FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
            KiegeszitoFelulet.ertesites("Kijeletkezés", "Sikeres kijeletkezés.", "Sikeres kijeletkezés.", "Sikeres kijeletkezés után");

        } else {
            logolo.info("Nem történt kijeletkezés.");
        }
    }

    @FXML
    public void bezaras() {
        logolo.info("Bezárás menüre kattintva.");
        SpringFxmlLoader.close();
        Platform.exit();
    }

    @FXML
    public void varosStatisztika() {
        FeluletBetoltese.VarosStatisztikaFelulet();
    }

    @FXML
    public void megyeStatisztika() {
        FeluletBetoltese.MegyeStatisztikaFelulet();
    }

    @FXML
    public void nemekStatisztika() {
        FeluletBetoltese.NemekStatisztikaFelulet();
    }

    @FXML
    public void berletTipusStatisztika() {
        FeluletBetoltese.BerletTipusStatisztikaFelulet();
    }

    @FXML
    public void berletletrehozasaMenu() {
        FeluletBetoltese.BerletLetrehozasaFelulet();
    }

    @FXML
    public void berlettestreszabasaMenu() {
        FeluletBetoltese.BerletekModositasaFelulet();
    }

    void gombFrissites() {

        logolo.debug("Gomgok frissítese ha tortet berlet letrehozas.");

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

    void adatFrissites() {

        logolo.debug("Adatfrissites.");

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                .konditeremOsszesBerlete(bejelentkezettKonditerem);
        logolo.info("Bejelentkezett koditeremhez lekérjük a bérleteket!");
        ujBerletValasztas.getItems().clear();
        for (KonditeremBerletVo berletek : konditeremBerletek) {
            ujBerletValasztas.getItems().add(berletek.getBerletNeve());
        }

        List<KonditeremTagVo> konditerem_tagjai = konditeremTagSzolgaltatas
                .konditeremOsszesTagja(bejelentkezettKonditerem);

        tagokSzama.setText(String.valueOf(konditerem_tagjai.size()));

        if (!tagTablazatAdatok.isEmpty()) {
            tagTablazatAdatok.clear();
        }

        logolo.debug("Tablazat feltoltese adatokkal: ");

        for (KonditeremTagVo konditeremTagVo : konditerem_tagjai) {

            tagTablazatAdatok.add(new TagAdatok(
                            konditeremTagVo.getId(),
                            konditeremTagVo.getTagSzuletesidatuma(),
                            konditeremTagVo.getTagNeve(),
                            konditeremTagVo.getTagVezeteknev(),
                            konditeremTagVo.getTagKeresztnev(),
                            konditeremTagVo.getTagNeme(),
                            konditeremTagVo.getTagKora(),
                            konditeremTagVo.getVasaroltBerletNeve(),
                            konditeremTagVo.getBerletVasarlasideje(),
                            konditeremTagVo.getBerletLejaratiIdeje(),
                            konditeremTagVo.getMennyiAlkalomMeg(),
                            konditeremTagVo.getLejartBerletNeve()
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

        berletNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().getVasaroltBerletNeveProperty());

        logolo.debug("Összes tag megjelenítese.");

        tagokTabla.setItems(tagTablazatAdatok);
    }


    private void tagSzerkesztes(TagAdatok tData) throws IOException {
        if (tData != null) {
            kivalasztottTag = konditeremTagSzolgaltatas.keresTagot(tData.getId());

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
            lejartBerletNeve.setText(tData.getLejartBerletNeve().getValue());

            if (tData.getTagNeme().getValue().equals("Nő")) {
                noModosit.setSelected(true);
            } else if (tData.getTagNeme().getValue().equals("Férfi")) {
                ferfiModosit.setSelected(true);
            }

            szuletesiDatumModosit.setValue(tData.getTagSzuletesiIdeje());

            List<KonditeremTagKepeVo> osszesKep = konditeremtagkepeSzolgaltatas.osszesKep();
            for (KonditeremTagKepeVo kepek : osszesKep) {
                if (kepek.getKonditeremTag().getId() == tData.getId()) {
                    kepModositasa.setImage(KepKonvertalas.byteKonvertalasKeppe(kepek.getTagKep(), 149, 134));
                }
            }
        }
    }

    @FXML
    public void tagModositasa(ActionEvent event) {
        //TODO
//            kivalasztottTag.s
    }

    private void oszlopokBerlet() {
        alkalmakOszlop = new TableColumn<>("Alkalmak");
        alkalmakOszlop.setMaxWidth(4800);
        alkalmakOszlop.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        alkalmakOszlop.setCellFactory(param -> new TableCell<TagAdatok, TagAdatok>() {

            @Override
            protected void updateItem(TagAdatok tag, boolean empty) {
                super.updateItem(tag, empty);

                TableRow alkalmakSor = getTableRow();
                if (tag == null) {
                    setGraphic(null);
                    alkalmakSor.setStyle("");
                    return;
                }
                final Button mennyiAlkalomMegGomb = new Button("Még " + tag.getMennyiAlkalom().getValue() + " alkalom van hátra.");

                if (Integer.parseInt(tag.getMennyiAlkalom().getValue()) == 0 && tag.getVasaroltBerletNeve().getValue().contains("Alkalmas")) {
                    mennyiAlkalomMegGomb.setText("Nincs több alkalom.");
                    alkalmakSor.setStyle(lejartBerletStyle);
                    mennyiAlkalomMegGomb.setDisable(true);
                } else {
                    alkalmakSor.setStyle("");
                }

                if (tag.getVasaroltBerletNeve().toString().contains("Alkalmas bérlet")) {
                    setGraphic(mennyiAlkalomMegGomb);
                }
                mennyiAlkalomMegGomb.setOnAction(event -> {
                    int alkalomSzama = Integer.parseInt(tag.getMennyiAlkalom().getValue());
                    Long tagId = tag.getId();
                    KonditeremTagVo konditeremTagVo = konditeremTagSzolgaltatas.keresTagot(tagId);
                    if (alkalomSzama != 0) {
                        alkalmakSor.setStyle("");
                        int kevesebbAlkalom = alkalomSzama - 1;
                        konditeremTagVo.setMennyiAlkalomMeg(kevesebbAlkalom);
                        konditeremTagSzolgaltatas.frissitKonditeremTagot(konditeremTagVo);
                        adatFrissites();
                        if (kevesebbAlkalom == 0) {
                            konditeremTagVo.setLejartBerletNeve(konditeremTagVo.getVasaroltBerletNeve());
                            konditeremTagSzolgaltatas.frissitKonditeremTagot(konditeremTagVo);
                        }
                    } else if (Integer.parseInt(tag.getMennyiAlkalom().getValue()) == 0 && tag.getVasaroltBerletNeve().getValue().contains("Alkalmas")) {
                        mennyiAlkalomMegGomb.setText("Nincs több alkalom.");
                        alkalmakSor.setStyle(lejartBerletStyle);
                        mennyiAlkalomMegGomb.setDisable(true);
                    }
                });
            }

        });

        berletLejaratiDatuma = new TableColumn<>("Berlet Lejárati Dátuma");
        berletLejaratiDatuma.setMaxWidth(4800);
        berletLejaratiDatuma.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        berletLejaratiDatuma.setCellFactory(param -> new TableCell<TagAdatok, TagAdatok>() {

            @Override
            protected void updateItem(TagAdatok tag, boolean empty) {
                super.updateItem(tag, empty);

                TableRow idokorlatosSor = getTableRow();

                if (tag == null) {
                    setGraphic(null);
                    idokorlatosSor.setStyle("");
                    return;
                }

                final Text testText = new Text(tag.getBerletLejaratiIdeje().getValue());


                if (tag.getVasaroltBerletNeve().toString().contains("Időkorlátos")) {
                    setGraphic(testText);
                    idokorlatosSor.setStyle("");
                }

            }

        });
    }

    private void tagModositasElrejtes() {
        tagModositas.setDisable(true);
    }

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

    public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
        this.bejelentkezettKonditerem = bejelentkezettKonditerem;
    }

    static String getBejelentkezesUzenet() {
        return bejelentkezesUzenet;
    }

    private static void setBejelentkezesUzenet(String bejelentkezesUzenet) {
        KondiBazisFoAblakKezelo.bejelentkezesUzenet = bejelentkezesUzenet;
    }

    static String getFelhasznalo() {
        return felhasznalo;
    }

    private static void setFelhasznalo(String felhasznalo) {
        KondiBazisFoAblakKezelo.felhasznalo = felhasznalo;
    }

    static boolean isKijelentkezes() {
        return kijelentkezes;
    }

    private static void setKijelentkezes(boolean kijelentkezes) {
        KondiBazisFoAblakKezelo.kijelentkezes = kijelentkezes;
    }
}
