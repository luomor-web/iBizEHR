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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVEDETAIL;
/**
 * 关系型数据实体[VACLEAVEDETAIL] 查询条件对象
 */
@Slf4j
@Data
public class VACLEAVEDETAILSearchContext extends QueryWrapperContext<VACLEAVEDETAIL> {

	private String n_hyzk_eq;//[婚姻状况]
	public void setN_hyzk_eq(String n_hyzk_eq) {
        this.n_hyzk_eq = n_hyzk_eq;
        if(!ObjectUtils.isEmpty(this.n_hyzk_eq)){
            this.getSelectCond().eq("hyzk", n_hyzk_eq);
        }
    }
	private String n_vacleavedetailname_like;//[请销假明细名称]
	public void setN_vacleavedetailname_like(String n_vacleavedetailname_like) {
        this.n_vacleavedetailname_like = n_vacleavedetailname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavedetailname_like)){
            this.getSelectCond().like("vacleavedetailname", n_vacleavedetailname_like);
        }
    }
	private String n_qjzl_eq;//[请假种类]
	public void setN_qjzl_eq(String n_qjzl_eq) {
        this.n_qjzl_eq = n_qjzl_eq;
        if(!ObjectUtils.isEmpty(this.n_qjzl_eq)){
            this.getSelectCond().eq("qjzl", n_qjzl_eq);
        }
    }
	private String n_jhjssxw_eq;//[计划结束上下午]
	public void setN_jhjssxw_eq(String n_jhjssxw_eq) {
        this.n_jhjssxw_eq = n_jhjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhjssxw_eq)){
            this.getSelectCond().eq("jhjssxw", n_jhjssxw_eq);
        }
    }
	private String n_jhkssxw_eq;//[计划开始上下午]
	public void setN_jhkssxw_eq(String n_jhkssxw_eq) {
        this.n_jhkssxw_eq = n_jhkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhkssxw_eq)){
            this.getSelectCond().eq("jhkssxw", n_jhkssxw_eq);
        }
    }
	private String n_tqlx_eq;//[探亲类型]
	public void setN_tqlx_eq(String n_tqlx_eq) {
        this.n_tqlx_eq = n_tqlx_eq;
        if(!ObjectUtils.isEmpty(this.n_tqlx_eq)){
            this.getSelectCond().eq("tqlx", n_tqlx_eq);
        }
    }
	private String n_sjjssxw_eq;//[实际结束上下午]
	public void setN_sjjssxw_eq(String n_sjjssxw_eq) {
        this.n_sjjssxw_eq = n_sjjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjjssxw_eq)){
            this.getSelectCond().eq("sjjssxw", n_sjjssxw_eq);
        }
    }
	private String n_sjkssxw_eq;//[实际开始上下午]
	public void setN_sjkssxw_eq(String n_sjkssxw_eq) {
        this.n_sjkssxw_eq = n_sjkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjkssxw_eq)){
            this.getSelectCond().eq("sjkssxw", n_sjkssxw_eq);
        }
    }
	private String n_vacleavemanagename_eq;//[请销假管理名称]
	public void setN_vacleavemanagename_eq(String n_vacleavemanagename_eq) {
        this.n_vacleavemanagename_eq = n_vacleavemanagename_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavemanagename_eq)){
            this.getSelectCond().eq("vacleavemanagename", n_vacleavemanagename_eq);
        }
    }
	private String n_vacleavemanagename_like;//[请销假管理名称]
	public void setN_vacleavemanagename_like(String n_vacleavemanagename_like) {
        this.n_vacleavemanagename_like = n_vacleavemanagename_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavemanagename_like)){
            this.getSelectCond().like("vacleavemanagename", n_vacleavemanagename_like);
        }
    }
	private String n_vacleavemanageid_eq;//[请销假管理标识]
	public void setN_vacleavemanageid_eq(String n_vacleavemanageid_eq) {
        this.n_vacleavemanageid_eq = n_vacleavemanageid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavemanageid_eq)){
            this.getSelectCond().eq("vacleavemanageid", n_vacleavemanageid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("vacleavedetailname", query)   
            );
		 }
	}
}




