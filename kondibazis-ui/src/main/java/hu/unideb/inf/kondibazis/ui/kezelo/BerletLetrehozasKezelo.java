// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.kiegeszito.KiegeszitoFelulet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class BerletLetrehozasKezelo implements Initializable {

    private static final Logger logolo = LoggerFactory.getLogger(BerletLetrehozasKezelo.class);

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private JFXButton letrehozasGomb;

    @FXML
    private JFXButton megseGomb;

    @FXML
    private JFXTextField berletnevBevitel;

    @FXML
    private JFXTextField berletaraBevitel;

    @FXML
    private JFXTextField napBevitel;

    @FXML
    private JFXTextField honapBevitel;

    @FXML
    private Text berletletrehozasUzenet;

    @FXML
    private Text bejelentkezett_Konditerem;

    @FXML
    private ChoiceBox<String> berlettipusValasztasa;

    @FXML
    private Text ftJel;

    @FXML
    private JFXTextField alakomBevitel;

    @FXML
    private Text alkalomSzoveg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idokorlatosBerlet(false);
        alkalmasBerlet(false);
        alapertek(false);
        berlettipusValasztasa.getItems().add("Alkalmas bérlet");
        berlettipusValasztasa.getItems().add("Időkorlátos bérlet");
        logolo.info("Berlet tipusok valasztashoz feltöltve!");
        bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
        bejelentkezett_Konditerem.setText(bejelentkezettKonditerem.getKonditeremNeve());
        berletaraBevitel.setText("0");
        napBevitel.setText("0");
        honapBevitel.setText("0");
        alakomBevitel.setText("0");

        berlettipusValasztasa.valueProperty().addListener((observableValue, regiErtek, ujErtek) -> {
            if (ujErtek.equals("Alkalmas bérlet")) {
                alapertek(true);
                idokorlatosBerlet(false);
                alkalmasBerlet(true);
                logolo.debug("Alkalmas berlet kivalasztva es alap ertekkel feltoltve!");
            } else if (ujErtek.equals("Időkorlátos bérlet")) {
                alapertek(true);
                idokorlatosBerlet(true);
                alkalmasBerlet(false);
                logolo.debug("Idokorlatos berlet kivalasztva es alap ertekkel feltoltve!");
            }
        });


    }

    @FXML
    public void letrehozas() {

        // TODO
        // ha már létezik egy bérlet nével akkor ne leheseen létrehozni még1 et

        boolean mehetAlkalmas = true;
        boolean mehetIdokorlatos = true;

        int ar;
        if (berlettipusValasztasa.getValue().equals("Alkalmas bérlet")) {
            ar = Integer.parseInt(berletaraBevitel.getText());
            int alkalom = Integer.parseInt(alakomBevitel.getText());

            if (berletnevBevitel.getText().isEmpty()) {
                mehetAlkalmas = false;
            }

            if (berletaraBevitel.getText().isEmpty()) {
                mehetAlkalmas = false;
            }

            if (ar == 0) {
                mehetAlkalmas = false;
            }

            if (alkalom == 0) {
                mehetAlkalmas = false;
            }

            if ((ar > 0 && alkalom > 0)) {
                mehetAlkalmas = true;
            }

            if (berletaraBevitel.getText().isEmpty() || alakomBevitel.getText().isEmpty()) {
                mehetAlkalmas = false;
            }

            if (mehetAlkalmas) {
                int honap = Integer.parseInt(honapBevitel.getText());
                KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
                ujBerlet.setBerletNeve(berletnevBevitel.getText() + " (" + berlettipusValasztasa.getValue() + ")");
                ujBerlet.setBerletTipusa(berlettipusValasztasa.getValue());
                ujBerlet.setBerletAra(ar);
                ujBerlet.setMennyiAlkalom(alkalom);
                ujBerlet.setMennyiHonap(honap);
                ujBerlet.setKonditerem(bejelentkezettKonditerem);

                konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);
                logolo.debug("Uj alkalmas berlet letrehozva!");

                foAblakKezelo.gombFrissites();
                foAblakKezelo.adatFrissites();

                ((Stage) megseGomb.getScene().getWindow()).close();
                KiegeszitoFelulet.ertesites("Bérlet Létrehozása", "A bérlet sikeresen létrehozva!", "A bérlet sikeresen létrehozva : " + berletnevBevitel.getText() + " névvel.", "Bérlet létrehozása után.", Pos.BOTTOM_RIGHT, 5);
            }

        } else if (berlettipusValasztasa.getValue().equals("Időkorlátos bérlet")) {

            ar = Integer.parseInt(berletaraBevitel.getText());
            int nap = Integer.parseInt(napBevitel.getText());
            int honap = Integer.parseInt(honapBevitel.getText());

            if (berletnevBevitel.getText().equals("")) {
                mehetIdokorlatos = false;
            }

            if (berletaraBevitel.getText().equals("")) {
                mehetIdokorlatos = false;
            }

            if (ar == 0) {
                mehetIdokorlatos = false;
            }

            if (nap == 0 || honap == 0) {
                mehetIdokorlatos = false;
            }

            if ((ar > 0 && nap > 0) || (ar > 0 && honap > 0)) {
                mehetIdokorlatos = true;
            }

            if (berletaraBevitel.getText().equals("") || napBevitel.getText().equals("")
                    || honapBevitel.getText().equals("")) {
                mehetIdokorlatos = false;
            }

            if (!mehetIdokorlatos) {
                berletletrehozasUzenet.setFill(Color.RED);
                berletletrehozasUzenet.setText("A csilaggal megjelolt adatok megadasa kotelezo!");

            } else {

                KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
                ujBerlet.setBerletNeve(berletnevBevitel.getText() + " (" + berlettipusValasztasa.getValue() + ")");
                ujBerlet.setBerletTipusa(berlettipusValasztasa.getValue());
                ujBerlet.setBerletAra(ar);
                ujBerlet.setMennyiNap(nap);
                ujBerlet.setMennyiHonap(honap);
                ujBerlet.setKonditerem(bejelentkezettKonditerem);

                konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);
                logolo.debug("Uj idokorlatos berlet letrehozva!");

                foAblakKezelo.gombFrissites();
                foAblakKezelo.adatFrissites();

                ((Stage) megseGomb.getScene().getWindow()).close();
                KiegeszitoFelulet.ertesites("Bérlet Létrehozása", "A bérlet sikeresen létrehozva!", "A bérlet sikeresen létrehozva : " + berletnevBevitel.getText() + " névvel.", "Bérlet létrehozása után.", Pos.BOTTOM_RIGHT, 5);
            }
        }

    }

    @FXML
    public void megse() throws IOException {
        ((Stage) megseGomb.getScene().getWindow()).close();
        logolo.debug("Megse gombra kattintva!");
    }


    private void alapertek(boolean megjelenes) {
//        berletnevSzoveg.setVisible(megjelenes);
        berletnevBevitel.setVisible(megjelenes);
//        berletaraSzoveg.setVisible(megjelenes);
        berletaraBevitel.setVisible(megjelenes);
//        ftJel.setVisible(megjelenes);
        letrehozasGomb.setVisible(megjelenes);
//        berlethonapSzoveg.setVisible(megjelenes);
        honapBevitel.setVisible(megjelenes);
    }

    private void idokorlatosBerlet(boolean megjelenes) {
//        berletnapSzoveg.setVisible(megjelenes);
        napBevitel.setVisible(megjelenes);
    }

    private void alkalmasBerlet(boolean megjelenes) {
        alakomBevitel.setVisible(megjelenes);
//        alkalomSzoveg.setVisible(megjelenes);
    }

}
