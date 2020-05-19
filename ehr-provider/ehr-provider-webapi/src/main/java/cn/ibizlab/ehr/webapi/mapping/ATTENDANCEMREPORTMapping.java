package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORT;
import cn.ibizlab.ehr.webapi.dto.ATTENDANCEMREPORTDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ATTENDANCEMREPORTMapping extends MappingBase<ATTENDANCEMREPORTDTO, ATTENDANCEMREPORT> {


}

