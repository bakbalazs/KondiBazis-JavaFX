package hu.unideb.inf.kondibazis.szolg.interfaces;

import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

import java.util.List;

public interface KonditeremTagKepeSzolgaltatas {

//    List<KonditeremTagKepeVo> konditeremOsszesTagja(KonditeremTagVo konditeremTagId);

//    List<KonditeremTagKepeVo> konditeremTagOsszesKepe(KonditeremTagKepeVo konditeremTagKepeVo);

    public void leterehozTagKepet(KonditeremTagKepeVo ujTag);

    List<KonditeremTagKepeVo> osszesKep();
}
