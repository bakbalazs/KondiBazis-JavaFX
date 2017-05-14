package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "konditeremTag")
public class KonditeremTag extends FoEntitas {

    private static final long serialVersionUID = 1L;

    public KonditeremTag() {
    }

    @Column(name = "tagVezetekneve")
    private String tagVezeteknev;

    @Column(name = "tagKeresztneve")
    private String tagKeresztnev;

    @Column(name = "tagNeve")
    private String tagNeve;

    @Column(name = "tagNeme")
    private String tagNeme;

    @Column(name = "tagKora")
    private int tagKora;

    @Column(name = "tagSzuletesidatum")
    private LocalDate tagSzuletesidatuma;

    @Column(name = "bereletVasarlasideje")
    private LocalDate berletVasarlasideje;

    @Column(name = "bereletLejaratiIdeje")
    private LocalDate berletLejaratiIdeje;

    @Column(name = "vasaroltBereletneve")
    private String vasaroltBerletNeve;

    @Column(name = "vasaroltBerletTipusa")
    private String vasaroltBerletTipusa;

    @Column(name = "tagVarosa")
    private String tagVarosa;

    @Column(name = "tagMegyeje")
    private String tagMegyeje;

    @ManyToOne()
    private Konditerem konditerem;

    public String getTagVezeteknev() {
        return tagVezeteknev;
    }

    public void setTagVezeteknev(String tagVezeteknev) {
        this.tagVezeteknev = tagVezeteknev;
    }

    public String getTagKeresztnev() {
        return tagKeresztnev;
    }

    public void setTagKeresztnev(String tagKeresztnev) {
        this.tagKeresztnev = tagKeresztnev;
    }

    public String getTagNeve() {
        return tagNeve;
    }

    public void setTagNeve(String tagNeve) {
        this.tagNeve = tagNeve;
    }

    public String getTagNeme() {
        return tagNeme;
    }

    public void setTagNeme(String tagNeme) {
        this.tagNeme = tagNeme;
    }

    public int getTagKora() {
        return tagKora;
    }

    public void setTagKora(int tagKora) {
        this.tagKora = tagKora;
    }

    public LocalDate getTagSzuletesidatuma() {
        return tagSzuletesidatuma;
    }

    public void setTagSzuletesidatuma(LocalDate tagSzuletesidatuma) {
        this.tagSzuletesidatuma = tagSzuletesidatuma;
    }

    public LocalDate getBerletVasarlasideje() {
        return berletVasarlasideje;
    }

    public void setBerletVasarlasideje(LocalDate berletVasarlasideje) {
        this.berletVasarlasideje = berletVasarlasideje;
    }

    public String getVasaroltBerletNeve() {
        return vasaroltBerletNeve;
    }

    public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
        this.vasaroltBerletNeve = vasaroltBerletNeve;
    }

    public String getVasaroltBerletTipusa() {
        return vasaroltBerletTipusa;
    }

    public void setVasaroltBerletTipusa(String vasaroltBerletTipusa) {
        this.vasaroltBerletTipusa = vasaroltBerletTipusa;
    }

    public Konditerem getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }

    public String getTagVarosa() {
        return tagVarosa;
    }

    public void setTagVarosa(String tagVarosa) {
        this.tagVarosa = tagVarosa;
    }

    public String getTagMegyeje() {
        return tagMegyeje;
    }

    public void setTagMegyeje(String tagMegyeje) {
        this.tagMegyeje = tagMegyeje;
    }

    public LocalDate getBerletLejaratiIdeje() {
        return berletLejaratiIdeje;
    }

    public void setBerletLejaratiIdeje(LocalDate berletLejaratiIdeje) {
        this.berletLejaratiIdeje = berletLejaratiIdeje;
    }

    @Override
    public String toString() {
        return "KonditeremTag{" +
                "tagVezeteknev='" + tagVezeteknev + '\'' +
                ", tagKeresztnev='" + tagKeresztnev + '\'' +
                ", tagNeve='" + tagNeve + '\'' +
                ", tagNeme='" + tagNeme + '\'' +
                ", tagKora=" + tagKora +
                ", tagSzuletesidatuma=" + tagSzuletesidatuma +
                ", berletVasarlasideje=" + berletVasarlasideje +
                ", berletLejaratiIdeje=" + berletLejaratiIdeje +
                ", vasaroltBerletNeve='" + vasaroltBerletNeve + '\'' +
                ", vasaroltBerletTipusa='" + vasaroltBerletTipusa + '\'' +
                ", tagVarosa='" + tagVarosa + '\'' +
                ", tagMegyeje='" + tagMegyeje + '\'' +
                ", konditerem=" + konditerem +
                '}';
    }
}
