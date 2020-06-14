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
import cn.ibizlab.ehr.core.pcm.domain.PcmWzd0001;
/**
 * 关系型数据实体[PcmWzd0001] 查询条件对象
 */
@Slf4j
@Data
public class PcmWzd0001SearchContext extends QueryWrapperContext<PcmWzd0001> {

	private String n_shyy_eq;//[审核原因]
	public void setN_shyy_eq(String n_shyy_eq) {
        this.n_shyy_eq = n_shyy_eq;
        if(!ObjectUtils.isEmpty(this.n_shyy_eq)){
            this.getSearchCond().eq("shyy", n_shyy_eq);
        }
    }
	private String n_csyy_eq;//[初审原因]
	public void setN_csyy_eq(String n_csyy_eq) {
        this.n_csyy_eq = n_csyy_eq;
        if(!ObjectUtils.isEmpty(this.n_csyy_eq)){
            this.getSearchCond().eq("csyy", n_csyy_eq);
        }
    }
	private String n_spyy_eq;//[审批原因]
	public void setN_spyy_eq(String n_spyy_eq) {
        this.n_spyy_eq = n_spyy_eq;
        if(!ObjectUtils.isEmpty(this.n_spyy_eq)){
            this.getSearchCond().eq("spyy", n_spyy_eq);
        }
    }
	private String n_wzd0001name_like;//[向导实体1名称]
	public void setN_wzd0001name_like(String n_wzd0001name_like) {
        this.n_wzd0001name_like = n_wzd0001name_like;
        if(!ObjectUtils.isEmpty(this.n_wzd0001name_like)){
            this.getSearchCond().like("wzd0001name", n_wzd0001name_like);
        }
    }
	private String n_yglx_eq;//[员工类型]
	public void setN_yglx_eq(String n_yglx_eq) {
        this.n_yglx_eq = n_yglx_eq;
        if(!ObjectUtils.isEmpty(this.n_yglx_eq)){
            this.getSearchCond().eq("yglx", n_yglx_eq);
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
                     wrapper.like("wzd0001name", query)   
            );
		 }
	}
}




