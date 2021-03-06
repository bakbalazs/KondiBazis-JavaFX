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
import javafx.event.ActionEvent;
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
public class KonditeremElerhetosegHozzaadasaKezelo implements Initializable {

    private static final Logger logolo = LoggerFactory.getLogger(KonditeremElerhetosegHozzaadasaKezelo.class);

    @Autowired
    private KonditeremElerhetosegSzolgaltatas konditeremElerhetosegSzolgaltatas;

    @Autowired
    private TelepulesekSzolgaltatas telepulesekSzolgaltatas;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    @Autowired
    private KonditeremElerhetosegeiKezelo konditeremElerhetosegeiKezelo;

    private KonditeremVo bejeletkezettKonditerem;

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

    @FXML
    private Button megseGomb;

    private boolean kotelezoVaros;

    private boolean kotelezoTelefonSzam;

    private static String nincsMegadva = "Nincs Megadva";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bejeletkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
        megyeNeveBevitel.setEditable(false);
        varosNeveBevitel.setEditable(false);

        iranyitoszamBevitel.setOnKeyReleased(kulcsEsemeny -> {

            if (iranyitoszamBevitel.getLength() == 4) {
                int iranyitoszamBeir = Integer.parseInt(iranyitoszamBevitel.getText());
                TelepulesekVo telepulesAdat = telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir);
                kotelezoVaros = false;
                if (telepulesekSzolgaltatas.keresIranyitoszamot(iranyitoszamBeir) == null) {
                    megyeNeveBevitel.setText("");
                    varosNeveBevitel.setText("");
                    elerhetosegHiba.setText("A megadott irányítószám nem létezik!\n");
                    kotelezoVaros = false;
                } else if (telepulesAdat.getTelepulesnev() != null) {
                    megyeNeveBevitel.setText(telepulesAdat.getMegye());
                    varosNeveBevitel.setText(telepulesAdat.getTelepulesnev());
                    kotelezoVaros = true;
                }
            } else if (iranyitoszamBevitel.getText().isEmpty()) {
                megyeNeveBevitel.setText("");
                varosNeveBevitel.setText("");
                elerhetosegHiba.setText("Nincs megadva irányítószám!\n");
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

    @FXML
    public void mentes(ActionEvent event) throws Exception {
        boolean mehet;

        if (!kotelezoVaros) {
            mehet = false;
            iranyitoszamJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            varosJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            megyeJoRossz.setImage(FeluletBetoltese.rosszBeirt);
            elerhetosegHiba.setFill(Color.RED);
            elerhetosegHiba.setText("A csilaggal jelölt elemek nincsennek megadva!\n");
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
            KonditeremElerhetosegVo ujElerhetoseg = new KonditeremElerhetosegVo();
            ujElerhetoseg.setKonditeremVarosanakIranyitoSzama(Integer.parseInt(iranyitoszamBevitel.getText()));
            ujElerhetoseg.setKonditeremVarosanakNeve(varosNeveBevitel.getText());
            ujElerhetoseg.setKonditeremVarosanakMegyeje(megyeNeveBevitel.getText());
            ujElerhetoseg.setKonditeremCime(utcaNeveBevitel.getText() + " " + hazSzamBevitel.getText() + " " + emeletBevitel.getText() + " " + ajtoBevitel.getText());
            ujElerhetoseg.setUtcaNeve(utcaNeveBevitel.getText());
            ujElerhetoseg.setHazSzam(hazSzamBevitel.getText());
            ujElerhetoseg.setEmeletSzam(emeletBevitel.getText());
            ujElerhetoseg.setAjtoSzam(ajtoBevitel.getText());
            ujElerhetoseg.setKonditremTelefonszam(telefonszamBevitel.getText());
            ujElerhetoseg.setKonditremEmailCim(emailBevitel.getText());
            ujElerhetoseg.setKonditeremWeboldalLink(weboldalBevitel.getText());
            ujElerhetoseg.setKonditeremFacebookOldalLink(facebookBevitel.getText());
            ujElerhetoseg.setKonditerem(bejeletkezettKonditerem);

            konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujElerhetoseg);

            konditeremElerhetosegeiKezelo.adatFrissites();

            ((Stage) megseGomb.getScene().getWindow()).close();

        }
    }

    @FXML
    public void megsem() {
        ((Stage) megseGomb.getScene().getWindow()).close();
    }
}
