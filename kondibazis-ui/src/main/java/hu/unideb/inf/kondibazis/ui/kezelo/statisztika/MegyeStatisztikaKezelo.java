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
public class MegyeStatisztikaKezelo implements Initializable {

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    @Autowired
    private BejelentkezoKezelo bejelentkezoKezelo;

    private KonditeremVo bejelentkezettKonditerem;

    private ObservableList<PieChart.Data> megye_diagram_Adatok;

    @FXML
    private PieChart megye_diagram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();

        megye_diagram_Adatok = FXCollections.observableArrayList();

        Map<String, Long> megye_diagrama = konditeremSzolgaltatas.megyeDiagramKonditeremTagokhoz(bejelentkezettKonditerem);

        for (Map.Entry<String, Long> elem : megye_diagrama.entrySet()) {
            megye_diagram_Adatok.add(new PieChart.Data(elem.getKey(), elem.getValue()));
        }

        megye_diagram_Adatok.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " : ", data.pieValueProperty().intValue()
                        )
                )
        );

        megye_diagram.setData(megye_diagram_Adatok);

    }


}
