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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;
/**
 * 关系型数据实体[TrmTrainPlan] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainPlanSearchContext extends QueryWrapperContext<TrmTrainPlan> {

	private String n_lclx_eq;//[流程类型]
	public void setN_lclx_eq(String n_lclx_eq) {
        this.n_lclx_eq = n_lclx_eq;
        if(!ObjectUtils.isEmpty(this.n_lclx_eq)){
            this.getSearchCond().eq("lclx", n_lclx_eq);
        }
    }
	private String n_shfs_eq;//[发布状态]
	public void setN_shfs_eq(String n_shfs_eq) {
        this.n_shfs_eq = n_shfs_eq;
        if(!ObjectUtils.isEmpty(this.n_shfs_eq)){
            this.getSearchCond().eq("shfs", n_shfs_eq);
        }
    }
	private String n_jhyd_eq;//[计划月度]
	public void setN_jhyd_eq(String n_jhyd_eq) {
        this.n_jhyd_eq = n_jhyd_eq;
        if(!ObjectUtils.isEmpty(this.n_jhyd_eq)){
            this.getSearchCond().eq("jhyd", n_jhyd_eq);
        }
    }
	private String n_jhnd_eq;//[年度]
	public void setN_jhnd_eq(String n_jhnd_eq) {
        this.n_jhnd_eq = n_jhnd_eq;
        if(!ObjectUtils.isEmpty(this.n_jhnd_eq)){
            this.getSearchCond().eq("jhnd", n_jhnd_eq);
        }
    }
	private String n_jhjb_eq;//[计划级别]
	public void setN_jhjb_eq(String n_jhjb_eq) {
        this.n_jhjb_eq = n_jhjb_eq;
        if(!ObjectUtils.isEmpty(this.n_jhjb_eq)){
            this.getSearchCond().eq("jhjb", n_jhjb_eq);
        }
    }
	private String n_jhlx_eq;//[类型]
	public void setN_jhlx_eq(String n_jhlx_eq) {
        this.n_jhlx_eq = n_jhlx_eq;
        if(!ObjectUtils.isEmpty(this.n_jhlx_eq)){
            this.getSearchCond().eq("jhlx", n_jhlx_eq);
        }
    }
	private String n_trmtrainplanname_like;//[培训计划名称]
	public void setN_trmtrainplanname_like(String n_trmtrainplanname_like) {
        this.n_trmtrainplanname_like = n_trmtrainplanname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplanname_like)){
            this.getSearchCond().like("trmtrainplanname", n_trmtrainplanname_like);
        }
    }
	private String n_jhjd_eq;//[计划季度]
	public void setN_jhjd_eq(String n_jhjd_eq) {
        this.n_jhjd_eq = n_jhjd_eq;
        if(!ObjectUtils.isEmpty(this.n_jhjd_eq)){
            this.getSearchCond().eq("jhjd", n_jhjd_eq);
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
	private String n_trmplanformuname_eq;//[培训计划]
	public void setN_trmplanformuname_eq(String n_trmplanformuname_eq) {
        this.n_trmplanformuname_eq = n_trmplanformuname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmplanformuname_eq)){
            this.getSearchCond().eq("trmplanformuname", n_trmplanformuname_eq);
        }
    }
	private String n_trmplanformuname_like;//[培训计划]
	public void setN_trmplanformuname_like(String n_trmplanformuname_like) {
        this.n_trmplanformuname_like = n_trmplanformuname_like;
        if(!ObjectUtils.isEmpty(this.n_trmplanformuname_like)){
            this.getSearchCond().like("trmplanformuname", n_trmplanformuname_like);
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
	private String n_trmdemdeftionname_eq;//[培训班名称]
	public void setN_trmdemdeftionname_eq(String n_trmdemdeftionname_eq) {
        this.n_trmdemdeftionname_eq = n_trmdemdeftionname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdemdeftionname_eq)){
            this.getSearchCond().eq("trmdemdeftionname", n_trmdemdeftionname_eq);
        }
    }
	private String n_trmdemdeftionname_like;//[培训班名称]
	public void setN_trmdemdeftionname_like(String n_trmdemdeftionname_like) {
        this.n_trmdemdeftionname_like = n_trmdemdeftionname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdemdeftionname_like)){
            this.getSearchCond().like("trmdemdeftionname", n_trmdemdeftionname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_trmdemdeftionid_eq;//[培训需求标识]
	public void setN_trmdemdeftionid_eq(String n_trmdemdeftionid_eq) {
        this.n_trmdemdeftionid_eq = n_trmdemdeftionid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdemdeftionid_eq)){
            this.getSearchCond().eq("trmdemdeftionid", n_trmdemdeftionid_eq);
        }
    }
	private String n_trmplanformuid_eq;//[培训计划制定标识]
	public void setN_trmplanformuid_eq(String n_trmplanformuid_eq) {
        this.n_trmplanformuid_eq = n_trmplanformuid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmplanformuid_eq)){
            this.getSearchCond().eq("trmplanformuid", n_trmplanformuid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("trmdemdeftionname", query)   
            );
		 }
	}
}




