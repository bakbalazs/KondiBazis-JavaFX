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
     *
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
     *
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "konditeremId")
    private Konditerem konditerem;


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

    public Konditerem getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }
}
