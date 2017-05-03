package hu.unideb.inf.kondibazis.szolg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremBerletMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremBerletSzolgaltatasImpl implements KonditeremBerletSzolgaltatas {
	
	@Autowired
	private KonditeremBerletTarolo konditeremBerletTarolo;
	
	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Override
	public KonditeremBerletVo keresBerletet(String berletNeve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet) {
		KonditeremBerlet uj = KonditeremBerletMapper.toDto(ujBerlet);
		
		KonditeremBerlet letezo = konditeremBerletTarolo.save(uj);
		
		if(letezo == null) {
			
		} else {
			
		}
		
		return KonditeremBerletMapper.toVo(letezo);
		
	}

	@Override
	public KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet) {
		KonditeremBerlet uj = KonditeremBerletMapper.toDto(konditeremBerlet);
		
		KonditeremBerlet mentett = konditeremBerletTarolo.save(uj);
		
		if(mentett == null) {
			
		} else {
			
		}
		
		return KonditeremBerletMapper.toVo(mentett);
		
	}

}
