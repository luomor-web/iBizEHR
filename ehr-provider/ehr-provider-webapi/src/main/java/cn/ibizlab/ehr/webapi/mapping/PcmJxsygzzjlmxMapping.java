package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
import cn.ibizlab.ehr.webapi.dto.PcmJxsygzzjlmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmJxsygzzjlmxMapping extends MappingBase<PcmJxsygzzjlmxDTO, PcmJxsygzzjlmx> {


}

