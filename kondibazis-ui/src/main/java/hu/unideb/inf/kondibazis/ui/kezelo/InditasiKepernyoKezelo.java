// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import hu.unideb.inf.kondibazis.ui.main.Inditas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InditasiKepernyoKezelo {

    private static Logger logolo = LoggerFactory.getLogger(Inditas.class);


    @FXML
    public void bejelentkezes(ActionEvent event) throws IOException {
        FeluletBetoltese.BejelentkezoFelulet(event);
        logolo.debug("Elindult a bejetkező felület.");
    }

    @FXML
    public void regisztracio(ActionEvent event) throws IOException {
        FeluletBetoltese.RegisztralasiFelulet(event);
        logolo.debug("Elindult a regisztrációs felület.");

    }

    @FXML
    public void regisztraltKonditermeink(ActionEvent event) throws IOException {
        FeluletBetoltese.RegisztraltKonditermekFelulet(event);
        logolo.debug("Elindult a regisztralt konditeremek felulet.");
    }

    @FXML
    public void kilepes() {
        SpringFxmlLoader.close();
        Platform.exit();
        logolo.debug("Kilepes gombra kattintva!");
    }

}
