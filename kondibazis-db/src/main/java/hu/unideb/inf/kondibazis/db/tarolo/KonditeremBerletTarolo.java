package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A konditerem bérlethez tartozó DAO aminek segítségével műveleteket hajthatunk végre a bérleteken.
 * Ez az osztály egy DAO amit a {@link org.springframework.stereotype.Repository Repository} annotációval jelzünk.
 * Ez az osztály a {@link org.springframework.data.jpa.repository.JpaRepository JpaRepository} leszármazottja,
 * ezáltal az alapvető CRUD műveletek előre definiáltak.
 */
@Repository
public interface KonditeremBerletTarolo extends JpaRepository<KonditeremBerlet, Long> {

    /**
     * Olyan bérleteket keres az adatbázsiban, amelyek egy bizonyos konditeremhez tartoznak.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param konditerem Az a konditerem aminek meg kell egyeznie a talált bérletekhez tartozó konditeremmel.
     * @return Egy lista azokról a bérletekről amelyek a metódus paramétereként megadott konditeremhez tartoznak.
     */
    List<KonditeremBerlet> findByKonditerem(Konditerem konditerem);

}
