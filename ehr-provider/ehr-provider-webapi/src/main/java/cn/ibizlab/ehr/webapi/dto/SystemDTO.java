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
 * 服务DTO对象[SystemDTO]
 */
@Data
public class SystemDTO extends DTOBase implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 属性 [AURLOGINADDR]
     *
     */
    @JSONField(name = "aurloginaddr")
    @JsonProperty("aurloginaddr")
    private String aurloginaddr;

    /**
     * 属性 [SYSTEMNAME]
     *
     */
    @JSONField(name = "systemname")
    @JsonProperty("systemname")
    private String systemname;

    /**
     * 属性 [SYSTEMTYPE]
     *
     */
    @JSONField(name = "systemtype")
    @JsonProperty("systemtype")
    private String systemtype;

    /**
     * 属性 [SYSTEMFUN]
     *
     */
    @JSONField(name = "systemfun")
    @JsonProperty("systemfun")
    private Integer systemfun;

    /**
     * 属性 [SYSTEMADDR]
     *
     */
    @JSONField(name = "systemaddr")
    @JsonProperty("systemaddr")
    private String systemaddr;

    /**
     * 属性 [BIGICON]
     *
     */
    @JSONField(name = "bigicon")
    @JsonProperty("bigicon")
    private String bigicon;

    /**
     * 属性 [SYSTEMID]
     *
     */
    @JSONField(name = "systemid")
    @JsonProperty("systemid")
    private String systemid;

    /**
     * 属性 [SERVICE]
     *
     */
    @JSONField(name = "service")
    @JsonProperty("service")
    private String service;

    /**
     * 属性 [SYSTEMPARAM]
     *
     */
    @JSONField(name = "systemparam")
    @JsonProperty("systemparam")
    private String systemparam;

    /**
     * 属性 [UPDATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "updatedate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updatedate")
    private Timestamp updatedate;

    /**
     * 属性 [CREATEDATE]
     *
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    @JSONField(name = "createdate" , format="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("createdate")
    private Timestamp createdate;

    /**
     * 属性 [FUNLIC]
     *
     */
    @JSONField(name = "funlic")
    @JsonProperty("funlic")
    private String funlic;

    /**
     * 属性 [AURLOGOUTADDR]
     *
     */
    @JSONField(name = "aurlogoutaddr")
    @JsonProperty("aurlogoutaddr")
    private String aurlogoutaddr;

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
     * 设置 [AURLOGINADDR]
     */
    public void setAurloginaddr(String  aurloginaddr){
        this.aurloginaddr = aurloginaddr ;
        this.modify("aurloginaddr",aurloginaddr);
    }

    /**
     * 设置 [SYSTEMNAME]
     */
    public void setSystemname(String  systemname){
        this.systemname = systemname ;
        this.modify("systemname",systemname);
    }

    /**
     * 设置 [SYSTEMTYPE]
     */
    public void setSystemtype(String  systemtype){
        this.systemtype = systemtype ;
        this.modify("systemtype",systemtype);
    }

    /**
     * 设置 [SYSTEMFUN]
     */
    public void setSystemfun(Integer  systemfun){
        this.systemfun = systemfun ;
        this.modify("systemfun",systemfun);
    }

    /**
     * 设置 [SYSTEMADDR]
     */
    public void setSystemaddr(String  systemaddr){
        this.systemaddr = systemaddr ;
        this.modify("systemaddr",systemaddr);
    }

    /**
     * 设置 [BIGICON]
     */
    public void setBigicon(String  bigicon){
        this.bigicon = bigicon ;
        this.modify("bigicon",bigicon);
    }

    /**
     * 设置 [SERVICE]
     */
    public void setService(String  service){
        this.service = service ;
        this.modify("service",service);
    }

    /**
     * 设置 [SYSTEMPARAM]
     */
    public void setSystemparam(String  systemparam){
        this.systemparam = systemparam ;
        this.modify("systemparam",systemparam);
    }

    /**
     * 设置 [FUNLIC]
     */
    public void setFunlic(String  funlic){
        this.funlic = funlic ;
        this.modify("funlic",funlic);
    }

    /**
     * 设置 [AURLOGOUTADDR]
     */
    public void setAurlogoutaddr(String  aurlogoutaddr){
        this.aurlogoutaddr = aurlogoutaddr ;
        this.modify("aurlogoutaddr",aurlogoutaddr);
    }


}

