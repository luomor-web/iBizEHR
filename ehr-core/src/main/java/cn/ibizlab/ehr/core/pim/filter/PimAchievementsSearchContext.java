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
import cn.ibizlab.ehr.core.pim.domain.PimAchievements;
/**
 * 关系型数据实体[PimAchievements] 查询条件对象
 */
@Slf4j
@Data
public class PimAchievementsSearchContext extends QueryWrapperContext<PimAchievements> {

	private String n_khjl_eq;//[考核结论]
	public void setN_khjl_eq(String n_khjl_eq) {
        this.n_khjl_eq = n_khjl_eq;
        if(!ObjectUtils.isEmpty(this.n_khjl_eq)){
            this.getSearchCond().eq("khjl", n_khjl_eq);
        }
    }
	private String n_xmjb_eq;//[项目级别]
	public void setN_xmjb_eq(String n_xmjb_eq) {
        this.n_xmjb_eq = n_xmjb_eq;
        if(!ObjectUtils.isEmpty(this.n_xmjb_eq)){
            this.getSearchCond().eq("xmjb", n_xmjb_eq);
        }
    }
	private String n_jd_eq;//[季度]
	public void setN_jd_eq(String n_jd_eq) {
        this.n_jd_eq = n_jd_eq;
        if(!ObjectUtils.isEmpty(this.n_jd_eq)){
            this.getSearchCond().eq("jd", n_jd_eq);
        }
    }
	private String n_dj_eq;//[档级]
	public void setN_dj_eq(String n_dj_eq) {
        this.n_dj_eq = n_dj_eq;
        if(!ObjectUtils.isEmpty(this.n_dj_eq)){
            this.getSearchCond().eq("dj", n_dj_eq);
        }
    }
	private String n_pimachievementsname_like;//[年度]
	public void setN_pimachievementsname_like(String n_pimachievementsname_like) {
        this.n_pimachievementsname_like = n_pimachievementsname_like;
        if(!ObjectUtils.isEmpty(this.n_pimachievementsname_like)){
            this.getSearchCond().like("pimachievementsname", n_pimachievementsname_like);
        }
    }
	private String n_khlx_eq;//[绩效考核类型]
	public void setN_khlx_eq(String n_khlx_eq) {
        this.n_khlx_eq = n_khlx_eq;
        if(!ObjectUtils.isEmpty(this.n_khlx_eq)){
            this.getSearchCond().eq("khlx", n_khlx_eq);
        }
    }
	private String n_yd_eq;//[月度]
	public void setN_yd_eq(String n_yd_eq) {
        this.n_yd_eq = n_yd_eq;
        if(!ObjectUtils.isEmpty(this.n_yd_eq)){
            this.getSearchCond().eq("yd", n_yd_eq);
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
                     wrapper.like("pimachievementsname", query)   
            );
		 }
	}
}




