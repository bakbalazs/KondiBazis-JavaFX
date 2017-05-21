package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Egyszerű osztály a konditermekhez tartozó adatok szállítására az egyes rétegek között (POJO).
 */
public class KonditeremVo implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public KonditeremVo() {
    }

    /**
     * Konditerem id-ja.
     */
    private Long id;

    /**
     * A konditerem felhasználóneve.
     */
    private String felhasznalonev;

    /**
     * A konditerem jelszava.
     */
    private String jelszo;

    /**
     * A konditerem neve.
     */
    private String konditeremNeve;

    /**
     * A konditerem regisztralásának a dátuma.
     */
    private LocalDate regisztralasDatuma;

    /**
     * A konditerem tagjainak a száma.
     */
    private Integer tagokSzama;

    /**
     * Lista a konditerem tagjairól.
     */
    private List<KonditeremTagVo> konditeremTagok;

    /**
     * Lista a konditerem bérleteiről.
     */
    private List<KonditeremBerletVo> konditeremBerletek;

    /**
     * Lista a konditerem elérhetőségeiről.
     */
    private List<KonditeremElerhetosegVo> konditeremElerhetosegek;

    /**
     * Visszaadja a konditerem id-ját.
     *
     * @return A konditerem id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja a konditrem id-ját.
     *
     * @param id A Beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Visszaadja a konditerem felhasználónevét.
     *
     * @return A konditerem felhasználóneve.
     */
    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    /**
     * Beállítja a konditerem felhasználónevét.
     *
     * @param felhasznalonev A beállítandó felhasználónév.
     */
    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    /**
     * Visszaadja a konditerem jelszavát.
     *
     * @return A konditerem jelszava.
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Beállítja a konditerem jelszavát.
     *
     * @param jelszo A beállítandó jelszó.
     */
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    /**
     * Visszaadja a konditerem nevét.
     *
     * @return A konditerem neve.
     */
    public String getKonditeremNeve() {
        return konditeremNeve;
    }

    /**
     * Beállítja a konditerem nevét.
     *
     * @param konditeremNeve A beállítandó név.
     */
    public void setKonditeremNeve(String konditeremNeve) {
        this.konditeremNeve = konditeremNeve;
    }

    /**
     * Visszaadja a konditerem regisztrálásának a dátumát.
     *
     * @return A konditerem regisztrálásának a dátuma.
     */
    public LocalDate getRegisztralasDatuma() {
        return regisztralasDatuma;
    }

    /**
     * Beállítja a konditerem regisztrálásának a dátumát.
     *
     * @param regisztralasDatuma A beállítandó dátum.
     */
    public void setRegisztralasDatuma(LocalDate regisztralasDatuma) {
        this.regisztralasDatuma = regisztralasDatuma;
    }

    /**
     * Visszaadja a konditerem tagjainak a számát.
     *
     * @return A konditerem tagjainak a száma.
     */
    public Integer getTagokSzama() {
        return tagokSzama;
    }

    /**
     * Beállítja a konditerem tagjainak a számát.
     *
     * @param tagokSzama A beállítandó szám.
     */
    public void setTagokSzama(Integer tagokSzama) {
        this.tagokSzama = tagokSzama;
    }

    /**
     * Visszaadja a konditerem tagjait.
     *
     * @return Egy {@link java.util.List List} amiben a kondietrem tagjai szerepelnek.
     */
    public List<KonditeremTagVo> getKonditeremTagok() {
        return konditeremTagok;
    }

    /**
     * Beállítja a konditerem tagjait.
     *
     * @param konditeremTagok A {@link java.util.List List} amiben a konditerem tagjai vannak.
     */
    public void setKonditeremTagok(List<KonditeremTagVo> konditeremTagok) {
        this.konditeremTagok = konditeremTagok;
    }

    /**
     * Visszaadja a konditerem bérleteit.
     *
     * @return Egy {@link java.util.List List} amiben a konditerem bérletei szerepelnek.
     */
    public List<KonditeremBerletVo> getKonditeremBerletek() {
        return konditeremBerletek;
    }

    /**
     * Beállítja a konditerem bérleteit.
     *
     * @param konditeremBerletek A {@link java.util.List List} amiben a konditerem bérletei vannak.
     */
    public void setKonditeremBerletek(List<KonditeremBerletVo> konditeremBerletek) {
        this.konditeremBerletek = konditeremBerletek;
    }

    /**
     * Visszaadja a konditerem elérhetőségeit.
     *
     * @return Egy {@link java.util.List List} amiben a konditerem elérhetőségei szerepelnek.
     */
    public List<KonditeremElerhetosegVo> getKonditeremElerhetosegek() {
        return konditeremElerhetosegek;
    }

    /**
     * Beállítja a konditerem elérhetőségeit.
     *
     * @param konditeremElerhetosegek A {@link java.util.List List} amiben a konditerem elérhetőségei vannak.
     */
    public void setKonditeremElerhetosegek(List<KonditeremElerhetosegVo> konditeremElerhetosegek) {
        this.konditeremElerhetosegek = konditeremElerhetosegek;
    }
}
