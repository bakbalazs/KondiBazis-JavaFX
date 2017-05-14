package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonditeremBerletTarolo extends JpaRepository<KonditeremBerlet, Long> {

	List<KonditeremBerlet> findByKonditerem(Konditerem konditerem);

}
