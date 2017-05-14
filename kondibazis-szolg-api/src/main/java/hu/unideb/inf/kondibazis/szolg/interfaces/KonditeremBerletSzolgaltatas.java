package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

import java.util.List;

public interface KonditeremBerletSzolgaltatas {
//	
//	KonditeremBerletVo keresBerletet(String berletNeve);

	/**
	 *
	 * @param ujBerlet
	 * @return
	 */
	KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet);

	/**
	 *
	 * @param konditeremBerlet
	 * @return
	 */
	KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet);

	/**
	 *
	 * @param konditeremBerlet
	 */
	void torolKonditeremBerletet(KonditeremBerletVo konditeremBerlet);

	/**
	 *
	 * @param konditerem
	 * @return
	 */
	List<KonditeremBerletVo> konditeremOsszesBerlete(KonditeremVo konditerem);

	/**
	 *
	 * @param id
	 * @return
	 */
	KonditeremBerletVo keresBerletet(Long id);

}
