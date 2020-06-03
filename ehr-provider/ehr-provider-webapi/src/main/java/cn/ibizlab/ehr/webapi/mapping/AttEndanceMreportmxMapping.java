package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import cn.ibizlab.ehr.webapi.dto.AttEndanceMreportmxDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AttEndanceMreportmxMapping extends MappingBase<AttEndanceMreportmxDTO, AttEndanceMreportmx> {


}

