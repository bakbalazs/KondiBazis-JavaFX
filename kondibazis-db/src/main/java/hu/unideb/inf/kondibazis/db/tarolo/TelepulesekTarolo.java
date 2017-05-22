package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A településekhez tartozó DAO aminek segítségével műveleteket hajthatunk végre a településeken.
 * Ez az osztály egy DAO amit a {@link org.springframework.stereotype.Repository Repository} annotációval jelzünk.
 * Ez az osztály a {@link org.springframework.data.jpa.repository.JpaRepository JpaRepository} leszármazottja,
 * ezáltal az alapvető CRUD műveletek előre definiáltak.
 */
@Repository
public interface TelepulesekTarolo extends JpaRepository<Telepulesek, Long> {

    /**
     * Egy települést keres az adatbázsiban az irányítószáma alapján.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param iranyitoszam Az az irányítószám aminek meg kell egyeznie a talált település irányítószámával.
     *                     Ezt az irányítószámot helyettesíti be a {@code where iranyitoszam = ?} kifejezésben a ? helyére.
     * @return Pontosan egy {@link hu.unideb.inf.kondibazis.db.entitas.Telepulesek Telepulesek} amelynek
     * megegyezik az irányítószáma a metódus paraméteréül adott Integerbe szereplővel.
     */
    Telepulesek findByiranyitoszam(Integer iranyitoszam);

    /**
     * Egy települést keres az adatbázsiban a neve alapján.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param telepulesnev Az a település név aminek meg kell egyeznie a talált település nevével.
     *                       Ezt a nevet helyettesíti be a {@code where telepulesnev = ?} kifejezésben a ? helyére.
     * @return Pontosan egy {@link hu.unideb.inf.kondibazis.db.entitas.Telepulesek Telepulesek} amelynek
     * megegyezik a neve a metódus paraméteréül adott Stringben szereplővel.
     */
    Telepulesek findBytelepulesnev(String telepulesnev);

}
