package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmTitle;
/**
 * 关系型数据实体[OrmTitle] 查询条件对象
 */
@Slf4j
@Data
public class OrmTitleSearchContext extends QueryWrapperContext<OrmTitle> {

	private String n_titletype_eq;//[头衔类型]
	public void setN_titletype_eq(String n_titletype_eq) {
        this.n_titletype_eq = n_titletype_eq;
        if(!ObjectUtils.isEmpty(this.n_titletype_eq)){
            this.getSearchCond().eq("titletype", n_titletype_eq);
        }
    }
	private String n_ormtitlename_like;//[头衔]
	public void setN_ormtitlename_like(String n_ormtitlename_like) {
        this.n_ormtitlename_like = n_ormtitlename_like;
        if(!ObjectUtils.isEmpty(this.n_ormtitlename_like)){
            this.getSearchCond().like("ormtitlename", n_ormtitlename_like);
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
                     wrapper.like("ormtitlename", query)   
            );
		 }
	}
}




