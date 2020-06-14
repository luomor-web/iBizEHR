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
import cn.ibizlab.ehr.core.par.domain.ParIntegralRule;
/**
 * 关系型数据实体[ParIntegralRule] 查询条件对象
 */
@Slf4j
@Data
public class ParIntegralRuleSearchContext extends QueryWrapperContext<ParIntegralRule> {

	private String n_parintegralrulename_like;//[积分规则名称]
	public void setN_parintegralrulename_like(String n_parintegralrulename_like) {
        this.n_parintegralrulename_like = n_parintegralrulename_like;
        if(!ObjectUtils.isEmpty(this.n_parintegralrulename_like)){
            this.getSearchCond().like("parintegralrulename", n_parintegralrulename_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_dj_eq;//[定级]
	public void setN_dj_eq(String n_dj_eq) {
        this.n_dj_eq = n_dj_eq;
        if(!ObjectUtils.isEmpty(this.n_dj_eq)){
            this.getSearchCond().eq("dj", n_dj_eq);
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
                     wrapper.like("parintegralrulename", query)   
            );
		 }
	}
}




