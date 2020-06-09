package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SALPERSONSTDDETAIL;
/**
 * 关系型数据实体[SALPERSONSTDDETAIL] 查询条件对象
 */
@Slf4j
@Data
public class SALPERSONSTDDETAILSearchContext extends QueryWrapperContext<SALPERSONSTDDETAIL> {

	private String n_salpersonstddetailname_like;//[员工薪酬标准明细名称]
	public void setN_salpersonstddetailname_like(String n_salpersonstddetailname_like) {
        this.n_salpersonstddetailname_like = n_salpersonstddetailname_like;
        if(!ObjectUtils.isEmpty(this.n_salpersonstddetailname_like)){
            this.getSearchCond().like("salpersonstddetailname", n_salpersonstddetailname_like);
        }
    }
	private String n_salpersonstdname_eq;//[员工薪酬标准名称]
	public void setN_salpersonstdname_eq(String n_salpersonstdname_eq) {
        this.n_salpersonstdname_eq = n_salpersonstdname_eq;
        if(!ObjectUtils.isEmpty(this.n_salpersonstdname_eq)){
            this.getSearchCond().eq("salpersonstdname", n_salpersonstdname_eq);
        }
    }
	private String n_salpersonstdname_like;//[员工薪酬标准名称]
	public void setN_salpersonstdname_like(String n_salpersonstdname_like) {
        this.n_salpersonstdname_like = n_salpersonstdname_like;
        if(!ObjectUtils.isEmpty(this.n_salpersonstdname_like)){
            this.getSearchCond().like("salpersonstdname", n_salpersonstdname_like);
        }
    }
	private String n_salschemeitemname_eq;//[要素项]
	public void setN_salschemeitemname_eq(String n_salschemeitemname_eq) {
        this.n_salschemeitemname_eq = n_salschemeitemname_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemname_eq)){
            this.getSearchCond().eq("salschemeitemname", n_salschemeitemname_eq);
        }
    }
	private String n_salschemeitemname_like;//[要素项]
	public void setN_salschemeitemname_like(String n_salschemeitemname_like) {
        this.n_salschemeitemname_like = n_salschemeitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemname_like)){
            this.getSearchCond().like("salschemeitemname", n_salschemeitemname_like);
        }
    }
	private String n_salpersonstdid_eq;//[员工薪酬标准标识]
	public void setN_salpersonstdid_eq(String n_salpersonstdid_eq) {
        this.n_salpersonstdid_eq = n_salpersonstdid_eq;
        if(!ObjectUtils.isEmpty(this.n_salpersonstdid_eq)){
            this.getSearchCond().eq("salpersonstdid", n_salpersonstdid_eq);
        }
    }
	private String n_salschemeitemid_eq;//[方案要素项标识]
	public void setN_salschemeitemid_eq(String n_salschemeitemid_eq) {
        this.n_salschemeitemid_eq = n_salschemeitemid_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemid_eq)){
            this.getSearchCond().eq("salschemeitemid", n_salschemeitemid_eq);
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
                     wrapper.like("salpersonstddetailname", query)   
            );
		 }
	}
}




