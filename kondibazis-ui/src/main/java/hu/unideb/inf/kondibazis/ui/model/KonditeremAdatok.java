package hu.unideb.inf.kondibazis.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KonditeremAdatok {

    private Long id;
    private StringProperty konditeremNeve;
    private StringProperty konditeremTelefonszama;
    private StringProperty konditeremHelye;
    private StringProperty konditeremCime;
    private StringProperty konditeremTagokSzama;

    public KonditeremAdatok() {
        super();
    }

    public KonditeremAdatok(Long id, String konditeremNeve, String konditeremTelefonszama, String konditeremHelye, String konditeremCime, String konditeremTagokSzama) {
        this.id = id;
        this.konditeremNeve = new SimpleStringProperty(konditeremNeve);
        this.konditeremTelefonszama = new SimpleStringProperty(konditeremTelefonszama);
        this.konditeremHelye = new SimpleStringProperty(konditeremHelye);
        this.konditeremCime = new SimpleStringProperty(konditeremCime);
        this.konditeremTagokSzama = new SimpleStringProperty(konditeremTagokSzama);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKonditeremNeve() {
        return konditeremNeve.get();
    }

    public StringProperty konditeremNeveProperty() {
        return konditeremNeve;
    }

    public void setKonditeremNeve(String konditeremNeve) {
        this.konditeremNeve.set(konditeremNeve);
    }

    public String getKonditeremTelefonszama() {
        return konditeremTelefonszama.get();
    }

    public StringProperty konditeremTelefonszamaProperty() {
        return konditeremTelefonszama;
    }

    public void setKonditeremTelefonszama(String konditeremTelefonszama) {
        this.konditeremTelefonszama.set(konditeremTelefonszama);
    }

    public String getKonditeremHelye() {
        return konditeremHelye.get();
    }

    public StringProperty konditeremHelyeProperty() {
        return konditeremHelye;
    }

    public void setKonditeremHelye(String konditeremHelye) {
        this.konditeremHelye.set(konditeremHelye);
    }

    public String getKonditeremCime() {
        return konditeremCime.get();
    }

    public StringProperty konditeremCimeProperty() {
        return konditeremCime;
    }

    public void setKonditeremCime(String konditeremCime) {
        this.konditeremCime.set(konditeremCime);
    }

    public String getKonditeremTagokSzama() {
        return konditeremTagokSzama.get();
    }

    public StringProperty konditeremTagokSzamaProperty() {
        return konditeremTagokSzama;
    }

    public void setKonditeremTagokSzama(String konditeremTagokSzama) {
        this.konditeremTagokSzama.set(konditeremTagokSzama);
    }
}
