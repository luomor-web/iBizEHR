package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;
/**
 * 关系型数据实体[SalSchemeItem] 查询条件对象
 */
@Slf4j
@Data
public class SalSchemeItemSearchContext extends QueryWrapperContext<SalSchemeItem> {

	private String n_sitemtype_eq;//[要素项类型]
	public void setN_sitemtype_eq(String n_sitemtype_eq) {
        this.n_sitemtype_eq = n_sitemtype_eq;
        if(!ObjectUtils.isEmpty(this.n_sitemtype_eq)){
            this.getSearchCond().eq("sitemtype", n_sitemtype_eq);
        }
    }
	private String n_salschemeitemname_like;//[工资单要素项名称]
	public void setN_salschemeitemname_like(String n_salschemeitemname_like) {
        this.n_salschemeitemname_like = n_salschemeitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemname_like)){
            this.getSearchCond().like("salschemeitemname", n_salschemeitemname_like);
        }
    }
	private String n_sitemadd_eq;//[增/减]
	public void setN_sitemadd_eq(String n_sitemadd_eq) {
        this.n_sitemadd_eq = n_sitemadd_eq;
        if(!ObjectUtils.isEmpty(this.n_sitemadd_eq)){
            this.getSearchCond().eq("sitemadd", n_sitemadd_eq);
        }
    }
	private String n_salschemename_eq;//[工资单名称]
	public void setN_salschemename_eq(String n_salschemename_eq) {
        this.n_salschemename_eq = n_salschemename_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemename_eq)){
            this.getSearchCond().eq("salschemename", n_salschemename_eq);
        }
    }
	private String n_salschemename_like;//[工资单名称]
	public void setN_salschemename_like(String n_salschemename_like) {
        this.n_salschemename_like = n_salschemename_like;
        if(!ObjectUtils.isEmpty(this.n_salschemename_like)){
            this.getSearchCond().like("salschemename", n_salschemename_like);
        }
    }
	private String n_salrulename_eq;//[薪酬规则]
	public void setN_salrulename_eq(String n_salrulename_eq) {
        this.n_salrulename_eq = n_salrulename_eq;
        if(!ObjectUtils.isEmpty(this.n_salrulename_eq)){
            this.getSearchCond().eq("salrulename", n_salrulename_eq);
        }
    }
	private String n_salrulename_like;//[薪酬规则]
	public void setN_salrulename_like(String n_salrulename_like) {
        this.n_salrulename_like = n_salrulename_like;
        if(!ObjectUtils.isEmpty(this.n_salrulename_like)){
            this.getSearchCond().like("salrulename", n_salrulename_like);
        }
    }
	private String n_salitemname_eq;//[要素项]
	public void setN_salitemname_eq(String n_salitemname_eq) {
        this.n_salitemname_eq = n_salitemname_eq;
        if(!ObjectUtils.isEmpty(this.n_salitemname_eq)){
            this.getSearchCond().eq("salitemname", n_salitemname_eq);
        }
    }
	private String n_salitemname_like;//[要素项]
	public void setN_salitemname_like(String n_salitemname_like) {
        this.n_salitemname_like = n_salitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salitemname_like)){
            this.getSearchCond().like("salitemname", n_salitemname_like);
        }
    }
	private String n_salschemeid_eq;//[工资单标识]
	public void setN_salschemeid_eq(String n_salschemeid_eq) {
        this.n_salschemeid_eq = n_salschemeid_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeid_eq)){
            this.getSearchCond().eq("salschemeid", n_salschemeid_eq);
        }
    }
	private String n_salruleid_eq;//[薪酬规则标识]
	public void setN_salruleid_eq(String n_salruleid_eq) {
        this.n_salruleid_eq = n_salruleid_eq;
        if(!ObjectUtils.isEmpty(this.n_salruleid_eq)){
            this.getSearchCond().eq("salruleid", n_salruleid_eq);
        }
    }
	private String n_salitemid_eq;//[薪酬要素项标识]
	public void setN_salitemid_eq(String n_salitemid_eq) {
        this.n_salitemid_eq = n_salitemid_eq;
        if(!ObjectUtils.isEmpty(this.n_salitemid_eq)){
            this.getSearchCond().eq("salitemid", n_salitemid_eq);
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
                     wrapper.like("salitemname", query)   
            );
		 }
	}
}




