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
import cn.ibizlab.ehr.core.wf.domain.WFIAAction;
/**
 * 关系型数据实体[WFIAAction] 查询条件对象
 */
@Slf4j
@Data
public class WFIAActionSearchContext extends QueryWrapperContext<WFIAAction> {

	private String n_wfiaactionname_like;//[工作流交互操作名称]
	public void setN_wfiaactionname_like(String n_wfiaactionname_like) {
        this.n_wfiaactionname_like = n_wfiaactionname_like;
        if(!ObjectUtils.isEmpty(this.n_wfiaactionname_like)){
            this.getSelectCond().like("wfiaactionname", n_wfiaactionname_like);
        }
    }
	private String n_wfstepname_eq;//[WFSTEPNAME]
	public void setN_wfstepname_eq(String n_wfstepname_eq) {
        this.n_wfstepname_eq = n_wfstepname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_eq)){
            this.getSelectCond().eq("wfstepname", n_wfstepname_eq);
        }
    }
	private String n_wfstepname_like;//[WFSTEPNAME]
	public void setN_wfstepname_like(String n_wfstepname_like) {
        this.n_wfstepname_like = n_wfstepname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_like)){
            this.getSelectCond().like("wfstepname", n_wfstepname_like);
        }
    }
	private String n_wfstepid_eq;//[互动操作_相关步骤]
	public void setN_wfstepid_eq(String n_wfstepid_eq) {
        this.n_wfstepid_eq = n_wfstepid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepid_eq)){
            this.getSelectCond().eq("wfstepid", n_wfstepid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfiaactionname",query);
		 }
	}
}




