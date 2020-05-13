package cn.ibizlab.ehr.core.demodel.filter;

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
import cn.ibizlab.ehr.core.demodel.domain.DataEntity;
/**
 * 关系型数据实体[DataEntity] 查询条件对象
 */
@Slf4j
@Data
public class DataEntitySearchContext extends QueryWrapperContext<DataEntity> {

	private String n_degroup_eq;//[实体归属]
	public void setN_degroup_eq(String n_degroup_eq) {
        this.n_degroup_eq = n_degroup_eq;
        if(!ObjectUtils.isEmpty(this.n_degroup_eq)){
            this.getSelectCond().eq("degroup", n_degroup_eq);
        }
    }
	private String n_dename_like;//[实体名称]
	public void setN_dename_like(String n_dename_like) {
        this.n_dename_like = n_dename_like;
        if(!ObjectUtils.isEmpty(this.n_dename_like)){
            this.getSelectCond().like("dename", n_dename_like);
        }
    }
	private Integer n_detype_eq;//[实体类型]
	public void setN_detype_eq(Integer n_detype_eq) {
        this.n_detype_eq = n_detype_eq;
        if(!ObjectUtils.isEmpty(this.n_detype_eq)){
            this.getSelectCond().eq("detype", n_detype_eq);
        }
    }
	private String n_printfunc_eq;//[打印功能]
	public void setN_printfunc_eq(String n_printfunc_eq) {
        this.n_printfunc_eq = n_printfunc_eq;
        if(!ObjectUtils.isEmpty(this.n_printfunc_eq)){
            this.getSelectCond().eq("printfunc", n_printfunc_eq);
        }
    }
	private Integer n_indexmode_eq;//[索引模式]
	public void setN_indexmode_eq(Integer n_indexmode_eq) {
        this.n_indexmode_eq = n_indexmode_eq;
        if(!ObjectUtils.isEmpty(this.n_indexmode_eq)){
            this.getSelectCond().eq("indexmode", n_indexmode_eq);
        }
    }
	private String n_storagetype_eq;//[实体存储类型]
	public void setN_storagetype_eq(String n_storagetype_eq) {
        this.n_storagetype_eq = n_storagetype_eq;
        if(!ObjectUtils.isEmpty(this.n_storagetype_eq)){
            this.getSelectCond().eq("storagetype", n_storagetype_eq);
        }
    }
	private Integer n_datachglogmode_eq;//[数据变更日志类型]
	public void setN_datachglogmode_eq(Integer n_datachglogmode_eq) {
        this.n_datachglogmode_eq = n_datachglogmode_eq;
        if(!ObjectUtils.isEmpty(this.n_datachglogmode_eq)){
            this.getSelectCond().eq("datachglogmode", n_datachglogmode_eq);
        }
    }
	private String n_tablespace_eq;//[实体表空间]
	public void setN_tablespace_eq(String n_tablespace_eq) {
        this.n_tablespace_eq = n_tablespace_eq;
        if(!ObjectUtils.isEmpty(this.n_tablespace_eq)){
            this.getSelectCond().eq("tablespace", n_tablespace_eq);
        }
    }
	private String n_dbstorage_eq;//[数据库存储]
	public void setN_dbstorage_eq(String n_dbstorage_eq) {
        this.n_dbstorage_eq = n_dbstorage_eq;
        if(!ObjectUtils.isEmpty(this.n_dbstorage_eq)){
            this.getSelectCond().eq("dbstorage", n_dbstorage_eq);
        }
    }
	private String n_acsortdir_eq;//[自动排序方向]
	public void setN_acsortdir_eq(String n_acsortdir_eq) {
        this.n_acsortdir_eq = n_acsortdir_eq;
        if(!ObjectUtils.isEmpty(this.n_acsortdir_eq)){
            this.getSelectCond().eq("acsortdir", n_acsortdir_eq);
        }
    }
	private String n_der11dename_eq;//[DER11DENAME]
	public void setN_der11dename_eq(String n_der11dename_eq) {
        this.n_der11dename_eq = n_der11dename_eq;
        if(!ObjectUtils.isEmpty(this.n_der11dename_eq)){
            this.getSelectCond().eq("der11dename", n_der11dename_eq);
        }
    }
	private String n_der11dename_like;//[DER11DENAME]
	public void setN_der11dename_like(String n_der11dename_like) {
        this.n_der11dename_like = n_der11dename_like;
        if(!ObjectUtils.isEmpty(this.n_der11dename_like)){
            this.getSelectCond().like("der11dename", n_der11dename_like);
        }
    }
	private String n_acquerymodelname_eq;//[自填查询模型]
	public void setN_acquerymodelname_eq(String n_acquerymodelname_eq) {
        this.n_acquerymodelname_eq = n_acquerymodelname_eq;
        if(!ObjectUtils.isEmpty(this.n_acquerymodelname_eq)){
            this.getSelectCond().eq("acquerymodelname", n_acquerymodelname_eq);
        }
    }
	private String n_acquerymodelname_like;//[自填查询模型]
	public void setN_acquerymodelname_like(String n_acquerymodelname_like) {
        this.n_acquerymodelname_like = n_acquerymodelname_like;
        if(!ObjectUtils.isEmpty(this.n_acquerymodelname_like)){
            this.getSelectCond().like("acquerymodelname", n_acquerymodelname_like);
        }
    }
	private String n_acquerymodelid_eq;//[数据实体_自填查询模型]
	public void setN_acquerymodelid_eq(String n_acquerymodelid_eq) {
        this.n_acquerymodelid_eq = n_acquerymodelid_eq;
        if(!ObjectUtils.isEmpty(this.n_acquerymodelid_eq)){
            this.getSelectCond().eq("acquerymodelid", n_acquerymodelid_eq);
        }
    }
	private String n_der11deid_eq;//[1:1关系实体]
	public void setN_der11deid_eq(String n_der11deid_eq) {
        this.n_der11deid_eq = n_der11deid_eq;
        if(!ObjectUtils.isEmpty(this.n_der11deid_eq)){
            this.getSelectCond().eq("der11deid", n_der11deid_eq);
        }
    }

    /**
	 * 启用快速搜索
	 */
	public void setQuery(String query)
	{
		 this.query=query;
		 if(!StringUtils.isEmpty(query)){
			this.getSelectCond().or().like("dename",query);
		 }
	}
}




