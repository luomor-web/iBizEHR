package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.sal.domain.SALSALARYBILL;
import cn.ibizlab.ehr.webapi.dto.SALSALARYBILLDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SALSALARYBILLMapping extends MappingBase<SALSALARYBILLDTO, SALSALARYBILL> {


}

