package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMTYPECONTRACT;
import cn.ibizlab.ehr.webapi.dto.PIMTYPECONTRACTDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMTYPECONTRACTMapping extends MappingBase<PIMTYPECONTRACTDTO, PIMTYPECONTRACT> {


}

