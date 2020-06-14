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
import cn.ibizlab.ehr.core.pim.domain.PimArchives;
/**
 * 关系型数据实体[PimArchives] 查询条件对象
 */
@Slf4j
@Data
public class PimArchivesSearchContext extends QueryWrapperContext<PimArchives> {

	private String n_zt_eq;//[档案借阅状态]
	public void setN_zt_eq(String n_zt_eq) {
        this.n_zt_eq = n_zt_eq;
        if(!ObjectUtils.isEmpty(this.n_zt_eq)){
            this.getSearchCond().eq("zt", n_zt_eq);
        }
    }
	private String n_education_eq;//[档案学历]
	public void setN_education_eq(String n_education_eq) {
        this.n_education_eq = n_education_eq;
        if(!ObjectUtils.isEmpty(this.n_education_eq)){
            this.getSearchCond().eq("education", n_education_eq);
        }
    }
	private String n_pimarchivesname_like;//[档案信息名称]
	public void setN_pimarchivesname_like(String n_pimarchivesname_like) {
        this.n_pimarchivesname_like = n_pimarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_like)){
            this.getSearchCond().like("pimarchivesname", n_pimarchivesname_like);
        }
    }
	private String n_dabh_like;//[档案编号]
	public void setN_dabh_like(String n_dabh_like) {
        this.n_dabh_like = n_dabh_like;
        if(!ObjectUtils.isEmpty(this.n_dabh_like)){
            this.getSearchCond().like("dabh", n_dabh_like);
        }
    }
	private String n_dazt_eq;//[档案状态]
	public void setN_dazt_eq(String n_dazt_eq) {
        this.n_dazt_eq = n_dazt_eq;
        if(!ObjectUtils.isEmpty(this.n_dazt_eq)){
            this.getSearchCond().eq("dazt", n_dazt_eq);
        }
    }
	private String n_dastate_eq;//[档案状态]
	public void setN_dastate_eq(String n_dastate_eq) {
        this.n_dastate_eq = n_dastate_eq;
        if(!ObjectUtils.isEmpty(this.n_dastate_eq)){
            this.getSearchCond().eq("dastate", n_dastate_eq);
        }
    }
	private String n_operations_eq;//[操作内容]
	public void setN_operations_eq(String n_operations_eq) {
        this.n_operations_eq = n_operations_eq;
        if(!ObjectUtils.isEmpty(this.n_operations_eq)){
            this.getSearchCond().eq("operations", n_operations_eq);
        }
    }
	private String n_dadcdw_eq;//[档案调出单位]
	public void setN_dadcdw_eq(String n_dadcdw_eq) {
        this.n_dadcdw_eq = n_dadcdw_eq;
        if(!ObjectUtils.isEmpty(this.n_dadcdw_eq)){
            this.getSearchCond().eq("dadcdw", n_dadcdw_eq);
        }
    }
	private String n_dabgdd_eq;//[档案保管地]
	public void setN_dabgdd_eq(String n_dabgdd_eq) {
        this.n_dabgdd_eq = n_dabgdd_eq;
        if(!ObjectUtils.isEmpty(this.n_dabgdd_eq)){
            this.getSearchCond().eq("dabgdd", n_dabgdd_eq);
        }
    }
	private String n_archivescentername_eq;//[档案室]
	public void setN_archivescentername_eq(String n_archivescentername_eq) {
        this.n_archivescentername_eq = n_archivescentername_eq;
        if(!ObjectUtils.isEmpty(this.n_archivescentername_eq)){
            this.getSearchCond().eq("archivescentername", n_archivescentername_eq);
        }
    }
	private String n_archivescentername_like;//[档案室]
	public void setN_archivescentername_like(String n_archivescentername_like) {
        this.n_archivescentername_like = n_archivescentername_like;
        if(!ObjectUtils.isEmpty(this.n_archivescentername_like)){
            this.getSearchCond().like("archivescentername", n_archivescentername_like);
        }
    }
	private String n_ormorgname2_eq;//[调出单位]
	public void setN_ormorgname2_eq(String n_ormorgname2_eq) {
        this.n_ormorgname2_eq = n_ormorgname2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_eq)){
            this.getSearchCond().eq("ormorgname2", n_ormorgname2_eq);
        }
    }
	private String n_ormorgname2_like;//[调出单位]
	public void setN_ormorgname2_like(String n_ormorgname2_like) {
        this.n_ormorgname2_like = n_ormorgname2_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname2_like)){
            this.getSearchCond().like("ormorgname2", n_ormorgname2_like);
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
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgname3_eq;//[管理单位]
	public void setN_ormorgname3_eq(String n_ormorgname3_eq) {
        this.n_ormorgname3_eq = n_ormorgname3_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname3_eq)){
            this.getSearchCond().eq("ormorgname3", n_ormorgname3_eq);
        }
    }
	private String n_ormorgname3_like;//[管理单位]
	public void setN_ormorgname3_like(String n_ormorgname3_like) {
        this.n_ormorgname3_like = n_ormorgname3_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname3_like)){
            this.getSearchCond().like("ormorgname3", n_ormorgname3_like);
        }
    }
	private String n_ygzt_eq;//[员工状态]
	public void setN_ygzt_eq(String n_ygzt_eq) {
        this.n_ygzt_eq = n_ygzt_eq;
        if(!ObjectUtils.isEmpty(this.n_ygzt_eq)){
            this.getSearchCond().eq("ygzt", n_ygzt_eq);
        }
    }
	private String n_archivescenterid_eq;//[档案室管理标识]
	public void setN_archivescenterid_eq(String n_archivescenterid_eq) {
        this.n_archivescenterid_eq = n_archivescenterid_eq;
        if(!ObjectUtils.isEmpty(this.n_archivescenterid_eq)){
            this.getSearchCond().eq("archivescenterid", n_archivescenterid_eq);
        }
    }
	private String n_pimpersonid_eq;//[员工]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_ormorgid2_eq;//[现档案保管单位标识]
	public void setN_ormorgid2_eq(String n_ormorgid2_eq) {
        this.n_ormorgid2_eq = n_ormorgid2_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid2_eq)){
            this.getSearchCond().eq("ormorgid2", n_ormorgid2_eq);
        }
    }
	private String n_ormorgid3_eq;//[管理单位]
	public void setN_ormorgid3_eq(String n_ormorgid3_eq) {
        this.n_ormorgid3_eq = n_ormorgid3_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid3_eq)){
            this.getSearchCond().eq("ormorgid3", n_ormorgid3_eq);
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
                     wrapper.like("pimpersonname", query)   
            );
		 }
	}
}




