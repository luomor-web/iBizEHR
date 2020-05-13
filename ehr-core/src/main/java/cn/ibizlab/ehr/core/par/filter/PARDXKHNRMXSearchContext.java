package cn.ibizlab.ehr.core.par.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.par.domain.PARDXKHNRMX;
/**
 * 关系型数据实体[PARDXKHNRMX] 查询条件对象
 */
@Slf4j
@Data
public class PARDXKHNRMXSearchContext extends QueryWrapperContext<PARDXKHNRMX> {

	private String n_zq_eq;//[周期]
	public void setN_zq_eq(String n_zq_eq) {
        this.n_zq_eq = n_zq_eq;
        if(!ObjectUtils.isEmpty(this.n_zq_eq)){
            this.getSelectCond().eq("zq", n_zq_eq);
        }
    }
	private String n_pardxkhnrmxname_like;//[考核评分表名称]
	public void setN_pardxkhnrmxname_like(String n_pardxkhnrmxname_like) {
        this.n_pardxkhnrmxname_like = n_pardxkhnrmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pardxkhnrmxname_like)){
            this.getSelectCond().like("pardxkhnrmxname", n_pardxkhnrmxname_like);
        }
    }
	private String n_pfzt_eq;//[评分主体]
	public void setN_pfzt_eq(String n_pfzt_eq) {
        this.n_pfzt_eq = n_pfzt_eq;
        if(!ObjectUtils.isEmpty(this.n_pfzt_eq)){
            this.getSelectCond().eq("pfzt", n_pfzt_eq);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_parkhzcmxname_eq;//[考核内容]
	public void setN_parkhzcmxname_eq(String n_parkhzcmxname_eq) {
        this.n_parkhzcmxname_eq = n_parkhzcmxname_eq;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_eq)){
            this.getSelectCond().eq("parkhzcmxname", n_parkhzcmxname_eq);
        }
    }
	private String n_parkhzcmxname_like;//[考核内容]
	public void setN_parkhzcmxname_like(String n_parkhzcmxname_like) {
        this.n_parkhzcmxname_like = n_parkhzcmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_like)){
            this.getSelectCond().like("parkhzcmxname", n_parkhzcmxname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[员工ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_parkhzcmxid_eq;//[考核内容ID]
	public void setN_parkhzcmxid_eq(String n_parkhzcmxid_eq) {
        this.n_parkhzcmxid_eq = n_parkhzcmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxid_eq)){
            this.getSelectCond().eq("parkhzcmxid", n_parkhzcmxid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pardxkhnrmxname",query);
		 }
	}
}



