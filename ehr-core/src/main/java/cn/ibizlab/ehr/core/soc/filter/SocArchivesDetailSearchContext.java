package cn.ibizlab.ehr.core.soc.filter;

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
import cn.ibizlab.ehr.core.soc.domain.SocArchivesDetail;
/**
 * 关系型数据实体[SocArchivesDetail] 查询条件对象
 */
@Slf4j
@Data
public class SocArchivesDetailSearchContext extends QueryWrapperContext<SocArchivesDetail> {

	private String n_socarchivesdetailname_like;//[社保档案明细名称]
	public void setN_socarchivesdetailname_like(String n_socarchivesdetailname_like) {
        this.n_socarchivesdetailname_like = n_socarchivesdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_socarchivesdetailname_like)){
            this.getSearchCond().like("socarchivesdetailname", n_socarchivesdetailname_like);
        }
    }
	private String n_socarchivesid_eq;//[社保档案标识]
	public void setN_socarchivesid_eq(String n_socarchivesid_eq) {
        this.n_socarchivesid_eq = n_socarchivesid_eq;
        if(!ObjectUtils.isEmpty(this.n_socarchivesid_eq)){
            this.getSearchCond().eq("socarchivesid", n_socarchivesid_eq);
        }
    }
	private String n_socarchivesname_eq;//[社保档案名称]
	public void setN_socarchivesname_eq(String n_socarchivesname_eq) {
        this.n_socarchivesname_eq = n_socarchivesname_eq;
        if(!ObjectUtils.isEmpty(this.n_socarchivesname_eq)){
            this.getSearchCond().eq("socarchivesname", n_socarchivesname_eq);
        }
    }
	private String n_socarchivesname_like;//[社保档案名称]
	public void setN_socarchivesname_like(String n_socarchivesname_like) {
        this.n_socarchivesname_like = n_socarchivesname_like;
        if(!ObjectUtils.isEmpty(this.n_socarchivesname_like)){
            this.getSearchCond().like("socarchivesname", n_socarchivesname_like);
        }
    }
	private String n_socruledetailid_eq;//[社保规则明细标识]
	public void setN_socruledetailid_eq(String n_socruledetailid_eq) {
        this.n_socruledetailid_eq = n_socruledetailid_eq;
        if(!ObjectUtils.isEmpty(this.n_socruledetailid_eq)){
            this.getSearchCond().eq("socruledetailid", n_socruledetailid_eq);
        }
    }
	private String n_socruledetailname_eq;//[社保规则明细名称]
	public void setN_socruledetailname_eq(String n_socruledetailname_eq) {
        this.n_socruledetailname_eq = n_socruledetailname_eq;
        if(!ObjectUtils.isEmpty(this.n_socruledetailname_eq)){
            this.getSearchCond().eq("socruledetailname", n_socruledetailname_eq);
        }
    }
	private String n_socruledetailname_like;//[社保规则明细名称]
	public void setN_socruledetailname_like(String n_socruledetailname_like) {
        this.n_socruledetailname_like = n_socruledetailname_like;
        if(!ObjectUtils.isEmpty(this.n_socruledetailname_like)){
            this.getSearchCond().like("socruledetailname", n_socruledetailname_like);
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
                     wrapper.like("socarchivesdetailname", query)   
            );
		 }
	}
}




