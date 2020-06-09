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
import cn.ibizlab.ehr.core.pim.domain.PimArchivalCatalogue;
/**
 * 关系型数据实体[PimArchivalCatalogue] 查询条件对象
 */
@Slf4j
@Data
public class PimArchivalCatalogueSearchContext extends QueryWrapperContext<PimArchivalCatalogue> {

	private String n_archivalcataloguename_like;//[档案目录名称]
	public void setN_archivalcataloguename_like(String n_archivalcataloguename_like) {
        this.n_archivalcataloguename_like = n_archivalcataloguename_like;
        if(!ObjectUtils.isEmpty(this.n_archivalcataloguename_like)){
            this.getSearchCond().like("archivalcataloguename", n_archivalcataloguename_like);
        }
    }
	private String n_pimarchivesname_eq;//[档案信息名称]
	public void setN_pimarchivesname_eq(String n_pimarchivesname_eq) {
        this.n_pimarchivesname_eq = n_pimarchivesname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_eq)){
            this.getSearchCond().eq("pimarchivesname", n_pimarchivesname_eq);
        }
    }
	private String n_pimarchivesname_like;//[档案信息名称]
	public void setN_pimarchivesname_like(String n_pimarchivesname_like) {
        this.n_pimarchivesname_like = n_pimarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesname_like)){
            this.getSearchCond().like("pimarchivesname", n_pimarchivesname_like);
        }
    }
	private String n_pimarchivesid_eq;//[档案信息标识]
	public void setN_pimarchivesid_eq(String n_pimarchivesid_eq) {
        this.n_pimarchivesid_eq = n_pimarchivesid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimarchivesid_eq)){
            this.getSearchCond().eq("pimarchivesid", n_pimarchivesid_eq);
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
                     wrapper.like("archivalcataloguename", query)   
            );
		 }
	}
}




