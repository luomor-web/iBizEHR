package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PIMWorkflowRef;
/**
 * 关系型数据实体[PIMWorkflowRef] 查询条件对象
 */
@Slf4j
@Data
public class PIMWorkflowRefSearchContext extends QueryWrapperContext<PIMWorkflowRef> {

	private String n_pimworkflowrefname_like;//[平台流程配置名称]
	public void setN_pimworkflowrefname_like(String n_pimworkflowrefname_like) {
        this.n_pimworkflowrefname_like = n_pimworkflowrefname_like;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowrefname_like)){
            this.getSelectCond().like("pimworkflowrefname", n_pimworkflowrefname_like);
        }
    }
	private String n_pimworkflowname_eq;//[流程配置]
	public void setN_pimworkflowname_eq(String n_pimworkflowname_eq) {
        this.n_pimworkflowname_eq = n_pimworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowname_eq)){
            this.getSelectCond().eq("pimworkflowname", n_pimworkflowname_eq);
        }
    }
	private String n_pimworkflowname_like;//[流程配置]
	public void setN_pimworkflowname_like(String n_pimworkflowname_like) {
        this.n_pimworkflowname_like = n_pimworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowname_like)){
            this.getSelectCond().like("pimworkflowname", n_pimworkflowname_like);
        }
    }
	private String n_wfworkflowname_eq;//[系统表单]
	public void setN_wfworkflowname_eq(String n_wfworkflowname_eq) {
        this.n_wfworkflowname_eq = n_wfworkflowname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_eq)){
            this.getSelectCond().eq("wfworkflowname", n_wfworkflowname_eq);
        }
    }
	private String n_wfworkflowname_like;//[系统表单]
	public void setN_wfworkflowname_like(String n_wfworkflowname_like) {
        this.n_wfworkflowname_like = n_wfworkflowname_like;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowname_like)){
            this.getSelectCond().like("wfworkflowname", n_wfworkflowname_like);
        }
    }
	private String n_wfworkflowid_eq;//[系统表单]
	public void setN_wfworkflowid_eq(String n_wfworkflowid_eq) {
        this.n_wfworkflowid_eq = n_wfworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfworkflowid_eq)){
            this.getSelectCond().eq("wfworkflowid", n_wfworkflowid_eq);
        }
    }
	private String n_pimworkflowid_eq;//[流程配置]
	public void setN_pimworkflowid_eq(String n_pimworkflowid_eq) {
        this.n_pimworkflowid_eq = n_pimworkflowid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimworkflowid_eq)){
            this.getSelectCond().eq("pimworkflowid", n_pimworkflowid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pimworkflowrefname",query);
		 }
	}
}




