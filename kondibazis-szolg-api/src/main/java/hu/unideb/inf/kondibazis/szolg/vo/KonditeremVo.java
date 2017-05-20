package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class KonditeremVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public KonditeremVo() {
    }

    private Long id;

    private String felhasznalonev;

    private String jelszo;

    private String konditeremNeve;

    private LocalDate regisztralasDatuma;

    private Integer tagokSzama;

    private List<KonditeremTagVo> konditeremTagok;

    private List<KonditeremBerletVo> konditeremBerletek;

    private KonditeremElerhetosegVo konditeremElerhetoseg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getKonditeremNeve() {
        return konditeremNeve;
    }

    public void setKonditeremNeve(String konditeremNeve) {
        this.konditeremNeve = konditeremNeve;
    }

    public LocalDate getRegisztralasDatuma() {
        return regisztralasDatuma;
    }

    public void setRegisztralasDatuma(LocalDate regisztralasDatuma) {
        this.regisztralasDatuma = regisztralasDatuma;
    }

    public Integer getTagokSzama() {
        return tagokSzama;
    }

    public void setTagokSzama(Integer tagokSzama) {
        this.tagokSzama = tagokSzama;
    }

    public List<KonditeremTagVo> getKonditeremTagok() {
        return konditeremTagok;
    }

    public void setKonditeremTagok(List<KonditeremTagVo> konditeremTagok) {
        this.konditeremTagok = konditeremTagok;
    }

    public List<KonditeremBerletVo> getKonditeremBerletek() {
        return konditeremBerletek;
    }

    public void setKonditeremBerletek(List<KonditeremBerletVo> konditeremBerletek) {
        this.konditeremBerletek = konditeremBerletek;
    }

    public KonditeremElerhetosegVo getKonditeremElerhetoseg() {
        return konditeremElerhetoseg;
    }

    public void setKonditeremElerhetoseg(KonditeremElerhetosegVo konditeremElerhetoseg) {
        this.konditeremElerhetoseg = konditeremElerhetoseg;
    }
}
