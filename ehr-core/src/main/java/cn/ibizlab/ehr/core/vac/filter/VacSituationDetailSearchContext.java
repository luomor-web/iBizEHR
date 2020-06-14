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
import cn.ibizlab.ehr.core.vac.domain.VacSituationDetail;
/**
 * 关系型数据实体[VacSituationDetail] 查询条件对象
 */
@Slf4j
@Data
public class VacSituationDetailSearchContext extends QueryWrapperContext<VacSituationDetail> {

	private String n_xjlx_eq;//[休假类型]
	public void setN_xjlx_eq(String n_xjlx_eq) {
        this.n_xjlx_eq = n_xjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_xjlx_eq)){
            this.getSearchCond().eq("xjlx", n_xjlx_eq);
        }
    }
	private String n_vacsituationdetailname_like;//[休假明细名称]
	public void setN_vacsituationdetailname_like(String n_vacsituationdetailname_like) {
        this.n_vacsituationdetailname_like = n_vacsituationdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_vacsituationdetailname_like)){
            this.getSearchCond().like("vacsituationdetailname", n_vacsituationdetailname_like);
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
                     wrapper.like("vacsituationdetailname", query)   
            );
		 }
	}
}




