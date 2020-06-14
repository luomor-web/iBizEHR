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
import cn.ibizlab.ehr.core.par.domain.ParLdndlhmbmx;
/**
 * 关系型数据实体[ParLdndlhmbmx] 查询条件对象
 */
@Slf4j
@Data
public class ParLdndlhmbmxSearchContext extends QueryWrapperContext<ParLdndlhmbmx> {

	private String n_mblx_eq;//[目标类型]
	public void setN_mblx_eq(String n_mblx_eq) {
        this.n_mblx_eq = n_mblx_eq;
        if(!ObjectUtils.isEmpty(this.n_mblx_eq)){
            this.getSearchCond().eq("mblx", n_mblx_eq);
        }
    }
	private String n_parldndlhmbmxname_like;//[量化目标]
	public void setN_parldndlhmbmxname_like(String n_parldndlhmbmxname_like) {
        this.n_parldndlhmbmxname_like = n_parldndlhmbmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parldndlhmbmxname_like)){
            this.getSearchCond().like("parldndlhmbmxname", n_parldndlhmbmxname_like);
        }
    }
	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_spzt_eq;//[审批状态]
	public void setN_spzt_eq(String n_spzt_eq) {
        this.n_spzt_eq = n_spzt_eq;
        if(!ObjectUtils.isEmpty(this.n_spzt_eq)){
            this.getSearchCond().eq("spzt", n_spzt_eq);
        }
    }
	private String n_parldndlhmbname_eq;//[年度量化目标名称]
	public void setN_parldndlhmbname_eq(String n_parldndlhmbname_eq) {
        this.n_parldndlhmbname_eq = n_parldndlhmbname_eq;
        if(!ObjectUtils.isEmpty(this.n_parldndlhmbname_eq)){
            this.getSearchCond().eq("parldndlhmbname", n_parldndlhmbname_eq);
        }
    }
	private String n_parldndlhmbname_like;//[年度量化目标名称]
	public void setN_parldndlhmbname_like(String n_parldndlhmbname_like) {
        this.n_parldndlhmbname_like = n_parldndlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parldndlhmbname_like)){
            this.getSearchCond().like("parldndlhmbname", n_parldndlhmbname_like);
        }
    }
	private String n_parldndlhmbid_eq;//[年度量化目标ID]
	public void setN_parldndlhmbid_eq(String n_parldndlhmbid_eq) {
        this.n_parldndlhmbid_eq = n_parldndlhmbid_eq;
        if(!ObjectUtils.isEmpty(this.n_parldndlhmbid_eq)){
            this.getSearchCond().eq("parldndlhmbid", n_parldndlhmbid_eq);
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
                     wrapper.like("parldndlhmbmxname", query)   
            );
		 }
	}
}




