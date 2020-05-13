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
import cn.ibizlab.ehr.core.wf.domain.WFStepInst;
/**
 * 关系型数据实体[WFStepInst] 查询条件对象
 */
@Slf4j
@Data
public class WFStepInstSearchContext extends QueryWrapperContext<WFStepInst> {

	private String n_wfstepinstname_like;//[工作流步骤子实例名称]
	public void setN_wfstepinstname_like(String n_wfstepinstname_like) {
        this.n_wfstepinstname_like = n_wfstepinstname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepinstname_like)){
            this.getSelectCond().like("wfstepinstname", n_wfstepinstname_like);
        }
    }
	private String n_wfstepname_eq;//[工作流步骤]
	public void setN_wfstepname_eq(String n_wfstepname_eq) {
        this.n_wfstepname_eq = n_wfstepname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_eq)){
            this.getSelectCond().eq("wfstepname", n_wfstepname_eq);
        }
    }
	private String n_wfstepname_like;//[工作流步骤]
	public void setN_wfstepname_like(String n_wfstepname_like) {
        this.n_wfstepname_like = n_wfstepname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_like)){
            this.getSelectCond().like("wfstepname", n_wfstepname_like);
        }
    }
	private String n_wfinstancename_eq;//[子流程实例]
	public void setN_wfinstancename_eq(String n_wfinstancename_eq) {
        this.n_wfinstancename_eq = n_wfinstancename_eq;
        if(!ObjectUtils.isEmpty(this.n_wfinstancename_eq)){
            this.getSelectCond().eq("wfinstancename", n_wfinstancename_eq);
        }
    }
	private String n_wfinstancename_like;//[子流程实例]
	public void setN_wfinstancename_like(String n_wfinstancename_like) {
        this.n_wfinstancename_like = n_wfinstancename_like;
        if(!ObjectUtils.isEmpty(this.n_wfinstancename_like)){
            this.getSelectCond().like("wfinstancename", n_wfinstancename_like);
        }
    }
	private String n_wfinstanceid_eq;//[子流程实例]
	public void setN_wfinstanceid_eq(String n_wfinstanceid_eq) {
        this.n_wfinstanceid_eq = n_wfinstanceid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfinstanceid_eq)){
            this.getSelectCond().eq("wfinstanceid", n_wfinstanceid_eq);
        }
    }
	private String n_wfstepid_eq;//[工作流步骤]
	public void setN_wfstepid_eq(String n_wfstepid_eq) {
        this.n_wfstepid_eq = n_wfstepid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepid_eq)){
            this.getSelectCond().eq("wfstepid", n_wfstepid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfstepinstname",query);
		 }
	}
}




