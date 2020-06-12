package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.ParExamCycle;
/**
 * 关系型数据实体[ParExamCycle] 查询条件对象
 */
@Slf4j
@Data
public class ParExamCycleSearchContext extends QueryWrapperContext<ParExamCycle> {

	private String n_parexamcyclename_like;//[考核周期]
	public void setN_parexamcyclename_like(String n_parexamcyclename_like) {
        this.n_parexamcyclename_like = n_parexamcyclename_like;
        if(!ObjectUtils.isEmpty(this.n_parexamcyclename_like)){
            this.getSearchCond().like("parexamcyclename", n_parexamcyclename_like);
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
                     wrapper.like("parexamcyclename", query)   
            );
		 }
	}
}




