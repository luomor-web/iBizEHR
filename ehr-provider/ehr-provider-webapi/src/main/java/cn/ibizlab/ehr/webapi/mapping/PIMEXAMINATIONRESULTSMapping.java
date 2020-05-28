package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMEXAMINATIONRESULTS;
import cn.ibizlab.ehr.webapi.dto.PIMEXAMINATIONRESULTSDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMEXAMINATIONRESULTSMapping extends MappingBase<PIMEXAMINATIONRESULTSDTO, PIMEXAMINATIONRESULTS> {


}

