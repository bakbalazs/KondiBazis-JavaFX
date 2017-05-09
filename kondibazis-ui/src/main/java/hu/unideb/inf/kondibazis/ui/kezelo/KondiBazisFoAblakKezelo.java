// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import hu.unideb.inf.kondibazis.ui.model.TagData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

@Component
public class KondiBazisFoAblakKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private BejelentkezoKezelo bejelentkezoKezelo;

	@Autowired
	private KonditeremTagSzolgaltatas konditeremtagSzolgaltatas;

	private KonditeremVo bejelentkezettKonditerem;

	@FXML
	private Text konditeremNeve;

	@FXML
	private Text tagokSzama;

	@FXML
	private Text regisztralasDatuma;

	private ObservableList<TagData> tagTablazatAdatok;

	@FXML
	private TableView<TagData> tagokTabla;

	@FXML
	private TableColumn<TagData, String> nevOszlop;

	@FXML
	private TableColumn<TagData, String> vezeteknevOszlop;

	@FXML
	private TableColumn<TagData, String> keresztnevOszlop;

	@FXML
	private TableColumn<TagData, String> nemOszlop;

	@FXML
	private TableColumn<TagData, String> korOszlop;

	@FXML
	private TableColumn<TagData, String> berletNeveOszlop;

	@FXML
	private TableColumn<TagData, String> berletVasarlasOszlop;

	@FXML
	private TableColumn<TagData, String> berletLejrataOszlop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
		tagTablazatAdatok = FXCollections.observableArrayList();
		adatFrissites();

		konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
		regisztralasDatuma.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getRegisztralasDatuma().toString());

		nevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagNeveProperty());

		vezeteknevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagVezetekneveProperty());
		
		keresztnevOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagKeresztneveProperty());
		
		nemOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagNemeProperty());
		
		korOszlop.setCellValueFactory(celldata -> celldata.getValue().getTagKoraProperty());
		
		berletVasarlasOszlop.setCellValueFactory(celldata -> celldata.getValue().getBerletVasarlasIdejeProperty());
		
		berletNeveOszlop.setCellValueFactory(celldata -> celldata.getValue().getVasaroltBerletNeveProperty());
		
		tagokTabla.setItems(tagTablazatAdatok);

	}

	@FXML
	public void elerhetoseg(ActionEvent event) {
		FeluletBetoltese.KonditeremElerhetosegSzekeszteseFelulet(event);
	}

	@FXML
	public void berletekLetrehozasa(ActionEvent event) {
		FeluletBetoltese.BerletLetrehozasaFelulet(event);
	}

	@FXML
	public void berletekModositasa(ActionEvent event) {
		FeluletBetoltese.BerletekModositasaFelulet(event);
	}

	@FXML
	public void tagHozzaadasa(ActionEvent event) {
		FeluletBetoltese.TagHozzaadasaFelulet(event);
	}

	@FXML
	public void kijelentkezes(ActionEvent event) {
	}

	@FXML
	public void bezaras(ActionEvent event) {
	}

	public void adatFrissites() {
		bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

		List<KonditeremTagVo> konditerem_tagjai = konditeremtagSzolgaltatas
				.konditeremOsszesTagja(bejelentkezettKonditerem);

		if (!tagTablazatAdatok.isEmpty()) {
			tagTablazatAdatok.clear();
		}

		for (KonditeremTagVo konditeremTagVo : konditerem_tagjai) {

			tagTablazatAdatok.add(new TagData(
					
					konditeremTagVo.getTagNeve(),
					konditeremTagVo.getTagVezeteknev(),
					konditeremTagVo.getTagKeresztnev(),
					konditeremTagVo.getTagNeme(),
					konditeremTagVo.getTagKora(),
					konditeremTagVo.getVasaroltBerletNeve(),
					konditeremTagVo.getBerletVasarlasideje()
					
					
					)
					
					
					);

		}
	}

	public KonditeremVo getBejelentkezettKonditerem() {
		return bejelentkezettKonditerem;
	}

	public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
		this.bejelentkezettKonditerem = bejelentkezettKonditerem;
	}

}
