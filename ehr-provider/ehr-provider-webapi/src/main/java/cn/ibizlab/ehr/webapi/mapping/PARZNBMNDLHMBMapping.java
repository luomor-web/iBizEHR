package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB;
import cn.ibizlab.ehr.webapi.dto.PARZNBMNDLHMBDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARZNBMNDLHMBMapping extends MappingBase<PARZNBMNDLHMBDTO, PARZNBMNDLHMB> {


}

