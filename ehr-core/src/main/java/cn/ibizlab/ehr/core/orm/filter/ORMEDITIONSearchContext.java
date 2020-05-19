package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.ORMEDITION;
/**
 * 关系型数据实体[ORMEDITION] 查询条件对象
 */
@Slf4j
@Data
public class ORMEDITIONSearchContext extends QueryWrapperContext<ORMEDITION> {

	private String n_ormeditionname_like;//[版本对照表名称]
	public void setN_ormeditionname_like(String n_ormeditionname_like) {
        this.n_ormeditionname_like = n_ormeditionname_like;
        if(!ObjectUtils.isEmpty(this.n_ormeditionname_like)){
            this.getSelectCond().like("ormeditionname", n_ormeditionname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("ormeditionname",query);
		 }
	}
}




