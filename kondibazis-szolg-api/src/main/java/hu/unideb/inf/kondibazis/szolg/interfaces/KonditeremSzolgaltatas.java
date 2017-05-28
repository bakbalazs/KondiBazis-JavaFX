package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;
import java.util.Map;

/**
 * A konditermek kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a konditermek kezeléséhez.
 */
public interface KonditeremSzolgaltatas {

    /**
     * Ez a szolgáltatás végzi a konditermek megtalálását az adatbázisban.
     * A kapott felhasználónevet továbbítja az adatbázis rétegnek a megfelelő metódussal,
     * ami lekérdezi az adatbázisból azt a konditermet amelyiknek megeggyezik a felhasználóneve
     * a paraméterben szereplővel.
     *
     * @param felhasznalonev A keresendő felhasználónév
     * @return Az adatbázisból lekérdezett Konditerem
     * ami KonditeremVo-vá lett alakítva a KonditeremMapper
     * segítségével.
     */
    KonditeremVo keresKonditermet(String felhasznalonev);

    /**
     * Ez a szolgáltatás végzi a konditermek megtalálását az adatbázisban.
     * A kapott id-t továbbítja az adatbázis rétegnek a megfelelő metódussal,
     * ami lekérdezi az adatbázisból azt a konditermet amelyiknek megeggyezik az id-ja
     * a paraméterben szereplővel.
     *
     * @param id A keresendő id
     * @return Az adatbázisból lekérdezett Konditerem
     * ami KonditeremVo-vá lett alakítva a KonditeremMapper
     * segítségével.
     */
    KonditeremVo keresKonditeremetId(Long id);

    /**
     * Ez a szolgáltatás létrehozza a paraméterül kapott konditeremet az adatbázisban.
     * Mivel új konditeremről van szó beállítunk neki alapértelmezetten egy
     * regisztrálási dátumot arra a napra amikor regisztrált az alkalmazásban.
     * Ezek után az implementációban szereplő adatbázis modulban lévő KonditeremTarolo
     * segítségével perzistenssé alakítjuk a konditermet.
     *
     * @param konditerem Az a konditerem amelyet perzisztálni kell az adatbázisba.
     * @return Az immár perzisztált adatbáziselem.
     */
    KonditeremVo konditeremetLetrehoz(KonditeremVo konditerem);

    /**
     * Ez a szolgáltatás egy adatbázsiban már szereplő konditerem adatait frissíti, azaz
     * módosítja az adatbázisban úgy, hogy az megfeleljen a paraméterül kapott konditerem adataival.
     *
     * @param konditerem Az a módosított adatokkal rendelkező konditerem, amelyet szeretnénk perzisztálni.
     * @return A frissített konditerem amely már szerepel az adatbázisban.
     */
    KonditeremVo frissitKonditermet(KonditeremVo konditerem);

    /**
     * Meghatározza a konditrem tagjait városonként számolja meg, majd visszaadja
     * csoportosítva.
     *
     * @param konditerem A konditrem akinek a tagjainak a városaira kíváncsiak vagyunk.
     * @return Egy {@link java.util.Map Map} amiben a kulcsok a városok nevei, az értékek
     * pedig hogy a tagok száma a városokhoz.
     */
    Map<String, Long> varosDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    /**
     * Meghatározza a konditrem tagjait megyénként számolja meg, majd visszaadja
     * csoportosítva.
     *
     * @param konditerem A konditrem akinek a tagjainak a megyénire kíváncsiak vagyunk.
     * @return Egy {@link java.util.Map Map} amiben a kulcsok a megyék nevei, az értékek
     * pedig hogy a tagok száma a megye nevek a városokhoz.
     */
    Map<String, Long> megyeDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    /**
     * Meghatározza a konditrem tagjait nemenként számolja meg, majd visszaadja
     * csoportosítva.
     *
     * @param konditerem A konditrem akinek a tagjainak a nemére kíváncsiak vagyunk.
     * @return Egy {@link java.util.Map Map} amiben a kulcsok a tagok nemei, az értékek
     * pedig hogy mennnyien vannak azonos nemű tagok.
     */
    Map<String, Long> nemekDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    /**
     * Meghatározza a konditrem tagjait bérlet típusonként, majd visszaadja
     * csoportosítva.
     *
     * @param konditerem A konditrem akinek a tagjainak a bérlet típusára kíváncsiak vagyunk.
     * @return Egy {@link java.util.Map Map} amiben a kulcsok a tagok áltál vásárolt bérletek típusa
     * az értékek pedig hogy mennyien vannak azonos bérlet típussal rendelkező tagok.
     */
    Map<String, Long> berlettipusDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    /**
     * Visszaadja az adatbázisban szereplő összes konditermet egy listában.
     *
     * @return Egy lista az adatbázisban lévő összes konditeremről.
     */
    List<KonditeremVo> osszesKonditerem();
}
