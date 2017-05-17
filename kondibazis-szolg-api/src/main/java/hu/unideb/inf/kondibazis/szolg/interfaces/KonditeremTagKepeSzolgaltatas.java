package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;

import java.util.List;

public interface KonditeremTagKepeSzolgaltatas {

//    List<KonditeremTagKepeVo> konditeremOsszesTagja(KonditeremTagVo konditeremTagId);

//    List<KonditeremTagKepeVo> konditeremTagOsszesKepe(KonditeremTagKepeVo konditeremTagKepeVo);

    KonditeremTagKepeVo leterehozTagKepet(KonditeremTagKepeVo ujTag);

    List<KonditeremTagKepeVo> osszesKep();
}
