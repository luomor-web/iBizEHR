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
import cn.ibizlab.ehr.core.orm.domain.OrmPostLib;
/**
 * 关系型数据实体[OrmPostLib] 查询条件对象
 */
@Slf4j
@Data
public class OrmPostLibSearchContext extends QueryWrapperContext<OrmPostLib> {

	private String n_postnature_eq;//[岗位性质]
	public void setN_postnature_eq(String n_postnature_eq) {
        this.n_postnature_eq = n_postnature_eq;
        if(!ObjectUtils.isEmpty(this.n_postnature_eq)){
            this.getSearchCond().eq("postnature", n_postnature_eq);
        }
    }
	private String n_gwflag_eq;//[岗位标签]
	public void setN_gwflag_eq(String n_gwflag_eq) {
        this.n_gwflag_eq = n_gwflag_eq;
        if(!ObjectUtils.isEmpty(this.n_gwflag_eq)){
            this.getSearchCond().eq("gwflag", n_gwflag_eq);
        }
    }
	private String n_gwtype_eq;//[岗位类型]
	public void setN_gwtype_eq(String n_gwtype_eq) {
        this.n_gwtype_eq = n_gwtype_eq;
        if(!ObjectUtils.isEmpty(this.n_gwtype_eq)){
            this.getSearchCond().eq("gwtype", n_gwtype_eq);
        }
    }
	private String n_isconfidential_eq;//[是否保密岗]
	public void setN_isconfidential_eq(String n_isconfidential_eq) {
        this.n_isconfidential_eq = n_isconfidential_eq;
        if(!ObjectUtils.isEmpty(this.n_isconfidential_eq)){
            this.getSearchCond().eq("isconfidential", n_isconfidential_eq);
        }
    }
	private String n_ormpostlibname_like;//[岗位名称]
	public void setN_ormpostlibname_like(String n_ormpostlibname_like) {
        this.n_ormpostlibname_like = n_ormpostlibname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostlibname_like)){
            this.getSearchCond().like("ormpostlibname", n_ormpostlibname_like);
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
                     wrapper.like("gwtype", query)   
                        .or().like("ormpostlibname", query)            
            );
		 }
	}
}




