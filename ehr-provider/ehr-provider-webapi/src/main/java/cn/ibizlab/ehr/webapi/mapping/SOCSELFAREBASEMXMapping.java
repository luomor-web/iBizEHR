package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASEMX;
import cn.ibizlab.ehr.webapi.dto.SOCSELFAREBASEMXDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SOCSELFAREBASEMXMapping extends MappingBase<SOCSELFAREBASEMXDTO, SOCSELFAREBASEMX> {


}

