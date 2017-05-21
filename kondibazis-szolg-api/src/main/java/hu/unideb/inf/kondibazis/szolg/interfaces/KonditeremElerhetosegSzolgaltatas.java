package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public interface KonditeremElerhetosegSzolgaltatas {

	KonditeremElerhetosegVo keresElerhetoseget(KonditeremVo konditerem);

	KonditeremElerhetosegVo letrehozElerhetoseget(KonditeremElerhetosegVo ujElerhetoseg);

	KonditeremElerhetosegVo frissitElerhetoseget(KonditeremElerhetosegVo konditeremElerhetoseg);

}
