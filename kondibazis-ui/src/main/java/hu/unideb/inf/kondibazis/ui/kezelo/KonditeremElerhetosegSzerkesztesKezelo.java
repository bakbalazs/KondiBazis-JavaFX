// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.kiegeszito.EmailHitelesito;
import hu.unideb.inf.kondibazis.ui.kiegeszito.TelefonszamHitelesíto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class KonditeremElerhetosegSzerkesztesKezelo implements Initializable {

    private static final Logger logolo = LoggerFactory.getLogger(KonditeremElerhetosegSzerkesztesKezelo.class);

    @Autowired
    private KonditeremElerhetosegSzolgaltatas konditeremElerhetosegSzolgaltatas;

    @Autowired
    private TelepulesekSzolgaltatas telepulesekSzolgaltatas;

    @FXML
    private TextField megyeNeveBevitel;

    @FXML
    private TextField varosNeveBevitel;

    @FXML
    private TextField iranyitoszamBevitel;

    @FXML
    private TextField utcaNeveBevitel;

    @FXML
    private TextField hazSzamBevitel;

    @FXML
    private TextField emeletBevitel;

    @FXML
    private TextField ajtoBevitel;

    @FXML
    private TextField telefonszamBevitel;

    @FXML
    private TextField emailBevitel;

    @FXML
    private TextField weboldalBevitel;

    @FXML
    private TextField facebookBevitel;

    @FXML
    private Text elerhetosegHiba;

    @FXML
    private Button megseGomb;

    @FXML
    private ImageView megyeJoRossz;

    @FXML
    private ImageView iranyitoszamJoRossz;

    @FXML
    private ImageView varosJoRossz;

    @FXML
    private ImageView utcaJoRossz;

    @FXML
    private ImageView hazSzamJoRossz;

    @FXML
    private ImageView teloszamJoRossz;

    @FXML
    private ImageView emailJoRossz;

    private boolean kotelezoVaros;

    private boolean kotelezoTelefonSzam;

    @Autowired
    private KonditeremElerhetosegeiKezelo konditeremElerhetosegeiKezelo;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    private KonditeremElerhetosegVo kivalasztott;

    private KonditeremVo bejelentkezett;

    private static String nincsMegadva = "Nincs Megadva";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        megyeNeveBevitel.setEditable(false);
        varosNeveBevitel.setEditable(false);
        logolo.debug("Elérhetőség szerekezstése felület elindult!");
        adatBetoltese();

        iranyitoszamBevitel.setOnKeyReleased(kulcsEsemeny -> {

            if (iranyitoszamBevitel.getLength() == 4) {
                int iranyitoszamBeir = Integer.parseInt(iranyitoszamBevitel.getText());
                TelepulesekVo telepulesAdat = telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir);
                kotelezoVaros = false;
                if (telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir) == null) {
                    megyeNeveBevitel.setText("");
                    varosNeveBevitel.setText("");
                    elerhetosegHiba.setFill(Color.RED);
                    elerhetosegHiba.setText("A megadott irányítószám nem létezik!\n");
                    logolo.debug("A megadott itányítószám nem létezik!");
                    kotelezoVaros = false;
                } else if (telepulesAdat.getTelepulesnev() != null) {
                    megyeNeveBevitel.setText(telepulesAdat.getMegye());
                    varosNeveBevitel.setText(telepulesAdat.getTelepulesnev());
                    kotelezoVaros = true;
                }
            } else if (iranyitoszamBevitel.getText().isEmpty()) {
                megyeNeveBevitel.setText("");
                varosNeveBevitel.setText("");
                elerhetosegHiba.setFill(Color.RED);
                elerhetosegHiba.setText("Nincs megadva irányítószám!\n");
                logolo.debug("Nincs megadva irányítószám!");
                kotelezoVaros = false;
            }

        });


        telefonszamBevitel.setOnKeyReleased(kulcsEsemeny -> {

            if (telefonszamBevitel.getText().length() == 2) {
                telefonszamBevitel.setText(telefonszamBevitel.getText() + "-");
                telefonszamBevitel.positionCaret(telefonszamBevitel.getText().length());
            } else if (telefonszamBevitel.getText().length() == 6) {
                telefonszamBevitel.setText(telefonszamBevitel.getText() + "-");
                telefonszamBevitel.positionCaret(telefonszamBevitel.getText().length());
            }

            if (telefonszamBevitel.getLength() == 10) {
                kotelezoTelefonSzam = TelefonszamHitelesíto.vezetekesHitelesitese(telefonszamBevitel.getText());
            } else if (telefonszamBevitel.getLength() == 11) {
                kotelezoTelefonSzam = TelefonszamHitelesíto.mobilHitelesitese(telefonszamBevitel.getText());
            }

        });

    }

    private void adatBetoltese() {
        kivalasztott = konditeremElerhetosegeiKezelo.getKivalasztottElerhetoseg();
        bejelentkezett = foAblakKezelo.getBejelentkezettKonditerem();

        megyeNeveBevitel.setText(kivalasztott.getKonditeremVarosanakMegyeje());
        varosNeveBevitel.setText(kivalasztott.getKonditeremVarosanakNeve());
        iranyitoszamBevitel.setText(kivalasztott.getKonditeremVarosanakIranyitoSzama().toString());
        utcaNeveBevitel.setText(kivalasztott.getUtcaNeve());
        hazSzamBevitel.setText(kivalasztott.getHazSzam());
        emeletBevitel.setText(kivalasztott.getEmeletSzam());
        ajtoBevitel.setText(kivalasztott.getAjtoSzam());
        telefonszamBevitel.setText(kivalasztott.getKonditremTelefonszam());
        emailBevitel.setText(kivalasztott.getKonditremEmailCim());
        weboldalBevitel.setText(kivalasztott.getKonditeremWeboldalLink());
        facebookBevitel.setText(kivalasztott.getKonditeremFacebookOldalLink());
    }

    @FXML
    public void mentes() throws Exception {
        boolean mehet;

        if (!kotelezoVaros) {
            mehet = false;
            iranyitoszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            varosJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            megyeJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            elerhetosegHiba.setFill(Color.RED);
            elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
            logolo.debug("A csillaggal megjelölt adatok nincsenek megadva!");
        } else {
            mehet = true;
            iranyitoszamJoRossz.setImage(FeluletBetoltese.joBeirt);
            varosJoRossz.setImage(FeluletBetoltese.joBeirt);
            megyeJoRossz.setImage(FeluletBetoltese.joBeirt);
        }

        if (utcaNeveBevitel.getText().isEmpty()) {
            mehet = false;
            utcaJoRossz.setImage(FeluletBetoltese.rosszBeirt);
        } else {
            mehet = true;
            utcaJoRossz.setImage(FeluletBetoltese.joBeirt);
        }

        if (hazSzamBevitel.getText().isEmpty()) {
            mehet = false;
            hazSzamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
        } else {
            mehet = true;
            hazSzamJoRossz.setImage(FeluletBetoltese.joBeirt);
        }

        if (telefonszamBevitel.getLength() < 10 || telefonszamBevitel.getLength() > 11) {
            mehet = false;
            teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            elerhetosegHiba.setFill(Color.RED);
            elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
        }

        if (!kotelezoTelefonSzam) {
            mehet = false;
            teloszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            elerhetosegHiba.setFill(Color.RED);
            elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
        } else {
            mehet = true;
            teloszamJoRossz.setImage(FeluletBetoltese.joBeirt);
        }

        if (emailBevitel.getLength() > 0) {
            if (!EmailHitelesito.ervenyesites(emailBevitel.getText())) {
                emailJoRossz.setImage(FeluletBetoltese.rosszBeirt);
                elerhetosegHiba.setFill(Color.RED);
                elerhetosegHiba.setText("Rossz az e-mail cím!\n");
                mehet = false;
            } else {
                emailJoRossz.setImage(FeluletBetoltese.joBeirt);
                mehet = true;
            }
        }

        if (weboldalBevitel.getText().isEmpty()) {
            weboldalBevitel.setText(nincsMegadva);
        }

        if (facebookBevitel.getText().isEmpty()) {
            facebookBevitel.setText(nincsMegadva);
        }

        if (emailBevitel.getText().isEmpty()) {
            emailBevitel.setText(nincsMegadva);
        }

        if (mehet) {
            kivalasztott.setKonditeremVarosanakIranyitoSzama(Integer.parseInt(iranyitoszamBevitel.getText()));
            kivalasztott.setKonditeremVarosanakNeve(varosNeveBevitel.getText());
            kivalasztott.setKonditeremVarosanakMegyeje(megyeNeveBevitel.getText());
            kivalasztott.setKonditeremCime(utcaNeveBevitel.getText() + " " + hazSzamBevitel.getText() + " " + emeletBevitel.getText() + " " + ajtoBevitel.getText());
            kivalasztott.setUtcaNeve(utcaNeveBevitel.getText());
            kivalasztott.setHazSzam(hazSzamBevitel.getText());
            kivalasztott.setEmeletSzam(emeletBevitel.getText());
            kivalasztott.setAjtoSzam(ajtoBevitel.getText());
            kivalasztott.setKonditremTelefonszam(telefonszamBevitel.getText());
            kivalasztott.setKonditremEmailCim(emailBevitel.getText());
            kivalasztott.setKonditeremWeboldalLink(weboldalBevitel.getText());
            kivalasztott.setKonditeremFacebookOldalLink(facebookBevitel.getText());

            konditeremElerhetosegSzolgaltatas.frissitElerhetoseget(kivalasztott);

            logolo.debug("A " + kivalasztott.getId() + " id val rendelkező elérhetőség frissítve!");

            konditeremElerhetosegeiKezelo.adatFrissites();

            ((Stage) megseGomb.getScene().getWindow()).close();

        }
    }

    @FXML
    public void megsem() {
        ((Stage) megseGomb.getScene().getWindow()).close();
        logolo.debug("Mégse gombra kattintva, nem történt módosítás!");
    }
}
