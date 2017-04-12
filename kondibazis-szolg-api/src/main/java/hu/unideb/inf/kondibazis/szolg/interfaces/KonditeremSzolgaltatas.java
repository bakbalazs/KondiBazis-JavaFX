package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremSzolgaltatas {
	
	KonditeremVo keresFelhasznalonevet(String felhazsnalonev);
	
	KonditeremVo konditeremetLetrehoz( KonditeremVo konditerem);
	
	
}
