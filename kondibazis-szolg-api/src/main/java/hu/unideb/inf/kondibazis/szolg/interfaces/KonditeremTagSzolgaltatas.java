package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;

public interface KonditeremTagSzolgaltatas {
	
	KonditeremTagVo keresTagot(Long id);
	
	KonditeremTagVo leterehozTagot (KonditeremTagVo ujTag);

	KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag);
	
}
