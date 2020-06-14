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
import cn.ibizlab.ehr.core.pcm.domain.PcmSgqMgr;
/**
 * 关系型数据实体[PcmSgqMgr] 查询条件对象
 */
@Slf4j
@Data
public class PcmSgqMgrSearchContext extends QueryWrapperContext<PcmSgqMgr> {

	private String n_sgzt_eq;//[试岗状态]
	public void setN_sgzt_eq(String n_sgzt_eq) {
        this.n_sgzt_eq = n_sgzt_eq;
        if(!ObjectUtils.isEmpty(this.n_sgzt_eq)){
            this.getSearchCond().eq("sgzt", n_sgzt_eq);
        }
    }
	private String n_pcmsgqmgrname_like;//[试岗期管理名称]
	public void setN_pcmsgqmgrname_like(String n_pcmsgqmgrname_like) {
        this.n_pcmsgqmgrname_like = n_pcmsgqmgrname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmsgqmgrname_like)){
            this.getSearchCond().like("pcmsgqmgrname", n_pcmsgqmgrname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pcmbdsqdmxid_eq;//[申请单明细标识]
	public void setN_pcmbdsqdmxid_eq(String n_pcmbdsqdmxid_eq) {
        this.n_pcmbdsqdmxid_eq = n_pcmbdsqdmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmbdsqdmxid_eq)){
            this.getSearchCond().eq("pcmbdsqdmxid", n_pcmbdsqdmxid_eq);
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
                     wrapper.like("pcmsgqmgrname", query)   
            );
		 }
	}
}




