package cn.ibizlab.ehr.core.common.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.common.domain.System;
/**
 * 关系型数据实体[System] 查询条件对象
 */
@Slf4j
@Data
public class SystemSearchContext extends QueryWrapperContext<System> {

	private String n_systemname_like;//[系统名称]
	public void setN_systemname_like(String n_systemname_like) {
        this.n_systemname_like = n_systemname_like;
        if(!ObjectUtils.isEmpty(this.n_systemname_like)){
            this.getSelectCond().like("systemname", n_systemname_like);
        }
    }
	private String n_systemtype_eq;//[系统类型]
	public void setN_systemtype_eq(String n_systemtype_eq) {
        this.n_systemtype_eq = n_systemtype_eq;
        if(!ObjectUtils.isEmpty(this.n_systemtype_eq)){
            this.getSelectCond().eq("systemtype", n_systemtype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("systemname",query);
		 }
	}
}




