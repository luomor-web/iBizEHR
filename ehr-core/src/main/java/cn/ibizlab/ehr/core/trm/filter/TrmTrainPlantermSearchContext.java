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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm;
/**
 * 关系型数据实体[TrmTrainPlanterm] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainPlantermSearchContext extends QueryWrapperContext<TrmTrainPlanterm> {

	private String n_pxfs_eq;//[培训方式]
	public void setN_pxfs_eq(String n_pxfs_eq) {
        this.n_pxfs_eq = n_pxfs_eq;
        if(!ObjectUtils.isEmpty(this.n_pxfs_eq)){
            this.getSearchCond().eq("pxfs", n_pxfs_eq);
        }
    }
	private String n_pxdxlb_eq;//[培训对象类别]
	public void setN_pxdxlb_eq(String n_pxdxlb_eq) {
        this.n_pxdxlb_eq = n_pxdxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxdxlb_eq)){
            this.getSearchCond().eq("pxdxlb", n_pxdxlb_eq);
        }
    }
	private String n_bjzt_eq;//[班级状态]
	public void setN_bjzt_eq(String n_bjzt_eq) {
        this.n_bjzt_eq = n_bjzt_eq;
        if(!ObjectUtils.isEmpty(this.n_bjzt_eq)){
            this.getSearchCond().eq("bjzt", n_bjzt_eq);
        }
    }
	private String n_pxlb_eq;//[培训类别]
	public void setN_pxlb_eq(String n_pxlb_eq) {
        this.n_pxlb_eq = n_pxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxlb_eq)){
            this.getSearchCond().eq("pxlb", n_pxlb_eq);
        }
    }
	private String n_jscc_eq;//[教师出处]
	public void setN_jscc_eq(String n_jscc_eq) {
        this.n_jscc_eq = n_jscc_eq;
        if(!ObjectUtils.isEmpty(this.n_jscc_eq)){
            this.getSearchCond().eq("jscc", n_jscc_eq);
        }
    }
	private String n_zt_eq;//[状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_sfqdpxxy_eq;//[是否签订培训协议]
	public void setN_sfqdpxxy_eq(String n_sfqdpxxy_eq) {
        this.n_sfqdpxxy_eq = n_sfqdpxxy_eq;
        if(!ObjectUtils.isEmpty(this.n_sfqdpxxy_eq)){
            this.getSearchCond().eq("sfqdpxxy", n_sfqdpxxy_eq);
        }
    }
	private String n_trmtrainplantermname_like;//[培训立项名称]
	public void setN_trmtrainplantermname_like(String n_trmtrainplantermname_like) {
        this.n_trmtrainplantermname_like = n_trmtrainplantermname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_like)){
            this.getSearchCond().like("trmtrainplantermname", n_trmtrainplantermname_like);
        }
    }
	private String n_trmtrainagencyname_eq;//[培训机构名称]
	public void setN_trmtrainagencyname_eq(String n_trmtrainagencyname_eq) {
        this.n_trmtrainagencyname_eq = n_trmtrainagencyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_eq)){
            this.getSearchCond().eq("trmtrainagencyname", n_trmtrainagencyname_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[培训机构名称]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSearchCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_trmtraincoursename_eq;//[课程]
	public void setN_trmtraincoursename_eq(String n_trmtraincoursename_eq) {
        this.n_trmtraincoursename_eq = n_trmtraincoursename_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_eq)){
            this.getSearchCond().eq("trmtraincoursename", n_trmtraincoursename_eq);
        }
    }
	private String n_trmtraincoursename_like;//[课程]
	public void setN_trmtraincoursename_like(String n_trmtraincoursename_like) {
        this.n_trmtraincoursename_like = n_trmtraincoursename_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_like)){
            this.getSearchCond().like("trmtraincoursename", n_trmtraincoursename_like);
        }
    }
	private String n_trmtrainteachername_eq;//[讲师]
	public void setN_trmtrainteachername_eq(String n_trmtrainteachername_eq) {
        this.n_trmtrainteachername_eq = n_trmtrainteachername_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteachername_eq)){
            this.getSearchCond().eq("trmtrainteachername", n_trmtrainteachername_eq);
        }
    }
	private String n_trmtrainteachername_like;//[讲师]
	public void setN_trmtrainteachername_like(String n_trmtrainteachername_like) {
        this.n_trmtrainteachername_like = n_trmtrainteachername_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteachername_like)){
            this.getSearchCond().like("trmtrainteachername", n_trmtrainteachername_like);
        }
    }
	private String n_trmtrainplanname_eq;//[培训立项名称]
	public void setN_trmtrainplanname_eq(String n_trmtrainplanname_eq) {
        this.n_trmtrainplanname_eq = n_trmtrainplanname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplanname_eq)){
            this.getSearchCond().eq("trmtrainplanname", n_trmtrainplanname_eq);
        }
    }
	private String n_trmtrainplanname_like;//[培训立项名称]
	public void setN_trmtrainplanname_like(String n_trmtrainplanname_like) {
        this.n_trmtrainplanname_like = n_trmtrainplanname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplanname_like)){
            this.getSearchCond().like("trmtrainplanname", n_trmtrainplanname_like);
        }
    }
	private String n_trmtrainplanid_eq;//[培训计划标识]
	public void setN_trmtrainplanid_eq(String n_trmtrainplanid_eq) {
        this.n_trmtrainplanid_eq = n_trmtrainplanid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplanid_eq)){
            this.getSearchCond().eq("trmtrainplanid", n_trmtrainplanid_eq);
        }
    }
	private String n_trmtrainteacherid_eq;//[培训教师标识]
	public void setN_trmtrainteacherid_eq(String n_trmtrainteacherid_eq) {
        this.n_trmtrainteacherid_eq = n_trmtrainteacherid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteacherid_eq)){
            this.getSearchCond().eq("trmtrainteacherid", n_trmtrainteacherid_eq);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSearchCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }
	private String n_trmtraincourseid_eq;//[培训课程标识]
	public void setN_trmtraincourseid_eq(String n_trmtraincourseid_eq) {
        this.n_trmtraincourseid_eq = n_trmtraincourseid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincourseid_eq)){
            this.getSearchCond().eq("trmtraincourseid", n_trmtraincourseid_eq);
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
                     wrapper.like("trmtrainplanname", query)   
            );
		 }
	}
}




