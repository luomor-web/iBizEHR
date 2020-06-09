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
import cn.ibizlab.ehr.core.par.domain.ParJxkhmbmx;
/**
 * 关系型数据实体[ParJxkhmbmx] 查询条件对象
 */
@Slf4j
@Data
public class ParJxkhmbmxSearchContext extends QueryWrapperContext<ParJxkhmbmx> {

	private String n_parjxkhmbmxname_like;//[考核模板明细名称]
	public void setN_parjxkhmbmxname_like(String n_parjxkhmbmxname_like) {
        this.n_parjxkhmbmxname_like = n_parjxkhmbmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxkhmbmxname_like)){
            this.getSearchCond().like("parjxkhmbmxname", n_parjxkhmbmxname_like);
        }
    }
	private String n_parjxkhmbname_eq;//[模板名称]
	public void setN_parjxkhmbname_eq(String n_parjxkhmbname_eq) {
        this.n_parjxkhmbname_eq = n_parjxkhmbname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhmbname_eq)){
            this.getSearchCond().eq("parjxkhmbname", n_parjxkhmbname_eq);
        }
    }
	private String n_parjxkhmbname_like;//[模板名称]
	public void setN_parjxkhmbname_like(String n_parjxkhmbname_like) {
        this.n_parjxkhmbname_like = n_parjxkhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxkhmbname_like)){
            this.getSearchCond().like("parjxkhmbname", n_parjxkhmbname_like);
        }
    }
	private String n_parjxkhmbid_eq;//[模板ID]
	public void setN_parjxkhmbid_eq(String n_parjxkhmbid_eq) {
        this.n_parjxkhmbid_eq = n_parjxkhmbid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhmbid_eq)){
            this.getSearchCond().eq("parjxkhmbid", n_parjxkhmbid_eq);
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
                     wrapper.like("parjxkhmbmxname", query)   
            );
		 }
	}
}




