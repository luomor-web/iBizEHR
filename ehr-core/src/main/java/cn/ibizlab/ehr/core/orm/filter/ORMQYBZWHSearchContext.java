package cn.ibizlab.ehr.core.orm.filter;

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
import cn.ibizlab.ehr.core.orm.domain.ORMQYBZWH;
/**
 * 关系型数据实体[ORMQYBZWH] 查询条件对象
 */
@Slf4j
@Data
public class ORMQYBZWHSearchContext extends QueryWrapperContext<ORMQYBZWH> {

	private String n_ormqybzwhname_eq;//[区域选择]
	public void setN_ormqybzwhname_eq(String n_ormqybzwhname_eq) {
        this.n_ormqybzwhname_eq = n_ormqybzwhname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormqybzwhname_eq)){
            this.getSelectCond().eq("ormqybzwhname", n_ormqybzwhname_eq);
        }
    }
	private String n_ormqybzwhname_like;//[区域选择]
	public void setN_ormqybzwhname_like(String n_ormqybzwhname_like) {
        this.n_ormqybzwhname_like = n_ormqybzwhname_like;
        if(!ObjectUtils.isEmpty(this.n_ormqybzwhname_like)){
            this.getSelectCond().like("ormqybzwhname", n_ormqybzwhname_like);
        }
    }
	private String n_ormorgname_eq;//[组织名称]
	public void setN_ormorgname_eq(String n_ormorgname_eq) {
        this.n_ormorgname_eq = n_ormorgname_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_eq)){
            this.getSelectCond().eq("ormorgname", n_ormorgname_eq);
        }
    }
	private String n_ormorgname_like;//[组织名称]
	public void setN_ormorgname_like(String n_ormorgname_like) {
        this.n_ormorgname_like = n_ormorgname_like;
        if(!ObjectUtils.isEmpty(this.n_ormorgname_like)){
            this.getSelectCond().like("ormorgname", n_ormorgname_like);
        }
    }
	private String n_ormorgid_eq;//[组织ID]
	public void setN_ormorgid_eq(String n_ormorgid_eq) {
        this.n_ormorgid_eq = n_ormorgid_eq;
        if(!ObjectUtils.isEmpty(this.n_ormorgid_eq)){
            this.getSelectCond().eq("ormorgid", n_ormorgid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("ormqybzwhname",query);
		 }
	}
}



