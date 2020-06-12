package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VacSystemApplication;
/**
 * 关系型数据实体[VacSystemApplication] 查询条件对象
 */
@Slf4j
@Data
public class VacSystemApplicationSearchContext extends QueryWrapperContext<VacSystemApplication> {

	private String n_vacsystemapplicationname_like;//[制度适用名称]
	public void setN_vacsystemapplicationname_like(String n_vacsystemapplicationname_like) {
        this.n_vacsystemapplicationname_like = n_vacsystemapplicationname_like;
        if(!ObjectUtils.isEmpty(this.n_vacsystemapplicationname_like)){
            this.getSearchCond().like("vacsystemapplicationname", n_vacsystemapplicationname_like);
        }
    }
	private String n_vacleavesystemname_eq;//[模板名称]
	public void setN_vacleavesystemname_eq(String n_vacleavesystemname_eq) {
        this.n_vacleavesystemname_eq = n_vacleavesystemname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemname_eq)){
            this.getSearchCond().eq("vacleavesystemname", n_vacleavesystemname_eq);
        }
    }
	private String n_vacleavesystemname_like;//[模板名称]
	public void setN_vacleavesystemname_like(String n_vacleavesystemname_like) {
        this.n_vacleavesystemname_like = n_vacleavesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemname_like)){
            this.getSearchCond().like("vacleavesystemname", n_vacleavesystemname_like);
        }
    }
	private String n_pimpersonname_eq;//[人员信息名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[人员信息名称]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_vacleavesystemid_eq;//[休假制度管理标识]
	public void setN_vacleavesystemid_eq(String n_vacleavesystemid_eq) {
        this.n_vacleavesystemid_eq = n_vacleavesystemid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavesystemid_eq)){
            this.getSearchCond().eq("vacleavesystemid", n_vacleavesystemid_eq);
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
                     wrapper.like("vacsystemapplicationname", query)   
            );
		 }
	}
}




