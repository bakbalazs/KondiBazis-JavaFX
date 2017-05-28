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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    private KonditeremTagVo kivalasztottTag;

    private ObservableList<TagAdatok> tagTablazatAdatok;

    private ObservableList<TagAdatok> item;

    private static String bejelentkezesUzenet;

    private static String felhasznalo;

    private static boolean kijelentkezes;

    private List<KonditeremBerletVo> konditeremBerletek;

    private Image nincsKep = new Image("/kepek/nincsKep.png");

    private Boolean vanKep = false;

    private byte[] kepByte;

    private FileChooser kepValaszto = new FileChooser();

    private File kivalasztottKep;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logolo.info("A Kondibázis Fő Ablak kezelő elindult!");
        kinezetBeallitasa();

        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
        tagTablazatAdatok = FXCollections.observableArrayList();

        konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
        regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());

        oszlopokBerlet();
        tagokTabla.getColumns().addAll(berletLejaratiDatuma, alkalmakOszlop);

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

        FilteredList<TagAdatok> keresettNev = new FilteredList<>(tagTablazatAdatok, p -> true);

        keresesszovegBevitel.textProperty().addListener((observable, oldValue, newValue) -> {
            keresettNev.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getTagVezetekneve().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (person.getTagKeresztneve().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        tagokTabla.setItems(keresettNev);
        logolo.debug("A " + keresesszovegBevitel + " szöveggel egyező neveket lekérte " + keresettNev.size() + " számú ilyen tag van!");
    }


    @FXML
    private void osszesTagBerlet() {
        if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiak);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nok);
        } else if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletuek);
        } else if (osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletuek);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiBerletuek);
        } else if (osszesTagGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiBerletuek);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNoBerletuek);
        } else if (osszesTagGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNoBerletuek);
        }
    }

    @FXML
    private void osszesTagNem() {
        if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuek);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuek);
        } else if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletuek);
        } else if (osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletuek);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasBerletuek);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasBerletuek);
        } else if (osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosBerletuek);
        } else if (osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosBerletuek);
        }
    }

    @FXML
    private void osszesTagBerletTipus() {
        if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(tagTablazatAdatok);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(nok);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && osszesTagGomb.isSelected()) {
            tagokTabla.setItems(ferfiak);
        } else if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuek);
        } else if (osszesTagBerletTipusGomb.isSelected() && osszesTagNemGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuek);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(nokAktiv);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && aktivberletGomb.isSelected()) {
            tagokTabla.setItems(ferfiakAktiv);
        } else if (osszesTagBerletTipusGomb.isSelected() && noGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(nokLejart);
        } else if (osszesTagBerletTipusGomb.isSelected() && ferfiGomb.isSelected() && lejertberletGomb.isSelected()) {
            tagokTabla.setItems(ferfiakLejart);
        }
    }

    @FXML
    private void aktivBerlet() {
        if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(aktivBerletuek);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiakAktiv);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nokAktiv);
        } else if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasBerletuek);
        } else if (aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosBerletuek);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokAktiv);
        } else if (aktivberletGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokAktiv);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiAktiv);
        } else if (aktivberletGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiAktiv);
        }

    }

    @FXML
    private void lejartBerlet() {
        if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(lejartBerletuek);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiakLejart);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nokLejart);
        } else if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasBerletuek);
        } else if (lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosBerletuek);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokLejart);
        } else if (lejertberletGomb.isSelected() && noGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokLejart);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiLejart);
        } else if (lejertberletGomb.isSelected() && ferfiGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiLejart);
        }
    }

    @FXML
    private void noTagok() {
        if (noGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nok);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nokAktiv);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(nokLejart);
        } else if (noGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNoBerletuek);
        } else if (noGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNoBerletuek);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokAktiv);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokLejart);
        } else if (noGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokAktiv);
        } else if (noGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokLejart);
        }
    }

    @FXML
    private void ferfiTagok() {
        if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiak);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiakAktiv);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagBerletTipusGomb.isSelected()) {
            tagokTabla.setItems(ferfiakLejart);
        } else if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiBerletuek);
        } else if (ferfiGomb.isSelected() && osszesTagGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiBerletuek);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiAktiv);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiLejart);
        } else if (ferfiGomb.isSelected() && aktivberletGomb.isSelected() && idokorlatosBerletekGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiAktiv);
        } else if (ferfiGomb.isSelected() && lejertberletGomb.isSelected() && alkalmasBerletekGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiLejart);
        }
    }

    @FXML
    private void alkalmasBerletek() {
        if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(alkalmasBerletuek);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(aktivAlkalmasBerletuek);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(lejartAlkalmasBerletuek);
        } else if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNoBerletuek);
        } else if (alkalmasBerletekGomb.isSelected() && osszesTagGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiBerletuek);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokAktiv);
        } else if (alkalmasBerletekGomb.isSelected() && aktivberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiAktiv);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(alkalmasNokLejart);
        } else if (alkalmasBerletekGomb.isSelected() && lejertberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(alkalmasFerfiLejart);
        }
    }

    @FXML
    private void idokorlatosBerletek() {
        if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosBerletuek);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(aktivIdokorlatosBerletuek);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && osszesTagNemGomb.isSelected()) {
            tagokTabla.setItems(lejartIdokorlatosBerletuek);
        } else if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNoBerletuek);
        } else if (idokorlatosBerletekGomb.isSelected() && osszesTagGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiBerletuek);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokAktiv);
        } else if (idokorlatosBerletekGomb.isSelected() && aktivberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiAktiv);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && noGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosNokLejart);
        } else if (idokorlatosBerletekGomb.isSelected() && lejertberletGomb.isSelected() && ferfiGomb.isSelected()) {
            tagokTabla.setItems(idokorlatosFerfiLejart);
        }
    }

    @FXML
    public void elerhetoseg() {
        logolo.info("Elérhetőség gombra kattintva.");
        FeluletBetoltese.KonditeremElerhetosegeiFelulet();
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
        szuresEskereses.setDisable(true);
        osszesTagGomb.setSelected(true);
        osszesTagNemGomb.setSelected(true);
        osszesTagBerletTipusGomb.setSelected(true);
    }

    @FXML
    public void szuresKereses() {
        if (szures.isSelected()) {
            szuresEskereses.setDisable(false);
            Platform.runLater(() -> tagokTabla.getSelectionModel().clearSelection());
            tagModositas.setDisable(true);
            tabPane.getSelectionModel().select(szuresEskereses);
            TagokSzurese.szuresek(item);
            logolo.debug("Szuresek bekapcsolva!");
        } else {
            szuresEskereses.setDisable(true);
            logolo.debug("Szuresek kikapcsolva!");
        }
    }

    @FXML
    public void kijelentkezes() {

        logolo.info("Kijeletkezés gomb megnyomva.");

        if (KiegeszitoFelulet.megerositesFelulet("Kijeletkezés megerősítő ablak", "Kijeletkezés megerősítés.", "Biztosan ki akar jelentkeztni?", "Kijelentkezés", "Mégsem", Alert.AlertType.CONFIRMATION)) {
            logolo.info("Sikeres kijeletkezés.");
            bejelentkezettKonditerem = null;
            tagokTabla = null;
            setKijelentkezes(true);
            setBejelentkezesUzenet("");
            setFelhasznalo("");
            FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
            KiegeszitoFelulet.ertesites("Kijeletkezés", "Sikeres kijeletkezés.", "Sikeres kijeletkezés.", "Sikeres kijeletkezés után", Pos.BOTTOM_RIGHT, 5);

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

        konditeremBerletek = konditeremBerletSzolgaltatas
                .konditeremOsszesBerlete(bejelentkezettKonditerem);
        logolo.info("Bejelentkezett koditeremhez lekérjük lejartBerletuTagok bérleteket!");
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

        item = FXCollections.observableArrayList();
        if (!item.isEmpty()) {
            item.clear();
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
            item = tagTablazatAdatok;
            logolo.debug("Adat: " + tagTablazatAdatok.get(tagTablazatAdatok.size() - 1));
        }

        osszesTag();

    }

    private void osszesTag() {

        nevOszlop.setCellValueFactory(celldata -> celldata.getValue().tagNeveProperty());

        vezeteknevOszlop.setCellValueFactory(celldata -> celldata.getValue().tagVezetekneveProperty());

        keresztnevOszlop.setCellValueFactory(celldata -> celldata.getValue().tagKeresztneveProperty());

        nemOszlop.setCellValueFactory(celldata -> celldata.getValue().tagNemeProperty());

        korOszlop.setCellValueFactory(celldata -> celldata.getValue().tagKoraProperty());

        berletVasarlasOszlop.setCellValueFactory(celldata -> celldata.getValue().berletVasarlasIdejeProperty());

        berletNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().vasaroltBerletNeveProperty());

        logolo.debug("Összes tag megjelenítese.");

        tagokTabla.setItems(tagTablazatAdatok);
    }


    private void tagSzerkesztes(TagAdatok tData) throws IOException {
        if (tData != null) {
            kivalasztottTag = konditeremTagSzolgaltatas.keresTagot(tData.getId());

            logolo.debug("A kivalasztott tag: " + kivalasztottTag);

            tagModositas.setDisable(false);
            tabPane.getSelectionModel().select(tagModositas);
            szuresEskereses.setDisable(true);
            szures.setSelected(false);
            osszesTagGomb.setSelected(true);
            osszesTagNemGomb.setSelected(true);

            vezeteknevModosit.setText(tData.getTagVezetekneve());
            keresztnevModosit.setText(tData.getTagKeresztneve());
            lejartBerletNeve.setText(tData.getLejartBerletNeve());

            if (tData.getTagNeme().equals("Nő")) {
                noModosit.setSelected(true);
            } else if (tData.getTagNeme().equals("Férfi")) {
                ferfiModosit.setSelected(true);
            }

            szuletesiDatumModosit.setValue(tData.getTagSzuletesiIdeje());

            List<KonditeremTagKepeVo> osszesKep = konditeremtagkepeSzolgaltatas.osszesKep();
            for (KonditeremTagKepeVo kepek : osszesKep) {
                if (kepek.getKonditeremTag().getId() == tData.getId()) {
                    kepModositasa.setImage(KepKonvertalas.byteKonvertalasKeppe(kepek.getTagKep(), 149, 134));
                }
            }

            logolo.info("A kivalasztott tag adatai betöltve.");
        }
    }

    private int korSzamolas(LocalDate szuletesiDatum) {
        return (int) ChronoUnit.YEARS.between(szuletesiDatum, LocalDate.now());
    }

    private String nemValasztas() {
        String tagNeme = null;
        if (ferfiModosit.isSelected()) {
            tagNeme = "Férfi";
            logolo.debug("Fertfi radiogomb benyomva");
        } else if (noModosit.isSelected()) {
            tagNeme = "Nő";
            logolo.debug("No radiogomb benyomva");
        }
        return tagNeme;

    }

    @FXML
    public void tagModositasa() throws IOException {
        logolo.debug("Tag módosítása gombra kattintva!");
        KonditeremTagVo tag = konditeremTagSzolgaltatas.keresTagot(kivalasztottTag.getId());
        logolo.debug("A kivalasztott tag id-ja: " + kivalasztottTag.getId());

//        KonditeremTagKepeVo kepModositasa = new KonditeremTagKepeVo();
//        if (vanKep) {
//            if (kepModositasa.getKonditeremTag().getId() == kivalasztottTag.getId()) {
//                kepModositasa.setTagKep(kepByte);
//                konditeremtagkepeSzolgaltatas.leterehozTagKepet(kepModositasa);
//            }
//
//        }

        if (!tag.getTagVezeteknev().equals(vezeteknevModosit.getText()) || !tag.getTagKeresztnev().equals(keresztnevModosit.getText()) || !tag.getTagNeme().equals(nemValasztas()) || !tag.getTagSzuletesidatuma().equals(szuletesiDatumModosit.getValue()) || ujBerletValasztas.getValue() != null) {
            if (KiegeszitoFelulet.megerositesFelulet("Tag módosítása megerősítő ablak", "Tag módosítás megerősítése.", "Biztosan módosítani szeretné?", "Módosítás", "Mégsem", Alert.AlertType.WARNING)) {

                kivalasztottTag.setTagVezeteknev(vezeteknevModosit.getText());
                kivalasztottTag.setTagKeresztnev(keresztnevModosit.getText());
                kivalasztottTag.setTagNeve(vezeteknevModosit.getText() + " " + keresztnevModosit.getText());
                kivalasztottTag.setTagSzuletesidatuma(szuletesiDatumModosit.getValue());
                kivalasztottTag.setTagKora(korSzamolas(szuletesiDatumModosit.getValue()));
                kivalasztottTag.setTagNeme(nemValasztas());

                if (ujBerletValasztas.getValue() != null && kivalasztottTag.getKonditeremBerlet() == null) {
                    for (KonditeremBerletVo berlet : konditeremBerletek) {
                        kivalasztottTag.setBerletVasarlasideje(LocalDate.now());

                        if (ujBerletValasztas.getValue().equals(berlet.getBerletNeve()) && ujBerletValasztas.getValue().contains("Időkorlátos")) {
                            int nap = berlet.getMennyiNap();
                            int honap = berlet.getMennyiHonap();
                            kivalasztottTag.setVasaroltBerletTipusa(berlet.getBerletTipusa());
                            kivalasztottTag.setVasaroltBerletNeve(berlet.getBerletNeve());
                            kivalasztottTag.setMennyiAlkalomMeg(0);
                            if (nap > 0) {
                                kivalasztottTag.setBerletLejaratiIdeje(LocalDate.now().plusDays(nap).minusDays(1));
                            } else if (honap > 0) {
                                kivalasztottTag.setBerletLejaratiIdeje(LocalDate.now().plusMonths(honap));
                            }
                            kivalasztottTag.setKonditeremBerlet(berlet);
                            break;
                        }

                        if (ujBerletValasztas.getValue().equals(berlet.getBerletNeve()) && ujBerletValasztas.getValue().contains("Alkalmas")) {
                            int alkalom = berlet.getMennyiAlkalom();
                            if (alkalom > 0) {
                                kivalasztottTag.setVasaroltBerletTipusa(berlet.getBerletTipusa());
                                kivalasztottTag.setBerletLejaratiIdeje(LocalDate.now());
                                kivalasztottTag.setMennyiAlkalomMeg(alkalom);
                                kivalasztottTag.setVasaroltBerletTipusa(berlet.getBerletTipusa());
                                kivalasztottTag.setVasaroltBerletNeve(berlet.getBerletNeve());
                            }
                            kivalasztottTag.setKonditeremBerlet(berlet);
                            break;
                        }

                    }
                }

                konditeremTagSzolgaltatas.frissitKonditeremTagot(kivalasztottTag);
                logolo.debug("A " + kivalasztottTag.getId() + " id-val rendelkező tag megváltozott!");
                KiegeszitoFelulet.ertesites("Tag módosítása", "Sikeres módosítás.", "Sikeres módosítás.", "Fő ablakban lejartBerletuTagok tag módodosítása tabon.", Pos.BOTTOM_RIGHT, 5);
                Platform.runLater(() -> tagokTabla.getSelectionModel().clearSelection());
                tagModositas.setDisable(true);
                adatFrissites();
                logolo.info("Sikeres tag módosítás!");

            } else {
                KiegeszitoFelulet.ertesites("Tag módosítása", "Nem történt módosítás.", "Nem történt módosítása.", "Fő ablakban lejartBerletuTagok tag módodosítása tabon.", Pos.BOTTOM_RIGHT, 5);
                logolo.info("Nem történt tag módosítása.");
            }
        } else {
            KiegeszitoFelulet.ertesites("Nem történt válrozás", "Nem módosult.", "Nincs módosítás.", "Fő ablakban lejartBerletuTagok tag módodosítása tabon.", Pos.TOP_CENTER, 2);
            logolo.info("Nem volt valtozas lejartBerletuTagok tag adataiban!");

        }

    }

    @FXML
    public void kepTorlese() {
        logolo.debug("Kep torlesere kattintva.\n Nincs kep kep berakva.");
        kepModositasa.setImage(nincsKep);
        vanKep = false;
    }

    @FXML
    public void tallozas() throws IOException {
        logolo.info("Tallózás gombra kattintva.");
        kepValaszto.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files (*.png , *.jpg)", "*.png", "*.jpg"));
        kivalasztottKep = kepValaszto.showOpenDialog(null);

        if (kivalasztottKep != null) {
            Image image = new Image(kivalasztottKep.toURI().toString(), 195, 185, false, false);
            kepByte = new byte[(int) kivalasztottKep.length()];
            FileInputStream fileInputStream = new FileInputStream(kivalasztottKep);
            fileInputStream.read(kepByte);
            fileInputStream.close();

            kepModositasa.setImage(image);
            vanKep = true;
            logolo.debug("A kiválasztott kep beallítva.");
//            tallozasGomb.setText("Módosítás");

        } else {
            kepModositasa.setImage(nincsKep);
            vanKep = false;
//            tallozasGomb.setText("Tallózás");
            logolo.debug("Nincs kép kiválasztva, a NincsKep kép lesz berakva");
        }

    }

    private byte[] nincsKep() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("kepek/nincsKep.png").getFile());
        String absolutePath = file.getAbsolutePath();
        new Image(file.toURI().toString(), 195, 285, false, false);
        byte[] kep = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(absolutePath);
        fileInputStream.read(kep);
        fileInputStream.close();
        return kep;
    }


    @FXML
    public void megseModosit() {
        Platform.runLater(() -> tagokTabla.getSelectionModel().clearSelection());
        tagModositas.setDisable(true);
        tabPane.getSelectionModel().select(szuresEskereses);
        szuresEskereses.setDisable(true);
        logolo.info("Mégsem gombra kattintva a tag módosítása fülön!");
    }

    private void oszlopokBerlet() {
        LocalDate maiNap = LocalDate.now();
        DateTimeFormatter datumFormatum = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

                final Button mennyiAlkalomMegGomb = new Button("Még " + tag.getMennyiAlkalom() + " alkalom van hátra.");
                mennyiAlkalomMegGomb.setStyle("-fx-border-color: #00FF7F; -fx-border-width: 2px;");
                if (tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                    mennyiAlkalomMegGomb.setText("Nincs több alkalom.");
                    mennyiAlkalomMegGomb.setDisable(true);
                    mennyiAlkalomMegGomb.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                }

                if (tag.getVasaroltBerletNeve().contains("Alkalmas bérlet")) {
                    setGraphic(mennyiAlkalomMegGomb);
                }
                mennyiAlkalomMegGomb.setOnAction(event -> {
                    int alkalomSzama = Integer.parseInt(tag.getMennyiAlkalom());
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
                            konditeremTagVo.setKonditeremBerlet(null);
                            konditeremTagSzolgaltatas.frissitKonditeremTagot(konditeremTagVo);
                            adatFrissites();
                        }
                    } else if (Integer.parseInt(tag.getMennyiAlkalom()) == 0 && tag.getVasaroltBerletNeve().contains("Alkalmas")) {
                        mennyiAlkalomMegGomb.setText("Nincs több alkalom.");
                        mennyiAlkalomMegGomb.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                        mennyiAlkalomMegGomb.setDisable(true);
                    }
                });
            }

        });

        berletLejaratiDatuma = new TableColumn<>("Bérlet Lejárati Dátuma");
        berletLejaratiDatuma.setMaxWidth(4800);
        berletLejaratiDatuma.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        berletLejaratiDatuma.setStyle("-fx-alignment: CENTER;");
        berletLejaratiDatuma.setCellFactory(param -> new TableCell<TagAdatok, TagAdatok>() {

            @Override
            protected void updateItem(TagAdatok tag, boolean empty) {
                super.updateItem(tag, empty);

                if (tag == null) {
                    setGraphic(null);
                    return;
                }

                final Text datumSzoveg = new Text(tag.getBerletLejaratiIdeje());
                datumSzoveg.setFill(Color.SPRINGGREEN);

                if (tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                    datumSzoveg.setFill(Color.RED);
                }
                if (tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                    datumSzoveg.setFill(Color.RED);
                }

                setGraphic(datumSzoveg);
            }

        });
        logolo.debug("A bérlet lejárati ideje oszlop és alkalmak oszlop létrehozva!");
    }

    private void kinezetBeallitasa() {
        nevOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        vezeteknevOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        keresztnevOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        nemOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        korOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        berletNeveOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        berletVasarlasOszlop.setStyle("-fx-alignment: CENTER-LEFT;");

        tagokTabla.setPlaceholder(new Text("Nem található egy tag sem."));

        tagokTabla.getStylesheets().add("/css/tablakinezet.css");

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
