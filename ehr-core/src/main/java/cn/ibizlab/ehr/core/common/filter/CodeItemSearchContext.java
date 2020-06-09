package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.CodeItem;
/**
 * 关系型数据实体[CodeItem] 查询条件对象
 */
@Slf4j
@Data
public class CodeItemSearchContext extends QueryWrapperContext<CodeItem> {

	private String n_codeitemname_like;//[代码项名称]
	public void setN_codeitemname_like(String n_codeitemname_like) {
        this.n_codeitemname_like = n_codeitemname_like;
        if(!ObjectUtils.isEmpty(this.n_codeitemname_like)){
            this.getSearchCond().like("codeitemname", n_codeitemname_like);
        }
    }
	private String n_codelistname_eq;//[代码表]
	public void setN_codelistname_eq(String n_codelistname_eq) {
        this.n_codelistname_eq = n_codelistname_eq;
        if(!ObjectUtils.isEmpty(this.n_codelistname_eq)){
            this.getSearchCond().eq("codelistname", n_codelistname_eq);
        }
    }
	private String n_codelistname_like;//[代码表]
	public void setN_codelistname_like(String n_codelistname_like) {
        this.n_codelistname_like = n_codelistname_like;
        if(!ObjectUtils.isEmpty(this.n_codelistname_like)){
            this.getSearchCond().like("codelistname", n_codelistname_like);
        }
    }
	private String n_pcodeitemname_eq;//[上级代码项]
	public void setN_pcodeitemname_eq(String n_pcodeitemname_eq) {
        this.n_pcodeitemname_eq = n_pcodeitemname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcodeitemname_eq)){
            this.getSearchCond().eq("pcodeitemname", n_pcodeitemname_eq);
        }
    }
	private String n_pcodeitemname_like;//[上级代码项]
	public void setN_pcodeitemname_like(String n_pcodeitemname_like) {
        this.n_pcodeitemname_like = n_pcodeitemname_like;
        if(!ObjectUtils.isEmpty(this.n_pcodeitemname_like)){
            this.getSearchCond().like("pcodeitemname", n_pcodeitemname_like);
        }
    }
	private String n_pcodeitemid_eq;//[上级代码项]
	public void setN_pcodeitemid_eq(String n_pcodeitemid_eq) {
        this.n_pcodeitemid_eq = n_pcodeitemid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcodeitemid_eq)){
            this.getSearchCond().eq("pcodeitemid", n_pcodeitemid_eq);
        }
    }
	private String n_codelistid_eq;//[代码表]
	public void setN_codelistid_eq(String n_codelistid_eq) {
        this.n_codelistid_eq = n_codelistid_eq;
        if(!ObjectUtils.isEmpty(this.n_codelistid_eq)){
            this.getSearchCond().eq("codelistid", n_codelistid_eq);
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
                     wrapper.like("codeitemname", query)   
            );
		 }
	}
}




