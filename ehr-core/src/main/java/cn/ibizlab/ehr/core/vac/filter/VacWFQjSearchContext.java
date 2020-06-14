package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VacWFQj;
/**
 * 关系型数据实体[VacWFQj] 查询条件对象
 */
@Slf4j
@Data
public class VacWFQjSearchContext extends QueryWrapperContext<VacWFQj> {

	private String n_qjstate_eq;//[请销假状态]
	public void setN_qjstate_eq(String n_qjstate_eq) {
        this.n_qjstate_eq = n_qjstate_eq;
        if(!ObjectUtils.isEmpty(this.n_qjstate_eq)){
            this.getSearchCond().eq("qjstate", n_qjstate_eq);
        }
    }
	private String n_wfqjname_like;//[请假（WF）名称]
	public void setN_wfqjname_like(String n_wfqjname_like) {
        this.n_wfqjname_like = n_wfqjname_like;
        if(!ObjectUtils.isEmpty(this.n_wfqjname_like)){
            this.getSearchCond().like("wfqjname", n_wfqjname_like);
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
                     wrapper.like("wfqjname", query)   
            );
		 }
	}
}




