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
import cn.ibizlab.ehr.core.pim.domain.PimPerson;
/**
 * 关系型数据实体[PimPerson] 查询条件对象
 */
@Slf4j
@Data
public class PimPersonSearchContext extends QueryWrapperContext<PimPerson> {

	private String n_gzzt_eq;//[挂职状态]
	public void setN_gzzt_eq(String n_gzzt_eq) {
        this.n_gzzt_eq = n_gzzt_eq;
        if(!ObjectUtils.isEmpty(this.n_gzzt_eq)){
            this.getSearchCond().eq("gzzt", n_gzzt_eq);
        }
    }
	private String n_zjlx_eq;//[证件类型]
	public void setN_zjlx_eq(String n_zjlx_eq) {
        this.n_zjlx_eq = n_zjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zjlx_eq)){
            this.getSearchCond().eq("zjlx", n_zjlx_eq);
        }
    }
	private String n_zgzt_eq;//[在岗状态]
	public void setN_zgzt_eq(String n_zgzt_eq) {
        this.n_zgzt_eq = n_zgzt_eq;
        if(!ObjectUtils.isEmpty(this.n_zgzt_eq)){
            this.getSearchCond().eq("zgzt", n_zgzt_eq);
        }
    }
	private String n_gw_eq;//[岗位]
	public void setN_gw_eq(String n_gw_eq) {
        this.n_gw_eq = n_gw_eq;
        if(!ObjectUtils.isEmpty(this.n_gw_eq)){
            this.getSearchCond().eq("gw", n_gw_eq);
        }
    }
	private String n_yglx_eq;//[员工类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSearchCond().eq("yglx", n_yglx_eq);
        }
    }
	private String n_daxl_eq;//[档案学历]
	public void setN_daxl_eq(String n_daxl_eq) {
        this.n_daxl_eq = n_daxl_eq;
        if(!ObjectUtils.isEmpty(this.n_daxl_eq)){
            this.getSearchCond().eq("daxl", n_daxl_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sydq_ltandeq;//[试用到期时间]
	public void setN_sydq_ltandeq(Timestamp n_sydq_ltandeq) {
        this.n_sydq_ltandeq = n_sydq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_sydq_ltandeq)){
            this.getSearchCond().le("sydq", n_sydq_ltandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_dzjbjsj_gtandeq;//[到局时间]
	public void setN_dzjbjsj_gtandeq(Timestamp n_dzjbjsj_gtandeq) {
        this.n_dzjbjsj_gtandeq = n_dzjbjsj_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_dzjbjsj_gtandeq)){
            this.getSearchCond().ge("dzjbjsj", n_dzjbjsj_gtandeq);
        }
    }
	private String n_zgcode_eq;//[在岗状态]
	public void setN_zgcode_eq(String n_zgcode_eq) {
        this.n_zgcode_eq = n_zgcode_eq;
        if(!ObjectUtils.isEmpty(this.n_zgcode_eq)){
            this.getSearchCond().eq("zgcode", n_zgcode_eq);
        }
    }
	private String n_jg_eq;//[籍贯]
	public void setN_jg_eq(String n_jg_eq) {
        this.n_jg_eq = n_jg_eq;
        if(!ObjectUtils.isEmpty(this.n_jg_eq)){
            this.getSearchCond().eq("jg", n_jg_eq);
        }
    }
	private String n_rank_eq;//[职级]
	public void setN_rank_eq(String n_rank_eq) {
        this.n_rank_eq = n_rank_eq;
        if(!ObjectUtils.isEmpty(this.n_rank_eq)){
            this.getSearchCond().eq("rank", n_rank_eq);
        }
    }
	private Integer n_isleaderteam_eq;//[是否属于领导班子]
	public void setN_isleaderteam_eq(Integer n_isleaderteam_eq) {
        this.n_isleaderteam_eq = n_isleaderteam_eq;
        if(!ObjectUtils.isEmpty(this.n_isleaderteam_eq)){
            this.getSearchCond().eq("isleaderteam", n_isleaderteam_eq);
        }
    }
	private String n_gwzt_eq;//[岗位状态]
	public void setN_gwzt_eq(String n_gwzt_eq) {
        this.n_gwzt_eq = n_gwzt_eq;
        if(!ObjectUtils.isEmpty(this.n_gwzt_eq)){
            this.getSearchCond().eq("gwzt", n_gwzt_eq);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_hjszd_eq;//[户籍所在地]
	public void setN_hjszd_eq(String n_hjszd_eq) {
        this.n_hjszd_eq = n_hjszd_eq;
        if(!ObjectUtils.isEmpty(this.n_hjszd_eq)){
            this.getSearchCond().eq("hjszd", n_hjszd_eq);
        }
    }
	private String n_zt_eq;//[试岗状态_干部花名册]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_jlspzt_eq;//[记录审批状态]
	public void setN_jlspzt_eq(String n_jlspzt_eq) {
        this.n_jlspzt_eq = n_jlspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jlspzt_eq)){
            this.getSearchCond().eq("jlspzt", n_jlspzt_eq);
        }
    }
	private String n_rzqd_eq;//[入职渠道]
	public void setN_rzqd_eq(String n_rzqd_eq) {
        this.n_rzqd_eq = n_rzqd_eq;
        if(!ObjectUtils.isEmpty(this.n_rzqd_eq)){
            this.getSearchCond().eq("rzqd", n_rzqd_eq);
        }
    }
	private String n_zzmm_eq;//[政治面貌]
	public void setN_zzmm_eq(String n_zzmm_eq) {
        this.n_zzmm_eq = n_zzmm_eq;
        if(!ObjectUtils.isEmpty(this.n_zzmm_eq)){
            this.getSearchCond().eq("zzmm", n_zzmm_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_jxdq_ltandeq;//[见习到期时间]
	public void setN_jxdq_ltandeq(Timestamp n_jxdq_ltandeq) {
        this.n_jxdq_ltandeq = n_jxdq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_jxdq_ltandeq)){
            this.getSearchCond().le("jxdq", n_jxdq_ltandeq);
        }
    }
	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
        }
    }
	private String n_firsteducation_eq;//[第一学历]
	public void setN_firsteducation_eq(String n_firsteducation_eq) {
        this.n_firsteducation_eq = n_firsteducation_eq;
        if(!ObjectUtils.isEmpty(this.n_firsteducation_eq)){
            this.getSearchCond().eq("firsteducation", n_firsteducation_eq);
        }
    }
	private String n_ygzt_eq;//[员工状态]
	public void setN_ygzt_eq(String n_ygzt_eq) {
        this.n_ygzt_eq = n_ygzt_eq;
        if(!ObjectUtils.isEmpty(this.n_ygzt_eq)){
            this.getSearchCond().eq("ygzt", n_ygzt_eq);
        }
    }
	private String n_duration_eq;//[实习/试用期限]
	public void setN_duration_eq(String n_duration_eq) {
        this.n_duration_eq = n_duration_eq;
        if(!ObjectUtils.isEmpty(this.n_duration_eq)){
            this.getSearchCond().eq("duration", n_duration_eq);
        }
    }
	private String n_rcxllx_eq;//[人才序列类型]
	public void setN_rcxllx_eq(String n_rcxllx_eq) {
        this.n_rcxllx_eq = n_rcxllx_eq;
        if(!ObjectUtils.isEmpty(this.n_rcxllx_eq)){
            this.getSearchCond().eq("rcxllx", n_rcxllx_eq);
        }
    }
	private String n_hklx_eq;//[户口类型]
	public void setN_hklx_eq(String n_hklx_eq) {
        this.n_hklx_eq = n_hklx_eq;
        if(!ObjectUtils.isEmpty(this.n_hklx_eq)){
            this.getSearchCond().eq("hklx", n_hklx_eq);
        }
    }
	private String n_retiplace_eq;//[退休地]
	public void setN_retiplace_eq(String n_retiplace_eq) {
        this.n_retiplace_eq = n_retiplace_eq;
        if(!ObjectUtils.isEmpty(this.n_retiplace_eq)){
            this.getSearchCond().eq("retiplace", n_retiplace_eq);
        }
    }
	private String n_higheducation_eq;//[最高学历]
	public void setN_higheducation_eq(String n_higheducation_eq) {
        this.n_higheducation_eq = n_higheducation_eq;
        if(!ObjectUtils.isEmpty(this.n_higheducation_eq)){
            this.getSearchCond().eq("higheducation", n_higheducation_eq);
        }
    }
	private String n_jlczz_eq;//[记录操作者]
	public void setN_jlczz_eq(String n_jlczz_eq) {
        this.n_jlczz_eq = n_jlczz_eq;
        if(!ObjectUtils.isEmpty(this.n_jlczz_eq)){
            this.getSearchCond().eq("jlczz", n_jlczz_eq);
        }
    }
	private String n_zj_eq;//[专家类型]
	public void setN_zj_eq(String n_zj_eq) {
        this.n_zj_eq = n_zj_eq;
        if(!ObjectUtils.isEmpty(this.n_zj_eq)){
            this.getSearchCond().eq("zj", n_zj_eq);
        }
    }
	private String n_hyzk_eq;//[婚姻状况]
	public void setN_hyzk_eq(String n_hyzk_eq) {
        this.n_hyzk_eq = n_hyzk_eq;
        if(!ObjectUtils.isEmpty(this.n_hyzk_eq)){
            this.getSearchCond().eq("hyzk", n_hyzk_eq);
        }
    }
	private String n_sftberp_eq;//[同步员工信息]
	public void setN_sftberp_eq(String n_sftberp_eq) {
        this.n_sftberp_eq = n_sftberp_eq;
        if(!ObjectUtils.isEmpty(this.n_sftberp_eq)){
            this.getSearchCond().eq("sftberp", n_sftberp_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sjtxrq_gtandeq;//[实际退休时间]
	public void setN_sjtxrq_gtandeq(Timestamp n_sjtxrq_gtandeq) {
        this.n_sjtxrq_gtandeq = n_sjtxrq_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_sjtxrq_gtandeq)){
            this.getSearchCond().ge("sjtxrq", n_sjtxrq_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_sjtxrq_ltandeq;//[实际退休时间]
	public void setN_sjtxrq_ltandeq(Timestamp n_sjtxrq_ltandeq) {
        this.n_sjtxrq_ltandeq = n_sjtxrq_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_sjtxrq_ltandeq)){
            this.getSearchCond().le("sjtxrq", n_sjtxrq_ltandeq);
        }
    }
	private String n_xx_eq;//[血型]
	public void setN_xx_eq(String n_xx_eq) {
        this.n_xx_eq = n_xx_eq;
        if(!ObjectUtils.isEmpty(this.n_xx_eq)){
            this.getSearchCond().eq("xx", n_xx_eq);
        }
    }
	private String n_sfdszn_eq;//[有独生子女证]
	public void setN_sfdszn_eq(String n_sfdszn_eq) {
        this.n_sfdszn_eq = n_sfdszn_eq;
        if(!ObjectUtils.isEmpty(this.n_sfdszn_eq)){
            this.getSearchCond().eq("sfdszn", n_sfdszn_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_workstate_eq;//[工作状态]
	public void setN_workstate_eq(String n_workstate_eq) {
        this.n_workstate_eq = n_workstate_eq;
        if(!ObjectUtils.isEmpty(this.n_workstate_eq)){
            this.getSearchCond().eq("workstate", n_workstate_eq);
        }
    }
	private String n_zjhm_like;//[证件号码]
	public void setN_zjhm_like(String n_zjhm_like) {
        this.n_zjhm_like = n_zjhm_like;
        if(!ObjectUtils.isEmpty(this.n_zjhm_like)){
            this.getSearchCond().like("zjhm", n_zjhm_like);
        }
    }
	private String n_yjsnf_eq;//[XX届应届生]
	public void setN_yjsnf_eq(String n_yjsnf_eq) {
        this.n_yjsnf_eq = n_yjsnf_eq;
        if(!ObjectUtils.isEmpty(this.n_yjsnf_eq)){
            this.getSearchCond().eq("yjsnf", n_yjsnf_eq);
        }
    }
	private String n_zw_eq;//[职务]
	public void setN_zw_eq(String n_zw_eq) {
        this.n_zw_eq = n_zw_eq;
        if(!ObjectUtils.isEmpty(this.n_zw_eq)){
            this.getSearchCond().eq("zw", n_zw_eq);
        }
    }
	private String n_mz_eq;//[民族]
	public void setN_mz_eq(String n_mz_eq) {
        this.n_mz_eq = n_mz_eq;
        if(!ObjectUtils.isEmpty(this.n_mz_eq)){
            this.getSearchCond().eq("mz", n_mz_eq);
        }
    }
	private String n_ydzt_eq;//[异动状态]
	public void setN_ydzt_eq(String n_ydzt_eq) {
        this.n_ydzt_eq = n_ydzt_eq;
        if(!ObjectUtils.isEmpty(this.n_ydzt_eq)){
            this.getSearchCond().eq("ydzt", n_ydzt_eq);
        }
    }
	private String n_pimpersonname3_eq;//[业务导师]
	public void setN_pimpersonname3_eq(String n_pimpersonname3_eq) {
        this.n_pimpersonname3_eq = n_pimpersonname3_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname3_eq)){
            this.getSearchCond().eq("pimpersonname3", n_pimpersonname3_eq);
        }
    }
	private String n_pimpersonname3_like;//[业务导师]
	public void setN_pimpersonname3_like(String n_pimpersonname3_like) {
        this.n_pimpersonname3_like = n_pimpersonname3_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname3_like)){
            this.getSearchCond().like("pimpersonname3", n_pimpersonname3_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_pimmajorsetypename_eq;//[专业序列类型]
	public void setN_pimmajorsetypename_eq(String n_pimmajorsetypename_eq) {
        this.n_pimmajorsetypename_eq = n_pimmajorsetypename_eq;
        if(!ObjectUtils.isEmpty(this.n_pimmajorsetypename_eq)){
            this.getSearchCond().eq("pimmajorsetypename", n_pimmajorsetypename_eq);
        }
    }
	private String n_pimmajorsetypename_like;//[专业序列类型]
	public void setN_pimmajorsetypename_like(String n_pimmajorsetypename_like) {
        this.n_pimmajorsetypename_like = n_pimmajorsetypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimmajorsetypename_like)){
            this.getSearchCond().like("pimmajorsetypename", n_pimmajorsetypename_like);
        }
    }
	private String n_pcmrcxlname_eq;//[人才序列]
	public void setN_pcmrcxlname_eq(String n_pcmrcxlname_eq) {
        this.n_pcmrcxlname_eq = n_pcmrcxlname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlname_eq)){
            this.getSearchCond().eq("pcmrcxlname", n_pcmrcxlname_eq);
        }
    }
	private String n_pcmrcxlname_like;//[人才序列]
	public void setN_pcmrcxlname_like(String n_pcmrcxlname_like) {
        this.n_pcmrcxlname_like = n_pcmrcxlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlname_like)){
            this.getSearchCond().like("pcmrcxlname", n_pcmrcxlname_like);
        }
    }
	private String n_pimpersonname2_eq;//[思想导师]
	public void setN_pimpersonname2_eq(String n_pimpersonname2_eq) {
        this.n_pimpersonname2_eq = n_pimpersonname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_eq)){
            this.getSearchCond().eq("pimpersonname2", n_pimpersonname2_eq);
        }
    }
	private String n_pimpersonname2_like;//[思想导师]
	public void setN_pimpersonname2_like(String n_pimpersonname2_like) {
        this.n_pimpersonname2_like = n_pimpersonname2_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname2_like)){
            this.getSearchCond().like("pimpersonname2", n_pimpersonname2_like);
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
	private String n_pimcityname_eq;//[出生地]
	public void setN_pimcityname_eq(String n_pimcityname_eq) {
        this.n_pimcityname_eq = n_pimcityname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimcityname_eq)){
            this.getSearchCond().eq("pimcityname", n_pimcityname_eq);
        }
    }
	private String n_pimcityname_like;//[出生地]
	public void setN_pimcityname_like(String n_pimcityname_like) {
        this.n_pimcityname_like = n_pimcityname_like;
        if(!ObjectUtils.isEmpty(this.n_pimcityname_like)){
            this.getSearchCond().like("pimcityname", n_pimcityname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_pcmrcxlid_eq;//[人才序列标识]
	public void setN_pcmrcxlid_eq(String n_pcmrcxlid_eq) {
        this.n_pcmrcxlid_eq = n_pcmrcxlid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlid_eq)){
            this.getSearchCond().eq("pcmrcxlid", n_pcmrcxlid_eq);
        }
    }
	private String n_pimpersonid2_eq;//[人员信息标识]
	public void setN_pimpersonid2_eq(String n_pimpersonid2_eq) {
        this.n_pimpersonid2_eq = n_pimpersonid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid2_eq)){
            this.getSearchCond().eq("pimpersonid2", n_pimpersonid2_eq);
        }
    }
	private String n_pimcityid_eq;//[市标识]
	public void setN_pimcityid_eq(String n_pimcityid_eq) {
        this.n_pimcityid_eq = n_pimcityid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimcityid_eq)){
            this.getSearchCond().eq("pimcityid", n_pimcityid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pcmjxsygzzjlmxid_eq;//[见习生员工转正记录引用明细标识]
	public void setN_pcmjxsygzzjlmxid_eq(String n_pcmjxsygzzjlmxid_eq) {
        this.n_pcmjxsygzzjlmxid_eq = n_pcmjxsygzzjlmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzjlmxid_eq)){
            this.getSearchCond().eq("pcmjxsygzzjlmxid", n_pcmjxsygzzjlmxid_eq);
        }
    }
	private String n_pimmajorsetypeid_eq;//[专业序列类型标识]
	public void setN_pimmajorsetypeid_eq(String n_pimmajorsetypeid_eq) {
        this.n_pimmajorsetypeid_eq = n_pimmajorsetypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimmajorsetypeid_eq)){
            this.getSearchCond().eq("pimmajorsetypeid", n_pimmajorsetypeid_eq);
        }
    }
	private String n_pimpersonid3_eq;//[人员信息标识]
	public void setN_pimpersonid3_eq(String n_pimpersonid3_eq) {
        this.n_pimpersonid3_eq = n_pimpersonid3_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid3_eq)){
            this.getSearchCond().eq("pimpersonid3", n_pimpersonid3_eq);
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




