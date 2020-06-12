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
import cn.ibizlab.ehr.core.vac.domain.VacHolidayRules;
/**
 * 关系型数据实体[VacHolidayRules] 查询条件对象
 */
@Slf4j
@Data
public class VacHolidayRulesSearchContext extends QueryWrapperContext<VacHolidayRules> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_vacholidayrulesname_like;//[考勤规则名称]
	public void setN_vacholidayrulesname_like(String n_vacholidayrulesname_like) {
        this.n_vacholidayrulesname_like = n_vacholidayrulesname_like;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesname_like)){
            this.getSearchCond().like("vacholidayrulesname", n_vacholidayrulesname_like);
        }
    }
	private String n_sfqy_eq;//[是否启用]
	public void setN_sfqy_eq(String n_sfqy_eq) {
        this.n_sfqy_eq = n_sfqy_eq;
        if(!ObjectUtils.isEmpty(this.n_sfqy_eq)){
            this.getSearchCond().eq("sfqy", n_sfqy_eq);
        }
    }
	private String n_tszxjzz_eq;//[推送至下级组织]
	public void setN_tszxjzz_eq(String n_tszxjzz_eq) {
        this.n_tszxjzz_eq = n_tszxjzz_eq;
        if(!ObjectUtils.isEmpty(this.n_tszxjzz_eq)){
            this.getSearchCond().eq("tszxjzz", n_tszxjzz_eq);
        }
    }
	private String n_defaultrule_eq;//[默认规则]
	public void setN_defaultrule_eq(String n_defaultrule_eq) {
        this.n_defaultrule_eq = n_defaultrule_eq;
        if(!ObjectUtils.isEmpty(this.n_defaultrule_eq)){
            this.getSearchCond().eq("defaultrule", n_defaultrule_eq);
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
                     wrapper.like("vacholidayrulesname", query)   
            );
		 }
	}
}




