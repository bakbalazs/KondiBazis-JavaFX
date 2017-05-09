// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.kondibazis.szolg.kontener.SzovegTartalom;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Inditas extends Application {
	
	private static Logger logolo = LoggerFactory.getLogger(Inditas.class);
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		FeluletBetoltese.InditasiFelulet(primaryStage);
	}

	public static void main(String[] args) {
		logolo.info(SzovegTartalom.ALKALMAZAS_INDITAS_LOG);
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		logolo.info(SzovegTartalom.ALKALMAZAS_LEALLITAS_LOG);
		SpringFxmlLoader.close();
	}
}
