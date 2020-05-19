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
import cn.ibizlab.ehr.core.common.domain.PortalPage;
/**
 * 关系型数据实体[PortalPage] 查询条件对象
 */
@Slf4j
@Data
public class PortalPageSearchContext extends QueryWrapperContext<PortalPage> {

	private String n_portalpagename_like;//[门户页面名称]
	public void setN_portalpagename_like(String n_portalpagename_like) {
        this.n_portalpagename_like = n_portalpagename_like;
        if(!ObjectUtils.isEmpty(this.n_portalpagename_like)){
            this.getSelectCond().like("portalpagename", n_portalpagename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("portalpagename",query);
		 }
	}
}




