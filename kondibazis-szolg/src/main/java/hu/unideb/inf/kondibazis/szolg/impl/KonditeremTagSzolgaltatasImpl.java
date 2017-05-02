package hu.unideb.inf.kondibazis.szolg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremTagSzolgaltatasImpl implements KonditeremTagSzolgaltatas {

	@Autowired
	private KonditeremTagTarolo konditeremTagTarolo;

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Override
	public KonditeremTagVo leterehozTagot(KonditeremTagVo ujTag) {
		KonditeremTag uj = KonditeremTagMapper.toDto(ujTag);

		KonditeremTag letezo = konditeremTagTarolo.save(uj);

		if (letezo == null) {

		} else {

		}

		return KonditeremTagMapper.toVo(letezo);

	}

	@Override
	public KonditeremTagVo keresTagot(Long id) {
		KonditeremTag found = konditeremTagTarolo.findOne(id);
		if (found == null) {
		} else {
		}

		return KonditeremTagMapper.toVo(found);
	}

//	@Override
//	public List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag) {

		KonditeremTag uj = KonditeremTagMapper.toDto(konditeremTag);

		KonditeremTag mentett = konditeremTagTarolo.save(uj);

		if (mentett == null) {

		} else {

		}

		return KonditeremTagMapper.toVo(mentett);

	}

}
