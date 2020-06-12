package cn.ibizlab.ehr.core.vac.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.ibizlab.ehr.core.vac.domain.VacDayOff;
/**
 * 关系型数据实体[VacDayOff] 查询条件对象
 */
@Slf4j
@Data
public class VacDayOffSearchContext extends QueryWrapperContext<VacDayOff> {

	private String n_vacdayoffname_like;//[调休上班名称]
	public void setN_vacdayoffname_like(String n_vacdayoffname_like) {
        this.n_vacdayoffname_like = n_vacdayoffname_like;
        if(!ObjectUtils.isEmpty(this.n_vacdayoffname_like)){
            this.getSearchCond().like("vacdayoffname", n_vacdayoffname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
            this.getSearchCond().and( wrapper ->
                     wrapper.like("vacdayoffname", query)   
            );
		 }
	}
}




