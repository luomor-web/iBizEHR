package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERCHARGE;
import cn.ibizlab.ehr.webapi.dto.TRMTEACHERCHARGEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMTEACHERCHARGEMapping extends MappingBase<TRMTEACHERCHARGEDTO, TRMTEACHERCHARGE> {


}

