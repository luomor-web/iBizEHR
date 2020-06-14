package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SalPlan;
/**
 * 关系型数据实体[SalPlan] 查询条件对象
 */
@Slf4j
@Data
public class SalPlanSearchContext extends QueryWrapperContext<SalPlan> {

	private Integer n_nyear_eq;//[年]
	public void setN_nyear_eq(Integer n_nyear_eq) {
        this.n_nyear_eq = n_nyear_eq;
        if(!ObjectUtils.isEmpty(this.n_nyear_eq)){
            this.getSearchCond().eq("nyear", n_nyear_eq);
        }
    }
	private String n_salplanname_like;//[薪酬计算计划名称]
	public void setN_salplanname_like(String n_salplanname_like) {
        this.n_salplanname_like = n_salplanname_like;
        if(!ObjectUtils.isEmpty(this.n_salplanname_like)){
            this.getSearchCond().like("salplanname", n_salplanname_like);
        }
    }
	private Integer n_nmonth_eq;//[月]
	public void setN_nmonth_eq(Integer n_nmonth_eq) {
        this.n_nmonth_eq = n_nmonth_eq;
        if(!ObjectUtils.isEmpty(this.n_nmonth_eq)){
            this.getSearchCond().eq("nmonth", n_nmonth_eq);
        }
    }
	private String n_state_eq;//[计划状态]
	public void setN_state_eq(String n_state_eq) {
        this.n_state_eq = n_state_eq;
        if(!ObjectUtils.isEmpty(this.n_state_eq)){
            this.getSearchCond().eq("state", n_state_eq);
        }
    }
	private String n_salschemename_eq;//[薪酬方案]
	public void setN_salschemename_eq(String n_salschemename_eq) {
        this.n_salschemename_eq = n_salschemename_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemename_eq)){
            this.getSearchCond().eq("salschemename", n_salschemename_eq);
        }
    }
	private String n_salschemename_like;//[薪酬方案]
	public void setN_salschemename_like(String n_salschemename_like) {
        this.n_salschemename_like = n_salschemename_like;
        if(!ObjectUtils.isEmpty(this.n_salschemename_like)){
            this.getSearchCond().like("salschemename", n_salschemename_like);
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
	private String n_salschemeid_eq;//[薪酬方案标识]
	public void setN_salschemeid_eq(String n_salschemeid_eq) {
        this.n_salschemeid_eq = n_salschemeid_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeid_eq)){
            this.getSearchCond().eq("salschemeid", n_salschemeid_eq);
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
                     wrapper.like("salplanname", query)   
            );
		 }
	}
}




