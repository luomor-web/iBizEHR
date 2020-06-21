package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocRecord;
/**
 * 关系型数据实体[SocRecord] 查询条件对象
 */
@Slf4j
@Data
public class SocRecordSearchContext extends QueryWrapperContext<SocRecord> {

	private String n_socrecordname_like;//[社保缴费记录名称]
	public void setN_socrecordname_like(String n_socrecordname_like) {
        this.n_socrecordname_like = n_socrecordname_like;
        if(!ObjectUtils.isEmpty(this.n_socrecordname_like)){
            this.getSearchCond().like("socrecordname", n_socrecordname_like);
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
                     wrapper.like("socrecordname", query)   
            );
		 }
	}
}




