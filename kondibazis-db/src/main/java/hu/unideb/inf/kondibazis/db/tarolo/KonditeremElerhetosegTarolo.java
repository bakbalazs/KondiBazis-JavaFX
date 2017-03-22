package hu.unideb.inf.kondibazis.db.tarolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface KonditeremElerhetosegTarolo extends JpaRepository<KonditeremElerhetoseg, Long> {

}