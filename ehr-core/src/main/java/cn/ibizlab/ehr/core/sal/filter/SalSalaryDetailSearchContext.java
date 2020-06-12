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
import cn.ibizlab.ehr.core.sal.domain.SalSalaryDetail;
/**
 * 关系型数据实体[SalSalaryDetail] 查询条件对象
 */
@Slf4j
@Data
public class SalSalaryDetailSearchContext extends QueryWrapperContext<SalSalaryDetail> {

	private String n_salsalarydetailname_like;//[员工薪酬明细名称]
	public void setN_salsalarydetailname_like(String n_salsalarydetailname_like) {
        this.n_salsalarydetailname_like = n_salsalarydetailname_like;
        if(!ObjectUtils.isEmpty(this.n_salsalarydetailname_like)){
            this.getSearchCond().like("salsalarydetailname", n_salsalarydetailname_like);
        }
    }
	private String n_salsalaryname_eq;//[员工薪酬名称]
	public void setN_salsalaryname_eq(String n_salsalaryname_eq) {
        this.n_salsalaryname_eq = n_salsalaryname_eq;
        if(!ObjectUtils.isEmpty(this.n_salsalaryname_eq)){
            this.getSearchCond().eq("salsalaryname", n_salsalaryname_eq);
        }
    }
	private String n_salsalaryname_like;//[员工薪酬名称]
	public void setN_salsalaryname_like(String n_salsalaryname_like) {
        this.n_salsalaryname_like = n_salsalaryname_like;
        if(!ObjectUtils.isEmpty(this.n_salsalaryname_like)){
            this.getSearchCond().like("salsalaryname", n_salsalaryname_like);
        }
    }
	private String n_salschemeitemname_eq;//[要素项]
	public void setN_salschemeitemname_eq(String n_salschemeitemname_eq) {
        this.n_salschemeitemname_eq = n_salschemeitemname_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemname_eq)){
            this.getSearchCond().eq("salschemeitemname", n_salschemeitemname_eq);
        }
    }
	private String n_salschemeitemname_like;//[要素项]
	public void setN_salschemeitemname_like(String n_salschemeitemname_like) {
        this.n_salschemeitemname_like = n_salschemeitemname_like;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemname_like)){
            this.getSearchCond().like("salschemeitemname", n_salschemeitemname_like);
        }
    }
	private String n_salschemeitemid_eq;//[方案要素项标识]
	public void setN_salschemeitemid_eq(String n_salschemeitemid_eq) {
        this.n_salschemeitemid_eq = n_salschemeitemid_eq;
        if(!ObjectUtils.isEmpty(this.n_salschemeitemid_eq)){
            this.getSearchCond().eq("salschemeitemid", n_salschemeitemid_eq);
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
                     wrapper.like("salsalarydetailname", query)   
            );
		 }
	}
}




