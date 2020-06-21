package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocRule;
/**
 * 关系型数据实体[SocRule] 查询条件对象
 */
@Slf4j
@Data
public class SocRuleSearchContext extends QueryWrapperContext<SocRule> {

	private String n_socrulename_like;//[社保规则名称]
	public void setN_socrulename_like(String n_socrulename_like) {
        this.n_socrulename_like = n_socrulename_like;
        if(!ObjectUtils.isEmpty(this.n_socrulename_like)){
            this.getSearchCond().like("socrulename", n_socrulename_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private Integer n_nyear_eq;//[年度]
	public void setN_nyear_eq(Integer n_nyear_eq) {
        this.n_nyear_eq = n_nyear_eq;
        if(!ObjectUtils.isEmpty(this.n_nyear_eq)){
            this.getSearchCond().eq("nyear", n_nyear_eq);
        }
    }
	private String n_socareaid_eq;//[参保地标识]
	public void setN_socareaid_eq(String n_socareaid_eq) {
        this.n_socareaid_eq = n_socareaid_eq;
        if(!ObjectUtils.isEmpty(this.n_socareaid_eq)){
            this.getSearchCond().eq("socareaid", n_socareaid_eq);
        }
    }
	private String n_socareaname_eq;//[参保地]
	public void setN_socareaname_eq(String n_socareaname_eq) {
        this.n_socareaname_eq = n_socareaname_eq;
        if(!ObjectUtils.isEmpty(this.n_socareaname_eq)){
            this.getSearchCond().eq("socareaname", n_socareaname_eq);
        }
    }
	private String n_socareaname_like;//[参保地]
	public void setN_socareaname_like(String n_socareaname_like) {
        this.n_socareaname_like = n_socareaname_like;
        if(!ObjectUtils.isEmpty(this.n_socareaname_like)){
            this.getSearchCond().like("socareaname", n_socareaname_like);
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
            this.getSearchCond().and( wrapper ->
                     wrapper.like("socrulename", query)   
            );
		 }
	}
}




