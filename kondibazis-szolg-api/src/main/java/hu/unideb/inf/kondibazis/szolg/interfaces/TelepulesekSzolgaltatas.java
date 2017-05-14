package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

import java.util.List;

public interface TelepulesekSzolgaltatas {
	
	TelepulesekVo keresIranyitoszamot(Integer iranyitoszam);
	
	TelepulesekVo keresTelepulesNevet(String telepulesnev);
	
	List<TelepulesekVo> osszesTelepules();

}
