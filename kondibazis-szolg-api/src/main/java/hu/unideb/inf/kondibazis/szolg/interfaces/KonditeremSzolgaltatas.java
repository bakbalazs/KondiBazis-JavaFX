package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremSzolgaltatas {
	
	KonditeremVo keresFelhasznalonevet(String felhasznalonev) throws Exception;
	
	KonditeremVo konditeremetLetrehoz( KonditeremVo konditerem);
	
	KonditeremVo frissitKonditermet(KonditeremVo konditerem);
	
}
