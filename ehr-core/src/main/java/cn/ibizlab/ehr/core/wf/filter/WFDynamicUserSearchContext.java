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
import cn.ibizlab.ehr.core.wf.domain.WFDynamicUser;
/**
 * 关系型数据实体[WFDynamicUser] 查询条件对象
 */
@Slf4j
@Data
public class WFDynamicUserSearchContext extends QueryWrapperContext<WFDynamicUser> {

	private String n_wfdynamicusername_like;//[工作流动态用户名称]
	public void setN_wfdynamicusername_like(String n_wfdynamicusername_like) {
        this.n_wfdynamicusername_like = n_wfdynamicusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfdynamicusername_like)){
            this.getSelectCond().like("wfdynamicusername", n_wfdynamicusername_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfdynamicusername",query);
		 }
	}
}




