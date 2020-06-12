package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmb;
/**
 * 关系型数据实体[ParPtryndlhmb] 查询条件对象
 */
@Slf4j
@Data
public class ParPtryndlhmbSearchContext extends QueryWrapperContext<ParPtryndlhmb> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_jxjd_eq;//[当前阶段]
	public void setN_jxjd_eq(String n_jxjd_eq) {
        this.n_jxjd_eq = n_jxjd_eq;
        if(!ObjectUtils.isEmpty(this.n_jxjd_eq)){
            this.getSearchCond().eq("jxjd", n_jxjd_eq);
        }
    }
	private String n_parptryndlhmbname_like;//[年度量化目标（部门副职及以下人员）名称]
	public void setN_parptryndlhmbname_like(String n_parptryndlhmbname_like) {
        this.n_parptryndlhmbname_like = n_parptryndlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parptryndlhmbname_like)){
            this.getSearchCond().like("parptryndlhmbname", n_parptryndlhmbname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[员工ID]
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
                     wrapper.like("parptryndlhmbname", query)   
            );
		 }
	}
}




