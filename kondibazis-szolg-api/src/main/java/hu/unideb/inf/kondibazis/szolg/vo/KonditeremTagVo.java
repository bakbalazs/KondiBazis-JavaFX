package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class KonditeremTagVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public KonditeremTagVo() {
    }

    private Long id;

    private String tagVezeteknev;

    private String tagKeresztnev;

    private String tagNeve;

    private String tagNeme;

    private int tagKora;

    private LocalDate tagSzuletesidatuma;

    private LocalDate berletVasarlasideje;

    private LocalDate berletLejaratiIdeje;

    private String vasaroltBerletNeve;

    private String vasaroltBerletTipusa;

    private String tagVarosa;

    private String tagMegyeje;

    private KonditeremVo konditerem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public KonditeremVo getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(KonditeremVo konditerem) {
        this.konditerem = konditerem;
    }

    public String getVasaroltBerletTipusa() {
        return vasaroltBerletTipusa;
    }

    public void setVasaroltBerletTipusa(String vasaroltBerletTipusa) {
        this.vasaroltBerletTipusa = vasaroltBerletTipusa;
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
        return "KonditeremTagVo [id=" + id + ", tagVezeteknev=" + tagVezeteknev + ", tagKeresztnev=" + tagKeresztnev
                + ", tagNeve=" + tagNeve + ", tagNeme=" + tagNeme + ", tagKora=" + tagKora + ", tagSzuletesidatuma="
                + tagSzuletesidatuma + ", berletVasarlasideje=" + berletVasarlasideje + ", vasaroltBerletNeve="
                + vasaroltBerletNeve + ", tagVarosa=" + tagVarosa
                + ", tagMegyeje=" + tagMegyeje + "]";
    }

}
