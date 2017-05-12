// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.main;

import java.io.IOException;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inditas extends Application {
	
	private static Logger logolo = LoggerFactory.getLogger(Inditas.class);
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		FeluletBetoltese.InditasiFelulet(primaryStage);
	}

	public static void main(String[] args) {
		logolo.info("Az alkalmazás elindul.");
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		logolo.info("Az alkalmazás leáll.");
		SpringFxmlLoader.close();
	}
}
