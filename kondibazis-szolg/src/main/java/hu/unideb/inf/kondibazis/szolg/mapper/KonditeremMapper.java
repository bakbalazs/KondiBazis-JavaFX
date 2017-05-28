// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.szolg.mapper;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class KonditeremMapper {

    private static ModelMapper mapper = new ModelMapper();

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
