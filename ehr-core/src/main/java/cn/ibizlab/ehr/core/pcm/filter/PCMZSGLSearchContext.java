package cn.ibizlab.ehr.core.pcm.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.pcm.domain.PCMZSGL;
/**
 * 关系型数据实体[PCMZSGL] 查询条件对象
 */
@Slf4j
@Data
public class PCMZSGLSearchContext extends QueryWrapperContext<PCMZSGL> {

	private String n_pcmzsglname_like;//[职数管理名称]
	public void setN_pcmzsglname_like(String n_pcmzsglname_like) {
        this.n_pcmzsglname_like = n_pcmzsglname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmzsglname_like)){
            this.getSelectCond().like("pcmzsglname", n_pcmzsglname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmzsglname",query);
		 }
	}
}



