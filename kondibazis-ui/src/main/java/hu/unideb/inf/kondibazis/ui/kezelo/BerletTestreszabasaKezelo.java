// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class BerletTestreszabasaKezelo implements Initializable {

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    @FXML
    private Button letrehozasGomb;

    @FXML
    private Button megseGomb;

    @FXML
    private ChoiceBox<String> berletNeveValaszto;

    @FXML
    private TextField berletaraBevitel;

    @FXML
    private TextField napBevitel;

    @FXML
    private TextField honapBevitel;

    @FXML
    private Text letrehozasUzenet;

    @FXML
    private Text regisztraltKonditerem;

    @FXML
    private Text berletletrehozasUzenet;

    @FXML
    private Text bejelentkezett_Konditerem;

    private Long kivalasztottBerletId;

    @FXML
    private Text napSzoveg;

    @FXML
    private Text alkalomSzoveg;

    @FXML
    private Text honapSzoveg;

    @FXML
    private TextField alkalomBevitel;

    @FXML
    private Text berletarSzoveg;

    @FXML
    private Button modositasGomb;

    @FXML
    private Text ftJel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        alkalmasBerlet(false);
        idokorlatosBerlet(false);
        alapErtek(false);
        bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
        bejelentkezett_Konditerem.setText(bejelentkezettKonditerem.getKonditeremNeve());
        berletaraBevitel.setText("0");
        napBevitel.setText("0");
        honapBevitel.setText("0");

        List<KonditeremBerletVo> konditeremBerletek = konditeremBerletSzolgaltatas
                .konditeremOsszesBerlete(bejelentkezettKonditerem);
        for (KonditeremBerletVo berletek : konditeremBerletek) {
            berletNeveValaszto.getItems().add(berletek.getBerletNeve());

            ChangeListener<String> valtozasFigyelo = (megfigyelendo, korabbi, jelenlegi) -> {
                if (jelenlegi != null) {
                    if (jelenlegi.equals(berletek.getBerletNeve())) {
                        kivalasztottBerletId = berletek.getId();
                        if (berletek.getBerletTipusa().equals("Alkalmas bérlet")) {
                            alapErtek(true);
                            alkalmasBerlet(true);
                            idokorlatosBerlet(false);
                            berletaraBevitel.setText(Integer.toString(berletek.getBerletAra()));
                            alkalomBevitel.setText(Integer.toString(berletek.getMennyiAlkalom()));
                        } else if (berletek.getBerletTipusa().equals("Időkorlátos bérlet")) {
                            alapErtek(true);
                            idokorlatosBerlet(true);
                            alkalmasBerlet(false);
                            berletaraBevitel.setText(Integer.toString(berletek.getBerletAra()));
                            napBevitel.setText(Integer.toString(berletek.getMennyiNap()));
                            honapBevitel.setText(Integer.toString(berletek.getMennyiHonap()));
                        }
                    }
                }
            };
            berletNeveValaszto.getSelectionModel().selectedItemProperty().addListener(valtozasFigyelo);
        }

    }

    @FXML
    public void modositas() {
        KonditeremBerletVo kivalasztottBerlet = konditeremBerletSzolgaltatas.keresBerletet(kivalasztottBerletId);

        if (kivalasztottBerlet.getBerletTipusa().equals("Alkalmas bérlet")) {
            kivalasztottBerlet.setBerletAra(Integer.parseInt(berletaraBevitel.getText()));
            kivalasztottBerlet.setMennyiAlkalom(Integer.parseInt(alkalomBevitel.getText()));
            konditeremBerletSzolgaltatas.frissitKonditeremBerletet(kivalasztottBerlet);

        } else if (kivalasztottBerlet.getBerletTipusa().equals("Időkorlátos bérlet")) {
            kivalasztottBerlet.setBerletAra(Integer.parseInt(berletaraBevitel.getText()));
            kivalasztottBerlet.setMennyiHonap(Integer.parseInt(honapBevitel.getText()));
            kivalasztottBerlet.setMennyiNap(Integer.parseInt(napBevitel.getText()));
            konditeremBerletSzolgaltatas.frissitKonditeremBerletet(kivalasztottBerlet);
        }


        ((Stage) megseGomb.getScene().getWindow()).close();
    }

    @FXML
    public void megse() throws IOException {
        ((Stage) megseGomb.getScene().getWindow()).close();
    }

    private void alapErtek(boolean megjelenik) {
        berletarSzoveg.setVisible(megjelenik);
        berletaraBevitel.setVisible(megjelenik);
        modositasGomb.setVisible(megjelenik);
        ftJel.setVisible(megjelenik);
    }

    private void idokorlatosBerlet(boolean megjelenik) {
        napSzoveg.setVisible(megjelenik);
        napBevitel.setVisible(megjelenik);
        honapSzoveg.setVisible(megjelenik);
        honapBevitel.setVisible(megjelenik);
    }

    private void alkalmasBerlet(boolean megjelenik) {
        alkalomSzoveg.setVisible(megjelenik);
        alkalomBevitel.setVisible(megjelenik);
    }

}
