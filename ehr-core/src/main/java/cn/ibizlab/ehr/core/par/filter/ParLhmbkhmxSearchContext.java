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
import cn.ibizlab.ehr.core.par.domain.ParLhmbkhmx;
/**
 * 关系型数据实体[ParLhmbkhmx] 查询条件对象
 */
@Slf4j
@Data
public class ParLhmbkhmxSearchContext extends QueryWrapperContext<ParLhmbkhmx> {

	private String n_parlhmbkhmxname_like;//[量化目标考核明细名称]
	public void setN_parlhmbkhmxname_like(String n_parlhmbkhmxname_like) {
        this.n_parlhmbkhmxname_like = n_parlhmbkhmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parlhmbkhmxname_like)){
            this.getSearchCond().like("parlhmbkhmxname", n_parlhmbkhmxname_like);
        }
    }
	private String n_parndlhmbkhname_eq;//[量化目标考核]
	public void setN_parndlhmbkhname_eq(String n_parndlhmbkhname_eq) {
        this.n_parndlhmbkhname_eq = n_parndlhmbkhname_eq;
        if(!ObjectUtils.isEmpty(this.n_parndlhmbkhname_eq)){
            this.getSearchCond().eq("parndlhmbkhname", n_parndlhmbkhname_eq);
        }
    }
	private String n_parndlhmbkhname_like;//[量化目标考核]
	public void setN_parndlhmbkhname_like(String n_parndlhmbkhname_like) {
        this.n_parndlhmbkhname_like = n_parndlhmbkhname_like;
        if(!ObjectUtils.isEmpty(this.n_parndlhmbkhname_like)){
            this.getSearchCond().like("parndlhmbkhname", n_parndlhmbkhname_like);
        }
    }
	private String n_parndlhmbkhid_eq;//[量化目标考核ID]
	public void setN_parndlhmbkhid_eq(String n_parndlhmbkhid_eq) {
        this.n_parndlhmbkhid_eq = n_parndlhmbkhid_eq;
        if(!ObjectUtils.isEmpty(this.n_parndlhmbkhid_eq)){
            this.getSearchCond().eq("parndlhmbkhid", n_parndlhmbkhid_eq);
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
                     wrapper.like("parlhmbkhmxname", query)   
            );
		 }
	}
}




