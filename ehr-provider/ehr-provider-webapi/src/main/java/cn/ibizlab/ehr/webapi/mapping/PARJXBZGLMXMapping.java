package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARJXBZGLMX;
import cn.ibizlab.ehr.webapi.dto.PARJXBZGLMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARJXBZGLMXMapping extends MappingBase<PARJXBZGLMXDTO, PARJXBZGLMX> {


}

