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
import cn.ibizlab.ehr.core.common.domain.UserDictItem;
/**
 * 关系型数据实体[UserDictItem] 查询条件对象
 */
@Slf4j
@Data
public class UserDictItemSearchContext extends QueryWrapperContext<UserDictItem> {

	private String n_userdictitemname_like;//[词条名称]
	public void setN_userdictitemname_like(String n_userdictitemname_like) {
        this.n_userdictitemname_like = n_userdictitemname_like;
        if(!ObjectUtils.isEmpty(this.n_userdictitemname_like)){
            this.getSelectCond().like("userdictitemname", n_userdictitemname_like);
        }
    }
	private String n_userdictcatname_eq;//[词条类别]
	public void setN_userdictcatname_eq(String n_userdictcatname_eq) {
        this.n_userdictcatname_eq = n_userdictcatname_eq;
        if(!ObjectUtils.isEmpty(this.n_userdictcatname_eq)){
            this.getSelectCond().eq("userdictcatname", n_userdictcatname_eq);
        }
    }
	private String n_userdictcatname_like;//[词条类别]
	public void setN_userdictcatname_like(String n_userdictcatname_like) {
        this.n_userdictcatname_like = n_userdictcatname_like;
        if(!ObjectUtils.isEmpty(this.n_userdictcatname_like)){
            this.getSelectCond().like("userdictcatname", n_userdictcatname_like);
        }
    }
	private String n_userdictname_eq;//[用户词典]
	public void setN_userdictname_eq(String n_userdictname_eq) {
        this.n_userdictname_eq = n_userdictname_eq;
        if(!ObjectUtils.isEmpty(this.n_userdictname_eq)){
            this.getSelectCond().eq("userdictname", n_userdictname_eq);
        }
    }
	private String n_userdictname_like;//[用户词典]
	public void setN_userdictname_like(String n_userdictname_like) {
        this.n_userdictname_like = n_userdictname_like;
        if(!ObjectUtils.isEmpty(this.n_userdictname_like)){
            this.getSelectCond().like("userdictname", n_userdictname_like);
        }
    }
	private String n_userdictid_eq;//[用户词典]
	public void setN_userdictid_eq(String n_userdictid_eq) {
        this.n_userdictid_eq = n_userdictid_eq;
        if(!ObjectUtils.isEmpty(this.n_userdictid_eq)){
            this.getSelectCond().eq("userdictid", n_userdictid_eq);
        }
    }
	private String n_userdictcatid_eq;//[词条类别]
	public void setN_userdictcatid_eq(String n_userdictcatid_eq) {
        this.n_userdictcatid_eq = n_userdictcatid_eq;
        if(!ObjectUtils.isEmpty(this.n_userdictcatid_eq)){
            this.getSelectCond().eq("userdictcatid", n_userdictcatid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("userdictitemname",query);
		 }
	}
}




