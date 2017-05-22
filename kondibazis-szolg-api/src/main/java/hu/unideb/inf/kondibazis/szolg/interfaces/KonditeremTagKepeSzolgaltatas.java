package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;

import java.util.List;

public interface KonditeremTagKepeSzolgaltatas {

    KonditeremTagKepeVo leterehozTagKepet(KonditeremTagKepeVo ujTag);

    List<KonditeremTagKepeVo> osszesKep();
}
