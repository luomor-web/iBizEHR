package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.wf.domain.WFAssistWork;
import cn.ibizlab.ehr.webapi.dto.WFAssistWorkDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFAssistWorkMapping extends MappingBase<WFAssistWorkDTO, WFAssistWork> {


}

