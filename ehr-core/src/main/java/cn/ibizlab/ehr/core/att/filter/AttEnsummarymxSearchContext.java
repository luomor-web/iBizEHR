package cn.ibizlab.ehr.core.att.filter;

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
import cn.ibizlab.ehr.core.att.domain.AttEnsummarymx;
/**
 * 关系型数据实体[AttEnsummarymx] 查询条件对象
 */
@Slf4j
@Data
public class AttEnsummarymxSearchContext extends QueryWrapperContext<AttEnsummarymx> {

	private String n_attensummarymxname_like;//[考勤汇总明细名称]
	public void setN_attensummarymxname_like(String n_attensummarymxname_like) {
        this.n_attensummarymxname_like = n_attensummarymxname_like;
        if(!ObjectUtils.isEmpty(this.n_attensummarymxname_like)){
            this.getSearchCond().like("attensummarymxname", n_attensummarymxname_like);
        }
    }
	private String n_kqlx_eq;//[考勤类型]
	public void setN_kqlx_eq(String n_kqlx_eq) {
        this.n_kqlx_eq = n_kqlx_eq;
        if(!ObjectUtils.isEmpty(this.n_kqlx_eq)){
            this.getSearchCond().eq("kqlx", n_kqlx_eq);
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
                     wrapper.like("attensummarymxname", query)   
            );
		 }
	}
}




