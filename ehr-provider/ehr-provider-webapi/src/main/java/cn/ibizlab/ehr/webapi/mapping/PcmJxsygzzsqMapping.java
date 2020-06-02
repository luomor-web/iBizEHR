package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq;
import cn.ibizlab.ehr.webapi.dto.PcmJxsygzzsqDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmJxsygzzsqMapping extends MappingBase<PcmJxsygzzsqDTO, PcmJxsygzzsq> {


}

