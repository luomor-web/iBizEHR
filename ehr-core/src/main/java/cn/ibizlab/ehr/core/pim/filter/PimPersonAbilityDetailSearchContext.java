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
import cn.ibizlab.ehr.core.pim.domain.PimPersonAbilityDetail;
/**
 * 关系型数据实体[PimPersonAbilityDetail] 查询条件对象
 */
@Slf4j
@Data
public class PimPersonAbilityDetailSearchContext extends QueryWrapperContext<PimPersonAbilityDetail> {

	private String n_pimpersonabilitydetailname_like;//[员工能力明细名称]
	public void setN_pimpersonabilitydetailname_like(String n_pimpersonabilitydetailname_like) {
        this.n_pimpersonabilitydetailname_like = n_pimpersonabilitydetailname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonabilitydetailname_like)){
            this.getSearchCond().like("pimpersonabilitydetailname", n_pimpersonabilitydetailname_like);
        }
    }
	private String n_pimpersonabilityid_eq;//[员工能力标识]
	public void setN_pimpersonabilityid_eq(String n_pimpersonabilityid_eq) {
        this.n_pimpersonabilityid_eq = n_pimpersonabilityid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonabilityid_eq)){
            this.getSearchCond().eq("pimpersonabilityid", n_pimpersonabilityid_eq);
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
                     wrapper.like("pimpersonabilitydetailname", query)   
            );
		 }
	}
}




