package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMB;
import cn.ibizlab.ehr.webapi.dto.PARPTRYNDLHMBDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PARPTRYNDLHMBMapping extends MappingBase<PARPTRYNDLHMBDTO, PARPTRYNDLHMB> {


}

