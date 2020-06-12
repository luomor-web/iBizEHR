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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsgz;
/**
 * 关系型数据实体[PcmJxsgz] 查询条件对象
 */
@Slf4j
@Data
public class PcmJxsgzSearchContext extends QueryWrapperContext<PcmJxsgz> {

	private String n_xllx_eq;//[学历类型]
	public void setN_xllx_eq(String n_xllx_eq) {
        this.n_xllx_eq = n_xllx_eq;
        if(!ObjectUtils.isEmpty(this.n_xllx_eq)){
            this.getSearchCond().eq("xllx", n_xllx_eq);
        }
    }
	private String n_duration_eq;//[见习期限]
	public void setN_duration_eq(String n_duration_eq) {
        this.n_duration_eq = n_duration_eq;
        if(!ObjectUtils.isEmpty(this.n_duration_eq)){
            this.getSearchCond().eq("duration", n_duration_eq);
        }
    }
	private String n_pcmjxsgzname_like;//[见习生规则名称]
	public void setN_pcmjxsgzname_like(String n_pcmjxsgzname_like) {
        this.n_pcmjxsgzname_like = n_pcmjxsgzname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsgzname_like)){
            this.getSearchCond().like("pcmjxsgzname", n_pcmjxsgzname_like);
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
                     wrapper.like("pcmjxsgzname", query)   
            );
		 }
	}
}




