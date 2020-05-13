package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAY;
import cn.ibizlab.ehr.webapi.dto.VACHOLIDAYDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACHOLIDAYMapping extends MappingBase<VACHOLIDAYDTO, VACHOLIDAY> {


}
