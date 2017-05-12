// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class BejelentkezoKezelo implements Initializable {

    private static Logger logolo = LoggerFactory.getLogger(BejelentkezoKezelo.class);

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    private KonditeremVo bejelentkezettKonditerem;

    private static String konditeremNeve;

    @FXML
    private TextField felhasznalonevBevitel;

    @FXML
    private PasswordField jelszoBevitel;

    @FXML
    private Text bejelentkezoUzenet;

    @FXML
    private Button visszaGomb;

    @FXML
    private ImageView felhasznalonevJoRossz;

    @FXML
    private ImageView jelszoJoRossz;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logolo.info("Elindult a bejeletkező felület.");
        bejelentkezoUzenet.setFill(Color.GREEN);
        bejelentkezoUzenet.setText(KonditeremElerhetosegKezelo.getBejelentkezesUzenet());
        felhasznalonevBevitel.setText(KonditeremElerhetosegKezelo.getFelhasznalo());
    }

    @FXML
    public void bejelentkezes(ActionEvent event) throws Exception {
        logolo.debug("Bejeletkezés gomb megnyomva!");
        KonditeremVo konditerem = konditeremSzolgaltatas.keresFelhasznalonevet(felhasznalonevBevitel.getText());

        if (konditerem == null) {
            bejelentkezoUzenet.setFill(Color.RED);
            bejelentkezoUzenet.setText("Nincs ilyen nevű felhasználó!");
            logolo.debug("A felhasználó nem létezik " + felhasznalonevBevitel.getText());
            felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            felhasznalonevBevitel.clear();
            jelszoBevitel.clear();
        } else {
            if (konditerem.getJelszo().equals(jelszoBevitel.getText())) {
                bejelentkezettKonditerem = konditerem;
                setKonditeremNeve(konditerem.getKonditeremNeve());
                FeluletBetoltese.FoAblakFelulet(event);
                logolo.debug("A felhasználó sikeresen bejelentkezett: " + felhasznalonevBevitel.getText());

            } else {
                bejelentkezoUzenet.setFill(Color.RED);
                bejelentkezoUzenet.setText("Helytelen jelszó!");
                felhasznalonevJoRossz.setImage(FeluletBetoltese.joBeirt);
                jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
                jelszoBevitel.clear();
                logolo.debug("Helytelen jelszó!" + " " + jelszoBevitel.getText());
            }
        }

    }

    @FXML
    public void regisztralas(ActionEvent event) throws IOException {
        logolo.debug("Regisztrálás felület indul.");
        FeluletBetoltese.RegisztralasiFelulet(event);
    }

    @FXML
    public void vissza(ActionEvent event) throws IOException {
        logolo.debug("Indítása felület indul.");
        FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
    }

    public KonditeremVo getBejelentkezettKonditerem() {
        return bejelentkezettKonditerem;
    }

    public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
        this.bejelentkezettKonditerem = bejelentkezettKonditerem;
    }

    public static String getKonditeremNeve() {
        return konditeremNeve;
    }

    public static void setKonditeremNeve(String konditeremNeve) {
        BejelentkezoKezelo.konditeremNeve = konditeremNeve;
    }

}
