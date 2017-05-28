package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremElerhetosegTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremElerhetosegMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * A konditermek elérhetőségének kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremElerhetosegSzolgaltatasImpl implements KonditeremElerhetosegSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremElerhetosegSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremElerhetosegTarolo KonditeremElerhetosegTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy konditerem elérhetőségéhez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private KonditeremElerhetosegTarolo konditeremElerhetosegTarolo;

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódusban a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódusának segítségével eltároljuk az adatbázisban a DTO-vá mappelt elérhetőség, ami ezáltal egy generált azonosítót is kap.
     * A metódus visszatérési értékként visszaadja az adatbázisban jelen lévő már ID-vel rendelkező elérhetőséget,
     * amelyet a szolgáltatás eredményül visszaad átmappelve.
     */
    @Override
    public KonditeremElerhetosegVo letrehozElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg) {
        KonditeremElerhetoseg ujElerhetoseg = KonditeremElerhetosegMapper.toDto(konditeremElerhetoseg);

        KonditeremElerhetoseg mentettElerhetoseg = konditeremElerhetosegTarolo.save(ujElerhetoseg);

        if (mentettElerhetoseg == null) {
            logolo.warn("Nem sikerult menteni a(z) " + mentettElerhetoseg.getKonditeremCime() + " címu elerhetoseg");
        } else {
            logolo.debug("Sikeresen elmentesre kerult a(z) " + mentettElerhetoseg.getKonditeremCime() + " címu elerhetoseg");
        }

        return KonditeremElerhetosegMapper.toVo(mentettElerhetoseg);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódussal elmentjük az adatbázisba az elérhetőséget, ami mivel már rendelkezik generált azonosítóval, így nem hoz
     * létre új példányt az adatbázisban, hanem a meglévő ID-val megegyező elérhetőséget fogja frissíteni.
     */
    @Override
    public KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg) {
        KonditeremElerhetoseg ujElerhetoseg = KonditeremElerhetosegMapper.toDto(konditeremElerhetoseg);

        KonditeremElerhetoseg mentettElerhetoseg = konditeremElerhetosegTarolo.save(ujElerhetoseg);

        if (mentettElerhetoseg == null) {
            logolo.warn("Nem sikerult frissiteni a(z) " + mentettElerhetoseg.getKonditeremCime() + " címu elerhetoseget!");
        } else {
            logolo.debug("Sikeresen frissult a(z) " + mentettElerhetoseg.getKonditeremCime() + " címu elerhetoseget!");
        }

        return KonditeremElerhetosegMapper.toVo(mentettElerhetoseg);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az összes adatbázisban található összes (a paraméterül kapott konditeremhez tartozó) bérletet.
     * Ezt a {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo#findByKonditerem(Konditerem)}  {@link KonditeremBerletTarolo}.findByKonditeremIn}
     * metódus segítségével hajtja végre. A konditeremet átmappelve adjuk a metódusnak, amely eredményül egy listát ad a konditeremhez
     * tartozó bérletekkel. A szolgáltatás ezt a listát átmappelve adja eredményül vissza.
     */
    @Override
    public List<KonditeremElerhetosegVo> konditremElerhetosegei(KonditeremVo konditerem) {

        List<KonditeremElerhetoseg> konditerem_elerhetosegei = konditeremElerhetosegTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditerem_elerhetosegei == null) {
            logolo.warn("Nem talalhato elerhetoseg a kovetkezo konditeremhez: " + konditerem.getFelhasznalonev());
        } else {
            logolo.debug(konditerem_elerhetosegei.size() + " db elérhetőség talhato a kovetkezo konditeremhez: " + konditerem.getFelhasznalonev());
        }

        return KonditeremElerhetosegMapper.toVo(konditerem_elerhetosegei);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus az adatbázisból egy paraméterül megadott azonosítójú elerhetoseget keres.
     * Ezt a műveletet a {@link org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable) }
     * metódus segítségével hajtja végre, amely egy Long típusú azonosítót vár paraméterül.
     * A szolgáltatás eredményül a megtalált elerhetőséget adja vissza átmappelve.
     */
    @Override
    public KonditeremElerhetosegVo keresElerhetoseget(long id) {
        KonditeremElerhetoseg talaltElerhetoseg = konditeremElerhetosegTarolo.findOne(id);

        if (talaltElerhetoseg == null) {
            logolo.warn("Nem talalhato a(z) " + talaltElerhetoseg + " id-val rendelkezo elérhetoseg!");
        } else {
            logolo.debug("A(z) " + talaltElerhetoseg + " id-vak rendelkezo elerhetoseg sikeresen lekerdezve!");
        }

        return KonditeremElerhetosegMapper.toVo(talaltElerhetoseg);
    }

}
