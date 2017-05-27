//CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.felulet;

import hu.unideb.inf.kondibazis.ui.kezelo.BejelentkezoKezelo;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public final class FeluletBetoltese {

    private static final SpringFxmlLoader loader = new SpringFxmlLoader();

    private static final String alkalmazasNeve = "KondiBázis";

    public static final Image ikon = new Image("/kepek/icon.png");

    public static final Image joBeirt = new Image("/kepek/pipa.png");

    public static final Image rosszBeirt = new Image("/kepek/x.png");

    public static final Image visszaGomb = new Image("/kepek/visszaGomb.png");

    public static void InditasiFelulet(Stage primaryStage) {
        Parent root = (Parent) loader.load("/fxml/InditasiKepernyoFelulet.fxml");
        Scene scene = new Scene(root);

        primaryStage.setTitle(alkalmazasNeve);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.getIcons().add(ikon);
        primaryStage.show();
    }

    public static void BejelentkezoFelulet(ActionEvent event) {
        Parent parent = (Parent) loader.load("/fxml/BejelentkezoFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Bejelentkezés - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void RegisztralasiFelulet(ActionEvent event) {
        Parent parent = (Parent) loader.load("/fxml/RegisztraciosFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Terem Regisztrálása - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void KonditeremElerhetosegFelulet(ActionEvent event) {
        Parent parent = (Parent) loader.load("/fxml/KonditeremElerhetosegFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Elérhetőség - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void NevjegyFelulet(ActionEvent event) {
        Parent root = (Parent) loader.load("/fxml/NevjegyFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Névjegy - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void RegisztraltKonditermekFelulet(ActionEvent event) {
        Parent root = (Parent) loader.load("/fxml/RegisztraltKonditeremekFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Regisztralt Konditermek - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void FoAblakFelulet(ActionEvent event) {
        Parent root = (Parent) loader.load("/fxml/KondiBazisFoAblakFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public static void BerletLetrehozasaFelulet() {
        Parent root = (Parent) loader.load("/fxml/BerletLetrehozasaFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Bérlet Létrehozása - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void BerletekModositasaFelulet() {
        Parent root = (Parent) loader.load("/fxml/BerletModositasaFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Bérletek Módosítása - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void TagHozzaadasaFelulet() {
        Parent root = (Parent) loader.load("/fxml/TagHozzaadasaFelulet.fxml");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Tag Hozzáadása -" + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void KonditeremElerhetosegSzekeszteseFelulet() {
        Parent parent = (Parent) loader.load("/fxml/KonditeremElerhetosegeiFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Elérhetőség  - " + alkalmazasNeve);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void VarosStatisztikaFelulet() {
        Parent parent = (Parent) loader.load("/fxml/VarosStatisztikaFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Város statisztika  - " + alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void MegyeStatisztikaFelulet() {
        Parent parent = (Parent) loader.load("/fxml/MegyeStatisztikaFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Megye statisztika  - " + alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void NemekStatisztikaFelulet() {
        Parent parent = (Parent) loader.load("/fxml/NemekStatisztikaFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Nemek statisztika  - " + alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

    public static void BerletTipusStatisztikaFelulet() {
        Parent parent = (Parent) loader.load("/fxml/BerletTipusStatisztikaFelulet.fxml");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Bérlettípus statisztika  - " + alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.getIcons().add(ikon);
        stage.show();
    }

}
