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
import cn.ibizlab.ehr.core.par.domain.PARJXZGPCMX;
/**
 * 关系型数据实体[PARJXZGPCMX] 查询条件对象
 */
@Slf4j
@Data
public class PARJXZGPCMXSearchContext extends QueryWrapperContext<PARJXZGPCMX> {

	private String n_parjxzgpcmxname_like;//[绩效主观评测明细名称]
	public void setN_parjxzgpcmxname_like(String n_parjxzgpcmxname_like) {
        this.n_parjxzgpcmxname_like = n_parjxzgpcmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxzgpcmxname_like)){
            this.getSelectCond().like("parjxzgpcmxname", n_parjxzgpcmxname_like);
        }
    }
	private String n_parjxzgpcname_eq;//[标题]
	public void setN_parjxzgpcname_eq(String n_parjxzgpcname_eq) {
        this.n_parjxzgpcname_eq = n_parjxzgpcname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxzgpcname_eq)){
            this.getSelectCond().eq("parjxzgpcname", n_parjxzgpcname_eq);
        }
    }
	private String n_parjxzgpcname_like;//[标题]
	public void setN_parjxzgpcname_like(String n_parjxzgpcname_like) {
        this.n_parjxzgpcname_like = n_parjxzgpcname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxzgpcname_like)){
            this.getSelectCond().like("parjxzgpcname", n_parjxzgpcname_like);
        }
    }
	private String n_parjxzgpcid_eq;//[主观评测ID]
	public void setN_parjxzgpcid_eq(String n_parjxzgpcid_eq) {
        this.n_parjxzgpcid_eq = n_parjxzgpcid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxzgpcid_eq)){
            this.getSelectCond().eq("parjxzgpcid", n_parjxzgpcid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("parjxzgpcmxname",query);
		 }
	}
}



