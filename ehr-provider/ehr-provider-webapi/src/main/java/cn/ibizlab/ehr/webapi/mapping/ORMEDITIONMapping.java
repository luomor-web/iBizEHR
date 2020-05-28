package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.orm.domain.ORMEDITION;
import cn.ibizlab.ehr.webapi.dto.ORMEDITIONDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ORMEDITIONMapping extends MappingBase<ORMEDITIONDTO, ORMEDITION> {


}

