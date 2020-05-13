package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFOMX;
import cn.ibizlab.ehr.webapi.dto.SOCWELFAREINFOMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SOCWELFAREINFOMXMapping extends MappingBase<SOCWELFAREINFOMXDTO, SOCWELFAREINFOMX> {


}

