package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;

public interface KonditeremElerhetosegSzolgaltatas {
	
	KonditeremElerhetosegVo keresElerhetoseget(Long id);
	
	KonditeremElerhetosegVo letrehozElerhetoseget(KonditeremElerhetosegVo ujElerhetoseg);

	KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg);
	
}
