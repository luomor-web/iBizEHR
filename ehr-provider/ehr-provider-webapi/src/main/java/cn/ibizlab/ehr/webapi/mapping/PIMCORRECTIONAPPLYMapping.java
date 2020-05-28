package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMCORRECTIONAPPLY;
import cn.ibizlab.ehr.webapi.dto.PIMCORRECTIONAPPLYDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMCORRECTIONAPPLYMapping extends MappingBase<PIMCORRECTIONAPPLYDTO, PIMCORRECTIONAPPLY> {


}

