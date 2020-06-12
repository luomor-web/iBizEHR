package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjgwh;
/**
 * 关系型数据实体[PcmXygzzjgwh] 查询条件对象
 */
@Slf4j
@Data
public class PcmXygzzjgwhSearchContext extends QueryWrapperContext<PcmXygzzjgwh> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_pcmxygzzjgwhname_like;//[员工]
	public void setN_pcmxygzzjgwhname_like(String n_pcmxygzzjgwhname_like) {
        this.n_pcmxygzzjgwhname_like = n_pcmxygzzjgwhname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzjgwhname_like)){
            this.getSearchCond().like("pcmxygzzjgwhname", n_pcmxygzzjgwhname_like);
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
                     wrapper.like("pcmxygzzjgwhname", query)   
            );
		 }
	}
}




