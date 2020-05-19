package cn.ibizlab.ehr.core.wf.filter;

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
import cn.ibizlab.ehr.core.wf.domain.WFAction;
/**
 * 关系型数据实体[WFAction] 查询条件对象
 */
@Slf4j
@Data
public class WFActionSearchContext extends QueryWrapperContext<WFAction> {

	private String n_wfactionname_like;//[工作流用户操作名称]
	public void setN_wfactionname_like(String n_wfactionname_like) {
        this.n_wfactionname_like = n_wfactionname_like;
        if(!ObjectUtils.isEmpty(this.n_wfactionname_like)){
            this.getSelectCond().like("wfactionname", n_wfactionname_like);
        }
    }
	private String n_wfworkflowname_eq;//[工作流配置]
	public void setN_wfworkflowname_eq(String n_wfworkflowname_eq) {
        this.n_wfworkflowname_eq = n_wfworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_eq)){
            this.getSelectCond().eq("wfworkflowname", n_wfworkflowname_eq);
        }
    }
	private String n_wfworkflowname_like;//[工作流配置]
	public void setN_wfworkflowname_like(String n_wfworkflowname_like) {
        this.n_wfworkflowname_like = n_wfworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_like)){
            this.getSelectCond().like("wfworkflowname", n_wfworkflowname_like);
        }
    }
	private String n_wfworkflowid_eq;//[工作流配置]
	public void setN_wfworkflowid_eq(String n_wfworkflowid_eq) {
        this.n_wfworkflowid_eq = n_wfworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowid_eq)){
            this.getSelectCond().eq("wfworkflowid", n_wfworkflowid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfactionname",query);
		 }
	}
}




