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
import cn.ibizlab.ehr.core.pim.domain.PimSocialSecurity;
/**
 * 关系型数据实体[PimSocialSecurity] 查询条件对象
 */
@Slf4j
@Data
public class PimSocialSecuritySearchContext extends QueryWrapperContext<PimSocialSecurity> {

	private String n_pimsocialsecurityname_like;//[社保信息名称]
	public void setN_pimsocialsecurityname_like(String n_pimsocialsecurityname_like) {
        this.n_pimsocialsecurityname_like = n_pimsocialsecurityname_like;
        if(!ObjectUtils.isEmpty(this.n_pimsocialsecurityname_like)){
            this.getSearchCond().like("pimsocialsecurityname", n_pimsocialsecurityname_like);
        }
    }
	private String n_jndw_eq;//[缴纳单位]
	public void setN_jndw_eq(String n_jndw_eq) {
        this.n_jndw_eq = n_jndw_eq;
        if(!ObjectUtils.isEmpty(this.n_jndw_eq)){
            this.getSearchCond().eq("jndw", n_jndw_eq);
        }
    }
	private String n_lx_eq;//[类型]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_cbdq_eq;//[参保地区]
	public void setN_cbdq_eq(String n_cbdq_eq) {
        this.n_cbdq_eq = n_cbdq_eq;
        if(!ObjectUtils.isEmpty(this.n_cbdq_eq)){
            this.getSearchCond().eq("cbdq", n_cbdq_eq);
        }
    }
	private String n_jnzt_eq;//[缴纳主体]
	public void setN_jnzt_eq(String n_jnzt_eq) {
        this.n_jnzt_eq = n_jnzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jnzt_eq)){
            this.getSearchCond().eq("jnzt", n_jnzt_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pimsocialsecurityname", query)   
            );
		 }
	}
}




