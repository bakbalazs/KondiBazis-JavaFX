// CHECKSTYLE:OFF
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
public class NemekStatisztikaKezelo implements Initializable {
    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private BejelentkezoKezelo bejelentkezoKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    private ObservableList<PieChart.Data> nemek_diagram_Adatok;

    @FXML
    private PieChart nemek_diagram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        nemek_diagram_Adatok = FXCollections.observableArrayList();

        Map<String, Long> nemek_diagrama = konditeremSzolgaltatas.nemekDiagramKonditeremTagokhoz(bejelentkezettKonditerem);

        for (Map.Entry<String, Long> elem : nemek_diagrama.entrySet()) {
            nemek_diagram_Adatok.add(new PieChart.Data(elem.getKey(), elem.getValue()));
        }

        nemek_diagram_Adatok.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " : ", data.pieValueProperty().intValue()
                        )
                )
        );

        nemek_diagram.setData(nemek_diagram_Adatok);

    }
}
