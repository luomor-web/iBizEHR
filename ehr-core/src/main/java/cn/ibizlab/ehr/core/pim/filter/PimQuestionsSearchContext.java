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
import cn.ibizlab.ehr.core.pim.domain.PimQuestions;
/**
 * 关系型数据实体[PimQuestions] 查询条件对象
 */
@Slf4j
@Data
public class PimQuestionsSearchContext extends QueryWrapperContext<PimQuestions> {

	private String n_createman_like;//[建立人]
	public void setN_createman_like(String n_createman_like) {
        this.n_createman_like = n_createman_like;
        if(!ObjectUtils.isEmpty(this.n_createman_like)){
            this.getSearchCond().like("createman", n_createman_like);
        }
    }
	private String n_questionman_like;//[提出人]
	public void setN_questionman_like(String n_questionman_like) {
        this.n_questionman_like = n_questionman_like;
        if(!ObjectUtils.isEmpty(this.n_questionman_like)){
            this.getSearchCond().like("questionman", n_questionman_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_createdate_gtandeq;//[提出时间]
	public void setN_createdate_gtandeq(Timestamp n_createdate_gtandeq) {
        this.n_createdate_gtandeq = n_createdate_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_createdate_gtandeq)){
            this.getSearchCond().ge("createdate", n_createdate_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_createdate_ltandeq;//[提出时间]
	public void setN_createdate_ltandeq(Timestamp n_createdate_ltandeq) {
        this.n_createdate_ltandeq = n_createdate_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_createdate_ltandeq)){
            this.getSearchCond().le("createdate", n_createdate_ltandeq);
        }
    }
	private String n_jjcd_eq;//[紧急程度]
	public void setN_jjcd_eq(String n_jjcd_eq) {
        this.n_jjcd_eq = n_jjcd_eq;
        if(!ObjectUtils.isEmpty(this.n_jjcd_eq)){
            this.getSearchCond().eq("jjcd", n_jjcd_eq);
        }
    }
	private String n_ym_like;//[页面]
	public void setN_ym_like(String n_ym_like) {
        this.n_ym_like = n_ym_like;
        if(!ObjectUtils.isEmpty(this.n_ym_like)){
            this.getSearchCond().like("ym", n_ym_like);
        }
    }
	private String n_mk_eq;//[模块]
	public void setN_mk_eq(String n_mk_eq) {
        this.n_mk_eq = n_mk_eq;
        if(!ObjectUtils.isEmpty(this.n_mk_eq)){
            this.getSearchCond().eq("mk", n_mk_eq);
        }
    }
	private String n_questionsname_like;//[问题]
	public void setN_questionsname_like(String n_questionsname_like) {
        this.n_questionsname_like = n_questionsname_like;
        if(!ObjectUtils.isEmpty(this.n_questionsname_like)){
            this.getSearchCond().like("questionsname", n_questionsname_like);
        }
    }
	private String n_kfz_like;//[开发者]
	public void setN_kfz_like(String n_kfz_like) {
        this.n_kfz_like = n_kfz_like;
        if(!ObjectUtils.isEmpty(this.n_kfz_like)){
            this.getSearchCond().like("kfz", n_kfz_like);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_tcsj_gtandeq;//[提出时间]
	public void setN_tcsj_gtandeq(Timestamp n_tcsj_gtandeq) {
        this.n_tcsj_gtandeq = n_tcsj_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_tcsj_gtandeq)){
            this.getSearchCond().ge("tcsj", n_tcsj_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_tcsj_ltandeq;//[提出时间]
	public void setN_tcsj_ltandeq(Timestamp n_tcsj_ltandeq) {
        this.n_tcsj_ltandeq = n_tcsj_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_tcsj_ltandeq)){
            this.getSearchCond().le("tcsj", n_tcsj_ltandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_wcsj_gtandeq;//[完成时间]
	public void setN_wcsj_gtandeq(Timestamp n_wcsj_gtandeq) {
        this.n_wcsj_gtandeq = n_wcsj_gtandeq;
        if(!ObjectUtils.isEmpty(this.n_wcsj_gtandeq)){
            this.getSearchCond().ge("wcsj", n_wcsj_gtandeq);
        }
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp n_wcsj_ltandeq;//[完成时间]
	public void setN_wcsj_ltandeq(Timestamp n_wcsj_ltandeq) {
        this.n_wcsj_ltandeq = n_wcsj_ltandeq;
        if(!ObjectUtils.isEmpty(this.n_wcsj_ltandeq)){
            this.getSearchCond().le("wcsj", n_wcsj_ltandeq);
        }
    }
	private String n_wtzt_eq;//[问题状态]
	public void setN_wtzt_eq(String n_wtzt_eq) {
        this.n_wtzt_eq = n_wtzt_eq;
        if(!ObjectUtils.isEmpty(this.n_wtzt_eq)){
            this.getSearchCond().eq("wtzt", n_wtzt_eq);
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
                     wrapper.like("questionsname", query)   
            );
		 }
	}
}




