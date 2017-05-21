package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Egyszerű osztály a konditerm bérleteihez tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class KonditeremBerletVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremBerletVo() {
    }

    /**
     * A konditerem bérlet id-ja.
     */
    private Long id;

    /**
     * A konditerem bérletének a neve.
     */
    private String berletNeve;

    /**
     * A konditrem bérletének az ára.
     */
    private int berletAra;

    /**
     * A konditerem alaklas bérleteinek alkalom száma.
     */
    private int mennyiAlkalom;

    /**
     * A kondietrem időkorlátos béletinél a napok száma.
     */
    private int mennyiNap;

    /**
     * A kondietrem időkorlátos béletinél a hónapok száma.
     */
    private int mennyiHonap;

    /**
     * A konditerem bérletének a típusa.
     */
    private String berletTipusa;

    /**
     * A bérlethez tartozó konditerem.
     */
    private KonditeremVo konditerem;

    /**
     * A bérlethez tartozó tagok.
     */
    private List<KonditeremTagVo> konditeremTagok;

    /**
     * Visszaadja a konditerem bérletánek id-ját.
     *
     * @return A konditerem bérletének id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja a konditerem bérletének id-ját.
     *
     * @param id A beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Visszaadja a konditerem bérletének a nevét.
     *
     * @return A konditerem bérletének a nevét.
     */
    public String getBerletNeve() {
        return berletNeve;
    }

    /**
     * Beállítja a konditerem bérletének nevét.
     *
     * @param berletNeve A beállítandó név.
     */
    public void setBerletNeve(String berletNeve) {
        this.berletNeve = berletNeve;
    }

    /**
     * Visszaadja a konditerem bérletének az árát.
     *
     * @return A konditerem bérletének a neve.
     */
    public int getBerletAra() {
        return berletAra;
    }

    /**
     * Beállítja a konditerem bérletének az árát.
     *
     * @param berletAra A beállítandó ár.
     */
    public void setBerletAra(int berletAra) {
        this.berletAra = berletAra;
    }

    /**
     * Visszaadja a bérlet mennyi alklaommal használható fel.
     *
     * @return Mennyi alkalommal használható a bérlet.
     */
    public int getMennyiAlkalom() {
        return mennyiAlkalom;
    }

    /**
     * Beállítja mennyi alkalommal lehet haasználni a bérletet.
     *
     * @param mennyiAlkalom A beállítandó alkalom száma.
     */
    public void setMennyiAlkalom(int mennyiAlkalom) {
        this.mennyiAlkalom = mennyiAlkalom;
    }

    /**
     * Visszaadja mennyi napig hazsnálható a bérlet.
     *
     * @return Mennyi napig hazsnálható a bérlet.
     */
    public int getMennyiNap() {
        return mennyiNap;
    }

    /**
     * Beállítja mennyi napig hazsnálható a bérlet.
     *
     * @param mennyiNap A beállítandó nap száma.
     */
    public void setMennyiNap(int mennyiNap) {
        this.mennyiNap = mennyiNap;
    }

    /**
     * Visszaadja mennyi hónapig lehet használni a bérletet.
     *
     * @return Mennyi hónapig használható a bérlet.
     */
    public int getMennyiHonap() {
        return mennyiHonap;
    }

    /**
     * Beállítja mennyi hónapig használható a bérlet.
     *
     * @param mennyiHonap A beállítandó hónap száma.
     */
    public void setMennyiHonap(int mennyiHonap) {
        this.mennyiHonap = mennyiHonap;
    }

    /**
     * Visszaadja a bérlet tipusát.
     *
     * @return A bérlet típusa.
     */
    public String getBerletTipusa() {
        return berletTipusa;
    }

    /**
     * Beállítja a bérlet típusát.
     *
     * @param berletTipusa A beállítandó típus neve.
     */
    public void setBerletTipusa(String berletTipusa) {
        this.berletTipusa = berletTipusa;
    }

    /**
     * Visszaadja a bérlet konditermét.
     *
     * @return A bérlet konditerme.
     */
    public KonditeremVo getKonditerem() {
        return konditerem;
    }

    /**
     * Beállítja a bérlet konditermét.
     *
     * @param konditerem A beállítandó konditerem a bérlethez.
     */
    public void setKonditerem(KonditeremVo konditerem) {
        this.konditerem = konditerem;
    }

    /**
     * Visszaadja a tagok bérleteit.
     *
     * @return Egy {@link java.util.List List} amiben a bérletekhez tartozó tagok szerepelnek.
     */
    public List<KonditeremTagVo> getKonditeremTagok() {
        return konditeremTagok;
    }

    /**
     * Beállítja a tagok bérleteit.
     *
     * @param konditeremTagok A {@link java.util.List List} amiben a bérletekhez tartozó tagok $vannak.
     */
    public void setKonditeremTagok(List<KonditeremTagVo> konditeremTagok) {
        this.konditeremTagok = konditeremTagok;
    }
}
