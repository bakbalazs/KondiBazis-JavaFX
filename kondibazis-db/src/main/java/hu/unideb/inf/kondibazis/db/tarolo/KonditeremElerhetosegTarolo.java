package hu.unideb.inf.kondibazis.db.tarolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;

@Repository
public interface KonditeremElerhetosegTarolo extends JpaRepository<KonditeremElerhetoseg, Long> {

	KonditeremElerhetoseg findById(Long konditeremId);
}
