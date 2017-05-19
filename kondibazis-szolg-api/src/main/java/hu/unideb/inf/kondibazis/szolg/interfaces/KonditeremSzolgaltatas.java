package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

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
     * @param konditerem Az a módosított adatokkal rendelkező konditerem, amelyet szeretnénk perzisztálni.
     * @return A frissített konditerem amely már szerepel az adatbázisban.
     */
    KonditeremVo frissitKonditermet(KonditeremVo konditerem);

    //TODO
    Map<String, Long> varosDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    //TODO
    Map<String, Long> megyeDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    //TODO
    Map<String, Long> nemekDiagramKonditeremTagokhoz(KonditeremVo konditerem);

    //TODO
    Map<String, Long> berlettipusDiagramKonditeremTagokhoz(KonditeremVo konditerem);

}
