// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.*;
import hu.unideb.inf.kondibazis.szolg.vo.*;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.kiegeszito.KiegeszitoFelulet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class TagHozzaadasaKezelo implements Initializable {

    private static Logger logolo = LoggerFactory.getLogger(TagHozzaadasaKezelo.class);

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    @Autowired
    private KonditeremTagSzolgaltatas konditeremTagSzolgaltatas;

    @Autowired
    private KonditeremTagKepeSzolgaltatas konditeremTagKepeSzolgaltatas;

    @Autowired
    private TelepulesekSzolgaltatas telepulesekSzolgaltatas;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    private Image nincsKep = new Image("/kepek/nincsKep.png");

    private FileChooser kepValaszto = new FileChooser();

    private File kivalasztottKep;

    private Integer tagKora = 0;

    private LocalDate maiNap = LocalDate.now();

    private byte[] kepByte;

    private Boolean vanKep = false;

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
    private TextField varosNevBevitel;

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

    @FXML
    private ImageView vezeteknevEllenoriz;

    @FXML
    private ImageView keresztnevEllenoriz;

    @FXML
    private ImageView nemEllenoriz;

    @FXML
    private ImageView szuldatumEllenoriz;

    @FXML
    private ImageView varosEllenoriz;

    @FXML
    private ImageView berletvalasztasEllenoriz;

    private String megyeNev;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logolo.debug("Tag hozzáadása felület elindítva.");
        kepMegjelenites.setImage(nincsKep);
        bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
        konditeremNeve.setText(foAblakKezelo.getBejelentkezettKonditerem().getKonditeremNeve());

        beiratkozasBevitel.setText(maiNap.toString());

        tallozasGomb.setText("Tallózás");

        List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                .konditeremOsszesBerlete(bejelentkezettKonditerem);
        logolo.debug("A bejelentkezett konditrem bérletei: " + konditeremBerletek);
        for (KonditeremBerletVo berletek : konditeremBerletek) {
            berletValasztas.getItems().add(berletek.getBerletNeve());
        }
        logolo.info("A berletek neveinek betöltese kesz a választo listaba.");

        List<TelepulesekVo> telepulesek = telepulesekSzolgaltatas.osszesTelepules();

        ArrayList<String> telepulesNevek = new ArrayList<>();

        for (TelepulesekVo telep : telepulesek) {
            telepulesNevek.add(telep.getTelepulesnev());
            varosNevBevitel.textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals(telep.getTelepulesnev())) {
                    megyeNev = telep.getMegye();
                }
            });
        }
        ArrayList<String> telepNev = duplakTorlese(telepulesNevek);

        TextFields.bindAutoCompletion(varosNevBevitel, telepNev);

    }

    @FXML
    public void tallozas() throws IOException {
        logolo.info("Tallózás gombra kattintva.");
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
            logolo.debug("A kiválasztott kep beallítva.");
            tallozasGomb.setText("Módosítás");

        } else {
            kepMegjelenites.setImage(nincsKep);
            vanKep = false;
            tallozasGomb.setText("Tallózás");
            logolo.debug("Nincs kép kiválasztva, a NincsKep kép lesz berakva");
        }

    }

    @FXML
    public void kepenTallozas() throws IOException {
        logolo.info("Képre kattintva a tallózáshot.");
        kepValaszto.getExtensionFilters().addAll(new ExtensionFilter("Image Files (*.png , *.jpg)", "*.png", "*.jpg"));
        kivalasztottKep = kepValaszto.showOpenDialog(null);

        if (kivalasztottKep != null) {
            Image image = new Image(kivalasztottKep.toURI().toString(), 195, 185, false, false);
            kepByte = new byte[(int) kivalasztottKep.length()];
            FileInputStream fileInputStream = new FileInputStream(kivalasztottKep);
            fileInputStream.read(kepByte);
            fileInputStream.close();

            kepMegjelenites.setImage(image);
            logolo.debug("A kiválasztott kép beállítva.");
            tallozasGomb.setText("Módosítás");
            vanKep = true;
        } else {

            vanKep = false;
            kepMegjelenites.setImage(nincsKep);
            tallozasGomb.setText("Tallózás");
            logolo.debug("Nincs kep kivalasztva, a NincsKep kep lesz berakva!");
        }
    }

    @FXML
    public void kepTorlese() {
        logolo.debug("Kep torlesere kattintva.\n Nincs kep kep berakva.");
        kepMegjelenites.setImage(nincsKep);
        tallozasGomb.setText("Tallózás");
        vanKep = false;
    }

    @FXML
    public void hozzaadas() throws IOException {
        logolo.info("Hozzáadás gombra kattintva.");

        boolean mehet = false;
        boolean kotelezo = false;

        if (vezeteknevBevitel.getText().isEmpty()) {
            vezeteknevEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nincs megadva vezeteknev!");
        } else {
            vezeteknevEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("Vezeteknev megadva!");
        }

        if (keresztnevBevitel.getText().isEmpty()) {
            keresztnevEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nincs megadva keresztnev!");
        } else {
            keresztnevEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("Keresztnev megadva!");
        }

        if (!ferfiValasztasGomb.isSelected() && !noValasztasGomb.isSelected()) {
            nemEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nincs kivalasztva sem a no sem a ferfi");
        } else if (ferfiValasztasGomb.isSelected() || noValasztasGomb.isSelected()) {
            nemEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("No vagy ferfi kiválasztva");
        }

        if (szuldatumBevitel.getValue() == null) {
            szuldatumEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nincs megadva szuletesi datum!");
        } else {
            tagKora = korSzamolas(szuldatumBevitel.getValue());
            szuldatumEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("Szuletesi datum megadva!");
        }

        if (varosNevBevitel.getText().isEmpty()) {
            varosEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nincs megadva a tag varosanak a neve!");
        } else {
            varosEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("Tag varosanak a neve megadva!");
        }

        if (berletValasztas.getValue() == null) {
            berletvalasztasEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
            logolo.debug("Nem tortent berlet kivalasztas!");
        } else {
            berletvalasztasEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
            logolo.debug("Berlet kivalasztva!");
        }

        if (kotelezo) {
            tagHozzaadasUzenet.setFill(Color.RED);
            tagHozzaadasUzenet.setText("A csilaggal megjelölt adatok megadása kötelező!");
            logolo.debug("A csilaggal megjelölt dolgok nem lettek megadva!");
            mehet = false;
        } else if (mehet) {
            KonditeremTagVo ujTag = new KonditeremTagVo();
            KonditeremTagKepeVo ujTagKepe = new KonditeremTagKepeVo();
            ujTag.setTagNeve(vezeteknevBevitel.getText() + " " + keresztnevBevitel.getText());
            ujTag.setTagVezeteknev(vezeteknevBevitel.getText());
            ujTag.setTagKeresztnev(keresztnevBevitel.getText());
            ujTag.setTagNeme(nemValasztas());
            ujTag.setTagSzuletesidatuma(szuldatumBevitel.getValue());
            ujTag.setTagKora(tagKora);
            ujTag.setBerletVasarlasideje(maiNap);
            ujTag.setVasaroltBerletNeve(berletValasztas.getValue());

            List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                    .konditeremOsszesBerlete(bejelentkezettKonditerem);

            for (KonditeremBerletVo berletek : konditeremBerletek) {

                if (berletValasztas.getValue().equals(berletek.getBerletNeve()) && berletValasztas.getValue().contains("Időkorlátos")) {
                    int nap = berletek.getMennyiNap();
                    int honap = berletek.getMennyiHonap();
                    ujTag.setVasaroltBerletTipusa(berletek.getBerletTipusa());
                    if (nap > 0) {
                        ujTag.setBerletLejaratiIdeje(maiNap.plusDays(nap).minusDays(1));
                    } else if (honap > 0) {
                        ujTag.setBerletLejaratiIdeje(maiNap.plusMonths(honap));
                    }
                    ujTag.setKonditeremBerlet(berletek);
                    break;
                }

                if (berletValasztas.getValue().equals(berletek.getBerletNeve()) && berletValasztas.getValue().contains("Alkalmas")) {
                    int alkalom = berletek.getMennyiAlkalom();
                    if (alkalom > 0) {
                        ujTag.setVasaroltBerletTipusa(berletek.getBerletTipusa());
                        ujTag.setBerletLejaratiIdeje(LocalDate.now());
                        ujTag.setMennyiAlkalomMeg(alkalom);
                    }
                    ujTag.setKonditeremBerlet(berletek);
                    break;
                }

            }

            ujTag.setLejartBerletNeve("Nem volt még bérlete!");
            ujTag.setTagVarosa(varosNevBevitel.getText());
            ujTag.setTagMegyeje(megyeNev);


            if (vanKep) {
                ujTagKepe.setTagKep(kepByte);
            } else {
                ujTagKepe.setTagKep(nincsKep());
            }

            bejelentkezettKonditerem.setTagokSzama(bejelentkezettKonditerem.getTagokSzama() + 1);

            konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

            ujTag.setKonditerem(bejelentkezettKonditerem);

            ujTagKepe.setKonditeremTag(ujTag);

            konditeremTagKepeSzolgaltatas.leterehozTagKepet(ujTagKepe);

            foAblakKezelo.adatFrissites();

            ((Stage) megseGomb.getScene().getWindow()).close();
            KiegeszitoFelulet.ertesites("Tag Hozzáadása", "A tag sikeresen hozzáadva!", "Tag sikeresen hozzáadava : " + vezeteknevBevitel.getText() + " " + keresztnevBevitel.getText() + "névvel.", "Tag létrehozása után.", Pos.BOTTOM_RIGHT, 5);
        }
    }

    private int korSzamolas(LocalDate szuletesiDatum) {
        return (int) ChronoUnit.YEARS.between(szuletesiDatum, maiNap);
    }

    private String nemValasztas() {
        String tagNeme = null;
        if (ferfiValasztasGomb.isSelected()) {
            logolo.debug("Ferfi gombra kattintva!");
            tagNeme = "Férfi";
        } else if (noValasztasGomb.isSelected()) {
            tagNeme = "Nő";
            logolo.debug("No gombra kattintva!");
        }

        return tagNeme;

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

    private ArrayList<String> duplakTorlese(ArrayList<String> lista) {
        ArrayList<String> eredmeny = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        for (String eleme : lista) {

            if (!set.contains(eleme)) {
                eredmeny.add(eleme);
                set.add(eleme);
            }
        }
        return eredmeny;
    }

    @FXML
    public void megse() throws IOException {
        ((Stage) megseGomb.getScene().getWindow()).close();
        logolo.info("Mégse gomb megnyomva, így a konditerem nem adott hozzá új tagot.");
    }

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

}
