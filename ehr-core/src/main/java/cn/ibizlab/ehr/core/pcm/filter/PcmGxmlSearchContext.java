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
import cn.ibizlab.ehr.core.pcm.domain.PcmGxml;
/**
 * 关系型数据实体[PcmGxml] 查询条件对象
 */
@Slf4j
@Data
public class PcmGxmlSearchContext extends QueryWrapperContext<PcmGxml> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSearchCond().eq("nd", n_nd_eq);
        }
    }
	private String n_xxxz_eq;//[学校性质]
	public void setN_xxxz_eq(String n_xxxz_eq) {
        this.n_xxxz_eq = n_xxxz_eq;
        if(!ObjectUtils.isEmpty(this.n_xxxz_eq)){
            this.getSearchCond().eq("xxxz", n_xxxz_eq);
        }
    }
	private String n_gxlb_eq;//[高校类型（停用）]
	public void setN_gxlb_eq(String n_gxlb_eq) {
        this.n_gxlb_eq = n_gxlb_eq;
        if(!ObjectUtils.isEmpty(this.n_gxlb_eq)){
            this.getSearchCond().eq("gxlb", n_gxlb_eq);
        }
    }
	private String n_nationarea_like;//[国家或地区]
	public void setN_nationarea_like(String n_nationarea_like) {
        this.n_nationarea_like = n_nationarea_like;
        if(!ObjectUtils.isEmpty(this.n_nationarea_like)){
            this.getSearchCond().like("nationarea", n_nationarea_like);
        }
    }
	private String n_pcmgxmlname_like;//[高校名称]
	public void setN_pcmgxmlname_like(String n_pcmgxmlname_like) {
        this.n_pcmgxmlname_like = n_pcmgxmlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmgxmlname_like)){
            this.getSearchCond().like("pcmgxmlname", n_pcmgxmlname_like);
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
                     wrapper.like("pcmgxmlname", query)   
            );
		 }
	}
}




