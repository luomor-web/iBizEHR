package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmPost;
/**
 * 关系型数据实体[OrmPost] 查询条件对象
 */
@Slf4j
@Data
public class OrmPostSearchContext extends QueryWrapperContext<OrmPost> {

	private String n_istemp_eq;//[是否临时数据]
	public void setN_istemp_eq(String n_istemp_eq) {
        this.n_istemp_eq = n_istemp_eq;
        if(!ObjectUtils.isEmpty(this.n_istemp_eq)){
            this.getSearchCond().eq("istemp", n_istemp_eq);
        }
    }
	private String n_gwtype_eq;//[岗位类型]
	public void setN_gwtype_eq(String n_gwtype_eq) {
        this.n_gwtype_eq = n_gwtype_eq;
        if(!ObjectUtils.isEmpty(this.n_gwtype_eq)){
            this.getSearchCond().eq("gwtype", n_gwtype_eq);
        }
    }
	private String n_postnature_eq;//[岗位性质]
	public void setN_postnature_eq(String n_postnature_eq) {
        this.n_postnature_eq = n_postnature_eq;
        if(!ObjectUtils.isEmpty(this.n_postnature_eq)){
            this.getSearchCond().eq("postnature", n_postnature_eq);
        }
    }
	private String n_iskeypostion_eq;//[是否关键岗位]
	public void setN_iskeypostion_eq(String n_iskeypostion_eq) {
        this.n_iskeypostion_eq = n_iskeypostion_eq;
        if(!ObjectUtils.isEmpty(this.n_iskeypostion_eq)){
            this.getSearchCond().eq("iskeypostion", n_iskeypostion_eq);
        }
    }
	private String n_isconfidential_eq;//[是否保密岗]
	public void setN_isconfidential_eq(String n_isconfidential_eq) {
        this.n_isconfidential_eq = n_isconfidential_eq;
        if(!ObjectUtils.isEmpty(this.n_isconfidential_eq)){
            this.getSearchCond().eq("isconfidential", n_isconfidential_eq);
        }
    }
	private String n_ormpostname_like;//[岗位名称]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_gwfl_eq;//[岗位分类]
	public void setN_gwfl_eq(String n_gwfl_eq) {
        this.n_gwfl_eq = n_gwfl_eq;
        if(!ObjectUtils.isEmpty(this.n_gwfl_eq)){
            this.getSearchCond().eq("gwfl", n_gwfl_eq);
        }
    }
	private String n_startstopsign_eq;//[启用标识]
	public void setN_startstopsign_eq(String n_startstopsign_eq) {
        this.n_startstopsign_eq = n_startstopsign_eq;
        if(!ObjectUtils.isEmpty(this.n_startstopsign_eq)){
            this.getSearchCond().eq("startstopsign", n_startstopsign_eq);
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
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("ormpostname", query)   
            );
		 }
	}
}




