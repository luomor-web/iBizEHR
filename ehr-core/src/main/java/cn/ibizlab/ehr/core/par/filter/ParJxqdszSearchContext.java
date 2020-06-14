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
import cn.ibizlab.ehr.core.par.domain.ParJxqdsz;
/**
 * 关系型数据实体[ParJxqdsz] 查询条件对象
 */
@Slf4j
@Data
public class ParJxqdszSearchContext extends QueryWrapperContext<ParJxqdsz> {

	private String n_qdlx_eq;//[启动类型]
	public void setN_qdlx_eq(String n_qdlx_eq) {
        this.n_qdlx_eq = n_qdlx_eq;
        if(!ObjectUtils.isEmpty(this.n_qdlx_eq)){
            this.getSearchCond().eq("qdlx", n_qdlx_eq);
        }
    }
	private String n_parjxqdszname_like;//[标题]
	public void setN_parjxqdszname_like(String n_parjxqdszname_like) {
        this.n_parjxqdszname_like = n_parjxqdszname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxqdszname_like)){
            this.getSearchCond().like("parjxqdszname", n_parjxqdszname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织ID]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("parjxqdszname", query)   
            );
		 }
	}
}




