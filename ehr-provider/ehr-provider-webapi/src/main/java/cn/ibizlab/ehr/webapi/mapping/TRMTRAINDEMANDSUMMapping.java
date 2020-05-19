package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMANDSUM;
import cn.ibizlab.ehr.webapi.dto.TRMTRAINDEMANDSUMDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMTRAINDEMANDSUMMapping extends MappingBase<TRMTRAINDEMANDSUMDTO, TRMTRAINDEMANDSUM> {


}

