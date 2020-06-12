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
import cn.ibizlab.ehr.core.sal.domain.SalStdXmgzRate;
/**
 * 关系型数据实体[SalStdXmgzRate] 查询条件对象
 */
@Slf4j
@Data
public class SalStdXmgzRateSearchContext extends QueryWrapperContext<SalStdXmgzRate> {

	private String n_salstdxmgzratename_like;//[项目工资标准(绩效比例)名称]
	public void setN_salstdxmgzratename_like(String n_salstdxmgzratename_like) {
        this.n_salstdxmgzratename_like = n_salstdxmgzratename_like;
        if(!ObjectUtils.isEmpty(this.n_salstdxmgzratename_like)){
            this.getSearchCond().like("salstdxmgzratename", n_salstdxmgzratename_like);
        }
    }
	private String n_khjl_eq;//[绩效考核结论]
	public void setN_khjl_eq(String n_khjl_eq) {
        this.n_khjl_eq = n_khjl_eq;
        if(!ObjectUtils.isEmpty(this.n_khjl_eq)){
            this.getSearchCond().eq("khjl", n_khjl_eq);
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
	private String n_ormorgid_eq;//[组织标识]
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
                     wrapper.like("salstdxmgzratename", query)   
            );
		 }
	}
}




