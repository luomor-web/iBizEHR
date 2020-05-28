package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMDUTYCADRES;
import cn.ibizlab.ehr.webapi.dto.TRMDUTYCADRESDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMDUTYCADRESMapping extends MappingBase<TRMDUTYCADRESDTO, TRMDUTYCADRES> {


}

