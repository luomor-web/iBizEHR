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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency;
/**
 * 关系型数据实体[TrmTrainAgency] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainAgencySearchContext extends QueryWrapperContext<TrmTrainAgency> {

	private String n_jgdj_eq;//[机构等级]
	public void setN_jgdj_eq(String n_jgdj_eq) {
        this.n_jgdj_eq = n_jgdj_eq;
        if(!ObjectUtils.isEmpty(this.n_jgdj_eq)){
            this.getSearchCond().eq("jgdj", n_jgdj_eq);
        }
    }
	private String n_jglx_eq;//[机构类型]
	public void setN_jglx_eq(String n_jglx_eq) {
        this.n_jglx_eq = n_jglx_eq;
        if(!ObjectUtils.isEmpty(this.n_jglx_eq)){
            this.getSearchCond().eq("jglx", n_jglx_eq);
        }
    }
	private Integer n_sffc_eq;//[是否封存]
	public void setN_sffc_eq(Integer n_sffc_eq) {
        this.n_sffc_eq = n_sffc_eq;
        if(!ObjectUtils.isEmpty(this.n_sffc_eq)){
            this.getSearchCond().eq("sffc", n_sffc_eq);
        }
    }
	private Integer n_sfgx_eq;//[是否共享]
	public void setN_sfgx_eq(Integer n_sfgx_eq) {
        this.n_sfgx_eq = n_sfgx_eq;
        if(!ObjectUtils.isEmpty(this.n_sfgx_eq)){
            this.getSearchCond().eq("sfgx", n_sfgx_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[培训机构名称]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSearchCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_jgbm_like;//[机构编码]
	public void setN_jgbm_like(String n_jgbm_like) {
        this.n_jgbm_like = n_jgbm_like;
        if(!ObjectUtils.isEmpty(this.n_jgbm_like)){
            this.getSearchCond().like("jgbm", n_jgbm_like);
        }
    }
	private String n_kplx_eq;//[开票类型]
	public void setN_kplx_eq(String n_kplx_eq) {
        this.n_kplx_eq = n_kplx_eq;
        if(!ObjectUtils.isEmpty(this.n_kplx_eq)){
            this.getSearchCond().eq("kplx", n_kplx_eq);
        }
    }
	private String n_jglb_eq;//[机构性质]
	public void setN_jglb_eq(String n_jglb_eq) {
        this.n_jglb_eq = n_jglb_eq;
        if(!ObjectUtils.isEmpty(this.n_jglb_eq)){
            this.getSearchCond().eq("jglb", n_jglb_eq);
        }
    }
	private String n_zcxx_like;//[注册信息]
	public void setN_zcxx_like(String n_zcxx_like) {
        this.n_zcxx_like = n_zcxx_like;
        if(!ObjectUtils.isEmpty(this.n_zcxx_like)){
            this.getSearchCond().like("zcxx", n_zcxx_like);
        }
    }
	private String n_lxdh_like;//[联系电话]
	public void setN_lxdh_like(String n_lxdh_like) {
        this.n_lxdh_like = n_lxdh_like;
        if(!ObjectUtils.isEmpty(this.n_lxdh_like)){
            this.getSearchCond().like("lxdh", n_lxdh_like);
        }
    }
	private String n_trmtrainagencyname2_eq;//[上级机构]
	public void setN_trmtrainagencyname2_eq(String n_trmtrainagencyname2_eq) {
        this.n_trmtrainagencyname2_eq = n_trmtrainagencyname2_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname2_eq)){
            this.getSearchCond().eq("trmtrainagencyname2", n_trmtrainagencyname2_eq);
        }
    }
	private String n_trmtrainagencyname2_like;//[上级机构]
	public void setN_trmtrainagencyname2_like(String n_trmtrainagencyname2_like) {
        this.n_trmtrainagencyname2_like = n_trmtrainagencyname2_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname2_like)){
            this.getSearchCond().like("trmtrainagencyname2", n_trmtrainagencyname2_like);
        }
    }
	private String n_ormorgname_eq;//[所属单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[所属单位]
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
	private String n_trmtrainagencyid2_eq;//[培训机构标识]
	public void setN_trmtrainagencyid2_eq(String n_trmtrainagencyid2_eq) {
        this.n_trmtrainagencyid2_eq = n_trmtrainagencyid2_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid2_eq)){
            this.getSearchCond().eq("trmtrainagencyid2", n_trmtrainagencyid2_eq);
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
                     wrapper.like("trmtrainagencyname", query)   
            );
		 }
	}
}




