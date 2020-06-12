package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAddress;
/**
 * 关系型数据实体[TrmTrainAddress] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainAddressSearchContext extends QueryWrapperContext<TrmTrainAddress> {

	private String n_pxlx_eq;//[培训类型]
	public void setN_pxlx_eq(String n_pxlx_eq) {
        this.n_pxlx_eq = n_pxlx_eq;
        if(!ObjectUtils.isEmpty(this.n_pxlx_eq)){
            this.getSearchCond().eq("pxlx", n_pxlx_eq);
        }
    }
	private String n_hjzk_eq;//[环境状况]
	public void setN_hjzk_eq(String n_hjzk_eq) {
        this.n_hjzk_eq = n_hjzk_eq;
        if(!ObjectUtils.isEmpty(this.n_hjzk_eq)){
            this.getSearchCond().eq("hjzk", n_hjzk_eq);
        }
    }
	private String n_sf_eq;//[省份]
	public void setN_sf_eq(String n_sf_eq) {
        this.n_sf_eq = n_sf_eq;
        if(!ObjectUtils.isEmpty(this.n_sf_eq)){
            this.getSearchCond().eq("sf", n_sf_eq);
        }
    }
	private String n_xz_eq;//[性质]
	public void setN_xz_eq(String n_xz_eq) {
        this.n_xz_eq = n_xz_eq;
        if(!ObjectUtils.isEmpty(this.n_xz_eq)){
            this.getSearchCond().eq("xz", n_xz_eq);
        }
    }
	private String n_trmtrainaddressname_like;//[场地名称]
	public void setN_trmtrainaddressname_like(String n_trmtrainaddressname_like) {
        this.n_trmtrainaddressname_like = n_trmtrainaddressname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressname_like)){
            this.getSearchCond().like("trmtrainaddressname", n_trmtrainaddressname_like);
        }
    }
	private String n_s_eq;//[市]
	public void setN_s_eq(String n_s_eq) {
        this.n_s_eq = n_s_eq;
        if(!ObjectUtils.isEmpty(this.n_s_eq)){
            this.getSearchCond().eq("s", n_s_eq);
        }
    }
	private String n_ormorgname_eq;//[所属单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[所属单位]
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
                     wrapper.like("trmtrainaddressname", query)   
            );
		 }
	}
}




