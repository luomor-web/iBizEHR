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
import cn.ibizlab.ehr.core.pim.domain.PimFaminfo;
/**
 * 关系型数据实体[PimFaminfo] 查询条件对象
 */
@Slf4j
@Data
public class PimFaminfoSearchContext extends QueryWrapperContext<PimFaminfo> {

	private String n_jlss_eq;//[记录所属]
	public void setN_jlss_eq(String n_jlss_eq) {
        this.n_jlss_eq = n_jlss_eq;
        if(!ObjectUtils.isEmpty(this.n_jlss_eq)){
            this.getSearchCond().eq("jlss", n_jlss_eq);
        }
    }
	private String n_sfjjllr_eq;//[是否紧急联络人]
	public void setN_sfjjllr_eq(String n_sfjjllr_eq) {
        this.n_sfjjllr_eq = n_sfjjllr_eq;
        if(!ObjectUtils.isEmpty(this.n_sfjjllr_eq)){
            this.getSearchCond().eq("sfjjllr", n_sfjjllr_eq);
        }
    }
	private String n_zzmm_eq;//[政治面貌]
	public void setN_zzmm_eq(String n_zzmm_eq) {
        this.n_zzmm_eq = n_zzmm_eq;
        if(!ObjectUtils.isEmpty(this.n_zzmm_eq)){
            this.getSearchCond().eq("zzmm", n_zzmm_eq);
        }
    }
	private String n_pimfaminfoname_like;//[姓名]
	public void setN_pimfaminfoname_like(String n_pimfaminfoname_like) {
        this.n_pimfaminfoname_like = n_pimfaminfoname_like;
        if(!ObjectUtils.isEmpty(this.n_pimfaminfoname_like)){
            this.getSearchCond().like("pimfaminfoname", n_pimfaminfoname_like);
        }
    }
	private String n_zjlx_eq;//[证件类型]
	public void setN_zjlx_eq(String n_zjlx_eq) {
        this.n_zjlx_eq = n_zjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zjlx_eq)){
            this.getSearchCond().eq("zjlx", n_zjlx_eq);
        }
    }
	private String n_ybrgx_eq;//[与本人关系]
	public void setN_ybrgx_eq(String n_ybrgx_eq) {
        this.n_ybrgx_eq = n_ybrgx_eq;
        if(!ObjectUtils.isEmpty(this.n_ybrgx_eq)){
            this.getSearchCond().eq("ybrgx", n_ybrgx_eq);
        }
    }
	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
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
                     wrapper.like("pimfaminfoname", query)   
            );
		 }
	}
}




