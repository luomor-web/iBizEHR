package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMSgqMgr;
import cn.ibizlab.ehr.webapi.dto.PCMSgqMgrDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMSgqMgrMapping extends MappingBase<PCMSgqMgrDTO, PCMSgqMgr> {


}

