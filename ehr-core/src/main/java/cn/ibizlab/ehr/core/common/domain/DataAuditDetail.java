package cn.ibizlab.ehr.core.common.domain;

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
 * 实体[数据审计明细]
 */
@Data
@TableName(value = "T_SRFDATAAUDITDETAIL",resultMap = "DataAuditDetailResultMap")
public class DataAuditDetail extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据审计明细标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "dataauditdetailid",type=IdType.UUID)
    @JSONField(name = "dataauditdetailid")
    @JsonProperty("dataauditdetailid")
    private String dataauditdetailid;
    /**
     * 属性
     */
    @TableField(value = "dataauditdetailname")
    @JSONField(name = "dataauditdetailname")
    @JsonProperty("dataauditdetailname")
    private String dataauditdetailname;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 原值（文本）
     */
    @TableField(value = "oldtext")
    @JSONField(name = "oldtext")
    @JsonProperty("oldtext")
    private String oldtext;
    /**
     * 原值
     */
    @TableField(value = "oldvalue")
    @JSONField(name = "oldvalue")
    @JsonProperty("oldvalue")
    private String oldvalue;
    /**
     * 新值
     */
    @TableField(value = "newvalue")
    @JSONField(name = "newvalue")
    @JsonProperty("newvalue")
    private String newvalue;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
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
     * 更新时间
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEDATE)
    @TableField(value = "updatedate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;
    /**
     * 新值（文本）
     */
    @TableField(value = "newtext")
    @JSONField(name = "newtext")
    @JsonProperty("newtext")
    private String newtext;
    /**
     * 数据审计
     */
    @TableField(value = "dataauditname")
    @JSONField(name = "dataauditname")
    @JsonProperty("dataauditname")
    private String dataauditname;
    /**
     * 数据审计
     */
    @TableField(value = "dataauditid")
    @JSONField(name = "dataauditid")
    @JsonProperty("dataauditid")
    private String dataauditid;

    /**
     * 
     */
    @JsonIgnore
    @JSONField(serialize = false)
    @TableField(exist = false)
    private cn.ibizlab.ehr.core.common.domain.DataAudit dataaudit;



    /**
     * 设置 [属性]
     */
    public void setDataauditdetailname(String dataauditdetailname){
        this.dataauditdetailname = dataauditdetailname ;
        this.modify("dataauditdetailname",dataauditdetailname);
    }
    /**
     * 设置 [原值（文本）]
     */
    public void setOldtext(String oldtext){
        this.oldtext = oldtext ;
        this.modify("oldtext",oldtext);
    }
    /**
     * 设置 [原值]
     */
    public void setOldvalue(String oldvalue){
        this.oldvalue = oldvalue ;
        this.modify("oldvalue",oldvalue);
    }
    /**
     * 设置 [新值]
     */
    public void setNewvalue(String newvalue){
        this.newvalue = newvalue ;
        this.modify("newvalue",newvalue);
    }
    /**
     * 设置 [新值（文本）]
     */
    public void setNewtext(String newtext){
        this.newtext = newtext ;
        this.modify("newtext",newtext);
    }
    /**
     * 设置 [数据审计]
     */
    public void setDataauditname(String dataauditname){
        this.dataauditname = dataauditname ;
        this.modify("dataauditname",dataauditname);
    }
    /**
     * 设置 [数据审计]
     */
    public void setDataauditid(String dataauditid){
        this.dataauditid = dataauditid ;
        this.modify("dataauditid",dataauditid);
    }
}






