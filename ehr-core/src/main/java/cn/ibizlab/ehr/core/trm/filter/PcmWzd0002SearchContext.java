package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.PcmWzd0002;
/**
 * 关系型数据实体[PcmWzd0002] 查询条件对象
 */
@Slf4j
@Data
public class PcmWzd0002SearchContext extends QueryWrapperContext<PcmWzd0002> {

	private String n_tcyy_eq;//[退出原因]
	public void setN_tcyy_eq(String n_tcyy_eq) {
        this.n_tcyy_eq = n_tcyy_eq;
        if(!ObjectUtils.isEmpty(this.n_tcyy_eq)){
            this.getSearchCond().eq("tcyy", n_tcyy_eq);
        }
    }
	private String n_status_eq;//[状态]
	public void setN_status_eq(String n_status_eq) {
        this.n_status_eq = n_status_eq;
        if(!ObjectUtils.isEmpty(this.n_status_eq)){
            this.getSearchCond().eq("status", n_status_eq);
        }
    }
	private String n_wzd0002name_like;//[干部退出（优秀年轻干部梯队）名称]
	public void setN_wzd0002name_like(String n_wzd0002name_like) {
        this.n_wzd0002name_like = n_wzd0002name_like;
        if(!ObjectUtils.isEmpty(this.n_wzd0002name_like)){
            this.getSearchCond().like("wzd0002name", n_wzd0002name_like);
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
                     wrapper.like("wzd0002name", query)   
            );
		 }
	}
}




