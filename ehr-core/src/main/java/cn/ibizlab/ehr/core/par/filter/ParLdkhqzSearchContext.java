package cn.ibizlab.ehr.core.par.filter;

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
import cn.ibizlab.ehr.core.par.domain.ParLdkhqz;
/**
 * 关系型数据实体[ParLdkhqz] 查询条件对象
 */
@Slf4j
@Data
public class ParLdkhqzSearchContext extends QueryWrapperContext<ParLdkhqz> {

	private String n_pfzt_eq;//[评分主体]
	public void setN_pfzt_eq(String n_pfzt_eq) {
        this.n_pfzt_eq = n_pfzt_eq;
        if(!ObjectUtils.isEmpty(this.n_pfzt_eq)){
            this.getSearchCond().eq("pfzt", n_pfzt_eq);
        }
    }
	private String n_parldkhqzname_like;//[评分规则]
	public void setN_parldkhqzname_like(String n_parldkhqzname_like) {
        this.n_parldkhqzname_like = n_parldkhqzname_like;
        if(!ObjectUtils.isEmpty(this.n_parldkhqzname_like)){
            this.getSearchCond().like("parldkhqzname", n_parldkhqzname_like);
        }
    }
	private String n_parkhzcmxname_eq;//[考核内容]
	public void setN_parkhzcmxname_eq(String n_parkhzcmxname_eq) {
        this.n_parkhzcmxname_eq = n_parkhzcmxname_eq;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_eq)){
            this.getSearchCond().eq("parkhzcmxname", n_parkhzcmxname_eq);
        }
    }
	private String n_parkhzcmxname_like;//[考核内容]
	public void setN_parkhzcmxname_like(String n_parkhzcmxname_like) {
        this.n_parkhzcmxname_like = n_parkhzcmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_like)){
            this.getSearchCond().like("parkhzcmxname", n_parkhzcmxname_like);
        }
    }
	private String n_parkhzcmxid_eq;//[考核内容ID]
	public void setN_parkhzcmxid_eq(String n_parkhzcmxid_eq) {
        this.n_parkhzcmxid_eq = n_parkhzcmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxid_eq)){
            this.getSearchCond().eq("parkhzcmxid", n_parkhzcmxid_eq);
        }
    }
	private String n_khobject_eq;//[考核对象]
	public void setN_khobject_eq(String n_khobject_eq) {
        this.n_khobject_eq = n_khobject_eq;
        if(!ObjectUtils.isEmpty(this.n_khobject_eq)){
            this.getSearchCond().eq("khobject", n_khobject_eq);
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
                     wrapper.like("parldkhqzname", query)   
            );
		 }
	}
}




