package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmbmx;
import cn.ibizlab.ehr.webapi.dto.ParZnbmndlhmbmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParZnbmndlhmbmxMapping extends MappingBase<ParZnbmndlhmbmxDTO, ParZnbmndlhmbmx> {


}

