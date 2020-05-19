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
import cn.ibizlab.ehr.core.common.domain.UserDGTheme;
/**
 * 关系型数据实体[UserDGTheme] 查询条件对象
 */
@Slf4j
@Data
public class UserDGThemeSearchContext extends QueryWrapperContext<UserDGTheme> {

	private String n_userdgthemename_like;//[表格列定义名称]
	public void setN_userdgthemename_like(String n_userdgthemename_like) {
        this.n_userdgthemename_like = n_userdgthemename_like;
        if(!ObjectUtils.isEmpty(this.n_userdgthemename_like)){
            this.getSelectCond().like("userdgthemename", n_userdgthemename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userdgthemename",query);
		 }
	}
}




