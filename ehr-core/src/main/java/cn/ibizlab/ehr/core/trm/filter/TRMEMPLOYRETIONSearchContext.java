package cn.ibizlab.ehr.core.trm.filter;

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
import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
/**
 * 关系型数据实体[TRMEMPLOYRETION] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TRMEMPLOYRETIONSearchContext extends QueryWrapperContext<TRMEMPLOYRETION> {

	private String n_trmemployeeretionname_like;//[员工培训报名名称]
	public void setN_trmemployeeretionname_like(String n_trmemployeeretionname_like) {
        this.n_trmemployeeretionname_like = n_trmemployeeretionname_like;
        if(!ObjectUtils.isEmpty(this.n_trmemployeeretionname_like)){
            this.getSelectCond().like("trmemployeeretionname", n_trmemployeeretionname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_trmcouarrangename_eq;//[课程安排名称]
	public void setN_trmcouarrangename_eq(String n_trmcouarrangename_eq) {
        this.n_trmcouarrangename_eq = n_trmcouarrangename_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcouarrangename_eq)){
            this.getSelectCond().eq("trmcouarrangename", n_trmcouarrangename_eq);
        }
    }
	private String n_trmcouarrangename_like;//[课程安排名称]
	public void setN_trmcouarrangename_like(String n_trmcouarrangename_like) {
        this.n_trmcouarrangename_like = n_trmcouarrangename_like;
        if(!ObjectUtils.isEmpty(this.n_trmcouarrangename_like)){
            this.getSelectCond().like("trmcouarrangename", n_trmcouarrangename_like);
        }
    }
	private String n_trmtrainagencyname_eq;//[培训机构名称]
	public void setN_trmtrainagencyname_eq(String n_trmtrainagencyname_eq) {
        this.n_trmtrainagencyname_eq = n_trmtrainagencyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_eq)){
            this.getSelectCond().eq("trmtrainagencyname", n_trmtrainagencyname_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[培训机构名称]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSelectCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_trmtrainactapplyname_eq;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_eq(String n_trmtrainactapplyname_eq) {
        this.n_trmtrainactapplyname_eq = n_trmtrainactapplyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_eq)){
            this.getSelectCond().eq("trmtrainactapplyname", n_trmtrainactapplyname_eq);
        }
    }
	private String n_trmtrainactapplyname_like;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_like(String n_trmtrainactapplyname_like) {
        this.n_trmtrainactapplyname_like = n_trmtrainactapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_like)){
            this.getSelectCond().like("trmtrainactapplyname", n_trmtrainactapplyname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmcouarrangeid_eq;//[课程安排标识]
	public void setN_trmcouarrangeid_eq(String n_trmcouarrangeid_eq) {
        this.n_trmcouarrangeid_eq = n_trmcouarrangeid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcouarrangeid_eq)){
            this.getSelectCond().eq("trmcouarrangeid", n_trmcouarrangeid_eq);
        }
    }
	private String n_trmtrainactapplyid_eq;//[培训活动申请标识]
	public void setN_trmtrainactapplyid_eq(String n_trmtrainactapplyid_eq) {
        this.n_trmtrainactapplyid_eq = n_trmtrainactapplyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyid_eq)){
            this.getSelectCond().eq("trmtrainactapplyid", n_trmtrainactapplyid_eq);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSelectCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("trmemployeeretionname",query);
		 }
	}
}




