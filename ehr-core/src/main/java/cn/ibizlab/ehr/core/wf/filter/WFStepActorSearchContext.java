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
import cn.ibizlab.ehr.core.wf.domain.WFStepActor;
/**
 * 关系型数据实体[WFStepActor] 查询条件对象
 */
@Slf4j
@Data
public class WFStepActorSearchContext extends QueryWrapperContext<WFStepActor> {

	private String n_wfstepactorname_like;//[工作流步骤操作者名称]
	public void setN_wfstepactorname_like(String n_wfstepactorname_like) {
        this.n_wfstepactorname_like = n_wfstepactorname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepactorname_like)){
            this.getSelectCond().like("wfstepactorname", n_wfstepactorname_like);
        }
    }
	private String n_wfstepname_eq;//[流程步骤]
	public void setN_wfstepname_eq(String n_wfstepname_eq) {
        this.n_wfstepname_eq = n_wfstepname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_eq)){
            this.getSelectCond().eq("wfstepname", n_wfstepname_eq);
        }
    }
	private String n_wfstepname_like;//[流程步骤]
	public void setN_wfstepname_like(String n_wfstepname_like) {
        this.n_wfstepname_like = n_wfstepname_like;
        if(!ObjectUtils.isEmpty(this.n_wfstepname_like)){
            this.getSelectCond().like("wfstepname", n_wfstepname_like);
        }
    }
	private String n_originalwfusername_eq;//[源流程用户]
	public void setN_originalwfusername_eq(String n_originalwfusername_eq) {
        this.n_originalwfusername_eq = n_originalwfusername_eq;
        if(!ObjectUtils.isEmpty(this.n_originalwfusername_eq)){
            this.getSelectCond().eq("originalwfusername", n_originalwfusername_eq);
        }
    }
	private String n_originalwfusername_like;//[源流程用户]
	public void setN_originalwfusername_like(String n_originalwfusername_like) {
        this.n_originalwfusername_like = n_originalwfusername_like;
        if(!ObjectUtils.isEmpty(this.n_originalwfusername_like)){
            this.getSelectCond().like("originalwfusername", n_originalwfusername_like);
        }
    }
	private String n_originalwfuserid_eq;//[源流程用户]
	public void setN_originalwfuserid_eq(String n_originalwfuserid_eq) {
        this.n_originalwfuserid_eq = n_originalwfuserid_eq;
        if(!ObjectUtils.isEmpty(this.n_originalwfuserid_eq)){
            this.getSelectCond().eq("originalwfuserid", n_originalwfuserid_eq);
        }
    }
	private String n_wfstepid_eq;//[步骤角色_步骤]
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
			this.getSelectCond().or().like("wfstepactorname",query);
		 }
	}
}




