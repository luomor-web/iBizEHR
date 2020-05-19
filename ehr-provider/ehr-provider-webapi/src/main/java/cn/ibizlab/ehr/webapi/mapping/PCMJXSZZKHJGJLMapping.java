package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL;
import cn.ibizlab.ehr.webapi.dto.PCMJXSZZKHJGJLDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMJXSZZKHJGJLMapping extends MappingBase<PCMJXSZZKHJGJLDTO, PCMJXSZZKHJGJL> {


}

