package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;

public interface KonditeremElerhetosegSzolgaltatas {

	KonditeremElerhetosegVo keresElerhetoseget(Long id);

	public void letrehozElerhetoseget(KonditeremElerhetosegVo ujElerhetoseg) throws Exception;

	KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg);

}
