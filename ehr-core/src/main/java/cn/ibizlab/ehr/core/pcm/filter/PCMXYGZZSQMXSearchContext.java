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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
/**
 * 关系型数据实体[PCMXYGZZSQMX] 查询条件对象
 */
@Slf4j
@Data
public class PCMXYGZZSQMXSearchContext extends QueryWrapperContext<PCMXYGZZSQMX> {

	private String n_pcmxygzzsqmxname_like;//[试用期员工转正申请明细名称]
	public void setN_pcmxygzzsqmxname_like(String n_pcmxygzzsqmxname_like) {
        this.n_pcmxygzzsqmxname_like = n_pcmxygzzsqmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqmxname_like)){
            this.getSelectCond().like("pcmxygzzsqmxname", n_pcmxygzzsqmxname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
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
	private String n_pcmxygzzsqid_eq;//[试用期员工转正申请标识]
	public void setN_pcmxygzzsqid_eq(String n_pcmxygzzsqid_eq) {
        this.n_pcmxygzzsqid_eq = n_pcmxygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmxygzzsqid_eq)){
            this.getSelectCond().eq("pcmxygzzsqid", n_pcmxygzzsqid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pcmxygzzsqmxname",query);
		 }
	}
}



