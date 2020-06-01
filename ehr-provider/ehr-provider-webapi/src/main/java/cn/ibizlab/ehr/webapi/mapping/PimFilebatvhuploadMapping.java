package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PimFilebatvhupload;
import cn.ibizlab.ehr.webapi.dto.PimFilebatvhuploadDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PimFilebatvhuploadMapping extends MappingBase<PimFilebatvhuploadDTO, PimFilebatvhupload> {


}

