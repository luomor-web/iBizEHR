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
import cn.ibizlab.ehr.core.par.domain.PARTZGG;
/**
 * 关系型数据实体[PARTZGG] 查询条件对象
 */
@Slf4j
@Data
public class PARTZGGSearchContext extends QueryWrapperContext<PARTZGG> {

	private String n_zqlx_eq;//[周期类型]
	public void setN_zqlx_eq(String n_zqlx_eq) {
        this.n_zqlx_eq = n_zqlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zqlx_eq)){
            this.getSelectCond().eq("zqlx", n_zqlx_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_yd_eq;//[月度]
	public void setN_yd_eq(String n_yd_eq) {
        this.n_yd_eq = n_yd_eq;
        if(!ObjectUtils.isEmpty(this.n_yd_eq)){
            this.getSelectCond().eq("yd", n_yd_eq);
        }
    }
	private String n_tzlx_eq;//[通知类型]
	public void setN_tzlx_eq(String n_tzlx_eq) {
        this.n_tzlx_eq = n_tzlx_eq;
        if(!ObjectUtils.isEmpty(this.n_tzlx_eq)){
            this.getSelectCond().eq("tzlx", n_tzlx_eq);
        }
    }
	private String n_partzggname_like;//[标题]
	public void setN_partzggname_like(String n_partzggname_like) {
        this.n_partzggname_like = n_partzggname_like;
        if(!ObjectUtils.isEmpty(this.n_partzggname_like)){
            this.getSelectCond().like("partzggname", n_partzggname_like);
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
                     wrapper.like("partzggname", query)   
            );
		 }
	}
}




