package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimCity;
/**
 * 关系型数据实体[PimCity] 查询条件对象
 */
@Slf4j
@Data
public class PimCitySearchContext extends QueryWrapperContext<PimCity> {

	private String n_protype_eq;//[类型]
	public void setN_protype_eq(String n_protype_eq) {
        this.n_protype_eq = n_protype_eq;
        if(!ObjectUtils.isEmpty(this.n_protype_eq)){
            this.getSearchCond().eq("protype", n_protype_eq);
        }
    }
	private String n_pimcityname_like;//[市名称]
	public void setN_pimcityname_like(String n_pimcityname_like) {
        this.n_pimcityname_like = n_pimcityname_like;
        if(!ObjectUtils.isEmpty(this.n_pimcityname_like)){
            this.getSearchCond().like("pimcityname", n_pimcityname_like);
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
                     wrapper.like("pimcityname", query)   
            );
		 }
	}
}




