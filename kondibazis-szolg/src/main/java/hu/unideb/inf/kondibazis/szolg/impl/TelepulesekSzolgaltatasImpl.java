package hu.unideb.inf.kondibazis.szolg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import hu.unideb.inf.kondibazis.db.tarolo.TelepulesekTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.TelepulesekSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.TelepulesekMapper;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TelepulesekSzolgaltatasImpl implements TelepulesekSzolgaltatas {

	@Autowired
	private TelepulesekTarolo telepulesekTarolo;

	@Override
	public TelepulesekVo keresIranyitoszamot(Integer iranyitoszam) {
//		return TelepulesekMapper.toVo(telepulesekTarolo.findByiranyitoszam(iranyitoszam));
		
		Telepulesek found = telepulesekTarolo.findByiranyitoszam(iranyitoszam);
		if(found == null) {
			
		} else {
			
		}
		
		return TelepulesekMapper.toVo(found);
		
	}

}
