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
import cn.ibizlab.ehr.core.common.domain.UserObject;
/**
 * 关系型数据实体[UserObject] 查询条件对象
 */
@Slf4j
@Data
public class UserObjectSearchContext extends QueryWrapperContext<UserObject> {

	private String n_userobjecttype_eq;//[用户对象类型]
	public void setN_userobjecttype_eq(String n_userobjecttype_eq) {
        this.n_userobjecttype_eq = n_userobjecttype_eq;
        if(!ObjectUtils.isEmpty(this.n_userobjecttype_eq)){
            this.getSelectCond().eq("userobjecttype", n_userobjecttype_eq);
        }
    }
	private String n_userobjectname_like;//[用户对象名称]
	public void setN_userobjectname_like(String n_userobjectname_like) {
        this.n_userobjectname_like = n_userobjectname_like;
        if(!ObjectUtils.isEmpty(this.n_userobjectname_like)){
            this.getSelectCond().like("userobjectname", n_userobjectname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userobjectname",query);
		 }
	}
}




