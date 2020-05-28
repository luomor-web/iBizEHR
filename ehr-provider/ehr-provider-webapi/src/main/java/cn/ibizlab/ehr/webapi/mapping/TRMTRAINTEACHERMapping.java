package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER;
import cn.ibizlab.ehr.webapi.dto.TRMTRAINTEACHERDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMTRAINTEACHERMapping extends MappingBase<TRMTRAINTEACHERDTO, TRMTRAINTEACHER> {


}

