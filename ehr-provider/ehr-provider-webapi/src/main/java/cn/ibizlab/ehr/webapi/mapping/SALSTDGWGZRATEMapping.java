package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.sal.domain.SALSTDGWGZRATE;
import cn.ibizlab.ehr.webapi.dto.SALSTDGWGZRATEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SALSTDGWGZRATEMapping extends MappingBase<SALSTDGWGZRATEDTO, SALSTDGWGZRATE> {


}

