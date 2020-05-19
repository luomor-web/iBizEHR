package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMDEMDEFTION;
import cn.ibizlab.ehr.webapi.dto.TRMDEMDEFTIONDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMDEMDEFTIONMapping extends MappingBase<TRMDEMDEFTIONDTO, TRMDEMDEFTION> {


}

