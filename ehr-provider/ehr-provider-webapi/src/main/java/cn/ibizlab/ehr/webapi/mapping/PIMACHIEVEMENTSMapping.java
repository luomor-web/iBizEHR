package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMACHIEVEMENTS;
import cn.ibizlab.ehr.webapi.dto.PIMACHIEVEMENTSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMACHIEVEMENTSMapping extends MappingBase<PIMACHIEVEMENTSDTO, PIMACHIEVEMENTS> {


}

