package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.ARCHIVESMANAGE;
import cn.ibizlab.ehr.webapi.dto.ARCHIVESMANAGEDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ARCHIVESMANAGEMapping extends MappingBase<ARCHIVESMANAGEDTO, ARCHIVESMANAGE> {


}

