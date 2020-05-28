package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACLEAVETIPS;
import cn.ibizlab.ehr.webapi.dto.VACLEAVETIPSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACLEAVETIPSMapping extends MappingBase<VACLEAVETIPSDTO, VACLEAVETIPS> {


}

