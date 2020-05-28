package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.orm.domain.ORMQYBZWH;
import cn.ibizlab.ehr.webapi.dto.ORMQYBZWHDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ORMQYBZWHMapping extends MappingBase<ORMQYBZWHDTO, ORMQYBZWH> {


}

