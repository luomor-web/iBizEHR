package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL;
import cn.ibizlab.ehr.webapi.dto.VACLEAVEDETAILDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VACLEAVEDETAILMapping extends MappingBase<VACLEAVEDETAILDTO, VACLEAVEDETAIL> {


}

