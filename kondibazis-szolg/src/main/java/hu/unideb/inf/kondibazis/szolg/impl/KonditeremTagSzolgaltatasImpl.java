package hu.unideb.inf.kondibazis.szolg.impl;


import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A konditermek tagjainak kezelését támogató osztály.
 * Ez az osztály a {@link org.springframework.stereotype.Service Service} annotációval van ellátva,
 * azaz ez egy {@link org.springframework.stereotype.Component Component} csak specifikáltabb.
 * A {@link org.springframework.transaction.annotation.Transactional Transactional} annotáció révén
 * az itt végzett tranzakciók bekapcsolódnak a meglévő tranzakcióba, vagy létrehoznak egyet ha
 * nincs még.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremTagSzolgaltatasImpl implements KonditeremTagSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremTagSzolgaltatasImpl.class);

    /**
     * A kondibazis-db modulból származó {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo KonditeremTagTarolo}.
     * Ezt az adattagot az {@link org.springframework.beans.factory.annotation.Autowired} annotáció
     * segítségével a spring DI injektálja be. Ezen az adattagon keresztül érhetőek el egy konditerem elérhetőségeihez
     * szükséges adatbázis műveletek.
     */
    @Autowired
    private KonditeremTagTarolo konditeremTagTarolo;

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus az adatbázisból egy paraméterül megadott azonosítójú tagot keres.
     * Ezt a műveletet a {@link org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable) }
     * metódus segítségével hajtja végre, amely egy Long típusú azonosítót vár paraméterül.
     * A szolgáltatás eredményül a megtalált tagot adja vissza átmappelve.
     */
    @Override
    public KonditeremTagVo keresTagot(Long id) {
        KonditeremTag talaltTag = konditeremTagTarolo.findOne(id);

        if (talaltTag == null) {
            logolo.warn("Nem talalhato a(z) " + talaltTag + " id-val rendelkezo tag!");
        } else {
            logolo.debug("A(z) " + talaltTag + " id-vak rendelkezo tag sikeresen lekerdezve!");
        }

        return KonditeremTagMapper.toVo(talaltTag);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódusban a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódusának segítségével eltároljuk az adatbázisban a DTO-vá mappelt tagot, ami ezáltal egy generált azonosítót is kap.
     * A metódus visszatérési értékként visszaadja az adatbázisban jelen lévő már ID-vel rendelkező tagot,
     * amelyet a szolgáltatás eredményül visszaad átmappelve.
     */
    @Override
    public KonditeremTagVo leterehozTagot(KonditeremTagVo tag) {
        KonditeremTag ujTag = KonditeremTagMapper.toDto(tag);

        KonditeremTag mentettTag = konditeremTagTarolo.save(ujTag);

        if (mentettTag == null) {
            logolo.warn("Nem sikerult menteni a(z) " + mentettTag.getTagNeve() + " nevu tagot!");
        } else {
            logolo.debug("Sikeresen elmentesre kerult a(z) " + mentettTag.getTagNeve() + " nevu tag!");
        }

        return KonditeremTagMapper.toVo(mentettTag);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus a {@link org.springframework.data.repository.CrudRepository#save(Object) }
     * metódussal elmentjük az adatbázisba a tagot, ami mivel már rendelkezik generált azonosítóval, így nem hoz
     * létre új példányt az adatbázisban, hanem a meglévő ID-val megegyező tagot fogja frissíteni.
     */
    @Override
    public KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag) {

        KonditeremTag ujTag = KonditeremTagMapper.toDto(konditeremTag);

        KonditeremTag mentettTag = konditeremTagTarolo.save(ujTag);

        if (mentettTag == null) {
            logolo.warn("Nem sikerult frissiteni a(z) " + mentettTag.getTagNeve() + " nevu tagot!");
        } else {
            logolo.debug("Sikeresen frissult a(z) " + mentettTag.getTagNeve() + " nevu tagot!");
        }

        return KonditeremTagMapper.toVo(mentettTag);

    }

    /**
     * {@inheritDoc}
     * <p>
     * Ebben az implementációban
     * a metódus megkeresi az összes adatbázisban található összes (a paraméterül kapott konditeremhez tartozó) tagot.
     * Ezt a {@link hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo#findByKonditerem(Konditerem)}  {@link KonditeremTagTarolo}.findByKonditeremIn}
     * metódus segítségével hajtja végre. A konditeremet átmappelve adjuk a metódusnak, amely eredményül egy listát ad a konditeremhez
     * tartozó tagokat. A szolgáltatás ezt a listát átmappelve adja eredményül vissza.
     */
    @Override
    public List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem) {

        List<KonditeremTag> konditeremTagjai = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagjai == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + konditeremTagjai.size() + " db tagja van.");
        }

        return KonditeremTagMapper.toVo(konditeremTagjai);
    }

    @Override
    public List<KonditeremTagVo> noiTagok(KonditeremVo konditerem) {

        List<KonditeremTag> noiTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag t : konditeremTagok) {
                if (t.getTagNeme().equals("Nő")) {
                    noiTagok.add(t);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + noiTagok.size() + " db női tagja van.");
        }

        return KonditeremTagMapper.toVo(noiTagok);
    }

    @Override
    public List<KonditeremTagVo> ferfiTagok(KonditeremVo konditerem) {
        List<KonditeremTag> ferfiTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag tag : konditeremTagok) {
                if (tag.getTagNeme().equals("Férfi")) {
                    ferfiTagok.add(tag);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + ferfiTagok.size() + " db férfi tagja van.");
        }

        return KonditeremTagMapper.toVo(ferfiTagok);
    }

    @Override
    public List<KonditeremTagVo> alkalmasBerletuTagok(KonditeremVo konditerem) {
        List<KonditeremTag> alkalmasBerletuTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag tag : konditeremTagok) {
                if (tag.getVasaroltBerletTipusa().contains("Alkalmas")) {
                    alkalmasBerletuTagok.add(tag);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + alkalmasBerletuTagok.size() + " db alkalmas bérletű tagja van.");
        }
        return KonditeremTagMapper.toVo(alkalmasBerletuTagok);
    }

    @Override
    public List<KonditeremTagVo> idokorlatosBerletuTagok(KonditeremVo konditerem) {
        List<KonditeremTag> idokorlatosBerletuTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag tag : konditeremTagok) {
                if (tag.getVasaroltBerletTipusa().contains("Időkorlátos")) {
                    idokorlatosBerletuTagok.add(tag);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + idokorlatosBerletuTagok.size() + " db időkorlátos bérletű tagja van.");
        }
        return KonditeremTagMapper.toVo(idokorlatosBerletuTagok);
    }

    @Override
    public List<KonditeremTagVo> lejartAlkalmasBerletuTagok(KonditeremVo konditerem) {
        LocalDate maiNap = LocalDate.now();
        List<KonditeremTag> lejartAlkalmasBerletuTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag tag : konditeremTagok) {

                if (tag.getVasaroltBerletTipusa().contains("Alkalmas") && ((tag.getMennyiAlkalomMeg() == 0) || tag.getBerletLejaratiIdeje().compareTo(maiNap) == -1 || tag.getBerletLejaratiIdeje().compareTo(maiNap) < -1)) {
                    lejartAlkalmasBerletuTagok.add(tag);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + lejartAlkalmasBerletuTagok.size() + " db alkalmas bérletű tagja van.");
        }
        return KonditeremTagMapper.toVo(lejartAlkalmasBerletuTagok);
    }

    @Override
    public List<KonditeremTagVo> lejartIdokorlatosBerletuTagok(KonditeremVo konditerem) {
        LocalDate maiNap = LocalDate.now();
        List<KonditeremTag> lejartIdokorlatosBerletuTagok = new ArrayList<>();

        List<KonditeremTag> konditeremTagok = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));

        if (konditeremTagok == null) {
            logolo.warn("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek nincsenek tagjai!");
        } else {
            for (KonditeremTag tag : konditeremTagok) {

                if (tag.getVasaroltBerletTipusa().contains("Időkorlátos") && (tag.getBerletLejaratiIdeje().compareTo(maiNap) == -1 || tag.getBerletLejaratiIdeje().compareTo(maiNap) < -1)) {
                    lejartIdokorlatosBerletuTagok.add(tag);
                }
            }
            logolo.debug("A " + konditerem.getFelhasznalonev() + " felhasznalonevu konditeremnek " + lejartIdokorlatosBerletuTagok.size() + " db idokorlatos bérletű tagja van.");
        }
        return KonditeremTagMapper.toVo(lejartIdokorlatosBerletuTagok);
    }

    @Override
    public List<KonditeremTagVo> lejartBerletuTagok(KonditeremVo konditerem) {

//        List<KonditeremTag> ad = new ArrayList<>();
//        ad.addAll(KonditeremTagMapper.toDto(lejartIdokorlatosBerletuTagok(konditerem)));
//        ad.addAll(KonditeremTagMapper.toDto(lejartAlkalmasBerletuTagok(konditerem)));

        return null;
    }


}
