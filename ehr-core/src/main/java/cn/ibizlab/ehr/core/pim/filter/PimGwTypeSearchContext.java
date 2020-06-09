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
import cn.ibizlab.ehr.core.pim.domain.PimGwType;
/**
 * 关系型数据实体[PimGwType] 查询条件对象
 */
@Slf4j
@Data
public class PimGwTypeSearchContext extends QueryWrapperContext<PimGwType> {

	private String n_pimgwtypename_like;//[岗位类型对照表名称]
	public void setN_pimgwtypename_like(String n_pimgwtypename_like) {
        this.n_pimgwtypename_like = n_pimgwtypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimgwtypename_like)){
            this.getSearchCond().like("pimgwtypename", n_pimgwtypename_like);
        }
    }
	private String n_gwlx_eq;//[岗位类型]
	public void setN_gwlx_eq(String n_gwlx_eq) {
        this.n_gwlx_eq = n_gwlx_eq;
        if(!ObjectUtils.isEmpty(this.n_gwlx_eq)){
            this.getSearchCond().eq("gwlx", n_gwlx_eq);
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
                     wrapper.like("pimgwtypename", query)   
                        .or().like("gwlx", query)            
            );
		 }
	}
}




