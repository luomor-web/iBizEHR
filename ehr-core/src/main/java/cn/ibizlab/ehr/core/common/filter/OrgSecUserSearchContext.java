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
import cn.ibizlab.ehr.core.common.domain.OrgSecUser;
/**
 * 关系型数据实体[OrgSecUser] 查询条件对象
 */
@Slf4j
@Data
public class OrgSecUserSearchContext extends QueryWrapperContext<OrgSecUser> {

	private String n_orgsecusername_like;//[组织部门人员名称]
	public void setN_orgsecusername_like(String n_orgsecusername_like) {
        this.n_orgsecusername_like = n_orgsecusername_like;
        if(!ObjectUtils.isEmpty(this.n_orgsecusername_like)){
            this.getSelectCond().like("orgsecusername", n_orgsecusername_like);
        }
    }
	private String n_orgsecusertypename_eq;//[部门人员关系]
	public void setN_orgsecusertypename_eq(String n_orgsecusertypename_eq) {
        this.n_orgsecusertypename_eq = n_orgsecusertypename_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsecusertypename_eq)){
            this.getSelectCond().eq("orgsecusertypename", n_orgsecusertypename_eq);
        }
    }
	private String n_orgsecusertypename_like;//[部门人员关系]
	public void setN_orgsecusertypename_like(String n_orgsecusertypename_like) {
        this.n_orgsecusertypename_like = n_orgsecusertypename_like;
        if(!ObjectUtils.isEmpty(this.n_orgsecusertypename_like)){
            this.getSelectCond().like("orgsecusertypename", n_orgsecusertypename_like);
        }
    }
	private String n_orgusername_eq;//[组织人员]
	public void setN_orgusername_eq(String n_orgusername_eq) {
        this.n_orgusername_eq = n_orgusername_eq;
        if(!ObjectUtils.isEmpty(this.n_orgusername_eq)){
            this.getSelectCond().eq("orgusername", n_orgusername_eq);
        }
    }
	private String n_orgusername_like;//[组织人员]
	public void setN_orgusername_like(String n_orgusername_like) {
        this.n_orgusername_like = n_orgusername_like;
        if(!ObjectUtils.isEmpty(this.n_orgusername_like)){
            this.getSelectCond().like("orgusername", n_orgusername_like);
        }
    }
	private String n_orgsectorname_eq;//[组织部门]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSelectCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[组织部门]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_orgname_eq;//[组织机构]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSelectCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[组织机构]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_orgid_eq;//[组织机构]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_orgsecusertypeid_eq;//[部门人员关系]
	public void setN_orgsecusertypeid_eq(String n_orgsecusertypeid_eq) {
        this.n_orgsecusertypeid_eq = n_orgsecusertypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsecusertypeid_eq)){
            this.getSelectCond().eq("orgsecusertypeid", n_orgsecusertypeid_eq);
        }
    }
	private String n_orgsectorid_eq;//[组织部门]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSelectCond().eq("orgsectorid", n_orgsectorid_eq);
        }
    }
	private String n_orguserid_eq;//[组织人员]
	public void setN_orguserid_eq(String n_orguserid_eq) {
        this.n_orguserid_eq = n_orguserid_eq;
        if(!ObjectUtils.isEmpty(this.n_orguserid_eq)){
            this.getSelectCond().eq("orguserid", n_orguserid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgsecusername",query);
		 }
	}
}




