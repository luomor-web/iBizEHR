package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqjh;
/**
 * 关系型数据实体[OrmXmxqjh] 查询条件对象
 */
@Slf4j
@Data
public class OrmXmxqjhSearchContext extends QueryWrapperContext<OrmXmxqjh> {

	private String n_approvalstatus_eq;//[审批状态]
	public void setN_approvalstatus_eq(String n_approvalstatus_eq) {
        this.n_approvalstatus_eq = n_approvalstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_approvalstatus_eq)){
            this.getSearchCond().eq("approvalstatus", n_approvalstatus_eq);
        }
    }
	private String n_xmlx_eq;//[项目类型]
	public void setN_xmlx_eq(String n_xmlx_eq) {
        this.n_xmlx_eq = n_xmlx_eq;
        if(!ObjectUtils.isEmpty(this.n_xmlx_eq)){
            this.getSearchCond().eq("xmlx", n_xmlx_eq);
        }
    }
	private String n_ormxmxqjhname_like;//[项目需求计划名称]
	public void setN_ormxmxqjhname_like(String n_ormxmxqjhname_like) {
        this.n_ormxmxqjhname_like = n_ormxmxqjhname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmxqjhname_like)){
            this.getSearchCond().like("ormxmxqjhname", n_ormxmxqjhname_like);
        }
    }
	private String n_editionstate_eq;//[版本状态]
	public void setN_editionstate_eq(String n_editionstate_eq) {
        this.n_editionstate_eq = n_editionstate_eq;
        if(!ObjectUtils.isEmpty(this.n_editionstate_eq)){
            this.getSearchCond().eq("editionstate", n_editionstate_eq);
        }
    }
	private String n_xmblx_eq;//[项目部类型]
	public void setN_xmblx_eq(String n_xmblx_eq) {
        this.n_xmblx_eq = n_xmblx_eq;
        if(!ObjectUtils.isEmpty(this.n_xmblx_eq)){
            this.getSearchCond().eq("xmblx", n_xmblx_eq);
        }
    }
	private String n_ormxmglname_eq;//[项目名称]
	public void setN_ormxmglname_eq(String n_ormxmglname_eq) {
        this.n_ormxmglname_eq = n_ormxmglname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormxmglname_eq)){
            this.getSearchCond().eq("ormxmglname", n_ormxmglname_eq);
        }
    }
	private String n_ormxmglname_like;//[项目名称]
	public void setN_ormxmglname_like(String n_ormxmglname_like) {
        this.n_ormxmglname_like = n_ormxmglname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmglname_like)){
            this.getSearchCond().like("ormxmglname", n_ormxmglname_like);
        }
    }
	private String n_pimpersonname_eq;//[项目负责人]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[项目负责人]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[项目负责人ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormxmglid_eq;//[项目ID]
	public void setN_ormxmglid_eq(String n_ormxmglid_eq) {
        this.n_ormxmglid_eq = n_ormxmglid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormxmglid_eq)){
            this.getSearchCond().eq("ormxmglid", n_ormxmglid_eq);
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
                     wrapper.like("ormxmxqjhname", query)   
            );
		 }
	}
}




