package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimWorkflowRef;
/**
 * 关系型数据实体[PimWorkflowRef] 查询条件对象
 */
@Slf4j
@Data
public class PimWorkflowRefSearchContext extends QueryWrapperContext<PimWorkflowRef> {

	private String n_pimworkflowrefname_like;//[平台流程配置名称]
	public void setN_pimworkflowrefname_like(String n_pimworkflowrefname_like) {
        this.n_pimworkflowrefname_like = n_pimworkflowrefname_like;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowrefname_like)){
            this.getSearchCond().like("pimworkflowrefname", n_pimworkflowrefname_like);
        }
    }
	private String n_pimworkflowname_eq;//[流程配置]
	public void setN_pimworkflowname_eq(String n_pimworkflowname_eq) {
        this.n_pimworkflowname_eq = n_pimworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowname_eq)){
            this.getSearchCond().eq("pimworkflowname", n_pimworkflowname_eq);
        }
    }
	private String n_pimworkflowname_like;//[流程配置]
	public void setN_pimworkflowname_like(String n_pimworkflowname_like) {
        this.n_pimworkflowname_like = n_pimworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowname_like)){
            this.getSearchCond().like("pimworkflowname", n_pimworkflowname_like);
        }
    }
	private String n_pimworkflowid_eq;//[流程配置]
	public void setN_pimworkflowid_eq(String n_pimworkflowid_eq) {
        this.n_pimworkflowid_eq = n_pimworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowid_eq)){
            this.getSearchCond().eq("pimworkflowid", n_pimworkflowid_eq);
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
                     wrapper.like("pimworkflowrefname", query)   
            );
		 }
	}
}




