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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsqmx;
/**
 * 关系型数据实体[PcmJxsygzzsqmx] 查询条件对象
 */
@Slf4j
@Data
public class PcmJxsygzzsqmxSearchContext extends QueryWrapperContext<PcmJxsygzzsqmx> {

	private String n_status_eq;//[审核状态]
	public void setN_status_eq(String n_status_eq) {
        this.n_status_eq = n_status_eq;
        if(!ObjectUtils.isEmpty(this.n_status_eq)){
            this.getSearchCond().eq("status", n_status_eq);
        }
    }
	private String n_pcmjxsygzzsqmxname_like;//[见习生员工转正申请明细名称]
	public void setN_pcmjxsygzzsqmxname_like(String n_pcmjxsygzzsqmxname_like) {
        this.n_pcmjxsygzzsqmxname_like = n_pcmjxsygzzsqmxname_like;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzsqmxname_like)){
            this.getSearchCond().like("pcmjxsygzzsqmxname", n_pcmjxsygzzsqmxname_like);
        }
    }
	private String n_bm_like;//[部门]
	public void setN_bm_like(String n_bm_like) {
        this.n_bm_like = n_bm_like;
        if(!ObjectUtils.isEmpty(this.n_bm_like)){
            this.getSearchCond().like("bm", n_bm_like);
        }
    }
	private String n_zz_like;//[组织]
	public void setN_zz_like(String n_zz_like) {
        this.n_zz_like = n_zz_like;
        if(!ObjectUtils.isEmpty(this.n_zz_like)){
            this.getSearchCond().like("zz", n_zz_like);
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
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pcmjxsygzzsqid_eq;//[见习生员工转正申请标识]
	public void setN_pcmjxsygzzsqid_eq(String n_pcmjxsygzzsqid_eq) {
        this.n_pcmjxsygzzsqid_eq = n_pcmjxsygzzsqid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmjxsygzzsqid_eq)){
            this.getSearchCond().eq("pcmjxsygzzsqid", n_pcmjxsygzzsqid_eq);
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
                     wrapper.like("pcmjxsygzzsqmxname", query)   
            );
		 }
	}
}




