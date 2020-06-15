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
import cn.ibizlab.ehr.core.par.domain.ParAssessTemplate;
/**
 * 关系型数据实体[ParAssessTemplate] 查询条件对象
 */
@Slf4j
@Data
public class ParAssessTemplateSearchContext extends QueryWrapperContext<ParAssessTemplate> {

	private String n_parassesstemplatename_like;//[考核模板名称]
	public void setN_parassesstemplatename_like(String n_parassesstemplatename_like) {
        this.n_parassesstemplatename_like = n_parassesstemplatename_like;
        if(!ObjectUtils.isEmpty(this.n_parassesstemplatename_like)){
            this.getSearchCond().like("parassesstemplatename", n_parassesstemplatename_like);
        }
    }
	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_khdx_eq;//[考核对象]
	public void setN_khdx_eq(String n_khdx_eq) {
        this.n_khdx_eq = n_khdx_eq;
        if(!ObjectUtils.isEmpty(this.n_khdx_eq)){
            this.getSearchCond().eq("khdx", n_khdx_eq);
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
                     wrapper.like("parassesstemplatename", query)   
            );
		 }
	}
}




