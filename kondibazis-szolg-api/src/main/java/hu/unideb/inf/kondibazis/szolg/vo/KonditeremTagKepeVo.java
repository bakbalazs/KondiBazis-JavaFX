package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

/**
 * Egyszerű osztály a konditerm tagok képeihez tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class KonditeremTagKepeVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremTagKepeVo() {
    }

    /**
     * A konditerem tag képének id-ja.
     */
    private Long id;

    /**
     * A tag képe bytban.
     */
    private byte[] tagKep;

    /**
     * A képhez tartozó tag.
     */
    private KonditeremTagVo konditeremTag;

    /**
     * Visszaadja a konditerem tag képének id-ját.
     *
     * @return A konditerem tag képének id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja a konditerem tag képének id-ját.
     *
     * @param id A beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

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
    public KonditeremTagVo getKonditeremTag() {
        return konditeremTag;
    }

    /**
     * Beállítja azt a tagot akihez a képet beállítottuk.
     *
     * @param konditeremTag A beállítandó tag.
     */
    public void setKonditeremTag(KonditeremTagVo konditeremTag) {
        this.konditeremTag = konditeremTag;
    }

}
