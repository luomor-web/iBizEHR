package cn.ibizlab.ehr.core.sal.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.sal.domain.SALSTDGWGZ;
/**
 * 关系型数据实体[SALSTDGWGZ] 查询条件对象
 */
@Slf4j
@Data
public class SALSTDGWGZSearchContext extends QueryWrapperContext<SALSTDGWGZ> {

	private String n_dj_eq;//[工资档级]
	public void setN_dj_eq(String n_dj_eq) {
        this.n_dj_eq = n_dj_eq;
        if(!ObjectUtils.isEmpty(this.n_dj_eq)){
            this.getSelectCond().eq("dj", n_dj_eq);
        }
    }
	private String n_salstdgwgzname_like;//[岗位工资标准名称]
	public void setN_salstdgwgzname_like(String n_salstdgwgzname_like) {
        this.n_salstdgwgzname_like = n_salstdgwgzname_like;
        if(!ObjectUtils.isEmpty(this.n_salstdgwgzname_like)){
            this.getSelectCond().like("salstdgwgzname", n_salstdgwgzname_like);
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
	private String n_ormdutyname_eq;//[职务]
	public void setN_ormdutyname_eq(String n_ormdutyname_eq) {
        this.n_ormdutyname_eq = n_ormdutyname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_eq)){
            this.getSelectCond().eq("ormdutyname", n_ormdutyname_eq);
        }
    }
	private String n_ormdutyname_like;//[职务]
	public void setN_ormdutyname_like(String n_ormdutyname_like) {
        this.n_ormdutyname_like = n_ormdutyname_like;
        if(!ObjectUtils.isEmpty(this.n_ormdutyname_like)){
            this.getSelectCond().like("ormdutyname", n_ormdutyname_like);
        }
    }
	private String n_ormdutyid_eq;//[职务管理标识]
	public void setN_ormdutyid_eq(String n_ormdutyid_eq) {
        this.n_ormdutyid_eq = n_ormdutyid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormdutyid_eq)){
            this.getSelectCond().eq("ormdutyid", n_ormdutyid_eq);
        }
    }
	private String n_ormorgid_eq;//[组织标识]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("salstdgwgzname",query);
		 }
	}
}




