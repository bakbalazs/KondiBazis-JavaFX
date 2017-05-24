package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Az adatbázisban egy települést reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy település nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "telepulesek")
public class Telepulesek extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public Telepulesek() {
    }

    /**
     * A település irányítószáma.
     */
    @Column(name = "iranyitoszam")
    private Integer iranyitoszam;

    /**
     * A megye neve ahol a település található.
     */
    @Column(name = "megye")
    private String megye;

    /**
     * A település neve.
     */
    @Column(name = "telepulesnev")
    private String telepulesnev;

    /**
     * Visszaadja a település irányítószámát.
     *
     * @return A település irányítószáma.
     */
    public Integer getIranyitoszam() {
        return iranyitoszam;
    }

    /**
     * Beállítja a település irányítószámát.
     *
     * @param iranyitoszam A beállítandó irányítószám.
     */
    public void setIranyitoszam(Integer iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    /**
     * Visszaadja a település megyéjének a nevét.
     *
     * @return A település megyéjének a nevét.
     */
    public String getMegye() {
        return megye;
    }

    /**
     * Beállítja a település megyéjének a nevét.
     *
     * @param megye A beállítandó megye neve.
     */
    public void setMegye(String megye) {
        this.megye = megye;
    }

    /**
     * Visszaadja a település nevét.
     *
     * @return A település neve.
     */
    public String getTelepulesnev() {
        return telepulesnev;
    }

    /**
     * Beállítja a település nevét.
     *
     * @param telepulesnev A beállítandó név.
     */
    public void setTelepulesnev(String telepulesnev) {
        this.telepulesnev = telepulesnev;
    }

}
