package cn.ibizlab.ehr.core.wf.filter;

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
import cn.ibizlab.ehr.core.wf.domain.WFUCPolicy;
/**
 * 关系型数据实体[WFUCPolicy] 查询条件对象
 */
@Slf4j
@Data
public class WFUCPolicySearchContext extends QueryWrapperContext<WFUCPolicy> {

	private Integer n_policystate_eq;//[策略状态]
	public void setN_policystate_eq(Integer n_policystate_eq) {
        this.n_policystate_eq = n_policystate_eq;
        if(!ObjectUtils.isEmpty(this.n_policystate_eq)){
            this.getSelectCond().eq("policystate", n_policystate_eq);
        }
    }
	private String n_wfucpolicyname_like;//[工作流候选用户策略名称]
	public void setN_wfucpolicyname_like(String n_wfucpolicyname_like) {
        this.n_wfucpolicyname_like = n_wfucpolicyname_like;
        if(!ObjectUtils.isEmpty(this.n_wfucpolicyname_like)){
            this.getSelectCond().like("wfucpolicyname", n_wfucpolicyname_like);
        }
    }
	private String n_minorwfusername_eq;//[候选用户]
	public void setN_minorwfusername_eq(String n_minorwfusername_eq) {
        this.n_minorwfusername_eq = n_minorwfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_minorwfusername_eq)){
            this.getSelectCond().eq("minorwfusername", n_minorwfusername_eq);
        }
    }
	private String n_minorwfusername_like;//[候选用户]
	public void setN_minorwfusername_like(String n_minorwfusername_like) {
        this.n_minorwfusername_like = n_minorwfusername_like;
        if(!ObjectUtils.isEmpty(this.n_minorwfusername_like)){
            this.getSelectCond().like("minorwfusername", n_minorwfusername_like);
        }
    }
	private String n_majorwfusername_eq;//[工作流用户]
	public void setN_majorwfusername_eq(String n_majorwfusername_eq) {
        this.n_majorwfusername_eq = n_majorwfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_majorwfusername_eq)){
            this.getSelectCond().eq("majorwfusername", n_majorwfusername_eq);
        }
    }
	private String n_majorwfusername_like;//[工作流用户]
	public void setN_majorwfusername_like(String n_majorwfusername_like) {
        this.n_majorwfusername_like = n_majorwfusername_like;
        if(!ObjectUtils.isEmpty(this.n_majorwfusername_like)){
            this.getSelectCond().like("majorwfusername", n_majorwfusername_like);
        }
    }
	private String n_minorwfuserid_eq;//[候选用户]
	public void setN_minorwfuserid_eq(String n_minorwfuserid_eq) {
        this.n_minorwfuserid_eq = n_minorwfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_minorwfuserid_eq)){
            this.getSelectCond().eq("minorwfuserid", n_minorwfuserid_eq);
        }
    }
	private String n_majorwfuserid_eq;//[工作流用户]
	public void setN_majorwfuserid_eq(String n_majorwfuserid_eq) {
        this.n_majorwfuserid_eq = n_majorwfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_majorwfuserid_eq)){
            this.getSelectCond().eq("majorwfuserid", n_majorwfuserid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfucpolicyname",query);
		 }
	}
}




