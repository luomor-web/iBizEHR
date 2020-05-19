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
import cn.ibizlab.ehr.core.pim.domain.PersonStateMGR;
/**
 * 关系型数据实体[PersonStateMGR] 查询条件对象
 */
@Slf4j
@Data
public class PersonStateMGRSearchContext extends QueryWrapperContext<PersonStateMGR> {

	private String n_personstatemgrname_like;//[员工状态管理名称]
	public void setN_personstatemgrname_like(String n_personstatemgrname_like) {
        this.n_personstatemgrname_like = n_personstatemgrname_like;
        if(!ObjectUtils.isEmpty(this.n_personstatemgrname_like)){
            this.getSelectCond().like("personstatemgrname", n_personstatemgrname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("personstatemgrname",query);
		 }
	}
}




