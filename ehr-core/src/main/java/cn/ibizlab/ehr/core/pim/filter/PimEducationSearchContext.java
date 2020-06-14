package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimEducation;
/**
 * 关系型数据实体[PimEducation] 查询条件对象
 */
@Slf4j
@Data
public class PimEducationSearchContext extends QueryWrapperContext<PimEducation> {

	private String n_xkml_eq;//[一级学科]
	public void setN_xkml_eq(String n_xkml_eq) {
        this.n_xkml_eq = n_xkml_eq;
        if(!ObjectUtils.isEmpty(this.n_xkml_eq)){
            this.getSearchCond().eq("xkml", n_xkml_eq);
        }
    }
	private String n_sxzy_eq;//[所学专业]
	public void setN_sxzy_eq(String n_sxzy_eq) {
        this.n_sxzy_eq = n_sxzy_eq;
        if(!ObjectUtils.isEmpty(this.n_sxzy_eq)){
            this.getSearchCond().eq("sxzy", n_sxzy_eq);
        }
    }
	private String n_degree_eq;//[学位]
	public void setN_degree_eq(String n_degree_eq) {
        this.n_degree_eq = n_degree_eq;
        if(!ObjectUtils.isEmpty(this.n_degree_eq)){
            this.getSearchCond().eq("degree", n_degree_eq);
        }
    }
	private String n_xllx_eq;//[学习形式]
	public void setN_xllx_eq(String n_xllx_eq) {
        this.n_xllx_eq = n_xllx_eq;
        if(!ObjectUtils.isEmpty(this.n_xllx_eq)){
            this.getSearchCond().eq("xllx", n_xllx_eq);
        }
    }
	private String n_xxxz_eq;//[学校性质]
	public void setN_xxxz_eq(String n_xxxz_eq) {
        this.n_xxxz_eq = n_xxxz_eq;
        if(!ObjectUtils.isEmpty(this.n_xxxz_eq)){
            this.getSearchCond().eq("xxxz", n_xxxz_eq);
        }
    }
	private String n_pimeducationname_like;//[教育信息名称]
	public void setN_pimeducationname_like(String n_pimeducationname_like) {
        this.n_pimeducationname_like = n_pimeducationname_like;
        if(!ObjectUtils.isEmpty(this.n_pimeducationname_like)){
            this.getSearchCond().like("pimeducationname", n_pimeducationname_like);
        }
    }
	private String n_xl_eq;//[学历]
	public void setN_xl_eq(String n_xl_eq) {
        this.n_xl_eq = n_xl_eq;
        if(!ObjectUtils.isEmpty(this.n_xl_eq)){
            this.getSearchCond().eq("xl", n_xl_eq);
        }
    }
	private String n_pimpersonname_eq;//[员工名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工名称]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pimeducationname", query)   
            );
		 }
	}
}




