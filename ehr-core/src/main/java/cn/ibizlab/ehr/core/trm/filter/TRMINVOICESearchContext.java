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
import cn.ibizlab.ehr.core.trm.domain.TRMINVOICE;
/**
 * 关系型数据实体[TRMINVOICE] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TRMINVOICESearchContext extends QueryWrapperContext<TRMINVOICE> {

	private String n_kplx_eq;//[开票类型]
	public void setN_kplx_eq(String n_kplx_eq) {
        this.n_kplx_eq = n_kplx_eq;
        if(!ObjectUtils.isEmpty(this.n_kplx_eq)){
            this.getSelectCond().eq("kplx", n_kplx_eq);
        }
    }
	private String n_trminvoicename_like;//[开票名称]
	public void setN_trminvoicename_like(String n_trminvoicename_like) {
        this.n_trminvoicename_like = n_trminvoicename_like;
        if(!ObjectUtils.isEmpty(this.n_trminvoicename_like)){
            this.getSelectCond().like("trminvoicename", n_trminvoicename_like);
        }
    }
	private String n_trmtrainagencyname_eq;//[培训机构名称]
	public void setN_trmtrainagencyname_eq(String n_trmtrainagencyname_eq) {
        this.n_trmtrainagencyname_eq = n_trmtrainagencyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_eq)){
            this.getSelectCond().eq("trmtrainagencyname", n_trmtrainagencyname_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[培训机构名称]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSelectCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSelectCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("trminvoicename",query);
		 }
	}
}




