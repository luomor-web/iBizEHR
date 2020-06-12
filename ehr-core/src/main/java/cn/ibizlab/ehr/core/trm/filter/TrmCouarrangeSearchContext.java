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
import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
/**
 * 关系型数据实体[TrmCouarrange] 查询条件对象
 */
@Slf4j
@Data
public class TrmCouarrangeSearchContext extends QueryWrapperContext<TrmCouarrange> {

	private String n_trmcouarrangename_like;//[课程安排名称]
	public void setN_trmcouarrangename_like(String n_trmcouarrangename_like) {
        this.n_trmcouarrangename_like = n_trmcouarrangename_like;
        if(!ObjectUtils.isEmpty(this.n_trmcouarrangename_like)){
            this.getSearchCond().like("trmcouarrangename", n_trmcouarrangename_like);
        }
    }
	private String n_trmtrainagencyname_eq;//[培训机构]
	public void setN_trmtrainagencyname_eq(String n_trmtrainagencyname_eq) {
        this.n_trmtrainagencyname_eq = n_trmtrainagencyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_eq)){
            this.getSearchCond().eq("trmtrainagencyname", n_trmtrainagencyname_eq);
        }
    }
	private String n_trmtrainagencyname_like;//[培训机构]
	public void setN_trmtrainagencyname_like(String n_trmtrainagencyname_like) {
        this.n_trmtrainagencyname_like = n_trmtrainagencyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyname_like)){
            this.getSearchCond().like("trmtrainagencyname", n_trmtrainagencyname_like);
        }
    }
	private String n_trmtrainplantermname_eq;//[班级]
	public void setN_trmtrainplantermname_eq(String n_trmtrainplantermname_eq) {
        this.n_trmtrainplantermname_eq = n_trmtrainplantermname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_eq)){
            this.getSearchCond().eq("trmtrainplantermname", n_trmtrainplantermname_eq);
        }
    }
	private String n_trmtrainplantermname_like;//[班级]
	public void setN_trmtrainplantermname_like(String n_trmtrainplantermname_like) {
        this.n_trmtrainplantermname_like = n_trmtrainplantermname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_like)){
            this.getSearchCond().like("trmtrainplantermname", n_trmtrainplantermname_like);
        }
    }
	private String n_trmtrainactapplyname_eq;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_eq(String n_trmtrainactapplyname_eq) {
        this.n_trmtrainactapplyname_eq = n_trmtrainactapplyname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_eq)){
            this.getSearchCond().eq("trmtrainactapplyname", n_trmtrainactapplyname_eq);
        }
    }
	private String n_trmtrainactapplyname_like;//[培训活动申请名称]
	public void setN_trmtrainactapplyname_like(String n_trmtrainactapplyname_like) {
        this.n_trmtrainactapplyname_like = n_trmtrainactapplyname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyname_like)){
            this.getSearchCond().like("trmtrainactapplyname", n_trmtrainactapplyname_like);
        }
    }
	private String n_trmtrainaddressname_eq;//[培训场地]
	public void setN_trmtrainaddressname_eq(String n_trmtrainaddressname_eq) {
        this.n_trmtrainaddressname_eq = n_trmtrainaddressname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressname_eq)){
            this.getSearchCond().eq("trmtrainaddressname", n_trmtrainaddressname_eq);
        }
    }
	private String n_trmtrainaddressname_like;//[培训场地]
	public void setN_trmtrainaddressname_like(String n_trmtrainaddressname_like) {
        this.n_trmtrainaddressname_like = n_trmtrainaddressname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressname_like)){
            this.getSearchCond().like("trmtrainaddressname", n_trmtrainaddressname_like);
        }
    }
	private String n_trmtrianpersonname_eq;//[参培人员]
	public void setN_trmtrianpersonname_eq(String n_trmtrianpersonname_eq) {
        this.n_trmtrianpersonname_eq = n_trmtrianpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrianpersonname_eq)){
            this.getSearchCond().eq("trmtrianpersonname", n_trmtrianpersonname_eq);
        }
    }
	private String n_trmtrianpersonname_like;//[参培人员]
	public void setN_trmtrianpersonname_like(String n_trmtrianpersonname_like) {
        this.n_trmtrianpersonname_like = n_trmtrianpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrianpersonname_like)){
            this.getSearchCond().like("trmtrianpersonname", n_trmtrianpersonname_like);
        }
    }
	private String n_trmtraincoursename_eq;//[课程]
	public void setN_trmtraincoursename_eq(String n_trmtraincoursename_eq) {
        this.n_trmtraincoursename_eq = n_trmtraincoursename_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_eq)){
            this.getSearchCond().eq("trmtraincoursename", n_trmtraincoursename_eq);
        }
    }
	private String n_trmtraincoursename_like;//[课程]
	public void setN_trmtraincoursename_like(String n_trmtraincoursename_like) {
        this.n_trmtraincoursename_like = n_trmtraincoursename_like;
        if(!ObjectUtils.isEmpty(this.n_trmtraincoursename_like)){
            this.getSearchCond().like("trmtraincoursename", n_trmtraincoursename_like);
        }
    }
	private String n_trmcoursesystemname_eq;//[名称]
	public void setN_trmcoursesystemname_eq(String n_trmcoursesystemname_eq) {
        this.n_trmcoursesystemname_eq = n_trmcoursesystemname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemname_eq)){
            this.getSearchCond().eq("trmcoursesystemname", n_trmcoursesystemname_eq);
        }
    }
	private String n_trmcoursesystemname_like;//[名称]
	public void setN_trmcoursesystemname_like(String n_trmcoursesystemname_like) {
        this.n_trmcoursesystemname_like = n_trmcoursesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemname_like)){
            this.getSearchCond().like("trmcoursesystemname", n_trmcoursesystemname_like);
        }
    }
	private String n_trmtrainfaciesname_eq;//[会议室]
	public void setN_trmtrainfaciesname_eq(String n_trmtrainfaciesname_eq) {
        this.n_trmtrainfaciesname_eq = n_trmtrainfaciesname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfaciesname_eq)){
            this.getSearchCond().eq("trmtrainfaciesname", n_trmtrainfaciesname_eq);
        }
    }
	private String n_trmtrainfaciesname_like;//[会议室]
	public void setN_trmtrainfaciesname_like(String n_trmtrainfaciesname_like) {
        this.n_trmtrainfaciesname_like = n_trmtrainfaciesname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfaciesname_like)){
            this.getSearchCond().like("trmtrainfaciesname", n_trmtrainfaciesname_like);
        }
    }
	private String n_trmtrainteachername_eq;//[讲师]
	public void setN_trmtrainteachername_eq(String n_trmtrainteachername_eq) {
        this.n_trmtrainteachername_eq = n_trmtrainteachername_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteachername_eq)){
            this.getSearchCond().eq("trmtrainteachername", n_trmtrainteachername_eq);
        }
    }
	private String n_trmtrainteachername_like;//[讲师]
	public void setN_trmtrainteachername_like(String n_trmtrainteachername_like) {
        this.n_trmtrainteachername_like = n_trmtrainteachername_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteachername_like)){
            this.getSearchCond().like("trmtrainteachername", n_trmtrainteachername_like);
        }
    }
	private String n_trmagencyrecordname_eq;//[培训记录]
	public void setN_trmagencyrecordname_eq(String n_trmagencyrecordname_eq) {
        this.n_trmagencyrecordname_eq = n_trmagencyrecordname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmagencyrecordname_eq)){
            this.getSearchCond().eq("trmagencyrecordname", n_trmagencyrecordname_eq);
        }
    }
	private String n_trmagencyrecordname_like;//[培训记录]
	public void setN_trmagencyrecordname_like(String n_trmagencyrecordname_like) {
        this.n_trmagencyrecordname_like = n_trmagencyrecordname_like;
        if(!ObjectUtils.isEmpty(this.n_trmagencyrecordname_like)){
            this.getSearchCond().like("trmagencyrecordname", n_trmagencyrecordname_like);
        }
    }
	private String n_trmtrianpersonid_eq;//[培训人员标识]
	public void setN_trmtrianpersonid_eq(String n_trmtrianpersonid_eq) {
        this.n_trmtrianpersonid_eq = n_trmtrianpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrianpersonid_eq)){
            this.getSearchCond().eq("trmtrianpersonid", n_trmtrianpersonid_eq);
        }
    }
	private String n_trmtrainteacherid_eq;//[培训教师标识]
	public void setN_trmtrainteacherid_eq(String n_trmtrainteacherid_eq) {
        this.n_trmtrainteacherid_eq = n_trmtrainteacherid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteacherid_eq)){
            this.getSearchCond().eq("trmtrainteacherid", n_trmtrainteacherid_eq);
        }
    }
	private String n_trmtrainfaciesid_eq;//[培训设施标识]
	public void setN_trmtrainfaciesid_eq(String n_trmtrainfaciesid_eq) {
        this.n_trmtrainfaciesid_eq = n_trmtrainfaciesid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainfaciesid_eq)){
            this.getSearchCond().eq("trmtrainfaciesid", n_trmtrainfaciesid_eq);
        }
    }
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSearchCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
        }
    }
	private String n_trmtrainplantermid_eq;//[培训计划项标识]
	public void setN_trmtrainplantermid_eq(String n_trmtrainplantermid_eq) {
        this.n_trmtrainplantermid_eq = n_trmtrainplantermid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermid_eq)){
            this.getSearchCond().eq("trmtrainplantermid", n_trmtrainplantermid_eq);
        }
    }
	private String n_trmtrainactapplyid_eq;//[培训活动申请标识]
	public void setN_trmtrainactapplyid_eq(String n_trmtrainactapplyid_eq) {
        this.n_trmtrainactapplyid_eq = n_trmtrainactapplyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainactapplyid_eq)){
            this.getSearchCond().eq("trmtrainactapplyid", n_trmtrainactapplyid_eq);
        }
    }
	private String n_trmtrainaddressid_eq;//[培训地点标识]
	public void setN_trmtrainaddressid_eq(String n_trmtrainaddressid_eq) {
        this.n_trmtrainaddressid_eq = n_trmtrainaddressid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainaddressid_eq)){
            this.getSearchCond().eq("trmtrainaddressid", n_trmtrainaddressid_eq);
        }
    }
	private String n_trmagencyrecordid_eq;//[机构培训记录标识]
	public void setN_trmagencyrecordid_eq(String n_trmagencyrecordid_eq) {
        this.n_trmagencyrecordid_eq = n_trmagencyrecordid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmagencyrecordid_eq)){
            this.getSearchCond().eq("trmagencyrecordid", n_trmagencyrecordid_eq);
        }
    }
	private String n_trmtraincourseid_eq;//[培训课程标识]
	public void setN_trmtraincourseid_eq(String n_trmtraincourseid_eq) {
        this.n_trmtraincourseid_eq = n_trmtraincourseid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtraincourseid_eq)){
            this.getSearchCond().eq("trmtraincourseid", n_trmtraincourseid_eq);
        }
    }
	private String n_trmcoursesystemid_eq;//[课程体系标识]
	public void setN_trmcoursesystemid_eq(String n_trmcoursesystemid_eq) {
        this.n_trmcoursesystemid_eq = n_trmcoursesystemid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemid_eq)){
            this.getSearchCond().eq("trmcoursesystemid", n_trmcoursesystemid_eq);
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
                     wrapper.like("trmcouarrangename", query)   
            );
		 }
	}
}




