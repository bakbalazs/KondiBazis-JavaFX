package hu.unideb.inf.kondibazis.db.tarolo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;

@Repository
public interface KonditeremBerletTarolo extends JpaRepository<KonditeremBerlet, Long> {

	List<KonditeremBerlet> findByKonditerem(Konditerem konditerem);

}
