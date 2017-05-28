package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

import java.util.List;

/**
 * A települések kezelését leíró interfész.
 * Leírja hogy milyen szolgáltatásokat kell definiálni
 * a teleülések kezeléséhez.
 */
public interface TelepulesekSzolgaltatas {

    /**
     * Ez a szolgáltatás végzi a települések megtalálását az adatbázisban.
     * A kapott irányítószámot továbbítja az adatbázis rétegnek a megfelelő metódussal,
     * ami lekérdezi az adatbázisból azt a települést amelyiknek megeggyezik az itányítószáma
     * a paraméterben szereplővel.
     *
     * @param iranyitoszam A keresendő irányítószám.
     * @return Az adatbázisból lekérdezett Település
     * ami TelepulesVo-vá lett alakítva a TelepulesMapper
     * segítségével.
     */
    TelepulesekVo keresIranyitoszamot(Integer iranyitoszam);

    /**
     * Visszaadja az adatbázisban szereplő összes települést egy listában.
     *
     * @return Egy lista az adatbázisban lévő összes településről.
     */
    List<TelepulesekVo> osszesTelepules();

}
