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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTMENT;
/**
 * 关系型数据实体[TRMTRAINACTMENT] 查询条件对象
 */
@Slf4j
@Data
public class TRMTRAINACTMENTSearchContext extends QueryWrapperContext<TRMTRAINACTMENT> {

	private String n_trmtrainactmentname_like;//[培训活动评估名称]
	public void setN_trmtrainactmentname_like(String n_trmtrainactmentname_like) {
        this.n_trmtrainactmentname_like = n_trmtrainactmentname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactmentname_like)){
            this.getSelectCond().like("trmtrainactmentname", n_trmtrainactmentname_like);
        }
    }
	private String n_trmtrainactapplyname_eq;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_eq(String n_trmtrainactapplyname_eq) {
        this.n_trmtrainactapplyname_eq = n_trmtrainactapplyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_eq)){
            this.getSelectCond().eq("trmtrainactapplyname", n_trmtrainactapplyname_eq);
        }
    }
	private String n_trmtrainactapplyname_like;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_like(String n_trmtrainactapplyname_like) {
        this.n_trmtrainactapplyname_like = n_trmtrainactapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_like)){
            this.getSelectCond().like("trmtrainactapplyname", n_trmtrainactapplyname_like);
        }
    }
	private String n_trmtrainactapplyid_eq;//[培训活动申请标识]
	public void setN_trmtrainactapplyid_eq(String n_trmtrainactapplyid_eq) {
        this.n_trmtrainactapplyid_eq = n_trmtrainactapplyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyid_eq)){
            this.getSelectCond().eq("trmtrainactapplyid", n_trmtrainactapplyid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("trmtrainactmentname", query)   
            );
		 }
	}
}




