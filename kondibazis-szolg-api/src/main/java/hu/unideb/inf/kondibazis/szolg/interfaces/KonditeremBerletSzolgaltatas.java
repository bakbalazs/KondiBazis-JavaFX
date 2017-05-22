package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;

/**
 * A konditermek bérleteinek kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a konditermek bérleteinek kezeléséhez.
 */
public interface KonditeremBerletSzolgaltatas {

    /**
     * Ez a szolgáltatás végzi a bérletek megtalálását az adatbázisban.
     * A kapott id-t továbbítja az adatbázis rétegnek a megfelelő metódussal,
     * ami lekérdezi az adatbázisból azt a bérletet amelyiknek megeggyezik az id-ja
     * a paraméterben szereplővel.
     *
     * @param id A keresendő id
     * @return Az adatbázisból lekérdezett bérlet
     * ami KonditeremBerletVo-vá lett alakítva a KonditeremBerletMapper
     * segítségével.
     */
    KonditeremBerletVo keresBerletet(Long id);

    /**
     * Ez a szolgáltatás létrehozza a paraméterül kapott bérletet az adatbázisban.
     * Ezek után az implementációban szereplő adatbázis modulban lévő KonditeremBerletTarolo
     * segítségével perzistenssé alakítjuk a bérletet.
     *
     * @param ujBerlet Az a bérlet amelyet perzisztálni kell az adatbázisba.
     * @return Az immár perzisztált adatbáziselem.
     */
    KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet);

    /**
     * Ez a szolgáltatás egy adatbázsiban már szereplő bérlet adatait frissíti, azaz
     * módosítja az adatbázisban úgy, hogy az megfeleljen a paraméterül kapott bérlet adataival.
     *
     * @param konditeremBerlet Az a módosított adatokkal rendelkező bérlet, amelyet szeretnénk perzisztálni.
     * @return A frissített bérlet amely már szerepel az adatbázisban.
     */
    KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet);

    /**
     * Visszaadja eredményül azt a listát, amely már csak azokat a bérleteket tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek a bérleteit keressük.
     * @return Egy lista amely csak a konditerem bérleteit tartalmazza.
     */
    List<KonditeremBerletVo> konditeremOsszesBerlete(KonditeremVo konditerem);

}
