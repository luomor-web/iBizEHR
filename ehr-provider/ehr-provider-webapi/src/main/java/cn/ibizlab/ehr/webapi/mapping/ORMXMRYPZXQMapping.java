package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.orm.domain.ORMXMRYPZXQ;
import cn.ibizlab.ehr.webapi.dto.ORMXMRYPZXQDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ORMXMRYPZXQMapping extends MappingBase<ORMXMRYPZXQDTO, ORMXMRYPZXQ> {


}

