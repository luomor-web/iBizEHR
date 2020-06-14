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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainDemandSum;
/**
 * 关系型数据实体[TrmTrainDemandSum] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainDemandSumSearchContext extends QueryWrapperContext<TrmTrainDemandSum> {

	private String n_trmtraindemandsumname_like;//[培训需求汇总明细名称]
	public void setN_trmtraindemandsumname_like(String n_trmtraindemandsumname_like) {
        this.n_trmtraindemandsumname_like = n_trmtraindemandsumname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraindemandsumname_like)){
            this.getSearchCond().like("trmtraindemandsumname", n_trmtraindemandsumname_like);
        }
    }
	private String n_trmtraindemandname_eq;//[培训需求汇总名称]
	public void setN_trmtraindemandname_eq(String n_trmtraindemandname_eq) {
        this.n_trmtraindemandname_eq = n_trmtraindemandname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraindemandname_eq)){
            this.getSearchCond().eq("trmtraindemandname", n_trmtraindemandname_eq);
        }
    }
	private String n_trmtraindemandname_like;//[培训需求汇总名称]
	public void setN_trmtraindemandname_like(String n_trmtraindemandname_like) {
        this.n_trmtraindemandname_like = n_trmtraindemandname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraindemandname_like)){
            this.getSearchCond().like("trmtraindemandname", n_trmtraindemandname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
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
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmtraindemandid_eq;//[培训需求汇总标识]
	public void setN_trmtraindemandid_eq(String n_trmtraindemandid_eq) {
        this.n_trmtraindemandid_eq = n_trmtraindemandid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraindemandid_eq)){
            this.getSearchCond().eq("trmtraindemandid", n_trmtraindemandid_eq);
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
                     wrapper.like("trmtraindemandsumname", query)   
            );
		 }
	}
}




