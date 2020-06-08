package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemandSum;
import cn.ibizlab.ehr.webapi.dto.TrmTrainDemandSumDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TrmTrainDemandSumMapping extends MappingBase<TrmTrainDemandSumDTO, TrmTrainDemandSum> {


}

