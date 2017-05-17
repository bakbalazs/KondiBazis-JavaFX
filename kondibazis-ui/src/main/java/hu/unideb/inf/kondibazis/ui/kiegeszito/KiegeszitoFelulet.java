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

    public static void ertesites(String cim, String megjelenoSzoveg, String logoloSzoveg, String feluletNeve) {
        Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
        Notifications ertesites = Notifications.create().title(cim).text(megjelenoSzoveg)
                .graphic(new ImageView(pipa)).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT)
                .onAction(event -> logolo.info("Az értesítésre kattintottak: " + feluletNeve));
        logolo.info(logoloSzoveg);
        ertesites.show();
    }

    public static boolean kijeletkezesMegerositesFelulet(String cim, String fejlec, String tartalom, Alert.AlertType alertType) {
        logolo.info("Kijeletkezés megerősítrése ablak.");
        final Alert alert = new Alert(alertType);
        alert.setTitle(cim);
        alert.setHeaderText(fejlec);
        alert.setContentText(tartalom);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(FeluletBetoltese.ikon);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

        Button yesButton = (Button) alert.getDialogPane().lookupButton(ButtonType.YES);
        yesButton.setText("Kijeletkezés");
        yesButton.setDefaultButton(false);

        Button noButton = (Button) alert.getDialogPane().lookupButton(ButtonType.NO);
        noButton.setText("Mégsem");
        noButton.setDefaultButton(true);

        final Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.YES;
    }
}
