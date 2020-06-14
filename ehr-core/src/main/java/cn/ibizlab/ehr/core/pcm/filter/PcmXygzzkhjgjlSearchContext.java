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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzkhjgjl;
/**
 * 关系型数据实体[PcmXygzzkhjgjl] 查询条件对象
 */
@Slf4j
@Data
public class PcmXygzzkhjgjlSearchContext extends QueryWrapperContext<PcmXygzzkhjgjl> {

	private String n_pj_eq;//[评价]
	public void setN_pj_eq(String n_pj_eq) {
        this.n_pj_eq = n_pj_eq;
        if(!ObjectUtils.isEmpty(this.n_pj_eq)){
            this.getSearchCond().eq("pj", n_pj_eq);
        }
    }
	private String n_pcmxygzzkhjgjlname_like;//[员工]
	public void setN_pcmxygzzkhjgjlname_like(String n_pcmxygzzkhjgjlname_like) {
        this.n_pcmxygzzkhjgjlname_like = n_pcmxygzzkhjgjlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzkhjgjlname_like)){
            this.getSearchCond().like("pcmxygzzkhjgjlname", n_pcmxygzzkhjgjlname_like);
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
                     wrapper.like("pcmxygzzkhjgjlname", query)   
            );
		 }
	}
}




