package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremBerletMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremTagSzolgaltatasImpl implements KonditeremTagSzolgaltatas {

    /**
     * A logoláshoz szükséges {@link org.slf4j.Logger Logger}.
     */
    private static Logger logolo = LoggerFactory.getLogger(KonditeremTagSzolgaltatasImpl.class);

    @Autowired
    private KonditeremTagTarolo konditeremTagTarolo;

    @Autowired
    private KonditeremSzolgaltatas konditeremSzolgaltatas;

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


    @Override
    public List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem) {
        List<KonditeremTag> findByKonditerem = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));
        if (findByKonditerem == null) {
//			logolo.warn("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak nincsenek tranzakcioi!");
        } else {
//			logolo.debug("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak " + findByFelhasznalo.size() + " db tranzakcioja van.");
        }

        return KonditeremTagMapper.toVo(findByKonditerem);
    }

    @Override
    public KonditeremBerletVo tagBerlete(KonditeremTagVo konditeremTag) {

        KonditeremBerlet b = konditeremTagTarolo.findByKonditeremBerlet(KonditeremTagMapper.toDto(konditeremTag));

        if (b == null) {
//			logolo.warn("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak nincsenek tranzakcioi!");
        } else {
//			logolo.debug("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak " + findByFelhasznalo.size() + " db tranzakcioja van.");
        }


        return KonditeremBerletMapper.toVo(b);
    }

    @Override
    public List<KonditeremTagVo> lejartBerletuTagok(KonditeremVo konditerem) {
        return null;
    }

    @Override
    public List<KonditeremTagVo> alkalmasBerletuTagok(KonditeremVo konditerem) {
        return null;
    }

    @Override
    public List<KonditeremTagVo> idokorlatosBerletuTagok(KonditeremVo konditerem) {
        return null;
    }
}
