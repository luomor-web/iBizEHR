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
import cn.ibizlab.ehr.core.common.domain.TSSDTask;
/**
 * 关系型数据实体[TSSDTask] 查询条件对象
 */
@Slf4j
@Data
public class TSSDTaskSearchContext extends QueryWrapperContext<TSSDTask> {

	private String n_tssdtaskname_like;//[调度任务项名称]
	public void setN_tssdtaskname_like(String n_tssdtaskname_like) {
        this.n_tssdtaskname_like = n_tssdtaskname_like;
        if(!ObjectUtils.isEmpty(this.n_tssdtaskname_like)){
            this.getSelectCond().like("tssdtaskname", n_tssdtaskname_like);
        }
    }
	private String n_tssdenginename_eq;//[任务调度引擎]
	public void setN_tssdenginename_eq(String n_tssdenginename_eq) {
        this.n_tssdenginename_eq = n_tssdenginename_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdenginename_eq)){
            this.getSelectCond().eq("tssdenginename", n_tssdenginename_eq);
        }
    }
	private String n_tssdenginename_like;//[任务调度引擎]
	public void setN_tssdenginename_like(String n_tssdenginename_like) {
        this.n_tssdenginename_like = n_tssdenginename_like;
        if(!ObjectUtils.isEmpty(this.n_tssdenginename_like)){
            this.getSelectCond().like("tssdenginename", n_tssdenginename_like);
        }
    }
	private String n_tssdengineid_eq;//[任务调度引擎]
	public void setN_tssdengineid_eq(String n_tssdengineid_eq) {
        this.n_tssdengineid_eq = n_tssdengineid_eq;
        if(!ObjectUtils.isEmpty(this.n_tssdengineid_eq)){
            this.getSelectCond().eq("tssdengineid", n_tssdengineid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("tssdtaskname",query);
		 }
	}
}




