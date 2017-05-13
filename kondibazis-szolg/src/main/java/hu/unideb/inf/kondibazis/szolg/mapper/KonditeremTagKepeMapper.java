package hu.unideb.inf.kondibazis.szolg.mapper;

import hu.unideb.inf.kondibazis.db.entitas.KonditeremTagKepe;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagKepeVo;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class KonditeremTagKepeMapper {

    private static ModelMapper mapper = new ModelMapper();

    public static KonditeremTagKepeVo toVo(KonditeremTagKepe konditeremTagKepeDto) {
        if (konditeremTagKepeDto == null) {
            return null;
        }
        return mapper.map(konditeremTagKepeDto, KonditeremTagKepeVo.class);
    }

    public static KonditeremTagKepe toDto(KonditeremTagKepeVo konditeremTagKepeVo) {
        if (konditeremTagKepeVo == null) {
            return null;
        }
        return mapper.map(konditeremTagKepeVo, KonditeremTagKepe.class);
    }

    public static List<KonditeremTagKepeVo> toVo(List<KonditeremTagKepe> konditeremTagKepeDtos) {
        List<KonditeremTagKepeVo> konditeremTagKepeVos = new ArrayList<>();
        for (KonditeremTagKepe konditeremTagKepeDto : konditeremTagKepeDtos) {
            konditeremTagKepeVos.add(toVo(konditeremTagKepeDto));
        }
        return konditeremTagKepeVos;
    }

    public static List<KonditeremTagKepe> toDto(List<KonditeremTagKepeVo> konditeremTagKepeVos) {
        List<KonditeremTagKepe> konditeremTagKepeDtos = new ArrayList<>();
        for (KonditeremTagKepeVo konditeremTagKepeVo : konditeremTagKepeVos) {
            konditeremTagKepeDtos.add(toDto(konditeremTagKepeVo));
        }
        return konditeremTagKepeDtos;
    }
}
