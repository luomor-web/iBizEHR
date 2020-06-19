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
import cn.ibizlab.ehr.core.trm.domain.TrmDepart;
/**
 * 关系型数据实体[TrmDepart] 查询条件对象
 */
@Slf4j
@Data
public class TrmDepartSearchContext extends QueryWrapperContext<TrmDepart> {

	private String n_trmdepartname_like;//[需求通知]
	public void setN_trmdepartname_like(String n_trmdepartname_like) {
        this.n_trmdepartname_like = n_trmdepartname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdepartname_like)){
            this.getSearchCond().like("trmdepartname", n_trmdepartname_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_lclx_eq;//[周期类型]
	public void setN_lclx_eq(String n_lclx_eq) {
        this.n_lclx_eq = n_lclx_eq;
        if(!ObjectUtils.isEmpty(this.n_lclx_eq)){
            this.getSearchCond().eq("lclx", n_lclx_eq);
        }
    }
	private String n_xqlylx_eq;//[需求来源类型]
	public void setN_xqlylx_eq(String n_xqlylx_eq) {
        this.n_xqlylx_eq = n_xqlylx_eq;
        if(!ObjectUtils.isEmpty(this.n_xqlylx_eq)){
            this.getSearchCond().eq("xqlylx", n_xqlylx_eq);
        }
    }
	private String n_spfs_eq;//[审批方式]
	public void setN_spfs_eq(String n_spfs_eq) {
        this.n_spfs_eq = n_spfs_eq;
        if(!ObjectUtils.isEmpty(this.n_spfs_eq)){
            this.getSearchCond().eq("spfs", n_spfs_eq);
        }
    }
	private String n_tzlx_eq;//[通知类型]
	public void setN_tzlx_eq(String n_tzlx_eq) {
        this.n_tzlx_eq = n_tzlx_eq;
        if(!ObjectUtils.isEmpty(this.n_tzlx_eq)){
            this.getSearchCond().eq("tzlx", n_tzlx_eq);
        }
    }
	private String n_jd_eq;//[季度]
	public void setN_jd_eq(String n_jd_eq) {
        this.n_jd_eq = n_jd_eq;
        if(!ObjectUtils.isEmpty(this.n_jd_eq)){
            this.getSearchCond().eq("jd", n_jd_eq);
        }
    }
	private String n_ormorgsectorname_eq;//[职能部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[职能部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_pimpersonname_eq;//[填单人]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[填单人]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormorgname_eq;//[直属单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[直属单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("trmdepartname", query)   
            );
		 }
	}
}




