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
import cn.ibizlab.ehr.core.par.domain.ParYdgzjh;
/**
 * 关系型数据实体[ParYdgzjh] 查询条件对象
 */
@Slf4j
@Data
public class ParYdgzjhSearchContext extends QueryWrapperContext<ParYdgzjh> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_yd_eq;//[月度]
	public void setN_yd_eq(String n_yd_eq) {
        this.n_yd_eq = n_yd_eq;
        if(!ObjectUtils.isEmpty(this.n_yd_eq)){
            this.getSearchCond().eq("yd", n_yd_eq);
        }
    }
	private String n_parydgzjhname_like;//[月度工作计划名称]
	public void setN_parydgzjhname_like(String n_parydgzjhname_like) {
        this.n_parydgzjhname_like = n_parydgzjhname_like;
        if(!ObjectUtils.isEmpty(this.n_parydgzjhname_like)){
            this.getSearchCond().like("parydgzjhname", n_parydgzjhname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[填报部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[填报部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[填报部门ID]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("parydgzjhname", query)   
            );
		 }
	}
}




