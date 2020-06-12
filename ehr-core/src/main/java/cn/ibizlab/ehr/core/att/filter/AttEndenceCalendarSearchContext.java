package cn.ibizlab.ehr.core.att.filter;

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
import cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar;
/**
 * 关系型数据实体[AttEndenceCalendar] 查询条件对象
 */
@Slf4j
@Data
public class AttEndenceCalendarSearchContext extends QueryWrapperContext<AttEndenceCalendar> {

	private String n_attendencecalendarname_like;//[考勤日历名称]
	public void setN_attendencecalendarname_like(String n_attendencecalendarname_like) {
        this.n_attendencecalendarname_like = n_attendencecalendarname_like;
        if(!ObjectUtils.isEmpty(this.n_attendencecalendarname_like)){
            this.getSearchCond().like("attendencecalendarname", n_attendencecalendarname_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_lx1_eq;//[上班/休假]
	public void setN_lx1_eq(String n_lx1_eq) {
        this.n_lx1_eq = n_lx1_eq;
        if(!ObjectUtils.isEmpty(this.n_lx1_eq)){
            this.getSearchCond().eq("lx1", n_lx1_eq);
        }
    }
	private String n_vacholidayname_eq;//[节假日/调休上班名称]
	public void setN_vacholidayname_eq(String n_vacholidayname_eq) {
        this.n_vacholidayname_eq = n_vacholidayname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacholidayname_eq)){
            this.getSearchCond().eq("vacholidayname", n_vacholidayname_eq);
        }
    }
	private String n_vacholidayname_like;//[节假日/调休上班名称]
	public void setN_vacholidayname_like(String n_vacholidayname_like) {
        this.n_vacholidayname_like = n_vacholidayname_like;
        if(!ObjectUtils.isEmpty(this.n_vacholidayname_like)){
            this.getSearchCond().like("vacholidayname", n_vacholidayname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
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
	private String n_vacholidayid_eq;//[节假日管理标识]
	public void setN_vacholidayid_eq(String n_vacholidayid_eq) {
        this.n_vacholidayid_eq = n_vacholidayid_eq;
        if(!ObjectUtils.isEmpty(this.n_vacholidayid_eq)){
            this.getSearchCond().eq("vacholidayid", n_vacholidayid_eq);
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
                     wrapper.like("attendencecalendarname", query)   
                        .or().like("nd", query)            
            );
		 }
	}
}




