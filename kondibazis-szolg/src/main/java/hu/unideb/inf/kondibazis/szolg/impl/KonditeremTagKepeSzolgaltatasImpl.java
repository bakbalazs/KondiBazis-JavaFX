package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagKepeTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagKepeSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagKepeMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * A konditermek tagjainak képének kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremTagKepeSzolgaltatasImpl implements KonditeremTagKepeSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagKepeTarolo KonditeremTagKepeTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy konditerem tag képéhez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private KonditeremTagKepeTarolo konditeremTagKepeTarolo;

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódusban a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódusának segítségével eltároljuk az adatbázisban a DTO-vá mappelt konditerm tag képét, ami ezáltal egy generált azonosítót is kap.
     * A metódus visszatérési értékként visszaadja az adatbázisban jelen lévő már ID-vel rendelkező konditerm tag képét,
     * amelyet a szolgáltatás eredményül visszaad átmappelve.
     */
    @Override
    public KonditeremTagKepeVo leterehozTagKepet(KonditeremTagKepeVo konditeremTagKepe) {

        KonditeremTagKepe tagKepe = KonditeremTagKepeMapper.toDto(konditeremTagKepe);

        KonditeremTagKepe mentettTagKepe = konditeremTagKepeTarolo.save(tagKepe);

        if (mentettTagKepe == null) {
            logolo.warn("Nem talalhato a(z) " + mentettTagKepe + " kep!");
        } else {
            logolo.debug("A(z) " + mentettTagKepe + " kep létrehozva!");
        }

        return KonditeremTagKepeMapper.toVo(mentettTagKepe);

    }
    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az adatbázisban az összes konditerm tag képét, majd visszaadja egy listában.
     * A műveletet a {@link KonditeremTagKepeTarolo#findAll()}  KonditeremTagKepeTarolo.findAll()}
     * metódus segítségével hajtja végre. Ennek eredményeképp kapunk egy listát amely tartalmazza az összes adatbázisban szereplő
     * tag képét. A szolgáltatás ezen lista elemeit átmappelve egy listában adja vissza eredményül.
     */
    @Override
    public List<KonditeremTagKepeVo> osszesKep() {

        List<KonditeremTagKepe> konditeremTagKepe = konditeremTagKepeTarolo.findAll();

        if (konditeremTagKepe == null) {
            logolo.warn("Nincs egy db kép sem!");
        } else {
            logolo.debug(konditeremTagKepe.size() + " db kép van elmentve.");
        }

        return KonditeremTagKepeMapper.toVo(konditeremTagKepe);
    }

}
