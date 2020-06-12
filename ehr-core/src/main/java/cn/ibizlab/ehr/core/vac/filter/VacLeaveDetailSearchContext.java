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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveDetail;
/**
 * 关系型数据实体[VacLeaveDetail] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaveDetailSearchContext extends QueryWrapperContext<VacLeaveDetail> {

	private String n_hyzk_eq;//[婚姻状况]
	public void setN_hyzk_eq(String n_hyzk_eq) {
        this.n_hyzk_eq = n_hyzk_eq;
        if(!ObjectUtils.isEmpty(this.n_hyzk_eq)){
            this.getSearchCond().eq("hyzk", n_hyzk_eq);
        }
    }
	private String n_vacleavedetailname_like;//[请销假明细名称]
	public void setN_vacleavedetailname_like(String n_vacleavedetailname_like) {
        this.n_vacleavedetailname_like = n_vacleavedetailname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavedetailname_like)){
            this.getSearchCond().like("vacleavedetailname", n_vacleavedetailname_like);
        }
    }
	private String n_qjzl_eq;//[请假种类]
	public void setN_qjzl_eq(String n_qjzl_eq) {
        this.n_qjzl_eq = n_qjzl_eq;
        if(!ObjectUtils.isEmpty(this.n_qjzl_eq)){
            this.getSearchCond().eq("qjzl", n_qjzl_eq);
        }
    }
	private String n_jhjssxw_eq;//[计划结束上下午]
	public void setN_jhjssxw_eq(String n_jhjssxw_eq) {
        this.n_jhjssxw_eq = n_jhjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhjssxw_eq)){
            this.getSearchCond().eq("jhjssxw", n_jhjssxw_eq);
        }
    }
	private String n_jhkssxw_eq;//[计划开始上下午]
	public void setN_jhkssxw_eq(String n_jhkssxw_eq) {
        this.n_jhkssxw_eq = n_jhkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhkssxw_eq)){
            this.getSearchCond().eq("jhkssxw", n_jhkssxw_eq);
        }
    }
	private String n_tqlx_eq;//[探亲类型]
	public void setN_tqlx_eq(String n_tqlx_eq) {
        this.n_tqlx_eq = n_tqlx_eq;
        if(!ObjectUtils.isEmpty(this.n_tqlx_eq)){
            this.getSearchCond().eq("tqlx", n_tqlx_eq);
        }
    }
	private String n_sjjssxw_eq;//[实际结束上下午]
	public void setN_sjjssxw_eq(String n_sjjssxw_eq) {
        this.n_sjjssxw_eq = n_sjjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjjssxw_eq)){
            this.getSearchCond().eq("sjjssxw", n_sjjssxw_eq);
        }
    }
	private String n_sjkssxw_eq;//[实际开始上下午]
	public void setN_sjkssxw_eq(String n_sjkssxw_eq) {
        this.n_sjkssxw_eq = n_sjkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjkssxw_eq)){
            this.getSearchCond().eq("sjkssxw", n_sjkssxw_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
	private String n_state_eq;//[状态]
	public void setN_state_eq(String n_state_eq) {
        this.n_state_eq = n_state_eq;
        if(!ObjectUtils.isEmpty(this.n_state_eq)){
            this.getSearchCond().eq("state", n_state_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
		 }
	}
}




