package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Az adatbázisban egy konditerem tagot reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditeremtag nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditeremTag")
public class KonditeremTag extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremTag() {
    }

    /**
     * A Tag vezetékneve.
     */
    @Column(name = "tagVezetekneve")
    private String tagVezeteknev;

    /**
     * A Tag keresztneve.
     */
    @Column(name = "tagKeresztneve")
    private String tagKeresztnev;

    /**
     * A Tag teljes neve.
     */
    @Column(name = "tagNeve")
    private String tagNeve;

    /**
     * A Tag neme.
     */
    @Column(name = "tagNeme")
    private String tagNeme;

    /**
     * A Tag kora.
     */
    @Column(name = "tagKora")
    private int tagKora;

    /**
     * A Tag születési dátuma.
     */
    @Column(name = "tagSzuletesidatum")
    private LocalDate tagSzuletesidatuma;

    /**
     * A Tag mikor vásátolta a bérletet.
     */
    @Column(name = "bereletVasarlasideje")
    private LocalDate berletVasarlasideje;

    /**
     * Mikor jár le a Tag bérlete.
     */
    @Column(name = "bereletLejaratiIdeje")
    private LocalDate berletLejaratiIdeje;

    /**
     * A Tag által vásárolt bérlet neve.
     */
    @Column(name = "vasaroltBereletneve")
    private String vasaroltBerletNeve;

    /**
     * A Tag által vásárolt bérlet típusa.
     */
    @Column(name = "vasaroltBerletTipusa")
    private String vasaroltBerletTipusa;

    /**
     * A Tag által vásrolt bérlet mennyi alkalomig jó.(Ha alkalmas bérlet vásárolt)
     */
    @Column(name = "mennyiAlkalomMeg")
    private int mennyiAlkalomMeg;

    /**
     * A Tag városa.
     */
    @Column(name = "tagVarosa")
    private String tagVarosa;

    /**
     * A Tag megyéje.
     */
    @Column(name = "tagMegyeje")
    private String tagMegyeje;

    /**
     *
     */
    @ManyToOne()
    private Konditerem konditerem;

    /**
     * A Tag vezetéknevét adja vissza.
     * @return A Tag vezetékneve.
     */
    public String getTagVezeteknev() {
        return tagVezeteknev;
    }

    /**
     * Beállítja a Tag vezetéknevét.
     * @param tagVezeteknev A beállítandó vezetéknév.
     */
    public void setTagVezeteknev(String tagVezeteknev) {
        this.tagVezeteknev = tagVezeteknev;
    }

    /**
     * A Tag keresztnevét adja vissza.
     * @return A Tag keresztneve.
     */
    public String getTagKeresztnev() {
        return tagKeresztnev;
    }

    /**
     * Beállítja a Tag keresztnevét.
     * @param tagKeresztnev A beállítandó kereszetnév.
     */
    public void setTagKeresztnev(String tagKeresztnev) {
        this.tagKeresztnev = tagKeresztnev;
    }

    /**
     * Visszaadja a Tag teljes nevét.
     * @return A Tag teljes neve.
     */
    public String getTagNeve() {
        return tagNeve;
    }

    /**
     * Beállítja a Tag teljes nevét.
     * @param tagNeve A beállítandó név.
     */
    public void setTagNeve(String tagNeve) {
        this.tagNeve = tagNeve;
    }

    /**
     * Visszaadja a Tag nemét.
     * @return A Tag neme.
     */
    public String getTagNeme() {
        return tagNeme;
    }

    /**
     * Beállítja a Tag nemét.
     * @param tagNeme A beállítandó nem.
     */
    public void setTagNeme(String tagNeme) {
        this.tagNeme = tagNeme;
    }

    /**
     * Visszaadaja a Tag korát.
     * @return A Tag kora.
     */
    public int getTagKora() {
        return tagKora;
    }

    /**
     * Beállítja a Tag korát.
     * @param tagKora A beállítandó kor.
     */
    public void setTagKora(int tagKora) {
        this.tagKora = tagKora;
    }

    /**
     * Visszaadja a Tag születési dátumát.
     * @return A Tag születési dátuma.
     */
    public LocalDate getTagSzuletesidatuma() {
        return tagSzuletesidatuma;
    }

    /**
     * Beállítja a Tag születési dátumát.
     * @param tagSzuletesidatuma A beállítandó dátum.
     */
    public void setTagSzuletesidatuma(LocalDate tagSzuletesidatuma) {
        this.tagSzuletesidatuma = tagSzuletesidatuma;
    }

    /**
     * Visszaadja mikor vásrolta a Tag a bérletet.
     * @return A bérlet vásárlás ideje.
     */
    public LocalDate getBerletVasarlasideje() {
        return berletVasarlasideje;
    }

    /**
     * Beállítja a bérlet vásárlás idejét.
     * @param berletVasarlasideje A beállítandó dátum.
     */
    public void setBerletVasarlasideje(LocalDate berletVasarlasideje) {
        this.berletVasarlasideje = berletVasarlasideje;
    }

    /**
     * Visszaadja a Tag áltál vásrolt bérlet nevét.
     * @return A vásárolt bérlet neve.
     */
    public String getVasaroltBerletNeve() {
        return vasaroltBerletNeve;
    }

    /**
     * Beállítja a bérlet nevét.
     * @param vasaroltBerletNeve A beállítandó név.
     */
    public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
        this.vasaroltBerletNeve = vasaroltBerletNeve;
    }

    //TODO
    public int getMennyiAlkalomMeg() {
        return mennyiAlkalomMeg;
    }

    public void setMennyiAlkalomMeg(int mennyiAlkalomMeg) {
        this.mennyiAlkalomMeg = mennyiAlkalomMeg;
    }

    /**
     * Visszaadja a Tag áltál vásolt bérlet tipusát.
     * @return A vásárolt bérlet tipusát.
     */
    public String getVasaroltBerletTipusa() {
        return vasaroltBerletTipusa;
    }

    /**
     * Beállítja a Tag áltál vásrolt bérlet tipusát.
     * @param vasaroltBerletTipusa A beállítandó típus.
     */
    public void setVasaroltBerletTipusa(String vasaroltBerletTipusa) {
        this.vasaroltBerletTipusa = vasaroltBerletTipusa;
    }

    public Konditerem getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }

    /**
     * Visszaadja a Tag városát.
     * @return A tag városa.
     */
    public String getTagVarosa() {
        return tagVarosa;
    }

    /**
     * Beállítja a Tag városát.
     * @param tagVarosa A beállítandó szöveg.
     */
    public void setTagVarosa(String tagVarosa) {
        this.tagVarosa = tagVarosa;
    }

    /**
     * Visszaadja a Tag Megyéjét.
     * @return A tag megyéje.
     */
    public String getTagMegyeje() {
        return tagMegyeje;
    }

    /**
     * Beállítja a Tag megyéjét.
     * @param tagMegyeje A beállítandó szöveg.
     */
    public void setTagMegyeje(String tagMegyeje) {
        this.tagMegyeje = tagMegyeje;
    }

    /**
     * Visszaadja mikor jár le a Tag áltál vásárolt bérlet.
     * @return A Tag bérletének lejárati ideje.
     */
    public LocalDate getBerletLejaratiIdeje() {
        return berletLejaratiIdeje;
    }

    /**
     * Beállítja a Tag által vásrolt bérlet lejárati idejét.
     * @param berletLejaratiIdeje A beállítandó dátum.
     */
    public void setBerletLejaratiIdeje(LocalDate berletLejaratiIdeje) {
        this.berletLejaratiIdeje = berletLejaratiIdeje;
    }

    @Override
    public String toString() {
        return "KonditeremTag{" +
                "tagVezeteknev='" + tagVezeteknev + '\'' +
                ", tagKeresztnev='" + tagKeresztnev + '\'' +
                ", tagNeve='" + tagNeve + '\'' +
                ", tagNeme='" + tagNeme + '\'' +
                ", tagKora=" + tagKora +
                ", tagSzuletesidatuma=" + tagSzuletesidatuma +
                ", berletVasarlasideje=" + berletVasarlasideje +
                ", berletLejaratiIdeje=" + berletLejaratiIdeje +
                ", vasaroltBerletNeve='" + vasaroltBerletNeve + '\'' +
                ", vasaroltBerletTipusa='" + vasaroltBerletTipusa + '\'' +
                ", tagVarosa='" + tagVarosa + '\'' +
                ", tagMegyeje='" + tagMegyeje + '\'' +
                ", konditerem=" + konditerem +
                '}';
    }
}
