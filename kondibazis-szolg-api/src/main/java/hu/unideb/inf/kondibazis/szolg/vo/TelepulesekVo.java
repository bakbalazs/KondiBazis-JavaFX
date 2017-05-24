package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

/**
 * Egyszerű osztály a településekhez tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class TelepulesekVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public TelepulesekVo() {
    }

    /**
     * A település irányítószáma.
     */
    private Integer iranyitoszam;

    /**
     * A megye neve ahol a település található.
     */
    private String megye;

    /**
     * A település neve.
     */
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
