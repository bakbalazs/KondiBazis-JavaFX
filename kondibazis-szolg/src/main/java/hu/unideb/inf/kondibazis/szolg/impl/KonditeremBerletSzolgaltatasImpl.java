package hu.unideb.inf.kondibazis.szolg.impl;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremBerletSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremBerletMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class KonditeremBerletSzolgaltatasImpl implements KonditeremBerletSzolgaltatas {

	@Autowired
	private KonditeremBerletTarolo konditeremBerletTarolo;

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Override
	public KonditeremBerletVo keresBerletet(Long id) {
		KonditeremBerlet found = konditeremBerletTarolo.findOne(id);
		if (found == null) {
		} else {
		}

		return KonditeremBerletMapper.toVo(found);
	}

	@Override
	public KonditeremBerletVo letrehozBerletet(KonditeremBerletVo ujBerlet) {
		KonditeremBerlet uj = KonditeremBerletMapper.toDto(ujBerlet);

		KonditeremBerlet letezo = konditeremBerletTarolo.save(uj);

		if (letezo == null) {

		} else {

		}

		return KonditeremBerletMapper.toVo(letezo);

	}

	@Override
	public KonditeremBerletVo frissitKonditeremBerletet(KonditeremBerletVo konditeremBerlet) {
		KonditeremBerlet mentett = konditeremBerletTarolo.save(KonditeremBerletMapper.toDto(konditeremBerlet));

		if (mentett == null) {

		} else {

		}

		return KonditeremBerletMapper.toVo(mentett);

	}

	@Override
	public List<KonditeremBerletVo> konditeremOsszesBerlete(KonditeremVo konditerem) {

		List<KonditeremBerlet> konditerem_berletei = konditeremBerletTarolo
				.findByKonditerem(KonditeremMapper.toDto(konditerem));

		if (konditerem_berletei == null) {
			// a konditremnek nincsneke bérletei
		} else {
			// a konditerem x db bérlete van
		}

		for (KonditeremBerlet konditeremBerlet : konditerem_berletei) {
			// kondietremberlet id
		}

		return KonditeremBerletMapper.toVo(konditerem_berletei);

	}

	@Override
	public void torolKonditeremBerletet(KonditeremBerletVo konditeremBerlet) {

		KonditeremVo konditerem = konditeremBerlet.getKonditerem();

		List<KonditeremBerletVo> konditeremBerletek = konditerem.getKonditeremBerletek();

		konditeremBerletek.remove(konditeremBerlet);

		konditeremSzolgaltatas.frissitKonditermet(konditerem);

		konditeremBerletTarolo.delete(konditeremBerlet.getId());

	}

}
