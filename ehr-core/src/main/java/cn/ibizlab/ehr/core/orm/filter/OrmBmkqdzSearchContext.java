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
import cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz;
/**
 * 关系型数据实体[OrmBmkqdz] 查询条件对象
 */
@Slf4j
@Data
public class OrmBmkqdzSearchContext extends QueryWrapperContext<OrmBmkqdz> {

	private String n_ormbmkqdzname_like;//[部门地址]
	public void setN_ormbmkqdzname_like(String n_ormbmkqdzname_like) {
        this.n_ormbmkqdzname_like = n_ormbmkqdzname_like;
        if(!ObjectUtils.isEmpty(this.n_ormbmkqdzname_like)){
            this.getSearchCond().like("ormbmkqdzname", n_ormbmkqdzname_like);
        }
    }
	private String n_sfmrkqdz_eq;//[默认考勤地址]
	public void setN_sfmrkqdz_eq(String n_sfmrkqdz_eq) {
        this.n_sfmrkqdz_eq = n_sfmrkqdz_eq;
        if(!ObjectUtils.isEmpty(this.n_sfmrkqdz_eq)){
            this.getSearchCond().eq("sfmrkqdz", n_sfmrkqdz_eq);
        }
    }
	private String n_ormorgsectorname_eq;//[部门名称]
	public void setN_ormorgsectorname_eq(String n_ormorgsectorname_eq) {
        this.n_ormorgsectorname_eq = n_ormorgsectorname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_eq)){
            this.getSearchCond().eq("ormorgsectorname", n_ormorgsectorname_eq);
        }
    }
	private String n_ormorgsectorname_like;//[部门名称]
	public void setN_ormorgsectorname_like(String n_ormorgsectorname_like) {
        this.n_ormorgsectorname_like = n_ormorgsectorname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorname_like)){
            this.getSearchCond().like("ormorgsectorname", n_ormorgsectorname_like);
        }
    }
	private String n_ormorgsectorid_eq;//[部门ID]
	public void setN_ormorgsectorid_eq(String n_ormorgsectorid_eq) {
        this.n_ormorgsectorid_eq = n_ormorgsectorid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgsectorid_eq)){
            this.getSearchCond().eq("ormorgsectorid", n_ormorgsectorid_eq);
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
                     wrapper.like("ormbmkqdzname", query)   
            );
		 }
	}
}




