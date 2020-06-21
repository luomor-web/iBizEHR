package cn.ibizlab.ehr.core.soc.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.soc.domain.SocType;
/**
 * 关系型数据实体[SocType] 查询条件对象
 */
@Slf4j
@Data
public class SocTypeSearchContext extends QueryWrapperContext<SocType> {

	private String n_soctypename_like;//[保险类型]
	public void setN_soctypename_like(String n_soctypename_like) {
        this.n_soctypename_like = n_soctypename_like;
        if(!ObjectUtils.isEmpty(this.n_soctypename_like)){
            this.getSearchCond().like("soctypename", n_soctypename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("soctypename", query)   
            );
		 }
	}
}




