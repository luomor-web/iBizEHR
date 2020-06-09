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
import cn.ibizlab.ehr.core.pim.domain.PimTitle;
/**
 * 关系型数据实体[PimTitle] 查询条件对象
 */
@Slf4j
@Data
public class PimTitleSearchContext extends QueryWrapperContext<PimTitle> {

	private Integer n_sfzgzc_eq;//[是否最高职称]
	public void setN_sfzgzc_eq(Integer n_sfzgzc_eq) {
        this.n_sfzgzc_eq = n_sfzgzc_eq;
        if(!ObjectUtils.isEmpty(this.n_sfzgzc_eq)){
            this.getSearchCond().eq("sfzgzc", n_sfzgzc_eq);
        }
    }
	private String n_zcdj_eq;//[职称等级]
	public void setN_zcdj_eq(String n_zcdj_eq) {
        this.n_zcdj_eq = n_zcdj_eq;
        if(!ObjectUtils.isEmpty(this.n_zcdj_eq)){
            this.getSearchCond().eq("zcdj", n_zcdj_eq);
        }
    }
	private String n_jlspzt_eq;//[记录审批状态]
	public void setN_jlspzt_eq(String n_jlspzt_eq) {
        this.n_jlspzt_eq = n_jlspzt_eq;
        if(!ObjectUtils.isEmpty(this.n_jlspzt_eq)){
            this.getSearchCond().eq("jlspzt", n_jlspzt_eq);
        }
    }
	private String n_pdjg_eq;//[评定机构]
	public void setN_pdjg_eq(String n_pdjg_eq) {
        this.n_pdjg_eq = n_pdjg_eq;
        if(!ObjectUtils.isEmpty(this.n_pdjg_eq)){
            this.getSearchCond().eq("pdjg", n_pdjg_eq);
        }
    }
	private String n_majorengaged_eq;//[专业类别]
	public void setN_majorengaged_eq(String n_majorengaged_eq) {
        this.n_majorengaged_eq = n_majorengaged_eq;
        if(!ObjectUtils.isEmpty(this.n_majorengaged_eq)){
            this.getSearchCond().eq("majorengaged", n_majorengaged_eq);
        }
    }
	private String n_pimtitlename_like;//[职称信息名称]
	public void setN_pimtitlename_like(String n_pimtitlename_like) {
        this.n_pimtitlename_like = n_pimtitlename_like;
        if(!ObjectUtils.isEmpty(this.n_pimtitlename_like)){
            this.getSearchCond().like("pimtitlename", n_pimtitlename_like);
        }
    }
	private String n_jlczz_eq;//[记录操作者]
	public void setN_jlczz_eq(String n_jlczz_eq) {
        this.n_jlczz_eq = n_jlczz_eq;
        if(!ObjectUtils.isEmpty(this.n_jlczz_eq)){
            this.getSearchCond().eq("jlczz", n_jlczz_eq);
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
	private String n_pimtitlecataloguename_eq;//[职称名称]
	public void setN_pimtitlecataloguename_eq(String n_pimtitlecataloguename_eq) {
        this.n_pimtitlecataloguename_eq = n_pimtitlecataloguename_eq;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecataloguename_eq)){
            this.getSearchCond().eq("pimtitlecataloguename", n_pimtitlecataloguename_eq);
        }
    }
	private String n_pimtitlecataloguename_like;//[职称名称]
	public void setN_pimtitlecataloguename_like(String n_pimtitlecataloguename_like) {
        this.n_pimtitlecataloguename_like = n_pimtitlecataloguename_like;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecataloguename_like)){
            this.getSearchCond().like("pimtitlecataloguename", n_pimtitlecataloguename_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pimtitlecatalogueid_eq;//[职称管理标识]
	public void setN_pimtitlecatalogueid_eq(String n_pimtitlecatalogueid_eq) {
        this.n_pimtitlecatalogueid_eq = n_pimtitlecatalogueid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecatalogueid_eq)){
            this.getSearchCond().eq("pimtitlecatalogueid", n_pimtitlecatalogueid_eq);
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
                        .or().like("ygbh", query)            
            );
		 }
	}
}




