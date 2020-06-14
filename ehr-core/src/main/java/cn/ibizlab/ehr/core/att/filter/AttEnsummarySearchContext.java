package cn.ibizlab.ehr.core.att.filter;

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
import cn.ibizlab.ehr.core.att.domain.AttEnsummary;
/**
 * 关系型数据实体[AttEnsummary] 查询条件对象
 */
@Slf4j
@Data
public class AttEnsummarySearchContext extends QueryWrapperContext<AttEnsummary> {

    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_begindate_eq;//[开始日期]
	public void setN_begindate_eq(Timestamp n_begindate_eq) {
        this.n_begindate_eq = n_begindate_eq;
        if(!ObjectUtils.isEmpty(this.n_begindate_eq)){
            this.getSearchCond().eq("begindate", n_begindate_eq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_begindate_gtandeq;//[开始日期]
	public void setN_begindate_gtandeq(Timestamp n_begindate_gtandeq) {
        this.n_begindate_gtandeq = n_begindate_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_begindate_gtandeq)){
            this.getSearchCond().ge("begindate", n_begindate_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_begindate_ltandeq;//[开始日期]
	public void setN_begindate_ltandeq(Timestamp n_begindate_ltandeq) {
        this.n_begindate_ltandeq = n_begindate_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_begindate_ltandeq)){
            this.getSearchCond().le("begindate", n_begindate_ltandeq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_yf_eq;//[月份]
	public void setN_yf_eq(String n_yf_eq) {
        this.n_yf_eq = n_yf_eq;
        if(!ObjectUtils.isEmpty(this.n_yf_eq)){
            this.getSearchCond().eq("yf", n_yf_eq);
        }
    }
	private String n_attensummaryname_like;//[考勤汇总名称]
	public void setN_attensummaryname_like(String n_attensummaryname_like) {
        this.n_attensummaryname_like = n_attensummaryname_like;
        if(!ObjectUtils.isEmpty(this.n_attensummaryname_like)){
            this.getSearchCond().like("attensummaryname", n_attensummaryname_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_enddate_gtandeq;//[结束日期]
	public void setN_enddate_gtandeq(Timestamp n_enddate_gtandeq) {
        this.n_enddate_gtandeq = n_enddate_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_enddate_gtandeq)){
            this.getSearchCond().ge("enddate", n_enddate_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd")
	private Timestamp n_enddate_ltandeq;//[结束日期]
	public void setN_enddate_ltandeq(Timestamp n_enddate_ltandeq) {
        this.n_enddate_ltandeq = n_enddate_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_enddate_ltandeq)){
            this.getSearchCond().le("enddate", n_enddate_ltandeq);
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
                     wrapper.like("ormorgname", query)   
                        .or().like("pimpersonname", query)            
            );
		 }
	}
}




