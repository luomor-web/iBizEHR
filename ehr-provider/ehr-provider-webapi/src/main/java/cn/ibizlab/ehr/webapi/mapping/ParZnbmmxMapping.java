package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.ParZnbmmx;
import cn.ibizlab.ehr.webapi.dto.ParZnbmmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParZnbmmxMapping extends MappingBase<ParZnbmmxDTO, ParZnbmmx> {


}

