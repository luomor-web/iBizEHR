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
import cn.ibizlab.ehr.core.wf.domain.WFUserGroupDetail;
/**
 * 关系型数据实体[WFUserGroupDetail] 查询条件对象
 */
@Slf4j
@Data
public class WFUserGroupDetailSearchContext extends QueryWrapperContext<WFUserGroupDetail> {

	private String n_wfusergroupdetailname_like;//[工作流用户名称]
	public void setN_wfusergroupdetailname_like(String n_wfusergroupdetailname_like) {
        this.n_wfusergroupdetailname_like = n_wfusergroupdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_wfusergroupdetailname_like)){
            this.getSelectCond().like("wfusergroupdetailname", n_wfusergroupdetailname_like);
        }
    }
	private String n_wfusergroupname_eq;//[工作流用户组]
	public void setN_wfusergroupname_eq(String n_wfusergroupname_eq) {
        this.n_wfusergroupname_eq = n_wfusergroupname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfusergroupname_eq)){
            this.getSelectCond().eq("wfusergroupname", n_wfusergroupname_eq);
        }
    }
	private String n_wfusergroupname_like;//[工作流用户组]
	public void setN_wfusergroupname_like(String n_wfusergroupname_like) {
        this.n_wfusergroupname_like = n_wfusergroupname_like;
        if(!ObjectUtils.isEmpty(this.n_wfusergroupname_like)){
            this.getSelectCond().like("wfusergroupname", n_wfusergroupname_like);
        }
    }
	private String n_wfusername_eq;//[工作流用户]
	public void setN_wfusername_eq(String n_wfusername_eq) {
        this.n_wfusername_eq = n_wfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfusername_eq)){
            this.getSelectCond().eq("wfusername", n_wfusername_eq);
        }
    }
	private String n_wfusername_like;//[工作流用户]
	public void setN_wfusername_like(String n_wfusername_like) {
        this.n_wfusername_like = n_wfusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfusername_like)){
            this.getSelectCond().like("wfusername", n_wfusername_like);
        }
    }
	private String n_wfuserid_eq;//[用户]
	public void setN_wfuserid_eq(String n_wfuserid_eq) {
        this.n_wfuserid_eq = n_wfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfuserid_eq)){
            this.getSelectCond().eq("wfuserid", n_wfuserid_eq);
        }
    }
	private String n_wfusergroupid_eq;//[用户组]
	public void setN_wfusergroupid_eq(String n_wfusergroupid_eq) {
        this.n_wfusergroupid_eq = n_wfusergroupid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfusergroupid_eq)){
            this.getSelectCond().eq("wfusergroupid", n_wfusergroupid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfusergroupdetailname",query);
		 }
	}
}




