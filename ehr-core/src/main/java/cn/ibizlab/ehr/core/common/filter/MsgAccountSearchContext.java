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
import cn.ibizlab.ehr.core.common.domain.MsgAccount;
/**
 * 关系型数据实体[MsgAccount] 查询条件对象
 */
@Slf4j
@Data
public class MsgAccountSearchContext extends QueryWrapperContext<MsgAccount> {

	private String n_msgaccountname_like;//[消息账户名称]
	public void setN_msgaccountname_like(String n_msgaccountname_like) {
        this.n_msgaccountname_like = n_msgaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_msgaccountname_like)){
            this.getSelectCond().like("msgaccountname", n_msgaccountname_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("msgaccountname",query);
		 }
	}
}




