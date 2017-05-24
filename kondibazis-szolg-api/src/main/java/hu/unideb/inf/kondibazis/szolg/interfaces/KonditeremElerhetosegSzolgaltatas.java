package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;

/**
 * A konditermek elérhetőségeinek kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a konditermek elérhetőségeinek kezeléséhez.
 */
public interface KonditeremElerhetosegSzolgaltatas {

    /**
     * Ez a szolgáltatás létrehozza a paraméterül kapott elérhetőséget az adatbázisban.
     * Ezek után az implementációban szereplő adatbázis modulban lévő KonditeremElerhetosegTarolo
     * segítségével perzistenssé alakítjuk az elérhetőséget.
     *
     * @param elerhetoseg Az az elérhetőség amelyet perzisztálni kell az adatbázisba.
     * @return Az immár perzisztált adatbáziselem.
     */
    KonditeremElerhetosegVo letrehozElerhetoseget(KonditeremElerhetosegVo elerhetoseg);

    /**
     * Ez a szolgáltatás egy adatbázsiban már szereplő elérhetőség adatait frissíti, azaz
     * módosítja az adatbázisban úgy, hogy az megfeleljen a paraméterül kapott elérhetőség adataival.
     *
     * @param konditeremElerhetoseg Az a módosított adatokkal rendelkező elérhetőség, amelyet szeretnénk perzisztálni.
     * @return A frissített konditerem elérhetőség amely már szerepel az adatbázisban.
     */
    KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg);

    /**
     * Visszaadja eredményül azt a listát, amely már csak azokat az elérhetőségeket tartalmazza,
     * amelyek a paraméterként megadott konditeremhez tartoznak.
     *
     * @param konditerem Az a konditerem akinek az elérhetőségeit keressük.
     * @return Egy lista amely csak a konditerem elérhetőségeit tartalmazza.
     */
    List<KonditeremElerhetosegVo> konditremElerhetosegei(KonditeremVo konditerem);

}
