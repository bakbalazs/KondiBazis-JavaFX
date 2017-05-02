package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;

public interface KonditeremTagSzolgaltatas {
	
	KonditeremTagVo leterehozTagot (KonditeremTagVo ujTag);
	
	KonditeremTagVo keresTagot(Long id);

	KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag);
	
}
