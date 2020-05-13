package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SALPARAM;
/**
 * 关系型数据实体[SALPARAM] 查询条件对象
 */
@Slf4j
@Data
public class SALPARAMSearchContext extends QueryWrapperContext<SALPARAM> {

	private String n_salparamname_like;//[薪酬计算指标名称]
	public void setN_salparamname_like(String n_salparamname_like) {
        this.n_salparamname_like = n_salparamname_like;
        if(!ObjectUtils.isEmpty(this.n_salparamname_like)){
            this.getSelectCond().like("salparamname", n_salparamname_like);
        }
    }
	private String n_salsourcename_eq;//[薪酬计算源]
	public void setN_salsourcename_eq(String n_salsourcename_eq) {
        this.n_salsourcename_eq = n_salsourcename_eq;
        if(!ObjectUtils.isEmpty(this.n_salsourcename_eq)){
            this.getSelectCond().eq("salsourcename", n_salsourcename_eq);
        }
    }
	private String n_salsourcename_like;//[薪酬计算源]
	public void setN_salsourcename_like(String n_salsourcename_like) {
        this.n_salsourcename_like = n_salsourcename_like;
        if(!ObjectUtils.isEmpty(this.n_salsourcename_like)){
            this.getSelectCond().like("salsourcename", n_salsourcename_like);
        }
    }
	private String n_salsourceid_eq;//[薪酬计算源]
	public void setN_salsourceid_eq(String n_salsourceid_eq) {
        this.n_salsourceid_eq = n_salsourceid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsourceid_eq)){
            this.getSelectCond().eq("salsourceid", n_salsourceid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("salparamname",query);
		 }
	}
}



