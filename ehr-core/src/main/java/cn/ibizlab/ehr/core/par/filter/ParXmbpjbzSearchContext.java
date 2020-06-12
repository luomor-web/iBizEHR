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
import cn.ibizlab.ehr.core.par.domain.ParXmbpjbz;
/**
 * 关系型数据实体[ParXmbpjbz] 查询条件对象
 */
@Slf4j
@Data
public class ParXmbpjbzSearchContext extends QueryWrapperContext<ParXmbpjbz> {

	private String n_gwlx_eq;//[岗位类型]
	public void setN_gwlx_eq(String n_gwlx_eq) {
        this.n_gwlx_eq = n_gwlx_eq;
        if(!ObjectUtils.isEmpty(this.n_gwlx_eq)){
            this.getSearchCond().eq("gwlx", n_gwlx_eq);
        }
    }
	private String n_parxmbpjbzname_like;//[项目部评级标准名称]
	public void setN_parxmbpjbzname_like(String n_parxmbpjbzname_like) {
        this.n_parxmbpjbzname_like = n_parxmbpjbzname_like;
        if(!ObjectUtils.isEmpty(this.n_parxmbpjbzname_like)){
            this.getSearchCond().like("parxmbpjbzname", n_parxmbpjbzname_like);
        }
    }
	private String n_dj_eq;//[档级]
	public void setN_dj_eq(String n_dj_eq) {
        this.n_dj_eq = n_dj_eq;
        if(!ObjectUtils.isEmpty(this.n_dj_eq)){
            this.getSearchCond().eq("dj", n_dj_eq);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_xmbpjbzmc_eq;//[项目部评级标准]
	public void setN_xmbpjbzmc_eq(String n_xmbpjbzmc_eq) {
        this.n_xmbpjbzmc_eq = n_xmbpjbzmc_eq;
        if(!ObjectUtils.isEmpty(this.n_xmbpjbzmc_eq)){
            this.getSearchCond().eq("xmbpjbzmc", n_xmbpjbzmc_eq);
        }
    }
	private String n_xmbpjbzmc_like;//[项目部评级标准]
	public void setN_xmbpjbzmc_like(String n_xmbpjbzmc_like) {
        this.n_xmbpjbzmc_like = n_xmbpjbzmc_like;
        if(!ObjectUtils.isEmpty(this.n_xmbpjbzmc_like)){
            this.getSearchCond().like("xmbpjbzmc", n_xmbpjbzmc_like);
        }
    }
	private String n_ormorgid_eq;//[组织ID]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_xmbpjbzid_eq;//[评级标准ID]
	public void setN_xmbpjbzid_eq(String n_xmbpjbzid_eq) {
        this.n_xmbpjbzid_eq = n_xmbpjbzid_eq;
        if(!ObjectUtils.isEmpty(this.n_xmbpjbzid_eq)){
            this.getSearchCond().eq("xmbpjbzid", n_xmbpjbzid_eq);
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
                     wrapper.like("parxmbpjbzname", query)   
            );
		 }
	}
}




