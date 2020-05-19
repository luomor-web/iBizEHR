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
import cn.ibizlab.ehr.core.common.domain.User;
/**
 * 关系型数据实体[User] 查询条件对象
 */
@Slf4j
@Data
public class UserSearchContext extends QueryWrapperContext<User> {

	private String n_username_like;//[用户名称]
	public void setN_username_like(String n_username_like) {
        this.n_username_like = n_username_like;
        if(!ObjectUtils.isEmpty(this.n_username_like)){
            this.getSelectCond().like("username", n_username_like);
        }
    }
	private String n_timezone_eq;//[所在时区]
	public void setN_timezone_eq(String n_timezone_eq) {
        this.n_timezone_eq = n_timezone_eq;
        if(!ObjectUtils.isEmpty(this.n_timezone_eq)){
            this.getSelectCond().eq("timezone", n_timezone_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("username",query);
		 }
	}
}




