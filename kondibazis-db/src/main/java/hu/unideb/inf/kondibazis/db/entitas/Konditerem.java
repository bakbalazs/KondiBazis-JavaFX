package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Az adatbázisban egy konditeremet reprezentáló osztály.
 * Ez egy entitás amit az adatbázisba leképezve egy konditerem nevű táblát kapunk a megfelelő oszlopokkal.
 */
@Entity
@Table(name = "konditerem")
public class Konditerem extends FoEntitas {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Üres konstruktor a szerializálhatóság miatt.
     */
    public Konditerem() {
    }

    /**
     * A konditerem felhasználóneve.
     * Ez egy egyedi felhasználónév, csak egyszer szerepelhet.
     * Ezt a {@link javax.persistence.Column Column} annotáció unique=true tagja biztosítja.
     */
    @Column(name = "felhasznalonev", unique = true)
    private String felhasznalonev;

    /**
     * A konditerem jelszava.
     */
    @Column(name = "jelszo")
    private String jelszo;

    /**
     * A konditerem neve.
     */
    @Column(name = "konditeremNeve")
    private String konditeremNeve;

    /**
     * A konditerem regisztrálásának a dátuma.
     */
    @Column(name = "regisztralasDatuma")
    private LocalDate regisztralasDatuma;

    /**
     * A konditeremhez tartozó tagok. Minden tagot külön kezelünk így minden konditerem rendelkezik egy listával, amelyben a tagjai szerepelnek.
     * A {@link javax.persistence.OneToMany OnToMany} annotáció megmondja hogy egy konditeremhez több tag tartozik.
     * A mappedBy taggal megadjuk hogy hol találja a Hibernate a konfigurációt ehhez az adattaghoz, ezesetben a kapcsolat másik
     * oldalán a "konditerem" nevű adattagon lesz megadva a konfiguráció.
     */
    @OneToMany(mappedBy = "konditerem", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    private List<KonditeremTag> konditeremTagok;

    /**
     * A konditeremhez tartozó bérletek. Minden bérletet külön kezelünk így minden konditerem rendelkezik egy listával, amelyben a bérletei szerepelnek.
     * A {@link javax.persistence.OneToMany OnToMany} annotáció megmondja hogy egy konditeremhez több bérlet tartozik.
     * A mappedBy taggal megadjuk hogy hol találja a Hibernate a konfigurációt ehhez az adattaghoz, ezesetben a kapcsolat másik
     * oldalán a "konditerem" nevű adattagon lesz megadva a konfiguráció.
     */
    @OneToMany(mappedBy = "konditerem", cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    private List<KonditeremBerlet> konditeremBerletek;

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
     * Visszaadja a konditerem tagjait.
     *
     * @return Egy {@link java.util.List List} amiben a kondietrem tagjai szerepelnek.
     */
    public List<KonditeremTag> getKonditeremTagok() {
        return konditeremTagok;
    }

    /**
     * Beállítja a konditerem tagjait.
     *
     * @param konditeremTagok A {@link java.util.List List} amiben a konditerem tagjai vannak.
     */
    public void setKonditeremTagok(List<KonditeremTag> konditeremTagok) {
        this.konditeremTagok = konditeremTagok;
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
     * Visszaadja a konditerem bérleteit.
     *
     * @return Egy {@link java.util.List List} amiben a konditerem bérletei szerepelnek.
     */
    public List<KonditeremBerlet> getKonditeremBerletek() {
        return konditeremBerletek;
    }

    /**
     * Beállítja a konditerem bérleteit.
     *
     * @param konditeremBerletek A {@link java.util.List List} amiben a konditerem bérletei vannak.
     */
    public void setKonditeremBerletek(List<KonditeremBerlet> konditeremBerletek) {
        this.konditeremBerletek = konditeremBerletek;
    }

}
