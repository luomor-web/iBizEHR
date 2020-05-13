package cn.ibizlab.ehr.core.wf.filter;

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
import cn.ibizlab.ehr.core.wf.domain.WFSystemUser;
/**
 * 关系型数据实体[WFSystemUser] 查询条件对象
 */
@Slf4j
@Data
public class WFSystemUserSearchContext extends QueryWrapperContext<WFSystemUser> {

	private String n_wfsystemusername_like;//[工作流系统用户名称]
	public void setN_wfsystemusername_like(String n_wfsystemusername_like) {
        this.n_wfsystemusername_like = n_wfsystemusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfsystemusername_like)){
            this.getSelectCond().like("wfsystemusername", n_wfsystemusername_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfsystemusername",query);
		 }
	}
}




