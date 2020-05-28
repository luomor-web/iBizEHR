package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAYRULES;
import cn.ibizlab.ehr.webapi.dto.VACHOLIDAYRULESDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACHOLIDAYRULESMapping extends MappingBase<VACHOLIDAYRULESDTO, VACHOLIDAYRULES> {


}

