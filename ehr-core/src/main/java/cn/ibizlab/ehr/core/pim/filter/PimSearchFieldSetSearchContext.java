package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimSearchFieldSet;
/**
 * 关系型数据实体[PimSearchFieldSet] 查询条件对象
 */
@Slf4j
@Data
public class PimSearchFieldSetSearchContext extends QueryWrapperContext<PimSearchFieldSet> {

	private String n_columnname_like;//[列名称]
	public void setN_columnname_like(String n_columnname_like) {
        this.n_columnname_like = n_columnname_like;
        if(!ObjectUtils.isEmpty(this.n_columnname_like)){
            this.getSearchCond().like("columnname", n_columnname_like);
        }
    }
	private String n_entitylogicname_like;//[实体逻辑名称]
	public void setN_entitylogicname_like(String n_entitylogicname_like) {
        this.n_entitylogicname_like = n_entitylogicname_like;
        if(!ObjectUtils.isEmpty(this.n_entitylogicname_like)){
            this.getSearchCond().like("entitylogicname", n_entitylogicname_like);
        }
    }
	private String n_pimsearchfieldsetname_like;//[组合查询条件设置名称]
	public void setN_pimsearchfieldsetname_like(String n_pimsearchfieldsetname_like) {
        this.n_pimsearchfieldsetname_like = n_pimsearchfieldsetname_like;
        if(!ObjectUtils.isEmpty(this.n_pimsearchfieldsetname_like)){
            this.getSearchCond().like("pimsearchfieldsetname", n_pimsearchfieldsetname_like);
        }
    }
	private String n_columnlogicname_like;//[列逻辑名称]
	public void setN_columnlogicname_like(String n_columnlogicname_like) {
        this.n_columnlogicname_like = n_columnlogicname_like;
        if(!ObjectUtils.isEmpty(this.n_columnlogicname_like)){
            this.getSearchCond().like("columnlogicname", n_columnlogicname_like);
        }
    }
	private String n_fieldtype_eq;//[属性类型]
	public void setN_fieldtype_eq(String n_fieldtype_eq) {
        this.n_fieldtype_eq = n_fieldtype_eq;
        if(!ObjectUtils.isEmpty(this.n_fieldtype_eq)){
            this.getSearchCond().eq("fieldtype", n_fieldtype_eq);
        }
    }
	private String n_entityname_like;//[实体名称]
	public void setN_entityname_like(String n_entityname_like) {
        this.n_entityname_like = n_entityname_like;
        if(!ObjectUtils.isEmpty(this.n_entityname_like)){
            this.getSearchCond().like("entityname", n_entityname_like);
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
                     wrapper.like("pimsearchfieldsetname", query)   
            );
		 }
	}
}




