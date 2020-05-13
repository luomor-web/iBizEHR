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
import cn.ibizlab.ehr.core.common.domain.MsgAccountDetail;
/**
 * 关系型数据实体[MsgAccountDetail] 查询条件对象
 */
@Slf4j
@Data
public class MsgAccountDetailSearchContext extends QueryWrapperContext<MsgAccountDetail> {

	private String n_msgaccountdetailname_like;//[组消息账户明细名称]
	public void setN_msgaccountdetailname_like(String n_msgaccountdetailname_like) {
        this.n_msgaccountdetailname_like = n_msgaccountdetailname_like;
        if(!ObjectUtils.isEmpty(this.n_msgaccountdetailname_like)){
            this.getSelectCond().like("msgaccountdetailname", n_msgaccountdetailname_like);
        }
    }
	private String n_majormsgaccountname_eq;//[组账户]
	public void setN_majormsgaccountname_eq(String n_majormsgaccountname_eq) {
        this.n_majormsgaccountname_eq = n_majormsgaccountname_eq;
        if(!ObjectUtils.isEmpty(this.n_majormsgaccountname_eq)){
            this.getSelectCond().eq("majormsgaccountname", n_majormsgaccountname_eq);
        }
    }
	private String n_majormsgaccountname_like;//[组账户]
	public void setN_majormsgaccountname_like(String n_majormsgaccountname_like) {
        this.n_majormsgaccountname_like = n_majormsgaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_majormsgaccountname_like)){
            this.getSelectCond().like("majormsgaccountname", n_majormsgaccountname_like);
        }
    }
	private String n_minormsgaccountname_eq;//[包含账户]
	public void setN_minormsgaccountname_eq(String n_minormsgaccountname_eq) {
        this.n_minormsgaccountname_eq = n_minormsgaccountname_eq;
        if(!ObjectUtils.isEmpty(this.n_minormsgaccountname_eq)){
            this.getSelectCond().eq("minormsgaccountname", n_minormsgaccountname_eq);
        }
    }
	private String n_minormsgaccountname_like;//[包含账户]
	public void setN_minormsgaccountname_like(String n_minormsgaccountname_like) {
        this.n_minormsgaccountname_like = n_minormsgaccountname_like;
        if(!ObjectUtils.isEmpty(this.n_minormsgaccountname_like)){
            this.getSelectCond().like("minormsgaccountname", n_minormsgaccountname_like);
        }
    }
	private String n_majormsgaccountid_eq;//[组消息账户_组账户]
	public void setN_majormsgaccountid_eq(String n_majormsgaccountid_eq) {
        this.n_majormsgaccountid_eq = n_majormsgaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_majormsgaccountid_eq)){
            this.getSelectCond().eq("majormsgaccountid", n_majormsgaccountid_eq);
        }
    }
	private String n_minormsgaccountid_eq;//[组消息账户_明细账户]
	public void setN_minormsgaccountid_eq(String n_minormsgaccountid_eq) {
        this.n_minormsgaccountid_eq = n_minormsgaccountid_eq;
        if(!ObjectUtils.isEmpty(this.n_minormsgaccountid_eq)){
            this.getSelectCond().eq("minormsgaccountid", n_minormsgaccountid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("msgaccountdetailname",query);
		 }
	}
}




