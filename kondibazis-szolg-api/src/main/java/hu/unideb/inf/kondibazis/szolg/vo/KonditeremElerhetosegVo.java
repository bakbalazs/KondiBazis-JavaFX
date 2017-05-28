package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

/**
 * Egyszerű osztály a konditermek elérhetőségeihez tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class KonditeremElerhetosegVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremElerhetosegVo() {
    }

    /**
     * A konditerem elérhetőség id-ja.
     */
    private Long id;

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
     * A konditerem címe.
     */
    private String konditeremCime;

    /**
     * A konditerem címének az utca neve.
     */
    private String utcaNeve;

    /**
     * A konditerem címének a haz szama.
     */
    private String hazSzam;

    /**
     * A konditerem címének az emelet szama.
     */
    private String emeletSzam;

    /**
     * A konditerem címének az ajto szama.
     */
    private String ajtoSzam;

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

    /**
     * Az adott konditerem akihez tartozik az elérhetőség.
     */
    private KonditeremVo konditerem;

    /**
     * Visszaadja a konditerem elérhetőség id-ját.
     *
     * @return A konditerem elérhetőségének id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja a konditerem elérhetőségének id-ját.
     *
     * @param id A beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Visszaadja a konditerem városának az irányítószámát.
     *
     * @return A konditerem városának irányítószámát.
     */
    public Integer getKonditeremVarosanakIranyitoSzama() {
        return KonditeremVarosanakIranyitoSzama;
    }

    /**
     * Beállítja a konditerem városának az irányítószámát.
     *
     * @param konditeremVarosanakIranyitoSzama A beállítandó irányítószám.
     */
    public void setKonditeremVarosanakIranyitoSzama(Integer konditeremVarosanakIranyitoSzama) {
        KonditeremVarosanakIranyitoSzama = konditeremVarosanakIranyitoSzama;
    }

    /**
     * Visszaadja a konditerem városánaka a nevét.
     *
     * @return A konditerem városának nevét.
     */
    public String getKonditeremVarosanakNeve() {
        return konditeremVarosanakNeve;
    }

    /**
     * Beállítja a konditerem városának nevét.
     *
     * @param konditeremVarosanakNeve A beállítandó város név.
     */
    public void setKonditeremVarosanakNeve(String konditeremVarosanakNeve) {
        this.konditeremVarosanakNeve = konditeremVarosanakNeve;
    }

    /**
     * Visszaadja a konditerem városának megyéjének a nevét.
     *
     * @return A konditerem városának megyeéje.
     */
    public String getKonditeremVarosanakMegyeje() {
        return konditeremVarosanakMegyeje;
    }

    /**
     * Beállítja a konditerem városának a megyéjét.
     *
     * @param konditeremVarosanakMegyeje A beállítandó megye név.
     */
    public void setKonditeremVarosanakMegyeje(String konditeremVarosanakMegyeje) {
        this.konditeremVarosanakMegyeje = konditeremVarosanakMegyeje;
    }

    /**
     * Visszaadja a konditerem címét.
     *
     * @return A konditerem címe.
     */
    public String getKonditeremCime() {
        return konditeremCime;
    }

    /**
     * Bellítja a konditerem címét.
     *
     * @param konditeremCime A beállítandó cím.
     */
    public void setKonditeremCime(String konditeremCime) {
        this.konditeremCime = konditeremCime;
    }

    public String getUtcaNeve() {
        return utcaNeve;
    }

    public void setUtcaNeve(String utcaNeve) {
        this.utcaNeve = utcaNeve;
    }

    public String getHazSzam() {
        return hazSzam;
    }

    public void setHazSzam(String hazSzam) {
        this.hazSzam = hazSzam;
    }

    public String getEmeletSzam() {
        return emeletSzam;
    }

    public void setEmeletSzam(String emeletSzam) {
        this.emeletSzam = emeletSzam;
    }

    public String getAjtoSzam() {
        return ajtoSzam;
    }

    public void setAjtoSzam(String ajtoSzam) {
        this.ajtoSzam = ajtoSzam;
    }

    /**
     * Visszaadja a konditerem telefonszámát.
     *
     * @return A konditerem telefonszáma.
     */
    public String getKonditremTelefonszam() {
        return konditremTelefonszam;
    }

    /**
     * Beállítja a konditerem telefonszámát.
     *
     * @param konditremTelefonszam A beállítandó telefonszám.
     */
    public void setKonditremTelefonszam(String konditremTelefonszam) {
        this.konditremTelefonszam = konditremTelefonszam;
    }

    /**
     * Visszaadja a konditerem e-mail címét.
     *
     * @return A konditerem e-mail címe.
     */
    public String getKonditremEmailCim() {
        return konditremEmailCim;
    }

    /**
     * Beállítja a konditerem e-mail címét.
     *
     * @param konditremEmailCim A beállítandó e-mail cím.
     */
    public void setKonditremEmailCim(String konditremEmailCim) {
        this.konditremEmailCim = konditremEmailCim;
    }

    /**
     * Visszaadja a konditerem weboldalának linkjét.
     *
     * @return A konditerem weboldalának a linkje.
     */
    public String getKonditeremWeboldalLink() {
        return konditeremWeboldalLink;
    }

    /**
     * Beállítja a konditerem weboldalának a linkjét.
     *
     * @param konditeremWeboldalLink A beállítandó weboldal link.
     */
    public void setKonditeremWeboldalLink(String konditeremWeboldalLink) {
        this.konditeremWeboldalLink = konditeremWeboldalLink;
    }

    /**
     * Visszaadja a konditerem facebook oldalának a linkjét.
     *
     * @return A konditerem facebook oldalának a linkje.
     */
    public String getKonditeremFacebookOldalLink() {
        return konditeremFacebookOldalLink;
    }

    /**
     * Beállítja a konditerem facebook oldalát.
     *
     * @param konditeremFacebookOldalLink A beállítandó facebook oldal link.
     */
    public void setKonditeremFacebookOldalLink(String konditeremFacebookOldalLink) {
        this.konditeremFacebookOldalLink = konditeremFacebookOldalLink;
    }

    /**
     * Visszaadja a konditermet.
     *
     * @return Az elérhetőséghez tartozó konditerem.
     */
    public KonditeremVo getKonditerem() {
        return konditerem;
    }

    /**
     * Beállítja az elérhetőség konditermét.
     *
     * @param konditerem A beállítandó konditerem.
     */
    public void setKonditerem(KonditeremVo konditerem) {
        this.konditerem = konditerem;
    }
}