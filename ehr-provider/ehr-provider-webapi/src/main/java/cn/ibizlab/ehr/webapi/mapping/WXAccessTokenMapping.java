package cn.ibizlab.ehr.webapi.mapping;

import org.mapstruct.*;
import cn.ibizlab.ehr.core.wx.domain.WXAccessToken;
import cn.ibizlab.ehr.webapi.dto.WXAccessTokenDTO;
import cn.ibizlab.ehr.util.domain.MappingBase;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WXAccessTokenMapping extends MappingBase<WXAccessTokenDTO, WXAccessToken> {


}

