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
import cn.ibizlab.ehr.core.par.domain.PARKHZCMX;
/**
 * 关系型数据实体[PARKHZCMX] 查询条件对象
 */
@Slf4j
@Data
public class PARKHZCMXSearchContext extends QueryWrapperContext<PARKHZCMX> {

	private String n_parkhzcmxname_like;//[考核内容]
	public void setN_parkhzcmxname_like(String n_parkhzcmxname_like) {
        this.n_parkhzcmxname_like = n_parkhzcmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_like)){
            this.getSelectCond().like("parkhzcmxname", n_parkhzcmxname_like);
        }
    }
	private String n_parjxkhjcszname_eq;//[考核方案]
	public void setN_parjxkhjcszname_eq(String n_parjxkhjcszname_eq) {
        this.n_parjxkhjcszname_eq = n_parjxkhjcszname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszname_eq)){
            this.getSelectCond().eq("parjxkhjcszname", n_parjxkhjcszname_eq);
        }
    }
	private String n_parjxkhjcszname_like;//[考核方案]
	public void setN_parjxkhjcszname_like(String n_parjxkhjcszname_like) {
        this.n_parjxkhjcszname_like = n_parjxkhjcszname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszname_like)){
            this.getSelectCond().like("parjxkhjcszname", n_parjxkhjcszname_like);
        }
    }
	private String n_parjxkhjcszid_eq;//[考核方案ID]
	public void setN_parjxkhjcszid_eq(String n_parjxkhjcszid_eq) {
        this.n_parjxkhjcszid_eq = n_parjxkhjcszid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszid_eq)){
            this.getSelectCond().eq("parjxkhjcszid", n_parjxkhjcszid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("parkhzcmxname", query)   
            );
		 }
	}
}




