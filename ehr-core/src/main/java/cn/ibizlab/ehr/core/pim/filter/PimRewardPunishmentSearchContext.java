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
import cn.ibizlab.ehr.core.pim.domain.PimRewardPunishment;
/**
 * 关系型数据实体[PimRewardPunishment] 查询条件对象
 */
@Slf4j
@Data
public class PimRewardPunishmentSearchContext extends QueryWrapperContext<PimRewardPunishment> {

	private String n_jlczz_eq;//[记录操作者]
	public void setN_jlczz_eq(String n_jlczz_eq) {
        this.n_jlczz_eq = n_jlczz_eq;
        if(!ObjectUtils.isEmpty(this.n_jlczz_eq)){
            this.getSearchCond().eq("jlczz", n_jlczz_eq);
        }
    }
	private String n_pimrewardpunishmentname_like;//[奖惩名称]
	public void setN_pimrewardpunishmentname_like(String n_pimrewardpunishmentname_like) {
        this.n_pimrewardpunishmentname_like = n_pimrewardpunishmentname_like;
        if(!ObjectUtils.isEmpty(this.n_pimrewardpunishmentname_like)){
            this.getSearchCond().like("pimrewardpunishmentname", n_pimrewardpunishmentname_like);
        }
    }
	private String n_jlspzt_eq;//[记录审批状态]
	public void setN_jlspzt_eq(String n_jlspzt_eq) {
        this.n_jlspzt_eq = n_jlspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jlspzt_eq)){
            this.getSearchCond().eq("jlspzt", n_jlspzt_eq);
        }
    }
	private String n_jlss_eq;//[记录所属]
	public void setN_jlss_eq(String n_jlss_eq) {
        this.n_jlss_eq = n_jlss_eq;
        if(!ObjectUtils.isEmpty(this.n_jlss_eq)){
            this.getSearchCond().eq("jlss", n_jlss_eq);
        }
    }
	private String n_jcjb_eq;//[奖惩级别]
	public void setN_jcjb_eq(String n_jcjb_eq) {
        this.n_jcjb_eq = n_jcjb_eq;
        if(!ObjectUtils.isEmpty(this.n_jcjb_eq)){
            this.getSearchCond().eq("jcjb", n_jcjb_eq);
        }
    }
	private String n_lx_eq;//[奖惩分类]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_cflx_eq;//[惩罚类型]
	public void setN_cflx_eq(String n_cflx_eq) {
        this.n_cflx_eq = n_cflx_eq;
        if(!ObjectUtils.isEmpty(this.n_cflx_eq)){
            this.getSearchCond().eq("cflx", n_cflx_eq);
        }
    }
	private String n_jclx_eq;//[奖励级别]
	public void setN_jclx_eq(String n_jclx_eq) {
        this.n_jclx_eq = n_jclx_eq;
        if(!ObjectUtils.isEmpty(this.n_jclx_eq)){
            this.getSearchCond().eq("jclx", n_jclx_eq);
        }
    }
	private String n_pimpersonname_eq;//[人员信息名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[人员信息名称]
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
                     wrapper.like("pimrewardpunishmentname", query)   
            );
		 }
	}
}




