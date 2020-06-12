package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TrmStaff;
/**
 * 关系型数据实体[TrmStaff] 查询条件对象
 */
@Slf4j
@Data
public class TrmStaffSearchContext extends QueryWrapperContext<TrmStaff> {

	private String n_trmstaffname_like;//[员工需求调查表名称]
	public void setN_trmstaffname_like(String n_trmstaffname_like) {
        this.n_trmstaffname_like = n_trmstaffname_like;
        if(!ObjectUtils.isEmpty(this.n_trmstaffname_like)){
            this.getSearchCond().like("trmstaffname", n_trmstaffname_like);
        }
    }
	private String n_xqlylx_eq;//[需求来源类型]
	public void setN_xqlylx_eq(String n_xqlylx_eq) {
        this.n_xqlylx_eq = n_xqlylx_eq;
        if(!ObjectUtils.isEmpty(this.n_xqlylx_eq)){
            this.getSearchCond().eq("xqlylx", n_xqlylx_eq);
        }
    }
	private String n_spfs_eq;//[审批方式]
	public void setN_spfs_eq(String n_spfs_eq) {
        this.n_spfs_eq = n_spfs_eq;
        if(!ObjectUtils.isEmpty(this.n_spfs_eq)){
            this.getSearchCond().eq("spfs", n_spfs_eq);
        }
    }
	private String n_lclx_eq;//[流程类型]
	public void setN_lclx_eq(String n_lclx_eq) {
        this.n_lclx_eq = n_lclx_eq;
        if(!ObjectUtils.isEmpty(this.n_lclx_eq)){
            this.getSearchCond().eq("lclx", n_lclx_eq);
        }
    }
	private String n_pimpersonname2_eq;//[员工姓名]
	public void setN_pimpersonname2_eq(String n_pimpersonname2_eq) {
        this.n_pimpersonname2_eq = n_pimpersonname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_eq)){
            this.getSearchCond().eq("pimpersonname2", n_pimpersonname2_eq);
        }
    }
	private String n_pimpersonname2_like;//[员工姓名]
	public void setN_pimpersonname2_like(String n_pimpersonname2_like) {
        this.n_pimpersonname2_like = n_pimpersonname2_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_like)){
            this.getSearchCond().like("pimpersonname2", n_pimpersonname2_like);
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
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimpersonid2_eq;//[人员信息标识]
	public void setN_pimpersonid2_eq(String n_pimpersonid2_eq) {
        this.n_pimpersonid2_eq = n_pimpersonid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid2_eq)){
            this.getSearchCond().eq("pimpersonid2", n_pimpersonid2_eq);
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
                     wrapper.like("trmstaffname", query)   
            );
		 }
	}
}




