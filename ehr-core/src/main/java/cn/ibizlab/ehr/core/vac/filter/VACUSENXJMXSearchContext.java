package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VACUSENXJMX;
/**
 * 关系型数据实体[VACUSENXJMX] 查询条件对象
 */
@Slf4j
@Data
public class VACUSENXJMXSearchContext extends QueryWrapperContext<VACUSENXJMX> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_vacusenxjmxname_like;//[假期使用明细名称]
	public void setN_vacusenxjmxname_like(String n_vacusenxjmxname_like) {
        this.n_vacusenxjmxname_like = n_vacusenxjmxname_like;
        if(!ObjectUtils.isEmpty(this.n_vacusenxjmxname_like)){
            this.getSelectCond().like("vacusenxjmxname", n_vacusenxjmxname_like);
        }
    }
	private String n_qjzl_eq;//[请假种类]
	public void setN_qjzl_eq(String n_qjzl_eq) {
        this.n_qjzl_eq = n_qjzl_eq;
        if(!ObjectUtils.isEmpty(this.n_qjzl_eq)){
            this.getSelectCond().eq("qjzl", n_qjzl_eq);
        }
    }
	private String n_vacleavedetailid_eq;//[请销假明细标识]
	public void setN_vacleavedetailid_eq(String n_vacleavedetailid_eq) {
        this.n_vacleavedetailid_eq = n_vacleavedetailid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacleavedetailid_eq)){
            this.getSelectCond().eq("vacleavedetailid", n_vacleavedetailid_eq);
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
                     wrapper.like("vacusenxjmxname", query)   
            );
		 }
	}
}




