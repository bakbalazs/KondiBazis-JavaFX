package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;

import java.util.List;

/**
 * A konditerm tagok képének kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a tagok képének kezeléséhez.
 */
public interface KonditeremTagKepeSzolgaltatas {

    /**
     * Ez a szolgáltatás létrehozza a paraméterül kapott tag képét az adatbázisban.
     * Ezek után az implementációban szereplő adatbázis modulban lévő KonditeremTagKepeTarolo
     * segítségével perzistenssé alakítjuk a tagot.
     *
     * @param ujTagKepe Az a tagnak a képe amelyet perzisztálni kell az adatbázisba.
     * @return Az immár perzisztált adatbáziselem.
     */
    KonditeremTagKepeVo leterehozTagKepet(KonditeremTagKepeVo ujTagKepe);

    /**
     * Visszaadja az adatbázisban szereplő összes tag képét egy listában.
     *
     * @return Egy lista az adatbázisban lévő összes tag képéről.
     */
    List<KonditeremTagKepeVo> osszesKep();
}
