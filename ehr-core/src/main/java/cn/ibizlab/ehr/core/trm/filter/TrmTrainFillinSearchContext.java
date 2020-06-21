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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin;
/**
 * 关系型数据实体[TrmTrainFillin] 查询条件对象
 */
@Slf4j
@Data
public class TrmTrainFillinSearchContext extends QueryWrapperContext<TrmTrainFillin> {

	private String n_trmtrainfillinname_like;//[需求填报]
	public void setN_trmtrainfillinname_like(String n_trmtrainfillinname_like) {
        this.n_trmtrainfillinname_like = n_trmtrainfillinname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinname_like)){
            this.getSearchCond().like("trmtrainfillinname", n_trmtrainfillinname_like);
        }
    }
	private String n_trmtrainfillinname2_eq;//[需求填报]
	public void setN_trmtrainfillinname2_eq(String n_trmtrainfillinname2_eq) {
        this.n_trmtrainfillinname2_eq = n_trmtrainfillinname2_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinname2_eq)){
            this.getSearchCond().eq("trmtrainfillinname2", n_trmtrainfillinname2_eq);
        }
    }
	private String n_trmtrainfillinname2_like;//[需求填报]
	public void setN_trmtrainfillinname2_like(String n_trmtrainfillinname2_like) {
        this.n_trmtrainfillinname2_like = n_trmtrainfillinname2_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinname2_like)){
            this.getSearchCond().like("trmtrainfillinname2", n_trmtrainfillinname2_like);
        }
    }
	private String n_ormorgname_eq;//[单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_trmdepartname_eq;//[培训需求通知]
	public void setN_trmdepartname_eq(String n_trmdepartname_eq) {
        this.n_trmdepartname_eq = n_trmdepartname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdepartname_eq)){
            this.getSearchCond().eq("trmdepartname", n_trmdepartname_eq);
        }
    }
	private String n_trmdepartname_like;//[培训需求通知]
	public void setN_trmdepartname_like(String n_trmdepartname_like) {
        this.n_trmdepartname_like = n_trmdepartname_like;
        if(!ObjectUtils.isEmpty(this.n_trmdepartname_like)){
            this.getSearchCond().like("trmdepartname", n_trmdepartname_like);
        }
    }
	private String n_ormorgsectorname_eq;//[部门]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmtrainfillinid2_eq;//[培训项目部门填报标识]
	public void setN_trmtrainfillinid2_eq(String n_trmtrainfillinid2_eq) {
        this.n_trmtrainfillinid2_eq = n_trmtrainfillinid2_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfillinid2_eq)){
            this.getSearchCond().eq("trmtrainfillinid2", n_trmtrainfillinid2_eq);
        }
    }
	private String n_trmdepartid_eq;//[培训需求通知标识]
	public void setN_trmdepartid_eq(String n_trmdepartid_eq) {
        this.n_trmdepartid_eq = n_trmdepartid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmdepartid_eq)){
            this.getSearchCond().eq("trmdepartid", n_trmdepartid_eq);
        }
    }
	private String n_ormorgsectorid_eq;//[部门标识]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("trmtrainfillinname", query)   
            );
		 }
	}
}




