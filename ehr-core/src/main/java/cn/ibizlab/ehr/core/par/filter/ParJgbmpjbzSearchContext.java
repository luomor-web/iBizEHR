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
import cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz;
/**
 * 关系型数据实体[ParJgbmpjbz] 查询条件对象
 */
@Slf4j
@Data
public class ParJgbmpjbzSearchContext extends QueryWrapperContext<ParJgbmpjbz> {

	private String n_pj_eq;//[评级]
	public void setN_pj_eq(String n_pj_eq) {
        this.n_pj_eq = n_pj_eq;
        if(!ObjectUtils.isEmpty(this.n_pj_eq)){
            this.getSearchCond().eq("pj", n_pj_eq);
        }
    }
	private String n_bmpj_eq;//[部门评级]
	public void setN_bmpj_eq(String n_bmpj_eq) {
        this.n_bmpj_eq = n_bmpj_eq;
        if(!ObjectUtils.isEmpty(this.n_bmpj_eq)){
            this.getSearchCond().eq("bmpj", n_bmpj_eq);
        }
    }
	private String n_parjgbmpjbzname_like;//[部门评级标准名称]
	public void setN_parjgbmpjbzname_like(String n_parjgbmpjbzname_like) {
        this.n_parjgbmpjbzname_like = n_parjgbmpjbzname_like;
        if(!ObjectUtils.isEmpty(this.n_parjgbmpjbzname_like)){
            this.getSearchCond().like("parjgbmpjbzname", n_parjgbmpjbzname_like);
        }
    }
	private String n_dj_eq;//[档级]
	public void setN_dj_eq(String n_dj_eq) {
        this.n_dj_eq = n_dj_eq;
        if(!ObjectUtils.isEmpty(this.n_dj_eq)){
            this.getSearchCond().eq("dj", n_dj_eq);
        }
    }
	private String n_ormorgsectorname_eq;//[部门名称]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门名称]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_pjbzmc_eq;//[评级]
	public void setN_pjbzmc_eq(String n_pjbzmc_eq) {
        this.n_pjbzmc_eq = n_pjbzmc_eq;
        if(!ObjectUtils.isEmpty(this.n_pjbzmc_eq)){
            this.getSearchCond().eq("pjbzmc", n_pjbzmc_eq);
        }
    }
	private String n_pjbzmc_like;//[评级]
	public void setN_pjbzmc_like(String n_pjbzmc_like) {
        this.n_pjbzmc_like = n_pjbzmc_like;
        if(!ObjectUtils.isEmpty(this.n_pjbzmc_like)){
            this.getSearchCond().like("pjbzmc", n_pjbzmc_like);
        }
    }
	private String n_pjbzid_eq;//[评级ID]
	public void setN_pjbzid_eq(String n_pjbzid_eq) {
        this.n_pjbzid_eq = n_pjbzid_eq;
        if(!ObjectUtils.isEmpty(this.n_pjbzid_eq)){
            this.getSearchCond().eq("pjbzid", n_pjbzid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织ID]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门ID]
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
                     wrapper.like("parjgbmpjbzname", query)   
            );
		 }
	}
}




