package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A konditermek kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremSzolgaltatasImpl implements KonditeremSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo KonditeremTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy konditeremhez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private KonditeremTarolo konditeremTarolo;

    /**
     * {@inheritDoc}
     * <p>
     * A metódusban a {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo#findByFelhasznalonev(String) KonditeremTarolo.findByFelhasznalonev}
     * segítségével lekérdezzük az adatbázisból a konditermet a felhasználóneve alapján.
     * Sikeres lekérdezés esetén a szolgáltatás visszaadja az átmappelt konditermet eredményül.
     */
    @Override
    public KonditeremVo keresKonditermet(String felhasznalonev) {

        Konditerem talaltKonditerem = konditeremTarolo.findByFelhasznalonev(felhasznalonev);

        if (talaltKonditerem == null) {
            logolo.warn("Nem talalhato a(z) " + felhasznalonev + " felhasznalonevu konditerem!");
        } else {
            logolo.debug("A(z) " + felhasznalonev + " nevu konditerem sikeresen lekerdezve!");
        }

        return KonditeremMapper.toVo(talaltKonditerem);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus az adatbázisból egy paraméterül megadott azonosítójú konditremet keres.
     * Ezt a műveletet a {@link org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable) }
     * metódus segítségével hajtja végre, amely egy Long típusú azonosítót vár paraméterül.
     * A szolgáltatás eredményül a megtalált konditermet adja vissza átmappelve.
     */
    @Override
    public KonditeremVo keresKonditeremetId(Long id) {
        Konditerem talaltKonditerem = konditeremTarolo.findOne(id);

        if (talaltKonditerem == null) {
            logolo.warn("Nem talalhato a(z) " + talaltKonditerem + " id-val rendelkezo konditerem!");
        } else {
            logolo.debug("A(z) " + talaltKonditerem + " id-vak rendelkezo konditerem sikeresen lekerdezve!");
        }

        return KonditeremMapper.toVo(talaltKonditerem);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódusban a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódusának segítségével eltároljuk az adatbázisban a DTO-vá mappelt konditermet, ami ezáltal egy generált azonosítót is kap.
     * A metódus visszatérési értékként visszaadja az adatbázisban jelen lévő már ID-vel rendelkező konditermet,
     * amelyet a szolgáltatás eredményül visszaad átmappelve.
     */
    @Override
    public KonditeremVo konditeremetLetrehoz(KonditeremVo konditerem) {

        Konditerem ujKonditerem = KonditeremMapper.toDto(konditerem);

        Konditerem mentettKonditerem = konditeremTarolo.save(ujKonditerem);

        if (mentettKonditerem == null) {
            logolo.warn("Nem sikerult menteni a(z) " + ujKonditerem.getFelhasznalonev() + " felhasznalonevu konditermet!");
        } else {
            logolo.debug("Sikeresen elmentesre kerult a(z) " + ujKonditerem.getFelhasznalonev() + " felhasznalonevu konditermet!");
        }

        return KonditeremMapper.toVo(mentettKonditerem);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódussal elmentjük az adatbázisba a konditermet, ami mivel már rendelkezik generált azonosítóval, így nem hoz
     * létre új példányt az adatbázisban, hanem a meglévő ID-val megegyező konditermet fogja frissíteni.
     */
    @Override
    public KonditeremVo frissitKonditermet(KonditeremVo konditerem) {

        Konditerem uj = KonditeremMapper.toDto(konditerem);

        Konditerem mentett = konditeremTarolo.save(uj);
        if (mentett == null) {
            logolo.warn("Nem sikerult frissiteni a(z) " + konditerem.getFelhasznalonev() + " felhasznalonevu konditermet!");
        } else {
            logolo.debug("Sikeresen frissult a(z) " + konditerem.getFelhasznalonev() + " felhasznalonevu konditerem!");
        }

        return KonditeremMapper.toVo(mentett);

    }

    //TODO
    @Override
    public Map<String, Long> varosDiagramKonditeremTagokhoz(KonditeremVo konditerem) {
        List<KonditeremTagVo> konditeremTagLisa = konditerem.getKonditeremTagok();

        Map<String, Long> varosDiagramAdatok = konditeremTagLisa.stream().collect(Collectors.groupingBy(KonditeremTagVo::getTagVarosa, Collectors.counting()));

        logolo.debug("Konditerem tagjai városonként: " + varosDiagramAdatok);

        return varosDiagramAdatok;
    }

    //TODO
    @Override
    public Map<String, Long> megyeDiagramKonditeremTagokhoz(KonditeremVo konditerem) {
        List<KonditeremTagVo> konditeremTagLisa = konditerem.getKonditeremTagok();

        Map<String, Long> megyeDiagramAdatok = konditeremTagLisa.stream().collect(Collectors.groupingBy(KonditeremTagVo::getTagMegyeje, Collectors.counting()));

        return megyeDiagramAdatok;
    }

    //TODO
    @Override
    public Map<String, Long> nemekDiagramKonditeremTagokhoz(KonditeremVo konditerem) {
        List<KonditeremTagVo> konditeremTagLisa = konditerem.getKonditeremTagok();

        Map<String, Long> nemekDiagramAdatok = konditeremTagLisa.stream().collect(Collectors.groupingBy(KonditeremTagVo::getTagNeme, Collectors.counting()));

        return nemekDiagramAdatok;
    }

    //TODO
    @Override
    public Map<String, Long> berlettipusDiagramKonditeremTagokhoz(KonditeremVo konditerem) {
        List<KonditeremTagVo> konditeremTagLisa = konditerem.getKonditeremTagok();

        Map<String, Long> berletTipusDiagramAdatok = konditeremTagLisa.stream().collect(Collectors.groupingBy(KonditeremTagVo::getVasaroltBerletTipusa, Collectors.counting()));

        return berletTipusDiagramAdatok;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az adatbázisban az összes konditermet, majd visszaadja egy listában.
     * A műveletet a {@link KonditeremBerletTarolo#findAll()}  KonditeremBerletTarolo.findAll()}
     * metódus segítségével hajtja végre. Ennek eredményeképp kapunk egy listát amely tartalmazza az összes adatbázisban szereplő
     * bérletet. A szolgáltatás ezen lista elemeit átmappelve egy listában adja vissza eredményül.
     */
    @Override
    public List<KonditeremVo> osszesKonditerem() {
        List<Konditerem> osszesKonditerem = konditeremTarolo.findAll();

        if (osszesKonditerem == null) {
            logolo.warn("Nincs regisztralt terem!");
        } else {
            logolo.debug(osszesKonditerem.size() + " regisztralt konditerem talalhato.");
        }

        return KonditeremMapper.toVo(osszesKonditerem);
    }

}
