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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE;
/**
 * 关系型数据实体[TRMTRAINCOURSE] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TRMTRAINCOURSESearchContext extends QueryWrapperContext<TRMTRAINCOURSE> {

	private String n_kclb_eq;//[课程类别]
	public void setN_kclb_eq(String n_kclb_eq) {
        this.n_kclb_eq = n_kclb_eq;
        if(!ObjectUtils.isEmpty(this.n_kclb_eq)){
            this.getSelectCond().eq("kclb", n_kclb_eq);
        }
    }
	private String n_trmtraincoursename_like;//[培训课程名称]
	public void setN_trmtraincoursename_like(String n_trmtraincoursename_like) {
        this.n_trmtraincoursename_like = n_trmtraincoursename_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_like)){
            this.getSelectCond().like("trmtraincoursename", n_trmtraincoursename_like);
        }
    }
	private String n_skfs_eq;//[授课方式]
	public void setN_skfs_eq(String n_skfs_eq) {
        this.n_skfs_eq = n_skfs_eq;
        if(!ObjectUtils.isEmpty(this.n_skfs_eq)){
            this.getSelectCond().eq("skfs", n_skfs_eq);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
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
	private String n_trmcoursesystemname_eq;//[培训模块]
	public void setN_trmcoursesystemname_eq(String n_trmcoursesystemname_eq) {
        this.n_trmcoursesystemname_eq = n_trmcoursesystemname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemname_eq)){
            this.getSelectCond().eq("trmcoursesystemname", n_trmcoursesystemname_eq);
        }
    }
	private String n_trmcoursesystemname_like;//[培训模块]
	public void setN_trmcoursesystemname_like(String n_trmcoursesystemname_like) {
        this.n_trmcoursesystemname_like = n_trmcoursesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemname_like)){
            this.getSelectCond().like("trmcoursesystemname", n_trmcoursesystemname_like);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSelectCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_trmcoursesystemid_eq;//[课程体系标识]
	public void setN_trmcoursesystemid_eq(String n_trmcoursesystemid_eq) {
        this.n_trmcoursesystemid_eq = n_trmcoursesystemid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemid_eq)){
            this.getSelectCond().eq("trmcoursesystemid", n_trmcoursesystemid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("trmtraincoursename",query);
		 }
	}
}




