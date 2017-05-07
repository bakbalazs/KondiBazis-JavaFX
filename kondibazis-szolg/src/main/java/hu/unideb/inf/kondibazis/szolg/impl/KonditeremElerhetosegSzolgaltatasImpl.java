package hu.unideb.inf.kondibazis.szolg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremElerhetosegTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremElerhetosegSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremElerhetosegMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremElerhetosegSzolgaltatasImpl implements KonditeremElerhetosegSzolgaltatas {

	@Autowired
	private KonditeremElerhetosegTarolo konditeremElerhetosegTarolo;

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Override
	public KonditeremElerhetosegVo keresElerhetoseget(Long id) {
		return KonditeremElerhetosegMapper.toVo(konditeremElerhetosegTarolo.findById(id));
	}

	@Override
	public void letrehozElerhetoseget(KonditeremElerhetosegVo ujElerhetoseg) throws Exception {
		try {
			konditeremElerhetosegTarolo.save(KonditeremElerhetosegMapper.toDto(ujElerhetoseg));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg) {
		KonditeremElerhetoseg uj = KonditeremElerhetosegMapper.toDto(konditeremElerhetoseg);

		KonditeremElerhetoseg mentett = konditeremElerhetosegTarolo.save(uj);

		if (mentett == null) {

		} else {

		}

		return KonditeremElerhetosegMapper.toVo(mentett);

	}

}
