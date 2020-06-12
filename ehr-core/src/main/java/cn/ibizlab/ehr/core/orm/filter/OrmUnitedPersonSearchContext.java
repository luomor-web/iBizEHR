package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.OrmUnitedPerson;
/**
 * 关系型数据实体[OrmUnitedPerson] 查询条件对象
 */
@Slf4j
@Data
public class OrmUnitedPersonSearchContext extends QueryWrapperContext<OrmUnitedPerson> {

	private String n_unitedpersonname_like;//[身份名称]
	public void setN_unitedpersonname_like(String n_unitedpersonname_like) {
        this.n_unitedpersonname_like = n_unitedpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_unitedpersonname_like)){
            this.getSearchCond().like("unitedpersonname", n_unitedpersonname_like);
        }
    }
	private String n_refermark_eq;//[引用标志]
	public void setN_refermark_eq(String n_refermark_eq) {
        this.n_refermark_eq = n_refermark_eq;
        if(!ObjectUtils.isEmpty(this.n_refermark_eq)){
            this.getSearchCond().eq("refermark", n_refermark_eq);
        }
    }
	private String n_employeename_like;//[姓名]
	public void setN_employeename_like(String n_employeename_like) {
        this.n_employeename_like = n_employeename_like;
        if(!ObjectUtils.isEmpty(this.n_employeename_like)){
            this.getSearchCond().like("employeename", n_employeename_like);
        }
    }
	private String n_employeenumber_eq;//[用户编码]
	public void setN_employeenumber_eq(String n_employeenumber_eq) {
        this.n_employeenumber_eq = n_employeenumber_eq;
        if(!ObjectUtils.isEmpty(this.n_employeenumber_eq)){
            this.getSearchCond().eq("employeenumber", n_employeenumber_eq);
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
                     wrapper.like("unitedpersonname", query)   
                        .or().like("employeename", query)            
                        .or().like("employeenumber", query)            
            );
		 }
	}
}




