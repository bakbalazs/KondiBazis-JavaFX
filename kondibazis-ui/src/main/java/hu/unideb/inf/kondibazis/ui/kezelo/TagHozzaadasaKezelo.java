// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
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
    private TextField megyeNevBevitel;

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
    private ImageView megyeEllenoriz;

    @FXML
    private ImageView berletvalasztasEllenoriz;

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
        for (KonditeremBerletVo berletek : konditeremBerletek) {
            berletValasztas.getItems().add(berletek.getBerletNeve());
        }

        List<TelepulesekVo> telepulesek = telepulesekSzolgaltatas.osszesTelepules();

        ArrayList<String> telepulesNevek = new ArrayList<>();



        for (TelepulesekVo telep : telepulesek) {
            telepulesNevek.add(telep.getTelepulesnev());
//            if(varosNevBevitel.getText().equals(telep.getTelepulesnev())) {
//               System.out.println("#####################################################################################################################");
//                System.out.println("#####################################################################################################################");
//                System.out.println("#####################################################################################################################");
//                System.out.println(telep.getMegye());
//                System.out.println("#####################################################################################################################");
//            }
        }
        ArrayList<String> telepNev = duplakTorlese(telepulesNevek);

        TextFields.bindAutoCompletion(varosNevBevitel, telepNev);

    }

    @FXML
    public void tallozas(ActionEvent event) throws IOException {
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
            logolo.debug("A kiválasztott kép beállítva.");
            tallozasGomb.setText("Módosítás");

        } else {
            // tagHozzaadasaUzenet.setFill(Color.RED);
            // tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");
            kepMegjelenites.setImage(nincsKep);
            vanKep = false;
            tallozasGomb.setText("Tallózás");
            logolo.debug("Nincs kép kiválasztva, a NincsKep kép lesz berakva");
        }

    }

    @FXML
    public void kepenTallozas(ActionEvent event) throws IOException {
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
            // tagHozzaadasaUzenet.setFill(Color.RED);
            // tagHozzaadasaUzenet.setText("Nincs kép kiválasztva!");

            vanKep = false;
            kepMegjelenites.setImage(nincsKep);
            tallozasGomb.setText("Tallózás");
            logolo.debug("Nincs kép kiválasztva, a NincsKep kép lesz berakva");

        }
    }

    @FXML
    public void kepTorlese(ActionEvent event) {
        logolo.debug("Kép törlésére kattintva.\n Nincs kép kép berakva.");
        kepMegjelenites.setImage(nincsKep);
        tallozasGomb.setText("Tallózás");
        vanKep = false;
    }

    @FXML
    public void hozzaadas(ActionEvent event) throws IOException {
        logolo.info("Hozzáadás gombra kattintva.");

        boolean mehet = false;
        boolean kotelezo = false;

        if (vezeteknevBevitel.getText().isEmpty()) {
            vezeteknevEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
        } else {
            vezeteknevEllenoriz.setImage(FeluletBetoltese.joBeirt);
            mehet = true;
        }

        if (keresztnevBevitel.getText().isEmpty()) {
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

        if (varosNevBevitel.getText().isEmpty()) {
            varosEllenoriz.setImage(FeluletBetoltese.rosszBeirt);
            mehet = false;
            kotelezo = true;
        } else {
            varosEllenoriz.setImage(FeluletBetoltese.joBeirt);
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
            tagHozzaadasUzenet.setFill(Color.RED);
            tagHozzaadasUzenet.setText("A csilaggal megjelölt adatok megadása kötelező!");
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

            long h = 0;
            long na = 0;
            long o = 0;

            List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                    .konditeremOsszesBerlete(bejelentkezettKonditerem);
            for (KonditeremBerletVo berletek : konditeremBerletek) {

                if (berletek.getBerletNeve().equals(berletValasztas.getValue()))

                    h = berletek.getMennyiHonap();
                na = berletek.getMennyiNap();
                o = berletek.getMennyiOra();
                ujTag.setBerletLejaratiIdeje(maiNap.plusMonths(h));
            }

            ujTag.setTagVarosa(varosNevBevitel.getText());


//			if (vanKep == true) {
//				ujTag.setTagKep(kepByte);
//			} else {
//				ujTag.setTagKep(nincsKep());
//			}

            KonditeremTagVo letezo = konditeremTagSzolgaltatas.leterehozTagot(ujTag);

            bejelentkezettKonditerem.getKonditeremTagok().add(letezo);

            konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

            letezo.setKonditerem(bejelentkezettKonditerem);

            konditeremTagSzolgaltatas.frissitKonditeremTagot(letezo);

            Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
            Notifications ertesites = Notifications.create().title("Tag Hozzáadása").text("A tag sikeresen hozzáadva!")
                    .graphic(new ImageView(pipa)).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                           logolo.info("Az értesítésre kattintottak.");
                        }
                    });
            logolo.info("Tag sikeresen hozzáadava : " + vezeteknevBevitel.getText() + " " + keresztnevBevitel.getText() +  "névvel.");
            foAblakKezelo.adatFrissites();
            ((Stage) megseGomb.getScene().getWindow()).close();
            ertesites.show();

        }
    }

    private int korSzamolas(LocalDate szuletesiDatum) {
        int kor = (int) ChronoUnit.YEARS.between(szuletesiDatum, maiNap);
        return kor;
    }

    private String nemValasztas() {
        String tagNeme = null;
        if (ferfiValasztasGomb.isSelected()) {
            tagNeme = "Férfi";
        } else if (noValasztasGomb.isSelected()) {
            tagNeme = "Nő";
        }

        return tagNeme;

    }

    private byte[] nincsKep() throws IOException {
        File file = new File("src/main/resources/kepek/nincsKep.png");
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

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

}
