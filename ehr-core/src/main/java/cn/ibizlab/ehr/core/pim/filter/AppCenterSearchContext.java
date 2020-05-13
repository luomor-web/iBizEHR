package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.AppCenter;
/**
 * 关系型数据实体[AppCenter] 查询条件对象
 */
@Slf4j
@Data
public class AppCenterSearchContext extends QueryWrapperContext<AppCenter> {

	private String n_appcentername_like;//[应用中心（工作流专用）名称]
	public void setN_appcentername_like(String n_appcentername_like) {
        this.n_appcentername_like = n_appcentername_like;
        if(!ObjectUtils.isEmpty(this.n_appcentername_like)){
            this.getSelectCond().like("appcentername", n_appcentername_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("appcentername",query);
		 }
	}
}




