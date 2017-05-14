package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Az adatbázisban egy bérletet reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditeremberlet nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditeremBerlet")
public class KonditeremBerlet extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremBerlet() {
    }

    /**
     * A bérlet neve.
     */
    @Column(name = "berlet_neve")
    private String berletNeve;

    /**
     * A bérlet ára.
     */
    @Column(name = "berletAra")
    private int berletAra;

    /**
     * A bérlet mennyi alkalommal használható.
     */
    @Column(name = "mennyiAlkalom")
    private int mennyiAlkalom;

    /**
     * A bérlet mennyi napig használható.
     */
    @Column(name = "mennyiNap")
    private int mennyiNap;

    /**
     * A bérlet mennyi hónapig használható.
     */
    @Column(name = "mennyiHonap")
    private int mennyiHonap;

    /**
     * A bérlet típusa.
     */
    @Column(name = "berletTipusa")
    private String berletTipusa;

    /**
     *
     */
    @ManyToOne()
    private Konditerem konditerem;

    /**
     * Visszaadja a bérlet nevét.
     * @return A bérlet neve.
     */
    public String getBerletNeve() {
        return berletNeve;
    }

    /**
     * Beállítja a bérlet nevét.
     * @param berletNeve A beállítandó név.
     */
    public void setBerletNeve(String berletNeve) {
        this.berletNeve = berletNeve;
    }

    /**
     * Visszaadja a bérlet árát.
     * @return A bérlet ára.
     */
    public int getBerletAra() {
        return berletAra;
    }

    /**
     * Beállítja a bérlet árát.
     * @param berletAra A beállítandó ár.
     */
    public void setBerletAra(int berletAra) {
        this.berletAra = berletAra;
    }

    /**
     * Visszaadja a bérlet mennyi alklaommal használható fel.
     * @return Mennyi alkalommal használható a bérlet.
     */
    public int getMennyiAlkalom() {
        return mennyiAlkalom;
    }

    /**
     * Beállítja mennyi alkalommal lehet haasználni a bérletet.
     * @param mennyiAlkalom A beállítandó alkalom száma.
     */
    public void setMennyiAlkalom(int mennyiAlkalom) {
        this.mennyiAlkalom = mennyiAlkalom;
    }

    /**
     * Visszaadja mennyi napig hazsnálható a bérlet.
     * @return Mennyi napig hazsnálható a bérlet.
     */
    public int getMennyiNap() {
        return mennyiNap;
    }

    /**
     * Beállítja mennyi napig hazsnálható a bérlet.
     * @param mennyiNap A beállítandó nap száma.
     */
    public void setMennyiNap(int mennyiNap) {
        this.mennyiNap = mennyiNap;
    }

    /**
     * Visszaadja mennyi hónapig lehet használni a bérletet.
     * @return Mennyi hónapig használható a bérlet.
     */
    public int getMennyiHonap() {
        return mennyiHonap;
    }

    /**
     * Beállítja mennyi hónapig használható a bérlet.
     * @param mennyiHonap A beállítandó hónap száma.
     */
    public void setMennyiHonap(int mennyiHonap) {
        this.mennyiHonap = mennyiHonap;
    }

    /**
     * Visszaadja a bérlet tipusát.
     * @return A bérlet típusa.
     */
    public String getBerletTipusa() {
        return berletTipusa;
    }

    /**
     * Beállítja a bérlet típusát.
     * @param berletTipusa A beállítandó típus neve.
     */
    public void setBerletTipusa(String berletTipusa) {
        this.berletTipusa = berletTipusa;
    }

    /**
     * @return
     */
    public Konditerem getKonditerem() {
        return konditerem;
    }

    /**
     * @param konditerem
     */
    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }

    @Override
    public String toString() {
        return "KonditeremBerlet{" +
                "berletNeve='" + berletNeve + '\'' +
                ", berletAra=" + berletAra +
                ", mennyiAlkalom=" + mennyiAlkalom +
                ", mennyiNap=" + mennyiNap +
                ", mennyiHonap=" + mennyiHonap +
                ", berletTipusa='" + berletTipusa + '\'' +
                ", konditerem=" + konditerem +
                '}';
    }
}
