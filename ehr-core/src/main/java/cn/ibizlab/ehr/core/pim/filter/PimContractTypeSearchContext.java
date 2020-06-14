package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimContractType;
/**
 * 关系型数据实体[PimContractType] 查询条件对象
 */
@Slf4j
@Data
public class PimContractTypeSearchContext extends QueryWrapperContext<PimContractType> {

	private String n_lx_eq;//[类型]
	public void setN_lx_eq(String n_lx_eq) {
        this.n_lx_eq = n_lx_eq;
        if(!ObjectUtils.isEmpty(this.n_lx_eq)){
            this.getSearchCond().eq("lx", n_lx_eq);
        }
    }
	private String n_pimcontracttypeid_like;//[合同/协议类型管理标识]
	public void setN_pimcontracttypeid_like(String n_pimcontracttypeid_like) {
        this.n_pimcontracttypeid_like = n_pimcontracttypeid_like;
        if(!ObjectUtils.isEmpty(this.n_pimcontracttypeid_like)){
            this.getSearchCond().like("pimcontracttypeid", n_pimcontracttypeid_like);
        }
    }
	private String n_pimcontracttypename_like;//[合同类别名称]
	public void setN_pimcontracttypename_like(String n_pimcontracttypename_like) {
        this.n_pimcontracttypename_like = n_pimcontracttypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimcontracttypename_like)){
            this.getSearchCond().like("pimcontracttypename", n_pimcontracttypename_like);
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
                     wrapper.like("pimcontracttypename", query)   
            );
		 }
	}
}




