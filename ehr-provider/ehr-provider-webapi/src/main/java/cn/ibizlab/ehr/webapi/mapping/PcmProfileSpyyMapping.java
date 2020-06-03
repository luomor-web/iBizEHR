package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSpyy;
import cn.ibizlab.ehr.webapi.dto.PcmProfileSpyyDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmProfileSpyyMapping extends MappingBase<PcmProfileSpyyDTO, PcmProfileSpyy> {


}

