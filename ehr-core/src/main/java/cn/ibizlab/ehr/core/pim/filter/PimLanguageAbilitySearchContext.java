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
import cn.ibizlab.ehr.core.pim.domain.PimLanguageAbility;
/**
 * 关系型数据实体[PimLanguageAbility] 查询条件对象
 */
@Slf4j
@Data
public class PimLanguageAbilitySearchContext extends QueryWrapperContext<PimLanguageAbility> {

	private String n_wyyz_eq;//[语种]
	public void setN_wyyz_eq(String n_wyyz_eq) {
        this.n_wyyz_eq = n_wyyz_eq;
        if(!ObjectUtils.isEmpty(this.n_wyyz_eq)){
            this.getSearchCond().eq("wyyz", n_wyyz_eq);
        }
    }
	private String n_jlss_eq;//[记录所属]
	public void setN_jlss_eq(String n_jlss_eq) {
        this.n_jlss_eq = n_jlss_eq;
        if(!ObjectUtils.isEmpty(this.n_jlss_eq)){
            this.getSearchCond().eq("jlss", n_jlss_eq);
        }
    }
	private String n_wydj_eq;//[外语等级]
	public void setN_wydj_eq(String n_wydj_eq) {
        this.n_wydj_eq = n_wydj_eq;
        if(!ObjectUtils.isEmpty(this.n_wydj_eq)){
            this.getSearchCond().eq("wydj", n_wydj_eq);
        }
    }
	private String n_pimlanguageabilityname_like;//[语种]
	public void setN_pimlanguageabilityname_like(String n_pimlanguageabilityname_like) {
        this.n_pimlanguageabilityname_like = n_pimlanguageabilityname_like;
        if(!ObjectUtils.isEmpty(this.n_pimlanguageabilityname_like)){
            this.getSearchCond().like("pimlanguageabilityname", n_pimlanguageabilityname_like);
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
                     wrapper.like("pimlanguageabilityname", query)   
            );
		 }
	}
}




