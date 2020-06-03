package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar;
import cn.ibizlab.ehr.webapi.dto.AttEndenceCalendarDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttEndenceCalendarMapping extends MappingBase<AttEndenceCalendarDTO, AttEndenceCalendar> {


}

