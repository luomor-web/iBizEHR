package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.PARKHFA;
/**
 * 关系型数据实体[PARKHFA] 查询条件对象
 */
@Slf4j
@Data
public class PARKHFASearchContext extends QueryWrapperContext<PARKHFA> {

	private String n_parkhfaname_like;//[考核对象]
	public void setN_parkhfaname_like(String n_parkhfaname_like) {
        this.n_parkhfaname_like = n_parkhfaname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhfaname_like)){
            this.getSelectCond().like("parkhfaname", n_parkhfaname_like);
        }
    }
	private String n_khdx_eq;//[考核对象]
	public void setN_khdx_eq(String n_khdx_eq) {
        this.n_khdx_eq = n_khdx_eq;
        if(!ObjectUtils.isEmpty(this.n_khdx_eq)){
            this.getSelectCond().eq("khdx", n_khdx_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("parkhfaname",query);
		 }
	}
}



