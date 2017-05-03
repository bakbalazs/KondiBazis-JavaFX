package hu.unideb.inf.kondibazis.szolg.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;

public class KonditeremBerletMapper {
	private static ModelMapper mapper = new ModelMapper();

	public static KonditeremBerletVo toVo(KonditeremBerlet konditeremBerletDto) {
		if (konditeremBerletDto == null) {
			return null;
		}
		return mapper.map(konditeremBerletDto, KonditeremBerletVo.class);
	}

	public static KonditeremBerlet toDto(KonditeremBerletVo KonditeremBerletVo) {
		if (KonditeremBerletVo == null) {
			return null;
		}
		return mapper.map(KonditeremBerletVo, KonditeremBerlet.class);
	}

	public static List<KonditeremBerletVo> toVo(List<KonditeremBerlet> konditeremBerletDtos) {
		List<KonditeremBerletVo> konditeremBerletVos = new ArrayList<>();
		for (KonditeremBerlet konditeremBerletDto : konditeremBerletDtos) {
			konditeremBerletVos.add(toVo(konditeremBerletDto));
		}
		return konditeremBerletVos;
	}

	public static List<KonditeremBerlet> toDto(List<KonditeremBerletVo> konditeremBerletVos) {
		List<KonditeremBerlet> konditeremBerletDtos = new ArrayList<>();
		for (KonditeremBerletVo KonditeremBerletVo : konditeremBerletVos) {
			konditeremBerletDtos.add(toDto(KonditeremBerletVo));
		}
		return konditeremBerletDtos;
	}

}
