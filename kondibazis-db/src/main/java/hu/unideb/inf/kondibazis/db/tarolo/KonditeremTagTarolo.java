package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonditeremTagTarolo extends JpaRepository<KonditeremTag, Long> {
	
	List<KonditeremTag> findByKonditerem(Konditerem konditerem);

}
