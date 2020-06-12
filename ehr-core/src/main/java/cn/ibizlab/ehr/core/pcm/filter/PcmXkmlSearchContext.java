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
import cn.ibizlab.ehr.core.pcm.domain.PcmXkml;
/**
 * 关系型数据实体[PcmXkml] 查询条件对象
 */
@Slf4j
@Data
public class PcmXkmlSearchContext extends QueryWrapperContext<PcmXkml> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_pcmxkmlname_like;//[学科名称]
	public void setN_pcmxkmlname_like(String n_pcmxkmlname_like) {
        this.n_pcmxkmlname_like = n_pcmxkmlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxkmlname_like)){
            this.getSearchCond().like("pcmxkmlname", n_pcmxkmlname_like);
        }
    }
	private String n_xkml_eq;//[学科门类]
	public void setN_xkml_eq(String n_xkml_eq) {
        this.n_xkml_eq = n_xkml_eq;
        if(!ObjectUtils.isEmpty(this.n_xkml_eq)){
            this.getSearchCond().eq("xkml", n_xkml_eq);
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
                     wrapper.like("pcmxkmlname", query)   
            );
		 }
	}
}




