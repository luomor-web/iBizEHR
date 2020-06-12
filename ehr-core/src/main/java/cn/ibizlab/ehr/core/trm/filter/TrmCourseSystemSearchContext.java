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
import cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem;
/**
 * 关系型数据实体[TrmCourseSystem] 查询条件对象
 */
@Slf4j
@Data
public class TrmCourseSystemSearchContext extends QueryWrapperContext<TrmCourseSystem> {

	private String n_trmcoursesystemname_like;//[名称]
	public void setN_trmcoursesystemname_like(String n_trmcoursesystemname_like) {
        this.n_trmcoursesystemname_like = n_trmcoursesystemname_like;
        if(!ObjectUtils.isEmpty(this.n_trmcoursesystemname_like)){
            this.getSearchCond().like("trmcoursesystemname", n_trmcoursesystemname_like);
        }
    }
	private String n_jb_eq;//[级别]
	public void setN_jb_eq(String n_jb_eq) {
        this.n_jb_eq = n_jb_eq;
        if(!ObjectUtils.isEmpty(this.n_jb_eq)){
            this.getSearchCond().eq("jb", n_jb_eq);
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
	private String n_trmtrainagencyid_eq;//[培训机构标识]
	public void setN_trmtrainagencyid_eq(String n_trmtrainagencyid_eq) {
        this.n_trmtrainagencyid_eq = n_trmtrainagencyid_eq;
        if(!ObjectUtils.isEmpty(this.n_trmtrainagencyid_eq)){
            this.getSearchCond().eq("trmtrainagencyid", n_trmtrainagencyid_eq);
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
                     wrapper.like("trmcoursesystemname", query)   
            );
		 }
	}
}




