package hu.unideb.inf.kondibazis.szolg.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;

public class TelepulesekMapper {

	private static ModelMapper mapper = new ModelMapper();

	public static TelepulesekVo toVo(Telepulesek telepulesekDto) {
		if (telepulesekDto == null) {

			return null;

		}
		return mapper.map(telepulesekDto, TelepulesekVo.class);
	}

	public static Telepulesek toDto(TelepulesekVo telepulesekVo) {
		if (telepulesekVo == null) {

			return null;
		}
		return mapper.map(telepulesekVo, Telepulesek.class);
	}

	public static List<TelepulesekVo> toVo(List<Telepulesek> telepulesekDtos) {
		List<TelepulesekVo> telepulesekVos = new ArrayList<>();
		for (Telepulesek telepulesekDto : telepulesekDtos) {
			telepulesekVos.add(toVo(telepulesekDto));
		}
		return telepulesekVos;
	}

	public static List<Telepulesek> toDto(List<TelepulesekVo> telepulesekVos) {
		List<Telepulesek> telepulesekDtos = new ArrayList<>();
		for (TelepulesekVo telepulesekVo : telepulesekVos) {
			telepulesekDtos.add(toDto(telepulesekVo));
		}
		return telepulesekDtos;
	}

}
