package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;

/**
 * Az adatbázisban egy konditerem tag képét reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditeremtagkepe nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditeremtagkepe")
public class KonditeremTagKepe extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremTagKepe() {
    }

    /**
     * A tag képe bytban.
     */
    @Lob
    @Column(name = "tagKep")
    private byte[] tagKep;

    /**
     * A képhez tartozó tag.
     */
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "konditeremTagId")
    private KonditeremTag konditeremTag;

    /**
     * Visszaadja az adott Tag fenyképét.
     *
     * @return A tag fenyképe.
     */
    public byte[] getTagKep() {
        return tagKep;
    }

    /**
     * Beállítja az adott Tag fenyképét.
     *
     * @param tagKep A beállítandó kép.
     */
    public void setTagKep(byte[] tagKep) {
        this.tagKep = tagKep;
    }

    /**
     * Visszaadja az adott tagot akihez a kép tartozik.
     *
     * @return A tag.
     */
    public KonditeremTag getKonditeremTag() {
        return konditeremTag;
    }

    /**
     * Beállítja azt a tagot akihez a képet beállítottuk.
     *
     * @param konditeremTag A beállítandó tag.
     */
    public void setKonditeremTag(KonditeremTag konditeremTag) {
        this.konditeremTag = konditeremTag;
    }
}
