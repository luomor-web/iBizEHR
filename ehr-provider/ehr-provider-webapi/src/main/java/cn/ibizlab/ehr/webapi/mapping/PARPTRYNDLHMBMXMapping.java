package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMBMX;
import cn.ibizlab.ehr.webapi.dto.PARPTRYNDLHMBMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARPTRYNDLHMBMXMapping extends MappingBase<PARPTRYNDLHMBMXDTO, PARPTRYNDLHMBMX> {


}

