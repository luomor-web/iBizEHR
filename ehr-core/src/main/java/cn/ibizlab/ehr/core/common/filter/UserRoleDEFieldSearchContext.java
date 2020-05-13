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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEField;
/**
 * 关系型数据实体[UserRoleDEField] 查询条件对象
 */
@Slf4j
@Data
public class UserRoleDEFieldSearchContext extends QueryWrapperContext<UserRoleDEField> {

	private String n_userroledefieldname_like;//[实体属性访问能力]
	public void setN_userroledefieldname_like(String n_userroledefieldname_like) {
        this.n_userroledefieldname_like = n_userroledefieldname_like;
        if(!ObjectUtils.isEmpty(this.n_userroledefieldname_like)){
            this.getSelectCond().like("userroledefieldname", n_userroledefieldname_like);
        }
    }
	private String n_defaction_eq;//[访问行为]
	public void setN_defaction_eq(String n_defaction_eq) {
        this.n_defaction_eq = n_defaction_eq;
        if(!ObjectUtils.isEmpty(this.n_defaction_eq)){
            this.getSelectCond().eq("defaction", n_defaction_eq);
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
			this.getSelectCond().or().like("userroledefieldname",query);
		 }
	}
}




