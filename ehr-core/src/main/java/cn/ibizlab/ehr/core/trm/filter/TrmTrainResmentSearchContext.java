package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainResment;
/**
 * 关系型数据实体[TrmTrainResment] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainResmentSearchContext extends QueryWrapperContext<TrmTrainResment> {

	private String n_trmtrainresmentname_like;//[培训资源评估名称]
	public void setN_trmtrainresmentname_like(String n_trmtrainresmentname_like) {
        this.n_trmtrainresmentname_like = n_trmtrainresmentname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainresmentname_like)){
            this.getSelectCond().like("trmtrainresmentname", n_trmtrainresmentname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("trmtrainresmentname", query)   
            );
		 }
	}
}




