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
import cn.ibizlab.ehr.core.pim.domain.PimNationMgr;
/**
 * 关系型数据实体[PimNationMgr] 查询条件对象
 */
@Slf4j
@Data
public class PimNationMgrSearchContext extends QueryWrapperContext<PimNationMgr> {

	private String n_nationmgrname_like;//[民族管理名称]
	public void setN_nationmgrname_like(String n_nationmgrname_like) {
        this.n_nationmgrname_like = n_nationmgrname_like;
        if(!ObjectUtils.isEmpty(this.n_nationmgrname_like)){
            this.getSearchCond().like("nationmgrname", n_nationmgrname_like);
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
                     wrapper.like("nationmgrname", query)   
            );
		 }
	}
}




