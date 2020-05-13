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
import cn.ibizlab.ehr.core.wf.domain.WFUserAssist;
/**
 * 关系型数据实体[WFUserAssist] 查询条件对象
 */
@Slf4j
@Data
public class WFUserAssistSearchContext extends QueryWrapperContext<WFUserAssist> {

	private String n_wfuserassistname_like;//[工作流用户代办名称]
	public void setN_wfuserassistname_like(String n_wfuserassistname_like) {
        this.n_wfuserassistname_like = n_wfuserassistname_like;
        if(!ObjectUtils.isEmpty(this.n_wfuserassistname_like)){
            this.getSelectCond().like("wfuserassistname", n_wfuserassistname_like);
        }
    }
	private String n_wfmajorusername_eq;//[工作流用户]
	public void setN_wfmajorusername_eq(String n_wfmajorusername_eq) {
        this.n_wfmajorusername_eq = n_wfmajorusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfmajorusername_eq)){
            this.getSelectCond().eq("wfmajorusername", n_wfmajorusername_eq);
        }
    }
	private String n_wfmajorusername_like;//[工作流用户]
	public void setN_wfmajorusername_like(String n_wfmajorusername_like) {
        this.n_wfmajorusername_like = n_wfmajorusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfmajorusername_like)){
            this.getSelectCond().like("wfmajorusername", n_wfmajorusername_like);
        }
    }
	private String n_wfminorusername_eq;//[工作流代办用户]
	public void setN_wfminorusername_eq(String n_wfminorusername_eq) {
        this.n_wfminorusername_eq = n_wfminorusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfminorusername_eq)){
            this.getSelectCond().eq("wfminorusername", n_wfminorusername_eq);
        }
    }
	private String n_wfminorusername_like;//[工作流代办用户]
	public void setN_wfminorusername_like(String n_wfminorusername_like) {
        this.n_wfminorusername_like = n_wfminorusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfminorusername_like)){
            this.getSelectCond().like("wfminorusername", n_wfminorusername_like);
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
	private String n_wfminoruserid_eq;//[工作流代办用户]
	public void setN_wfminoruserid_eq(String n_wfminoruserid_eq) {
        this.n_wfminoruserid_eq = n_wfminoruserid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfminoruserid_eq)){
            this.getSelectCond().eq("wfminoruserid", n_wfminoruserid_eq);
        }
    }
	private String n_wfworkflowid_eq;//[工作流]
	public void setN_wfworkflowid_eq(String n_wfworkflowid_eq) {
        this.n_wfworkflowid_eq = n_wfworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowid_eq)){
            this.getSelectCond().eq("wfworkflowid", n_wfworkflowid_eq);
        }
    }
	private String n_wfmajoruserid_eq;//[工作流用户]
	public void setN_wfmajoruserid_eq(String n_wfmajoruserid_eq) {
        this.n_wfmajoruserid_eq = n_wfmajoruserid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfmajoruserid_eq)){
            this.getSelectCond().eq("wfmajoruserid", n_wfmajoruserid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfuserassistname",query);
		 }
	}
}




