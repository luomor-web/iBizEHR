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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
/**
 * 关系型数据实体[PcmJxsygzzjlmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmJxsygzzjlmxSearchContext extends QueryWrapperContext<PcmJxsygzzjlmx> {

	private String n_checkstatus_eq;//[审核状态]
	public void setN_checkstatus_eq(String n_checkstatus_eq) {
        this.n_checkstatus_eq = n_checkstatus_eq;
        if(!ObjectUtils.isEmpty(this.n_checkstatus_eq)){
            this.getSearchCond().eq("checkstatus", n_checkstatus_eq);
        }
    }
	private String n_pcmjxsygzzjlmxname_like;//[见习生员工转正记录引用明细名称]
	public void setN_pcmjxsygzzjlmxname_like(String n_pcmjxsygzzjlmxname_like) {
        this.n_pcmjxsygzzjlmxname_like = n_pcmjxsygzzjlmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzjlmxname_like)){
            this.getSearchCond().like("pcmjxsygzzjlmxname", n_pcmjxsygzzjlmxname_like);
        }
    }
	private String n_duration_eq;//[见习期限（月）]
	public void setN_duration_eq(String n_duration_eq) {
        this.n_duration_eq = n_duration_eq;
        if(!ObjectUtils.isEmpty(this.n_duration_eq)){
            this.getSearchCond().eq("duration", n_duration_eq);
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
	private String n_ygbh_like;//[员工编号]
	public void setN_ygbh_like(String n_ygbh_like) {
        this.n_ygbh_like = n_ygbh_like;
        if(!ObjectUtils.isEmpty(this.n_ygbh_like)){
            this.getSearchCond().like("ygbh", n_ygbh_like);
        }
    }
	private String n_pcmjxsygzzsqname_eq;//[见习生员工转正申请名称]
	public void setN_pcmjxsygzzsqname_eq(String n_pcmjxsygzzsqname_eq) {
        this.n_pcmjxsygzzsqname_eq = n_pcmjxsygzzsqname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzsqname_eq)){
            this.getSearchCond().eq("pcmjxsygzzsqname", n_pcmjxsygzzsqname_eq);
        }
    }
	private String n_pcmjxsygzzsqname_like;//[见习生员工转正申请名称]
	public void setN_pcmjxsygzzsqname_like(String n_pcmjxsygzzsqname_like) {
        this.n_pcmjxsygzzsqname_like = n_pcmjxsygzzsqname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzsqname_like)){
            this.getSearchCond().like("pcmjxsygzzsqname", n_pcmjxsygzzsqname_like);
        }
    }
	private String n_pcmjxszzkhjgjlname_eq;//[员工]
	public void setN_pcmjxszzkhjgjlname_eq(String n_pcmjxszzkhjgjlname_eq) {
        this.n_pcmjxszzkhjgjlname_eq = n_pcmjxszzkhjgjlname_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxszzkhjgjlname_eq)){
            this.getSearchCond().eq("pcmjxszzkhjgjlname", n_pcmjxszzkhjgjlname_eq);
        }
    }
	private String n_pcmjxszzkhjgjlname_like;//[员工]
	public void setN_pcmjxszzkhjgjlname_like(String n_pcmjxszzkhjgjlname_like) {
        this.n_pcmjxszzkhjgjlname_like = n_pcmjxszzkhjgjlname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxszzkhjgjlname_like)){
            this.getSearchCond().like("pcmjxszzkhjgjlname", n_pcmjxszzkhjgjlname_like);
        }
    }
	private String n_pcmjxsygzzsqid_eq;//[见习生员工转正申请标识]
	public void setN_pcmjxsygzzsqid_eq(String n_pcmjxsygzzsqid_eq) {
        this.n_pcmjxsygzzsqid_eq = n_pcmjxsygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzsqid_eq)){
            this.getSearchCond().eq("pcmjxsygzzsqid", n_pcmjxsygzzsqid_eq);
        }
    }
	private String n_pcmjxszzkhjgjlid_eq;//[见习生员工转正考核结果记录标识]
	public void setN_pcmjxszzkhjgjlid_eq(String n_pcmjxszzkhjgjlid_eq) {
        this.n_pcmjxszzkhjgjlid_eq = n_pcmjxszzkhjgjlid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxszzkhjgjlid_eq)){
            this.getSearchCond().eq("pcmjxszzkhjgjlid", n_pcmjxszzkhjgjlid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pcmjxsygzzjlmxname", query)   
                        .or().like("pimpersonname", query)            
                        .or().like("ygbh", query)            
            );
		 }
	}
}




