package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmOrg;
/**
 * 关系型数据实体[OrmOrg] 查询条件对象
 */
@Slf4j
@Data
public class OrmOrgSearchContext extends QueryWrapperContext<OrmOrg> {

	private String n_btqy_eq;//[区域补贴]
	public void setN_btqy_eq(String n_btqy_eq) {
        this.n_btqy_eq = n_btqy_eq;
        if(!ObjectUtils.isEmpty(this.n_btqy_eq)){
            this.getSearchCond().eq("btqy", n_btqy_eq);
        }
    }
	private String n_startstopsign_eq;//[启停标识]
	public void setN_startstopsign_eq(String n_startstopsign_eq) {
        this.n_startstopsign_eq = n_startstopsign_eq;
        if(!ObjectUtils.isEmpty(this.n_startstopsign_eq)){
            this.getSearchCond().eq("startstopsign", n_startstopsign_eq);
        }
    }
	private String n_legalentity_eq;//[组织性质]
	public void setN_legalentity_eq(String n_legalentity_eq) {
        this.n_legalentity_eq = n_legalentity_eq;
        if(!ObjectUtils.isEmpty(this.n_legalentity_eq)){
            this.getSearchCond().eq("legalentity", n_legalentity_eq);
        }
    }
	private String n_gsss_eq;//[所属区域]
	public void setN_gsss_eq(String n_gsss_eq) {
        this.n_gsss_eq = n_gsss_eq;
        if(!ObjectUtils.isEmpty(this.n_gsss_eq)){
            this.getSearchCond().eq("gsss", n_gsss_eq);
        }
    }
	private String n_orgcode_eq;//[组织编号]
	public void setN_orgcode_eq(String n_orgcode_eq) {
        this.n_orgcode_eq = n_orgcode_eq;
        if(!ObjectUtils.isEmpty(this.n_orgcode_eq)){
            this.getSearchCond().eq("orgcode", n_orgcode_eq);
        }
    }
	private String n_orgcode_like;//[组织编号]
	public void setN_orgcode_like(String n_orgcode_like) {
        this.n_orgcode_like = n_orgcode_like;
        if(!ObjectUtils.isEmpty(this.n_orgcode_like)){
            this.getSearchCond().like("orgcode", n_orgcode_like);
        }
    }
	private String n_zzdzs_like;//[组织显示名称]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_shortname_eq;//[简称]
	public void setN_shortname_eq(String n_shortname_eq) {
        this.n_shortname_eq = n_shortname_eq;
        if(!ObjectUtils.isEmpty(this.n_shortname_eq)){
            this.getSearchCond().eq("shortname", n_shortname_eq);
        }
    }
	private String n_shortname_like;//[简称]
	public void setN_shortname_like(String n_shortname_like) {
        this.n_shortname_like = n_shortname_like;
        if(!ObjectUtils.isEmpty(this.n_shortname_like)){
            this.getSearchCond().like("shortname", n_shortname_like);
        }
    }
	private String n_zzlx_eq;//[组织类型]
	public void setN_zzlx_eq(String n_zzlx_eq) {
        this.n_zzlx_eq = n_zzlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zzlx_eq)){
            this.getSearchCond().eq("zzlx", n_zzlx_eq);
        }
    }
	private String n_orgname_like;//[组织名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_porgname_eq;//[上级组织]
	public void setN_porgname_eq(String n_porgname_eq) {
        this.n_porgname_eq = n_porgname_eq;
        if(!ObjectUtils.isEmpty(this.n_porgname_eq)){
            this.getSearchCond().eq("porgname", n_porgname_eq);
        }
    }
	private String n_porgname_like;//[上级组织]
	public void setN_porgname_like(String n_porgname_like) {
        this.n_porgname_like = n_porgname_like;
        if(!ObjectUtils.isEmpty(this.n_porgname_like)){
            this.getSearchCond().like("porgname", n_porgname_like);
        }
    }
	private String n_porgid_eq;//[组织机构标识]
	public void setN_porgid_eq(String n_porgid_eq) {
        this.n_porgid_eq = n_porgid_eq;
        if(!ObjectUtils.isEmpty(this.n_porgid_eq)){
            this.getSearchCond().eq("porgid", n_porgid_eq);
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
                     wrapper.like("orgname", query)   
            );
		 }
	}
}




