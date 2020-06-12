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
import cn.ibizlab.ehr.core.orm.domain.OrmSignOrg;
/**
 * 关系型数据实体[OrmSignOrg] 查询条件对象
 */
@Slf4j
@Data
public class OrmSignOrgSearchContext extends QueryWrapperContext<OrmSignOrg> {

	private String n_orgcode_like;//[组织编号]
	public void setN_orgcode_like(String n_orgcode_like) {
        this.n_orgcode_like = n_orgcode_like;
        if(!ObjectUtils.isEmpty(this.n_orgcode_like)){
            this.getSearchCond().like("orgcode", n_orgcode_like);
        }
    }
	private String n_ormsignorgname_like;//[法人主体名称]
	public void setN_ormsignorgname_like(String n_ormsignorgname_like) {
        this.n_ormsignorgname_like = n_ormsignorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormsignorgname_like)){
            this.getSearchCond().like("ormsignorgname", n_ormsignorgname_like);
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
                     wrapper.like("ormsignorgname", query)   
            );
		 }
	}
}




