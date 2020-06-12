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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply;
/**
 * 关系型数据实体[TrmTrainActapply] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainActapplySearchContext extends QueryWrapperContext<TrmTrainActapply> {

	private String n_pxfs_eq;//[培训方式]
	public void setN_pxfs_eq(String n_pxfs_eq) {
        this.n_pxfs_eq = n_pxfs_eq;
        if(!ObjectUtils.isEmpty(this.n_pxfs_eq)){
            this.getSearchCond().eq("pxfs", n_pxfs_eq);
        }
    }
	private String n_pxjb_eq;//[培训级别]
	public void setN_pxjb_eq(String n_pxjb_eq) {
        this.n_pxjb_eq = n_pxjb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxjb_eq)){
            this.getSearchCond().eq("pxjb", n_pxjb_eq);
        }
    }
	private String n_pxnd_eq;//[培训年度]
	public void setN_pxnd_eq(String n_pxnd_eq) {
        this.n_pxnd_eq = n_pxnd_eq;
        if(!ObjectUtils.isEmpty(this.n_pxnd_eq)){
            this.getSearchCond().eq("pxnd", n_pxnd_eq);
        }
    }
	private String n_pxyf_eq;//[培训月份]
	public void setN_pxyf_eq(String n_pxyf_eq) {
        this.n_pxyf_eq = n_pxyf_eq;
        if(!ObjectUtils.isEmpty(this.n_pxyf_eq)){
            this.getSearchCond().eq("pxyf", n_pxyf_eq);
        }
    }
	private String n_pxlb_eq;//[培训类别]
	public void setN_pxlb_eq(String n_pxlb_eq) {
        this.n_pxlb_eq = n_pxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxlb_eq)){
            this.getSearchCond().eq("pxlb", n_pxlb_eq);
        }
    }
	private String n_trmtrainactapplyname_like;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_like(String n_trmtrainactapplyname_like) {
        this.n_trmtrainactapplyname_like = n_trmtrainactapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_like)){
            this.getSearchCond().like("trmtrainactapplyname", n_trmtrainactapplyname_like);
        }
    }
	private String n_pxdxlb_eq;//[培训对象类别]
	public void setN_pxdxlb_eq(String n_pxdxlb_eq) {
        this.n_pxdxlb_eq = n_pxdxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxdxlb_eq)){
            this.getSearchCond().eq("pxdxlb", n_pxdxlb_eq);
        }
    }
	private String n_pxjd_eq;//[培训季度]
	public void setN_pxjd_eq(String n_pxjd_eq) {
        this.n_pxjd_eq = n_pxjd_eq;
        if(!ObjectUtils.isEmpty(this.n_pxjd_eq)){
            this.getSearchCond().eq("pxjd", n_pxjd_eq);
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

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("trmtrainactapplyname", query)   
            );
		 }
	}
}




