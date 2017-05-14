package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonditeremElerhetosegTarolo extends JpaRepository<KonditeremElerhetoseg, Long> {

	KonditeremElerhetoseg findByKonditerem(Konditerem konditerem);

}
