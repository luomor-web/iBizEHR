package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZRATE;
import cn.ibizlab.ehr.webapi.dto.SALSTDXMGZRATEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SALSTDXMGZRATEMapping extends MappingBase<SALSTDXMGZRATEDTO, SALSTDXMGZRATE> {


}

