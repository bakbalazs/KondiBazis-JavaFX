package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A konditerem tagjaihoz tartozó DAO aminek segítségével műveleteket hajthatunk végre a tagokon.
 * Ez az osztály egy DAO amit a {@link org.springframework.stereotype.Repository Repository} annotációval jelzünk.
 * Ez az osztály a {@link org.springframework.data.jpa.repository.JpaRepository JpaRepository} leszármazottja,
 * ezáltal az alapvető CRUD műveletek előre definiáltak.
 */
@Repository
public interface KonditeremTagTarolo extends JpaRepository<KonditeremTag, Long> {

    /**
     * Olyan tagokat keres az adatbázsiban, amelyek egy bizonyos konditeremhez tartoznak.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param konditerem Az a konditerem aminek meg kell egyeznie a talált taghoz tartozó konditeremmel.
     * @return Egy lista azokról a tagokról amelyek a metódus paramétereként megadott konditeremhez tartoznak.
     */
    List<KonditeremTag> findByKonditerem(Konditerem konditerem);

    /**
     * Olyan bérletet keres az adatbázsiban, amelyek egy bizonyos konditerem taghoz tartoznak.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param konditeremTag Az a konditerem tag aminek meg kell egyeznie a talált taghoz tartozó bérlettel.
     * @return Egy bérletet ad vissza amely a metódus paraméterként megadott konditerem taghoz tartozik.
     */
    KonditeremBerlet findByKonditeremBerlet(KonditeremTag konditeremTag);

}
