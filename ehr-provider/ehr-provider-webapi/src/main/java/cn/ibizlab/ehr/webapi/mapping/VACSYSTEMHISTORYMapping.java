package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMHISTORY;
import cn.ibizlab.ehr.webapi.dto.VACSYSTEMHISTORYDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACSYSTEMHISTORYMapping extends MappingBase<VACSYSTEMHISTORYDTO, VACSYSTEMHISTORY> {


}

