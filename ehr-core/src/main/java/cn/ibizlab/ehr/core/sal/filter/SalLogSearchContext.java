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
import cn.ibizlab.ehr.core.sal.domain.SalLog;
/**
 * 关系型数据实体[SalLog] 查询条件对象
 */
@Slf4j
@Data
public class SalLogSearchContext extends QueryWrapperContext<SalLog> {

	private String n_sallogname_like;//[操作类型]
	public void setN_sallogname_like(String n_sallogname_like) {
        this.n_sallogname_like = n_sallogname_like;
        if(!ObjectUtils.isEmpty(this.n_sallogname_like)){
            this.getSearchCond().like("sallogname", n_sallogname_like);
        }
    }
	private String n_salsalaryname_eq;//[员工薪酬]
	public void setN_salsalaryname_eq(String n_salsalaryname_eq) {
        this.n_salsalaryname_eq = n_salsalaryname_eq;
        if(!ObjectUtils.isEmpty(this.n_salsalaryname_eq)){
            this.getSearchCond().eq("salsalaryname", n_salsalaryname_eq);
        }
    }
	private String n_salsalaryname_like;//[员工薪酬]
	public void setN_salsalaryname_like(String n_salsalaryname_like) {
        this.n_salsalaryname_like = n_salsalaryname_like;
        if(!ObjectUtils.isEmpty(this.n_salsalaryname_like)){
            this.getSearchCond().like("salsalaryname", n_salsalaryname_like);
        }
    }
	private String n_salsalarydetailname_eq;//[要素项]
	public void setN_salsalarydetailname_eq(String n_salsalarydetailname_eq) {
        this.n_salsalarydetailname_eq = n_salsalarydetailname_eq;
        if(!ObjectUtils.isEmpty(this.n_salsalarydetailname_eq)){
            this.getSearchCond().eq("salsalarydetailname", n_salsalarydetailname_eq);
        }
    }
	private String n_salsalarydetailname_like;//[要素项]
	public void setN_salsalarydetailname_like(String n_salsalarydetailname_like) {
        this.n_salsalarydetailname_like = n_salsalarydetailname_like;
        if(!ObjectUtils.isEmpty(this.n_salsalarydetailname_like)){
            this.getSearchCond().like("salsalarydetailname", n_salsalarydetailname_like);
        }
    }
	private String n_salsalarydetailid_eq;//[员工薪酬明细标识]
	public void setN_salsalarydetailid_eq(String n_salsalarydetailid_eq) {
        this.n_salsalarydetailid_eq = n_salsalarydetailid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsalarydetailid_eq)){
            this.getSearchCond().eq("salsalarydetailid", n_salsalarydetailid_eq);
        }
    }
	private String n_salsalaryid_eq;//[员工薪酬标识]
	public void setN_salsalaryid_eq(String n_salsalaryid_eq) {
        this.n_salsalaryid_eq = n_salsalaryid_eq;
        if(!ObjectUtils.isEmpty(this.n_salsalaryid_eq)){
            this.getSearchCond().eq("salsalaryid", n_salsalaryid_eq);
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
                     wrapper.like("sallogname", query)   
            );
		 }
	}
}




