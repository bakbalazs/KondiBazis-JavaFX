package hu.unideb.inf.kondibazis.db.tarolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;

@Repository
public interface KonditeremTarolo extends JpaRepository<Konditerem, Long> {
	
	Konditerem findByFelhasznalonev(String felhasznalonev) throws Exception;

}
