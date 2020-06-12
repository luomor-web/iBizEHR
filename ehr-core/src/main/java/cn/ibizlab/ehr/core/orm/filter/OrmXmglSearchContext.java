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
import cn.ibizlab.ehr.core.orm.domain.OrmXmgl;
/**
 * 关系型数据实体[OrmXmgl] 查询条件对象
 */
@Slf4j
@Data
public class OrmXmglSearchContext extends QueryWrapperContext<OrmXmgl> {

	private String n_isdirectlymanage_eq;//[是否局直管]
	public void setN_isdirectlymanage_eq(String n_isdirectlymanage_eq) {
        this.n_isdirectlymanage_eq = n_isdirectlymanage_eq;
        if(!ObjectUtils.isEmpty(this.n_isdirectlymanage_eq)){
            this.getSearchCond().eq("isdirectlymanage", n_isdirectlymanage_eq);
        }
    }
	private String n_project_name_like;//[项目名称]
	public void setN_project_name_like(String n_project_name_like) {
        this.n_project_name_like = n_project_name_like;
        if(!ObjectUtils.isEmpty(this.n_project_name_like)){
            this.getSearchCond().like("project_name", n_project_name_like);
        }
    }
	private String n_ormxmglname_like;//[项目名称]
	public void setN_ormxmglname_like(String n_ormxmglname_like) {
        this.n_ormxmglname_like = n_ormxmglname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmglname_like)){
            this.getSearchCond().like("ormxmglname", n_ormxmglname_like);
        }
    }
	private String n_engineeringbustype_eq;//[工程业务类型]
	public void setN_engineeringbustype_eq(String n_engineeringbustype_eq) {
        this.n_engineeringbustype_eq = n_engineeringbustype_eq;
        if(!ObjectUtils.isEmpty(this.n_engineeringbustype_eq)){
            this.getSearchCond().eq("engineeringbustype", n_engineeringbustype_eq);
        }
    }
	private String n_project_type_eq;//[项目类型]
	public void setN_project_type_eq(String n_project_type_eq) {
        this.n_project_type_eq = n_project_type_eq;
        if(!ObjectUtils.isEmpty(this.n_project_type_eq)){
            this.getSearchCond().eq("project_type", n_project_type_eq);
        }
    }
	private String n_engineeringscale_eq;//[工程规模]
	public void setN_engineeringscale_eq(String n_engineeringscale_eq) {
        this.n_engineeringscale_eq = n_engineeringscale_eq;
        if(!ObjectUtils.isEmpty(this.n_engineeringscale_eq)){
            this.getSearchCond().eq("engineeringscale", n_engineeringscale_eq);
        }
    }
	private String n_engineeringpurpose_eq;//[工程用途]
	public void setN_engineeringpurpose_eq(String n_engineeringpurpose_eq) {
        this.n_engineeringpurpose_eq = n_engineeringpurpose_eq;
        if(!ObjectUtils.isEmpty(this.n_engineeringpurpose_eq)){
            this.getSearchCond().eq("engineeringpurpose", n_engineeringpurpose_eq);
        }
    }
	private String n_procapitalatt_eq;//[项目资金属性]
	public void setN_procapitalatt_eq(String n_procapitalatt_eq) {
        this.n_procapitalatt_eq = n_procapitalatt_eq;
        if(!ObjectUtils.isEmpty(this.n_procapitalatt_eq)){
            this.getSearchCond().eq("procapitalatt", n_procapitalatt_eq);
        }
    }
	private String n_project_number_like;//[项目编号]
	public void setN_project_number_like(String n_project_number_like) {
        this.n_project_number_like = n_project_number_like;
        if(!ObjectUtils.isEmpty(this.n_project_number_like)){
            this.getSearchCond().like("project_number", n_project_number_like);
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
                     wrapper.like("project_name", query)   
            );
		 }
	}
}




