package hu.unideb.inf.kondibazis.szolg.interfaces;

import java.util.List;

import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

public interface TelepulesekSzolgaltatas {
	
	TelepulesekVo keresIranyitoszamot(Integer iranyitoszam);
	
	TelepulesekVo keresTelepulesNevet(String telepulesnev);
	
	List<TelepulesekVo> osszesTelepules();

}
