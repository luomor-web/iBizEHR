package cn.ibizlab.ehr.core.sal.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.sal.domain.SALRULE;
/**
 * 关系型数据实体[SALRULE] 查询条件对象
 */
@Slf4j
@Data
public class SALRULESearchContext extends QueryWrapperContext<SALRULE> {

	private String n_salrulename_like;//[薪酬规则名称]
	public void setN_salrulename_like(String n_salrulename_like) {
        this.n_salrulename_like = n_salrulename_like;
        if(!ObjectUtils.isEmpty(this.n_salrulename_like)){
            this.getSelectCond().like("salrulename", n_salrulename_like);
        }
    }
	private String n_salparamname_eq;//[薪酬计算指标名称]
	public void setN_salparamname_eq(String n_salparamname_eq) {
        this.n_salparamname_eq = n_salparamname_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamname_eq)){
            this.getSelectCond().eq("salparamname", n_salparamname_eq);
        }
    }
	private String n_salparamname_like;//[薪酬计算指标名称]
	public void setN_salparamname_like(String n_salparamname_like) {
        this.n_salparamname_like = n_salparamname_like;
        if(!ObjectUtils.isEmpty(this.n_salparamname_like)){
            this.getSelectCond().like("salparamname", n_salparamname_like);
        }
    }
	private String n_salparamid_eq;//[薪酬计算指标标识]
	public void setN_salparamid_eq(String n_salparamid_eq) {
        this.n_salparamid_eq = n_salparamid_eq;
        if(!ObjectUtils.isEmpty(this.n_salparamid_eq)){
            this.getSelectCond().eq("salparamid", n_salparamid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("salrulename",query);
		 }
	}
}




