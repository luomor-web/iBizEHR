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
import cn.ibizlab.ehr.core.pim.domain.PimStafftype;
/**
 * 关系型数据实体[PimStafftype] 查询条件对象
 */
@Slf4j
@Data
public class PimStafftypeSearchContext extends QueryWrapperContext<PimStafftype> {

	private String n_pimstafftypeid_eq;//[员工类型管理标识]
	public void setN_pimstafftypeid_eq(String n_pimstafftypeid_eq) {
        this.n_pimstafftypeid_eq = n_pimstafftypeid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimstafftypeid_eq)){
            this.getSearchCond().eq("pimstafftypeid", n_pimstafftypeid_eq);
        }
    }
	private String n_shgz_eq;//[入职审核规则]
	public void setN_shgz_eq(String n_shgz_eq) {
        this.n_shgz_eq = n_shgz_eq;
        if(!ObjectUtils.isEmpty(this.n_shgz_eq)){
            this.getSearchCond().eq("shgz", n_shgz_eq);
        }
    }
	private String n_pimstafftypename_like;//[员工类型管理名称]
	public void setN_pimstafftypename_like(String n_pimstafftypename_like) {
        this.n_pimstafftypename_like = n_pimstafftypename_like;
        if(!ObjectUtils.isEmpty(this.n_pimstafftypename_like)){
            this.getSearchCond().like("pimstafftypename", n_pimstafftypename_like);
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
                     wrapper.like("pimstafftypename", query)   
            );
		 }
	}
}




