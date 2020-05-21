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
 * 实体[DA日志]
 */
@Data
@TableName(value = "T_DALOG",resultMap = "DALogResultMap")
public class DALog extends EntityMP implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志时间
     */
    @DEField(preType = DEPredefinedFieldType.CREATEDATE)
    @TableField(value = "createdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;
    /**
     * 日志序列
     */
    @DEField(defaultValue = "1")
    @TableField(value = "logsn")
    @JSONField(name = "logsn")
    @JsonProperty("logsn")
    private Integer logsn;
    /**
     * 远程地址
     */
    @TableField(value = "remoteaddr")
    @JSONField(name = "remoteaddr")
    @JsonProperty("remoteaddr")
    private String remoteaddr;
    /**
     * DA日志名称
     */
    @DEField(name = "dalog_name")
    @TableField(value = "dalog_name")
    @JSONField(name = "dalog_name")
    @JsonProperty("dalog_name")
    private String dalogName;
    /**
     * 更新人
     */
    @DEField(preType = DEPredefinedFieldType.UPDATEMAN)
    @TableField(value = "updateman")
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;
    /**
     * 对象类型
     */
    @TableField(value = "objecttype")
    @JSONField(name = "objecttype")
    @JsonProperty("objecttype")
    private String objecttype;
    /**
     * 建立人
     */
    @DEField(preType = DEPredefinedFieldType.CREATEMAN)
    @TableField(value = "createman" , fill = FieldFill.INSERT)
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;
    /**
     * DA日志标识
     */
    @DEField(name = "dalog_id" , isKeyField=true)
    @TableId(value= "dalog_id",type=IdType.UUID)
    @JSONField(name = "dalog_id")
    @JsonProperty("dalog_id")
    private String dalogId;
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
     * 日志信息
     */
    @TableField(value = "loginfo")
    @JSONField(name = "loginfo")
    @JsonProperty("loginfo")
    private String loginfo;
    /**
     * 对象标识
     */
    @TableField(value = "objectid")
    @JSONField(name = "objectid")
    @JsonProperty("objectid")
    private String objectid;
    /**
     * 日志类型
     */
    @TableField(value = "logtype")
    @JSONField(name = "logtype")
    @JsonProperty("logtype")
    private String logtype;



    /**
     * 设置 [日志序列]
     */
    public void setLogsn(Integer logsn){
        this.logsn = logsn ;
        this.modify("logsn",logsn);
    }
    /**
     * 设置 [远程地址]
     */
    public void setRemoteaddr(String remoteaddr){
        this.remoteaddr = remoteaddr ;
        this.modify("remoteaddr",remoteaddr);
    }
    /**
     * 设置 [DA日志名称]
     */
    public void setDalogName(String dalogName){
        this.dalogName = dalogName ;
        this.modify("dalog_name",dalogName);
    }
    /**
     * 设置 [对象类型]
     */
    public void setObjecttype(String objecttype){
        this.objecttype = objecttype ;
        this.modify("objecttype",objecttype);
    }
    /**
     * 设置 [日志信息]
     */
    public void setLoginfo(String loginfo){
        this.loginfo = loginfo ;
        this.modify("loginfo",loginfo);
    }
    /**
     * 设置 [对象标识]
     */
    public void setObjectid(String objectid){
        this.objectid = objectid ;
        this.modify("objectid",objectid);
    }
    /**
     * 设置 [日志类型]
     */
    public void setLogtype(String logtype){
        this.logtype = logtype ;
        this.modify("logtype",logtype);
    }

}


