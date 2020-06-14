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
import cn.ibizlab.ehr.core.pim.domain.PimVacation;
/**
 * 关系型数据实体[PimVacation] 查询条件对象
 */
@Slf4j
@Data
public class PimVacationSearchContext extends QueryWrapperContext<PimVacation> {

	private String n_pimvacationname_like;//[休假信息名称]
	public void setN_pimvacationname_like(String n_pimvacationname_like) {
        this.n_pimvacationname_like = n_pimvacationname_like;
        if(!ObjectUtils.isEmpty(this.n_pimvacationname_like)){
            this.getSearchCond().like("pimvacationname", n_pimvacationname_like);
        }
    }
	private String n_xjlx_eq;//[休假类型]
	public void setN_xjlx_eq(String n_xjlx_eq) {
        this.n_xjlx_eq = n_xjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_xjlx_eq)){
            this.getSearchCond().eq("xjlx", n_xjlx_eq);
        }
    }
	private String n_pimpersonname_eq;//[人员信息名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[人员信息名称]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pimvacationname", query)   
            );
		 }
	}
}




