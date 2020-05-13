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
import cn.ibizlab.ehr.core.wf.domain.WFStepData;
/**
 * 关系型数据实体[WFStepData] 查询条件对象
 */
@Slf4j
@Data
public class WFStepDataSearchContext extends QueryWrapperContext<WFStepData> {

	private String n_wfstepdataname_like;//[流程操作]
	public void setN_wfstepdataname_like(String n_wfstepdataname_like) {
        this.n_wfstepdataname_like = n_wfstepdataname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepdataname_like)){
            this.getSelectCond().like("wfstepdataname", n_wfstepdataname_like);
        }
    }
	private String n_originalwfusername_eq;//[源流程用户]
	public void setN_originalwfusername_eq(String n_originalwfusername_eq) {
        this.n_originalwfusername_eq = n_originalwfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_originalwfusername_eq)){
            this.getSelectCond().eq("originalwfusername", n_originalwfusername_eq);
        }
    }
	private String n_originalwfusername_like;//[源流程用户]
	public void setN_originalwfusername_like(String n_originalwfusername_like) {
        this.n_originalwfusername_like = n_originalwfusername_like;
        if(!ObjectUtils.isEmpty(this.n_originalwfusername_like)){
            this.getSelectCond().like("originalwfusername", n_originalwfusername_like);
        }
    }
	private String n_wfstepname_eq;//[步骤名称]
	public void setN_wfstepname_eq(String n_wfstepname_eq) {
        this.n_wfstepname_eq = n_wfstepname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_eq)){
            this.getSelectCond().eq("wfstepname", n_wfstepname_eq);
        }
    }
	private String n_wfstepname_like;//[步骤名称]
	public void setN_wfstepname_like(String n_wfstepname_like) {
        this.n_wfstepname_like = n_wfstepname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_like)){
            this.getSelectCond().like("wfstepname", n_wfstepname_like);
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
	private String n_originalwfuserid_eq;//[源流程用户]
	public void setN_originalwfuserid_eq(String n_originalwfuserid_eq) {
        this.n_originalwfuserid_eq = n_originalwfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_originalwfuserid_eq)){
            this.getSelectCond().eq("originalwfuserid", n_originalwfuserid_eq);
        }
    }
	private String n_wfstepid_eq;//[步骤数据_相关步骤]
	public void setN_wfstepid_eq(String n_wfstepid_eq) {
        this.n_wfstepid_eq = n_wfstepid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepid_eq)){
            this.getSelectCond().eq("wfstepid", n_wfstepid_eq);
        }
    }
	private String n_wfinstanceid_eq;//[WFInstanceId]
	public void setN_wfinstanceid_eq(String n_wfinstanceid_eq) {
        this.n_wfinstanceid_eq = n_wfinstanceid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfinstanceid_eq)){
            this.getSelectCond().eq("wfinstanceid", n_wfinstanceid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfstepdataname",query);
		 }
	}
}




