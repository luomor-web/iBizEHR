package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.ARCHIVALCATALOGUE;
import cn.ibizlab.ehr.webapi.dto.ARCHIVALCATALOGUEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ARCHIVALCATALOGUEMapping extends MappingBase<ARCHIVALCATALOGUEDTO, ARCHIVALCATALOGUE> {


}

