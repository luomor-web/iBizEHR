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
import cn.ibizlab.ehr.core.par.domain.PARJXKHXHZ;
/**
 * 关系型数据实体[PARJXKHXHZ] 查询条件对象
 */
@Slf4j
@Data
public class PARJXKHXHZSearchContext extends QueryWrapperContext<PARJXKHXHZ> {

	private String n_khlx_eq;//[考核对象]
	public void setN_khlx_eq(String n_khlx_eq) {
        this.n_khlx_eq = n_khlx_eq;
        if(!ObjectUtils.isEmpty(this.n_khlx_eq)){
            this.getSelectCond().eq("khlx", n_khlx_eq);
        }
    }
	private String n_parjxkhxhzname_like;//[绩效考核项得分汇总名称]
	public void setN_parjxkhxhzname_like(String n_parjxkhxhzname_like) {
        this.n_parjxkhxhzname_like = n_parjxkhxhzname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxkhxhzname_like)){
            this.getSelectCond().like("parjxkhxhzname", n_parjxkhxhzname_like);
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
                     wrapper.like("parjxkhxhzname", query)   
            );
		 }
	}
}




