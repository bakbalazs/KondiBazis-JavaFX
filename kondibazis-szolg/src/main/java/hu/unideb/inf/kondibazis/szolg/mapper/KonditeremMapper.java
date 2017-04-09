package hu.unideb.inf.kondibazis.szolg.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;

public class KonditeremMapper {

	public static Mapper mapper = new DozerBeanMapper();

	public static KonditeremVo toVo(Konditerem konditeremDto) {
		if (konditeremDto == null) {
			return null;
		}
		return mapper.map(konditeremDto, KonditeremVo.class);
	}

	public static Konditerem toDto(KonditeremVo konditeremVo) {
		if (konditeremVo == null) {
			return null;
		}
		return mapper.map(konditeremVo, Konditerem.class);
	}

	public static List<KonditeremVo> toVo(List<Konditerem> konditeremDtos) {
		List<KonditeremVo> konditeremVos = new ArrayList<>();
		for (Konditerem konditeremDto : konditeremDtos) {
			konditeremVos.add(toVo(konditeremDto));
		}
		return konditeremVos;
	}

	public static List<Konditerem> toDto(List<KonditeremVo> konditeremVos) {
		List<Konditerem> konditeremDtos = new ArrayList<>();
		for (KonditeremVo konditeremVo : konditeremVos) {
			konditeremDtos.add(toDto(konditeremVo));
		}
		return konditeremDtos;
	}

}
