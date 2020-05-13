package cn.ibizlab.ehr.core.pcm.filter;

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
import cn.ibizlab.ehr.core.pcm.domain.SGQMgr;
/**
 * 关系型数据实体[SGQMgr] 查询条件对象
 */
@Slf4j
@Data
public class SGQMgrSearchContext extends QueryWrapperContext<SGQMgr> {

	private String n_sgqmgrname_like;//[试岗期管理名称]
	public void setN_sgqmgrname_like(String n_sgqmgrname_like) {
        this.n_sgqmgrname_like = n_sgqmgrname_like;
        if(!ObjectUtils.isEmpty(this.n_sgqmgrname_like)){
            this.getSelectCond().like("sgqmgrname", n_sgqmgrname_like);
        }
    }
	private String n_pimpersonname_eq;//[员工姓名]
	public void setN_pimpersonname_eq(String n_pimpersonname_eq) {
        this.n_pimpersonname_eq = n_pimpersonname_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_eq)){
            this.getSelectCond().eq("pimpersonname", n_pimpersonname_eq);
        }
    }
	private String n_pimpersonname_like;//[员工姓名]
	public void setN_pimpersonname_like(String n_pimpersonname_like) {
        this.n_pimpersonname_like = n_pimpersonname_like;
        if(!ObjectUtils.isEmpty(this.n_pimpersonname_like)){
            this.getSelectCond().like("pimpersonname", n_pimpersonname_like);
        }
    }
	private String n_pimpersonid_eq;//[人员信息标识]
	public void setN_pimpersonid_eq(String n_pimpersonid_eq) {
        this.n_pimpersonid_eq = n_pimpersonid_eq;
        if(!ObjectUtils.isEmpty(this.n_pimpersonid_eq)){
            this.getSelectCond().eq("pimpersonid", n_pimpersonid_eq);
        }
    }
	private String n_pcmbdsqdmxid_eq;//[申请单明细标识]
	public void setN_pcmbdsqdmxid_eq(String n_pcmbdsqdmxid_eq) {
        this.n_pcmbdsqdmxid_eq = n_pcmbdsqdmxid_eq;
        if(!ObjectUtils.isEmpty(this.n_pcmbdsqdmxid_eq)){
            this.getSelectCond().eq("pcmbdsqdmxid", n_pcmbdsqdmxid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("sgqmgrname",query);
		 }
	}
}



