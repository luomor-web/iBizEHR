package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMDISTIRBUTION;
import cn.ibizlab.ehr.webapi.dto.PIMDISTIRBUTIONDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMDISTIRBUTIONMapping extends MappingBase<PIMDISTIRBUTIONDTO, PIMDISTIRBUTION> {


}

