package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TrmStaffnodes;
import cn.ibizlab.ehr.webapi.dto.TrmStaffnodesDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TrmStaffnodesMapping extends MappingBase<TrmStaffnodesDTO, TrmStaffnodes> {


}

