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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;
/**
 * 关系型数据实体[PcmTxfpsq] 查询条件对象
 */
@Slf4j
@Data
public class PcmTxfpsqSearchContext extends QueryWrapperContext<PcmTxfpsq> {

	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_pcmtxfpsqname_like;//[标题]
	public void setN_pcmtxfpsqname_like(String n_pcmtxfpsqname_like) {
        this.n_pcmtxfpsqname_like = n_pcmtxfpsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmtxfpsqname_like)){
            this.getSearchCond().like("pcmtxfpsqname", n_pcmtxfpsqname_like);
        }
    }
	private String n_zz_like;//[退休前组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
        }
    }
	private String n_pimpersonname_eq;//[退休员工]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[退休员工]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_yzw_eq;//[退休前职务]
	public void setN_yzw_eq(String n_yzw_eq) {
        this.n_yzw_eq = n_yzw_eq;
        if(!ObjectUtils.isEmpty(this.n_yzw_eq)){
            this.getSearchCond().eq("yzw", n_yzw_eq);
        }
    }
	private String n_yzw_like;//[退休前职务]
	public void setN_yzw_like(String n_yzw_like) {
        this.n_yzw_like = n_yzw_like;
        if(!ObjectUtils.isEmpty(this.n_yzw_like)){
            this.getSearchCond().like("yzw", n_yzw_like);
        }
    }
	private String n_ygbh_like;//[原员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_ygw_eq;//[退休前岗位]
	public void setN_ygw_eq(String n_ygw_eq) {
        this.n_ygw_eq = n_ygw_eq;
        if(!ObjectUtils.isEmpty(this.n_ygw_eq)){
            this.getSearchCond().eq("ygw", n_ygw_eq);
        }
    }
	private String n_bm_like;//[退休前部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSearchCond().like("bm", n_bm_like);
        }
    }
	private String n_pimpersonid_eq;//[退休员工ID]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pcmprofileid_eq;//[应聘者ID]
	public void setN_pcmprofileid_eq(String n_pcmprofileid_eq) {
        this.n_pcmprofileid_eq = n_pcmprofileid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmprofileid_eq)){
            this.getSearchCond().eq("pcmprofileid", n_pcmprofileid_eq);
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
                     wrapper.like("pcmtxfpsqname", query)   
                        .or().like("pimpersonname", query)            
                        .or().like("ygbh", query)            
            );
		 }
	}
}




