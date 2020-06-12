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
import cn.ibizlab.ehr.core.par.domain.ParJzszpsjg;
/**
 * 关系型数据实体[ParJzszpsjg] 查询条件对象
 */
@Slf4j
@Data
public class ParJzszpsjgSearchContext extends QueryWrapperContext<ParJzszpsjg> {

	private String n_parjzszpsjgname_like;//[集中述职评审结果名称]
	public void setN_parjzszpsjgname_like(String n_parjzszpsjgname_like) {
        this.n_parjzszpsjgname_like = n_parjzszpsjgname_like;
        if(!ObjectUtils.isEmpty(this.n_parjzszpsjgname_like)){
            this.getSearchCond().like("parjzszpsjgname", n_parjzszpsjgname_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_khdx_eq;//[考核对象]
	public void setN_khdx_eq(String n_khdx_eq) {
        this.n_khdx_eq = n_khdx_eq;
        if(!ObjectUtils.isEmpty(this.n_khdx_eq)){
            this.getSearchCond().eq("khdx", n_khdx_eq);
        }
    }
	private String n_pimpersonname_eq;//[领导姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[领导姓名]
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
                     wrapper.like("parjzszpsjgname", query)   
            );
		 }
	}
}




