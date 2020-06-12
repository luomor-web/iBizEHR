package cn.ibizlab.ehr.core.sal.filter;

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
import cn.ibizlab.ehr.core.sal.domain.SalItemSub;
/**
 * 关系型数据实体[SalItemSub] 查询条件对象
 */
@Slf4j
@Data
public class SalItemSubSearchContext extends QueryWrapperContext<SalItemSub> {

	private String n_salitemsubname_like;//[薪酬要素项维护名称]
	public void setN_salitemsubname_like(String n_salitemsubname_like) {
        this.n_salitemsubname_like = n_salitemsubname_like;
        if(!ObjectUtils.isEmpty(this.n_salitemsubname_like)){
            this.getSearchCond().like("salitemsubname", n_salitemsubname_like);
        }
    }
	private String n_ormorgname_eq;//[组织]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSearchCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSearchCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_salitemname_eq;//[要素项]
	public void setN_salitemname_eq(String n_salitemname_eq) {
        this.n_salitemname_eq = n_salitemname_eq;
        if(!ObjectUtils.isEmpty(this.n_salitemname_eq)){
            this.getSearchCond().eq("salitemname", n_salitemname_eq);
        }
    }
	private String n_salitemname_like;//[要素项]
	public void setN_salitemname_like(String n_salitemname_like) {
        this.n_salitemname_like = n_salitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salitemname_like)){
            this.getSearchCond().like("salitemname", n_salitemname_like);
        }
    }
	private String n_salsubjectname_eq;//[财务科目]
	public void setN_salsubjectname_eq(String n_salsubjectname_eq) {
        this.n_salsubjectname_eq = n_salsubjectname_eq;
        if(!ObjectUtils.isEmpty(this.n_salsubjectname_eq)){
            this.getSearchCond().eq("salsubjectname", n_salsubjectname_eq);
        }
    }
	private String n_salsubjectname_like;//[财务科目]
	public void setN_salsubjectname_like(String n_salsubjectname_like) {
        this.n_salsubjectname_like = n_salsubjectname_like;
        if(!ObjectUtils.isEmpty(this.n_salsubjectname_like)){
            this.getSearchCond().like("salsubjectname", n_salsubjectname_like);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSearchCond().eq("ormorgid", n_ormorgid_eq);
        }
    }
	private String n_salsubjectid_eq;//[财务科目标识]
	public void setN_salsubjectid_eq(String n_salsubjectid_eq) {
        this.n_salsubjectid_eq = n_salsubjectid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsubjectid_eq)){
            this.getSearchCond().eq("salsubjectid", n_salsubjectid_eq);
        }
    }
	private String n_salitemid_eq;//[薪酬要素项标识]
	public void setN_salitemid_eq(String n_salitemid_eq) {
        this.n_salitemid_eq = n_salitemid_eq;
        if(!ObjectUtils.isEmpty(this.n_salitemid_eq)){
            this.getSearchCond().eq("salitemid", n_salitemid_eq);
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
                     wrapper.like("salitemsubname", query)   
            );
		 }
	}
}




