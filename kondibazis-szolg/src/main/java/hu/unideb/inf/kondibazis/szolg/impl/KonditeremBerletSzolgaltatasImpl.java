package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremBerletMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * A konditermek bérletinek kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremBerletSzolgaltatasImpl implements KonditeremBerletSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremBerletSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo KonditeremBerletTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy bérlethez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private KonditeremBerletTarolo konditeremBerletTarolo;

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus az adatbázisból egy paraméterül megadott azonosítójú bérletet keres.
     * Ezt a műveletet a {@link org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable) }
     * metódus segítségével hajtja végre, amely egy Long típusú azonosítót vár paraméterül.
     * A szolgáltatás eredményül a megtalált bérletet adja vissza átmappelve.
     */
    @Override
    public KonditeremBerletVo keresBerletet(Long id) {
        KonditeremBerlet talaltBerlet = konditeremBerletTarolo.findOne(id);

        if (talaltBerlet == null) {
            logolo.warn("Nem talalhato a(z) " + talaltBerlet + " id-val rendelkezo konditerem!");
        } else {
            logolo.debug("A(z) " + talaltBerlet + " id-vak rendelkezo konditerem sikeresen lekerdezve!");
        }

        return KonditeremBerletMapper.toVo(talaltBerlet);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódusban a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódusának segítségével eltároljuk az adatbázisban a DTO-vá mappelt bérletet, ami ezáltal egy generált azonosítót is kap.
     * A metódus visszatérési értékként visszaadja az adatbázisban jelen lévő már ID-vel rendelkező bérletet,
     * amelyet a szolgáltatás eredményül visszaad átmappelve.
     */
    @Override
    public KonditeremBerletVo letrehozBerletet(KonditeremBerletVo berlet) {
        KonditeremBerlet ujBerlet = KonditeremBerletMapper.toDto(berlet);

        KonditeremBerlet mentettBerlet = konditeremBerletTarolo.save(ujBerlet);

        if (mentettBerlet == null) {
            logolo.warn("Nem sikerult menteni a(z) " + ujBerlet.getBerletNeve() + " nevu berletet!");
        } else {
            logolo.debug("Sikeresen elmentesre kerult a(z) " + ujBerlet.getBerletNeve() + " nevu berletet!");
        }

        return KonditeremBerletMapper.toVo(mentettBerlet);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódussal elmentjük az adatbázisba a bérletet, ami mivel már rendelkezik generált azonosítóval, így nem hoz
     * létre új példányt az adatbázisban, hanem a meglévő ID-val megegyező bérletet fogja frissíteni.
     */
    @Override
    public KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet) {

        KonditeremBerlet ujBerlet = KonditeremBerletMapper.toDto(konditeremBerlet);

        KonditeremBerlet mentettBerlet = konditeremBerletTarolo.save(ujBerlet);


        if (mentettBerlet == null) {
            logolo.warn("Nem sikerult frissiteni a(z) " + mentettBerlet.getBerletNeve() + " nevu berletet!");
        } else {
            logolo.debug("Sikeresen frissult a(z) " + mentettBerlet.getBerletNeve() + " nevu berlet!");
        }

        return KonditeremBerletMapper.toVo(mentettBerlet);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az összes adatbázisban található összes (a paraméterül kapott konditeremhez tartozó) bérletet.
     * Ezt a {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo#findByKonditerem(Konditerem)}  {@link KonditeremBerletTarolo}.findByKonditeremIn}
     * metódus segítségével hajtja végre. A konditeremet átmappelve adjuk a metódusnak, amely eredményül egy listát ad a konditeremhez
     * tartozó bérletekkel benne. A szolgáltatás ezt a listát átmappelve adja eredményül vissza.
     */
    @Override
    public List<KonditeremBerletVo> konditeremOsszesBerlete(KonditeremVo konditerem) {

        List<KonditeremBerlet> konditerem_berletei = konditeremBerletTarolo
                .findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditerem_berletei == null) {
            logolo.warn("Nem talalhato berlet a kovetkezo konditeremhez: " + konditerem.getFelhasznalonev());
        } else {
            logolo.debug(konditerem_berletei.size() + " db berlet talhato a kovetkezo konditeremhez: " + konditerem.getFelhasznalonev());
        }

        return KonditeremBerletMapper.toVo(konditerem_berletei);

    }

}
