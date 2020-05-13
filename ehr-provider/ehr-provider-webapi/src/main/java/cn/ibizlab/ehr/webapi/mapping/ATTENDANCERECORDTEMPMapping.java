package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORDTEMP;
import cn.ibizlab.ehr.webapi.dto.ATTENDANCERECORDTEMPDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ATTENDANCERECORDTEMPMapping extends MappingBase<ATTENDANCERECORDTEMPDTO, ATTENDANCERECORDTEMP> {


}

