package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmJxszzkhjgjl;
import cn.ibizlab.ehr.webapi.dto.PcmJxszzkhjgjlDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmJxszzkhjgjlMapping extends MappingBase<PcmJxszzkhjgjlDTO, PcmJxszzkhjgjl> {


}

