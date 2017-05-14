package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremElerhetosegSzolgaltatas {

	KonditeremElerhetosegVo keresElerhetoseget(KonditeremVo konditerem);

	public void letrehozElerhetoseget(KonditeremElerhetosegVo ujElerhetoseg) throws Exception;

	KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg);

}
