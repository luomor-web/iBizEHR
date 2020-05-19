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
import cn.ibizlab.ehr.core.common.domain.UserRole;
/**
 * 关系型数据实体[UserRole] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleSearchContext extends QueryWrapperContext<UserRole> {

	private String n_userrolename_like;//[用户角色名称]
	public void setN_userrolename_like(String n_userrolename_like) {
        this.n_userrolename_like = n_userrolename_like;
        if(!ObjectUtils.isEmpty(this.n_userrolename_like)){
            this.getSelectCond().like("userrolename", n_userrolename_like);
        }
    }
	private String n_userroletype_eq;//[用户角色类型]
	public void setN_userroletype_eq(String n_userroletype_eq) {
        this.n_userroletype_eq = n_userroletype_eq;
        if(!ObjectUtils.isEmpty(this.n_userroletype_eq)){
            this.getSelectCond().eq("userroletype", n_userroletype_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userrolename",query);
		 }
	}
}




