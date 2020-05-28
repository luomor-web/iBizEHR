package cn.ibizlab.ehr.core.vac.filter;

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
import cn.ibizlab.ehr.core.vac.domain.VACWORKDAY;
/**
 * 关系型数据实体[VACWORKDAY] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VACWORKDAYSearchContext extends QueryWrapperContext<VACWORKDAY> {

	private String n_nd_eq;//[年度]
	public void setN_nd_eq(String n_nd_eq) {
        this.n_nd_eq = n_nd_eq;
        if(!ObjectUtils.isEmpty(this.n_nd_eq)){
            this.getSelectCond().eq("nd", n_nd_eq);
        }
    }
	private String n_vacworkdayname_eq;//[工作日]
	public void setN_vacworkdayname_eq(String n_vacworkdayname_eq) {
        this.n_vacworkdayname_eq = n_vacworkdayname_eq;
        if(!ObjectUtils.isEmpty(this.n_vacworkdayname_eq)){
            this.getSelectCond().eq("vacworkdayname", n_vacworkdayname_eq);
        }
    }
	private String n_vacworkdayname_like;//[工作日]
	public void setN_vacworkdayname_like(String n_vacworkdayname_like) {
        this.n_vacworkdayname_like = n_vacworkdayname_like;
        if(!ObjectUtils.isEmpty(this.n_vacworkdayname_like)){
            this.getSelectCond().like("vacworkdayname", n_vacworkdayname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("vacworkdayname",query);
		 }
	}
}




