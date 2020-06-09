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
import cn.ibizlab.ehr.core.par.domain.ParZnbmmx;
/**
 * 关系型数据实体[ParZnbmmx] 查询条件对象
 */
@Slf4j
@Data
public class ParZnbmmxSearchContext extends QueryWrapperContext<ParZnbmmx> {

	private String n_parznbmmxname_like;//[通知选择职能部门明细名称]
	public void setN_parznbmmxname_like(String n_parznbmmxname_like) {
        this.n_parznbmmxname_like = n_parznbmmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parznbmmxname_like)){
            this.getSearchCond().like("parznbmmxname", n_parznbmmxname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[职能部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[职能部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_partzggname_eq;//[标题]
	public void setN_partzggname_eq(String n_partzggname_eq) {
        this.n_partzggname_eq = n_partzggname_eq;
        if(!ObjectUtils.isEmpty(this.n_partzggname_eq)){
            this.getSearchCond().eq("partzggname", n_partzggname_eq);
        }
    }
	private String n_partzggname_like;//[标题]
	public void setN_partzggname_like(String n_partzggname_like) {
        this.n_partzggname_like = n_partzggname_like;
        if(!ObjectUtils.isEmpty(this.n_partzggname_like)){
            this.getSearchCond().like("partzggname", n_partzggname_like);
        }
    }
	private String n_partzggid_eq;//[通知ID]
	public void setN_partzggid_eq(String n_partzggid_eq) {
        this.n_partzggid_eq = n_partzggid_eq;
        if(!ObjectUtils.isEmpty(this.n_partzggid_eq)){
            this.getSearchCond().eq("partzggid", n_partzggid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[职能部门ID]
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
                     wrapper.like("parznbmmxname", query)   
            );
		 }
	}
}




