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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSpyy;
/**
 * 关系型数据实体[PcmProfileSpyy] 查询条件对象
 */
@Slf4j
@Data
public class PcmProfileSpyySearchContext extends QueryWrapperContext<PcmProfileSpyy> {

	private String n_pcmprofilespyyname_like;//[应聘者审批原因名称]
	public void setN_pcmprofilespyyname_like(String n_pcmprofilespyyname_like) {
        this.n_pcmprofilespyyname_like = n_pcmprofilespyyname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilespyyname_like)){
            this.getSearchCond().like("pcmprofilespyyname", n_pcmprofilespyyname_like);
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
                     wrapper.like("pcmprofilespyyname", query)   
            );
		 }
	}
}




