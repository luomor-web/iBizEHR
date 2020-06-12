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
import cn.ibizlab.ehr.core.sal.domain.SalParam;
/**
 * 关系型数据实体[SalParam] 查询条件对象
 */
@Slf4j
@Data
public class SalParamSearchContext extends QueryWrapperContext<SalParam> {

	private String n_salparamname_like;//[薪酬计算指标名称]
	public void setN_salparamname_like(String n_salparamname_like) {
        this.n_salparamname_like = n_salparamname_like;
        if(!ObjectUtils.isEmpty(this.n_salparamname_like)){
            this.getSearchCond().like("salparamname", n_salparamname_like);
        }
    }
	private String n_salsourcename_eq;//[薪酬计算源]
	public void setN_salsourcename_eq(String n_salsourcename_eq) {
        this.n_salsourcename_eq = n_salsourcename_eq;
        if(!ObjectUtils.isEmpty(this.n_salsourcename_eq)){
            this.getSearchCond().eq("salsourcename", n_salsourcename_eq);
        }
    }
	private String n_salsourcename_like;//[薪酬计算源]
	public void setN_salsourcename_like(String n_salsourcename_like) {
        this.n_salsourcename_like = n_salsourcename_like;
        if(!ObjectUtils.isEmpty(this.n_salsourcename_like)){
            this.getSearchCond().like("salsourcename", n_salsourcename_like);
        }
    }
	private String n_salsourceid_eq;//[薪酬计算源]
	public void setN_salsourceid_eq(String n_salsourceid_eq) {
        this.n_salsourceid_eq = n_salsourceid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsourceid_eq)){
            this.getSearchCond().eq("salsourceid", n_salsourceid_eq);
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
                     wrapper.like("salparamname", query)   
            );
		 }
	}
}




