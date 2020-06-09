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
import cn.ibizlab.ehr.core.par.domain.ParDjbz;
/**
 * 关系型数据实体[ParDjbz] 查询条件对象
 */
@Slf4j
@Data
public class ParDjbzSearchContext extends QueryWrapperContext<ParDjbz> {

	private String n_khpgdj_eq;//[考核评估等级]
	public void setN_khpgdj_eq(String n_khpgdj_eq) {
        this.n_khpgdj_eq = n_khpgdj_eq;
        if(!ObjectUtils.isEmpty(this.n_khpgdj_eq)){
            this.getSearchCond().eq("khpgdj", n_khpgdj_eq);
        }
    }
	private String n_pardjbzname_like;//[定级标准名称]
	public void setN_pardjbzname_like(String n_pardjbzname_like) {
        this.n_pardjbzname_like = n_pardjbzname_like;
        if(!ObjectUtils.isEmpty(this.n_pardjbzname_like)){
            this.getSearchCond().like("pardjbzname", n_pardjbzname_like);
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
                     wrapper.like("pardjbzname", query)   
            );
		 }
	}
}




