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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxbz;
/**
 * 关系型数据实体[PcmTxbz] 查询条件对象
 */
@Slf4j
@Data
public class PcmTxbzSearchContext extends QueryWrapperContext<PcmTxbz> {

	private String n_xb_eq;//[性别]
	public void setN_xb_eq(String n_xb_eq) {
        this.n_xb_eq = n_xb_eq;
        if(!ObjectUtils.isEmpty(this.n_xb_eq)){
            this.getSearchCond().eq("xb", n_xb_eq);
        }
    }
	private String n_pcmtxbzname_like;//[退休标准管理名称]
	public void setN_pcmtxbzname_like(String n_pcmtxbzname_like) {
        this.n_pcmtxbzname_like = n_pcmtxbzname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmtxbzname_like)){
            this.getSearchCond().like("pcmtxbzname", n_pcmtxbzname_like);
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
                     wrapper.like("xb", query)   
                        .or().like("pcmtxbzname", query)            
            );
		 }
	}
}




