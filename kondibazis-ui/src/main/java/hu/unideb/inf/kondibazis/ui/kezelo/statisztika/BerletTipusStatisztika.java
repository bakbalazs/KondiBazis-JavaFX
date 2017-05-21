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
public class BerletTipusStatisztika implements Initializable {

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private BejelentkezoKezelo bejelentkezoKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    private ObservableList<PieChart.Data> berlettipus_diagram_Adatok;

    @FXML
    private PieChart berlettipus_diagram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        berlettipus_diagram_Adatok = FXCollections.observableArrayList();

        Map<String, Long> berlettipus_diagrama = konditeremSzolgaltatas.berlettipusDiagramKonditeremTagokhoz(bejelentkezettKonditerem);

        for (Map.Entry<String, Long> elem : berlettipus_diagrama.entrySet()) {
            berlettipus_diagram_Adatok.add(new PieChart.Data(elem.getKey(), elem.getValue()));
        }

        berlettipus_diagram_Adatok.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " : ", data.pieValueProperty().intValue()
                        )
                )
        );

        berlettipus_diagram.setData(berlettipus_diagram_Adatok);

    }


}
