package hu.unideb.inf.kondibazis.ui.felulet;

import hu.unideb.inf.kondibazis.szolg.kontener.SzovegTartalom;
import hu.unideb.inf.kondibazis.szolg.kontener.TartalomBetoltese;
import hu.unideb.inf.kondibazis.ui.kezelo.BejelentkezoKezelo;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public final class FeluletBetoltese {

	private static final SpringFxmlLoader loader = new SpringFxmlLoader();
	private static final String visszaGomb = new String("/css/visszaGomb.css");

	public static final Image ikon = new Image("/kepek/icon.png");

	public static final Image joBeirt = new Image("/kepek/pipa.png");

	public static final Image rosszBeirt = new Image("/kepek/x.png");

	public static void InditasiFelulet(Stage primaryStage) {
		Parent root = (Parent) loader.load("/fxml/InditasiKepernyoFelulet.fxml");
		Scene scene = new Scene(root);

		primaryStage.setTitle(SzovegTartalom.alkalmazasNeve);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(ikon);
		primaryStage.show();
	}

	public static void BejelentkezoFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/BejelentkezoFelulet.fxml");
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Bejelentkezés - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void RegisztralasiFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/RegisztraciosFelulet.fxml");
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Terem Regisztrálása - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void KonditeremElerhetosegFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/KonditeremElerhetosegFelulet.fxml");
		Scene scene = new Scene(parent);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Elérhetőség - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void NevjegyFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/NevjegyFelulet.fxml");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Névjegy - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void FoAblakFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/KondiBazisFoAblakFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(SzovegTartalom.alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void BerletLetrehozasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/BerletLetrehozasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Bérlet Létrehozása - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(ikon);
		stage.show();
	}

	public static void BerletekModositasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/BerletekModositasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Bérletek Módosítása - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(ikon);
		stage.show();
	}

	public static void TagHozzaadasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/TaghozzaadasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Tag Hozzáadása -" + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(ikon);
		stage.show();
	}

	public static void KonditeremElerhetosegSzekeszteseFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/KonditeremElerhetosegSzerkesztesFelulet.fxml");
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setTitle("Elérhetőség  - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(ikon);
		stage.show();
	}

}
