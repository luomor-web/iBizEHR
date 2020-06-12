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
import cn.ibizlab.ehr.core.vac.domain.VacHoliday;
/**
 * 关系型数据实体[VacHoliday] 查询条件对象
 */
@Slf4j
@Data
public class VacHolidaySearchContext extends QueryWrapperContext<VacHoliday> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_vacholidayname_like;//[名称]
	public void setN_vacholidayname_like(String n_vacholidayname_like) {
        this.n_vacholidayname_like = n_vacholidayname_like;
        if(!ObjectUtils.isEmpty(this.n_vacholidayname_like)){
            this.getSearchCond().like("vacholidayname", n_vacholidayname_like);
        }
    }
	private String n_jjrlx_eq;//[类型]
	public void setN_jjrlx_eq(String n_jjrlx_eq) {
        this.n_jjrlx_eq = n_jjrlx_eq;
        if(!ObjectUtils.isEmpty(this.n_jjrlx_eq)){
            this.getSearchCond().eq("jjrlx", n_jjrlx_eq);
        }
    }
	private String n_sex_eq;//[性别]
	public void setN_sex_eq(String n_sex_eq) {
        this.n_sex_eq = n_sex_eq;
        if(!ObjectUtils.isEmpty(this.n_sex_eq)){
            this.getSearchCond().eq("sex", n_sex_eq);
        }
    }
	private String n_vacholidayrulesname_eq;//[考勤规则名称]
	public void setN_vacholidayrulesname_eq(String n_vacholidayrulesname_eq) {
        this.n_vacholidayrulesname_eq = n_vacholidayrulesname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesname_eq)){
            this.getSearchCond().eq("vacholidayrulesname", n_vacholidayrulesname_eq);
        }
    }
	private String n_vacholidayrulesname_like;//[考勤规则名称]
	public void setN_vacholidayrulesname_like(String n_vacholidayrulesname_like) {
        this.n_vacholidayrulesname_like = n_vacholidayrulesname_like;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesname_like)){
            this.getSearchCond().like("vacholidayrulesname", n_vacholidayrulesname_like);
        }
    }
	private String n_vacholidayrulesid_eq;//[考勤规则标识]
	public void setN_vacholidayrulesid_eq(String n_vacholidayrulesid_eq) {
        this.n_vacholidayrulesid_eq = n_vacholidayrulesid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesid_eq)){
            this.getSearchCond().eq("vacholidayrulesid", n_vacholidayrulesid_eq);
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
                     wrapper.like("vacholidayname", query)   
            );
		 }
	}
}




