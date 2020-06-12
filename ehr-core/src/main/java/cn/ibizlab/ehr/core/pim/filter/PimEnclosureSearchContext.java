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
import cn.ibizlab.ehr.core.pim.domain.PimEnclosure;
/**
 * 关系型数据实体[PimEnclosure] 查询条件对象
 */
@Slf4j
@Data
public class PimEnclosureSearchContext extends QueryWrapperContext<PimEnclosure> {

	private String n_pimenclosurename_like;//[附件信息名称]
	public void setN_pimenclosurename_like(String n_pimenclosurename_like) {
        this.n_pimenclosurename_like = n_pimenclosurename_like;
        if(!ObjectUtils.isEmpty(this.n_pimenclosurename_like)){
            this.getSearchCond().like("pimenclosurename", n_pimenclosurename_like);
        }
    }
	private String n_fjfl_eq;//[附件分类]
	public void setN_fjfl_eq(String n_fjfl_eq) {
        this.n_fjfl_eq = n_fjfl_eq;
        if(!ObjectUtils.isEmpty(this.n_fjfl_eq)){
            this.getSearchCond().eq("fjfl", n_fjfl_eq);
        }
    }
	private String n_pimpersonname_eq;//[人员信息名称]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSearchCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[人员信息名称]
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
                     wrapper.like("pimenclosurename", query)   
            );
		 }
	}
}




