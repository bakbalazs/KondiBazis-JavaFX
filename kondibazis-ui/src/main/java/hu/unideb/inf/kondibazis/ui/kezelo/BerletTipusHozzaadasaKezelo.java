package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class BerletTipusHozzaadasaKezelo implements Initializable {
	
	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;
	
	@Autowired
	private KonditeremBerletSzolgaltatas konditeremBerletSzolgaltatas;
	
	@Autowired
	private FoAblakKezelo foAblakKezelo;
	
	private KonditeremVo bejelentkezettKonditerem;
	
	@FXML
	private Button letrehozasGomb;

	@FXML
	private Button kihagyasGomb;

	@FXML
	private TextField berletnevBevitel;

	@FXML
	private TextField berletaraBevitel;

	@FXML
	private TextField oraBevitel;

	@FXML
	private TextField napBevitel;

	@FXML
	private TextField honapBevitel;

	@FXML
	private Text letrehozasUzenet;

	@FXML 
	private Text regisztraltKonditerem;

	@FXML 
	private Text berletletrehozasUzenet;
	
	private int ora;
	
	private int nap;
	
	private int honap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = foAblakKezelo.getBejelentkezettKonditerem();
	}

	@FXML
	public void letrehozas(ActionEvent event) {
		
		ora = Integer.parseInt(oraBevitel.getText());
		nap = Integer.parseInt(napBevitel.getText());
		honap = Integer.parseInt(honapBevitel.getText());
		
		boolean mehet = true;
		
		if(berletnevBevitel.getText().equals("")) {
			mehet = false;
		}
		
		if(berletaraBevitel.getText().equals("")) {
			mehet = false;
		}
		
		if(ora == 0 || nap == 0 || honap == 0) {
			mehet = false;
		}
		
		if(ora > 0 || nap > 0 || honap > 0) {
			mehet = true;
		}
		
		if(mehet) {
			KonditeremBerletVo ujBerlet = new KonditeremBerletVo();
			ujBerlet.setBerletNeve(berletnevBevitel.getText());
			String test = berletaraBevitel.getText();
			int szam1 = Integer.parseInt(test);
			ujBerlet.setBerletAra(szam1);
			ujBerlet.setMennyiOra(ora);
			ujBerlet.setMennyiNap(nap);
			ujBerlet.setMennyiHonap(honap);
			
			KonditeremBerletVo letezo = konditeremBerletSzolgaltatas.letrehozBerletet(ujBerlet);
			
			bejelentkezettKonditerem.getKonditeremBerletek().add(letezo);
			
			konditeremSzolgaltatas.frissitKonditermet(bejelentkezettKonditerem);
			
			letezo.setKonditerem(bejelentkezettKonditerem);
			
			konditeremBerletSzolgaltatas.frissitKonditeremBerletet(letezo);
		}
		
		

	}

	@FXML
	public void kihagyas(ActionEvent event) throws IOException {
//		feluletBetoltese.BelepesiFelulet();
//		((Node) (event.getSource())).getScene().getWindow().hide();
	}

}
