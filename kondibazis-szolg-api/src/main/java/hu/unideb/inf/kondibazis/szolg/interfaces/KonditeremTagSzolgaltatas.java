package hu.unideb.inf.kondibazis.szolg.interfaces;

import java.util.List;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremTagSzolgaltatas {
	
	KonditeremTagVo keresTagot(Long id);
	
	KonditeremTagVo leterehozTagot (KonditeremTagVo ujTag);

	KonditeremTagVo frissitKonditeremTagot(KonditeremTagVo konditeremTag);

	List<KonditeremTagVo> konditeremOsszesTagja(KonditeremVo konditerem);
	
}
