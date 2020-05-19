package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH;
import cn.ibizlab.ehr.webapi.dto.PARNDLHMBKHDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARNDLHMBKHMapping extends MappingBase<PARNDLHMBKHDTO, PARNDLHMBKH> {


}

