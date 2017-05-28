// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.szolg.mapper;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class KonditeremElerhetosegMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static KonditeremElerhetosegVo toVo(KonditeremElerhetoseg konditeremElerhetosegDto) {
        if (konditeremElerhetosegDto == null) {
            return null;
        }
        return mapper.map(konditeremElerhetosegDto, KonditeremElerhetosegVo.class);
    }

    public static KonditeremElerhetoseg toDto(KonditeremElerhetosegVo KonditeremElerhetosegVo) {
        if (KonditeremElerhetosegVo == null) {
            return null;
        }
        return mapper.map(KonditeremElerhetosegVo, KonditeremElerhetoseg.class);
    }

    public static List<KonditeremElerhetosegVo> toVo(List<KonditeremElerhetoseg> konditeremElerhetosegDtos) {
        List<KonditeremElerhetosegVo> konditeremElerhetosegVos = new ArrayList<>();
        for (KonditeremElerhetoseg konditeremElerhetosegDto : konditeremElerhetosegDtos) {
            konditeremElerhetosegVos.add(toVo(konditeremElerhetosegDto));
        }
        return konditeremElerhetosegVos;
    }

    public static List<KonditeremElerhetoseg> toDto(List<KonditeremElerhetosegVo> konditeremElerhetosegVos) {
        List<KonditeremElerhetoseg> konditeremElerhetosegDtos = new ArrayList<>();
        for (KonditeremElerhetosegVo KonditeremElerhetosegVo : konditeremElerhetosegVos) {
            konditeremElerhetosegDtos.add(toDto(KonditeremElerhetosegVo));
        }
        return konditeremElerhetosegDtos;
    }

}
