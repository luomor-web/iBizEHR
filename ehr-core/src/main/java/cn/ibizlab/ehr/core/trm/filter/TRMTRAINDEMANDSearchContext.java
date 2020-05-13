package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDEMAND;
/**
 * 关系型数据实体[TRMTRAINDEMAND] 查询条件对象
 */
@Slf4j
@Data
public class TRMTRAINDEMANDSearchContext extends QueryWrapperContext<TRMTRAINDEMAND> {

	private String n_hznd_eq;//[汇总年度]
	public void setN_hznd_eq(String n_hznd_eq) {
        this.n_hznd_eq = n_hznd_eq;
        if(!ObjectUtils.isEmpty(this.n_hznd_eq)){
            this.getSelectCond().eq("hznd", n_hznd_eq);
        }
    }
	private String n_hzjd_eq;//[汇总季度]
	public void setN_hzjd_eq(String n_hzjd_eq) {
        this.n_hzjd_eq = n_hzjd_eq;
        if(!ObjectUtils.isEmpty(this.n_hzjd_eq)){
            this.getSelectCond().eq("hzjd", n_hzjd_eq);
        }
    }
	private String n_trmtraindemandname_like;//[需求汇总]
	public void setN_trmtraindemandname_like(String n_trmtraindemandname_like) {
        this.n_trmtraindemandname_like = n_trmtraindemandname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraindemandname_like)){
            this.getSelectCond().like("trmtraindemandname", n_trmtraindemandname_like);
        }
    }
	private String n_ormorgname_eq;//[汇总单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[汇总单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("trmtraindemandname",query);
		 }
	}
}



