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
import cn.ibizlab.ehr.core.common.domain.DEDataChgDisp;
/**
 * 关系型数据实体[DEDataChgDisp] 查询条件对象
 */
@Slf4j
@Data
public class DEDataChgDispSearchContext extends QueryWrapperContext<DEDataChgDisp> {

	private String n_dedatachgdispname_like;//[数据变更派发引擎]
	public void setN_dedatachgdispname_like(String n_dedatachgdispname_like) {
        this.n_dedatachgdispname_like = n_dedatachgdispname_like;
        if(!ObjectUtils.isEmpty(this.n_dedatachgdispname_like)){
            this.getSelectCond().like("dedatachgdispname", n_dedatachgdispname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("dedatachgdispname",query);
		 }
	}
}




