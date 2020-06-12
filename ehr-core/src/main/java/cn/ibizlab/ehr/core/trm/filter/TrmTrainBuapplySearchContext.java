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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainBuapply;
/**
 * 关系型数据实体[TrmTrainBuapply] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainBuapplySearchContext extends QueryWrapperContext<TrmTrainBuapply> {

	private String n_trmtrainbuapplyname_like;//[培训预算申请名称]
	public void setN_trmtrainbuapplyname_like(String n_trmtrainbuapplyname_like) {
        this.n_trmtrainbuapplyname_like = n_trmtrainbuapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainbuapplyname_like)){
            this.getSearchCond().like("trmtrainbuapplyname", n_trmtrainbuapplyname_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_jflx_eq;//[经费类型]
	public void setN_jflx_eq(String n_jflx_eq) {
        this.n_jflx_eq = n_jflx_eq;
        if(!ObjectUtils.isEmpty(this.n_jflx_eq)){
            this.getSearchCond().eq("jflx", n_jflx_eq);
        }
    }
	private String n_trmtrainplantermname_eq;//[培训班]
	public void setN_trmtrainplantermname_eq(String n_trmtrainplantermname_eq) {
        this.n_trmtrainplantermname_eq = n_trmtrainplantermname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_eq)){
            this.getSearchCond().eq("trmtrainplantermname", n_trmtrainplantermname_eq);
        }
    }
	private String n_trmtrainplantermname_like;//[培训班]
	public void setN_trmtrainplantermname_like(String n_trmtrainplantermname_like) {
        this.n_trmtrainplantermname_like = n_trmtrainplantermname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_like)){
            this.getSearchCond().like("trmtrainplantermname", n_trmtrainplantermname_like);
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
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmtrainplantermid_eq;//[培训计划项标识]
	public void setN_trmtrainplantermid_eq(String n_trmtrainplantermid_eq) {
        this.n_trmtrainplantermid_eq = n_trmtrainplantermid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermid_eq)){
            this.getSearchCond().eq("trmtrainplantermid", n_trmtrainplantermid_eq);
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
                     wrapper.like("trmtrainbuapplyname", query)   
            );
		 }
	}
}




