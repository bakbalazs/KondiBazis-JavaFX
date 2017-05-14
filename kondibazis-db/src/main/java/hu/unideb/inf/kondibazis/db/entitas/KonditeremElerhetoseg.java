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
     * Megye neve ahol a konditerem található.
     */
    @Column(name = "megye_Neve")
    private String megyeNeve;

    /**
     * Irányítszám ahol a konditerem található.
     */
    @Column(name = "iranyitoSzam")
    private Integer iranyitoSzam;

    /**
     * Város neve ahol a konditerem található.
     */
    @Column(name = "varos_neve")
    private String varosNeve;

    /**
     * Utca neve ahol a konditerem található.
     */
    @Column(name = "utca_Neve")
    private String utcaNeve;

    /**
     * Pontos ház szám ahol a konditerem található.
     */
    @Column(name = "haz_Szam")
    private Integer hazSzam;

    /**
     * Emelet szám ha van ahol a konditerem található.
     */
    @Column(name = "emelet")
    private Integer emelet;

    /**
     * Ajtó száma ahol a konditerem található.
     */
    @Column(name = "ajto")
    private String ajto;

    /**
     * A konditerem telefonszáma.
     */
    @Column(name = "telefonszam")
    private String telefonszam;

    /**
     * A konditerem e-mailcíme.
     */
    @Column(name = "emailCim")
    private String emailCim;

    /**
     * A konditerem weboldala.
     */
    @Column(name = "weboldalLink")
    private String weboldalLink;

    /**
     * A konditerem facebook oldala.
     */
    @Column(name = "facebookOldalLink")
    private String facebookOldalLink;

    /**
     *
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "konditerem_id")
    private Konditerem konditerem;

    /**
     * Visszaadja annak a megyének a nevét ahol a konditerem található.
     * @return A megye neve.
     */
    public String getMegyeNeve() {
        return megyeNeve;
    }

    /**
     * Beállítja annak a megyének a nevét ahol a konditrem található.
     * @param megyeNeve A beállítandó név.
     */
    public void setMegyeNeve(String megyeNeve) {
        this.megyeNeve = megyeNeve;
    }

    /**
     * Visszaadja annak a városnak az irányítószámát ahol a konditerem található.
     * @return Az irányítószám.
     */
    public Integer getIranyitoSzam() {
        return iranyitoSzam;
    }

    /**
     * Beállítja annak a városnak az irányítószámát ahol a konditerem található.
     * @param iranyitoSzam A megadható szám.
     */
    public void setIranyitoSzam(Integer iranyitoSzam) {
        this.iranyitoSzam = iranyitoSzam;
    }

    /**
     * Visszaadja annak a városnak a nevét ahol a konditerem található.
     * @return A város neve.
     */
    public String getVarosNeve() {
        return varosNeve;
    }

    /**
     * Beállítja annak a városnak a nevét ahol a konditerem található.
     * @param varosNeve A megadható név.
     */
    public void setVarosNeve(String varosNeve) {
        this.varosNeve = varosNeve;
    }

    /**
     * Visszaadja annak az utcának a nevét ahol a konditerem elhelyezkedik a városban.
     * @return Az utca neve a városban.
     */
    public String getUtcaNeve() {
        return utcaNeve;
    }

    /**
     * Beállítja annak az utcának a nevét ahol a konditerem elhelyezkedik a városban.
     * @param utcaNeve A megadható név.
     */
    public void setUtcaNeve(String utcaNeve) {
        this.utcaNeve = utcaNeve;
    }

    /**
     * Visszaadja annak a helynek a ház számát ahol a konditerem elhelyezkedik az adott utcában.
     * @return Az utcában a ház szám.
     */
    public Integer getHazSzam() {
        return hazSzam;
    }

    /**
     * Beállítja annak a helynek a ház számát ahol a konditerem elhelyezkedik az adott utcában.
     * @param hazSzam A megadható szám.
     */
    public void setHazSzam(Integer hazSzam) {
        this.hazSzam = hazSzam;
    }

    /**
     *
     * @return
     */
    public Integer getEmelet() {
        return emelet;
    }

    /**
     *
     * @param emelet
     */
    public void setEmelet(Integer emelet) {
        this.emelet = emelet;
    }

    /**
     *
     * @return
     */
    public String getAjto() {
        return ajto;
    }

    /**
     *
     * @param ajto
     */
    public void setAjto(String ajto) {
        this.ajto = ajto;
    }

    /**
     *
     * @return
     */
    public String getTelefonszam() {
        return telefonszam;
    }

    /**
     *
     * @param telefonszam
     */
    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    /**
     *
     * @return
     */
    public String getEmailCim() {
        return emailCim;
    }

    /**
     *
     * @param emailCim
     */
    public void setEmailCim(String emailCim) {
        this.emailCim = emailCim;
    }

    /**
     *
     * @return
     */
    public String getWeboldalLink() {
        return weboldalLink;
    }

    /**
     *
     * @param weboldalLink
     */
    public void setWeboldalLink(String weboldalLink) {
        this.weboldalLink = weboldalLink;
    }

    /**
     *
     * @return
     */
    public String getFacebookOldalLink() {
        return facebookOldalLink;
    }

    /**
     *
     * @param facebookOldalLink
     */
    public void setFacebookOldalLink(String facebookOldalLink) {
        this.facebookOldalLink = facebookOldalLink;
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

    @Override
    public String toString() {
        return "KonditeremElerhetoseg [megyeNeve=" + megyeNeve + ", iranyitoSzam=" + iranyitoSzam + ", varosNeve="
                + varosNeve + ", utcaNeve=" + utcaNeve + ", hazSzam=" + hazSzam + ", emelet=" + emelet + ", ajto="
                + ajto + ", telefonszam=" + telefonszam + ", emailCim=" + emailCim + ", weboldalLink=" + weboldalLink
                + ", facebookOldalLink=" + facebookOldalLink + ", konditerem=" + konditerem + "]";
    }

}
