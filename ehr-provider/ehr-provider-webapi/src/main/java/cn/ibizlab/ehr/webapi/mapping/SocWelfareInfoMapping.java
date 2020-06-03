package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.soc.domain.SocWelfareInfo;
import cn.ibizlab.ehr.webapi.dto.SocWelfareInfoDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SocWelfareInfoMapping extends MappingBase<SocWelfareInfoDTO, SocWelfareInfo> {


}

