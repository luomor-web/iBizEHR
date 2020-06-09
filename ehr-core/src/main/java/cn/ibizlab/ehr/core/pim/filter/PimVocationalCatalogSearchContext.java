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
import cn.ibizlab.ehr.core.pim.domain.PimVocationalCatalog;
/**
 * 关系型数据实体[PimVocationalCatalog] 查询条件对象
 */
@Slf4j
@Data
public class PimVocationalCatalogSearchContext extends QueryWrapperContext<PimVocationalCatalog> {

	private String n_dh_eq;//[资格证书代码]
	public void setN_dh_eq(String n_dh_eq) {
        this.n_dh_eq = n_dh_eq;
        if(!ObjectUtils.isEmpty(this.n_dh_eq)){
            this.getSearchCond().eq("dh", n_dh_eq);
        }
    }
	private String n_pimvocationalcatalogname_like;//[职（执）业资格名称]
	public void setN_pimvocationalcatalogname_like(String n_pimvocationalcatalogname_like) {
        this.n_pimvocationalcatalogname_like = n_pimvocationalcatalogname_like;
        if(!ObjectUtils.isEmpty(this.n_pimvocationalcatalogname_like)){
            this.getSearchCond().like("pimvocationalcatalogname", n_pimvocationalcatalogname_like);
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
                     wrapper.like("pimvocationalcatalogname", query)   
            );
		 }
	}
}




