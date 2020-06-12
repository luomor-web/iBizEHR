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
import cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion;
/**
 * 关系型数据实体[TrmDemdeftion] 查询条件对象
 */
@Slf4j
@Data
public class TrmDemdeftionSearchContext extends QueryWrapperContext<TrmDemdeftion> {

	private String n_dcbjb_eq;//[调查表级别]
	public void setN_dcbjb_eq(String n_dcbjb_eq) {
        this.n_dcbjb_eq = n_dcbjb_eq;
        if(!ObjectUtils.isEmpty(this.n_dcbjb_eq)){
            this.getSearchCond().eq("dcbjb", n_dcbjb_eq);
        }
    }
	private String n_pxbmc_like;//[培训班名称]
	public void setN_pxbmc_like(String n_pxbmc_like) {
        this.n_pxbmc_like = n_pxbmc_like;
        if(!ObjectUtils.isEmpty(this.n_pxbmc_like)){
            this.getSearchCond().like("pxbmc", n_pxbmc_like);
        }
    }
	private String n_dcscjd_eq;//[调查所处季度]
	public void setN_dcscjd_eq(String n_dcscjd_eq) {
        this.n_dcscjd_eq = n_dcscjd_eq;
        if(!ObjectUtils.isEmpty(this.n_dcscjd_eq)){
            this.getSearchCond().eq("dcscjd", n_dcscjd_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_pxjssj_ltandeq;//[培训结束时间]
	public void setN_pxjssj_ltandeq(Timestamp n_pxjssj_ltandeq) {
        this.n_pxjssj_ltandeq = n_pxjssj_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_pxjssj_ltandeq)){
            this.getSearchCond().le("pxjssj", n_pxjssj_ltandeq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_dcdxlx_eq;//[调查对象类型]
	public void setN_dcdxlx_eq(String n_dcdxlx_eq) {
        this.n_dcdxlx_eq = n_dcdxlx_eq;
        if(!ObjectUtils.isEmpty(this.n_dcdxlx_eq)){
            this.getSearchCond().eq("dcdxlx", n_dcdxlx_eq);
        }
    }
	private String n_dcyglb_eq;//[调查员工类别]
	public void setN_dcyglb_eq(String n_dcyglb_eq) {
        this.n_dcyglb_eq = n_dcyglb_eq;
        if(!ObjectUtils.isEmpty(this.n_dcyglb_eq)){
            this.getSearchCond().eq("dcyglb", n_dcyglb_eq);
        }
    }
	private String n_dcblx_eq;//[调查表类型]
	public void setN_dcblx_eq(String n_dcblx_eq) {
        this.n_dcblx_eq = n_dcblx_eq;
        if(!ObjectUtils.isEmpty(this.n_dcblx_eq)){
            this.getSearchCond().eq("dcblx", n_dcblx_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_pxkssj_gtandeq;//[培训开始时间]
	public void setN_pxkssj_gtandeq(Timestamp n_pxkssj_gtandeq) {
        this.n_pxkssj_gtandeq = n_pxkssj_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_pxkssj_gtandeq)){
            this.getSearchCond().ge("pxkssj", n_pxkssj_gtandeq);
        }
    }
	private String n_xqfl_eq;//[需求分类]
	public void setN_xqfl_eq(String n_xqfl_eq) {
        this.n_xqfl_eq = n_xqfl_eq;
        if(!ObjectUtils.isEmpty(this.n_xqfl_eq)){
            this.getSearchCond().eq("xqfl", n_xqfl_eq);
        }
    }
	private String n_trmdemdeftionname_like;//[培训汇总]
	public void setN_trmdemdeftionname_like(String n_trmdemdeftionname_like) {
        this.n_trmdemdeftionname_like = n_trmdemdeftionname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdemdeftionname_like)){
            this.getSearchCond().like("trmdemdeftionname", n_trmdemdeftionname_like);
        }
    }
	private String n_dcscnd_eq;//[调查所处年度]
	public void setN_dcscnd_eq(String n_dcscnd_eq) {
        this.n_dcscnd_eq = n_dcscnd_eq;
        if(!ObjectUtils.isEmpty(this.n_dcscnd_eq)){
            this.getSearchCond().eq("dcscnd", n_dcscnd_eq);
        }
    }
	private String n_pxmk_eq;//[培训模块]
	public void setN_pxmk_eq(String n_pxmk_eq) {
        this.n_pxmk_eq = n_pxmk_eq;
        if(!ObjectUtils.isEmpty(this.n_pxmk_eq)){
            this.getSearchCond().eq("pxmk", n_pxmk_eq);
        }
    }
	private String n_trmtraincoursename_eq;//[培训课程]
	public void setN_trmtraincoursename_eq(String n_trmtraincoursename_eq) {
        this.n_trmtraincoursename_eq = n_trmtraincoursename_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_eq)){
            this.getSearchCond().eq("trmtraincoursename", n_trmtraincoursename_eq);
        }
    }
	private String n_trmtraincoursename_like;//[培训课程]
	public void setN_trmtraincoursename_like(String n_trmtraincoursename_like) {
        this.n_trmtraincoursename_like = n_trmtraincoursename_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_like)){
            this.getSearchCond().like("trmtraincoursename", n_trmtraincoursename_like);
        }
    }
	private String n_trmtrainfillinname_eq;//[培训项目部门填报名称]
	public void setN_trmtrainfillinname_eq(String n_trmtrainfillinname_eq) {
        this.n_trmtrainfillinname_eq = n_trmtrainfillinname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinname_eq)){
            this.getSearchCond().eq("trmtrainfillinname", n_trmtrainfillinname_eq);
        }
    }
	private String n_trmtrainfillinname_like;//[培训项目部门填报名称]
	public void setN_trmtrainfillinname_like(String n_trmtrainfillinname_like) {
        this.n_trmtrainfillinname_like = n_trmtrainfillinname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinname_like)){
            this.getSearchCond().like("trmtrainfillinname", n_trmtrainfillinname_like);
        }
    }
	private String n_ormorgname_eq;//[单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_trmdepartname_eq;//[培训需求名称]
	public void setN_trmdepartname_eq(String n_trmdepartname_eq) {
        this.n_trmdepartname_eq = n_trmdepartname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdepartname_eq)){
            this.getSearchCond().eq("trmdepartname", n_trmdepartname_eq);
        }
    }
	private String n_trmdepartname_like;//[培训需求名称]
	public void setN_trmdepartname_like(String n_trmdepartname_like) {
        this.n_trmdepartname_like = n_trmdepartname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdepartname_like)){
            this.getSearchCond().like("trmdepartname", n_trmdepartname_like);
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
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmtrainfillinid_eq;//[培训项目部门填报标识]
	public void setN_trmtrainfillinid_eq(String n_trmtrainfillinid_eq) {
        this.n_trmtrainfillinid_eq = n_trmtrainfillinid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinid_eq)){
            this.getSearchCond().eq("trmtrainfillinid", n_trmtrainfillinid_eq);
        }
    }
	private String n_trmtraincourseid_eq;//[培训课程标识]
	public void setN_trmtraincourseid_eq(String n_trmtraincourseid_eq) {
        this.n_trmtraincourseid_eq = n_trmtraincourseid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincourseid_eq)){
            this.getSearchCond().eq("trmtraincourseid", n_trmtraincourseid_eq);
        }
    }
	private String n_trmdepartid_eq;//[培训需求填报标识]
	public void setN_trmdepartid_eq(String n_trmdepartid_eq) {
        this.n_trmdepartid_eq = n_trmdepartid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdepartid_eq)){
            this.getSearchCond().eq("trmdepartid", n_trmdepartid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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




