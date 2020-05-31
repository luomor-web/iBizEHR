package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SalSource;
/**
 * 关系型数据实体[SalSource] 查询条件对象
 */
@Slf4j
@Data
public class SalSourceSearchContext extends QueryWrapperContext<SalSource> {

	private String n_salsourcename_like;//[薪酬计算源名称]
	public void setN_salsourcename_like(String n_salsourcename_like) {
        this.n_salsourcename_like = n_salsourcename_like;
        if(!ObjectUtils.isEmpty(this.n_salsourcename_like)){
            this.getSelectCond().like("salsourcename", n_salsourcename_like);
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
                     wrapper.like("salsourcename", query)   
            );
		 }
	}
}




