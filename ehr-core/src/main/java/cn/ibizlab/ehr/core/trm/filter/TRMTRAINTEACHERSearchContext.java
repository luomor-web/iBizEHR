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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER;
/**
 * 关系型数据实体[TRMTRAINTEACHER] 查询条件对象
 */
@Slf4j
@Data
public class TRMTRAINTEACHERSearchContext extends QueryWrapperContext<TRMTRAINTEACHER> {

	private String n_pxjsjb_eq;//[培训讲师级别]
	public void setN_pxjsjb_eq(String n_pxjsjb_eq) {
        this.n_pxjsjb_eq = n_pxjsjb_eq;
        if(!ObjectUtils.isEmpty(this.n_pxjsjb_eq)){
            this.getSelectCond().eq("pxjsjb", n_pxjsjb_eq);
        }
    }
	private String n_jslb_eq;//[教师类别]
	public void setN_jslb_eq(String n_jslb_eq) {
        this.n_jslb_eq = n_jslb_eq;
        if(!ObjectUtils.isEmpty(this.n_jslb_eq)){
            this.getSelectCond().eq("jslb", n_jslb_eq);
        }
    }
	private String n_jslx_eq;//[讲师类型]
	public void setN_jslx_eq(String n_jslx_eq) {
        this.n_jslx_eq = n_jslx_eq;
        if(!ObjectUtils.isEmpty(this.n_jslx_eq)){
            this.getSelectCond().eq("jslx", n_jslx_eq);
        }
    }
	private String n_trmtrainteachername_like;//[培训教师名称]
	public void setN_trmtrainteachername_like(String n_trmtrainteachername_like) {
        this.n_trmtrainteachername_like = n_trmtrainteachername_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteachername_like)){
            this.getSelectCond().like("trmtrainteachername", n_trmtrainteachername_like);
        }
    }
	private String n_ormorgname_eq;//[所属单位]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[所属单位]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_trmtrainagencyname_eq;//[所属机构]
	public void setN_trmtrainagencyname_eq(String n_trmtrainagencyname_eq) {
        this.n_trmtrainagencyname_eq = n_trmtrainagencyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_eq)){
            this.getSelectCond().eq("trmtrainagencyname", n_trmtrainagencyname_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[所属机构]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSelectCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_pimpersonname_eq;//[姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
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
            this.getSelectCond().and( wrapper ->
                     wrapper.like("trmtrainteachername", query)   
            );
		 }
	}
}




