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
import cn.ibizlab.ehr.core.att.domain.AttEndanceSettings;
/**
 * 关系型数据实体[AttEndanceSettings] 查询条件对象
 */
@Slf4j
@Data
public class AttEndanceSettingsSearchContext extends QueryWrapperContext<AttEndanceSettings> {

	private String n_attendancesettingsname_like;//[考勤人员名称]
	public void setN_attendancesettingsname_like(String n_attendancesettingsname_like) {
        this.n_attendancesettingsname_like = n_attendancesettingsname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancesettingsname_like)){
            this.getSearchCond().like("attendancesettingsname", n_attendancesettingsname_like);
        }
    }
	private String n_dkfs_eq;//[打卡方式]
	public void setN_dkfs_eq(String n_dkfs_eq) {
        this.n_dkfs_eq = n_dkfs_eq;
        if(!ObjectUtils.isEmpty(this.n_dkfs_eq)){
            this.getSearchCond().eq("dkfs", n_dkfs_eq);
        }
    }
	private String n_attendencesetupname_eq;//[所属考勤表]
	public void setN_attendencesetupname_eq(String n_attendencesetupname_eq) {
        this.n_attendencesetupname_eq = n_attendencesetupname_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_eq)){
            this.getSearchCond().eq("attendencesetupname", n_attendencesetupname_eq);
        }
    }
	private String n_attendencesetupname_like;//[所属考勤表]
	public void setN_attendencesetupname_like(String n_attendencesetupname_like) {
        this.n_attendencesetupname_like = n_attendencesetupname_like;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupname_like)){
            this.getSearchCond().like("attendencesetupname", n_attendencesetupname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_zzdzs_like;//[人员组织简称]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_attendencesetupid_eq;//[考勤设置标识]
	public void setN_attendencesetupid_eq(String n_attendencesetupid_eq) {
        this.n_attendencesetupid_eq = n_attendencesetupid_eq;
        if(!ObjectUtils.isEmpty(this.n_attendencesetupid_eq)){
            this.getSearchCond().eq("attendencesetupid", n_attendencesetupid_eq);
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
                     wrapper.like("ygbh", query)   
                        .or().like("pimpersonname", query)            
            );
		 }
	}
}




