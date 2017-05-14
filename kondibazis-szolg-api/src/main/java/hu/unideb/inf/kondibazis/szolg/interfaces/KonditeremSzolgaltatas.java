package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.Map;

public interface KonditeremSzolgaltatas {
	
	KonditeremVo keresFelhasznalonevet(String felhasznalonev);
	
	KonditeremVo konditeremetLetrehoz( KonditeremVo konditerem);
	
	KonditeremVo frissitKonditermet(KonditeremVo konditerem);

	Map<String, Long> varosDiagramKonditeremTagokhoz(KonditeremVo konditerem);
	
}
