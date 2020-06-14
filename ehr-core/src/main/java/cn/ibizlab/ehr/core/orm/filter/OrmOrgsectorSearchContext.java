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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgsector;
/**
 * 关系型数据实体[OrmOrgsector] 查询条件对象
 */
@Slf4j
@Data
public class OrmOrgsectorSearchContext extends QueryWrapperContext<OrmOrgsector> {

	private String n_qy_eq;//[补贴标准]
	public void setN_qy_eq(String n_qy_eq) {
        this.n_qy_eq = n_qy_eq;
        if(!ObjectUtils.isEmpty(this.n_qy_eq)){
            this.getSearchCond().eq("qy", n_qy_eq);
        }
    }
	private String n_startstopsign_eq;//[启停标识]
	public void setN_startstopsign_eq(String n_startstopsign_eq) {
        this.n_startstopsign_eq = n_startstopsign_eq;
        if(!ObjectUtils.isEmpty(this.n_startstopsign_eq)){
            this.getSearchCond().eq("startstopsign", n_startstopsign_eq);
        }
    }
	private String n_approvalstatus_eq;//[审批状态]
	public void setN_approvalstatus_eq(String n_approvalstatus_eq) {
        this.n_approvalstatus_eq = n_approvalstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_approvalstatus_eq)){
            this.getSearchCond().eq("approvalstatus", n_approvalstatus_eq);
        }
    }
	private String n_dkfs_eq;//[打卡方式]
	public void setN_dkfs_eq(String n_dkfs_eq) {
        this.n_dkfs_eq = n_dkfs_eq;
        if(!ObjectUtils.isEmpty(this.n_dkfs_eq)){
            this.getSearchCond().eq("dkfs", n_dkfs_eq);
        }
    }
	private String n_orgsectorname_like;//[部门名称]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSearchCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_xmgm_eq;//[项目规模]
	public void setN_xmgm_eq(String n_xmgm_eq) {
        this.n_xmgm_eq = n_xmgm_eq;
        if(!ObjectUtils.isEmpty(this.n_xmgm_eq)){
            this.getSearchCond().eq("xmgm", n_xmgm_eq);
        }
    }
	private String n_referjoblevel_eq;//[参照职务层级]
	public void setN_referjoblevel_eq(String n_referjoblevel_eq) {
        this.n_referjoblevel_eq = n_referjoblevel_eq;
        if(!ObjectUtils.isEmpty(this.n_referjoblevel_eq)){
            this.getSearchCond().eq("referjoblevel", n_referjoblevel_eq);
        }
    }
	private String n_gqap_eq;//[工期安排]
	public void setN_gqap_eq(String n_gqap_eq) {
        this.n_gqap_eq = n_gqap_eq;
        if(!ObjectUtils.isEmpty(this.n_gqap_eq)){
            this.getSearchCond().eq("gqap", n_gqap_eq);
        }
    }
	private String n_bmlx_eq;//[部门类型]
	public void setN_bmlx_eq(String n_bmlx_eq) {
        this.n_bmlx_eq = n_bmlx_eq;
        if(!ObjectUtils.isEmpty(this.n_bmlx_eq)){
            this.getSearchCond().eq("bmlx", n_bmlx_eq);
        }
    }
	private String n_xmblx_eq;//[项目部类型]
	public void setN_xmblx_eq(String n_xmblx_eq) {
        this.n_xmblx_eq = n_xmblx_eq;
        if(!ObjectUtils.isEmpty(this.n_xmblx_eq)){
            this.getSearchCond().eq("xmblx", n_xmblx_eq);
        }
    }
	private String n_gkjz_eq;//[管控机制]
	public void setN_gkjz_eq(String n_gkjz_eq) {
        this.n_gkjz_eq = n_gkjz_eq;
        if(!ObjectUtils.isEmpty(this.n_gkjz_eq)){
            this.getSearchCond().eq("gkjz", n_gkjz_eq);
        }
    }
	private String n_editionstate_eq;//[版本状态]
	public void setN_editionstate_eq(String n_editionstate_eq) {
        this.n_editionstate_eq = n_editionstate_eq;
        if(!ObjectUtils.isEmpty(this.n_editionstate_eq)){
            this.getSearchCond().eq("editionstate", n_editionstate_eq);
        }
    }
	private String n_belongregion_eq;//[所属区域]
	public void setN_belongregion_eq(String n_belongregion_eq) {
        this.n_belongregion_eq = n_belongregion_eq;
        if(!ObjectUtils.isEmpty(this.n_belongregion_eq)){
            this.getSearchCond().eq("belongregion", n_belongregion_eq);
        }
    }
	private String n_proleadername_eq;//[项目负责人]
	public void setN_proleadername_eq(String n_proleadername_eq) {
        this.n_proleadername_eq = n_proleadername_eq;
        if(!ObjectUtils.isEmpty(this.n_proleadername_eq)){
            this.getSearchCond().eq("proleadername", n_proleadername_eq);
        }
    }
	private String n_proleadername_like;//[项目负责人]
	public void setN_proleadername_like(String n_proleadername_like) {
        this.n_proleadername_like = n_proleadername_like;
        if(!ObjectUtils.isEmpty(this.n_proleadername_like)){
            this.getSearchCond().like("proleadername", n_proleadername_like);
        }
    }
	private String n_prodepname_eq;//[项目部名称]
	public void setN_prodepname_eq(String n_prodepname_eq) {
        this.n_prodepname_eq = n_prodepname_eq;
        if(!ObjectUtils.isEmpty(this.n_prodepname_eq)){
            this.getSearchCond().eq("prodepname", n_prodepname_eq);
        }
    }
	private String n_prodepname_like;//[项目部名称]
	public void setN_prodepname_like(String n_prodepname_like) {
        this.n_prodepname_like = n_prodepname_like;
        if(!ObjectUtils.isEmpty(this.n_prodepname_like)){
            this.getSearchCond().like("prodepname", n_prodepname_like);
        }
    }
	private String n_ormxmglname_eq;//[项目名称]
	public void setN_ormxmglname_eq(String n_ormxmglname_eq) {
        this.n_ormxmglname_eq = n_ormxmglname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormxmglname_eq)){
            this.getSearchCond().eq("ormxmglname", n_ormxmglname_eq);
        }
    }
	private String n_ormxmglname_like;//[项目名称]
	public void setN_ormxmglname_like(String n_ormxmglname_like) {
        this.n_ormxmglname_like = n_ormxmglname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmglname_like)){
            this.getSearchCond().like("ormxmglname", n_ormxmglname_like);
        }
    }
	private String n_pimpersonname_eq;//[部门负责人]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[部门负责人]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_orgname_eq;//[组织机构]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSearchCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[组织机构]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSearchCond().like("orgname", n_orgname_like);
        }
    }
	private String n_zzdzs_like;//[组织]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_porgsectorname_eq;//[上级部门]
	public void setN_porgsectorname_eq(String n_porgsectorname_eq) {
        this.n_porgsectorname_eq = n_porgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_porgsectorname_eq)){
            this.getSearchCond().eq("porgsectorname", n_porgsectorname_eq);
        }
    }
	private String n_porgsectorname_like;//[上级部门]
	public void setN_porgsectorname_like(String n_porgsectorname_like) {
        this.n_porgsectorname_like = n_porgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_porgsectorname_like)){
            this.getSearchCond().like("porgsectorname", n_porgsectorname_like);
        }
    }
	private String n_pimpersonid_eq;//[部门负责人ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormxmglid_eq;//[项目ID]
	public void setN_ormxmglid_eq(String n_ormxmglid_eq) {
        this.n_ormxmglid_eq = n_ormxmglid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormxmglid_eq)){
            this.getSearchCond().eq("ormxmglid", n_ormxmglid_eq);
        }
    }
	private String n_prodepid_eq;//[项目部ID]
	public void setN_prodepid_eq(String n_prodepid_eq) {
        this.n_prodepid_eq = n_prodepid_eq;
        if(!ObjectUtils.isEmpty(this.n_prodepid_eq)){
            this.getSearchCond().eq("prodepid", n_prodepid_eq);
        }
    }
	private String n_proleaderid_eq;//[项目负责人ID]
	public void setN_proleaderid_eq(String n_proleaderid_eq) {
        this.n_proleaderid_eq = n_proleaderid_eq;
        if(!ObjectUtils.isEmpty(this.n_proleaderid_eq)){
            this.getSearchCond().eq("proleaderid", n_proleaderid_eq);
        }
    }
	private String n_porgsectorid_eq;//[上级部门ID]
	public void setN_porgsectorid_eq(String n_porgsectorid_eq) {
        this.n_porgsectorid_eq = n_porgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_porgsectorid_eq)){
            this.getSearchCond().eq("porgsectorid", n_porgsectorid_eq);
        }
    }
	private String n_orgid_eq;//[组织机构标识]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSearchCond().eq("orgid", n_orgid_eq);
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
                     wrapper.like("orgsectorname", query)   
            );
		 }
	}
}




