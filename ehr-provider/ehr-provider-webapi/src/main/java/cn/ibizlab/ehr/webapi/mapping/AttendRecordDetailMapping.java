package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.AttendRecordDetail;
import cn.ibizlab.ehr.webapi.dto.AttendRecordDetailDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttendRecordDetailMapping extends MappingBase<AttendRecordDetailDTO, AttendRecordDetail> {


}

