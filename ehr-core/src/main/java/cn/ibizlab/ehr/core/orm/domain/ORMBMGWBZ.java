package cn.ibizlab.ehr.core.orm.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import java.math.BigDecimal;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Transient;


import com.baomidou.mybatisplus.annotation.*;
import cn.ibizlab.ehr.util.domain.EntityMP;

/**
 * 实体[部门岗位编制]
 */
@Data
@TableName(value = "T_ORMBMGWBZ",resultMap = "ORMBMGWBZResultMap")
public class ORMBMGWBZ extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位职责说明
     */
    @TableField(value = "gwzzsm")
    @JSONField(name = "gwzzsm")
    @JsonProperty("gwzzsm")
    private String gwzzsm;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 部门岗位编制标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "ormbmgwbzid",type=IdType.UUID)
    @JSONField(name = "ormbmgwbzid")
    @JsonProperty("ormbmgwbzid")
    private String ormbmgwbzid;
    /**
     * 建立时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 排序号
     */
    @TableField(value = "xh")
    @JSONField(name = "xh")
    @JsonProperty("xh")
    private Integer xh;
    /**
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 人数编制
     */
    @TableField(value = "numcompilation")
    @JSONField(name = "numcompilation")
    @JsonProperty("numcompilation")
    private Integer numcompilation;
    /**
     * 部门岗位编制名称
     */
    @TableField(value = "ormbmgwbzname")
    @JSONField(name = "ormbmgwbzname")
    @JsonProperty("ormbmgwbzname")
    private String ormbmgwbzname;
    /**
     * 岗位
     */
    @TableField(exist = false)
    @JSONField(name = "ormpostname")
    @JsonProperty("ormpostname")
    private String ormpostname;
    /**
     * 岗位编制
     */
    @TableField(exist = false)
    @JSONField(name = "ormgwbzmc")
    @JsonProperty("ormgwbzmc")
    private String ormgwbzmc;
    /**
     * 岗位ID
     */
    @TableField(value = "ormpostid")
    @JSONField(name = "ormpostid")
    @JsonProperty("ormpostid")
    private String ormpostid;
    /**
     * 岗位编制ID
     */
    @TableField(value = "ormgwbzid")
    @JSONField(name = "ormgwbzid")
    @JsonProperty("ormgwbzid")
    private String ormgwbzid;

    /**
     * 岗位编制
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.ORMORGSECTOR ormgwbz;

    /**
     * 岗位
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.orm.domain.ORMPOST ormpost;



    /**
     * 设置 [岗位职责说明]
     */
    public void setGwzzsm(String gwzzsm){
        this.gwzzsm = gwzzsm ;
        this.modify("gwzzsm",gwzzsm);
    }
    /**
     * 设置 [排序号]
     */
    public void setXh(Integer xh){
        this.xh = xh ;
        this.modify("xh",xh);
    }
    /**
     * 设置 [人数编制]
     */
    public void setNumcompilation(Integer numcompilation){
        this.numcompilation = numcompilation ;
        this.modify("numcompilation",numcompilation);
    }
    /**
     * 设置 [部门岗位编制名称]
     */
    public void setOrmbmgwbzname(String ormbmgwbzname){
        this.ormbmgwbzname = ormbmgwbzname ;
        this.modify("ormbmgwbzname",ormbmgwbzname);
    }
    /**
     * 设置 [岗位ID]
     */
    public void setOrmpostid(String ormpostid){
        this.ormpostid = ormpostid ;
        this.modify("ormpostid",ormpostid);
    }
    /**
     * 设置 [岗位编制ID]
     */
    public void setOrmgwbzid(String ormgwbzid){
        this.ormgwbzid = ormgwbzid ;
        this.modify("ormgwbzid",ormgwbzid);
    }
}





