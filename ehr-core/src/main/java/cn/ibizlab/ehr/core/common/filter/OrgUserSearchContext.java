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
import cn.ibizlab.ehr.core.common.domain.OrgUser;
/**
 * 关系型数据实体[OrgUser] 查询条件对象
 */
@Slf4j
@Data
public class OrgUserSearchContext extends QueryWrapperContext<OrgUser> {

	private String n_orgusername_like;//[人员名称]
	public void setN_orgusername_like(String n_orgusername_like) {
        this.n_orgusername_like = n_orgusername_like;
        if(!ObjectUtils.isEmpty(this.n_orgusername_like)){
            this.getSelectCond().like("orgusername", n_orgusername_like);
        }
    }
	private String n_usercode_eq;//[用户编号]
	public void setN_usercode_eq(String n_usercode_eq) {
        this.n_usercode_eq = n_usercode_eq;
        if(!ObjectUtils.isEmpty(this.n_usercode_eq)){
            this.getSelectCond().eq("usercode", n_usercode_eq);
        }
    }
	private String n_usercode_like;//[用户编号]
	public void setN_usercode_like(String n_usercode_like) {
        this.n_usercode_like = n_usercode_like;
        if(!ObjectUtils.isEmpty(this.n_usercode_like)){
            this.getSelectCond().like("usercode", n_usercode_like);
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
	private String n_orgsectorname_eq;//[所属部门]
	public void setN_orgsectorname_eq(String n_orgsectorname_eq) {
        this.n_orgsectorname_eq = n_orgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_eq)){
            this.getSelectCond().eq("orgsectorname", n_orgsectorname_eq);
        }
    }
	private String n_orgsectorname_like;//[所属部门]
	public void setN_orgsectorname_like(String n_orgsectorname_like) {
        this.n_orgsectorname_like = n_orgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_orgsectorname_like)){
            this.getSelectCond().like("orgsectorname", n_orgsectorname_like);
        }
    }
	private String n_orguserlevelname_eq;//[人员级别]
	public void setN_orguserlevelname_eq(String n_orguserlevelname_eq) {
        this.n_orguserlevelname_eq = n_orguserlevelname_eq;
        if(!ObjectUtils.isEmpty(this.n_orguserlevelname_eq)){
            this.getSelectCond().eq("orguserlevelname", n_orguserlevelname_eq);
        }
    }
	private String n_orguserlevelname_like;//[人员级别]
	public void setN_orguserlevelname_like(String n_orguserlevelname_like) {
        this.n_orguserlevelname_like = n_orguserlevelname_like;
        if(!ObjectUtils.isEmpty(this.n_orguserlevelname_like)){
            this.getSelectCond().like("orguserlevelname", n_orguserlevelname_like);
        }
    }
	private String n_orgname_eq;//[所属组织]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSelectCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[所属组织]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_orgid_eq;//[所属组织]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_orguserlevelid_eq;//[人员级别]
	public void setN_orguserlevelid_eq(String n_orguserlevelid_eq) {
        this.n_orguserlevelid_eq = n_orguserlevelid_eq;
        if(!ObjectUtils.isEmpty(this.n_orguserlevelid_eq)){
            this.getSelectCond().eq("orguserlevelid", n_orguserlevelid_eq);
        }
    }
	private String n_orgsecusertypeid_eq;//[部门人员关系]
	public void setN_orgsecusertypeid_eq(String n_orgsecusertypeid_eq) {
        this.n_orgsecusertypeid_eq = n_orgsecusertypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsecusertypeid_eq)){
            this.getSelectCond().eq("orgsecusertypeid", n_orgsecusertypeid_eq);
        }
    }
	private String n_orgsectorid_eq;//[所属部门]
	public void setN_orgsectorid_eq(String n_orgsectorid_eq) {
        this.n_orgsectorid_eq = n_orgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgsectorid_eq)){
            this.getSelectCond().eq("orgsectorid", n_orgsectorid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgusername",query);
			this.getSelectCond().or().like("usercode",query);
		 }
	}
}




