package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PimArchiveSloanandreturn;
import cn.ibizlab.ehr.webapi.dto.PimArchiveSloanandreturnDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PimArchiveSloanandreturnMapping extends MappingBase<PimArchiveSloanandreturnDTO, PimArchiveSloanandreturn> {


}

