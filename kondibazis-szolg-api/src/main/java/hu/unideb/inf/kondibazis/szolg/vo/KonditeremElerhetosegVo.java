package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

public class KonditeremElerhetosegVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public KonditeremElerhetosegVo() {
    }

    /**
     * Irányítszám ahol a konditerem található.
     */
    private Integer KonditeremVarosanakIranyitoSzama;

    /**
     * Város neve ahol a konditerem található.
     */
    private String konditeremVarosanakNeve;

    /**
     * Megye neve ahol a konditerem található.
     */
    private String konditeremVarosanakMegyeje;

    /**
     *
     */
    private String konditeremCime;

    /**
     * A konditerem telefonszáma.
     */
    private String konditremTelefonszam;

    /**
     * A konditerem e-mailcíme.
     */
    private String konditremEmailCim;

    /**
     * A konditerem weboldala.
     */
    private String konditeremWeboldalLink;

    /**
     * A konditerem facebook oldala.
     */
    private String konditeremFacebookOldalLink;

//    /**
//     *
//     */
    private KonditeremVo konditerem;

    public Integer getKonditeremVarosanakIranyitoSzama() {
        return KonditeremVarosanakIranyitoSzama;
    }

    public void setKonditeremVarosanakIranyitoSzama(Integer konditeremVarosanakIranyitoSzama) {
        KonditeremVarosanakIranyitoSzama = konditeremVarosanakIranyitoSzama;
    }

    public String getKonditeremVarosanakNeve() {
        return konditeremVarosanakNeve;
    }

    public void setKonditeremVarosanakNeve(String konditeremVarosanakNeve) {
        this.konditeremVarosanakNeve = konditeremVarosanakNeve;
    }

    public String getKonditeremVarosanakMegyeje() {
        return konditeremVarosanakMegyeje;
    }

    public void setKonditeremVarosanakMegyeje(String konditeremVarosanakMegyeje) {
        this.konditeremVarosanakMegyeje = konditeremVarosanakMegyeje;
    }

    public String getKonditeremCime() {
        return konditeremCime;
    }

    public void setKonditeremCime(String konditeremCime) {
        this.konditeremCime = konditeremCime;
    }

    public String getKonditremTelefonszam() {
        return konditremTelefonszam;
    }

    public void setKonditremTelefonszam(String konditremTelefonszam) {
        this.konditremTelefonszam = konditremTelefonszam;
    }

    public String getKonditremEmailCim() {
        return konditremEmailCim;
    }

    public void setKonditremEmailCim(String konditremEmailCim) {
        this.konditremEmailCim = konditremEmailCim;
    }

    public String getKonditeremWeboldalLink() {
        return konditeremWeboldalLink;
    }

    public void setKonditeremWeboldalLink(String konditeremWeboldalLink) {
        this.konditeremWeboldalLink = konditeremWeboldalLink;
    }

    public String getKonditeremFacebookOldalLink() {
        return konditeremFacebookOldalLink;
    }

    public void setKonditeremFacebookOldalLink(String konditeremFacebookOldalLink) {
        this.konditeremFacebookOldalLink = konditeremFacebookOldalLink;
    }

    public KonditeremVo getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(KonditeremVo konditerem) {
        this.konditerem = konditerem;
    }
}
