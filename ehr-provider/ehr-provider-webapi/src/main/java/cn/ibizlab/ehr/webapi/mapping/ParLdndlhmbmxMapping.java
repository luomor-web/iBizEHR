package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.ParLdndlhmbmx;
import cn.ibizlab.ehr.webapi.dto.ParLdndlhmbmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParLdndlhmbmxMapping extends MappingBase<ParLdndlhmbmxDTO, ParLdndlhmbmx> {


}

