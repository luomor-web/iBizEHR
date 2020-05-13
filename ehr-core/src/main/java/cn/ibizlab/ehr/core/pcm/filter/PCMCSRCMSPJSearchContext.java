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
import cn.ibizlab.ehr.core.pcm.domain.PCMCSRCMSPJ;
/**
 * 关系型数据实体[PCMCSRCMSPJ] 查询条件对象
 */
@Slf4j
@Data
public class PCMCSRCMSPJSearchContext extends QueryWrapperContext<PCMCSRCMSPJ> {

	private String n_pcmcsrcmspjname_like;//[成熟人才面试评价名称]
	public void setN_pcmcsrcmspjname_like(String n_pcmcsrcmspjname_like) {
        this.n_pcmcsrcmspjname_like = n_pcmcsrcmspjname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmcsrcmspjname_like)){
            this.getSelectCond().like("pcmcsrcmspjname", n_pcmcsrcmspjname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmcsrcmspjname",query);
		 }
	}
}




