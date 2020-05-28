package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.ATTENDENCECALENDAR;
import cn.ibizlab.ehr.webapi.dto.ATTENDENCECALENDARDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ATTENDENCECALENDARMapping extends MappingBase<ATTENDENCECALENDARDTO, ATTENDENCECALENDAR> {


}

