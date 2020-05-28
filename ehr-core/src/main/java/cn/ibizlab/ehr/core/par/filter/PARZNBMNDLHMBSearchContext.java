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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMB;
/**
 * 关系型数据实体[PARZNBMNDLHMB] 查询条件对象
 */
@Slf4j
@Data
public class PARZNBMNDLHMBSearchContext extends QueryWrapperContext<PARZNBMNDLHMB> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_parznbmndlhmbname_like;//[年度量化目标（职能部门级）名称]
	public void setN_parznbmndlhmbname_like(String n_parznbmndlhmbname_like) {
        this.n_parznbmndlhmbname_like = n_parznbmndlhmbname_like;
        if(!ObjectUtils.isEmpty(this.n_parznbmndlhmbname_like)){
            this.getSelectCond().like("parznbmndlhmbname", n_parznbmndlhmbname_like);
        }
    }
	private String n_jxjd_eq;//[当前阶段]
	public void setN_jxjd_eq(String n_jxjd_eq) {
        this.n_jxjd_eq = n_jxjd_eq;
        if(!ObjectUtils.isEmpty(this.n_jxjd_eq)){
            this.getSelectCond().eq("jxjd", n_jxjd_eq);
        }
    }
	private String n_ormorgsectorname_eq;//[职能部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSelectCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[职能部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSelectCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[职能部门ID]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSelectCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("parznbmndlhmbname", query)   
            );
		 }
	}
}




