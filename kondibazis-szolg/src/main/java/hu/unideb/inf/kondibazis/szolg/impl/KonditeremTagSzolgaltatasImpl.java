package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
		KonditeremTag found = konditeremTagTarolo.findById(id);
		if (found == null) {
		} else {
		}

		return KonditeremTagMapper.toVo(found);
	}

	@Override
	public List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem) {
		List<KonditeremTag> findByKonditerem = konditeremTagTarolo.findByKonditerem(KonditeremMapper.toDto(konditerem));
		if( findByKonditerem == null ){
//			logolo.warn("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak nincsenek tranzakcioi!");
		} else {
//			logolo.debug("A " + felhasznalo.getFelhasznalonev() + " felhasznalonevu felhasznalonak " + findByFelhasznalo.size() + " db tranzakcioja van.");
		}
		
		for(KonditeremTag konditeremTag : findByKonditerem) {
			
		}
		
		return KonditeremTagMapper.toVo(findByKonditerem);
	}

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
