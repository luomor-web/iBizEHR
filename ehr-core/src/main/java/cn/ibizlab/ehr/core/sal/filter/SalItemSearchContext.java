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
import cn.ibizlab.ehr.core.sal.domain.SalItem;
/**
 * 关系型数据实体[SalItem] 查询条件对象
 */
@Slf4j
@Data
public class SalItemSearchContext extends QueryWrapperContext<SalItem> {

	private String n_salitemname_like;//[要素项]
	public void setN_salitemname_like(String n_salitemname_like) {
        this.n_salitemname_like = n_salitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salitemname_like)){
            this.getSearchCond().like("salitemname", n_salitemname_like);
        }
    }
	private String n_salsubjectname_eq;//[财务科目]
	public void setN_salsubjectname_eq(String n_salsubjectname_eq) {
        this.n_salsubjectname_eq = n_salsubjectname_eq;
        if(!ObjectUtils.isEmpty(this.n_salsubjectname_eq)){
            this.getSearchCond().eq("salsubjectname", n_salsubjectname_eq);
        }
    }
	private String n_salsubjectname_like;//[财务科目]
	public void setN_salsubjectname_like(String n_salsubjectname_like) {
        this.n_salsubjectname_like = n_salsubjectname_like;
        if(!ObjectUtils.isEmpty(this.n_salsubjectname_like)){
            this.getSearchCond().like("salsubjectname", n_salsubjectname_like);
        }
    }
	private String n_salsubjectid_eq;//[财务科目标识]
	public void setN_salsubjectid_eq(String n_salsubjectid_eq) {
        this.n_salsubjectid_eq = n_salsubjectid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsubjectid_eq)){
            this.getSearchCond().eq("salsubjectid", n_salsubjectid_eq);
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
                     wrapper.like("salitemname", query)   
            );
		 }
	}
}




