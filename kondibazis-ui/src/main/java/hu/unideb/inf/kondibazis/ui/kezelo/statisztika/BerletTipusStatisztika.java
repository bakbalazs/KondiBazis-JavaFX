// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo.statisztika;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.kezelo.KondiBazisFoAblakKezelo;
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

    private KonditeremVo bejelentkezettKonditerem;

    private ObservableList<PieChart.Data> berlettipus_diagram_Adatok;

    @Autowired
    private KondiBazisFoAblakKezelo foAblakKezelo;

    @FXML
    private PieChart berlettipus_diagram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Long bejeletkezettKonditeremId = foAblakKezelo.getBejelentkezettKonditerem().getId();

        bejelentkezettKonditerem = konditeremSzolgaltatas.keresKonditeremetId(bejeletkezettKonditeremId);

        berlettipus_diagram_Adatok = FXCollections.observableArrayList();

        Map<String, Long> berlettipus_diagrama = konditeremSzolgaltatas.berlettipusDiagramKonditeremTagokhoz(bejelentkezettKonditerem);

        if (!berlettipus_diagrama.isEmpty()) {
            // kitöröljük a tartalmát
            berlettipus_diagram_Adatok.clear();
            // hozzáadjuk újból a frissen számolt adatokat
            for (Map.Entry<String, Long> elem : berlettipus_diagrama.entrySet()) {
                berlettipus_diagram_Adatok.add(new PieChart.Data(elem.getKey(), elem.getValue()));
            }
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
