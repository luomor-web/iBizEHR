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
import cn.ibizlab.ehr.core.wf.domain.WFAssistWork;
/**
 * 关系型数据实体[WFAssistWork] 查询条件对象
 */
@Slf4j
@Data
public class WFAssistWorkSearchContext extends QueryWrapperContext<WFAssistWork> {

	private String n_wfassistworkname_like;//[工作流代办工作名称]
	public void setN_wfassistworkname_like(String n_wfassistworkname_like) {
        this.n_wfassistworkname_like = n_wfassistworkname_like;
        if(!ObjectUtils.isEmpty(this.n_wfassistworkname_like)){
            this.getSelectCond().like("wfassistworkname", n_wfassistworkname_like);
        }
    }
	private String n_wfinstancename_eq;//[流程实例]
	public void setN_wfinstancename_eq(String n_wfinstancename_eq) {
        this.n_wfinstancename_eq = n_wfinstancename_eq;
        if(!ObjectUtils.isEmpty(this.n_wfinstancename_eq)){
            this.getSelectCond().eq("wfinstancename", n_wfinstancename_eq);
        }
    }
	private String n_wfinstancename_like;//[流程实例]
	public void setN_wfinstancename_like(String n_wfinstancename_like) {
        this.n_wfinstancename_like = n_wfinstancename_like;
        if(!ObjectUtils.isEmpty(this.n_wfinstancename_like)){
            this.getSelectCond().like("wfinstancename", n_wfinstancename_like);
        }
    }
	private String n_wfstepactorname_eq;//[步骤操作者]
	public void setN_wfstepactorname_eq(String n_wfstepactorname_eq) {
        this.n_wfstepactorname_eq = n_wfstepactorname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorname_eq)){
            this.getSelectCond().eq("wfstepactorname", n_wfstepactorname_eq);
        }
    }
	private String n_wfstepactorname_like;//[步骤操作者]
	public void setN_wfstepactorname_like(String n_wfstepactorname_like) {
        this.n_wfstepactorname_like = n_wfstepactorname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorname_like)){
            this.getSelectCond().like("wfstepactorname", n_wfstepactorname_like);
        }
    }
	private String n_wfworkflowname_eq;//[工作流]
	public void setN_wfworkflowname_eq(String n_wfworkflowname_eq) {
        this.n_wfworkflowname_eq = n_wfworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_eq)){
            this.getSelectCond().eq("wfworkflowname", n_wfworkflowname_eq);
        }
    }
	private String n_wfworkflowname_like;//[工作流]
	public void setN_wfworkflowname_like(String n_wfworkflowname_like) {
        this.n_wfworkflowname_like = n_wfworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_like)){
            this.getSelectCond().like("wfworkflowname", n_wfworkflowname_like);
        }
    }
	private String n_wfinstanceid_eq;//[流程实例]
	public void setN_wfinstanceid_eq(String n_wfinstanceid_eq) {
        this.n_wfinstanceid_eq = n_wfinstanceid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfinstanceid_eq)){
            this.getSelectCond().eq("wfinstanceid", n_wfinstanceid_eq);
        }
    }
	private String n_wfstepactorid_eq;//[步骤操作者]
	public void setN_wfstepactorid_eq(String n_wfstepactorid_eq) {
        this.n_wfstepactorid_eq = n_wfstepactorid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorid_eq)){
            this.getSelectCond().eq("wfstepactorid", n_wfstepactorid_eq);
        }
    }
	private String n_wfworkflowid_eq;//[工作流]
	public void setN_wfworkflowid_eq(String n_wfworkflowid_eq) {
        this.n_wfworkflowid_eq = n_wfworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowid_eq)){
            this.getSelectCond().eq("wfworkflowid", n_wfworkflowid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfassistworkname",query);
		 }
	}
}




