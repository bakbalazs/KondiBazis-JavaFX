package hu.unideb.inf.kondibazis.szolg.interfaces;

import java.util.List;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremBerletSzolgaltatas {
	
	KonditeremBerletVo keresBerletet(String berletNeve);
	
	KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet);
	
	KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet);
	
	List<KonditeremBerletVo> konditeremOsszesBerlete(KonditeremVo konditerem);

}
