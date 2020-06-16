package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocRuleDetail;
/**
 * 关系型数据实体[SocRuleDetail] 查询条件对象
 */
@Slf4j
@Data
public class SocRuleDetailSearchContext extends QueryWrapperContext<SocRuleDetail> {

	private String n_socruledetailname_like;//[社保规则明细名称]
	public void setN_socruledetailname_like(String n_socruledetailname_like) {
        this.n_socruledetailname_like = n_socruledetailname_like;
        if(!ObjectUtils.isEmpty(this.n_socruledetailname_like)){
            this.getSearchCond().like("socruledetailname", n_socruledetailname_like);
        }
    }
	private String n_soctypeid_eq;//[保险类型标识]
	public void setN_soctypeid_eq(String n_soctypeid_eq) {
        this.n_soctypeid_eq = n_soctypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_soctypeid_eq)){
            this.getSearchCond().eq("soctypeid", n_soctypeid_eq);
        }
    }
	private String n_soctypename_eq;//[保险类型]
	public void setN_soctypename_eq(String n_soctypename_eq) {
        this.n_soctypename_eq = n_soctypename_eq;
        if(!ObjectUtils.isEmpty(this.n_soctypename_eq)){
            this.getSearchCond().eq("soctypename", n_soctypename_eq);
        }
    }
	private String n_soctypename_like;//[保险类型]
	public void setN_soctypename_like(String n_soctypename_like) {
        this.n_soctypename_like = n_soctypename_like;
        if(!ObjectUtils.isEmpty(this.n_soctypename_like)){
            this.getSearchCond().like("soctypename", n_soctypename_like);
        }
    }
	private String n_socruleid_eq;//[社保规则标识]
	public void setN_socruleid_eq(String n_socruleid_eq) {
        this.n_socruleid_eq = n_socruleid_eq;
        if(!ObjectUtils.isEmpty(this.n_socruleid_eq)){
            this.getSearchCond().eq("socruleid", n_socruleid_eq);
        }
    }
	private String n_socrulename_eq;//[社保规则名称]
	public void setN_socrulename_eq(String n_socrulename_eq) {
        this.n_socrulename_eq = n_socrulename_eq;
        if(!ObjectUtils.isEmpty(this.n_socrulename_eq)){
            this.getSearchCond().eq("socrulename", n_socrulename_eq);
        }
    }
	private String n_socrulename_like;//[社保规则名称]
	public void setN_socrulename_like(String n_socrulename_like) {
        this.n_socrulename_like = n_socrulename_like;
        if(!ObjectUtils.isEmpty(this.n_socrulename_like)){
            this.getSearchCond().like("socrulename", n_socrulename_like);
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
                     wrapper.like("socruledetailname", query)   
            );
		 }
	}
}




