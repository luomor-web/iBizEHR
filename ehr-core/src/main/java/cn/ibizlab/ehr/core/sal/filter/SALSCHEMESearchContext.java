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
import cn.ibizlab.ehr.core.sal.domain.SALSCHEME;
/**
 * 关系型数据实体[SALSCHEME] 查询条件对象
 */
@Slf4j
@Data
public class SALSCHEMESearchContext extends QueryWrapperContext<SALSCHEME> {

	private String n_saltype_eq;//[薪酬类型]
	public void setN_saltype_eq(String n_saltype_eq) {
        this.n_saltype_eq = n_saltype_eq;
        if(!ObjectUtils.isEmpty(this.n_saltype_eq)){
            this.getSelectCond().eq("saltype", n_saltype_eq);
        }
    }
	private String n_salschemename_like;//[工资单名称]
	public void setN_salschemename_like(String n_salschemename_like) {
        this.n_salschemename_like = n_salschemename_like;
        if(!ObjectUtils.isEmpty(this.n_salschemename_like)){
            this.getSelectCond().like("salschemename", n_salschemename_like);
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
			this.getSelectCond().or().like("salschemename",query);
		 }
	}
}




