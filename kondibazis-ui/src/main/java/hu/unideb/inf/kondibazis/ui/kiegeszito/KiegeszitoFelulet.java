// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kiegeszito;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class KiegeszitoFelulet {

    private static Logger logolo = LoggerFactory.getLogger(KiegeszitoFelulet.class);

    public static void ertesites(String cim, String megjelenoSzoveg, String logoloSzoveg, String feluletNeve, Pos helyzet, int mennyiIdeig) {
        Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
        Notifications ertesites = Notifications.create().title(cim).text(megjelenoSzoveg)
                .graphic(new ImageView(pipa)).hideAfter(Duration.seconds(mennyiIdeig)).position(helyzet)
                .onAction(event -> logolo.info("Az értesítésre kattintottak: " + feluletNeve));
        logolo.info(logoloSzoveg);
        ertesites.show();
    }

    public static boolean megerositesFelulet(String cim, String fejlec, String tartalom, String igenGombNev, String nemGombNev,  Alert.AlertType alertType) {
        logolo.info(cim);
        final Alert alert = new Alert(alertType);
        alert.setTitle(cim);
        alert.setHeaderText(fejlec);
        alert.setContentText(tartalom);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(FeluletBetoltese.ikon);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

        Button igenGomb = (Button) alert.getDialogPane().lookupButton(ButtonType.YES);
        igenGomb.setText(igenGombNev);
        igenGomb.setDefaultButton(false);

        Button nemGomb = (Button) alert.getDialogPane().lookupButton(ButtonType.NO);
        nemGomb.setText(nemGombNev);
        nemGomb.setDefaultButton(false);

        final Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.YES;
    }
}
