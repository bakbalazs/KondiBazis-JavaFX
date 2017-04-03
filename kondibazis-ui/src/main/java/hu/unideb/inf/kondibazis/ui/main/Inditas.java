package hu.unideb.inf.kondibazis.ui.main;

import java.io.IOException;

import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.application.Application;
import javafx.stage.Stage;

public class Inditas extends Application {
	
	FeluletBetoltese feluletBetoltese = new FeluletBetoltese();

	@Override
	public void start(Stage primaryStage) throws IOException {
		feluletBetoltese.InditasiFelulet();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
