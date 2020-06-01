package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmPcmSgqMgr;
import cn.ibizlab.ehr.webapi.dto.PcmPcmSgqMgrDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmPcmSgqMgrMapping extends MappingBase<PcmPcmSgqMgrDTO, PcmPcmSgqMgr> {


}

