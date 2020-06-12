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
import cn.ibizlab.ehr.core.pcm.domain.PcmYpzjkxx;
/**
 * 关系型数据实体[PcmYpzjkxx] 查询条件对象
 */
@Slf4j
@Data
public class PcmYpzjkxxSearchContext extends QueryWrapperContext<PcmYpzjkxx> {

	private String n_pcmypzjkxxname_like;//[应聘者接口信息管理名称]
	public void setN_pcmypzjkxxname_like(String n_pcmypzjkxxname_like) {
        this.n_pcmypzjkxxname_like = n_pcmypzjkxxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmypzjkxxname_like)){
            this.getSearchCond().like("pcmypzjkxxname", n_pcmypzjkxxname_like);
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
                     wrapper.like("pcmypzjkxxname", query)   
            );
		 }
	}
}




