package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VacLeaceType;
/**
 * 关系型数据实体[VacLeaceType] 查询条件对象
 */
@Slf4j
@Data
public class VacLeaceTypeSearchContext extends QueryWrapperContext<VacLeaceType> {

	private String n_vacleacetypename_like;//[休假类型管理名称]
	public void setN_vacleacetypename_like(String n_vacleacetypename_like) {
        this.n_vacleacetypename_like = n_vacleacetypename_like;
        if(!ObjectUtils.isEmpty(this.n_vacleacetypename_like)){
            this.getSearchCond().like("vacleacetypename", n_vacleacetypename_like);
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
                     wrapper.like("vacleacetypename", query)   
            );
		 }
	}
}




