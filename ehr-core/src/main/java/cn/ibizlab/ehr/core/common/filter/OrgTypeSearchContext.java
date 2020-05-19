package cn.ibizlab.ehr.core.common.filter;

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
import cn.ibizlab.ehr.core.common.domain.OrgType;
/**
 * 关系型数据实体[OrgType] 查询条件对象
 */
@Slf4j
@Data
public class OrgTypeSearchContext extends QueryWrapperContext<OrgType> {

	private String n_orgtypename_like;//[组织类型名称]
	public void setN_orgtypename_like(String n_orgtypename_like) {
        this.n_orgtypename_like = n_orgtypename_like;
        if(!ObjectUtils.isEmpty(this.n_orgtypename_like)){
            this.getSelectCond().like("orgtypename", n_orgtypename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("orgtypename",query);
		 }
	}
}




