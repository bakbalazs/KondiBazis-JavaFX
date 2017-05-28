// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.szolg.mapper;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class KonditeremTagMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static KonditeremTagVo toVo(KonditeremTag konditeremTagDto) {
        if (konditeremTagDto == null) {

            return null;

        }
        return mapper.map(konditeremTagDto, KonditeremTagVo.class);
    }

    public static KonditeremTag toDto(KonditeremTagVo konditeremTagVo) {
        if (konditeremTagVo == null) {

            return null;

        }
        return mapper.map(konditeremTagVo, KonditeremTag.class);
    }

    public static List<KonditeremTagVo> toVo(List<KonditeremTag> konditeremTagDtos) {
        List<KonditeremTagVo> konditeremTagVos = new ArrayList<>();
        for (KonditeremTag konditeremTagDto : konditeremTagDtos) {
            konditeremTagVos.add(toVo(konditeremTagDto));
        }
        return konditeremTagVos;
    }

    public static List<KonditeremTag> toDto(List<KonditeremTagVo> konditeremTagVos) {
        List<KonditeremTag> konditeremTagDtos = new ArrayList<>();
        for (KonditeremTagVo konditeremTagVo : konditeremTagVos) {
            konditeremTagDtos.add(toDto(konditeremTagVo));
        }
        return konditeremTagDtos;
    }

}
