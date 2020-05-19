package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.DataAuditDetail;
/**
 * 关系型数据实体[DataAuditDetail] 查询条件对象
 */
@Slf4j
@Data
public class DataAuditDetailSearchContext extends QueryWrapperContext<DataAuditDetail> {

	private String n_dataauditdetailname_like;//[属性]
	public void setN_dataauditdetailname_like(String n_dataauditdetailname_like) {
        this.n_dataauditdetailname_like = n_dataauditdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_dataauditdetailname_like)){
            this.getSelectCond().like("dataauditdetailname", n_dataauditdetailname_like);
        }
    }
	private String n_dataauditname_eq;//[数据审计]
	public void setN_dataauditname_eq(String n_dataauditname_eq) {
        this.n_dataauditname_eq = n_dataauditname_eq;
        if(!ObjectUtils.isEmpty(this.n_dataauditname_eq)){
            this.getSelectCond().eq("dataauditname", n_dataauditname_eq);
        }
    }
	private String n_dataauditname_like;//[数据审计]
	public void setN_dataauditname_like(String n_dataauditname_like) {
        this.n_dataauditname_like = n_dataauditname_like;
        if(!ObjectUtils.isEmpty(this.n_dataauditname_like)){
            this.getSelectCond().like("dataauditname", n_dataauditname_like);
        }
    }
	private String n_dataauditid_eq;//[数据审计]
	public void setN_dataauditid_eq(String n_dataauditid_eq) {
        this.n_dataauditid_eq = n_dataauditid_eq;
        if(!ObjectUtils.isEmpty(this.n_dataauditid_eq)){
            this.getSelectCond().eq("dataauditid", n_dataauditid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("dataauditdetailname",query);
		 }
	}
}




