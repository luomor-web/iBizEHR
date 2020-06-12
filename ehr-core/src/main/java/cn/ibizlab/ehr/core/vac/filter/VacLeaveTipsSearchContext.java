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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveTips;
/**
 * 关系型数据实体[VacLeaveTips] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaveTipsSearchContext extends QueryWrapperContext<VacLeaveTips> {

	private String n_qjzl_eq;//[请假种类]
	public void setN_qjzl_eq(String n_qjzl_eq) {
        this.n_qjzl_eq = n_qjzl_eq;
        if(!ObjectUtils.isEmpty(this.n_qjzl_eq)){
            this.getSearchCond().eq("qjzl", n_qjzl_eq);
        }
    }
	private String n_vacleavetipsname_like;//[请假提示名称]
	public void setN_vacleavetipsname_like(String n_vacleavetipsname_like) {
        this.n_vacleavetipsname_like = n_vacleavetipsname_like;
        if(!ObjectUtils.isEmpty(this.n_vacleavetipsname_like)){
            this.getSearchCond().like("vacleavetipsname", n_vacleavetipsname_like);
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
                     wrapper.like("vacleavetipsname", query)   
            );
		 }
	}
}




