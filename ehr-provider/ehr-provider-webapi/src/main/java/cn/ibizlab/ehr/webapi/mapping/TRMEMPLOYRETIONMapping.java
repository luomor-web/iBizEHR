package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
import cn.ibizlab.ehr.webapi.dto.TRMEMPLOYRETIONDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMEMPLOYRETIONMapping extends MappingBase<TRMEMPLOYRETIONDTO, TRMEMPLOYRETION> {


}

