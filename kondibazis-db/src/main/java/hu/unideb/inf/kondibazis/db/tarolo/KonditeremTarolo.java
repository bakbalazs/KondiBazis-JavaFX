package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonditeremTarolo extends JpaRepository<Konditerem, Long> {
	
	Konditerem findByFelhasznalonev(String felhasznalonev);

}
