package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQ;
import cn.ibizlab.ehr.webapi.dto.PCMJXSYGZZSQDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMJXSYGZZSQMapping extends MappingBase<PCMJXSYGZZSQDTO, PCMJXSYGZZSQ> {


}

