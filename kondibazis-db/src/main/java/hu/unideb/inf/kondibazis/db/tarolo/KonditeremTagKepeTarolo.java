package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A konditerem tagjainak képeihez tartozó DAO aminek segítségével műveleteket hajthatunk végre a tagok képein.
 * Ez az osztály egy DAO amit a {@link org.springframework.stereotype.Repository Repository} annotációval jelzünk.
 * Ez az osztály a {@link org.springframework.data.jpa.repository.JpaRepository JpaRepository} leszármazottja,
 * ezáltal az alapvető CRUD műveletek előre definiáltak.
 */
@Repository
public interface KonditeremTagKepeTarolo extends JpaRepository<KonditeremTagKepe, Long> {

}
