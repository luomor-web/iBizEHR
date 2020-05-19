package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMCSRCMSPJ;
import cn.ibizlab.ehr.webapi.dto.PCMCSRCMSPJDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMCSRCMSPJMapping extends MappingBase<PCMCSRCMSPJDTO, PCMCSRCMSPJ> {


}

