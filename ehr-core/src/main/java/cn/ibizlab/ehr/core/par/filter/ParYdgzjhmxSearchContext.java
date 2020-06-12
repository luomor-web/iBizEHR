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
import cn.ibizlab.ehr.core.par.domain.ParYdgzjhmx;
/**
 * 关系型数据实体[ParYdgzjhmx] 查询条件对象
 */
@Slf4j
@Data
public class ParYdgzjhmxSearchContext extends QueryWrapperContext<ParYdgzjhmx> {

	private String n_zblx_eq;//[指标类型]
	public void setN_zblx_eq(String n_zblx_eq) {
        this.n_zblx_eq = n_zblx_eq;
        if(!ObjectUtils.isEmpty(this.n_zblx_eq)){
            this.getSearchCond().eq("zblx", n_zblx_eq);
        }
    }
	private String n_parydgzjhmxname_like;//[工作计划]
	public void setN_parydgzjhmxname_like(String n_parydgzjhmxname_like) {
        this.n_parydgzjhmxname_like = n_parydgzjhmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parydgzjhmxname_like)){
            this.getSearchCond().like("parydgzjhmxname", n_parydgzjhmxname_like);
        }
    }
	private String n_parydgzjhname_eq;//[月度工作计划]
	public void setN_parydgzjhname_eq(String n_parydgzjhname_eq) {
        this.n_parydgzjhname_eq = n_parydgzjhname_eq;
        if(!ObjectUtils.isEmpty(this.n_parydgzjhname_eq)){
            this.getSearchCond().eq("parydgzjhname", n_parydgzjhname_eq);
        }
    }
	private String n_parydgzjhname_like;//[月度工作计划]
	public void setN_parydgzjhname_like(String n_parydgzjhname_like) {
        this.n_parydgzjhname_like = n_parydgzjhname_like;
        if(!ObjectUtils.isEmpty(this.n_parydgzjhname_like)){
            this.getSearchCond().like("parydgzjhname", n_parydgzjhname_like);
        }
    }
	private String n_parydgzjhid_eq;//[月度工作计划ID]
	public void setN_parydgzjhid_eq(String n_parydgzjhid_eq) {
        this.n_parydgzjhid_eq = n_parydgzjhid_eq;
        if(!ObjectUtils.isEmpty(this.n_parydgzjhid_eq)){
            this.getSearchCond().eq("parydgzjhid", n_parydgzjhid_eq);
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
                     wrapper.like("parydgzjhmxname", query)   
            );
		 }
	}
}




