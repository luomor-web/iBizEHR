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
import cn.ibizlab.ehr.core.pcm.domain.PcmZpmeglmx;
/**
 * 关系型数据实体[PcmZpmeglmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmZpmeglmxSearchContext extends QueryWrapperContext<PcmZpmeglmx> {

	private String n_pcmzpmeglmxname_like;//[招聘名额管理明细名称]
	public void setN_pcmzpmeglmxname_like(String n_pcmzpmeglmxname_like) {
        this.n_pcmzpmeglmxname_like = n_pcmzpmeglmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmzpmeglmxname_like)){
            this.getSearchCond().like("pcmzpmeglmxname", n_pcmzpmeglmxname_like);
        }
    }
	private String n_pcmzpmeglname_eq;//[招聘名额管理名称]
	public void setN_pcmzpmeglname_eq(String n_pcmzpmeglname_eq) {
        this.n_pcmzpmeglname_eq = n_pcmzpmeglname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmzpmeglname_eq)){
            this.getSearchCond().eq("pcmzpmeglname", n_pcmzpmeglname_eq);
        }
    }
	private String n_pcmzpmeglname_like;//[招聘名额管理名称]
	public void setN_pcmzpmeglname_like(String n_pcmzpmeglname_like) {
        this.n_pcmzpmeglname_like = n_pcmzpmeglname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmzpmeglname_like)){
            this.getSearchCond().like("pcmzpmeglname", n_pcmzpmeglname_like);
        }
    }
	private String n_pcmzpmeglid_eq;//[招聘名额管理标识]
	public void setN_pcmzpmeglid_eq(String n_pcmzpmeglid_eq) {
        this.n_pcmzpmeglid_eq = n_pcmzpmeglid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmzpmeglid_eq)){
            this.getSearchCond().eq("pcmzpmeglid", n_pcmzpmeglid_eq);
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
                     wrapper.like("pcmzpmeglmxname", query)   
            );
		 }
	}
}




