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
import cn.ibizlab.ehr.core.trm.domain.TrmLgbDetail;
/**
 * 关系型数据实体[TrmLgbDetail] 查询条件对象
 */
@Slf4j
@Data
public class TrmLgbDetailSearchContext extends QueryWrapperContext<TrmLgbDetail> {

	private String n_trmlgbdetailname_like;//[老干部明细名称]
	public void setN_trmlgbdetailname_like(String n_trmlgbdetailname_like) {
        this.n_trmlgbdetailname_like = n_trmlgbdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_trmlgbdetailname_like)){
            this.getSearchCond().like("trmlgbdetailname", n_trmlgbdetailname_like);
        }
    }
	private String n_pimpersonname_eq;//[姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_trmlgbcostname_eq;//[活动]
	public void setN_trmlgbcostname_eq(String n_trmlgbcostname_eq) {
        this.n_trmlgbcostname_eq = n_trmlgbcostname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmlgbcostname_eq)){
            this.getSearchCond().eq("trmlgbcostname", n_trmlgbcostname_eq);
        }
    }
	private String n_trmlgbcostname_like;//[活动]
	public void setN_trmlgbcostname_like(String n_trmlgbcostname_like) {
        this.n_trmlgbcostname_like = n_trmlgbcostname_like;
        if(!ObjectUtils.isEmpty(this.n_trmlgbcostname_like)){
            this.getSearchCond().like("trmlgbcostname", n_trmlgbcostname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_trmlgbcostid_eq;//[老干部费用标识]
	public void setN_trmlgbcostid_eq(String n_trmlgbcostid_eq) {
        this.n_trmlgbcostid_eq = n_trmlgbcostid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmlgbcostid_eq)){
            this.getSearchCond().eq("trmlgbcostid", n_trmlgbcostid_eq);
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
                     wrapper.like("trmlgbdetailname", query)   
            );
		 }
	}
}




