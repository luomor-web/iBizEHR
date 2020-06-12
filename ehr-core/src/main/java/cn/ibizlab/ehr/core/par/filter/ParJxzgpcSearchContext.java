package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.ParJxzgpc;
/**
 * 关系型数据实体[ParJxzgpc] 查询条件对象
 */
@Slf4j
@Data
public class ParJxzgpcSearchContext extends QueryWrapperContext<ParJxzgpc> {

	private String n_khx_eq;//[考核项]
	public void setN_khx_eq(String n_khx_eq) {
        this.n_khx_eq = n_khx_eq;
        if(!ObjectUtils.isEmpty(this.n_khx_eq)){
            this.getSearchCond().eq("khx", n_khx_eq);
        }
    }
	private String n_khlx_eq;//[考核类型]
	public void setN_khlx_eq(String n_khlx_eq) {
        this.n_khlx_eq = n_khlx_eq;
        if(!ObjectUtils.isEmpty(this.n_khlx_eq)){
            this.getSearchCond().eq("khlx", n_khlx_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_parjxzgpcname_like;//[标题]
	public void setN_parjxzgpcname_like(String n_parjxzgpcname_like) {
        this.n_parjxzgpcname_like = n_parjxzgpcname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxzgpcname_like)){
            this.getSearchCond().like("parjxzgpcname", n_parjxzgpcname_like);
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
                     wrapper.like("parjxzgpcname", query)   
            );
		 }
	}
}




