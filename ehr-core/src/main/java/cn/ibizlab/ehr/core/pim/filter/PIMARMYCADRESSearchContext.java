package cn.ibizlab.ehr.core.pim.filter;

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
import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
/**
 * 关系型数据实体[PIMARMYCADRES] 查询条件对象
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PIMARMYCADRESSearchContext extends QueryWrapperContext<PIMARMYCADRES> {

	private String n_pimarmycadresname_like;//[军转干部名称]
	public void setN_pimarmycadresname_like(String n_pimarmycadresname_like) {
        this.n_pimarmycadresname_like = n_pimarmycadresname_like;
        if(!ObjectUtils.isEmpty(this.n_pimarmycadresname_like)){
            this.getSelectCond().like("pimarmycadresname", n_pimarmycadresname_like);
        }
    }
	private String n_trooptype_eq;//[类型(*)]
	public void setN_trooptype_eq(String n_trooptype_eq) {
        this.n_trooptype_eq = n_trooptype_eq;
        if(!ObjectUtils.isEmpty(this.n_trooptype_eq)){
            this.getSelectCond().eq("trooptype", n_trooptype_eq);
        }
    }
	private String n_leveltype_eq;//[级别(*)]
	public void setN_leveltype_eq(String n_leveltype_eq) {
        this.n_leveltype_eq = n_leveltype_eq;
        if(!ObjectUtils.isEmpty(this.n_leveltype_eq)){
            this.getSelectCond().eq("leveltype", n_leveltype_eq);
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

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("pimarmycadresname",query);
		 }
	}
}




