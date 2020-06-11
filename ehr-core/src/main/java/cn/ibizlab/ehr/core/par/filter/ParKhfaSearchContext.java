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
import cn.ibizlab.ehr.core.par.domain.ParKhfa;
/**
 * 关系型数据实体[ParKhfa] 查询条件对象
 */
@Slf4j
@Data
public class ParKhfaSearchContext extends QueryWrapperContext<ParKhfa> {

	private String n_parkhfaname_like;//[考核对象]
	public void setN_parkhfaname_like(String n_parkhfaname_like) {
        this.n_parkhfaname_like = n_parkhfaname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhfaname_like)){
            this.getSearchCond().like("parkhfaname", n_parkhfaname_like);
        }
    }
	private String n_khdx_eq;//[考核对象]
	public void setN_khdx_eq(String n_khdx_eq) {
        this.n_khdx_eq = n_khdx_eq;
        if(!ObjectUtils.isEmpty(this.n_khdx_eq)){
            this.getSearchCond().eq("khdx", n_khdx_eq);
        }
    }
	private String n_availableflag_eq;//[是否有效]
	public void setN_availableflag_eq(String n_availableflag_eq) {
        this.n_availableflag_eq = n_availableflag_eq;
        if(!ObjectUtils.isEmpty(this.n_availableflag_eq)){
            this.getSearchCond().eq("availableflag", n_availableflag_eq);
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
                     wrapper.like("parkhfaname", query)   
            );
		 }
	}
}




