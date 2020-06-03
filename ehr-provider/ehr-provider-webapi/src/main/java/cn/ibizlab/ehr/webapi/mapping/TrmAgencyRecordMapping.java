package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TrmAgencyRecord;
import cn.ibizlab.ehr.webapi.dto.TrmAgencyRecordDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TrmAgencyRecordMapping extends MappingBase<TrmAgencyRecordDTO, TrmAgencyRecord> {


}

