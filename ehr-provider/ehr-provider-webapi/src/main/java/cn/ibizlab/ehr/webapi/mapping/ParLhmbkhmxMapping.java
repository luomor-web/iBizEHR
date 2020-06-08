package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.ParLhmbkhmx;
import cn.ibizlab.ehr.webapi.dto.ParLhmbkhmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParLhmbkhmxMapping extends MappingBase<ParLhmbkhmxDTO, ParLhmbkhmx> {


}

