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
import cn.ibizlab.ehr.core.pim.domain.PimCorrectionApply;
/**
 * 关系型数据实体[PimCorrectionApply] 查询条件对象
 */
@Slf4j
@Data
public class PimCorrectionApplySearchContext extends QueryWrapperContext<PimCorrectionApply> {

	private String n_pimcorrectionapplyname_like;//[B/Y类员工转正申请明细名称]
	public void setN_pimcorrectionapplyname_like(String n_pimcorrectionapplyname_like) {
        this.n_pimcorrectionapplyname_like = n_pimcorrectionapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_pimcorrectionapplyname_like)){
            this.getSearchCond().like("pimcorrectionapplyname", n_pimcorrectionapplyname_like);
        }
    }
	private String n_pimbyygzzsqname_eq;//[标题]
	public void setN_pimbyygzzsqname_eq(String n_pimbyygzzsqname_eq) {
        this.n_pimbyygzzsqname_eq = n_pimbyygzzsqname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqname_eq)){
            this.getSearchCond().eq("pimbyygzzsqname", n_pimbyygzzsqname_eq);
        }
    }
	private String n_pimbyygzzsqname_like;//[标题]
	public void setN_pimbyygzzsqname_like(String n_pimbyygzzsqname_like) {
        this.n_pimbyygzzsqname_like = n_pimbyygzzsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqname_like)){
            this.getSearchCond().like("pimbyygzzsqname", n_pimbyygzzsqname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimbyygzzsqid_eq;//[B/Y类员工转正申请ID]
	public void setN_pimbyygzzsqid_eq(String n_pimbyygzzsqid_eq) {
        this.n_pimbyygzzsqid_eq = n_pimbyygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyygzzsqid_eq)){
            this.getSearchCond().eq("pimbyygzzsqid", n_pimbyygzzsqid_eq);
        }
    }
	private String n_pimpersonid_eq;//[员工标识]
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
                     wrapper.like("pimcorrectionapplyname", query)   
            );
		 }
	}
}




