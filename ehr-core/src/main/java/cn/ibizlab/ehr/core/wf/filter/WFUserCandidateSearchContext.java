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
import cn.ibizlab.ehr.core.wf.domain.WFUserCandidate;
/**
 * 关系型数据实体[WFUserCandidate] 查询条件对象
 */
@Slf4j
@Data
public class WFUserCandidateSearchContext extends QueryWrapperContext<WFUserCandidate> {

	private String n_wfusercandidatename_like;//[工作流用户候选者名称]
	public void setN_wfusercandidatename_like(String n_wfusercandidatename_like) {
        this.n_wfusercandidatename_like = n_wfusercandidatename_like;
        if(!ObjectUtils.isEmpty(this.n_wfusercandidatename_like)){
            this.getSelectCond().like("wfusercandidatename", n_wfusercandidatename_like);
        }
    }
	private String n_wfmajorusername_eq;//[工作流主用户]
	public void setN_wfmajorusername_eq(String n_wfmajorusername_eq) {
        this.n_wfmajorusername_eq = n_wfmajorusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfmajorusername_eq)){
            this.getSelectCond().eq("wfmajorusername", n_wfmajorusername_eq);
        }
    }
	private String n_wfmajorusername_like;//[工作流主用户]
	public void setN_wfmajorusername_like(String n_wfmajorusername_like) {
        this.n_wfmajorusername_like = n_wfmajorusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfmajorusername_like)){
            this.getSelectCond().like("wfmajorusername", n_wfmajorusername_like);
        }
    }
	private String n_wfminorusername_eq;//[工作流候选用户]
	public void setN_wfminorusername_eq(String n_wfminorusername_eq) {
        this.n_wfminorusername_eq = n_wfminorusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfminorusername_eq)){
            this.getSelectCond().eq("wfminorusername", n_wfminorusername_eq);
        }
    }
	private String n_wfminorusername_like;//[工作流候选用户]
	public void setN_wfminorusername_like(String n_wfminorusername_like) {
        this.n_wfminorusername_like = n_wfminorusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfminorusername_like)){
            this.getSelectCond().like("wfminorusername", n_wfminorusername_like);
        }
    }
	private String n_wfminoruserid_eq;//[工作流候选用户]
	public void setN_wfminoruserid_eq(String n_wfminoruserid_eq) {
        this.n_wfminoruserid_eq = n_wfminoruserid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfminoruserid_eq)){
            this.getSelectCond().eq("wfminoruserid", n_wfminoruserid_eq);
        }
    }
	private String n_wfmajoruserid_eq;//[工作流主用户]
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
			this.getSelectCond().or().like("wfusercandidatename",query);
		 }
	}
}




