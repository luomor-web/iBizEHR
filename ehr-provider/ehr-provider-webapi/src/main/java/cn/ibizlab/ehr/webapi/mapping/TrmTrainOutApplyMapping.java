package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TrmTrainOutApply;
import cn.ibizlab.ehr.webapi.dto.TrmTrainOutApplyDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TrmTrainOutApplyMapping extends MappingBase<TrmTrainOutApplyDTO, TrmTrainOutApply> {


}

