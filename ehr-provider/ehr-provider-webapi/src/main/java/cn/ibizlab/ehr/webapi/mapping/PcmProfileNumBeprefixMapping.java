package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileNumBeprefix;
import cn.ibizlab.ehr.webapi.dto.PcmProfileNumBeprefixDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PcmProfileNumBeprefixMapping extends MappingBase<PcmProfileNumBeprefixDTO, PcmProfileNumBeprefix> {


}

