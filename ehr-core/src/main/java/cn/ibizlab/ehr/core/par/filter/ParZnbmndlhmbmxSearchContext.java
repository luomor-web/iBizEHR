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
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmbmx;
/**
 * 关系型数据实体[ParZnbmndlhmbmx] 查询条件对象
 */
@Slf4j
@Data
public class ParZnbmndlhmbmxSearchContext extends QueryWrapperContext<ParZnbmndlhmbmx> {

	private String n_mblx_eq;//[目标类型]
	public void setN_mblx_eq(String n_mblx_eq) {
        this.n_mblx_eq = n_mblx_eq;
        if(!ObjectUtils.isEmpty(this.n_mblx_eq)){
            this.getSearchCond().eq("mblx", n_mblx_eq);
        }
    }
	private String n_spzt_eq;//[审批状态]
	public void setN_spzt_eq(String n_spzt_eq) {
        this.n_spzt_eq = n_spzt_eq;
        if(!ObjectUtils.isEmpty(this.n_spzt_eq)){
            this.getSearchCond().eq("spzt", n_spzt_eq);
        }
    }
	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_parznbmndlhmbmxname_like;//[提炼指标]
	public void setN_parznbmndlhmbmxname_like(String n_parznbmndlhmbmxname_like) {
        this.n_parznbmndlhmbmxname_like = n_parznbmndlhmbmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parznbmndlhmbmxname_like)){
            this.getSearchCond().like("parznbmndlhmbmxname", n_parznbmndlhmbmxname_like);
        }
    }
	private String n_parznbmndlhmbname_eq;//[年度量化目标]
	public void setN_parznbmndlhmbname_eq(String n_parznbmndlhmbname_eq) {
        this.n_parznbmndlhmbname_eq = n_parznbmndlhmbname_eq;
        if(!ObjectUtils.isEmpty(this.n_parznbmndlhmbname_eq)){
            this.getSearchCond().eq("parznbmndlhmbname", n_parznbmndlhmbname_eq);
        }
    }
	private String n_parznbmndlhmbname_like;//[年度量化目标]
	public void setN_parznbmndlhmbname_like(String n_parznbmndlhmbname_like) {
        this.n_parznbmndlhmbname_like = n_parznbmndlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parznbmndlhmbname_like)){
            this.getSearchCond().like("parznbmndlhmbname", n_parznbmndlhmbname_like);
        }
    }
	private String n_parznbmndlhmbid_eq;//[年度量化目标ID]
	public void setN_parznbmndlhmbid_eq(String n_parznbmndlhmbid_eq) {
        this.n_parznbmndlhmbid_eq = n_parznbmndlhmbid_eq;
        if(!ObjectUtils.isEmpty(this.n_parznbmndlhmbid_eq)){
            this.getSearchCond().eq("parznbmndlhmbid", n_parznbmndlhmbid_eq);
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
                     wrapper.like("parznbmndlhmbmxname", query)   
            );
		 }
	}
}




