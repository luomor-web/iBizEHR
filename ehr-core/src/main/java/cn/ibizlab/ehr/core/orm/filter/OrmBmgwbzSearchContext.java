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
import cn.ibizlab.ehr.core.orm.domain.OrmBmgwbz;
/**
 * 关系型数据实体[OrmBmgwbz] 查询条件对象
 */
@Slf4j
@Data
public class OrmBmgwbzSearchContext extends QueryWrapperContext<OrmBmgwbz> {

	private String n_ormbmgwbzname_like;//[部门岗位编制名称]
	public void setN_ormbmgwbzname_like(String n_ormbmgwbzname_like) {
        this.n_ormbmgwbzname_like = n_ormbmgwbzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormbmgwbzname_like)){
            this.getSearchCond().like("ormbmgwbzname", n_ormbmgwbzname_like);
        }
    }
	private String n_ormpostname_eq;//[岗位]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[岗位]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_ormgwbzmc_eq;//[岗位编制]
	public void setN_ormgwbzmc_eq(String n_ormgwbzmc_eq) {
        this.n_ormgwbzmc_eq = n_ormgwbzmc_eq;
        if(!ObjectUtils.isEmpty(this.n_ormgwbzmc_eq)){
            this.getSearchCond().eq("ormgwbzmc", n_ormgwbzmc_eq);
        }
    }
	private String n_ormgwbzmc_like;//[岗位编制]
	public void setN_ormgwbzmc_like(String n_ormgwbzmc_like) {
        this.n_ormgwbzmc_like = n_ormgwbzmc_like;
        if(!ObjectUtils.isEmpty(this.n_ormgwbzmc_like)){
            this.getSearchCond().like("ormgwbzmc", n_ormgwbzmc_like);
        }
    }
	private String n_ormpostid_eq;//[岗位ID]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormgwbzid_eq;//[岗位编制ID]
	public void setN_ormgwbzid_eq(String n_ormgwbzid_eq) {
        this.n_ormgwbzid_eq = n_ormgwbzid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormgwbzid_eq)){
            this.getSearchCond().eq("ormgwbzid", n_ormgwbzid_eq);
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
                     wrapper.like("ormbmgwbzname", query)   
                        .or().like("ormpostname", query)            
            );
		 }
	}
}




