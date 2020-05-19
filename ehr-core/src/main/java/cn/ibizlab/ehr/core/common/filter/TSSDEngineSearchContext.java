package cn.ibizlab.ehr.core.common.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.common.domain.TSSDEngine;
/**
 * 关系型数据实体[TSSDEngine] 查询条件对象
 */
@Slf4j
@Data
public class TSSDEngineSearchContext extends QueryWrapperContext<TSSDEngine> {

	private String n_tssdenginename_like;//[任务调度引擎名称]
	public void setN_tssdenginename_like(String n_tssdenginename_like) {
        this.n_tssdenginename_like = n_tssdenginename_like;
        if(!ObjectUtils.isEmpty(this.n_tssdenginename_like)){
            this.getSelectCond().like("tssdenginename", n_tssdenginename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdenginename",query);
		 }
	}
}




