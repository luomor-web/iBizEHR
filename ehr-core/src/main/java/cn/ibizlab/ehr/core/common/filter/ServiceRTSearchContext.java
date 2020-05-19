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
import cn.ibizlab.ehr.core.common.domain.ServiceRT;
/**
 * 关系型数据实体[ServiceRT] 查询条件对象
 */
@Slf4j
@Data
public class ServiceRTSearchContext extends QueryWrapperContext<ServiceRT> {

	private String n_startmode_eq;//[启动模式]
	public void setN_startmode_eq(String n_startmode_eq) {
        this.n_startmode_eq = n_startmode_eq;
        if(!ObjectUtils.isEmpty(this.n_startmode_eq)){
            this.getSelectCond().eq("startmode", n_startmode_eq);
        }
    }
	private String n_servicename_like;//[服务名称]
	public void setN_servicename_like(String n_servicename_like) {
        this.n_servicename_like = n_servicename_like;
        if(!ObjectUtils.isEmpty(this.n_servicename_like)){
            this.getSelectCond().like("servicename", n_servicename_like);
        }
    }
	private String n_servicestate_eq;//[服务运行状态]
	public void setN_servicestate_eq(String n_servicestate_eq) {
        this.n_servicestate_eq = n_servicestate_eq;
        if(!ObjectUtils.isEmpty(this.n_servicestate_eq)){
            this.getSelectCond().eq("servicestate", n_servicestate_eq);
        }
    }
	private String n_container_eq;//[服务容器]
	public void setN_container_eq(String n_container_eq) {
        this.n_container_eq = n_container_eq;
        if(!ObjectUtils.isEmpty(this.n_container_eq)){
            this.getSelectCond().eq("container", n_container_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("servicename",query);
		 }
	}
}




