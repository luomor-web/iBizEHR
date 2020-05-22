package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMAWARDSWONS;
import cn.ibizlab.ehr.webapi.dto.PCMAWARDSWONSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMAWARDSWONSMapping extends MappingBase<PCMAWARDSWONSDTO, PCMAWARDSWONS> {


}

