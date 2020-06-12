package cn.ibizlab.ehr.core.pcm.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileApproval;
/**
 * 关系型数据实体[PcmProfileApproval] 查询条件对象
 */
@Slf4j
@Data
public class PcmProfileApprovalSearchContext extends QueryWrapperContext<PcmProfileApproval> {

	private String n_fastate_eq;//[审批阶段（非A类员工）]
	public void setN_fastate_eq(String n_fastate_eq) {
        this.n_fastate_eq = n_fastate_eq;
        if(!ObjectUtils.isEmpty(this.n_fastate_eq)){
            this.getSearchCond().eq("fastate", n_fastate_eq);
        }
    }
	private String n_passorreject_eq;//[通过/拒绝]
	public void setN_passorreject_eq(String n_passorreject_eq) {
        this.n_passorreject_eq = n_passorreject_eq;
        if(!ObjectUtils.isEmpty(this.n_passorreject_eq)){
            this.getSearchCond().eq("passorreject", n_passorreject_eq);
        }
    }
	private String n_approvalstage_eq;//[审批阶段]
	public void setN_approvalstage_eq(String n_approvalstage_eq) {
        this.n_approvalstage_eq = n_approvalstage_eq;
        if(!ObjectUtils.isEmpty(this.n_approvalstage_eq)){
            this.getSearchCond().eq("approvalstage", n_approvalstage_eq);
        }
    }
	private String n_pcmprofileapprovalname_like;//[应聘者审批表名称]
	public void setN_pcmprofileapprovalname_like(String n_pcmprofileapprovalname_like) {
        this.n_pcmprofileapprovalname_like = n_pcmprofileapprovalname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileapprovalname_like)){
            this.getSearchCond().like("pcmprofileapprovalname", n_pcmprofileapprovalname_like);
        }
    }
	private String n_pimbyzzjlmxname_eq;//[非A类员工编号变更]
	public void setN_pimbyzzjlmxname_eq(String n_pimbyzzjlmxname_eq) {
        this.n_pimbyzzjlmxname_eq = n_pimbyzzjlmxname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyzzjlmxname_eq)){
            this.getSearchCond().eq("pimbyzzjlmxname", n_pimbyzzjlmxname_eq);
        }
    }
	private String n_pimbyzzjlmxname_like;//[非A类员工编号变更]
	public void setN_pimbyzzjlmxname_like(String n_pimbyzzjlmxname_like) {
        this.n_pimbyzzjlmxname_like = n_pimbyzzjlmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pimbyzzjlmxname_like)){
            this.getSearchCond().like("pimbyzzjlmxname", n_pimbyzzjlmxname_like);
        }
    }
	private String n_pcmprofilename_eq;//[姓名]
	public void setN_pcmprofilename_eq(String n_pcmprofilename_eq) {
        this.n_pcmprofilename_eq = n_pcmprofilename_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_eq)){
            this.getSearchCond().eq("pcmprofilename", n_pcmprofilename_eq);
        }
    }
	private String n_pcmprofilename_like;//[姓名]
	public void setN_pcmprofilename_like(String n_pcmprofilename_like) {
        this.n_pcmprofilename_like = n_pcmprofilename_like;
        if(!ObjectUtils.isEmpty(this.n_pcmprofilename_like)){
            this.getSearchCond().like("pcmprofilename", n_pcmprofilename_like);
        }
    }
	private String n_pcmprofileid_eq;//[应聘者ID]
	public void setN_pcmprofileid_eq(String n_pcmprofileid_eq) {
        this.n_pcmprofileid_eq = n_pcmprofileid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileid_eq)){
            this.getSearchCond().eq("pcmprofileid", n_pcmprofileid_eq);
        }
    }
	private String n_pimbyzzjlmxid_eq;//[非A类员工编号变更ID]
	public void setN_pimbyzzjlmxid_eq(String n_pimbyzzjlmxid_eq) {
        this.n_pimbyzzjlmxid_eq = n_pimbyzzjlmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimbyzzjlmxid_eq)){
            this.getSearchCond().eq("pimbyzzjlmxid", n_pimbyzzjlmxid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("pcmprofileapprovalname", query)   
            );
		 }
	}
}




