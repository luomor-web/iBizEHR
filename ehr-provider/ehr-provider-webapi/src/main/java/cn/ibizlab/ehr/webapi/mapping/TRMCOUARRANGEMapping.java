package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMCOUARRANGE;
import cn.ibizlab.ehr.webapi.dto.TRMCOUARRANGEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMCOUARRANGEMapping extends MappingBase<TRMCOUARRANGEDTO, TRMCOUARRANGE> {


}

