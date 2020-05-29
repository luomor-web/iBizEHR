package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMNORecyclingLibrary;
import cn.ibizlab.ehr.webapi.dto.PCMNORecyclingLibraryDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PCMNORecyclingLibraryMapping extends MappingBase<PCMNORecyclingLibraryDTO, PCMNORecyclingLibrary> {


}

