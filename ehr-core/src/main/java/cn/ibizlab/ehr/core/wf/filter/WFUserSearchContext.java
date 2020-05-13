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
import cn.ibizlab.ehr.core.wf.domain.WFUser;
/**
 * 关系型数据实体[WFUser] 查询条件对象
 */
@Slf4j
@Data
public class WFUserSearchContext extends QueryWrapperContext<WFUser> {

	private String n_wfusername_like;//[工作流用户名称]
	public void setN_wfusername_like(String n_wfusername_like) {
        this.n_wfusername_like = n_wfusername_like;
        if(!ObjectUtils.isEmpty(this.n_wfusername_like)){
            this.getSelectCond().like("wfusername", n_wfusername_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("wfusername",query);
		 }
	}
}




