// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.main;

import java.io.IOException;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.felulet.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Inditas extends Application {
	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		FeluletBetoltese.InditasiFelulet(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void stop() throws Exception {
		SpringFxmlLoader.close();
	}
}
