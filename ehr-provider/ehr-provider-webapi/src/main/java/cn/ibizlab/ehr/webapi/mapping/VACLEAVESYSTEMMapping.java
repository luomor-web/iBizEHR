package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEM;
import cn.ibizlab.ehr.webapi.dto.VACLEAVESYSTEMDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACLEAVESYSTEMMapping extends MappingBase<VACLEAVESYSTEMDTO, VACLEAVESYSTEM> {


}

