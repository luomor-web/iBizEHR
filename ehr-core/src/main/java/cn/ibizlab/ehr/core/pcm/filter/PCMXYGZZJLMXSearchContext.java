package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJLMX;
/**
 * 关系型数据实体[PCMXYGZZJLMX] 查询条件对象
 */
@Slf4j
@Data
public class PCMXYGZZJLMXSearchContext extends QueryWrapperContext<PCMXYGZZJLMX> {

	private String n_pcmxygzzjlmxname_like;//[试用期员工转正结果引用明细名称]
	public void setN_pcmxygzzjlmxname_like(String n_pcmxygzzjlmxname_like) {
        this.n_pcmxygzzjlmxname_like = n_pcmxygzzjlmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzjlmxname_like)){
            this.getSelectCond().like("pcmxygzzjlmxname", n_pcmxygzzjlmxname_like);
        }
    }
	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSelectCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_pcmxygzzkhjgjlname_eq;//[员工]
	public void setN_pcmxygzzkhjgjlname_eq(String n_pcmxygzzkhjgjlname_eq) {
        this.n_pcmxygzzkhjgjlname_eq = n_pcmxygzzkhjgjlname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzkhjgjlname_eq)){
            this.getSelectCond().eq("pcmxygzzkhjgjlname", n_pcmxygzzkhjgjlname_eq);
        }
    }
	private String n_pcmxygzzkhjgjlname_like;//[员工]
	public void setN_pcmxygzzkhjgjlname_like(String n_pcmxygzzkhjgjlname_like) {
        this.n_pcmxygzzkhjgjlname_like = n_pcmxygzzkhjgjlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzkhjgjlname_like)){
            this.getSelectCond().like("pcmxygzzkhjgjlname", n_pcmxygzzkhjgjlname_like);
        }
    }
	private String n_duration_eq;//[试用期限（月）]
	public void setN_duration_eq(String n_duration_eq) {
        this.n_duration_eq = n_duration_eq;
        if(!ObjectUtils.isEmpty(this.n_duration_eq)){
            this.getSelectCond().eq("duration", n_duration_eq);
        }
    }
	private String n_pcmxygzzsqname_eq;//[试用期员工转正申请名称]
	public void setN_pcmxygzzsqname_eq(String n_pcmxygzzsqname_eq) {
        this.n_pcmxygzzsqname_eq = n_pcmxygzzsqname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqname_eq)){
            this.getSelectCond().eq("pcmxygzzsqname", n_pcmxygzzsqname_eq);
        }
    }
	private String n_pcmxygzzsqname_like;//[试用期员工转正申请名称]
	public void setN_pcmxygzzsqname_like(String n_pcmxygzzsqname_like) {
        this.n_pcmxygzzsqname_like = n_pcmxygzzsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqname_like)){
            this.getSelectCond().like("pcmxygzzsqname", n_pcmxygzzsqname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSelectCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pcmxygzzsqid_eq;//[试用期员工转正申请标识]
	public void setN_pcmxygzzsqid_eq(String n_pcmxygzzsqid_eq) {
        this.n_pcmxygzzsqid_eq = n_pcmxygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqid_eq)){
            this.getSelectCond().eq("pcmxygzzsqid", n_pcmxygzzsqid_eq);
        }
    }
	private String n_pcmxygzzkhjgjlid_eq;//[试用期员工转正考核结果记录标识]
	public void setN_pcmxygzzkhjgjlid_eq(String n_pcmxygzzkhjgjlid_eq) {
        this.n_pcmxygzzkhjgjlid_eq = n_pcmxygzzkhjgjlid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzkhjgjlid_eq)){
            this.getSelectCond().eq("pcmxygzzkhjgjlid", n_pcmxygzzkhjgjlid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmxygzzjlmxname",query);
			this.getSelectCond().or().like("pimpersonname",query);
			this.getSelectCond().or().like("ygbh",query);
		 }
	}
}




