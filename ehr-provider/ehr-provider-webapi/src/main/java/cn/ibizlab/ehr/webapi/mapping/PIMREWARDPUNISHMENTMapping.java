package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.pim.domain.PIMREWARDPUNISHMENT;
import cn.ibizlab.ehr.webapi.dto.PIMREWARDPUNISHMENTDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PIMREWARDPUNISHMENTMapping extends MappingBase<PIMREWARDPUNISHMENTDTO, PIMREWARDPUNISHMENT> {


}

