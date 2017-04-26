package hu.unideb.inf.kondibazis.szolg.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-szolg.xml")
@Transactional
@Rollback(true)
public class SzolgaltatasTeszt {

	@Autowired
	KonditeremTarolo konditeremTarolo;

	@Test
	public void tesztBeszurasAKonditerembe() throws Exception{
		
		System.out.println("asd");

//		Konditerem admin = konditeremTarolo.findByFelhasznalonev("admin");
//		
//		assertEquals( admin.getFelhasznalonev(), "admin");

	}

}