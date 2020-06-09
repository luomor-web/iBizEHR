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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfile;
/**
 * 关系型数据实体[PcmProfile] 查询条件对象
 */
@Slf4j
@Data
public class PcmProfileSearchContext extends QueryWrapperContext<PcmProfile> {

	private String n_gwlb_eq;//[岗位类别]
	public void setN_gwlb_eq(String n_gwlb_eq) {
        this.n_gwlb_eq = n_gwlb_eq;
        if(!ObjectUtils.isEmpty(this.n_gwlb_eq)){
            this.getSearchCond().eq("gwlb", n_gwlb_eq);
        }
    }
	private String n_r_lastdiscipline_like;//[专业名称]
	public void setN_r_lastdiscipline_like(String n_r_lastdiscipline_like) {
        this.n_r_lastdiscipline_like = n_r_lastdiscipline_like;
        if(!ObjectUtils.isEmpty(this.n_r_lastdiscipline_like)){
            this.getSearchCond().like("r_lastdiscipline", n_r_lastdiscipline_like);
        }
    }
	private String n_bloodtype_eq;//[血型]
	public void setN_bloodtype_eq(String n_bloodtype_eq) {
        this.n_bloodtype_eq = n_bloodtype_eq;
        if(!ObjectUtils.isEmpty(this.n_bloodtype_eq)){
            this.getSearchCond().eq("bloodtype", n_bloodtype_eq);
        }
    }
	private String n_xkml_eq;//[一级学科]
	public void setN_xkml_eq(String n_xkml_eq) {
        this.n_xkml_eq = n_xkml_eq;
        if(!ObjectUtils.isEmpty(this.n_xkml_eq)){
            this.getSearchCond().eq("xkml", n_xkml_eq);
        }
    }
	private String n_jzpspyjyy_eq;//[局初审意见原因]
	public void setN_jzpspyjyy_eq(String n_jzpspyjyy_eq) {
        this.n_jzpspyjyy_eq = n_jzpspyjyy_eq;
        if(!ObjectUtils.isEmpty(this.n_jzpspyjyy_eq)){
            this.getSearchCond().eq("jzpspyjyy", n_jzpspyjyy_eq);
        }
    }
	private String n_yglxshgz_eq;//[员工类型审核规则]
	public void setN_yglxshgz_eq(String n_yglxshgz_eq) {
        this.n_yglxshgz_eq = n_yglxshgz_eq;
        if(!ObjectUtils.isEmpty(this.n_yglxshgz_eq)){
            this.getSearchCond().eq("yglxshgz", n_yglxshgz_eq);
        }
    }
	private String n_pcmprofilename_like;//[姓名]
	public void setN_pcmprofilename_like(String n_pcmprofilename_like) {
        this.n_pcmprofilename_like = n_pcmprofilename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_like)){
            this.getSearchCond().like("pcmprofilename", n_pcmprofilename_like);
        }
    }
	private String n_rzqd_eq;//[入职渠道]
	public void setN_rzqd_eq(String n_rzqd_eq) {
        this.n_rzqd_eq = n_rzqd_eq;
        if(!ObjectUtils.isEmpty(this.n_rzqd_eq)){
            this.getSearchCond().eq("rzqd", n_rzqd_eq);
        }
    }
	private String n_rpr_eq;//[户籍所在地]
	public void setN_rpr_eq(String n_rpr_eq) {
        this.n_rpr_eq = n_rpr_eq;
        if(!ObjectUtils.isEmpty(this.n_rpr_eq)){
            this.getSearchCond().eq("rpr", n_rpr_eq);
        }
    }
	private String n_jzbspyjyy_eq;//[局审批意见原因]
	public void setN_jzbspyjyy_eq(String n_jzbspyjyy_eq) {
        this.n_jzbspyjyy_eq = n_jzbspyjyy_eq;
        if(!ObjectUtils.isEmpty(this.n_jzbspyjyy_eq)){
            this.getSearchCond().eq("jzbspyjyy", n_jzbspyjyy_eq);
        }
    }
	private String n_yglx_eq;//[申报类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSearchCond().eq("yglx", n_yglx_eq);
        }
    }
	private String n_ywzdjbs_eq;//[有无重大疾病史]
	public void setN_ywzdjbs_eq(String n_ywzdjbs_eq) {
        this.n_ywzdjbs_eq = n_ywzdjbs_eq;
        if(!ObjectUtils.isEmpty(this.n_ywzdjbs_eq)){
            this.getSearchCond().eq("ywzdjbs", n_ywzdjbs_eq);
        }
    }
	private String n_rlsb_ypzzt_eq;//[应聘者状态（人力上报使用）]
	public void setN_rlsb_ypzzt_eq(String n_rlsb_ypzzt_eq) {
        this.n_rlsb_ypzzt_eq = n_rlsb_ypzzt_eq;
        if(!ObjectUtils.isEmpty(this.n_rlsb_ypzzt_eq)){
            this.getSearchCond().eq("rlsb_ypzzt", n_rlsb_ypzzt_eq);
        }
    }
	private String n_educationlevel_eq;//[最高学历]
	public void setN_educationlevel_eq(String n_educationlevel_eq) {
        this.n_educationlevel_eq = n_educationlevel_eq;
        if(!ObjectUtils.isEmpty(this.n_educationlevel_eq)){
            this.getSearchCond().eq("educationlevel", n_educationlevel_eq);
        }
    }
	private String n_zplx_eq;//[招聘类型]
	public void setN_zplx_eq(String n_zplx_eq) {
        this.n_zplx_eq = n_zplx_eq;
        if(!ObjectUtils.isEmpty(this.n_zplx_eq)){
            this.getSearchCond().eq("zplx", n_zplx_eq);
        }
    }
	private String n_yjsnf_eq;//[毕业年份]
	public void setN_yjsnf_eq(String n_yjsnf_eq) {
        this.n_yjsnf_eq = n_yjsnf_eq;
        if(!ObjectUtils.isEmpty(this.n_yjsnf_eq)){
            this.getSearchCond().eq("yjsnf", n_yjsnf_eq);
        }
    }
	private String n_r_lastschool_like;//[毕业学校]
	public void setN_r_lastschool_like(String n_r_lastschool_like) {
        this.n_r_lastschool_like = n_r_lastschool_like;
        if(!ObjectUtils.isEmpty(this.n_r_lastschool_like)){
            this.getSearchCond().like("r_lastschool", n_r_lastschool_like);
        }
    }
	private String n_nativeplace_eq;//[籍贯]
	public void setN_nativeplace_eq(String n_nativeplace_eq) {
        this.n_nativeplace_eq = n_nativeplace_eq;
        if(!ObjectUtils.isEmpty(this.n_nativeplace_eq)){
            this.getSearchCond().eq("nativeplace", n_nativeplace_eq);
        }
    }
	private String n_certificatenumber_like;//[证件号码]
	public void setN_certificatenumber_like(String n_certificatenumber_like) {
        this.n_certificatenumber_like = n_certificatenumber_like;
        if(!ObjectUtils.isEmpty(this.n_certificatenumber_like)){
            this.getSearchCond().like("certificatenumber", n_certificatenumber_like);
        }
    }
	private String n_certificatetype_eq;//[证件类型]
	public void setN_certificatetype_eq(String n_certificatetype_eq) {
        this.n_certificatetype_eq = n_certificatetype_eq;
        if(!ObjectUtils.isEmpty(this.n_certificatetype_eq)){
            this.getSearchCond().eq("certificatetype", n_certificatetype_eq);
        }
    }
	private String n_nation_eq;//[民族]
	public void setN_nation_eq(String n_nation_eq) {
        this.n_nation_eq = n_nation_eq;
        if(!ObjectUtils.isEmpty(this.n_nation_eq)){
            this.getSearchCond().eq("nation", n_nation_eq);
        }
    }
	private String n_sftgcp_eq;//[是否通过测评]
	public void setN_sftgcp_eq(String n_sftgcp_eq) {
        this.n_sftgcp_eq = n_sftgcp_eq;
        if(!ObjectUtils.isEmpty(this.n_sftgcp_eq)){
            this.getSearchCond().eq("sftgcp", n_sftgcp_eq);
        }
    }
	private String n_jldspyjyy_eq;//[局审核意见原因]
	public void setN_jldspyjyy_eq(String n_jldspyjyy_eq) {
        this.n_jldspyjyy_eq = n_jldspyjyy_eq;
        if(!ObjectUtils.isEmpty(this.n_jldspyjyy_eq)){
            this.getSearchCond().eq("jldspyjyy", n_jldspyjyy_eq);
        }
    }
	private String n_sfxzy_eq;//[是否小专业]
	public void setN_sfxzy_eq(String n_sfxzy_eq) {
        this.n_sfxzy_eq = n_sfxzy_eq;
        if(!ObjectUtils.isEmpty(this.n_sfxzy_eq)){
            this.getSearchCond().eq("sfxzy", n_sfxzy_eq);
        }
    }
	private String n_gender_eq;//[性别]
	public void setN_gender_eq(String n_gender_eq) {
        this.n_gender_eq = n_gender_eq;
        if(!ObjectUtils.isEmpty(this.n_gender_eq)){
            this.getSearchCond().eq("gender", n_gender_eq);
        }
    }
	private String n_xxxz_eq;//[学校性质]
	public void setN_xxxz_eq(String n_xxxz_eq) {
        this.n_xxxz_eq = n_xxxz_eq;
        if(!ObjectUtils.isEmpty(this.n_xxxz_eq)){
            this.getSearchCond().eq("xxxz", n_xxxz_eq);
        }
    }
	private String n_sfxzbjnbry_eq;//[选择内部人员]
	public void setN_sfxzbjnbry_eq(String n_sfxzbjnbry_eq) {
        this.n_sfxzbjnbry_eq = n_sfxzbjnbry_eq;
        if(!ObjectUtils.isEmpty(this.n_sfxzbjnbry_eq)){
            this.getSearchCond().eq("sfxzbjnbry", n_sfxzbjnbry_eq);
        }
    }
	private String n_yydj_eq;//[语言等级]
	public void setN_yydj_eq(String n_yydj_eq) {
        this.n_yydj_eq = n_yydj_eq;
        if(!ObjectUtils.isEmpty(this.n_yydj_eq)){
            this.getSearchCond().eq("yydj", n_yydj_eq);
        }
    }
	private String n_polity_eq;//[政治面貌]
	public void setN_polity_eq(String n_polity_eq) {
        this.n_polity_eq = n_polity_eq;
        if(!ObjectUtils.isEmpty(this.n_polity_eq)){
            this.getSearchCond().eq("polity", n_polity_eq);
        }
    }
	private String n_wedstate_eq;//[婚姻状况]
	public void setN_wedstate_eq(String n_wedstate_eq) {
        this.n_wedstate_eq = n_wedstate_eq;
        if(!ObjectUtils.isEmpty(this.n_wedstate_eq)){
            this.getSearchCond().eq("wedstate", n_wedstate_eq);
        }
    }
	private String n_rgjytg_eq;//[人工校验通过]
	public void setN_rgjytg_eq(String n_rgjytg_eq) {
        this.n_rgjytg_eq = n_rgjytg_eq;
        if(!ObjectUtils.isEmpty(this.n_rgjytg_eq)){
            this.getSearchCond().eq("rgjytg", n_rgjytg_eq);
        }
    }
	private String n_hklx_eq;//[户口类型]
	public void setN_hklx_eq(String n_hklx_eq) {
        this.n_hklx_eq = n_hklx_eq;
        if(!ObjectUtils.isEmpty(this.n_hklx_eq)){
            this.getSearchCond().eq("hklx", n_hklx_eq);
        }
    }
	private String n_qzsm_eq;//[本人承诺以上内容均属实并签字]
	public void setN_qzsm_eq(String n_qzsm_eq) {
        this.n_qzsm_eq = n_qzsm_eq;
        if(!ObjectUtils.isEmpty(this.n_qzsm_eq)){
            this.getSearchCond().eq("qzsm", n_qzsm_eq);
        }
    }
	private String n_xznf_eq;//[招聘年份]
	public void setN_xznf_eq(String n_xznf_eq) {
        this.n_xznf_eq = n_xznf_eq;
        if(!ObjectUtils.isEmpty(this.n_xznf_eq)){
            this.getSearchCond().eq("xznf", n_xznf_eq);
        }
    }
	private String n_profiletype_eq;//[应聘者状态]
	public void setN_profiletype_eq(String n_profiletype_eq) {
        this.n_profiletype_eq = n_profiletype_eq;
        if(!ObjectUtils.isEmpty(this.n_profiletype_eq)){
            this.getSearchCond().eq("profiletype", n_profiletype_eq);
        }
    }
	private String n_ormdutyname_eq;//[挂职进职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSearchCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[挂职进职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSearchCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[虚拟部门名称]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[虚拟部门名称]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
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
	private String n_pimpersonname_eq;//[退休员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[退休员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormpostname_eq;//[挂职进岗位]
	public void setN_ormpostname_eq(String n_ormpostname_eq) {
        this.n_ormpostname_eq = n_ormpostname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_eq)){
            this.getSearchCond().eq("ormpostname", n_ormpostname_eq);
        }
    }
	private String n_ormpostname_like;//[挂职进岗位]
	public void setN_ormpostname_like(String n_ormpostname_like) {
        this.n_ormpostname_like = n_ormpostname_like;
        if(!ObjectUtils.isEmpty(this.n_ormpostname_like)){
            this.getSearchCond().like("ormpostname", n_ormpostname_like);
        }
    }
	private String n_zzdzs_like;//[组织]
	public void setN_zzdzs_like(String n_zzdzs_like) {
        this.n_zzdzs_like = n_zzdzs_like;
        if(!ObjectUtils.isEmpty(this.n_zzdzs_like)){
            this.getSearchCond().like("zzdzs", n_zzdzs_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[虚拟部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
        }
    }
	private String n_ormpostid_eq;//[挂职进岗位标识]
	public void setN_ormpostid_eq(String n_ormpostid_eq) {
        this.n_ormpostid_eq = n_ormpostid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormpostid_eq)){
            this.getSearchCond().eq("ormpostid", n_ormpostid_eq);
        }
    }
	private String n_ormdutyid_eq;//[挂职进职务标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSearchCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_checkresult_eq;//[校验结果]
	public void setN_checkresult_eq(String n_checkresult_eq) {
        this.n_checkresult_eq = n_checkresult_eq;
        if(!ObjectUtils.isEmpty(this.n_checkresult_eq)){
            this.getSearchCond().eq("checkresult", n_checkresult_eq);
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
                     wrapper.like("pcmprofilename", query)   
                        .or().like("ygbh", query)            
            );
		 }
	}
}




