package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;

public interface KonditeremBerletSzolgaltatas {
	
	KonditeremBerletVo keresBerletet(String berletNeve);
	
	KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet);
	
	KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet);

}
