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
import cn.ibizlab.ehr.core.wf.domain.WFVersion;
/**
 * 关系型数据实体[WFVersion] 查询条件对象
 */
@Slf4j
@Data
public class WFVersionSearchContext extends QueryWrapperContext<WFVersion> {

	private String n_wfwfversionname_like;//[工作流配置版本名称]
	public void setN_wfwfversionname_like(String n_wfwfversionname_like) {
        this.n_wfwfversionname_like = n_wfwfversionname_like;
        if(!ObjectUtils.isEmpty(this.n_wfwfversionname_like)){
            this.getSelectCond().like("wfwfversionname", n_wfwfversionname_like);
        }
    }
	private String n_wfwfname_eq;//[工作流配置]
	public void setN_wfwfname_eq(String n_wfwfname_eq) {
        this.n_wfwfname_eq = n_wfwfname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfwfname_eq)){
            this.getSelectCond().eq("wfwfname", n_wfwfname_eq);
        }
    }
	private String n_wfwfname_like;//[工作流配置]
	public void setN_wfwfname_like(String n_wfwfname_like) {
        this.n_wfwfname_like = n_wfwfname_like;
        if(!ObjectUtils.isEmpty(this.n_wfwfname_like)){
            this.getSelectCond().like("wfwfname", n_wfwfname_like);
        }
    }
	private String n_wfwfid_eq;//[工作流配置]
	public void setN_wfwfid_eq(String n_wfwfid_eq) {
        this.n_wfwfid_eq = n_wfwfid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfwfid_eq)){
            this.getSelectCond().eq("wfwfid", n_wfwfid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfwfversionname",query);
		 }
	}
}




