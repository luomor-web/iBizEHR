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
import cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue;
/**
 * 关系型数据实体[PimTitleCatalogue] 查询条件对象
 */
@Slf4j
@Data
public class PimTitleCatalogueSearchContext extends QueryWrapperContext<PimTitleCatalogue> {

	private String n_dh_eq;//[职称代码]
	public void setN_dh_eq(String n_dh_eq) {
        this.n_dh_eq = n_dh_eq;
        if(!ObjectUtils.isEmpty(this.n_dh_eq)){
            this.getSearchCond().eq("dh", n_dh_eq);
        }
    }
	private String n_titletype_eq;//[职称类型]
	public void setN_titletype_eq(String n_titletype_eq) {
        this.n_titletype_eq = n_titletype_eq;
        if(!ObjectUtils.isEmpty(this.n_titletype_eq)){
            this.getSearchCond().eq("titletype", n_titletype_eq);
        }
    }
	private String n_zclc_eq;//[职称类型]
	public void setN_zclc_eq(String n_zclc_eq) {
        this.n_zclc_eq = n_zclc_eq;
        if(!ObjectUtils.isEmpty(this.n_zclc_eq)){
            this.getSearchCond().eq("zclc", n_zclc_eq);
        }
    }
	private String n_pimtitlecataloguename_like;//[职称目录名称]
	public void setN_pimtitlecataloguename_like(String n_pimtitlecataloguename_like) {
        this.n_pimtitlecataloguename_like = n_pimtitlecataloguename_like;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecataloguename_like)){
            this.getSearchCond().like("pimtitlecataloguename", n_pimtitlecataloguename_like);
        }
    }
	private String n_zcdj_eq;//[职称等级]
	public void setN_zcdj_eq(String n_zcdj_eq) {
        this.n_zcdj_eq = n_zcdj_eq;
        if(!ObjectUtils.isEmpty(this.n_zcdj_eq)){
            this.getSearchCond().eq("zcdj", n_zcdj_eq);
        }
    }
	private String n_pimtitlecataloguename2_eq;//[职称目录类型]
	public void setN_pimtitlecataloguename2_eq(String n_pimtitlecataloguename2_eq) {
        this.n_pimtitlecataloguename2_eq = n_pimtitlecataloguename2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecataloguename2_eq)){
            this.getSearchCond().eq("pimtitlecataloguename2", n_pimtitlecataloguename2_eq);
        }
    }
	private String n_pimtitlecataloguename2_like;//[职称目录类型]
	public void setN_pimtitlecataloguename2_like(String n_pimtitlecataloguename2_like) {
        this.n_pimtitlecataloguename2_like = n_pimtitlecataloguename2_like;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecataloguename2_like)){
            this.getSearchCond().like("pimtitlecataloguename2", n_pimtitlecataloguename2_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimtitlecatalogueid2_eq;//[职称标识]
	public void setN_pimtitlecatalogueid2_eq(String n_pimtitlecatalogueid2_eq) {
        this.n_pimtitlecatalogueid2_eq = n_pimtitlecatalogueid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pimtitlecatalogueid2_eq)){
            this.getSearchCond().eq("pimtitlecatalogueid2", n_pimtitlecatalogueid2_eq);
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
                     wrapper.like("pimtitlecataloguename", query)   
            );
		 }
	}
}




