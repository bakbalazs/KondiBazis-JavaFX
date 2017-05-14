package hu.unideb.inf.kondibazis.db.tarolo;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelepulesekTarolo extends JpaRepository<Telepulesek, Long> {

	Telepulesek findByiranyitoszam(Integer iranyitoszam);
	
	Telepulesek findBytelepulesnev(String telepulesnev);
	
	Telepulesek findBymegye(String megyeNeve);
	
}
