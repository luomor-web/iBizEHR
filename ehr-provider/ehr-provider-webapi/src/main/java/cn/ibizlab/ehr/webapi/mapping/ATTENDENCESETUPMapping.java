package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP;
import cn.ibizlab.ehr.webapi.dto.ATTENDENCESETUPDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ATTENDENCESETUPMapping extends MappingBase<ATTENDENCESETUPDTO, ATTENDENCESETUP> {


}

