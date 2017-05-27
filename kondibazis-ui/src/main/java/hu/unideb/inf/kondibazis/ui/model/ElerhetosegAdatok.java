package hu.unideb.inf.kondibazis.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ElerhetosegAdatok {

    private long id;
    private StringProperty telepulesNev;
    private StringProperty megyyeNev;
    private StringProperty konditeremCime;
    private StringProperty konditeremTelefonszama;
    private StringProperty emailCim;
    private StringProperty facebookOldalLink;
    private StringProperty weboldalLink;

    public ElerhetosegAdatok() {
        super();
    }

    public ElerhetosegAdatok(long id, String telepulesNev, String megyyeNev, String konditeremCime, String konditeremTelefonszama, String emailCim, String facebookOldalLink, String weboldalLink) {
        this.id = id;
        this.telepulesNev = new SimpleStringProperty(telepulesNev);
        this.megyyeNev = new SimpleStringProperty(megyyeNev);
        this.konditeremCime = new SimpleStringProperty(konditeremCime);
        this.konditeremTelefonszama = new SimpleStringProperty(konditeremTelefonszama);
        this.emailCim = new SimpleStringProperty(emailCim);
        this.facebookOldalLink = new SimpleStringProperty(facebookOldalLink);
        this.weboldalLink = new SimpleStringProperty(weboldalLink);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelepulesNev() {
        return telepulesNev.get();
    }

    public StringProperty telepulesNevProperty() {
        return telepulesNev;
    }

    public void setTelepulesNev(String telepulesNev) {
        this.telepulesNev.set(telepulesNev);
    }

    public String getMegyyeNev() {
        return megyyeNev.get();
    }

    public StringProperty megyyeNevProperty() {
        return megyyeNev;
    }

    public void setMegyyeNev(String megyyeNev) {
        this.megyyeNev.set(megyyeNev);
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

    public String getKonditeremTelefonszama() {
        return konditeremTelefonszama.get();
    }

    public StringProperty konditeremTelefonszamaProperty() {
        return konditeremTelefonszama;
    }

    public void setKonditeremTelefonszama(String konditeremTelefonszama) {
        this.konditeremTelefonszama.set(konditeremTelefonszama);
    }

    public String getEmailCim() {
        return emailCim.get();
    }

    public StringProperty emailCimProperty() {
        return emailCim;
    }

    public void setEmailCim(String emailCim) {
        this.emailCim.set(emailCim);
    }

    public String getFacebookOldalLink() {
        return facebookOldalLink.get();
    }

    public StringProperty facebookOldalLinkProperty() {
        return facebookOldalLink;
    }

    public void setFacebookOldalLink(String facebookOldalLink) {
        this.facebookOldalLink.set(facebookOldalLink);
    }

    public String getWeboldalLink() {
        return weboldalLink.get();
    }

    public StringProperty weboldalLinkProperty() {
        return weboldalLink;
    }

    public void setWeboldalLink(String weboldalLink) {
        this.weboldalLink.set(weboldalLink);
    }
}
