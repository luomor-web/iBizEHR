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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileSzyjtj;
/**
 * 关系型数据实体[PcmProfileSzyjtj] 查询条件对象
 */
@Slf4j
@Data
public class PcmProfileSzyjtjSearchContext extends QueryWrapperContext<PcmProfileSzyjtj> {

	private String n_yglx_eq;//[申报类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSearchCond().eq("yglx", n_yglx_eq);
        }
    }
	private String n_pcmprofileszyjtjname_like;//[应聘者社招引进条件]
	public void setN_pcmprofileszyjtjname_like(String n_pcmprofileszyjtjname_like) {
        this.n_pcmprofileszyjtjname_like = n_pcmprofileszyjtjname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileszyjtjname_like)){
            this.getSearchCond().like("pcmprofileszyjtjname", n_pcmprofileszyjtjname_like);
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
                     wrapper.like("pcmprofileszyjtjname", query)   
            );
		 }
	}
}




