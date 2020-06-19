package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocArchives;
/**
 * 关系型数据实体[SocArchives] 查询条件对象
 */
@Slf4j
@Data
public class SocArchivesSearchContext extends QueryWrapperContext<SocArchives> {

	private String n_socarchivesname_like;//[社保档案名称]
	public void setN_socarchivesname_like(String n_socarchivesname_like) {
        this.n_socarchivesname_like = n_socarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_socarchivesname_like)){
            this.getSearchCond().like("socarchivesname", n_socarchivesname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_socaccountid_eq;//[参保账户标识]
	public void setN_socaccountid_eq(String n_socaccountid_eq) {
        this.n_socaccountid_eq = n_socaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_socaccountid_eq)){
            this.getSearchCond().eq("socaccountid", n_socaccountid_eq);
        }
    }
	private String n_socaccountname_eq;//[参保账户]
	public void setN_socaccountname_eq(String n_socaccountname_eq) {
        this.n_socaccountname_eq = n_socaccountname_eq;
        if(!ObjectUtils.isEmpty(this.n_socaccountname_eq)){
            this.getSearchCond().eq("socaccountname", n_socaccountname_eq);
        }
    }
	private String n_socaccountname_like;//[参保账户]
	public void setN_socaccountname_like(String n_socaccountname_like) {
        this.n_socaccountname_like = n_socaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_socaccountname_like)){
            this.getSearchCond().like("socaccountname", n_socaccountname_like);
        }
    }
	private String n_socruleid_eq;//[社保规则标识]
	public void setN_socruleid_eq(String n_socruleid_eq) {
        this.n_socruleid_eq = n_socruleid_eq;
        if(!ObjectUtils.isEmpty(this.n_socruleid_eq)){
            this.getSearchCond().eq("socruleid", n_socruleid_eq);
        }
    }
	private String n_socrulename_eq;//[社保规则名称]
	public void setN_socrulename_eq(String n_socrulename_eq) {
        this.n_socrulename_eq = n_socrulename_eq;
        if(!ObjectUtils.isEmpty(this.n_socrulename_eq)){
            this.getSearchCond().eq("socrulename", n_socrulename_eq);
        }
    }
	private String n_socrulename_like;//[社保规则名称]
	public void setN_socrulename_like(String n_socrulename_like) {
        this.n_socrulename_like = n_socrulename_like;
        if(!ObjectUtils.isEmpty(this.n_socrulename_like)){
            this.getSearchCond().like("socrulename", n_socrulename_like);
        }
    }
	private String n_ormorgid_eq;//[组织ID]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_state_eq;//[状态]
	public void setN_state_eq(String n_state_eq) {
        this.n_state_eq = n_state_eq;
        if(!ObjectUtils.isEmpty(this.n_state_eq)){
            this.getSearchCond().eq("state", n_state_eq);
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
                     wrapper.like("pimpersonname", query)   
                        .or().like("ygbh", query)            
            );
		 }
	}
}




