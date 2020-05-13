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
import cn.ibizlab.ehr.core.common.domain.DataSyncIn;
/**
 * 关系型数据实体[DataSyncIn] 查询条件对象
 */
@Slf4j
@Data
public class DataSyncInSearchContext extends QueryWrapperContext<DataSyncIn> {

	private String n_syncagent_eq;//[数据输入代理]
	public void setN_syncagent_eq(String n_syncagent_eq) {
        this.n_syncagent_eq = n_syncagent_eq;
        if(!ObjectUtils.isEmpty(this.n_syncagent_eq)){
            this.getSelectCond().eq("syncagent", n_syncagent_eq);
        }
    }
	private Integer n_eventtype_eq;//[事件类型]
	public void setN_eventtype_eq(Integer n_eventtype_eq) {
        this.n_eventtype_eq = n_eventtype_eq;
        if(!ObjectUtils.isEmpty(this.n_eventtype_eq)){
            this.getSelectCond().eq("eventtype", n_eventtype_eq);
        }
    }
	private String n_datasyncinname_like;//[数据同步接收队列名称]
	public void setN_datasyncinname_like(String n_datasyncinname_like) {
        this.n_datasyncinname_like = n_datasyncinname_like;
        if(!ObjectUtils.isEmpty(this.n_datasyncinname_like)){
            this.getSelectCond().like("datasyncinname", n_datasyncinname_like);
        }
    }
	private String n_dename_eq;//[数据实体]
	public void setN_dename_eq(String n_dename_eq) {
        this.n_dename_eq = n_dename_eq;
        if(!ObjectUtils.isEmpty(this.n_dename_eq)){
            this.getSelectCond().eq("dename", n_dename_eq);
        }
    }
	private String n_dename_like;//[数据实体]
	public void setN_dename_like(String n_dename_like) {
        this.n_dename_like = n_dename_like;
        if(!ObjectUtils.isEmpty(this.n_dename_like)){
            this.getSelectCond().like("dename", n_dename_like);
        }
    }
	private String n_deid_eq;//[数据实体]
	public void setN_deid_eq(String n_deid_eq) {
        this.n_deid_eq = n_deid_eq;
        if(!ObjectUtils.isEmpty(this.n_deid_eq)){
            this.getSelectCond().eq("deid", n_deid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("datasyncinname",query);
		 }
	}
}



