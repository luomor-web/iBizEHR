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
import cn.ibizlab.ehr.core.common.domain.OrgSector;
/**
 * 关系型数据实体[OrgSector] 查询条件对象
 */
@Slf4j
@Data
public class OrgSectorSearchContext extends QueryWrapperContext<OrgSector> {

	private String n_orgsectorname_like;//[部门名称]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_shortname_like;//[简称]
	public void setN_shortname_like(String n_shortname_like) {
        this.n_shortname_like = n_shortname_like;
        if(!ObjectUtils.isEmpty(this.n_shortname_like)){
            this.getSelectCond().like("shortname", n_shortname_like);
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
	private String n_porgsectorname_eq;//[上级部门]
	public void setN_porgsectorname_eq(String n_porgsectorname_eq) {
        this.n_porgsectorname_eq = n_porgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_porgsectorname_eq)){
            this.getSelectCond().eq("porgsectorname", n_porgsectorname_eq);
        }
    }
	private String n_porgsectorname_like;//[上级部门]
	public void setN_porgsectorname_like(String n_porgsectorname_like) {
        this.n_porgsectorname_like = n_porgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_porgsectorname_like)){
            this.getSelectCond().like("porgsectorname", n_porgsectorname_like);
        }
    }
	private String n_reporgsectorname_eq;//[汇报部门]
	public void setN_reporgsectorname_eq(String n_reporgsectorname_eq) {
        this.n_reporgsectorname_eq = n_reporgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_reporgsectorname_eq)){
            this.getSelectCond().eq("reporgsectorname", n_reporgsectorname_eq);
        }
    }
	private String n_reporgsectorname_like;//[汇报部门]
	public void setN_reporgsectorname_like(String n_reporgsectorname_like) {
        this.n_reporgsectorname_like = n_reporgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_reporgsectorname_like)){
            this.getSelectCond().like("reporgsectorname", n_reporgsectorname_like);
        }
    }
	private String n_orgid_eq;//[组织机构]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_reporgsectorid_eq;//[汇报部门]
	public void setN_reporgsectorid_eq(String n_reporgsectorid_eq) {
        this.n_reporgsectorid_eq = n_reporgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_reporgsectorid_eq)){
            this.getSelectCond().eq("reporgsectorid", n_reporgsectorid_eq);
        }
    }
	private String n_porgsectorid_eq;//[上级部门]
	public void setN_porgsectorid_eq(String n_porgsectorid_eq) {
        this.n_porgsectorid_eq = n_porgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_porgsectorid_eq)){
            this.getSelectCond().eq("porgsectorid", n_porgsectorid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgsectorname",query);
		 }
	}
}




