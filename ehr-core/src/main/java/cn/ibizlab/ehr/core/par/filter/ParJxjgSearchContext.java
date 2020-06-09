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
import cn.ibizlab.ehr.core.par.domain.ParJxjg;
/**
 * 关系型数据实体[ParJxjg] 查询条件对象
 */
@Slf4j
@Data
public class ParJxjgSearchContext extends QueryWrapperContext<ParJxjg> {

	private String n_khpgdj_eq;//[考核定级]
	public void setN_khpgdj_eq(String n_khpgdj_eq) {
        this.n_khpgdj_eq = n_khpgdj_eq;
        if(!ObjectUtils.isEmpty(this.n_khpgdj_eq)){
            this.getSearchCond().eq("khpgdj", n_khpgdj_eq);
        }
    }
	private String n_parjxjgname_like;//[绩效结果名称]
	public void setN_parjxjgname_like(String n_parjxjgname_like) {
        this.n_parjxjgname_like = n_parjxjgname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxjgname_like)){
            this.getSearchCond().like("parjxjgname", n_parjxjgname_like);
        }
    }
	private String n_nd_eq;//[考核年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_khlx_eq;//[考核对象]
	public void setN_khlx_eq(String n_khlx_eq) {
        this.n_khlx_eq = n_khlx_eq;
        if(!ObjectUtils.isEmpty(this.n_khlx_eq)){
            this.getSearchCond().eq("khlx", n_khlx_eq);
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
                     wrapper.like("parjxjgname", query)   
            );
		 }
	}
}




