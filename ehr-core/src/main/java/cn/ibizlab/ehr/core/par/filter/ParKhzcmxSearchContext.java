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
import cn.ibizlab.ehr.core.par.domain.ParKhzcmx;
/**
 * 关系型数据实体[ParKhzcmx] 查询条件对象
 */
@Slf4j
@Data
public class ParKhzcmxSearchContext extends QueryWrapperContext<ParKhzcmx> {

	private String n_parkhzcmxname_like;//[考核模板明细]
	public void setN_parkhzcmxname_like(String n_parkhzcmxname_like) {
        this.n_parkhzcmxname_like = n_parkhzcmxname_like;
        if(!ObjectUtils.isEmpty(this.n_parkhzcmxname_like)){
            this.getSearchCond().like("parkhzcmxname", n_parkhzcmxname_like);
        }
    }
	private String n_parjxkhjcszname_eq;//[考核方案]
	public void setN_parjxkhjcszname_eq(String n_parjxkhjcszname_eq) {
        this.n_parjxkhjcszname_eq = n_parjxkhjcszname_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszname_eq)){
            this.getSearchCond().eq("parjxkhjcszname", n_parjxkhjcszname_eq);
        }
    }
	private String n_parjxkhjcszname_like;//[考核方案]
	public void setN_parjxkhjcszname_like(String n_parjxkhjcszname_like) {
        this.n_parjxkhjcszname_like = n_parjxkhjcszname_like;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszname_like)){
            this.getSearchCond().like("parjxkhjcszname", n_parjxkhjcszname_like);
        }
    }
	private String n_parjxkhjcszid_eq;//[考核方案ID]
	public void setN_parjxkhjcszid_eq(String n_parjxkhjcszid_eq) {
        this.n_parjxkhjcszid_eq = n_parjxkhjcszid_eq;
        if(!ObjectUtils.isEmpty(this.n_parjxkhjcszid_eq)){
            this.getSearchCond().eq("parjxkhjcszid", n_parjxkhjcszid_eq);
        }
    }
	private String n_parassesstemplateid_eq;//[考核模板标识]
	public void setN_parassesstemplateid_eq(String n_parassesstemplateid_eq) {
        this.n_parassesstemplateid_eq = n_parassesstemplateid_eq;
        if(!ObjectUtils.isEmpty(this.n_parassesstemplateid_eq)){
            this.getSearchCond().eq("parassesstemplateid", n_parassesstemplateid_eq);
        }
    }
	private String n_parassesstemplatename_eq;//[考核模板名称]
	public void setN_parassesstemplatename_eq(String n_parassesstemplatename_eq) {
        this.n_parassesstemplatename_eq = n_parassesstemplatename_eq;
        if(!ObjectUtils.isEmpty(this.n_parassesstemplatename_eq)){
            this.getSearchCond().eq("parassesstemplatename", n_parassesstemplatename_eq);
        }
    }
	private String n_parassesstemplatename_like;//[考核模板名称]
	public void setN_parassesstemplatename_like(String n_parassesstemplatename_like) {
        this.n_parassesstemplatename_like = n_parassesstemplatename_like;
        if(!ObjectUtils.isEmpty(this.n_parassesstemplatename_like)){
            this.getSearchCond().like("parassesstemplatename", n_parassesstemplatename_like);
        }
    }
	private String n_khnr_eq;//[考核内容]
	public void setN_khnr_eq(String n_khnr_eq) {
        this.n_khnr_eq = n_khnr_eq;
        if(!ObjectUtils.isEmpty(this.n_khnr_eq)){
            this.getSearchCond().eq("khnr", n_khnr_eq);
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
                     wrapper.like("parkhzcmxname", query)   
            );
		 }
	}
}




