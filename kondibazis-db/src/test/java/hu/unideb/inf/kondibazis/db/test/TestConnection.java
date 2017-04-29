package hu.unideb.inf.kondibazis.db.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-db.xml")
@Transactional
@Rollback(false)
public class TestConnection {

	@Autowired
	KonditeremTarolo ktarolo;

//	@Test
//	public void testInsert() {
//		Konditerem random = new Konditerem();
//
//		random.setId(1L);
//		random.setJelszo("sadfdfds");
//		
//
//		ktarolo.save(random);
//	}
	
	@Test
	public void beszurasAKonditerembe() throws Exception {
		
//		Konditerem admin = ktarolo.findByFelhasznalonev("admin");
//		assertEquals(admin.getFelhasznalonev(), "admin" );
		
	}

}
