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
import cn.ibizlab.ehr.core.wf.domain.WFTmpStepActor;
/**
 * 关系型数据实体[WFTmpStepActor] 查询条件对象
 */
@Slf4j
@Data
public class WFTmpStepActorSearchContext extends QueryWrapperContext<WFTmpStepActor> {

	private String n_wftmpstepactorname_like;//[工作流步骤操作者（临时）名称]
	public void setN_wftmpstepactorname_like(String n_wftmpstepactorname_like) {
        this.n_wftmpstepactorname_like = n_wftmpstepactorname_like;
        if(!ObjectUtils.isEmpty(this.n_wftmpstepactorname_like)){
            this.getSelectCond().like("wftmpstepactorname", n_wftmpstepactorname_like);
        }
    }
	private String n_wfactorname_eq;//[工作流临时步骤操作者_工作流操作者]
	public void setN_wfactorname_eq(String n_wfactorname_eq) {
        this.n_wfactorname_eq = n_wfactorname_eq;
        if(!ObjectUtils.isEmpty(this.n_wfactorname_eq)){
            this.getSelectCond().eq("wfactorname", n_wfactorname_eq);
        }
    }
	private String n_wfactorname_like;//[工作流临时步骤操作者_工作流操作者]
	public void setN_wfactorname_like(String n_wfactorname_like) {
        this.n_wfactorname_like = n_wfactorname_like;
        if(!ObjectUtils.isEmpty(this.n_wfactorname_like)){
            this.getSelectCond().like("wfactorname", n_wfactorname_like);
        }
    }
	private String n_prevwfstepname_eq;//[工作流临时步骤操作者（上一步骤）]
	public void setN_prevwfstepname_eq(String n_prevwfstepname_eq) {
        this.n_prevwfstepname_eq = n_prevwfstepname_eq;
        if(!ObjectUtils.isEmpty(this.n_prevwfstepname_eq)){
            this.getSelectCond().eq("prevwfstepname", n_prevwfstepname_eq);
        }
    }
	private String n_prevwfstepname_like;//[工作流临时步骤操作者（上一步骤）]
	public void setN_prevwfstepname_like(String n_prevwfstepname_like) {
        this.n_prevwfstepname_like = n_prevwfstepname_like;
        if(!ObjectUtils.isEmpty(this.n_prevwfstepname_like)){
            this.getSelectCond().like("prevwfstepname", n_prevwfstepname_like);
        }
    }
	private String n_prevwfstepid_eq;//[工作流临时步骤操作者（上一步骤）]
	public void setN_prevwfstepid_eq(String n_prevwfstepid_eq) {
        this.n_prevwfstepid_eq = n_prevwfstepid_eq;
        if(!ObjectUtils.isEmpty(this.n_prevwfstepid_eq)){
            this.getSelectCond().eq("prevwfstepid", n_prevwfstepid_eq);
        }
    }
	private String n_wfactorid_eq;//[工作流临时步骤操作者_工作流操作者]
	public void setN_wfactorid_eq(String n_wfactorid_eq) {
        this.n_wfactorid_eq = n_wfactorid_eq;
        if(!ObjectUtils.isEmpty(this.n_wfactorid_eq)){
            this.getSelectCond().eq("wfactorid", n_wfactorid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wftmpstepactorname",query);
		 }
	}
}




