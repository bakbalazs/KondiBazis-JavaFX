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
	private static String alkalmazásNeve = "KondiBázis";
	private static final Image icon = new Image("/kepek/icon.png");
	private static final String visszaGomb = new String("/css/visszaGomb.css");

	public static void InditasiFelulet(Stage primaryStage) {
		Parent root = (Parent) loader.load("/fxml/InditasiKepernyoFelulet.fxml");
		Scene scene = new Scene(root);

		primaryStage.setTitle(getAlkalmazásNeve());
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.getIcons().add(icon);
		primaryStage.show();
	}

	public static void BejelentkezoFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/BejelentkezoFelulet.fxml");
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Bejelentkezés - " + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void RegisztralasiFelulet(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/RegisztraciosFelulet.fxml");
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Terem Regisztrálása - " + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void NevjegyFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/NevjegyFelulet.fxml");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(visszaGomb);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Névjegy - " + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void BerletHozzaadasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/BerletTipusHozzaadasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Bérlet létrehozása - " + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void FoAblakFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/FoAblakFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(getAlkalmazásNeve() + " - " + BejelentkezoKezelo.getBejelentkezettKonditeremNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
	}

	public static void BerletLetrehozasaFoAblakFelulet() {
		Parent root = (Parent) loader.load("/fxml/BerletLetrehozasFoAblakFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Bérlet létrehozása - " + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(icon);
		stage.show();
	}

	public static void TagHozzaadasaFelulet(ActionEvent event) {
		Parent root = (Parent) loader.load("/fxml/TaghozzaadasaFelulet.fxml");
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Tag Hozzáadása -" + getAlkalmazásNeve());
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.getIcons().add(icon);
		stage.show();
	}

	public static String getAlkalmazásNeve() {
		return alkalmazásNeve;
	}

	public static void setAlkalmazásNeve(String alkalmazásNeve) {
		FeluletBetoltese.alkalmazásNeve = alkalmazásNeve;
	}

}
