package hu.unideb.inf.kondibazis.ui.felulet;

import hu.unideb.inf.kondibazis.szolg.kontener.SzovegTartalom;
import hu.unideb.inf.kondibazis.szolg.kontener.TartalomBetoltese;
import hu.unideb.inf.kondibazis.ui.kezelo.BejelentkezoKezelo;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class FeluletBetoltese {

	private static final SpringFxmlLoader loader = new SpringFxmlLoader();
	private static final String visszaGomb = new String("/css/visszaGomb.css");

	public static void InditasiFelulet(Stage primaryStage) {
		Parent root = (Parent) loader.load("/fxml/InditasiKepernyoFelulet.fxml");
		Scene scene = new Scene(root);

		primaryStage.setTitle(SzovegTartalom.alkalmazasNeve);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(TartalomBetoltese.ikon);
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
		Parent root = (Parent) loader.load("/fxml/FoAblakFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(SzovegTartalom.alkalmazasNeve + " - " + BejelentkezoKezelo.getKonditeremNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void BerletTestreszabasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/BerletTestreszabasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Bérlet Testreszabása - " + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(TartalomBetoltese.ikon);
		stage.show();
	}

	public static void TagHozzaadasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/TaghozzaadasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Tag Hozzáadása -" + SzovegTartalom.alkalmazasNeve);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(TartalomBetoltese.ikon);
		stage.show();
	}

}
