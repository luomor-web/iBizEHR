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
import cn.ibizlab.ehr.core.pcm.domain.PcmRcxl;
/**
 * 关系型数据实体[PcmRcxl] 查询条件对象
 */
@Slf4j
@Data
public class PcmRcxlSearchContext extends QueryWrapperContext<PcmRcxl> {

	private String n_rcxlmc_like;//[人才序列名称]
	public void setN_rcxlmc_like(String n_rcxlmc_like) {
        this.n_rcxlmc_like = n_rcxlmc_like;
        if(!ObjectUtils.isEmpty(this.n_rcxlmc_like)){
            this.getSearchCond().like("rcxlmc", n_rcxlmc_like);
        }
    }
	private String n_rcxllx_eq;//[人才序列类型]
	public void setN_rcxllx_eq(String n_rcxllx_eq) {
        this.n_rcxllx_eq = n_rcxllx_eq;
        if(!ObjectUtils.isEmpty(this.n_rcxllx_eq)){
            this.getSearchCond().eq("rcxllx", n_rcxllx_eq);
        }
    }
	private String n_pcmrcxlname_like;//[人才序列名称]
	public void setN_pcmrcxlname_like(String n_pcmrcxlname_like) {
        this.n_pcmrcxlname_like = n_pcmrcxlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlname_like)){
            this.getSearchCond().like("pcmrcxlname", n_pcmrcxlname_like);
        }
    }
	private String n_pcmrcxlname2_eq;//[上级]
	public void setN_pcmrcxlname2_eq(String n_pcmrcxlname2_eq) {
        this.n_pcmrcxlname2_eq = n_pcmrcxlname2_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlname2_eq)){
            this.getSearchCond().eq("pcmrcxlname2", n_pcmrcxlname2_eq);
        }
    }
	private String n_pcmrcxlname2_like;//[上级]
	public void setN_pcmrcxlname2_like(String n_pcmrcxlname2_like) {
        this.n_pcmrcxlname2_like = n_pcmrcxlname2_like;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlname2_like)){
            this.getSearchCond().like("pcmrcxlname2", n_pcmrcxlname2_like);
        }
    }
	private String n_pcmrcxlid2_eq;//[人才序列标识]
	public void setN_pcmrcxlid2_eq(String n_pcmrcxlid2_eq) {
        this.n_pcmrcxlid2_eq = n_pcmrcxlid2_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmrcxlid2_eq)){
            this.getSearchCond().eq("pcmrcxlid2", n_pcmrcxlid2_eq);
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
                     wrapper.like("rcxlmc", query)   
            );
		 }
	}
}




