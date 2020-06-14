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
import cn.ibizlab.ehr.core.pim.domain.PimLwgz;
/**
 * 关系型数据实体[PimLwgz] 查询条件对象
 */
@Slf4j
@Data
public class PimLwgzSearchContext extends QueryWrapperContext<PimLwgz> {

	private String n_pimlwgzname_like;//[轮岗规则名称]
	public void setN_pimlwgzname_like(String n_pimlwgzname_like) {
        this.n_pimlwgzname_like = n_pimlwgzname_like;
        if(!ObjectUtils.isEmpty(this.n_pimlwgzname_like)){
            this.getSearchCond().like("pimlwgzname", n_pimlwgzname_like);
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
                     wrapper.like("pimlwgzname", query)   
            );
		 }
	}
}




