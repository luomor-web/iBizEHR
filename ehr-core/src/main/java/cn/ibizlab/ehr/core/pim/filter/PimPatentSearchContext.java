package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PimPatent;
/**
 * 关系型数据实体[PimPatent] 查询条件对象
 */
@Slf4j
@Data
public class PimPatentSearchContext extends QueryWrapperContext<PimPatent> {

	private String n_pimpatentname_like;//[专利名称(*)]
	public void setN_pimpatentname_like(String n_pimpatentname_like) {
        this.n_pimpatentname_like = n_pimpatentname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpatentname_like)){
            this.getSearchCond().like("pimpatentname", n_pimpatentname_like);
        }
    }
	private String n_zlpzgb_eq;//[专利批准国别(*)]
	public void setN_zlpzgb_eq(String n_zlpzgb_eq) {
        this.n_zlpzgb_eq = n_zlpzgb_eq;
        if(!ObjectUtils.isEmpty(this.n_zlpzgb_eq)){
            this.getSearchCond().eq("zlpzgb", n_zlpzgb_eq);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSearchCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSearchCond().eq("pimpersonid", n_pimpersonid_eq);
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
                     wrapper.like("pimpatentname", query)   
            );
		 }
	}
}




