package hu.unideb.inf.kondibazis.szolg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremSzolgaltatasImpl implements KonditeremSzolgaltatas {

	@Autowired
	KonditeremTarolo konditeremTarolo;

	public KonditeremVo findByFelhasznalonev(String felhasznalonev) {
		Konditerem k = null;
		try {
			k = konditeremTarolo.findByFelhasznalonev(felhasznalonev);
		} catch (Exception e) {
			// logolás
			e.printStackTrace();
		}

		return KonditeremMapper.toVo(k);
	}

}
