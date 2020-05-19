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
import cn.ibizlab.ehr.core.wf.domain.WFUIWizard;
/**
 * 关系型数据实体[WFUIWizard] 查询条件对象
 */
@Slf4j
@Data
public class WFUIWizardSearchContext extends QueryWrapperContext<WFUIWizard> {

	private String n_wfuiwizardname_like;//[工作流操作界面名称]
	public void setN_wfuiwizardname_like(String n_wfuiwizardname_like) {
        this.n_wfuiwizardname_like = n_wfuiwizardname_like;
        if(!ObjectUtils.isEmpty(this.n_wfuiwizardname_like)){
            this.getSelectCond().like("wfuiwizardname", n_wfuiwizardname_like);
        }
    }
	private String n_wfstepvalue_eq;//[调整步骤值]
	public void setN_wfstepvalue_eq(String n_wfstepvalue_eq) {
        this.n_wfstepvalue_eq = n_wfstepvalue_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepvalue_eq)){
            this.getSelectCond().eq("wfstepvalue", n_wfstepvalue_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfuiwizardname",query);
		 }
	}
}




