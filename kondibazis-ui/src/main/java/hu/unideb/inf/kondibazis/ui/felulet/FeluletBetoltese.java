package hu.unideb.inf.kondibazis.ui.felulet;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FeluletBetoltese {

	private FXMLLoader loader = new FXMLLoader();
	private Stage stage = new Stage();
	private Pane parent = new Pane();
	private String alkalmazásNeve = "KondiBázis";

	public void iconBeallitasa() {
		stage.getIcons().add(new Image("/kepek/icon.png"));
	}

	public void visszaGombBeallitasa() {
		parent.getStylesheets().add(getClass().getResource("/css/visszaGomb.css").toString());
	}

	public void InditasiFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/InditasiKepernyoFelulet.fxml").openStream());
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle(getAlkalmazásNeve());
		stage.show();
	}

	public void BelepesiFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/BejelentkezoFelulet.fxml").openStream());
		visszaGombBeallitasa();
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Bejeletkezés - " + getAlkalmazásNeve());
		stage.show();
	}

	public void RegisztralasiFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/RegisztraciosFelulet.fxml").openStream());
		visszaGombBeallitasa();
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Terem Regisztrálása - " + getAlkalmazásNeve());
		stage.show();
	}

	public void NevjegyFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/NevjegyFelulet.fxml").openStream());
		visszaGombBeallitasa();
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Névjegy - " + getAlkalmazásNeve());
		stage.show();
	}

	public void BerletHozzaadasaFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/BerletTipusHozzaadasaFelulet.fxml").openStream());
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Bérlet létrehozása - " + getAlkalmazásNeve());
		stage.show();
	}

	public void FoAblakFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/FoAblakFelulet.fxml").openStream());
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle(getAlkalmazásNeve());
		stage.show();
	}

	public void BerletLetrehozasaFoAblakFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/BerletLetrehozasFoAblakFelulet.fxml").openStream());
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Bérlet létrehozása - " + getAlkalmazásNeve());
		stage.show();
	}

	public void TagHozzaadasaFelulet() throws IOException {
		parent = loader.load(getClass().getResource("/fxml/TaghozzaadasaFelulet.fxml").openStream());
		iconBeallitasa();
		Scene scene = new Scene(parent);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Tag Hozzáadása -" + getAlkalmazásNeve());
		stage.show();
	}

	public String getAlkalmazásNeve() {
		return alkalmazásNeve;
	}

	public void setAlkalmazásNeve(String alkalmazásNeve) {
		this.alkalmazásNeve = alkalmazásNeve;
	}

}
