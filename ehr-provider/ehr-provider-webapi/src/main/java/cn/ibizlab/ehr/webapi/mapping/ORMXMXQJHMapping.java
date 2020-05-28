package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH;
import cn.ibizlab.ehr.webapi.dto.ORMXMXQJHDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ORMXMXQJHMapping extends MappingBase<ORMXMXQJHDTO, ORMXMXQJH> {


}

