package hu.unideb.inf.kondibazis.ui.kezelo.statisztika;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.kezelo.BejelentkezoKezelo;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class VarosStatisztikaKezelo implements Initializable {

@Autowired
private KonditeremSzolgaltatas konditeremSzolgaltatas;

@Autowired
private BejelentkezoKezelo bejelentkezoKezelo;

private KonditeremVo bejelentkezettKonditerem;

private ObservableList<PieChart.Data> varos_diagram_Adatok;

@FXML
private PieChart varos_diagram;

@Override
public void initialize(URL location, ResourceBundle resources) {
        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        varos_diagram_Adatok = FXCollections.observableArrayList();

        Map<String, Long> varos_diagrama = konditeremSzolgaltatas.varosDiagramKonditeremTagokhoz(bejelentkezettKonditerem);

        for (Map.Entry<String, Long> elem : varos_diagrama.entrySet()) {
        varos_diagram_Adatok.add(new PieChart.Data(elem.getKey(), elem.getValue()));
        }

        varos_diagram_Adatok.forEach(data ->
        data.nameProperty().bind(
        Bindings.concat(
        data.getName(), " : ", data.pieValueProperty().intValue()
        )
        )
        );

        varos_diagram.setData(varos_diagram_Adatok);

        }


        }
