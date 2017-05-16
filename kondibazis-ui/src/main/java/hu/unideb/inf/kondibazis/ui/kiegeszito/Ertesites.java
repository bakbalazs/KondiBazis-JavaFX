package hu.unideb.inf.kondibazis.ui.kiegeszito;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ertesites {

    private static Logger logolo = LoggerFactory.getLogger(Ertesites.class);

    public static void ertesites(String cim, String megjelenoSzoveg, String logoloSzoveg, String feluletNeve) {
        Image pipa = new Image("/kepek/pipaErtesites.png", 85.0, 85.0, true, true);
        Notifications ertesites = Notifications.create().title(cim).text(megjelenoSzoveg)
                .graphic(new ImageView(pipa)).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT)
                .onAction(event -> logolo.info("Az értesítésre kattintottak: " + feluletNeve));
        logolo.info(logoloSzoveg);
        ertesites.show();
    }
}
