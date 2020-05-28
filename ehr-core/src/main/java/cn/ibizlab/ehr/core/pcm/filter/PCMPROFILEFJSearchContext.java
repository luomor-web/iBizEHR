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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEFJ;
/**
 * 关系型数据实体[PCMPROFILEFJ] 查询条件对象
 */
@Slf4j
@Data
public class PCMPROFILEFJSearchContext extends QueryWrapperContext<PCMPROFILEFJ> {

	private String n_pcmprofilefjname_like;//[应聘者附件名称]
	public void setN_pcmprofilefjname_like(String n_pcmprofilefjname_like) {
        this.n_pcmprofilefjname_like = n_pcmprofilefjname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilefjname_like)){
            this.getSelectCond().like("pcmprofilefjname", n_pcmprofilefjname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSelectCond().and( wrapper ->
                     wrapper.like("pcmprofilefjname", query)   
            );
		 }
	}
}




