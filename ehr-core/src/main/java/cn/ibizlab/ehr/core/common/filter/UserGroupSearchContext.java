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
import cn.ibizlab.ehr.core.common.domain.UserGroup;
/**
 * 关系型数据实体[UserGroup] 查询条件对象
 */
@Slf4j
@Data
public class UserGroupSearchContext extends QueryWrapperContext<UserGroup> {

	private String n_usergroupname_like;//[用户组名称]
	public void setN_usergroupname_like(String n_usergroupname_like) {
        this.n_usergroupname_like = n_usergroupname_like;
        if(!ObjectUtils.isEmpty(this.n_usergroupname_like)){
            this.getSelectCond().like("usergroupname", n_usergroupname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("usergroupname",query);
		 }
	}
}




