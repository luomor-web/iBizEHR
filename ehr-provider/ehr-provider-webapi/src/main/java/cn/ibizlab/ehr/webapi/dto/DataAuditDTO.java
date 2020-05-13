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
 * 服务DTO对象[DataAuditDTO]
 */
@Data
public class DataAuditDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [OBJECTTYPE]
     *
     */
    @JSONField(name = "objecttype")
    @JsonProperty("objecttype")
    private String objecttype;

    /**
     * 属性 [AUDITINFO]
     *
     */
    @JSONField(name = "auditinfo")
    @JsonProperty("auditinfo")
    private String auditinfo;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [DATAAUDITID]
     *
     */
    @JSONField(name = "dataauditid")
    @JsonProperty("dataauditid")
    private String dataauditid;

    /**
     * 属性 [AUDITTYPE]
     *
     */
    @JSONField(name = "audittype")
    @JsonProperty("audittype")
    private String audittype;

    /**
     * 属性 [DATAAUDITNAME]
     *
     */
    @JSONField(name = "dataauditname")
    @JsonProperty("dataauditname")
    private String dataauditname;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [OBJECTID]
     *
     */
    @JSONField(name = "objectid")
    @JsonProperty("objectid")
    private String objectid;

    /**
     * 属性 [OPPERSONNAME]
     *
     */
    @JSONField(name = "oppersonname")
    @JsonProperty("oppersonname")
    private String oppersonname;

    /**
     * 属性 [OPPERSONID]
     *
     */
    @JSONField(name = "oppersonid")
    @JsonProperty("oppersonid")
    private String oppersonid;

    /**
     * 属性 [IPADDRESS]
     *
     */
    @JSONField(name = "ipaddress")
    @JsonProperty("ipaddress")
    private String ipaddress;

    /**
     * 属性 [SESSIONID]
     *
     */
    @JSONField(name = "sessionid")
    @JsonProperty("sessionid")
    private String sessionid;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;


    /**
     * 设置 [OBJECTTYPE]
     */
    public void setObjecttype(String  objecttype){
        this.objecttype = objecttype ;
        this.modify("objecttype",objecttype);
    }

    /**
     * 设置 [AUDITINFO]
     */
    public void setAuditinfo(String  auditinfo){
        this.auditinfo = auditinfo ;
        this.modify("auditinfo",auditinfo);
    }

    /**
     * 设置 [AUDITTYPE]
     */
    public void setAudittype(String  audittype){
        this.audittype = audittype ;
        this.modify("audittype",audittype);
    }

    /**
     * 设置 [DATAAUDITNAME]
     */
    public void setDataauditname(String  dataauditname){
        this.dataauditname = dataauditname ;
        this.modify("dataauditname",dataauditname);
    }

    /**
     * 设置 [OBJECTID]
     */
    public void setObjectid(String  objectid){
        this.objectid = objectid ;
        this.modify("objectid",objectid);
    }

    /**
     * 设置 [OPPERSONNAME]
     */
    public void setOppersonname(String  oppersonname){
        this.oppersonname = oppersonname ;
        this.modify("oppersonname",oppersonname);
    }

    /**
     * 设置 [OPPERSONID]
     */
    public void setOppersonid(String  oppersonid){
        this.oppersonid = oppersonid ;
        this.modify("oppersonid",oppersonid);
    }

    /**
     * 设置 [IPADDRESS]
     */
    public void setIpaddress(String  ipaddress){
        this.ipaddress = ipaddress ;
        this.modify("ipaddress",ipaddress);
    }

    /**
     * 设置 [SESSIONID]
     */
    public void setSessionid(String  sessionid){
        this.sessionid = sessionid ;
        this.modify("sessionid",sessionid);
    }


}

