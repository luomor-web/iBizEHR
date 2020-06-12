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
import cn.ibizlab.ehr.core.att.domain.AttEndanceRecord;
/**
 * 关系型数据实体[AttEndanceRecord] 查询条件对象
 */
@Slf4j
@Data
public class AttEndanceRecordSearchContext extends QueryWrapperContext<AttEndanceRecord> {

	private String n_dkfs_eq;//[考勤方式]
	public void setN_dkfs_eq(String n_dkfs_eq) {
        this.n_dkfs_eq = n_dkfs_eq;
        if(!ObjectUtils.isEmpty(this.n_dkfs_eq)){
            this.getSearchCond().eq("dkfs", n_dkfs_eq);
        }
    }
	private String n_attendancerecordname_like;//[考勤记录名称]
	public void setN_attendancerecordname_like(String n_attendancerecordname_like) {
        this.n_attendancerecordname_like = n_attendancerecordname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancerecordname_like)){
            this.getSearchCond().like("attendancerecordname", n_attendancerecordname_like);
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
	private String n_ormorgsectorname_eq;//[部门/项目部]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门/项目部]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_trmtrainplantermname_eq;//[培训计划项名称]
	public void setN_trmtrainplantermname_eq(String n_trmtrainplantermname_eq) {
        this.n_trmtrainplantermname_eq = n_trmtrainplantermname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_eq)){
            this.getSearchCond().eq("trmtrainplantermname", n_trmtrainplantermname_eq);
        }
    }
	private String n_trmtrainplantermname_like;//[培训计划项名称]
	public void setN_trmtrainplantermname_like(String n_trmtrainplantermname_like) {
        this.n_trmtrainplantermname_like = n_trmtrainplantermname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_like)){
            this.getSearchCond().like("trmtrainplantermname", n_trmtrainplantermname_like);
        }
    }
	private String n_ormbmkqdzname_eq;//[部门地址]
	public void setN_ormbmkqdzname_eq(String n_ormbmkqdzname_eq) {
        this.n_ormbmkqdzname_eq = n_ormbmkqdzname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormbmkqdzname_eq)){
            this.getSearchCond().eq("ormbmkqdzname", n_ormbmkqdzname_eq);
        }
    }
	private String n_ormbmkqdzname_like;//[部门地址]
	public void setN_ormbmkqdzname_like(String n_ormbmkqdzname_like) {
        this.n_ormbmkqdzname_like = n_ormbmkqdzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormbmkqdzname_like)){
            this.getSearchCond().like("ormbmkqdzname", n_ormbmkqdzname_like);
        }
    }
	private String n_attendancemreportmxname_eq;//[考勤月报明细名称]
	public void setN_attendancemreportmxname_eq(String n_attendancemreportmxname_eq) {
        this.n_attendancemreportmxname_eq = n_attendancemreportmxname_eq;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportmxname_eq)){
            this.getSearchCond().eq("attendancemreportmxname", n_attendancemreportmxname_eq);
        }
    }
	private String n_attendancemreportmxname_like;//[考勤月报明细名称]
	public void setN_attendancemreportmxname_like(String n_attendancemreportmxname_like) {
        this.n_attendancemreportmxname_like = n_attendancemreportmxname_like;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportmxname_like)){
            this.getSearchCond().like("attendancemreportmxname", n_attendancemreportmxname_like);
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
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormbmkqdzid_eq;//[部门地址维护标识]
	public void setN_ormbmkqdzid_eq(String n_ormbmkqdzid_eq) {
        this.n_ormbmkqdzid_eq = n_ormbmkqdzid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormbmkqdzid_eq)){
            this.getSearchCond().eq("ormbmkqdzid", n_ormbmkqdzid_eq);
        }
    }
	private String n_attendancemreportmxid_eq;//[考勤月报明细标识]
	public void setN_attendancemreportmxid_eq(String n_attendancemreportmxid_eq) {
        this.n_attendancemreportmxid_eq = n_attendancemreportmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_attendancemreportmxid_eq)){
            this.getSearchCond().eq("attendancemreportmxid", n_attendancemreportmxid_eq);
        }
    }
	private String n_trmtrainplantermid_eq;//[培训计划项标识]
	public void setN_trmtrainplantermid_eq(String n_trmtrainplantermid_eq) {
        this.n_trmtrainplantermid_eq = n_trmtrainplantermid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermid_eq)){
            this.getSearchCond().eq("trmtrainplantermid", n_trmtrainplantermid_eq);
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
                     wrapper.like("pimpersonname", query)   
                        .or().like("ygbh", query)            
            );
		 }
	}
}




