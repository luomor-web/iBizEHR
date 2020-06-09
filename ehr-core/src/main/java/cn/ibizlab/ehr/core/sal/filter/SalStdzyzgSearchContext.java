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
import cn.ibizlab.ehr.core.sal.domain.SalStdzyzg;
/**
 * 关系型数据实体[SalStdzyzg] 查询条件对象
 */
@Slf4j
@Data
public class SalStdzyzgSearchContext extends QueryWrapperContext<SalStdzyzg> {

	private String n_salstdzyzgname_like;//[执业资格津贴标准名称]
	public void setN_salstdzyzgname_like(String n_salstdzyzgname_like) {
        this.n_salstdzyzgname_like = n_salstdzyzgname_like;
        if(!ObjectUtils.isEmpty(this.n_salstdzyzgname_like)){
            this.getSearchCond().like("salstdzyzgname", n_salstdzyzgname_like);
        }
    }
	private String n_zyfl_eq;//[专业分类]
	public void setN_zyfl_eq(String n_zyfl_eq) {
        this.n_zyfl_eq = n_zyfl_eq;
        if(!ObjectUtils.isEmpty(this.n_zyfl_eq)){
            this.getSearchCond().eq("zyfl", n_zyfl_eq);
        }
    }
	private String n_jbfl_eq;//[级别分类]
	public void setN_jbfl_eq(String n_jbfl_eq) {
        this.n_jbfl_eq = n_jbfl_eq;
        if(!ObjectUtils.isEmpty(this.n_jbfl_eq)){
            this.getSearchCond().eq("jbfl", n_jbfl_eq);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("salstdzyzgname", query)   
            );
		 }
	}
}




