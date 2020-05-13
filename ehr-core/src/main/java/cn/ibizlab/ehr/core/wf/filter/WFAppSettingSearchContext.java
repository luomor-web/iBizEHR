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
import cn.ibizlab.ehr.core.wf.domain.WFAppSetting;
/**
 * 关系型数据实体[WFAppSetting] 查询条件对象
 */
@Slf4j
@Data
public class WFAppSettingSearchContext extends QueryWrapperContext<WFAppSetting> {

	private String n_wfappsettingname_like;//[系统工作流设定]
	public void setN_wfappsettingname_like(String n_wfappsettingname_like) {
        this.n_wfappsettingname_like = n_wfappsettingname_like;
        if(!ObjectUtils.isEmpty(this.n_wfappsettingname_like)){
            this.getSelectCond().like("wfappsettingname", n_wfappsettingname_like);
        }
    }
	private String n_remindmsgtemplname_eq;//[催办消息模板]
	public void setN_remindmsgtemplname_eq(String n_remindmsgtemplname_eq) {
        this.n_remindmsgtemplname_eq = n_remindmsgtemplname_eq;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtemplname_eq)){
            this.getSelectCond().eq("remindmsgtemplname", n_remindmsgtemplname_eq);
        }
    }
	private String n_remindmsgtemplname_like;//[催办消息模板]
	public void setN_remindmsgtemplname_like(String n_remindmsgtemplname_like) {
        this.n_remindmsgtemplname_like = n_remindmsgtemplname_like;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtemplname_like)){
            this.getSelectCond().like("remindmsgtemplname", n_remindmsgtemplname_like);
        }
    }
	private String n_remindmsgtempid_eq;//[催办消息模板]
	public void setN_remindmsgtempid_eq(String n_remindmsgtempid_eq) {
        this.n_remindmsgtempid_eq = n_remindmsgtempid_eq;
        if(!ObjectUtils.isEmpty(this.n_remindmsgtempid_eq)){
            this.getSelectCond().eq("remindmsgtempid", n_remindmsgtempid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfappsettingname",query);
		 }
	}
}




