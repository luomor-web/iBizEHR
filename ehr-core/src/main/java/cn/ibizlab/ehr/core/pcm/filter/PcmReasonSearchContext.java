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
import cn.ibizlab.ehr.core.pcm.domain.PcmReason;
/**
 * 关系型数据实体[PcmReason] 查询条件对象
 */
@Slf4j
@Data
public class PcmReasonSearchContext extends QueryWrapperContext<PcmReason> {

	private String n_lx_eq;//[类型]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_pcmreasonname_like;//[配置原因代码表名称]
	public void setN_pcmreasonname_like(String n_pcmreasonname_like) {
        this.n_pcmreasonname_like = n_pcmreasonname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmreasonname_like)){
            this.getSearchCond().like("pcmreasonname", n_pcmreasonname_like);
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
                     wrapper.like("pcmreasonname", query)   
            );
		 }
	}
}




