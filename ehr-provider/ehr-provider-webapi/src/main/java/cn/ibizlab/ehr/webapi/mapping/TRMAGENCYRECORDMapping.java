package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.trm.domain.TRMAGENCYRECORD;
import cn.ibizlab.ehr.webapi.dto.TRMAGENCYRECORDDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TRMAGENCYRECORDMapping extends MappingBase<TRMAGENCYRECORDDTO, TRMAGENCYRECORD> {


}

