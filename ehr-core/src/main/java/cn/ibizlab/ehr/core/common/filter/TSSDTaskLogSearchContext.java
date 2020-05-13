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
import cn.ibizlab.ehr.core.common.domain.TSSDTaskLog;
/**
 * 关系型数据实体[TSSDTaskLog] 查询条件对象
 */
@Slf4j
@Data
public class TSSDTaskLogSearchContext extends QueryWrapperContext<TSSDTaskLog> {

	private String n_tssdtasklogname_like;//[任务调度日志名称]
	public void setN_tssdtasklogname_like(String n_tssdtasklogname_like) {
        this.n_tssdtasklogname_like = n_tssdtasklogname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdtasklogname_like)){
            this.getSelectCond().like("tssdtasklogname", n_tssdtasklogname_like);
        }
    }
	private String n_tssdtaskname_eq;//[调度任务]
	public void setN_tssdtaskname_eq(String n_tssdtaskname_eq) {
        this.n_tssdtaskname_eq = n_tssdtaskname_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdtaskname_eq)){
            this.getSelectCond().eq("tssdtaskname", n_tssdtaskname_eq);
        }
    }
	private String n_tssdtaskname_like;//[调度任务]
	public void setN_tssdtaskname_like(String n_tssdtaskname_like) {
        this.n_tssdtaskname_like = n_tssdtaskname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdtaskname_like)){
            this.getSelectCond().like("tssdtaskname", n_tssdtaskname_like);
        }
    }
	private String n_tssdtaskid_eq;//[调度任务]
	public void setN_tssdtaskid_eq(String n_tssdtaskid_eq) {
        this.n_tssdtaskid_eq = n_tssdtaskid_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdtaskid_eq)){
            this.getSelectCond().eq("tssdtaskid", n_tssdtaskid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdtasklogname",query);
		 }
	}
}




