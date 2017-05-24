package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagKepeTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremTagKepeSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremTagKepeMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremTagKepeSzolgaltatasImpl implements KonditeremTagKepeSzolgaltatas {

    @Autowired
    private KonditeremTagKepeTarolo konditeremTagKepeTarolo;

    @Override
    public KonditeremTagKepeVo leterehozTagKepet(KonditeremTagKepeVo ujTag) {

        KonditeremTagKepe uj = KonditeremTagKepeMapper.toDto(ujTag);

        KonditeremTagKepe ment = konditeremTagKepeTarolo.save(uj);

        if (ment == null) {

        } else {

        }

        return KonditeremTagKepeMapper.toVo(ment);

    }

    @Override
    public List<KonditeremTagKepeVo> osszesKep() {
        List<KonditeremTagKepe> konditeremTagKepe = konditeremTagKepeTarolo.findAll();

        if (konditeremTagKepe == null) {

        } else {

        }

        for (KonditeremTagKepe konditeremTagKepe1 : konditeremTagKepe) {

        }

        return KonditeremTagKepeMapper.toVo(konditeremTagKepe);
    }

}
