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
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreport;
/**
 * 关系型数据实体[AttEndanceMreport] 查询条件对象
 */
@Slf4j
@Data
public class AttEndanceMreportSearchContext extends QueryWrapperContext<AttEndanceMreport> {

	private String n_attendancemreportname_like;//[考勤月报名称]
	public void setN_attendancemreportname_like(String n_attendancemreportname_like) {
        this.n_attendancemreportname_like = n_attendancemreportname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportname_like)){
            this.getSearchCond().like("attendancemreportname", n_attendancemreportname_like);
        }
    }
	private String n_yf_eq;//[月份]
	public void setN_yf_eq(String n_yf_eq) {
        this.n_yf_eq = n_yf_eq;
        if(!ObjectUtils.isEmpty(this.n_yf_eq)){
            this.getSearchCond().eq("yf", n_yf_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
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
	private String n_attendencesetupname_eq;//[考勤表]
	public void setN_attendencesetupname_eq(String n_attendencesetupname_eq) {
        this.n_attendencesetupname_eq = n_attendencesetupname_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_eq)){
            this.getSearchCond().eq("attendencesetupname", n_attendencesetupname_eq);
        }
    }
	private String n_attendencesetupname_like;//[考勤表]
	public void setN_attendencesetupname_like(String n_attendencesetupname_like) {
        this.n_attendencesetupname_like = n_attendencesetupname_like;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_like)){
            this.getSearchCond().like("attendencesetupname", n_attendencesetupname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_attendencesetupid_eq;//[考勤设置标识]
	public void setN_attendencesetupid_eq(String n_attendencesetupid_eq) {
        this.n_attendencesetupid_eq = n_attendencesetupid_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupid_eq)){
            this.getSearchCond().eq("attendencesetupid", n_attendencesetupid_eq);
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
                     wrapper.like("attendancemreportname", query)   
            );
		 }
	}
}




