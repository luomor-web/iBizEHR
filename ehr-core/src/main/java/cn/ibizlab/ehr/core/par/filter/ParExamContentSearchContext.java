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
import cn.ibizlab.ehr.core.par.domain.ParExamContent;
/**
 * 关系型数据实体[ParExamContent] 查询条件对象
 */
@Slf4j
@Data
public class ParExamContentSearchContext extends QueryWrapperContext<ParExamContent> {

	private String n_parexamcontentname_like;//[考核内容]
	public void setN_parexamcontentname_like(String n_parexamcontentname_like) {
        this.n_parexamcontentname_like = n_parexamcontentname_like;
        if(!ObjectUtils.isEmpty(this.n_parexamcontentname_like)){
            this.getSearchCond().like("parexamcontentname", n_parexamcontentname_like);
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
                     wrapper.like("parexamcontentname", query)   
            );
		 }
	}
}




