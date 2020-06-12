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
import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
/**
 * 关系型数据实体[PimByzzjlmx] 查询条件对象
 */
@Slf4j
@Data
public class PimByzzjlmxSearchContext extends QueryWrapperContext<PimByzzjlmx> {

	private String n_nzzyglx_eq;//[拟申请员工编号类型]
	public void setN_nzzyglx_eq(String n_nzzyglx_eq) {
        this.n_nzzyglx_eq = n_nzzyglx_eq;
        if(!ObjectUtils.isEmpty(this.n_nzzyglx_eq)){
            this.getSearchCond().eq("nzzyglx", n_nzzyglx_eq);
        }
    }
	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_xygbh_like;//[新员工编号]
	public void setN_xygbh_like(String n_xygbh_like) {
        this.n_xygbh_like = n_xygbh_like;
        if(!ObjectUtils.isEmpty(this.n_xygbh_like)){
            this.getSearchCond().like("xygbh", n_xygbh_like);
        }
    }
	private String n_oldygbh_like;//[申请前员工编号]
	public void setN_oldygbh_like(String n_oldygbh_like) {
        this.n_oldygbh_like = n_oldygbh_like;
        if(!ObjectUtils.isEmpty(this.n_oldygbh_like)){
            this.getSearchCond().like("oldygbh", n_oldygbh_like);
        }
    }
	private String n_standardcause_eq;//[标准原因]
	public void setN_standardcause_eq(String n_standardcause_eq) {
        this.n_standardcause_eq = n_standardcause_eq;
        if(!ObjectUtils.isEmpty(this.n_standardcause_eq)){
            this.getSearchCond().eq("standardcause", n_standardcause_eq);
        }
    }
	private String n_pimbyzzjlmxname_like;//[B/Y类员工转正记录引用明细名称]
	public void setN_pimbyzzjlmxname_like(String n_pimbyzzjlmxname_like) {
        this.n_pimbyzzjlmxname_like = n_pimbyzzjlmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pimbyzzjlmxname_like)){
            this.getSearchCond().like("pimbyzzjlmxname", n_pimbyzzjlmxname_like);
        }
    }
	private String n_ygbh_like;//[申请前员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormpostname_eq;//[转正后拟安排岗位名称]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[转正后拟安排岗位名称]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_pimexaminationresultsname_eq;//[姓名]
	public void setN_pimexaminationresultsname_eq(String n_pimexaminationresultsname_eq) {
        this.n_pimexaminationresultsname_eq = n_pimexaminationresultsname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimexaminationresultsname_eq)){
            this.getSearchCond().eq("pimexaminationresultsname", n_pimexaminationresultsname_eq);
        }
    }
	private String n_pimexaminationresultsname_like;//[姓名]
	public void setN_pimexaminationresultsname_like(String n_pimexaminationresultsname_like) {
        this.n_pimexaminationresultsname_like = n_pimexaminationresultsname_like;
        if(!ObjectUtils.isEmpty(this.n_pimexaminationresultsname_like)){
            this.getSearchCond().like("pimexaminationresultsname", n_pimexaminationresultsname_like);
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
	private String n_zz_like;//[组织名称]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
        }
    }
	private String n_pimbyygzzsqname_eq;//[标题]
	public void setN_pimbyygzzsqname_eq(String n_pimbyygzzsqname_eq) {
        this.n_pimbyygzzsqname_eq = n_pimbyygzzsqname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqname_eq)){
            this.getSearchCond().eq("pimbyygzzsqname", n_pimbyygzzsqname_eq);
        }
    }
	private String n_pimbyygzzsqname_like;//[标题]
	public void setN_pimbyygzzsqname_like(String n_pimbyygzzsqname_like) {
        this.n_pimbyygzzsqname_like = n_pimbyygzzsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqname_like)){
            this.getSearchCond().like("pimbyygzzsqname", n_pimbyygzzsqname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimexaminationresultsid_eq;//[B/Y员工转正考核结果记录ID]
	public void setN_pimexaminationresultsid_eq(String n_pimexaminationresultsid_eq) {
        this.n_pimexaminationresultsid_eq = n_pimexaminationresultsid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimexaminationresultsid_eq)){
            this.getSearchCond().eq("pimexaminationresultsid", n_pimexaminationresultsid_eq);
        }
    }
	private String n_pimbyygzzsqid_eq;//[B/Y类员工转正申请ID]
	public void setN_pimbyygzzsqid_eq(String n_pimbyygzzsqid_eq) {
        this.n_pimbyygzzsqid_eq = n_pimbyygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqid_eq)){
            this.getSearchCond().eq("pimbyygzzsqid", n_pimbyygzzsqid_eq);
        }
    }
	private String n_ormpostid_eq;//[转正后岗位标识]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
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
                     wrapper.like("pimbyzzjlmxname", query)   
                        .or().like("ygbh", query)            
                        .or().like("pimpersonname", query)            
            );
		 }
	}
}




