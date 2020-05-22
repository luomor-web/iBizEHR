package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMDEPARTNEEDS;
import cn.ibizlab.ehr.webapi.dto.TRMDEPARTNEEDSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMDEPARTNEEDSMapping extends MappingBase<TRMDEPARTNEEDSDTO, TRMDEPARTNEEDS> {


}

