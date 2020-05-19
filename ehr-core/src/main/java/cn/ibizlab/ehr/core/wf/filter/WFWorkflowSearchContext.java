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
import cn.ibizlab.ehr.core.wf.domain.WFWorkflow;
/**
 * 关系型数据实体[WFWorkflow] 查询条件对象
 */
@Slf4j
@Data
public class WFWorkflowSearchContext extends QueryWrapperContext<WFWorkflow> {

	private String n_wftype_eq;//[流程类型]
	public void setN_wftype_eq(String n_wftype_eq) {
        this.n_wftype_eq = n_wftype_eq;
        if(!ObjectUtils.isEmpty(this.n_wftype_eq)){
            this.getSelectCond().eq("wftype", n_wftype_eq);
        }
    }
	private String n_wfworkflowname_like;//[工作流配置名称]
	public void setN_wfworkflowname_like(String n_wfworkflowname_like) {
        this.n_wfworkflowname_like = n_wfworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_like)){
            this.getSelectCond().like("wfworkflowname", n_wfworkflowname_like);
        }
    }
	private Integer n_wfstate_eq;//[工作流状态]
	public void setN_wfstate_eq(Integer n_wfstate_eq) {
        this.n_wfstate_eq = n_wfstate_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstate_eq)){
            this.getSelectCond().eq("wfstate", n_wfstate_eq);
        }
    }
	private String n_remindmsgtemplname_eq;//[催办消息模板]
	public void setN_remindmsgtemplname_eq(String n_remindmsgtemplname_eq) {
        this.n_remindmsgtemplname_eq = n_remindmsgtemplname_eq;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtemplname_eq)){
            this.getSelectCond().eq("remindmsgtemplname", n_remindmsgtemplname_eq);
        }
    }
	private String n_remindmsgtemplname_like;//[催办消息模板]
	public void setN_remindmsgtemplname_like(String n_remindmsgtemplname_like) {
        this.n_remindmsgtemplname_like = n_remindmsgtemplname_like;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtemplname_like)){
            this.getSelectCond().like("remindmsgtemplname", n_remindmsgtemplname_like);
        }
    }
	private String n_remindmsgtemplid_eq;//[催办消息模板]
	public void setN_remindmsgtemplid_eq(String n_remindmsgtemplid_eq) {
        this.n_remindmsgtemplid_eq = n_remindmsgtemplid_eq;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtemplid_eq)){
            this.getSelectCond().eq("remindmsgtemplid", n_remindmsgtemplid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfworkflowname",query);
		 }
	}
}




