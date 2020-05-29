package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
import cn.ibizlab.ehr.webapi.dto.PCMXYGZZSQMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMXYGZZSQMXMapping extends MappingBase<PCMXYGZZSQMXDTO, PCMXYGZZSQMX> {


}

