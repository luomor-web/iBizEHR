package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.ParJxmtfk;
import cn.ibizlab.ehr.webapi.dto.ParJxmtfkDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParJxmtfkMapping extends MappingBase<ParJxmtfkDTO, ParJxmtfk> {


}

