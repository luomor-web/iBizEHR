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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ;
/**
 * 关系型数据实体[PCMXYGZZSQ] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PCMXYGZZSQSearchContext extends QueryWrapperContext<PCMXYGZZSQ> {

	private String n_pcmxygzzsqname_like;//[试用期员工转正申请名称]
	public void setN_pcmxygzzsqname_like(String n_pcmxygzzsqname_like) {
        this.n_pcmxygzzsqname_like = n_pcmxygzzsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqname_like)){
            this.getSelectCond().like("pcmxygzzsqname", n_pcmxygzzsqname_like);
        }
    }
	private String n_zzlx_eq;//[转正类型]
	public void setN_zzlx_eq(String n_zzlx_eq) {
        this.n_zzlx_eq = n_zzlx_eq;
        if(!ObjectUtils.isEmpty(this.n_zzlx_eq)){
            this.getSelectCond().eq("zzlx", n_zzlx_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmxygzzsqname",query);
		 }
	}
}




