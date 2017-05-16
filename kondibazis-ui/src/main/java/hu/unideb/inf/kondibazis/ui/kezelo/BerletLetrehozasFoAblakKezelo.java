package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.kiegeszito.Ertesites;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class BerletLetrehozasFoAblakKezelo implements Initializable {

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private Button megseGomb;

    @FXML
    private TextField berletnevBevitel;

    @FXML
    private TextField berletaraBevitel;

    @FXML
    private TextField napBevitel;

    @FXML
    private TextField honapBevitel;

    @FXML
    private Text berletletrehozasUzenet;

    @FXML
    private Text bejelentkezett_Konditerem;

    @FXML
    private ChoiceBox<String> berlettipusValasztasa;

    @FXML
    private Text berletnevSzoveg;

    @FXML
    private Text berletaraSzoveg;

    @FXML
    private Text berletnapSzoveg;

    @FXML
    private Text berlethonapSzoveg;

    @FXML
    private Text ftJel;

    @FXML
    private TextField alakomBevitel;

    @FXML
    private Text alkalomSzoveg;

    @FXML
    private Button letrehozasGomb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idokorlatosBerlet(false);
        alkalmasBerlet(false);
        alapertek(false);
        berlettipusValasztasa.getItems().add("Alkalmas bérlet");
        berlettipusValasztasa.getItems().add("Időkorlátos bérlet");
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
            } else if (ujErtek.equals("Időkorlátos bérlet")) {
                alapertek(true);
                idokorlatosBerlet(true);
                alkalmasBerlet(false);
            }
        });


    }

    @FXML
    public void letrehozas() {

        boolean mehetAlkalmas = true;
        boolean mehetIdokorlatos = true;

        int ar;
        if (berlettipusValasztasa.getValue().equals("Alkalmas bérlet")) {
            ar = Integer.parseInt(berletaraBevitel.getText());
            int alkalom = Integer.parseInt(alakomBevitel.getText());

            if (berletnevBevitel.getText().equals("")) {
                mehetAlkalmas = false;
            }

            if (berletaraBevitel.getText().equals("")) {
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

            if (berletaraBevitel.getText().equals("") || alakomBevitel.getText().equals("")) {
                mehetAlkalmas = false;
            }

            if (mehetAlkalmas) {

                KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
                ujBerlet.setBerletNeve(berletnevBevitel.getText() + " (" + berlettipusValasztasa.getValue() + ")");
                ujBerlet.setBerletTipusa(berlettipusValasztasa.getValue());
                ujBerlet.setBerletAra(ar);
                ujBerlet.setMennyiAlkalom(alkalom);

                KonditeremBerletVo letezo = konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);

                bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);

                konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

                letezo.setKonditerem(bejelentkezettKonditerem);

                konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);

                foAblakKezelo.gombFrissites();

                ((Stage) megseGomb.getScene().getWindow()).close();
                Ertesites.ertesites("Bérlet Létrehozása", "A bérlet sikeresen létrehozva!", "A bérlet sikeresen létrehozva : " + berletnevBevitel.getText() + " névvel.", "Bérlet létrehozása után.");
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
                berletletrehozasUzenet.setText("A csilaggal megjelölt adatok megadása kötelező!");

            } else {

                KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
                ujBerlet.setBerletNeve(berletnevBevitel.getText() + " (" + berlettipusValasztasa.getValue() + ")");
                ujBerlet.setBerletTipusa(berlettipusValasztasa.getValue());
                ujBerlet.setBerletAra(ar);
                ujBerlet.setMennyiNap(nap);
                ujBerlet.setMennyiHonap(honap);


                KonditeremBerletVo letezo = konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);

                bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);

                konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);

                letezo.setKonditerem(bejelentkezettKonditerem);

                konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);

                foAblakKezelo.gombFrissites();

                ((Stage) megseGomb.getScene().getWindow()).close();
                Ertesites.ertesites("Bérlet Létrehozása", "A bérlet sikeresen létrehozva!", "A bérlet sikeresen létrehozva : " + berletnevBevitel.getText() + " névvel.", "Bérlet létrehozása után.");
            }
        }

    }

    @FXML
    public void megse() throws IOException {
        ((Stage) megseGomb.getScene().getWindow()).close();
    }


    private void alapertek(boolean megjelenes) {
        berletnevSzoveg.setVisible(megjelenes);
        berletnevBevitel.setVisible(megjelenes);
        berletaraSzoveg.setVisible(megjelenes);
        berletaraBevitel.setVisible(megjelenes);
        ftJel.setVisible(megjelenes);
        letrehozasGomb.setVisible(megjelenes);

    }

    private void idokorlatosBerlet(boolean megjelenes) {
        berletnapSzoveg.setVisible(megjelenes);
        napBevitel.setVisible(megjelenes);
        berlethonapSzoveg.setVisible(megjelenes);
        honapBevitel.setVisible(megjelenes);
    }

    private void alkalmasBerlet(boolean megjelenes) {
        alakomBevitel.setVisible(megjelenes);
        alkalomSzoveg.setVisible(megjelenes);
    }

}
