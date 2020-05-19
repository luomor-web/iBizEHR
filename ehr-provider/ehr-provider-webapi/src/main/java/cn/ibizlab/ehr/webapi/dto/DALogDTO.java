package cn.ibizlab.ehr.webapi.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import lombok.Data;

/**
 * 服务DTO对象[DALogDTO]
 */
@Data
public class DALogDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [LOGSN]
     *
     */
    @JSONField(name = "logsn")
    @JsonProperty("logsn")
    private Integer logsn;

    /**
     * 属性 [REMOTEADDR]
     *
     */
    @JSONField(name = "remoteaddr")
    @JsonProperty("remoteaddr")
    private String remoteaddr;

    /**
     * 属性 [DALOG_NAME]
     *
     */
    @JSONField(name = "dalog_name")
    @JsonProperty("dalog_name")
    private String dalogName;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [OBJECTTYPE]
     *
     */
    @JSONField(name = "objecttype")
    @JsonProperty("objecttype")
    private String objecttype;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [DALOG_ID]
     *
     */
    @JSONField(name = "dalog_id")
    @JsonProperty("dalog_id")
    private String dalogId;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [LOGINFO]
     *
     */
    @JSONField(name = "loginfo")
    @JsonProperty("loginfo")
    private String loginfo;

    /**
     * 属性 [OBJECTID]
     *
     */
    @JSONField(name = "objectid")
    @JsonProperty("objectid")
    private String objectid;

    /**
     * 属性 [LOGTYPE]
     *
     */
    @JSONField(name = "logtype")
    @JsonProperty("logtype")
    private String logtype;


    /**
     * 设置 [LOGSN]
     */
    public void setLogsn(Integer  logsn){
        this.logsn = logsn ;
        this.modify("logsn",logsn);
    }

    /**
     * 设置 [REMOTEADDR]
     */
    public void setRemoteaddr(String  remoteaddr){
        this.remoteaddr = remoteaddr ;
        this.modify("remoteaddr",remoteaddr);
    }

    /**
     * 设置 [DALOG_NAME]
     */
    public void setDalogName(String  dalogName){
        this.dalogName = dalogName ;
        this.modify("dalog_name",dalogName);
    }

    /**
     * 设置 [OBJECTTYPE]
     */
    public void setObjecttype(String  objecttype){
        this.objecttype = objecttype ;
        this.modify("objecttype",objecttype);
    }

    /**
     * 设置 [LOGINFO]
     */
    public void setLoginfo(String  loginfo){
        this.loginfo = loginfo ;
        this.modify("loginfo",loginfo);
    }

    /**
     * 设置 [OBJECTID]
     */
    public void setObjectid(String  objectid){
        this.objectid = objectid ;
        this.modify("objectid",objectid);
    }

    /**
     * 设置 [LOGTYPE]
     */
    public void setLogtype(String  logtype){
        this.logtype = logtype ;
        this.modify("logtype",logtype);
    }


}

