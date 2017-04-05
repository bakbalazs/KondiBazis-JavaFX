package hu.unideb.inf.kondibazis.ui.felulet;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FeluletBetoltese {
	
	private FXMLLoader loader = new FXMLLoader();
	private Stage stage = new Stage();
	private String alkalmazásNeve = "KondiBázis";
	
	public void InditasiFelulet() throws IOException{
		Pane parent = loader.load(getClass().getResource("/fxml/InditasiKepernyoFelulet.fxml").openStream());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
//		stage.getIcons().add(new Image("/images/kondibazis.png"));
		stage.setTitle(getAlkalmazásNeve());
		stage.show();
	}
	
	public void BelepesiFelulet() throws IOException {
		Pane parent = loader.load(getClass().getResource("/fxml/BejelentkezoFelulet.fxml").openStream());
		parent.getStylesheets().add(getClass().getResource("/css/visszaGomb.css").toString());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
	//	stage.getIcons().add(new Image("/images/kondibazis.png"));
		stage.setTitle("Bejeletkezés - " + getAlkalmazásNeve());
		stage.show();
	}
	
	public void RegisztralasiFelulet() throws IOException {
		Pane parent = loader.load(getClass().getResource("/fxml/RegisztraciosFelulet.fxml").openStream());
		parent.getStylesheets().add(getClass().getResource("/css/visszaGomb.css").toString());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
	//	stage.getIcons().add(new Image("/images/kondibazis.png"));
		stage.setTitle("Terem Regisztrálása - " + getAlkalmazásNeve());
		stage.show();
	}
	
	public void NevjegyFelulet() throws IOException{
		Pane parent = loader.load(getClass().getResource("/fxml/NevjegyFelulet.fxml").openStream());
		parent.getStylesheets().add(getClass().getResource("/css/visszaGomb.css").toString());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
//		stage.getIcons().add(new Image("/images/kondibazis.png"));
		stage.setTitle("Névjegy - " + getAlkalmazásNeve());
		stage.show();
	}
	
	/// átírni őket sorendbe
	
	public void FoAblakFelulet() throws IOException{
		Pane parent = loader.load(getClass().getResource("/fxml/FoAblakFelulet.fxml").openStream());
		//parent.getStylesheets().add(getClass().getResource("/css/visszaGomb.css").toString());
		Scene scene = new Scene(parent);
		stage.setScene(scene);
//		stage.setResizable(false);
//		stage.getIcons().add(new Image("/images/kondibazis.png"));
		stage.setTitle(getAlkalmazásNeve());
		stage.show();
	}
	
	public String getAlkalmazásNeve() {
		return alkalmazásNeve;
	}
	public void setAlkalmazásNeve(String alkalmazásNeve) {
		this.alkalmazásNeve = alkalmazásNeve;
	}
	
	

}
