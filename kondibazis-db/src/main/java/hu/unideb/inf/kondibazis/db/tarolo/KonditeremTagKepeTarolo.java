package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonditeremTagKepeTarolo extends JpaRepository<KonditeremTagKepe, Long> {

//    List<KonditeremTagKepe> findByKonditeremTag(KonditeremTag konditeremTag);

}
