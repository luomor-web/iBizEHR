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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveManage;
/**
 * 关系型数据实体[VacLeaveManage] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaveManageSearchContext extends QueryWrapperContext<VacLeaveManage> {

	private String n_vacleavemanagename_like;//[请假管理名称]
	public void setN_vacleavemanagename_like(String n_vacleavemanagename_like) {
        this.n_vacleavemanagename_like = n_vacleavemanagename_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavemanagename_like)){
            this.getSearchCond().like("vacleavemanagename", n_vacleavemanagename_like);
        }
    }
	private String n_jhkssxw_eq;//[计划开始上下午]
	public void setN_jhkssxw_eq(String n_jhkssxw_eq) {
        this.n_jhkssxw_eq = n_jhkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhkssxw_eq)){
            this.getSearchCond().eq("jhkssxw", n_jhkssxw_eq);
        }
    }
	private String n_qjzl_eq;//[请假种类]
	public void setN_qjzl_eq(String n_qjzl_eq) {
        this.n_qjzl_eq = n_qjzl_eq;
        if(!ObjectUtils.isEmpty(this.n_qjzl_eq)){
            this.getSearchCond().eq("qjzl", n_qjzl_eq);
        }
    }
	private String n_wfqqjstate_eq;//[请销假状态]
	public void setN_wfqqjstate_eq(String n_wfqqjstate_eq) {
        this.n_wfqqjstate_eq = n_wfqqjstate_eq;
        if(!ObjectUtils.isEmpty(this.n_wfqqjstate_eq)){
            this.getSearchCond().eq("wfqqjstate", n_wfqqjstate_eq);
        }
    }
	private String n_sjkssxw_eq;//[实际开始上下午]
	public void setN_sjkssxw_eq(String n_sjkssxw_eq) {
        this.n_sjkssxw_eq = n_sjkssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjkssxw_eq)){
            this.getSearchCond().eq("sjkssxw", n_sjkssxw_eq);
        }
    }
	private String n_jhjssxw_eq;//[计划结束上下午]
	public void setN_jhjssxw_eq(String n_jhjssxw_eq) {
        this.n_jhjssxw_eq = n_jhjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_jhjssxw_eq)){
            this.getSearchCond().eq("jhjssxw", n_jhjssxw_eq);
        }
    }
	private String n_sjjssxw_eq;//[实际结束上下午]
	public void setN_sjjssxw_eq(String n_sjjssxw_eq) {
        this.n_sjjssxw_eq = n_sjjssxw_eq;
        if(!ObjectUtils.isEmpty(this.n_sjjssxw_eq)){
            this.getSearchCond().eq("sjjssxw", n_sjjssxw_eq);
        }
    }
	private String n_ormorgsectorname_eq;//[部门/项目部]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门/项目部]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_pimpersonname_eq;//[请假人员]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[请假人员]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
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
                     wrapper.like("pimpersonname", query)   
            );
		 }
	}
}




