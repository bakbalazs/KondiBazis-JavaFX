package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonditeremTagKepeTarolo extends JpaRepository<KonditeremTagKepe, Long> {

//    List<KonditeremTagKepe> findByKonditeremTag(KonditeremTag konditeremTag);

}
