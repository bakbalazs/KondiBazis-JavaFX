package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.db.tarolo.TelepulesekTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.TelepulesekMapper;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * A települések kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TelepulesekSzolgaltatasImpl implements TelepulesekSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(TelepulesekSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.TelepulesekTarolo TelepulesekTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy településhez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private TelepulesekTarolo telepulesekTarolo;

    /**
     * {@inheritDoc}
     * <p>
     * A metódusban a {@link hu.unideb.inf.kondibazis.db.tarolo.TelepulesekTarolo#findByiranyitoszam(Integer)} TelepulesTarolo.findByiranyitoszam}
     * segítségével lekérdezzük az adatbázisból a települések irányítószáma alapján.
     * Sikeres lekérdezés esetén a szolgáltatás visszaadja az átmappelt települést eredményül.
     */
    @Override
    public TelepulesekVo keresIranyitoszamot(Integer iranyitoszam) {
        Telepulesek talaltTelepules = telepulesekTarolo.findByiranyitoszam(iranyitoszam);

        if (talaltTelepules == null) {
            logolo.warn("Nem talalhato a(z) " + talaltTelepules + " iranyitoszammal rendelkezo telepules!");
        } else {
            logolo.debug("A(z) " + talaltTelepules + " iranyitoszammal rendelkezo telepules sikeresen lekerdezve!");
        }

        return TelepulesekMapper.toVo(talaltTelepules);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az adatbázisban az összes települést, majd visszaadja egy listában.
     * A műveletet a {@link TelepulesekTarolo#findAll()}  TelepulesekTarolo.findAll()}
     * metódus segítségével hajtja végre. Ennek eredményeképp kapunk egy listát amely tartalmazza az összes adatbázisban szereplő
     * települést. A szolgáltatás ezen lista elemeit átmappelve egy listában adja vissza eredményül.
     */
    @Override
    public List<TelepulesekVo> osszesTelepules() {
        List<Telepulesek> osszesTelepules = telepulesekTarolo.findAll();

        if (osszesTelepules == null) {
            logolo.warn("Nincs egy db telepules sem!");
        } else {
            logolo.debug(osszesTelepules.size() + " db telepules talalhato.");
        }

        return TelepulesekMapper.toVo(osszesTelepules);
    }

}
