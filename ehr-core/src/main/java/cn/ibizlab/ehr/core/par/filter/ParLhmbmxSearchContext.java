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
import cn.ibizlab.ehr.core.par.domain.ParLhmbmx;
/**
 * 关系型数据实体[ParLhmbmx] 查询条件对象
 */
@Slf4j
@Data
public class ParLhmbmxSearchContext extends QueryWrapperContext<ParLhmbmx> {

	private String n_parlhmbmxname_like;//[量化目标]
	public void setN_parlhmbmxname_like(String n_parlhmbmxname_like) {
        this.n_parlhmbmxname_like = n_parlhmbmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parlhmbmxname_like)){
            this.getSearchCond().like("parlhmbmxname", n_parlhmbmxname_like);
        }
    }
	private String n_parjxlhmbname_eq;//[绩效量化目标名称]
	public void setN_parjxlhmbname_eq(String n_parjxlhmbname_eq) {
        this.n_parjxlhmbname_eq = n_parjxlhmbname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxlhmbname_eq)){
            this.getSearchCond().eq("parjxlhmbname", n_parjxlhmbname_eq);
        }
    }
	private String n_parjxlhmbname_like;//[绩效量化目标名称]
	public void setN_parjxlhmbname_like(String n_parjxlhmbname_like) {
        this.n_parjxlhmbname_like = n_parjxlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxlhmbname_like)){
            this.getSearchCond().like("parjxlhmbname", n_parjxlhmbname_like);
        }
    }
	private String n_parjxlhmbid_eq;//[量化目标ID]
	public void setN_parjxlhmbid_eq(String n_parjxlhmbid_eq) {
        this.n_parjxlhmbid_eq = n_parjxlhmbid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxlhmbid_eq)){
            this.getSearchCond().eq("parjxlhmbid", n_parjxlhmbid_eq);
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
                     wrapper.like("parlhmbmxname", query)   
            );
		 }
	}
}




