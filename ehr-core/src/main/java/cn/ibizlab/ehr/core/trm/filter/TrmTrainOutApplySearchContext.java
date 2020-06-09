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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainOutApply;
/**
 * 关系型数据实体[TrmTrainOutApply] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainOutApplySearchContext extends QueryWrapperContext<TrmTrainOutApply> {

	private String n_wbpxjg_eq;//[外部培训机构]
	public void setN_wbpxjg_eq(String n_wbpxjg_eq) {
        this.n_wbpxjg_eq = n_wbpxjg_eq;
        if(!ObjectUtils.isEmpty(this.n_wbpxjg_eq)){
            this.getSearchCond().eq("wbpxjg", n_wbpxjg_eq);
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
	private String n_ywlx_eq;//[业务类型]
	public void setN_ywlx_eq(String n_ywlx_eq) {
        this.n_ywlx_eq = n_ywlx_eq;
        if(!ObjectUtils.isEmpty(this.n_ywlx_eq)){
            this.getSearchCond().eq("ywlx", n_ywlx_eq);
        }
    }
	private String n_trmtrainoutapplyname_like;//[外部培训申请名称]
	public void setN_trmtrainoutapplyname_like(String n_trmtrainoutapplyname_like) {
        this.n_trmtrainoutapplyname_like = n_trmtrainoutapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainoutapplyname_like)){
            this.getSearchCond().like("trmtrainoutapplyname", n_trmtrainoutapplyname_like);
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

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("trmtrainoutapplyname", query)   
            );
		 }
	}
}




