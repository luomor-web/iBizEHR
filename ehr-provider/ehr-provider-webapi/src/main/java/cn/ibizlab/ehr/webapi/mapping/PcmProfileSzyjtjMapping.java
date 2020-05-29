package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
import cn.ibizlab.ehr.webapi.dto.PcmProfileSzyjtjDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmProfileSzyjtjMapping extends MappingBase<PcmProfileSzyjtjDTO, PcmProfileSzyjtj> {


}

