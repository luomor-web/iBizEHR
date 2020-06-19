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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainActment;
/**
 * 关系型数据实体[TrmTrainActment] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainActmentSearchContext extends QueryWrapperContext<TrmTrainActment> {

	private String n_trmtrainactmentname_like;//[培训后评估名称]
	public void setN_trmtrainactmentname_like(String n_trmtrainactmentname_like) {
        this.n_trmtrainactmentname_like = n_trmtrainactmentname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactmentname_like)){
            this.getSearchCond().like("trmtrainactmentname", n_trmtrainactmentname_like);
        }
    }
	private String n_trmtrainactapplyname_eq;//[培训后评估名称]
	public void setN_trmtrainactapplyname_eq(String n_trmtrainactapplyname_eq) {
        this.n_trmtrainactapplyname_eq = n_trmtrainactapplyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_eq)){
            this.getSearchCond().eq("trmtrainactapplyname", n_trmtrainactapplyname_eq);
        }
    }
	private String n_trmtrainactapplyname_like;//[培训后评估名称]
	public void setN_trmtrainactapplyname_like(String n_trmtrainactapplyname_like) {
        this.n_trmtrainactapplyname_like = n_trmtrainactapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_like)){
            this.getSearchCond().like("trmtrainactapplyname", n_trmtrainactapplyname_like);
        }
    }
	private String n_trmtrainactapplyid_eq;//[培训后评估标识]
	public void setN_trmtrainactapplyid_eq(String n_trmtrainactapplyid_eq) {
        this.n_trmtrainactapplyid_eq = n_trmtrainactapplyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyid_eq)){
            this.getSearchCond().eq("trmtrainactapplyid", n_trmtrainactapplyid_eq);
        }
    }
	private String n_evaltarget_eq;//[评估对象]
	public void setN_evaltarget_eq(String n_evaltarget_eq) {
        this.n_evaltarget_eq = n_evaltarget_eq;
        if(!ObjectUtils.isEmpty(this.n_evaltarget_eq)){
            this.getSearchCond().eq("evaltarget", n_evaltarget_eq);
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
                     wrapper.like("trmtrainactmentname", query)   
            );
		 }
	}
}




