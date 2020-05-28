package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
import cn.ibizlab.ehr.webapi.dto.PIMARMYCADRESDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMARMYCADRESMapping extends MappingBase<PIMARMYCADRESDTO, PIMARMYCADRES> {


}

