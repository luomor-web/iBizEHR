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
import cn.ibizlab.ehr.core.common.domain.MsgTemplate;
/**
 * 关系型数据实体[MsgTemplate] 查询条件对象
 */
@Slf4j
@Data
public class MsgTemplateSearchContext extends QueryWrapperContext<MsgTemplate> {

	private String n_msgtemplatename_like;//[消息模板名称]
	public void setN_msgtemplatename_like(String n_msgtemplatename_like) {
        this.n_msgtemplatename_like = n_msgtemplatename_like;
        if(!ObjectUtils.isEmpty(this.n_msgtemplatename_like)){
            this.getSelectCond().like("msgtemplatename", n_msgtemplatename_like);
        }
    }
	private String n_contenttype_eq;//[内容类型]
	public void setN_contenttype_eq(String n_contenttype_eq) {
        this.n_contenttype_eq = n_contenttype_eq;
        if(!ObjectUtils.isEmpty(this.n_contenttype_eq)){
            this.getSelectCond().eq("contenttype", n_contenttype_eq);
        }
    }
	private String n_dename_eq;//[数据实体]
	public void setN_dename_eq(String n_dename_eq) {
        this.n_dename_eq = n_dename_eq;
        if(!ObjectUtils.isEmpty(this.n_dename_eq)){
            this.getSelectCond().eq("dename", n_dename_eq);
        }
    }
	private String n_dename_like;//[数据实体]
	public void setN_dename_like(String n_dename_like) {
        this.n_dename_like = n_dename_like;
        if(!ObjectUtils.isEmpty(this.n_dename_like)){
            this.getSelectCond().like("dename", n_dename_like);
        }
    }
	private String n_deid_eq;//[数据实体]
	public void setN_deid_eq(String n_deid_eq) {
        this.n_deid_eq = n_deid_eq;
        if(!ObjectUtils.isEmpty(this.n_deid_eq)){
            this.getSelectCond().eq("deid", n_deid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("msgtemplatename",query);
		 }
	}
}




