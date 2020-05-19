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
import cn.ibizlab.ehr.core.common.domain.DataAudit;
/**
 * 关系型数据实体[DataAudit] 查询条件对象
 */
@Slf4j
@Data
public class DataAuditSearchContext extends QueryWrapperContext<DataAudit> {

	private String n_audittype_eq;//[行为类型]
	public void setN_audittype_eq(String n_audittype_eq) {
        this.n_audittype_eq = n_audittype_eq;
        if(!ObjectUtils.isEmpty(this.n_audittype_eq)){
            this.getSelectCond().eq("audittype", n_audittype_eq);
        }
    }
	private String n_dataauditname_like;//[审计条目]
	public void setN_dataauditname_like(String n_dataauditname_like) {
        this.n_dataauditname_like = n_dataauditname_like;
        if(!ObjectUtils.isEmpty(this.n_dataauditname_like)){
            this.getSelectCond().like("dataauditname", n_dataauditname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("dataauditname",query);
		 }
	}
}




