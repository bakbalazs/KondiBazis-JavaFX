package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;

/**
 * A konditerm tagok kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a tagok kezeléséhez.
 */
public interface KonditeremTagSzolgaltatas {

    /**
     * Ez a szolgáltatás végzi a tagok megtalálását az adatbázisban.
     * A kapott id-t továbbítja az adatbázis rétegnek a megfelelő metódussal,
     * ami lekérdezi az adatbázisból azt a tagot amelyiknek megeggyezik az id-ja
     * a paraméterben szereplővel.
     *
     * @param id A keresendő id
     * @return Az adatbázisból lekérdezett KonditeremTag
     * ami KonditeremTagVo-vá lett alakítva a KonditeremTagMapper
     * segítségével.
     */
    KonditeremTagVo keresTagot(Long id);

    /**
     * Ez a szolgáltatás létrehozza a paraméterül kapott tagot az adatbázisban.
     * Ezek után az implementációban szereplő adatbázis modulban lévő KonditeremTagTarolo
     * segítségével perzistenssé alakítjuk a tagot.
     *
     * @param konditeremTag Az a tag amelyet perzisztálni kell az adatbázisba.
     * @return Az immár perzisztált adatbáziselem.
     */
    KonditeremTagVo leterehozTagot(KonditeremTagVo konditeremTag);

    /**
     * Ez a szolgáltatás egy adatbázsiban már szereplő tag adatait frissíti, azaz
     * módosítja az adatbázisban úgy, hogy az megfeleljen a paraméterül kapott tag adataival.
     *
     * @param konditeremTag Az a módosított adatokkal rendelkező tag, amelyet szeretnénk perzisztálni.
     * @return A frissített tag amely már szerepel az adatbázisban.
     */
    KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag);

    /**
     * Visszaadja eredményül azt a listát, amely már csak azokat a tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a tagjait keressük.
     * @return Egy lista amely csak a konditerem tagjait tartalmazza.
     */
    List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak azokat a női tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a női tagjait keressük.
     * @return Egy lista amely csak a konditerem női tagjait tartalmazza.
     */
    List<KonditeremTagVo> noiTagok(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak azokat a férfi tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a férfi tagjait keressük.
     * @return Egy lista amely csak a konditerem férfi tagjait tartalmazza.
     */
    List<KonditeremTagVo> ferfiTagok(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak az alkalmas bérlettel rendelkező tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek az alkalmas bérletű tagjait keressük.
     * @return Egy lista amely csak a konditerem alkalmas bérletű tagjait tartalmazza.
     */
    List<KonditeremTagVo> alkalmasBerletuTagok(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak az időkorlátos bérlettel rendelkező tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek az időkorlátos bérletű tagjait keressük.
     * @return Egy lista amely csak a konditerem időkorlátos bérletű tagjait tartalmazza.
     */
    List<KonditeremTagVo> idokorlatosBerletuTagok(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak a lejárt alkalmas bérlettel rendelkező tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a lejárt alkalmas bérletű tagjait keressük.
     * @return Egy lista amely csak a konditerem lejárt alkalmas bérletű tagjait tartalmazza.
     */
    List<KonditeremTagVo> lejartAlkalmasBerletuTagok(KonditeremVo konditerem);

    /**
     * Visszaadja eredményül azt a listát, amely már csak a lejárt időkorlátos bérlettel rendelkező tagokat tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a lejárt időkorlátos bérletű tagjait keressük.
     * @return Egy lista amely csak a konditerem lejárt időkorlátos bérletű tagjait tartalmazza.
     */
    List<KonditeremTagVo> lejartIdokorlatosBerletuTagok(KonditeremVo konditerem);

}
