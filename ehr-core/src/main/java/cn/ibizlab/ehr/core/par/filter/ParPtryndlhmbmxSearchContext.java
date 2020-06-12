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
import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmbmx;
/**
 * 关系型数据实体[ParPtryndlhmbmx] 查询条件对象
 */
@Slf4j
@Data
public class ParPtryndlhmbmxSearchContext extends QueryWrapperContext<ParPtryndlhmbmx> {

	private String n_spzt_eq;//[审批状态]
	public void setN_spzt_eq(String n_spzt_eq) {
        this.n_spzt_eq = n_spzt_eq;
        if(!ObjectUtils.isEmpty(this.n_spzt_eq)){
            this.getSearchCond().eq("spzt", n_spzt_eq);
        }
    }
	private String n_parptryndlhmbmxname_like;//[工作职责]
	public void setN_parptryndlhmbmxname_like(String n_parptryndlhmbmxname_like) {
        this.n_parptryndlhmbmxname_like = n_parptryndlhmbmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parptryndlhmbmxname_like)){
            this.getSearchCond().like("parptryndlhmbmxname", n_parptryndlhmbmxname_like);
        }
    }
	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_parptryndlhmbname_eq;//[年度量化目标]
	public void setN_parptryndlhmbname_eq(String n_parptryndlhmbname_eq) {
        this.n_parptryndlhmbname_eq = n_parptryndlhmbname_eq;
        if(!ObjectUtils.isEmpty(this.n_parptryndlhmbname_eq)){
            this.getSearchCond().eq("parptryndlhmbname", n_parptryndlhmbname_eq);
        }
    }
	private String n_parptryndlhmbname_like;//[年度量化目标]
	public void setN_parptryndlhmbname_like(String n_parptryndlhmbname_like) {
        this.n_parptryndlhmbname_like = n_parptryndlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parptryndlhmbname_like)){
            this.getSearchCond().like("parptryndlhmbname", n_parptryndlhmbname_like);
        }
    }
	private String n_parptryndlhmbid_eq;//[年度量化目标ID]
	public void setN_parptryndlhmbid_eq(String n_parptryndlhmbid_eq) {
        this.n_parptryndlhmbid_eq = n_parptryndlhmbid_eq;
        if(!ObjectUtils.isEmpty(this.n_parptryndlhmbid_eq)){
            this.getSearchCond().eq("parptryndlhmbid", n_parptryndlhmbid_eq);
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
                     wrapper.like("parptryndlhmbmxname", query)   
            );
		 }
	}
}




