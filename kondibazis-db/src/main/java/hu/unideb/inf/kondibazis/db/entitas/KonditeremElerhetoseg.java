package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;

/**
 * Az adatbázisban egy konditerem elérhetőségét reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditeremelerhetoseg nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditeremElerhetoseg")
public class KonditeremElerhetoseg extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremElerhetoseg() {
    }

    /**
     * Irányítszám ahol a konditerem található.
     */
    @Column(name = "iranyitoSzam")
    private Integer KonditeremVarosanakIranyitoSzama;

    /**
     * Város neve ahol a konditerem található.
     */
    @Column(name = "varosNeve")
    private String konditeremVarosanakNeve;

    /**
     * Megye neve ahol a konditerem található.
     */
    @Column(name = "megyeNeve")
    private String konditeremVarosanakMegyeje;

    /**
     * A konditerem címe.
     */
    @Column(name = "cim")
    private String konditeremCime;

    /**
     * A konditerem telefonszáma.
     */
    @Column(name = "telefonszam")
    private String konditremTelefonszam;

    /**
     * A konditerem e-mailcíme.
     */
    @Column(name = "emailCim")
    private String konditremEmailCim;

    /**
     * A konditerem weboldala.
     */
    @Column(name = "weboldalLink")
    private String konditeremWeboldalLink;

    /**
     * A konditerem facebook oldala.
     */
    @Column(name = "facebookOldalLink")
    private String konditeremFacebookOldalLink;

    /**
     * Az adott konditerem akihez tartozik az elérhetőség.
     */
    @ManyToOne
    private Konditerem konditerem;

    /**
     *
     * @return
     */
    public Integer getKonditeremVarosanakIranyitoSzama() {
        return KonditeremVarosanakIranyitoSzama;
    }

    /**
     *
     * @param konditeremVarosanakIranyitoSzama
     */
    public void setKonditeremVarosanakIranyitoSzama(Integer konditeremVarosanakIranyitoSzama) {
        KonditeremVarosanakIranyitoSzama = konditeremVarosanakIranyitoSzama;
    }

    /**
     *
     * @return
     */
    public String getKonditeremVarosanakNeve() {
        return konditeremVarosanakNeve;
    }

    /**
     *
     * @param konditeremVarosanakNeve
     */
    public void setKonditeremVarosanakNeve(String konditeremVarosanakNeve) {
        this.konditeremVarosanakNeve = konditeremVarosanakNeve;
    }

    /**
     *
     * @return
     */
    public String getKonditeremVarosanakMegyeje() {
        return konditeremVarosanakMegyeje;
    }

    /**
     *
     * @param konditeremVarosanakMegyeje
     */
    public void setKonditeremVarosanakMegyeje(String konditeremVarosanakMegyeje) {
        this.konditeremVarosanakMegyeje = konditeremVarosanakMegyeje;
    }

    /**
     *
     * @return
     */
    public String getKonditeremCime() {
        return konditeremCime;
    }

    /**
     *
     * @param konditeremCime
     */
    public void setKonditeremCime(String konditeremCime) {
        this.konditeremCime = konditeremCime;
    }

    /**
     *
     * @return
     */
    public String getKonditremTelefonszam() {
        return konditremTelefonszam;
    }

    /**
     *
     * @param konditremTelefonszam
     */
    public void setKonditremTelefonszam(String konditremTelefonszam) {
        this.konditremTelefonszam = konditremTelefonszam;
    }

    /**
     *
     * @return
     */
    public String getKonditremEmailCim() {
        return konditremEmailCim;
    }

    /**
     *
     * @param konditremEmailCim
     */
    public void setKonditremEmailCim(String konditremEmailCim) {
        this.konditremEmailCim = konditremEmailCim;
    }

    /**
     *
     * @return
     */
    public String getKonditeremWeboldalLink() {
        return konditeremWeboldalLink;
    }

    /**
     *
     * @param konditeremWeboldalLink
     */
    public void setKonditeremWeboldalLink(String konditeremWeboldalLink) {
        this.konditeremWeboldalLink = konditeremWeboldalLink;
    }

    /**
     *
     * @return
     */
    public String getKonditeremFacebookOldalLink() {
        return konditeremFacebookOldalLink;
    }

    /**
     *
     * @param konditeremFacebookOldalLink
     */
    public void setKonditeremFacebookOldalLink(String konditeremFacebookOldalLink) {
        this.konditeremFacebookOldalLink = konditeremFacebookOldalLink;
    }

    /**
     *
     * @return
     */
    public Konditerem getKonditerem() {
        return konditerem;
    }

    /**
     *
     * @param konditerem
     */
    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }
}
