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
import cn.ibizlab.ehr.core.wf.domain.WFReminder;
/**
 * 关系型数据实体[WFReminder] 查询条件对象
 */
@Slf4j
@Data
public class WFReminderSearchContext extends QueryWrapperContext<WFReminder> {

	private String n_wfremindername_like;//[标题]
	public void setN_wfremindername_like(String n_wfremindername_like) {
        this.n_wfremindername_like = n_wfremindername_like;
        if(!ObjectUtils.isEmpty(this.n_wfremindername_like)){
            this.getSelectCond().like("wfremindername", n_wfremindername_like);
        }
    }
	private String n_wfstepactorname_eq;//[工作操作者]
	public void setN_wfstepactorname_eq(String n_wfstepactorname_eq) {
        this.n_wfstepactorname_eq = n_wfstepactorname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorname_eq)){
            this.getSelectCond().eq("wfstepactorname", n_wfstepactorname_eq);
        }
    }
	private String n_wfstepactorname_like;//[工作操作者]
	public void setN_wfstepactorname_like(String n_wfstepactorname_like) {
        this.n_wfstepactorname_like = n_wfstepactorname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorname_like)){
            this.getSelectCond().like("wfstepactorname", n_wfstepactorname_like);
        }
    }
	private String n_wfusername_eq;//[催办者]
	public void setN_wfusername_eq(String n_wfusername_eq) {
        this.n_wfusername_eq = n_wfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_wfusername_eq)){
            this.getSelectCond().eq("wfusername", n_wfusername_eq);
        }
    }
	private String n_wfusername_like;//[催办者]
	public void setN_wfusername_like(String n_wfusername_like) {
        this.n_wfusername_like = n_wfusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfusername_like)){
            this.getSelectCond().like("wfusername", n_wfusername_like);
        }
    }
	private String n_wfstepactorid_eq;//[工作流催办_操作者]
	public void setN_wfstepactorid_eq(String n_wfstepactorid_eq) {
        this.n_wfstepactorid_eq = n_wfstepactorid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorid_eq)){
            this.getSelectCond().eq("wfstepactorid", n_wfstepactorid_eq);
        }
    }
	private String n_wfuserid_eq;//[催办者]
	public void setN_wfuserid_eq(String n_wfuserid_eq) {
        this.n_wfuserid_eq = n_wfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfuserid_eq)){
            this.getSelectCond().eq("wfuserid", n_wfuserid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfremindername",query);
		 }
	}
}




