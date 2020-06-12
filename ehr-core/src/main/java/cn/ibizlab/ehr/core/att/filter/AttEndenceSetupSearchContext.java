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
import cn.ibizlab.ehr.core.att.domain.AttEndenceSetup;
/**
 * 关系型数据实体[AttEndenceSetup] 查询条件对象
 */
@Slf4j
@Data
public class AttEndenceSetupSearchContext extends QueryWrapperContext<AttEndenceSetup> {

	private String n_attendencesetupname_like;//[考勤表名称]
	public void setN_attendencesetupname_like(String n_attendencesetupname_like) {
        this.n_attendencesetupname_like = n_attendencesetupname_like;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_like)){
            this.getSearchCond().like("attendencesetupname", n_attendencesetupname_like);
        }
    }
	private String n_allowoutwork_eq;//[允许外勤]
	public void setN_allowoutwork_eq(String n_allowoutwork_eq) {
        this.n_allowoutwork_eq = n_allowoutwork_eq;
        if(!ObjectUtils.isEmpty(this.n_allowoutwork_eq)){
            this.getSearchCond().eq("allowoutwork", n_allowoutwork_eq);
        }
    }
	private String n_dkfs_eq;//[打卡方式]
	public void setN_dkfs_eq(String n_dkfs_eq) {
        this.n_dkfs_eq = n_dkfs_eq;
        if(!ObjectUtils.isEmpty(this.n_dkfs_eq)){
            this.getSearchCond().eq("dkfs", n_dkfs_eq);
        }
    }
	private String n_pimpersonname_eq;//[考勤员]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[考勤员]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_vacholidayrulesname_eq;//[考勤规则]
	public void setN_vacholidayrulesname_eq(String n_vacholidayrulesname_eq) {
        this.n_vacholidayrulesname_eq = n_vacholidayrulesname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesname_eq)){
            this.getSearchCond().eq("vacholidayrulesname", n_vacholidayrulesname_eq);
        }
    }
	private String n_vacholidayrulesname_like;//[考勤规则]
	public void setN_vacholidayrulesname_like(String n_vacholidayrulesname_like) {
        this.n_vacholidayrulesname_like = n_vacholidayrulesname_like;
        if(!ObjectUtils.isEmpty(this.n_vacholidayrulesname_like)){
            this.getSearchCond().like("vacholidayrulesname", n_vacholidayrulesname_like);
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
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("attendencesetupname", query)   
                        .or().like("ormorgname", query)            
            );
		 }
	}
}




