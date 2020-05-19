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
 * 服务DTO对象[ServiceRTDTO]
 */
@Data
public class ServiceRTDTO extends DTOBase implements Serializable {

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
     * 属性 [UPDATEMAN]
     *
     */
    @JSONField(name = "updateman")
    @JsonProperty("updateman")
    private String updateman;

    /**
     * 属性 [STARTMODE]
     *
     */
    @JSONField(name = "startmode")
    @JsonProperty("startmode")
    private String startmode;

    /**
     * 属性 [SERVICENAME]
     *
     */
    @JSONField(name = "servicename")
    @JsonProperty("servicename")
    private String servicename;

    /**
     * 属性 [CREATEMAN]
     *
     */
    @JSONField(name = "createman")
    @JsonProperty("createman")
    private String createman;

    /**
     * 属性 [SERVICEOBJECT]
     *
     */
    @JSONField(name = "serviceobject")
    @JsonProperty("serviceobject")
    private String serviceobject;

    /**
     * 属性 [SERVICESTATE]
     *
     */
    @JSONField(name = "servicestate")
    @JsonProperty("servicestate")
    private String servicestate;

    /**
     * 属性 [RUNORDER]
     *
     */
    @JSONField(name = "runorder")
    @JsonProperty("runorder")
    private Integer runorder;

    /**
     * 属性 [SERVICEID]
     *
     */
    @JSONField(name = "serviceid")
    @JsonProperty("serviceid")
    private String serviceid;

    /**
     * 属性 [CONTAINER]
     *
     */
    @JSONField(name = "container")
    @JsonProperty("container")
    private String container;

    /**
     * 属性 [MEMO]
     *
     */
    @JSONField(name = "memo")
    @JsonProperty("memo")
    private String memo;

    /**
     * 属性 [SERVICEPARAM]
     *
     */
    @JSONField(name = "serviceparam")
    @JsonProperty("serviceparam")
    private String serviceparam;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [ERRORINFO]
     *
     */
    @JSONField(name = "errorinfo")
    @JsonProperty("errorinfo")
    private String errorinfo;

    /**
     * 属性 [RESERVER]
     *
     */
    @JSONField(name = "reserver")
    @JsonProperty("reserver")
    private String reserver;


    /**
     * 设置 [STARTMODE]
     */
    public void setStartmode(String  startmode){
        this.startmode = startmode ;
        this.modify("startmode",startmode);
    }

    /**
     * 设置 [SERVICENAME]
     */
    public void setServicename(String  servicename){
        this.servicename = servicename ;
        this.modify("servicename",servicename);
    }

    /**
     * 设置 [SERVICEOBJECT]
     */
    public void setServiceobject(String  serviceobject){
        this.serviceobject = serviceobject ;
        this.modify("serviceobject",serviceobject);
    }

    /**
     * 设置 [SERVICESTATE]
     */
    public void setServicestate(String  servicestate){
        this.servicestate = servicestate ;
        this.modify("servicestate",servicestate);
    }

    /**
     * 设置 [RUNORDER]
     */
    public void setRunorder(Integer  runorder){
        this.runorder = runorder ;
        this.modify("runorder",runorder);
    }

    /**
     * 设置 [CONTAINER]
     */
    public void setContainer(String  container){
        this.container = container ;
        this.modify("container",container);
    }

    /**
     * 设置 [MEMO]
     */
    public void setMemo(String  memo){
        this.memo = memo ;
        this.modify("memo",memo);
    }

    /**
     * 设置 [SERVICEPARAM]
     */
    public void setServiceparam(String  serviceparam){
        this.serviceparam = serviceparam ;
        this.modify("serviceparam",serviceparam);
    }

    /**
     * 设置 [ERRORINFO]
     */
    public void setErrorinfo(String  errorinfo){
        this.errorinfo = errorinfo ;
        this.modify("errorinfo",errorinfo);
    }

    /**
     * 设置 [RESERVER]
     */
    public void setReserver(String  reserver){
        this.reserver = reserver ;
        this.modify("reserver",reserver);
    }


}

