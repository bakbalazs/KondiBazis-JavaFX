package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Egyszerű osztály a konditerem tagjaihoz tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class KonditeremTagVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremTagVo() {
    }

    /**
     * Konditerem tag id-ja.
     */
    private Long id;


    /**
     * A Tag vezetékneve.
     */
    private String tagVezeteknev;

    /**
     * A Tag keresztneve.
     */
    private String tagKeresztnev;

    /**
     * A Tag teljes neve.
     */
    private String tagNeve;

    /**
     * A Tag neme.
     */
    private String tagNeme;

    /**
     * A Tag kora.
     */
    private int tagKora;

    /**
     * A Tag születési dátuma.
     */
    private LocalDate tagSzuletesidatuma;

    /**
     * A Tag mikor vásátolta a bérletet.
     */
    private LocalDate berletVasarlasideje;

    /**
     * Mikor jár le a Tag bérlete.
     */
    private LocalDate berletLejaratiIdeje;

    /**
     * A Tag által vásárolt bérlet neve.
     */
    private String vasaroltBerletNeve;

    /**
     * A Tag által vásárolt bérlet típusa.
     */
    private String vasaroltBerletTipusa;

    /**
     * A Tag városa.
     */
    private String tagVarosa;

    /**
     * A Tag megyéje.
     */
    private String tagMegyeje;

    /**
     * A Tag által vásrolt bérlet mennyi alkalomig jó.
     * Ha alkalmas bérlet vásárolt.
     */
    private int mennyiAlkalomMeg;

    /**
     * A Tag lejárt bérletáánek a neve.
     */
    private String lejartBerletNeve;

    /**
     * A Taghoz tartozó konditerem.
     */
    private KonditeremVo konditerem;

    /**
     * A Tgahoz tartozó bérlet.
     */
    private KonditeremBerletVo konditeremBerlet;

    /**
     * Visszaadja a konditerem tag id-ját.
     *
     * @return A konditerem tag id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja a konditrem tag id-ját.
     *
     * @param id A Beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * A Tag vezetéknevét adja vissza.
     *
     * @return A Tag vezetékneve.
     */
    public String getTagVezeteknev() {
        return tagVezeteknev;
    }

    /**
     * Beállítja a Tag vezetéknevét.
     *
     * @param tagVezeteknev A beállítandó vezetéknév.
     */
    public void setTagVezeteknev(String tagVezeteknev) {
        this.tagVezeteknev = tagVezeteknev;
    }

    /**
     * A Tag keresztnevét adja vissza.
     *
     * @return A Tag keresztneve.
     */
    public String getTagKeresztnev() {
        return tagKeresztnev;
    }

    /**
     * Beállítja a Tag keresztnevét.
     *
     * @param tagKeresztnev A beállítandó kereszetnév.
     */
    public void setTagKeresztnev(String tagKeresztnev) {
        this.tagKeresztnev = tagKeresztnev;
    }

    /**
     * Visszaadja a Tag teljes nevét.
     *
     * @return A Tag teljes neve.
     */
    public String getTagNeve() {
        return tagNeve;
    }

    /**
     * Beállítja a Tag teljes nevét.
     *
     * @param tagNeve A beállítandó név.
     */
    public void setTagNeve(String tagNeve) {
        this.tagNeve = tagNeve;
    }

    /**
     * Visszaadja a Tag nemét.
     *
     * @return A Tag neme.
     */
    public String getTagNeme() {
        return tagNeme;
    }

    /**
     * Beállítja a Tag nemét.
     *
     * @param tagNeme A beállítandó nem.
     */
    public void setTagNeme(String tagNeme) {
        this.tagNeme = tagNeme;
    }

    /**
     * Visszaadaja a Tag korát.
     *
     * @return A Tag kora.
     */
    public int getTagKora() {
        return tagKora;
    }

    /**
     * Beállítja a Tag korát.
     *
     * @param tagKora A beállítandó kor.
     */
    public void setTagKora(int tagKora) {
        this.tagKora = tagKora;
    }

    /**
     * Visszaadja a Tag születési dátumát.
     *
     * @return A Tag születési dátuma.
     */
    public LocalDate getTagSzuletesidatuma() {
        return tagSzuletesidatuma;
    }

    /**
     * Beállítja a Tag születési dátumát.
     *
     * @param tagSzuletesidatuma A beállítandó dátum.
     */
    public void setTagSzuletesidatuma(LocalDate tagSzuletesidatuma) {
        this.tagSzuletesidatuma = tagSzuletesidatuma;
    }

    /**
     * Visszaadja mikor vásrolta a Tag a bérletet.
     *
     * @return A bérlet vásárlás ideje.
     */
    public LocalDate getBerletVasarlasideje() {
        return berletVasarlasideje;
    }

    /**
     * Beállítja a bérlet vásárlás idejét.
     *
     * @param berletVasarlasideje A beállítandó dátum.
     */
    public void setBerletVasarlasideje(LocalDate berletVasarlasideje) {
        this.berletVasarlasideje = berletVasarlasideje;
    }

    /**
     * Visszaadja a Tag áltál vásrolt bérlet nevét.
     *
     * @return A vásárolt bérlet neve.
     */
    public String getVasaroltBerletNeve() {
        return vasaroltBerletNeve;
    }

    /**
     * Beállítja a bérlet nevét.
     *
     * @param vasaroltBerletNeve A beállítandó név.
     */
    public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
        this.vasaroltBerletNeve = vasaroltBerletNeve;
    }

    /**
     * Visszaadja hogyha a Tag alkalmas bérletet vásol, mennyi alkalom van még hátra.
     *
     * @return Visszaadja alkalmas bérlet esetén a Tag mennyi alkalommal mehet még.
     */
    public int getMennyiAlkalomMeg() {
        return mennyiAlkalomMeg;
    }

    /**
     * Beállítja hogy alkalmas bérlet esetén a Tagnak mennyi alkalma van.
     *
     * @param mennyiAlkalomMeg Az alkalmas bérlet vásárlása esetén beállítandó szám.
     */
    public void setMennyiAlkalomMeg(int mennyiAlkalomMeg) {
        this.mennyiAlkalomMeg = mennyiAlkalomMeg;
    }

    /**
     * Visszaadja a Tag lejárt bérletének a nevét.
     *
     * @return A Tag lejárt bérletének a neve.
     */
    public String getLejartBerletNeve() {
        return lejartBerletNeve;
    }

    /**
     * Beállítja a Tag lejárt bérletének a nevét.
     *
     * @param lejartBerletNeve A beállítandó név.
     */
    public void setLejartBerletNeve(String lejartBerletNeve) {
        this.lejartBerletNeve = lejartBerletNeve;
    }

    /**
     * Visszaadja a Tag áltál vásolt bérlet tipusát.
     *
     * @return A vásárolt bérlet tipusát.
     */
    public String getVasaroltBerletTipusa() {
        return vasaroltBerletTipusa;
    }

    /**
     * Beállítja a Tag áltál vásrolt bérlet tipusát.
     *
     * @param vasaroltBerletTipusa A beállítandó típus.
     */
    public void setVasaroltBerletTipusa(String vasaroltBerletTipusa) {
        this.vasaroltBerletTipusa = vasaroltBerletTipusa;
    }

    /**
     * Visszaadja a Tag konditermét.
     *
     * @return A Tag konditerme.
     */
    public KonditeremVo getKonditerem() {
        return konditerem;
    }

    /**
     * Beállítja a tag konditermét.
     *
     * @param konditerem A beállítandó konditerem.
     */
    public void setKonditerem(KonditeremVo konditerem) {
        this.konditerem = konditerem;
    }

    /**
     * Visszaadja a Tag városát.
     *
     * @return A tag városa.
     */
    public String getTagVarosa() {
        return tagVarosa;
    }

    /**
     * Beállítja a Tag városát.
     *
     * @param tagVarosa A beállítandó szöveg.
     */
    public void setTagVarosa(String tagVarosa) {
        this.tagVarosa = tagVarosa;
    }

    /**
     * Visszaadja a Tag Megyéjét.
     *
     * @return A tag megyéje.
     */
    public String getTagMegyeje() {
        return tagMegyeje;
    }

    /**
     * Beállítja a Tag megyéjét.
     *
     * @param tagMegyeje A beállítandó szöveg.
     */
    public void setTagMegyeje(String tagMegyeje) {
        this.tagMegyeje = tagMegyeje;
    }

    /**
     * Visszaadja mikor jár le a Tag áltál vásárolt bérlet.
     *
     * @return A Tag bérletének lejárati ideje.
     */
    public LocalDate getBerletLejaratiIdeje() {
        return berletLejaratiIdeje;
    }

    /**
     * Beállítja a Tag által vásrolt bérlet lejárati idejét.
     *
     * @param berletLejaratiIdeje A beállítandó dátum.
     */
    public void setBerletLejaratiIdeje(LocalDate berletLejaratiIdeje) {
        this.berletLejaratiIdeje = berletLejaratiIdeje;
    }

    /**
     * Visszaadja a tag bérletét.
     *
     * @return A Tag bérlete.
     */
    public KonditeremBerletVo getKonditeremBerlet() {
        return konditeremBerlet;
    }

    /**
     * Beállítja a Tag által vásárol bérletet.
     *
     * @param konditeremBerlet A beállítandó bérlet.
     */
    public void setKonditeremBerlet(KonditeremBerletVo konditeremBerlet) {
        this.konditeremBerlet = konditeremBerlet;
    }
}
