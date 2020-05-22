package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMBMX;
import cn.ibizlab.ehr.webapi.dto.PARZNBMNDLHMBMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARZNBMNDLHMBMXMapping extends MappingBase<PARZNBMNDLHMBMXDTO, PARZNBMNDLHMBMX> {


}

