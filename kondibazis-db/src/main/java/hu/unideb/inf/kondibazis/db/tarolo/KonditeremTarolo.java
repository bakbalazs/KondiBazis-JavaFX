package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A konditermekhez tartozó DAO aminek segítségével műveleteket hajthatunk végre a konditermeken.
 * Ez az osztály egy DAO amit a {@link org.springframework.stereotype.Repository Repository} annotációval jelzünk.
 * Ez az osztály a {@link org.springframework.data.jpa.repository.JpaRepository JpaRepository} leszármazottja,
 * ezáltal az alapvető CRUD műveletek előre definiáltak.
 */
@Repository
public interface KonditeremTarolo extends JpaRepository<Konditerem, Long> {

    /**
     * Egy konditeremet keres az adatbázsiban a felhasználóneve alapján.
     * A metódushoz tartozó lekérdezést a spring készíti el a metódus neve alapján, ezért a
     * findBy használata szükséges a metódus nevében, valamint ezt követően az a mező, ami a {@code where}
     * feltételben szerepelni fog.
     *
     * @param felhasznalonev Az a felhasználónév aminek meg kell egyeznie a talált konditerem felhasználónevével.
     *                       Ezt a felhasználónevet helyettesíti be a {@code where felhasznalonev = ?} kifejezésben a ? helyére.
     * @return Pontosan egy {@link hu.unideb.inf.kondibazis.db.entitas.Konditerem Konditerem} amelynek
     * megegyezik a felhasználóneve a metódus paraméteréül adott Stringben szereplővel.
     */
    Konditerem findByFelhasznalonev(String felhasznalonev);

}
