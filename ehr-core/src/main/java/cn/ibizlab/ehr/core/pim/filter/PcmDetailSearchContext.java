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
import cn.ibizlab.ehr.core.pim.domain.PcmDetail;
/**
 * 关系型数据实体[PcmDetail] 查询条件对象
 */
@Slf4j
@Data
public class PcmDetailSearchContext extends QueryWrapperContext<PcmDetail> {

	private String n_lxdh_like;//[联系方式]
	public void setN_lxdh_like(String n_lxdh_like) {
        this.n_lxdh_like = n_lxdh_like;
        if(!ObjectUtils.isEmpty(this.n_lxdh_like)){
            this.getSearchCond().like("lxdh", n_lxdh_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_cjgzsj_eq;//[参加工作时间]
	public void setN_cjgzsj_eq(Timestamp n_cjgzsj_eq) {
        this.n_cjgzsj_eq = n_cjgzsj_eq;
        if(!ObjectUtils.isEmpty(this.n_cjgzsj_eq)){
            this.getSearchCond().eq("cjgzsj", n_cjgzsj_eq);
        }
    }
	private String n_zgxlsxzy_like;//[最高学历所学专业]
	public void setN_zgxlsxzy_like(String n_zgxlsxzy_like) {
        this.n_zgxlsxzy_like = n_zgxlsxzy_like;
        if(!ObjectUtils.isEmpty(this.n_zgxlsxzy_like)){
            this.getSearchCond().like("zgxlsxzy", n_zgxlsxzy_like);
        }
    }
	private String n_zjhm_like;//[证件号码]
	public void setN_zjhm_like(String n_zjhm_like) {
        this.n_zjhm_like = n_zjhm_like;
        if(!ObjectUtils.isEmpty(this.n_zjhm_like)){
            this.getSearchCond().like("zjhm", n_zjhm_like);
        }
    }
	private Integer n_sfzckjs_eq;//[是否注册会计师]
	public void setN_sfzckjs_eq(Integer n_sfzckjs_eq) {
        this.n_sfzckjs_eq = n_sfzckjs_eq;
        if(!ObjectUtils.isEmpty(this.n_sfzckjs_eq)){
            this.getSearchCond().eq("sfzckjs", n_sfzckjs_eq);
        }
    }
	private String n_hyzk_eq;//[婚姻状况]
	public void setN_hyzk_eq(String n_hyzk_eq) {
        this.n_hyzk_eq = n_hyzk_eq;
        if(!ObjectUtils.isEmpty(this.n_hyzk_eq)){
            this.getSearchCond().eq("hyzk", n_hyzk_eq);
        }
    }
	private String n_zgxlbyyx_like;//[最高学历毕业院校]
	public void setN_zgxlbyyx_like(String n_zgxlbyyx_like) {
        this.n_zgxlbyyx_like = n_zgxlbyyx_like;
        if(!ObjectUtils.isEmpty(this.n_zgxlbyyx_like)){
            this.getSearchCond().like("zgxlbyyx", n_zgxlbyyx_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_qsrq_like;//[签订日期]
	public void setN_qsrq_like(Timestamp n_qsrq_like) {
        this.n_qsrq_like = n_qsrq_like;
        if(!ObjectUtils.isEmpty(this.n_qsrq_like)){
            this.getSearchCond().like("qsrq", n_qsrq_like);
        }
    }
	private String n_zgxxlb_eq;//[最高学历学校类别]
	public void setN_zgxxlb_eq(String n_zgxxlb_eq) {
        this.n_zgxxlb_eq = n_zgxxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_zgxxlb_eq)){
            this.getSearchCond().eq("zgxxlb", n_zgxxlb_eq);
        }
    }
	private String n_htsyq_like;//[合同试用期]
	public void setN_htsyq_like(String n_htsyq_like) {
        this.n_htsyq_like = n_htsyq_like;
        if(!ObjectUtils.isEmpty(this.n_htsyq_like)){
            this.getSearchCond().like("htsyq", n_htsyq_like);
        }
    }
	private String n_dyxlbyyx_like;//[第一学历毕业院校]
	public void setN_dyxlbyyx_like(String n_dyxlbyyx_like) {
        this.n_dyxlbyyx_like = n_dyxlbyyx_like;
        if(!ObjectUtils.isEmpty(this.n_dyxlbyyx_like)){
            this.getSearchCond().like("dyxlbyyx", n_dyxlbyyx_like);
        }
    }
	private String n_pcmdetailid_eq;//[人员明细表标识]
	public void setN_pcmdetailid_eq(String n_pcmdetailid_eq) {
        this.n_pcmdetailid_eq = n_pcmdetailid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmdetailid_eq)){
            this.getSearchCond().eq("pcmdetailid", n_pcmdetailid_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_csrq_like;//[出生日期]
	public void setN_csrq_like(Timestamp n_csrq_like) {
        this.n_csrq_like = n_csrq_like;
        if(!ObjectUtils.isEmpty(this.n_csrq_like)){
            this.getSearchCond().like("csrq", n_csrq_like);
        }
    }
	private String n_sbcjd_like;//[社保参缴地]
	public void setN_sbcjd_like(String n_sbcjd_like) {
        this.n_sbcjd_like = n_sbcjd_like;
        if(!ObjectUtils.isEmpty(this.n_sbcjd_like)){
            this.getSearchCond().like("sbcjd", n_sbcjd_like);
        }
    }
	private String n_dyxl_eq;//[第一学历]
	public void setN_dyxl_eq(String n_dyxl_eq) {
        this.n_dyxl_eq = n_dyxl_eq;
        if(!ObjectUtils.isEmpty(this.n_dyxl_eq)){
            this.getSearchCond().eq("dyxl", n_dyxl_eq);
        }
    }
	private String n_dyxlsxzy_like;//[第一学历所学专业]
	public void setN_dyxlsxzy_like(String n_dyxlsxzy_like) {
        this.n_dyxlsxzy_like = n_dyxlsxzy_like;
        if(!ObjectUtils.isEmpty(this.n_dyxlsxzy_like)){
            this.getSearchCond().like("dyxlsxzy", n_dyxlsxzy_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_zgxljssj_like;//[最高学历毕业时间]
	public void setN_zgxljssj_like(Timestamp n_zgxljssj_like) {
        this.n_zgxljssj_like = n_zgxljssj_like;
        if(!ObjectUtils.isEmpty(this.n_zgxljssj_like)){
            this.getSearchCond().like("zgxljssj", n_zgxljssj_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_dbdwsj_like;//[本单位工作时间]
	public void setN_dbdwsj_like(Timestamp n_dbdwsj_like) {
        this.n_dbdwsj_like = n_dbdwsj_like;
        if(!ObjectUtils.isEmpty(this.n_dbdwsj_like)){
            this.getSearchCond().like("dbdwsj", n_dbdwsj_like);
        }
    }
	private String n_gw_like;//[岗位]
	public void setN_gw_like(String n_gw_like) {
        this.n_gw_like = n_gw_like;
        if(!ObjectUtils.isEmpty(this.n_gw_like)){
            this.getSearchCond().like("gw", n_gw_like);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_gwtype_eq;//[岗位类别]
	public void setN_gwtype_eq(String n_gwtype_eq) {
        this.n_gwtype_eq = n_gwtype_eq;
        if(!ObjectUtils.isEmpty(this.n_gwtype_eq)){
            this.getSearchCond().eq("gwtype", n_gwtype_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_rdsj_like;//[入党时间]
	public void setN_rdsj_like(Timestamp n_rdsj_like) {
        this.n_rdsj_like = n_rdsj_like;
        if(!ObjectUtils.isEmpty(this.n_rdsj_like)){
            this.getSearchCond().like("rdsj", n_rdsj_like);
        }
    }
	private String n_xxlb_eq;//[第一学历学校类别]
	public void setN_xxlb_eq(String n_xxlb_eq) {
        this.n_xxlb_eq = n_xxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_xxlb_eq)){
            this.getSearchCond().eq("xxlb", n_xxlb_eq);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_bz_like;//[备注]
	public void setN_bz_like(String n_bz_like) {
        this.n_bz_like = n_bz_like;
        if(!ObjectUtils.isEmpty(this.n_bz_like)){
            this.getSearchCond().like("bz", n_bz_like);
        }
    }
	private String n_px_like;//[培训]
	public void setN_px_like(String n_px_like) {
        this.n_px_like = n_px_like;
        if(!ObjectUtils.isEmpty(this.n_px_like)){
            this.getSearchCond().like("px", n_px_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_jsrq_eq;//[结束日期]
	public void setN_jsrq_eq(Timestamp n_jsrq_eq) {
        this.n_jsrq_eq = n_jsrq_eq;
        if(!ObjectUtils.isEmpty(this.n_jsrq_eq)){
            this.getSearchCond().eq("jsrq", n_jsrq_eq);
        }
    }
	private String n_contracttype_eq;//[劳动合同性质]
	public void setN_contracttype_eq(String n_contracttype_eq) {
        this.n_contracttype_eq = n_contracttype_eq;
        if(!ObjectUtils.isEmpty(this.n_contracttype_eq)){
            this.getSearchCond().eq("contracttype", n_contracttype_eq);
        }
    }
	private String n_pimqualtypename_like;//[岗位证书]
	public void setN_pimqualtypename_like(String n_pimqualtypename_like) {
        this.n_pimqualtypename_like = n_pimqualtypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimqualtypename_like)){
            this.getSearchCond().like("pimqualtypename", n_pimqualtypename_like);
        }
    }
	private String n_xllx_eq;//[第一学历学习形式]
	public void setN_xllx_eq(String n_xllx_eq) {
        this.n_xllx_eq = n_xllx_eq;
        if(!ObjectUtils.isEmpty(this.n_xllx_eq)){
            this.getSearchCond().eq("xllx", n_xllx_eq);
        }
    }
	private String n_careername_like;//[专业技术资格（职称）]
	public void setN_careername_like(String n_careername_like) {
        this.n_careername_like = n_careername_like;
        if(!ObjectUtils.isEmpty(this.n_careername_like)){
            this.getSearchCond().like("careername", n_careername_like);
        }
    }
	private String n_zgxllx_eq;//[最高学历学习形式]
	public void setN_zgxllx_eq(String n_zgxllx_eq) {
        this.n_zgxllx_eq = n_zgxllx_eq;
        if(!ObjectUtils.isEmpty(this.n_zgxllx_eq)){
            this.getSearchCond().eq("zgxllx", n_zgxllx_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_tozjdate_like;//[建筑系统工作时间]
	public void setN_tozjdate_like(Timestamp n_tozjdate_like) {
        this.n_tozjdate_like = n_tozjdate_like;
        if(!ObjectUtils.isEmpty(this.n_tozjdate_like)){
            this.getSearchCond().like("tozjdate", n_tozjdate_like);
        }
    }
	private String n_jxkhcj_like;//[绩效考核成绩（近两年）]
	public void setN_jxkhcj_like(String n_jxkhcj_like) {
        this.n_jxkhcj_like = n_jxkhcj_like;
        if(!ObjectUtils.isEmpty(this.n_jxkhcj_like)){
            this.getSearchCond().like("jxkhcj", n_jxkhcj_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_dyxljssj_like;//[第一学历毕业时间]
	public void setN_dyxljssj_like(Timestamp n_dyxljssj_like) {
        this.n_dyxljssj_like = n_dyxljssj_like;
        if(!ObjectUtils.isEmpty(this.n_dyxljssj_like)){
            this.getSearchCond().like("dyxljssj", n_dyxljssj_like);
        }
    }
	private String n_yglx_eq;//[员工类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSearchCond().eq("yglx", n_yglx_eq);
        }
    }
	private String n_pcmdetailname_like;//[人员明细表名称]
	public void setN_pcmdetailname_like(String n_pcmdetailname_like) {
        this.n_pcmdetailname_like = n_pcmdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmdetailname_like)){
            this.getSearchCond().like("pcmdetailname", n_pcmdetailname_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_dzjbjsj_like;//[局工作时间]
	public void setN_dzjbjsj_like(Timestamp n_dzjbjsj_like) {
        this.n_dzjbjsj_like = n_dzjbjsj_like;
        if(!ObjectUtils.isEmpty(this.n_dzjbjsj_like)){
            this.getSearchCond().like("dzjbjsj", n_dzjbjsj_like);
        }
    }
	private String n_zzmm_eq;//[政治面貌]
	public void setN_zzmm_eq(String n_zzmm_eq) {
        this.n_zzmm_eq = n_zzmm_eq;
        if(!ObjectUtils.isEmpty(this.n_zzmm_eq)){
            this.getSearchCond().eq("zzmm", n_zzmm_eq);
        }
    }
	private String n_kstgkms_like;//[注册会计师专业阶段考试已通过科目数]
	public void setN_kstgkms_like(String n_kstgkms_like) {
        this.n_kstgkms_like = n_kstgkms_like;
        if(!ObjectUtils.isEmpty(this.n_kstgkms_like)){
            this.getSearchCond().like("kstgkms", n_kstgkms_like);
        }
    }
	private String n_zgzsbh_like;//[注册会计师证书编号]
	public void setN_zgzsbh_like(String n_zgzsbh_like) {
        this.n_zgzsbh_like = n_zgzsbh_like;
        if(!ObjectUtils.isEmpty(this.n_zgzsbh_like)){
            this.getSearchCond().like("zgzsbh", n_zgzsbh_like);
        }
    }
	private String n_rzqd_eq;//[入职渠道]
	public void setN_rzqd_eq(String n_rzqd_eq) {
        this.n_rzqd_eq = n_rzqd_eq;
        if(!ObjectUtils.isEmpty(this.n_rzqd_eq)){
            this.getSearchCond().eq("rzqd", n_rzqd_eq);
        }
    }
	private String n_pimvocationalcatalogname_like;//[执(职)业资格证书]
	public void setN_pimvocationalcatalogname_like(String n_pimvocationalcatalogname_like) {
        this.n_pimvocationalcatalogname_like = n_pimvocationalcatalogname_like;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalcatalogname_like)){
            this.getSearchCond().like("pimvocationalcatalogname", n_pimvocationalcatalogname_like);
        }
    }
	private String n_rank_eq;//[职级]
	public void setN_rank_eq(String n_rank_eq) {
        this.n_rank_eq = n_rank_eq;
        if(!ObjectUtils.isEmpty(this.n_rank_eq)){
            this.getSearchCond().eq("rank", n_rank_eq);
        }
    }
	private String n_zcbh_like;//[职称编号]
	public void setN_zcbh_like(String n_zcbh_like) {
        this.n_zcbh_like = n_zcbh_like;
        if(!ObjectUtils.isEmpty(this.n_zcbh_like)){
            this.getSearchCond().like("zcbh", n_zcbh_like);
        }
    }
	private String n_pimmajorsetypename_like;//[所属业务系统]
	public void setN_pimmajorsetypename_like(String n_pimmajorsetypename_like) {
        this.n_pimmajorsetypename_like = n_pimmajorsetypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimmajorsetypename_like)){
            this.getSearchCond().like("pimmajorsetypename", n_pimmajorsetypename_like);
        }
    }
	private Double n_zjxtgznx_like;//[建筑系统工作年限]
	public void setN_zjxtgznx_like(Double n_zjxtgznx_like) {
        this.n_zjxtgznx_like = n_zjxtgznx_like;
        if(!ObjectUtils.isEmpty(this.n_zjxtgznx_like)){
            this.getSearchCond().like("zjxtgznx", n_zjxtgznx_like);
        }
    }
	private Double n_gznx_like;//[工作年限]
	public void setN_gznx_like(Double n_gznx_like) {
        this.n_gznx_like = n_gznx_like;
        if(!ObjectUtils.isEmpty(this.n_gznx_like)){
            this.getSearchCond().like("gznx", n_gznx_like);
        }
    }
	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_createdate_eq;//[建立时间]
	public void setN_createdate_eq(Timestamp n_createdate_eq) {
        this.n_createdate_eq = n_createdate_eq;
        if(!ObjectUtils.isEmpty(this.n_createdate_eq)){
            this.getSearchCond().eq("createdate", n_createdate_eq);
        }
    }
	private String n_htlb_eq;//[合同类别]
	public void setN_htlb_eq(String n_htlb_eq) {
        this.n_htlb_eq = n_htlb_eq;
        if(!ObjectUtils.isEmpty(this.n_htlb_eq)){
            this.getSearchCond().eq("htlb", n_htlb_eq);
        }
    }
	private String n_ormorgname_like;//[工作单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_zgxl_eq;//[最高学历]
	public void setN_zgxl_eq(String n_zgxl_eq) {
        this.n_zgxl_eq = n_zgxl_eq;
        if(!ObjectUtils.isEmpty(this.n_zgxl_eq)){
            this.getSearchCond().eq("zgxl", n_zgxl_eq);
        }
    }
	private Double n_bjgznx_eq;//[局工作年限]
	public void setN_bjgznx_eq(Double n_bjgznx_eq) {
        this.n_bjgznx_eq = n_bjgznx_eq;
        if(!ObjectUtils.isEmpty(this.n_bjgznx_eq)){
            this.getSearchCond().eq("bjgznx", n_bjgznx_eq);
        }
    }
	private String n_jg_eq;//[籍贯]
	public void setN_jg_eq(String n_jg_eq) {
        this.n_jg_eq = n_jg_eq;
        if(!ObjectUtils.isEmpty(this.n_jg_eq)){
            this.getSearchCond().eq("jg", n_jg_eq);
        }
    }
	private String n_jg_like;//[籍贯]
	public void setN_jg_like(String n_jg_like) {
        this.n_jg_like = n_jg_like;
        if(!ObjectUtils.isEmpty(this.n_jg_like)){
            this.getSearchCond().like("jg", n_jg_like);
        }
    }
	private String n_hjdz_like;//[户籍地址]
	public void setN_hjdz_like(String n_hjdz_like) {
        this.n_hjdz_like = n_hjdz_like;
        if(!ObjectUtils.isEmpty(this.n_hjdz_like)){
            this.getSearchCond().like("hjdz", n_hjdz_like);
        }
    }
	private Double n_bdwgznx_eq;//[本单位工作年限]
	public void setN_bdwgznx_eq(Double n_bdwgznx_eq) {
        this.n_bdwgznx_eq = n_bdwgznx_eq;
        if(!ObjectUtils.isEmpty(this.n_bdwgznx_eq)){
            this.getSearchCond().eq("bdwgznx", n_bdwgznx_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_htqx_eq;//[合同期限]
	public void setN_htqx_eq(Timestamp n_htqx_eq) {
        this.n_htqx_eq = n_htqx_eq;
        if(!ObjectUtils.isEmpty(this.n_htqx_eq)){
            this.getSearchCond().eq("htqx", n_htqx_eq);
        }
    }
	private Integer n_nj_like;//[年龄]
	public void setN_nj_like(Integer n_nj_like) {
        this.n_nj_like = n_nj_like;
        if(!ObjectUtils.isEmpty(this.n_nj_like)){
            this.getSearchCond().like("nj", n_nj_like);
        }
    }
	private String n_hkxz_eq;//[户口性质]
	public void setN_hkxz_eq(String n_hkxz_eq) {
        this.n_hkxz_eq = n_hkxz_eq;
        if(!ObjectUtils.isEmpty(this.n_hkxz_eq)){
            this.getSearchCond().eq("hkxz", n_hkxz_eq);
        }
    }
	private String n_zw_eq;//[职务]
	public void setN_zw_eq(String n_zw_eq) {
        this.n_zw_eq = n_zw_eq;
        if(!ObjectUtils.isEmpty(this.n_zw_eq)){
            this.getSearchCond().eq("zw", n_zw_eq);
        }
    }
	private Integer n_sfzgxl_eq;//[是否最高学历]
	public void setN_sfzgxl_eq(Integer n_sfzgxl_eq) {
        this.n_sfzgxl_eq = n_sfzgxl_eq;
        if(!ObjectUtils.isEmpty(this.n_sfzgxl_eq)){
            this.getSearchCond().eq("sfzgxl", n_sfzgxl_eq);
        }
    }
	private String n_mz_eq;//[民族]
	public void setN_mz_eq(String n_mz_eq) {
        this.n_mz_eq = n_mz_eq;
        if(!ObjectUtils.isEmpty(this.n_mz_eq)){
            this.getSearchCond().eq("mz", n_mz_eq);
        }
    }
	private String n_shortname_like;//[部门名称]
	public void setN_shortname_like(String n_shortname_like) {
        this.n_shortname_like = n_shortname_like;
        if(!ObjectUtils.isEmpty(this.n_shortname_like)){
            this.getSearchCond().like("shortname", n_shortname_like);
        }
    }
	private String n_zzdzs_like;//[工作单位]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门名称]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门名称]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("pimpersonname", query)   
                        .or().like("ygbh", query)            
            );
		 }
	}
}




