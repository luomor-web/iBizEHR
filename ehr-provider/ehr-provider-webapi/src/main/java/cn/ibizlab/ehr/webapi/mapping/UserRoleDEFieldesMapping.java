package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.common.domain.UserRoleDEFieldes;
import cn.ibizlab.ehr.webapi.dto.UserRoleDEFieldesDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserRoleDEFieldesMapping extends MappingBase<UserRoleDEFieldesDTO, UserRoleDEFieldes> {


}

