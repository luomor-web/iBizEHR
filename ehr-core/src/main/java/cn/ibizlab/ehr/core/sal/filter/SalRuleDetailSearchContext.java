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
import cn.ibizlab.ehr.core.sal.domain.SalRuleDetail;
/**
 * 关系型数据实体[SalRuleDetail] 查询条件对象
 */
@Slf4j
@Data
public class SalRuleDetailSearchContext extends QueryWrapperContext<SalRuleDetail> {

	private String n_salruledetailname_like;//[薪酬规则明细名称]
	public void setN_salruledetailname_like(String n_salruledetailname_like) {
        this.n_salruledetailname_like = n_salruledetailname_like;
        if(!ObjectUtils.isEmpty(this.n_salruledetailname_like)){
            this.getSearchCond().like("salruledetailname", n_salruledetailname_like);
        }
    }
	private String n_checkrule_eq;//[比较规则]
	public void setN_checkrule_eq(String n_checkrule_eq) {
        this.n_checkrule_eq = n_checkrule_eq;
        if(!ObjectUtils.isEmpty(this.n_checkrule_eq)){
            this.getSearchCond().eq("checkrule", n_checkrule_eq);
        }
    }
	private String n_salrulename_eq;//[薪酬规则名称]
	public void setN_salrulename_eq(String n_salrulename_eq) {
        this.n_salrulename_eq = n_salrulename_eq;
        if(!ObjectUtils.isEmpty(this.n_salrulename_eq)){
            this.getSearchCond().eq("salrulename", n_salrulename_eq);
        }
    }
	private String n_salrulename_like;//[薪酬规则名称]
	public void setN_salrulename_like(String n_salrulename_like) {
        this.n_salrulename_like = n_salrulename_like;
        if(!ObjectUtils.isEmpty(this.n_salrulename_like)){
            this.getSearchCond().like("salrulename", n_salrulename_like);
        }
    }
	private String n_salparamname_eq;//[薪酬计算指标(原值)]
	public void setN_salparamname_eq(String n_salparamname_eq) {
        this.n_salparamname_eq = n_salparamname_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamname_eq)){
            this.getSearchCond().eq("salparamname", n_salparamname_eq);
        }
    }
	private String n_salparamname_like;//[薪酬计算指标(原值)]
	public void setN_salparamname_like(String n_salparamname_like) {
        this.n_salparamname_like = n_salparamname_like;
        if(!ObjectUtils.isEmpty(this.n_salparamname_like)){
            this.getSearchCond().like("salparamname", n_salparamname_like);
        }
    }
	private String n_salparamname2_eq;//[薪酬计算指标(对应值)]
	public void setN_salparamname2_eq(String n_salparamname2_eq) {
        this.n_salparamname2_eq = n_salparamname2_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamname2_eq)){
            this.getSearchCond().eq("salparamname2", n_salparamname2_eq);
        }
    }
	private String n_salparamname2_like;//[薪酬计算指标(对应值)]
	public void setN_salparamname2_like(String n_salparamname2_like) {
        this.n_salparamname2_like = n_salparamname2_like;
        if(!ObjectUtils.isEmpty(this.n_salparamname2_like)){
            this.getSearchCond().like("salparamname2", n_salparamname2_like);
        }
    }
	private String n_salparamid_eq;//[薪酬计算指标标识]
	public void setN_salparamid_eq(String n_salparamid_eq) {
        this.n_salparamid_eq = n_salparamid_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamid_eq)){
            this.getSearchCond().eq("salparamid", n_salparamid_eq);
        }
    }
	private String n_salruleid_eq;//[薪酬规则标识]
	public void setN_salruleid_eq(String n_salruleid_eq) {
        this.n_salruleid_eq = n_salruleid_eq;
        if(!ObjectUtils.isEmpty(this.n_salruleid_eq)){
            this.getSearchCond().eq("salruleid", n_salruleid_eq);
        }
    }
	private String n_salparamid2_eq;//[薪酬计算指标标识]
	public void setN_salparamid2_eq(String n_salparamid2_eq) {
        this.n_salparamid2_eq = n_salparamid2_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamid2_eq)){
            this.getSearchCond().eq("salparamid2", n_salparamid2_eq);
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
                     wrapper.like("salruledetailname", query)   
            );
		 }
	}
}




