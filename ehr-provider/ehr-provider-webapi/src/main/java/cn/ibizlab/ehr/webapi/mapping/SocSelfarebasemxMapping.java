package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.soc.domain.SocSelfarebasemx;
import cn.ibizlab.ehr.webapi.dto.SocSelfarebasemxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SocSelfarebasemxMapping extends MappingBase<SocSelfarebasemxDTO, SocSelfarebasemx> {


}

