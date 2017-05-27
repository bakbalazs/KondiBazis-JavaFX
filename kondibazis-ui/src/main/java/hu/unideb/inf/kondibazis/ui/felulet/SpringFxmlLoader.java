// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.felulet;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;


public class SpringFxmlLoader {

	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-ui.xml");

	Object load(String url) {
		try (InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url)) {

			FXMLLoader loader = new FXMLLoader();
			loader.setControllerFactory(applicationContext::getBean);
			return loader.load(fxmlStream);

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void close() {
		((ConfigurableApplicationContext) applicationContext).close();
	}
}
