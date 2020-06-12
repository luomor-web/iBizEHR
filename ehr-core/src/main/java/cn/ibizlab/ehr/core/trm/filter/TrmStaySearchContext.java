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
import cn.ibizlab.ehr.core.trm.domain.TrmStay;
/**
 * 关系型数据实体[TrmStay] 查询条件对象
 */
@Slf4j
@Data
public class TrmStaySearchContext extends QueryWrapperContext<TrmStay> {

	private String n_trmstayname_like;//[名称]
	public void setN_trmstayname_like(String n_trmstayname_like) {
        this.n_trmstayname_like = n_trmstayname_like;
        if(!ObjectUtils.isEmpty(this.n_trmstayname_like)){
            this.getSearchCond().like("trmstayname", n_trmstayname_like);
        }
    }
	private String n_fjlx_eq;//[房间类型]
	public void setN_fjlx_eq(String n_fjlx_eq) {
        this.n_fjlx_eq = n_fjlx_eq;
        if(!ObjectUtils.isEmpty(this.n_fjlx_eq)){
            this.getSearchCond().eq("fjlx", n_fjlx_eq);
        }
    }
	private String n_trmtrainaddressname_eq;//[培训地点]
	public void setN_trmtrainaddressname_eq(String n_trmtrainaddressname_eq) {
        this.n_trmtrainaddressname_eq = n_trmtrainaddressname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressname_eq)){
            this.getSearchCond().eq("trmtrainaddressname", n_trmtrainaddressname_eq);
        }
    }
	private String n_trmtrainaddressname_like;//[培训地点]
	public void setN_trmtrainaddressname_like(String n_trmtrainaddressname_like) {
        this.n_trmtrainaddressname_like = n_trmtrainaddressname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressname_like)){
            this.getSearchCond().like("trmtrainaddressname", n_trmtrainaddressname_like);
        }
    }
	private String n_trmtrainaddressid_eq;//[培训地点标识]
	public void setN_trmtrainaddressid_eq(String n_trmtrainaddressid_eq) {
        this.n_trmtrainaddressid_eq = n_trmtrainaddressid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressid_eq)){
            this.getSearchCond().eq("trmtrainaddressid", n_trmtrainaddressid_eq);
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
                     wrapper.like("trmstayname", query)   
            );
		 }
	}
}




