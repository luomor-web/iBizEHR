package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
/**
 * 关系型数据实体[OrmXmrypzxq] 查询条件对象
 */
@Slf4j
@Data
public class OrmXmrypzxqSearchContext extends QueryWrapperContext<OrmXmrypzxq> {

	private String n_approvalstatus_eq;//[审批状态（需求计划）]
	public void setN_approvalstatus_eq(String n_approvalstatus_eq) {
        this.n_approvalstatus_eq = n_approvalstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_approvalstatus_eq)){
            this.getSearchCond().eq("approvalstatus", n_approvalstatus_eq);
        }
    }
	private String n_gw_eq;//[拟任岗位]
	public void setN_gw_eq(String n_gw_eq) {
        this.n_gw_eq = n_gw_eq;
        if(!ObjectUtils.isEmpty(this.n_gw_eq)){
            this.getSearchCond().eq("gw", n_gw_eq);
        }
    }
	private String n_planstate_eq;//[计划状态]
	public void setN_planstate_eq(String n_planstate_eq) {
        this.n_planstate_eq = n_planstate_eq;
        if(!ObjectUtils.isEmpty(this.n_planstate_eq)){
            this.getSearchCond().eq("planstate", n_planstate_eq);
        }
    }
	private String n_modspzt_eq;//[修改审批状态]
	public void setN_modspzt_eq(String n_modspzt_eq) {
        this.n_modspzt_eq = n_modspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_modspzt_eq)){
            this.getSearchCond().eq("modspzt", n_modspzt_eq);
        }
    }
	private String n_spzt_eq;//[审批状态（释放）]
	public void setN_spzt_eq(String n_spzt_eq) {
        this.n_spzt_eq = n_spzt_eq;
        if(!ObjectUtils.isEmpty(this.n_spzt_eq)){
            this.getSearchCond().eq("spzt", n_spzt_eq);
        }
    }
	private String n_ormxmrypzxqname_like;//[项目人员需求名称]
	public void setN_ormxmrypzxqname_like(String n_ormxmrypzxqname_like) {
        this.n_ormxmrypzxqname_like = n_ormxmrypzxqname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmrypzxqname_like)){
            this.getSearchCond().like("ormxmrypzxqname", n_ormxmrypzxqname_like);
        }
    }
	private String n_istemp_eq;//[是否临时数据]
	public void setN_istemp_eq(String n_istemp_eq) {
        this.n_istemp_eq = n_istemp_eq;
        if(!ObjectUtils.isEmpty(this.n_istemp_eq)){
            this.getSearchCond().eq("istemp", n_istemp_eq);
        }
    }
	private String n_tpspzt_eq;//[审批状态（调配）]
	public void setN_tpspzt_eq(String n_tpspzt_eq) {
        this.n_tpspzt_eq = n_tpspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_tpspzt_eq)){
            this.getSearchCond().eq("tpspzt", n_tpspzt_eq);
        }
    }
	private String n_modpersonname_eq;//[修改人员]
	public void setN_modpersonname_eq(String n_modpersonname_eq) {
        this.n_modpersonname_eq = n_modpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_modpersonname_eq)){
            this.getSearchCond().eq("modpersonname", n_modpersonname_eq);
        }
    }
	private String n_modpersonname_like;//[修改人员]
	public void setN_modpersonname_like(String n_modpersonname_like) {
        this.n_modpersonname_like = n_modpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_modpersonname_like)){
            this.getSearchCond().like("modpersonname", n_modpersonname_like);
        }
    }
	private String n_ormpostname_eq;//[拟任岗位]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[拟任岗位]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[项目部]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[项目部]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_realpersonname_eq;//[实际人员]
	public void setN_realpersonname_eq(String n_realpersonname_eq) {
        this.n_realpersonname_eq = n_realpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_realpersonname_eq)){
            this.getSearchCond().eq("realpersonname", n_realpersonname_eq);
        }
    }
	private String n_realpersonname_like;//[实际人员]
	public void setN_realpersonname_like(String n_realpersonname_like) {
        this.n_realpersonname_like = n_realpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_realpersonname_like)){
            this.getSearchCond().like("realpersonname", n_realpersonname_like);
        }
    }
	private String n_xmbmc_eq;//[项目部]
	public void setN_xmbmc_eq(String n_xmbmc_eq) {
        this.n_xmbmc_eq = n_xmbmc_eq;
        if(!ObjectUtils.isEmpty(this.n_xmbmc_eq)){
            this.getSearchCond().eq("xmbmc", n_xmbmc_eq);
        }
    }
	private String n_xmbmc_like;//[项目部]
	public void setN_xmbmc_like(String n_xmbmc_like) {
        this.n_xmbmc_like = n_xmbmc_like;
        if(!ObjectUtils.isEmpty(this.n_xmbmc_like)){
            this.getSearchCond().like("xmbmc", n_xmbmc_like);
        }
    }
	private String n_pimpersonname_eq;//[姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[项目部ID]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_ormxmxqjhid_eq;//[需求计划ID]
	public void setN_ormxmxqjhid_eq(String n_ormxmxqjhid_eq) {
        this.n_ormxmxqjhid_eq = n_ormxmxqjhid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormxmxqjhid_eq)){
            this.getSearchCond().eq("ormxmxqjhid", n_ormxmxqjhid_eq);
        }
    }
	private String n_realperosnid_eq;//[实际人员ID]
	public void setN_realperosnid_eq(String n_realperosnid_eq) {
        this.n_realperosnid_eq = n_realperosnid_eq;
        if(!ObjectUtils.isEmpty(this.n_realperosnid_eq)){
            this.getSearchCond().eq("realperosnid", n_realperosnid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_modpimpersonid_eq;//[修改人员ID]
	public void setN_modpimpersonid_eq(String n_modpimpersonid_eq) {
        this.n_modpimpersonid_eq = n_modpimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_modpimpersonid_eq)){
            this.getSearchCond().eq("modpimpersonid", n_modpimpersonid_eq);
        }
    }
	private String n_ormpostid_eq;//[岗位ID]
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
                     wrapper.like("ormxmrypzxqname", query)   
                        .or().like("orgshortname", query)            
                        .or().like("gcmcjbm", query)            
            );
		 }
	}
}




