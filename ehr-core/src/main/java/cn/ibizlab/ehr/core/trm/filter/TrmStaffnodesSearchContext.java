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
import cn.ibizlab.ehr.core.trm.domain.TrmStaffnodes;
/**
 * 关系型数据实体[TrmStaffnodes] 查询条件对象
 */
@Slf4j
@Data
public class TrmStaffnodesSearchContext extends QueryWrapperContext<TrmStaffnodes> {

	private String n_bz_eq;//[备注]
	public void setN_bz_eq(String n_bz_eq) {
        this.n_bz_eq = n_bz_eq;
        if(!ObjectUtils.isEmpty(this.n_bz_eq)){
            this.getSearchCond().eq("bz", n_bz_eq);
        }
    }
	private String n_pxnr_eq;//[培训内容]
	public void setN_pxnr_eq(String n_pxnr_eq) {
        this.n_pxnr_eq = n_pxnr_eq;
        if(!ObjectUtils.isEmpty(this.n_pxnr_eq)){
            this.getSearchCond().eq("pxnr", n_pxnr_eq);
        }
    }
	private String n_trmstaffnodesname_like;//[员工需求填报名称]
	public void setN_trmstaffnodesname_like(String n_trmstaffnodesname_like) {
        this.n_trmstaffnodesname_like = n_trmstaffnodesname_like;
        if(!ObjectUtils.isEmpty(this.n_trmstaffnodesname_like)){
            this.getSearchCond().like("trmstaffnodesname", n_trmstaffnodesname_like);
        }
    }
	private String n_pxfs_eq;//[培训方式]
	public void setN_pxfs_eq(String n_pxfs_eq) {
        this.n_pxfs_eq = n_pxfs_eq;
        if(!ObjectUtils.isEmpty(this.n_pxfs_eq)){
            this.getSearchCond().eq("pxfs", n_pxfs_eq);
        }
    }
	private String n_pxlb_eq;//[培训类别]
	public void setN_pxlb_eq(String n_pxlb_eq) {
        this.n_pxlb_eq = n_pxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxlb_eq)){
            this.getSearchCond().eq("pxlb", n_pxlb_eq);
        }
    }
	private String n_jpcd_eq;//[紧迫程度]
	public void setN_jpcd_eq(String n_jpcd_eq) {
        this.n_jpcd_eq = n_jpcd_eq;
        if(!ObjectUtils.isEmpty(this.n_jpcd_eq)){
            this.getSearchCond().eq("jpcd", n_jpcd_eq);
        }
    }
	private String n_trmstaffname_eq;//[员工需求调查表名称]
	public void setN_trmstaffname_eq(String n_trmstaffname_eq) {
        this.n_trmstaffname_eq = n_trmstaffname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmstaffname_eq)){
            this.getSearchCond().eq("trmstaffname", n_trmstaffname_eq);
        }
    }
	private String n_trmstaffname_like;//[员工需求调查表名称]
	public void setN_trmstaffname_like(String n_trmstaffname_like) {
        this.n_trmstaffname_like = n_trmstaffname_like;
        if(!ObjectUtils.isEmpty(this.n_trmstaffname_like)){
            this.getSearchCond().like("trmstaffname", n_trmstaffname_like);
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
	private String n_trmtraincoursename_eq;//[培训课程名称]
	public void setN_trmtraincoursename_eq(String n_trmtraincoursename_eq) {
        this.n_trmtraincoursename_eq = n_trmtraincoursename_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_eq)){
            this.getSearchCond().eq("trmtraincoursename", n_trmtraincoursename_eq);
        }
    }
	private String n_trmtraincoursename_like;//[培训课程名称]
	public void setN_trmtraincoursename_like(String n_trmtraincoursename_like) {
        this.n_trmtraincoursename_like = n_trmtraincoursename_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_like)){
            this.getSearchCond().like("trmtraincoursename", n_trmtraincoursename_like);
        }
    }
	private String n_trmtraincourseid_eq;//[培训课程标识]
	public void setN_trmtraincourseid_eq(String n_trmtraincourseid_eq) {
        this.n_trmtraincourseid_eq = n_trmtraincourseid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincourseid_eq)){
            this.getSearchCond().eq("trmtraincourseid", n_trmtraincourseid_eq);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSearchCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }
	private String n_trmstaffid_eq;//[员工需求调查表标识]
	public void setN_trmstaffid_eq(String n_trmstaffid_eq) {
        this.n_trmstaffid_eq = n_trmstaffid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmstaffid_eq)){
            this.getSearchCond().eq("trmstaffid", n_trmstaffid_eq);
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
                     wrapper.like("trmstaffnodesname", query)   
            );
		 }
	}
}




