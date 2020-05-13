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
import cn.ibizlab.ehr.core.wf.domain.WFInstance;
/**
 * 关系型数据实体[WFInstance] 查询条件对象
 */
@Slf4j
@Data
public class WFInstanceSearchContext extends QueryWrapperContext<WFInstance> {

	private String n_userdata_like;//[用户数据]
	public void setN_userdata_like(String n_userdata_like) {
        this.n_userdata_like = n_userdata_like;
        if(!ObjectUtils.isEmpty(this.n_userdata_like)){
            this.getSelectCond().like("userdata", n_userdata_like);
        }
    }
	private String n_userdata4_like;//[用户数据4]
	public void setN_userdata4_like(String n_userdata4_like) {
        this.n_userdata4_like = n_userdata4_like;
        if(!ObjectUtils.isEmpty(this.n_userdata4_like)){
            this.getSelectCond().like("userdata4", n_userdata4_like);
        }
    }
	private String n_userdata3_like;//[用户数据3]
	public void setN_userdata3_like(String n_userdata3_like) {
        this.n_userdata3_like = n_userdata3_like;
        if(!ObjectUtils.isEmpty(this.n_userdata3_like)){
            this.getSelectCond().like("userdata3", n_userdata3_like);
        }
    }
	private String n_wfinstancename_like;//[工作流实例名称]
	public void setN_wfinstancename_like(String n_wfinstancename_like) {
        this.n_wfinstancename_like = n_wfinstancename_like;
        if(!ObjectUtils.isEmpty(this.n_wfinstancename_like)){
            this.getSelectCond().like("wfinstancename", n_wfinstancename_like);
        }
    }
	private String n_userdata2_like;//[用户数据2]
	public void setN_userdata2_like(String n_userdata2_like) {
        this.n_userdata2_like = n_userdata2_like;
        if(!ObjectUtils.isEmpty(this.n_userdata2_like)){
            this.getSelectCond().like("userdata2", n_userdata2_like);
        }
    }
	private String n_pwfinstancename_eq;//[父实例]
	public void setN_pwfinstancename_eq(String n_pwfinstancename_eq) {
        this.n_pwfinstancename_eq = n_pwfinstancename_eq;
        if(!ObjectUtils.isEmpty(this.n_pwfinstancename_eq)){
            this.getSelectCond().eq("pwfinstancename", n_pwfinstancename_eq);
        }
    }
	private String n_pwfinstancename_like;//[父实例]
	public void setN_pwfinstancename_like(String n_pwfinstancename_like) {
        this.n_pwfinstancename_like = n_pwfinstancename_like;
        if(!ObjectUtils.isEmpty(this.n_pwfinstancename_like)){
            this.getSelectCond().like("pwfinstancename", n_pwfinstancename_like);
        }
    }
	private String n_orgname_eq;//[组织名称]
	public void setN_orgname_eq(String n_orgname_eq) {
        this.n_orgname_eq = n_orgname_eq;
        if(!ObjectUtils.isEmpty(this.n_orgname_eq)){
            this.getSelectCond().eq("orgname", n_orgname_eq);
        }
    }
	private String n_orgname_like;//[组织名称]
	public void setN_orgname_like(String n_orgname_like) {
        this.n_orgname_like = n_orgname_like;
        if(!ObjectUtils.isEmpty(this.n_orgname_like)){
            this.getSelectCond().like("orgname", n_orgname_like);
        }
    }
	private String n_wfworkflowname_eq;//[工作流名称]
	public void setN_wfworkflowname_eq(String n_wfworkflowname_eq) {
        this.n_wfworkflowname_eq = n_wfworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_eq)){
            this.getSelectCond().eq("wfworkflowname", n_wfworkflowname_eq);
        }
    }
	private String n_wfworkflowname_like;//[工作流名称]
	public void setN_wfworkflowname_like(String n_wfworkflowname_like) {
        this.n_wfworkflowname_like = n_wfworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_like)){
            this.getSelectCond().like("wfworkflowname", n_wfworkflowname_like);
        }
    }
	private String n_wfworkflowid_eq;//[工作流名称]
	public void setN_wfworkflowid_eq(String n_wfworkflowid_eq) {
        this.n_wfworkflowid_eq = n_wfworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowid_eq)){
            this.getSelectCond().eq("wfworkflowid", n_wfworkflowid_eq);
        }
    }
	private String n_orgid_eq;//[组织标识]
	public void setN_orgid_eq(String n_orgid_eq) {
        this.n_orgid_eq = n_orgid_eq;
        if(!ObjectUtils.isEmpty(this.n_orgid_eq)){
            this.getSelectCond().eq("orgid", n_orgid_eq);
        }
    }
	private String n_pwfinstanceid_eq;//[父实例]
	public void setN_pwfinstanceid_eq(String n_pwfinstanceid_eq) {
        this.n_pwfinstanceid_eq = n_pwfinstanceid_eq;
        if(!ObjectUtils.isEmpty(this.n_pwfinstanceid_eq)){
            this.getSelectCond().eq("pwfinstanceid", n_pwfinstanceid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfinstancename",query);
		 }
	}
}




