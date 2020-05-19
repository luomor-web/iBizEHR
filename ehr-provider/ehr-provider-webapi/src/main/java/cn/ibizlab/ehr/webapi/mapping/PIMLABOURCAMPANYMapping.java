package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMLABOURCAMPANY;
import cn.ibizlab.ehr.webapi.dto.PIMLABOURCAMPANYDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMLABOURCAMPANYMapping extends MappingBase<PIMLABOURCAMPANYDTO, PIMLABOURCAMPANY> {


}

