package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.wf.domain.WFDynamicUser;
import cn.ibizlab.ehr.webapi.dto.WFDynamicUserDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WFDynamicUserMapping extends MappingBase<WFDynamicUserDTO, WFDynamicUser> {


}

