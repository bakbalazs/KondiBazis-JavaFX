package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

@Component
public class RegisztralasKezelo implements Initializable {

	@Autowired
	KonditeremSzolgaltatas konditeremSzolgaltatas;
	
	@FXML 
	private TextField konditeremnevBevitel;

	@FXML 
	private TextField felhasznalonevBevitel;

	@FXML 
	private PasswordField jelszoBevitel;

	@FXML 
	private Button visszaGomb;
	
	@FXML 
	private Text regisztraciosUzenet;

	@FXML
	public void regisztralas(ActionEvent event) throws IOException {
		
		boolean ok = true;
		regisztraciosUzenet.setText("");

	/*	// sikeres reg esetén
		feluletBetoltese.BerletHozzaadasaFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
*/
	}

	@FXML
	public void vissza(ActionEvent event) throws IOException {
	//	feluletBetoltese.InditasiFelulet();
		((Node) (event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
