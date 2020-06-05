package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PimArchivalCatalogue;
import cn.ibizlab.ehr.webapi.dto.PimArchivalCatalogueDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PimArchivalCatalogueMapping extends MappingBase<PimArchivalCatalogueDTO, PimArchivalCatalogue> {


}

