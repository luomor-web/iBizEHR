package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
/**
 * 关系型数据实体[PcmBdsqdmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmBdsqdmxSearchContext extends QueryWrapperContext<PcmBdsqdmx> {

	private String n_ldzytype_eq;//[劳动争议类型]
	public void setN_ldzytype_eq(String n_ldzytype_eq) {
        this.n_ldzytype_eq = n_ldzytype_eq;
        if(!ObjectUtils.isEmpty(this.n_ldzytype_eq)){
            this.getSearchCond().eq("ldzytype", n_ldzytype_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sxrq_gtandeq;//[生效日期]
	public void setN_sxrq_gtandeq(Timestamp n_sxrq_gtandeq) {
        this.n_sxrq_gtandeq = n_sxrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_sxrq_gtandeq)){
            this.getSearchCond().ge("sxrq", n_sxrq_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sxrq_ltandeq;//[生效日期]
	public void setN_sxrq_ltandeq(Timestamp n_sxrq_ltandeq) {
        this.n_sxrq_ltandeq = n_sxrq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_sxrq_ltandeq)){
            this.getSearchCond().le("sxrq", n_sxrq_ltandeq);
        }
    }
	private String n_gzzt_eq;//[挂职状态]
	public void setN_gzzt_eq(String n_gzzt_eq) {
        this.n_gzzt_eq = n_gzzt_eq;
        if(!ObjectUtils.isEmpty(this.n_gzzt_eq)){
            this.getSearchCond().eq("gzzt", n_gzzt_eq);
        }
    }
	private String n_sfjrhmd_eq;//[是否加入黑名单]
	public void setN_sfjrhmd_eq(String n_sfjrhmd_eq) {
        this.n_sfjrhmd_eq = n_sfjrhmd_eq;
        if(!ObjectUtils.isEmpty(this.n_sfjrhmd_eq)){
            this.getSearchCond().eq("sfjrhmd", n_sfjrhmd_eq);
        }
    }
	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_lx_eq;//[类型]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_pcmbdsqdmxname_like;//[申请单明细名称]
	public void setN_pcmbdsqdmxname_like(String n_pcmbdsqdmxname_like) {
        this.n_pcmbdsqdmxname_like = n_pcmbdsqdmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmbdsqdmxname_like)){
            this.getSearchCond().like("pcmbdsqdmxname", n_pcmbdsqdmxname_like);
        }
    }
	private String n_xrank_eq;//[新职级]
	public void setN_xrank_eq(String n_xrank_eq) {
        this.n_xrank_eq = n_xrank_eq;
        if(!ObjectUtils.isEmpty(this.n_xrank_eq)){
            this.getSearchCond().eq("xrank", n_xrank_eq);
        }
    }
	private String n_dglx_eq;//[待岗类型]
	public void setN_dglx_eq(String n_dglx_eq) {
        this.n_dglx_eq = n_dglx_eq;
        if(!ObjectUtils.isEmpty(this.n_dglx_eq)){
            this.getSearchCond().eq("dglx", n_dglx_eq);
        }
    }
	private String n_ormorgsectorname2_eq;//[退休管理部门]
	public void setN_ormorgsectorname2_eq(String n_ormorgsectorname2_eq) {
        this.n_ormorgsectorname2_eq = n_ormorgsectorname2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname2_eq)){
            this.getSearchCond().eq("ormorgsectorname2", n_ormorgsectorname2_eq);
        }
    }
	private String n_ormorgsectorname2_like;//[退休管理部门]
	public void setN_ormorgsectorname2_like(String n_ormorgsectorname2_like) {
        this.n_ormorgsectorname2_like = n_ormorgsectorname2_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname2_like)){
            this.getSearchCond().like("ormorgsectorname2", n_ormorgsectorname2_like);
        }
    }
	private String n_ormorgsectorname_eq;//[新部门/项目]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[新部门/项目]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_lzmtr_eq;//[离职面谈人]
	public void setN_lzmtr_eq(String n_lzmtr_eq) {
        this.n_lzmtr_eq = n_lzmtr_eq;
        if(!ObjectUtils.isEmpty(this.n_lzmtr_eq)){
            this.getSearchCond().eq("lzmtr", n_lzmtr_eq);
        }
    }
	private String n_lzmtr_like;//[离职面谈人]
	public void setN_lzmtr_like(String n_lzmtr_like) {
        this.n_lzmtr_like = n_lzmtr_like;
        if(!ObjectUtils.isEmpty(this.n_lzmtr_like)){
            this.getSearchCond().like("lzmtr", n_lzmtr_like);
        }
    }
	private String n_ormpostname_eq;//[新岗位]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[新岗位]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_rank_eq;//[原职级]
	public void setN_rank_eq(String n_rank_eq) {
        this.n_rank_eq = n_rank_eq;
        if(!ObjectUtils.isEmpty(this.n_rank_eq)){
            this.getSearchCond().eq("rank", n_rank_eq);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgname_eq;//[新组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[新组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
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
	private String n_ormdutyname_eq;//[新职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[新职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormorgsectorid2_eq;//[部门标识]
	public void setN_ormorgsectorid2_eq(String n_ormorgsectorid2_eq) {
        this.n_ormorgsectorid2_eq = n_ormorgsectorid2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid2_eq)){
            this.getSearchCond().eq("ormorgsectorid2", n_ormorgsectorid2_eq);
        }
    }
	private String n_ormdutyid_eq;//[职务标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_pcmbdsqdid_eq;//[变动申请单标识]
	public void setN_pcmbdsqdid_eq(String n_pcmbdsqdid_eq) {
        this.n_pcmbdsqdid_eq = n_pcmbdsqdid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmbdsqdid_eq)){
            this.getSearchCond().eq("pcmbdsqdid", n_pcmbdsqdid_eq);
        }
    }
	private String n_lzmtrid_eq;//[人员信息标识]
	public void setN_lzmtrid_eq(String n_lzmtrid_eq) {
        this.n_lzmtrid_eq = n_lzmtrid_eq;
        if(!ObjectUtils.isEmpty(this.n_lzmtrid_eq)){
            this.getSearchCond().eq("lzmtrid", n_lzmtrid_eq);
        }
    }
	private String n_pimpersonid_eq;//[员工ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormorgid_eq;//[挂职组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_ormpostid_eq;//[岗位管理标识]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[新部门/项目ID]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("pcmbdsqdmxname", query)   
                        .or().like("ygbh", query)            
                        .or().like("pimpersonname", query)            
            );
		 }
	}
}




