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
import cn.ibizlab.ehr.core.par.domain.ParJxbzglmx;
/**
 * 关系型数据实体[ParJxbzglmx] 查询条件对象
 */
@Slf4j
@Data
public class ParJxbzglmxSearchContext extends QueryWrapperContext<ParJxbzglmx> {

	private String n_parjxbzglmxname_like;//[绩效标准管理明细名称]
	public void setN_parjxbzglmxname_like(String n_parjxbzglmxname_like) {
        this.n_parjxbzglmxname_like = n_parjxbzglmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxbzglmxname_like)){
            this.getSearchCond().like("parjxbzglmxname", n_parjxbzglmxname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_parjxbzglname_eq;//[绩效标准管理名称]
	public void setN_parjxbzglname_eq(String n_parjxbzglname_eq) {
        this.n_parjxbzglname_eq = n_parjxbzglname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxbzglname_eq)){
            this.getSearchCond().eq("parjxbzglname", n_parjxbzglname_eq);
        }
    }
	private String n_parjxbzglname_like;//[绩效标准管理名称]
	public void setN_parjxbzglname_like(String n_parjxbzglname_like) {
        this.n_parjxbzglname_like = n_parjxbzglname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxbzglname_like)){
            this.getSearchCond().like("parjxbzglname", n_parjxbzglname_like);
        }
    }
	private String n_parjxbzglid_eq;//[标准ID]
	public void setN_parjxbzglid_eq(String n_parjxbzglid_eq) {
        this.n_parjxbzglid_eq = n_parjxbzglid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxbzglid_eq)){
            this.getSearchCond().eq("parjxbzglid", n_parjxbzglid_eq);
        }
    }
	private String n_pimpersonid_eq;//[员工ID]
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
                     wrapper.like("parjxbzglmxname", query)   
            );
		 }
	}
}




