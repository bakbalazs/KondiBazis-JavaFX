// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class RegisztralasKezelo implements Initializable {

    private static Logger logolo = LoggerFactory.getLogger(RegisztralasKezelo.class);

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    private KonditeremVo regisztraltKonditerem;

    @FXML
    private JFXTextField konditeremnevBevitel;

    @FXML
    private JFXTextField felhasznalonevBevitel;

    @FXML
    private JFXPasswordField jelszoBevitel;

    @FXML
    private Text regisztraciosUzenet;

    @FXML
    private ImageView konditeremneveJoRossz;

    @FXML
    private ImageView felhasznalonevJoRossz;

    @FXML
    private ImageView jelszoJoRossz;

    @FXML
    private ImageView visszaGombKep;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visszaGombKep.setImage(FeluletBetoltese.visszaGomb);
        logolo.info("A terem regisztrálás felület elindítva.");
    }

    @FXML
    public void regisztralas(ActionEvent event) throws Exception {

        logolo.debug("Regisztrálás gombra kattintva.");

        boolean ok = true;
        regisztraciosUzenet.setFill(Color.RED);
        regisztraciosUzenet.setText("");

        if (konditeremnevBevitel.getText().length() == 0) {
            regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Konditerem nevének a megadása kötelező!\n");
            logolo.debug("Nincs megadva konditerem név.");
            konditeremneveJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            ok = false;
        } else {
            logolo.debug("Konditerem név megadva: " + konditeremnevBevitel.getText());
            konditeremneveJoRossz.setImage(FeluletBetoltese.joBeirt);
        }

        if (felhasznalonevBevitel.getText().length() == 0) {
            regisztraciosUzenet.setText(regisztraciosUzenet.getText()
                    + "A felhasználónév min. 5 karakter!\n Felhasználónév megadása kötelező!\n");
            logolo.debug("A felhasználónév nem helyes: " + felhasznalonevBevitel.getText());
            felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            ok = false;
        }
        if (felhasznalonevBevitel.getText().length() > 0 && felhasznalonevBevitel.getText().length() < 5) {
            regisztraciosUzenet.setText(regisztraciosUzenet.getText()
                    + "A felhasználónév min. 5 karakter!\n A felhasználónév túl rövid!\n");
            logolo.debug("A felhasználónév nem helyes: " + felhasznalonevBevitel.getText());
            felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            felhasznalonevBevitel.clear();
            ok = false;
        } else if (felhasznalonevBevitel.getText().length() >= 5) {
            felhasznalonevJoRossz.setImage(FeluletBetoltese.joBeirt);
            logolo.debug("Felahsználónév megadása helyes: " + felhasznalonevBevitel.getText());
        }

        if (jelszoBevitel.getText().length() == 0) {
            regisztraciosUzenet
                    .setText(regisztraciosUzenet.getText() + "A jelszó min. 8 karakter!\n Jelszó megadása kötelező!\n");
            logolo.debug("A jelszó megadása helytelen: " + jelszoBevitel.getText());
            jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            ok = false;
        }

        if (jelszoBevitel.getText().length() > 0 && jelszoBevitel.getText().length() < 8) {
            regisztraciosUzenet
                    .setText(regisztraciosUzenet.getText() + " A jelszó min. 8 karakter!\n A jelszó túl rövid!\n");
            logolo.debug("A jelszó megadása helytelen: " + jelszoBevitel.getText());
            jelszoJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            jelszoBevitel.clear();
            ok = false;
        } else if (jelszoBevitel.getText().length() >= 8) {
            jelszoJoRossz.setImage(FeluletBetoltese.joBeirt);
            logolo.debug("Jelszó helyesen megadva.");
        }

        if (ok) {
            if (konditeremSzolgaltatas.keresKonditermet(felhasznalonevBevitel.getText()) != null) {
                regisztraciosUzenet.setText(regisztraciosUzenet.getText() + "Ilyen felhazsnáló már létezik");
                logolo.info("Ilyen felhasználó már regisztrált.");
                felhasznalonevJoRossz.setImage(FeluletBetoltese.rosszBeirt);
                felhasznalonevBevitel.clear();
            } else {
                KonditeremVo uj = new KonditeremVo();
                uj.setKonditeremNeve(konditeremnevBevitel.getText());
                uj.setFelhasznalonev(felhasznalonevBevitel.getText());
                uj.setJelszo(jelszoBevitel.getText());
                uj.setRegisztralasDatuma(LocalDate.now());
                uj.setTagokSzama(0);
                konditeremSzolgaltatas.konditeremetLetrehoz(uj);
                KonditeremVo letrehozott = konditeremSzolgaltatas
                        .keresKonditermet(felhasznalonevBevitel.getText());
                regisztraltKonditerem = letrehozott;
                logolo.info("Új felhasználó hozzáadva: " + felhasznalonevBevitel.getText());
                FeluletBetoltese.KonditeremElerhetosegFelulet(event);
            }
        }
    }

    @FXML
    public void vissza(ActionEvent event) throws IOException {
        logolo.debug("Regisztrálás felületen a vissza gombra kattintva.");
        FeluletBetoltese.InditasiFelulet(Inditas.primaryStage);
    }

    KonditeremVo getRegisztraltKonditerem() {
        return regisztraltKonditerem;
    }

    public void setRegisztraltKonditerem(KonditeremVo regisztraltKonditerem) {
        this.regisztraltKonditerem = regisztraltKonditerem;
    }

}
