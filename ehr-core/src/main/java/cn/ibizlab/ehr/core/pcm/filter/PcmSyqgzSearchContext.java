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
import cn.ibizlab.ehr.core.pcm.domain.PcmSyqgz;
/**
 * 关系型数据实体[PcmSyqgz] 查询条件对象
 */
@Slf4j
@Data
public class PcmSyqgzSearchContext extends QueryWrapperContext<PcmSyqgz> {

	private String n_duration_eq;//[试用期限]
	public void setN_duration_eq(String n_duration_eq) {
        this.n_duration_eq = n_duration_eq;
        if(!ObjectUtils.isEmpty(this.n_duration_eq)){
            this.getSearchCond().eq("duration", n_duration_eq);
        }
    }
	private String n_pcmsyqgzname_eq;//[试用期规则名称]
	public void setN_pcmsyqgzname_eq(String n_pcmsyqgzname_eq) {
        this.n_pcmsyqgzname_eq = n_pcmsyqgzname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmsyqgzname_eq)){
            this.getSearchCond().eq("pcmsyqgzname", n_pcmsyqgzname_eq);
        }
    }
	private String n_pcmsyqgzname_like;//[试用期规则名称]
	public void setN_pcmsyqgzname_like(String n_pcmsyqgzname_like) {
        this.n_pcmsyqgzname_like = n_pcmsyqgzname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmsyqgzname_like)){
            this.getSearchCond().like("pcmsyqgzname", n_pcmsyqgzname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
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
                     wrapper.like("pcmsyqgzname", query)   
            );
		 }
	}
}




