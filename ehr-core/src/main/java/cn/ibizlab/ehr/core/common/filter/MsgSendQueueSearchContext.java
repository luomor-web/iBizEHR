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
import cn.ibizlab.ehr.core.common.domain.MsgSendQueue;
/**
 * 关系型数据实体[MsgSendQueue] 查询条件对象
 */
@Slf4j
@Data
public class MsgSendQueueSearchContext extends QueryWrapperContext<MsgSendQueue> {

	private Integer n_msgtype_eq;//[消息类型]
	public void setN_msgtype_eq(Integer n_msgtype_eq) {
        this.n_msgtype_eq = n_msgtype_eq;
        if(!ObjectUtils.isEmpty(this.n_msgtype_eq)){
            this.getSelectCond().eq("msgtype", n_msgtype_eq);
        }
    }
	private String n_contenttype_eq;//[内容类型]
	public void setN_contenttype_eq(String n_contenttype_eq) {
        this.n_contenttype_eq = n_contenttype_eq;
        if(!ObjectUtils.isEmpty(this.n_contenttype_eq)){
            this.getSelectCond().eq("contenttype", n_contenttype_eq);
        }
    }
	private Integer n_importanceflag_eq;//[重要程度]
	public void setN_importanceflag_eq(Integer n_importanceflag_eq) {
        this.n_importanceflag_eq = n_importanceflag_eq;
        if(!ObjectUtils.isEmpty(this.n_importanceflag_eq)){
            this.getSelectCond().eq("importanceflag", n_importanceflag_eq);
        }
    }
	private String n_msgsendqueuename_like;//[消息发送队列名称]
	public void setN_msgsendqueuename_like(String n_msgsendqueuename_like) {
        this.n_msgsendqueuename_like = n_msgsendqueuename_like;
        if(!ObjectUtils.isEmpty(this.n_msgsendqueuename_like)){
            this.getSelectCond().like("msgsendqueuename", n_msgsendqueuename_like);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("msgsendqueuename",query);
		 }
	}
}




