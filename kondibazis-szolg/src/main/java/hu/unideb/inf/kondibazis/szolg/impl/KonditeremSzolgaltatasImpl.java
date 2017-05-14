package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremSzolgaltatasImpl implements KonditeremSzolgaltatas {

    @Autowired
    private KonditeremTarolo konditeremTarolo;

    @Override
    public KonditeremVo keresFelhasznalonevet(String felhasznalonev) {

        Konditerem k = konditeremTarolo.findByFelhasznalonev(felhasznalonev);

        if (k == null) {

        } else {

        }

        return KonditeremMapper.toVo(k);

    }

    @Override
    public KonditeremVo konditeremetLetrehoz(KonditeremVo konditerem) {

        Konditerem ujK = KonditeremMapper.toDto(konditerem);

        Konditerem mentK = konditeremTarolo.save(ujK);

        if (mentK == null) {

        } else {

        }

        return KonditeremMapper.toVo(mentK);

    }

    @Override
    public KonditeremVo frissitKonditermet(KonditeremVo konditerem) {

        Konditerem uj = KonditeremMapper.toDto(konditerem);

        Konditerem mentett = konditeremTarolo.save(uj);
        if (mentett == null) {
        } else {
        }

        return KonditeremMapper.toVo(mentett);

    }

    @Override
    public Map<String, Long> varosDiagramKonditeremTagokhoz(KonditeremVo konditerem) {
        List<KonditeremTagVo> konditeremTagLisa = konditerem.getKonditeremTagok();

        Map<String, Long> res = konditeremTagLisa.stream().collect(Collectors.groupingBy(KonditeremTagVo::getTagVarosa, Collectors.counting()));

        return res;
    }


}
