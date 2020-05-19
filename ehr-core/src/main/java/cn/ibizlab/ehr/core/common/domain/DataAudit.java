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
import org.springframework.util.ObjectUtils;
import org.springframework.util.DigestUtils;
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
 * 实体[数据审计]
 */
@Data
@TableName(value = "T_SRFDATAAUDIT",resultMap = "DataAuditResultMap")
public class DataAudit extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 对象类型
     */
    @TableField(value = "objecttype")
    @JSONField(name = "objecttype")
    @JsonProperty("objecttype")
    private String objecttype;
    /**
     * 审计明细
     */
    @TableField(value = "auditinfo")
    @JSONField(name = "auditinfo")
    @JsonProperty("auditinfo")
    private String auditinfo;
    /**
     * 操作时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 数据审计标识
     */
    @DEField(isKeyField=true)
    @TableId(value= "dataauditid",type=IdType.UUID)
    @JSONField(name = "dataauditid")
    @JsonProperty("dataauditid")
    private String dataauditid;
    /**
     * 行为类型
     */
    @TableField(value = "audittype")
    @JSONField(name = "audittype")
    @JsonProperty("audittype")
    private String audittype;
    /**
     * 审计条目
     */
    @TableField(value = "dataauditname")
    @JSONField(name = "dataauditname")
    @JsonProperty("dataauditname")
    private String dataauditname;
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
     * 对象编号
     */
    @TableField(value = "objectid")
    @JSONField(name = "objectid")
    @JsonProperty("objectid")
    private String objectid;
    /**
     * 操作人
     */
    @TableField(value = "oppersonname")
    @JSONField(name = "oppersonname")
    @JsonProperty("oppersonname")
    private String oppersonname;
    /**
     * 操作人
     */
    @TableField(value = "oppersonid")
    @JSONField(name = "oppersonid")
    @JsonProperty("oppersonid")
    private String oppersonid;
    /**
     * 访问地址
     */
    @TableField(value = "ipaddress")
    @JSONField(name = "ipaddress")
    @JsonProperty("ipaddress")
    private String ipaddress;
    /**
     * 访问标识
     */
    @TableField(value = "sessionid")
    @JSONField(name = "sessionid")
    @JsonProperty("sessionid")
    private String sessionid;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;



    /**
     * 设置 [对象类型]
     */
    public void setObjecttype(String objecttype){
        this.objecttype = objecttype ;
        this.modify("objecttype",objecttype);
    }
    /**
     * 设置 [审计明细]
     */
    public void setAuditinfo(String auditinfo){
        this.auditinfo = auditinfo ;
        this.modify("auditinfo",auditinfo);
    }
    /**
     * 设置 [行为类型]
     */
    public void setAudittype(String audittype){
        this.audittype = audittype ;
        this.modify("audittype",audittype);
    }
    /**
     * 设置 [审计条目]
     */
    public void setDataauditname(String dataauditname){
        this.dataauditname = dataauditname ;
        this.modify("dataauditname",dataauditname);
    }
    /**
     * 设置 [对象编号]
     */
    public void setObjectid(String objectid){
        this.objectid = objectid ;
        this.modify("objectid",objectid);
    }
    /**
     * 设置 [操作人]
     */
    public void setOppersonname(String oppersonname){
        this.oppersonname = oppersonname ;
        this.modify("oppersonname",oppersonname);
    }
    /**
     * 设置 [操作人]
     */
    public void setOppersonid(String oppersonid){
        this.oppersonid = oppersonid ;
        this.modify("oppersonid",oppersonid);
    }
    /**
     * 设置 [访问地址]
     */
    public void setIpaddress(String ipaddress){
        this.ipaddress = ipaddress ;
        this.modify("ipaddress",ipaddress);
    }
    /**
     * 设置 [访问标识]
     */
    public void setSessionid(String sessionid){
        this.sessionid = sessionid ;
        this.modify("sessionid",sessionid);
    }

}


