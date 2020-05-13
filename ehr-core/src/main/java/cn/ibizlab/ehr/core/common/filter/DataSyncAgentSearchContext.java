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
import cn.ibizlab.ehr.core.common.domain.DataSyncAgent;
/**
 * 关系型数据实体[DataSyncAgent] 查询条件对象
 */
@Slf4j
@Data
public class DataSyncAgentSearchContext extends QueryWrapperContext<DataSyncAgent> {

	private String n_datasyncagentname_like;//[数据同步代理名称]
	public void setN_datasyncagentname_like(String n_datasyncagentname_like) {
        this.n_datasyncagentname_like = n_datasyncagentname_like;
        if(!ObjectUtils.isEmpty(this.n_datasyncagentname_like)){
            this.getSelectCond().like("datasyncagentname", n_datasyncagentname_like);
        }
    }
	private String n_agenttype_eq;//[代理类型]
	public void setN_agenttype_eq(String n_agenttype_eq) {
        this.n_agenttype_eq = n_agenttype_eq;
        if(!ObjectUtils.isEmpty(this.n_agenttype_eq)){
            this.getSelectCond().eq("agenttype", n_agenttype_eq);
        }
    }
	private String n_syncdir_eq;//[数据同步方向]
	public void setN_syncdir_eq(String n_syncdir_eq) {
        this.n_syncdir_eq = n_syncdir_eq;
        if(!ObjectUtils.isEmpty(this.n_syncdir_eq)){
            this.getSelectCond().eq("syncdir", n_syncdir_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("datasyncagentname",query);
		 }
	}
}




