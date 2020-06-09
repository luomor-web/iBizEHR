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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherCharge;
/**
 * 关系型数据实体[TrmTeacherCharge] 查询条件对象
 */
@Slf4j
@Data
public class TrmTeacherChargeSearchContext extends QueryWrapperContext<TrmTeacherCharge> {

	private String n_jsdj_eq;//[讲师等级]
	public void setN_jsdj_eq(String n_jsdj_eq) {
        this.n_jsdj_eq = n_jsdj_eq;
        if(!ObjectUtils.isEmpty(this.n_jsdj_eq)){
            this.getSearchCond().eq("jsdj", n_jsdj_eq);
        }
    }
	private String n_trmteacherchargename_like;//[讲师收费记录名称]
	public void setN_trmteacherchargename_like(String n_trmteacherchargename_like) {
        this.n_trmteacherchargename_like = n_trmteacherchargename_like;
        if(!ObjectUtils.isEmpty(this.n_trmteacherchargename_like)){
            this.getSearchCond().like("trmteacherchargename", n_trmteacherchargename_like);
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
	private String n_trmtrainplantermname_eq;//[培训班]
	public void setN_trmtrainplantermname_eq(String n_trmtrainplantermname_eq) {
        this.n_trmtrainplantermname_eq = n_trmtrainplantermname_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_eq)){
            this.getSearchCond().eq("trmtrainplantermname", n_trmtrainplantermname_eq);
        }
    }
	private String n_trmtrainplantermname_like;//[培训班]
	public void setN_trmtrainplantermname_like(String n_trmtrainplantermname_like) {
        this.n_trmtrainplantermname_like = n_trmtrainplantermname_like;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermname_like)){
            this.getSearchCond().like("trmtrainplantermname", n_trmtrainplantermname_like);
        }
    }
	private String n_trmtrainplantermid_eq;//[培训计划项标识]
	public void setN_trmtrainplantermid_eq(String n_trmtrainplantermid_eq) {
        this.n_trmtrainplantermid_eq = n_trmtrainplantermid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainplantermid_eq)){
            this.getSearchCond().eq("trmtrainplantermid", n_trmtrainplantermid_eq);
        }
    }
	private String n_trmtrainteacherid_eq;//[培训教师标识]
	public void setN_trmtrainteacherid_eq(String n_trmtrainteacherid_eq) {
        this.n_trmtrainteacherid_eq = n_trmtrainteacherid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainteacherid_eq)){
            this.getSearchCond().eq("trmtrainteacherid", n_trmtrainteacherid_eq);
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
                     wrapper.like("trmteacherchargename", query)   
            );
		 }
	}
}




