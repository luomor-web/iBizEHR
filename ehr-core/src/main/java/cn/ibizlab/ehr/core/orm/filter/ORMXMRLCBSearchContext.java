package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.ORMXMRLCB;
/**
 * 关系型数据实体[ORMXMRLCB] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ORMXMRLCBSearchContext extends QueryWrapperContext<ORMXMRLCB> {

	private String n_ormxmrlcbname_like;//[项目人力成本名称]
	public void setN_ormxmrlcbname_like(String n_ormxmrlcbname_like) {
        this.n_ormxmrlcbname_like = n_ormxmrlcbname_like;
        if(!ObjectUtils.isEmpty(this.n_ormxmrlcbname_like)){
            this.getSelectCond().like("ormxmrlcbname", n_ormxmrlcbname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("ormxmrlcbname",query);
		 }
	}
}




