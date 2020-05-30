package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PimResearchFindings;
import cn.ibizlab.ehr.webapi.dto.PimResearchFindingsDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PimResearchFindingsMapping extends MappingBase<PimResearchFindingsDTO, PimResearchFindings> {


}

