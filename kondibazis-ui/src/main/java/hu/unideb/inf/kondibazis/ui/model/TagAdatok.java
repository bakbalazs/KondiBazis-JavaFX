// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class TagAdatok {

    private long id;
    private LocalDate tagSzuletesiIdeje;
    private StringProperty tagNeve;
    private StringProperty tagVezetekneve;
    private StringProperty tagKeresztneve;
    private StringProperty tagNeme;
    private StringProperty tagKora;
    private StringProperty berletVasarlasIdeje;
    private StringProperty berletLejaratiIdeje;
    private StringProperty vasaroltBerletNeve;
    private StringProperty mennyiAlkalom;
    private StringProperty lejartBerletNeve;

    public TagAdatok() {
        super();
    }

    public TagAdatok(long id, LocalDate tagSzuletesiIdeje, String tagNeve, String tagVezetekneve, String tagKeresztneve, String tagNeme, Integer tagKora, String vasaroltBerletNeve, LocalDate berletVasarlasideje, LocalDate berletLejaratiIdeje, Integer mennyiAlkalom, String lejartBerletNeve) {
        this.setId(id);
        this.setTagSzuletesiIdeje(tagSzuletesiIdeje);
        this.tagNeve = new SimpleStringProperty(tagNeve);
        this.tagVezetekneve = new SimpleStringProperty(tagVezetekneve);
        this.tagKeresztneve = new SimpleStringProperty(tagKeresztneve);
        this.tagNeme = new SimpleStringProperty(tagNeme);
        this.tagKora = new SimpleStringProperty(tagKora.toString());
        this.berletVasarlasIdeje = new SimpleStringProperty(berletVasarlasideje.toString());
        this.berletLejaratiIdeje = new SimpleStringProperty(berletLejaratiIdeje.toString());
        this.vasaroltBerletNeve = new SimpleStringProperty(vasaroltBerletNeve);
        this.mennyiAlkalom = new SimpleStringProperty(mennyiAlkalom.toString());
        this.lejartBerletNeve = new SimpleStringProperty(lejartBerletNeve);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getTagSzuletesiIdeje() {
        return tagSzuletesiIdeje;
    }

    public void setTagSzuletesiIdeje(LocalDate tagSzuletesiIdeje) {
        this.tagSzuletesiIdeje = tagSzuletesiIdeje;
    }

    public String getTagNeve() {
        return tagNeve.get();
    }

    public StringProperty tagNeveProperty() {
        return tagNeve;
    }

    public void setTagNeve(String tagNeve) {
        this.tagNeve.set(tagNeve);
    }

    public String getTagVezetekneve() {
        return tagVezetekneve.get();
    }

    public StringProperty tagVezetekneveProperty() {
        return tagVezetekneve;
    }

    public void setTagVezetekneve(String tagVezetekneve) {
        this.tagVezetekneve.set(tagVezetekneve);
    }

    public String getTagKeresztneve() {
        return tagKeresztneve.get();
    }

    public StringProperty tagKeresztneveProperty() {
        return tagKeresztneve;
    }

    public void setTagKeresztneve(String tagKeresztneve) {
        this.tagKeresztneve.set(tagKeresztneve);
    }

    public String getTagNeme() {
        return tagNeme.get();
    }

    public StringProperty tagNemeProperty() {
        return tagNeme;
    }

    public void setTagNeme(String tagNeme) {
        this.tagNeme.set(tagNeme);
    }

    public String getTagKora() {
        return tagKora.get();
    }

    public StringProperty tagKoraProperty() {
        return tagKora;
    }

    public void setTagKora(String tagKora) {
        this.tagKora.set(tagKora);
    }

    public String getBerletVasarlasIdeje() {
        return berletVasarlasIdeje.get();
    }

    public StringProperty berletVasarlasIdejeProperty() {
        return berletVasarlasIdeje;
    }

    public void setBerletVasarlasIdeje(String berletVasarlasIdeje) {
        this.berletVasarlasIdeje.set(berletVasarlasIdeje);
    }

    public String getBerletLejaratiIdeje() {
        return berletLejaratiIdeje.get();
    }

    public StringProperty berletLejaratiIdejeProperty() {
        return berletLejaratiIdeje;
    }

    public void setBerletLejaratiIdeje(String berletLejaratiIdeje) {
        this.berletLejaratiIdeje.set(berletLejaratiIdeje);
    }

    public String getVasaroltBerletNeve() {
        return vasaroltBerletNeve.get();
    }

    public StringProperty vasaroltBerletNeveProperty() {
        return vasaroltBerletNeve;
    }

    public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
        this.vasaroltBerletNeve.set(vasaroltBerletNeve);
    }

    public String getMennyiAlkalom() {
        return mennyiAlkalom.get();
    }

    public StringProperty mennyiAlkalomProperty() {
        return mennyiAlkalom;
    }

    public void setMennyiAlkalom(String mennyiAlkalom) {
        this.mennyiAlkalom.set(mennyiAlkalom);
    }

    public String getLejartBerletNeve() {
        return lejartBerletNeve.get();
    }

    public StringProperty lejartBerletNeveProperty() {
        return lejartBerletNeve;
    }

    public void setLejartBerletNeve(String lejartBerletNeve) {
        this.lejartBerletNeve.set(lejartBerletNeve);
    }
}
