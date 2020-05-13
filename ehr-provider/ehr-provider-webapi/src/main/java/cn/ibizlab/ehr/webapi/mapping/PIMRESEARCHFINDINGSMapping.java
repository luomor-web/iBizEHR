package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMRESEARCHFINDINGS;
import cn.ibizlab.ehr.webapi.dto.PIMRESEARCHFINDINGSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMRESEARCHFINDINGSMapping extends MappingBase<PIMRESEARCHFINDINGSDTO, PIMRESEARCHFINDINGS> {


}

